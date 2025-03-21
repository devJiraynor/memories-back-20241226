package com.sjh.memories_back.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sjh.memories_back.common.dto.request.test.PostMemoryRequestDto;
import com.sjh.memories_back.common.dto.response.ResponseDto;
import com.sjh.memories_back.common.entity.MemoryTestEntity;
import com.sjh.memories_back.repository.MemoryTestRepository;
import com.sjh.memories_back.service.TestService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestServiceImplement implements TestService {

  private final MemoryTestRepository memoryTestRepository;

  @Override
  public ResponseEntity<ResponseDto> postMemory(PostMemoryRequestDto dto, String userId) {

    try {
      MemoryTestEntity memoryTestEntity = null;

      Integer preSequence = memoryTestRepository.countByUserId(userId);
      if (preSequence == 0) {
        memoryTestEntity = new MemoryTestEntity(dto, userId);
      } else {
        MemoryTestEntity preMemoryTestEntity = memoryTestRepository.findByUserIdAndSequence(userId, preSequence);
        memoryTestEntity = new MemoryTestEntity(dto, preMemoryTestEntity, userId);
      }

      memoryTestRepository.save(memoryTestEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.CREATED);

  }
  
}
