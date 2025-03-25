package com.sjh.memories_back.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sjh.memories_back.service.FileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

  private final FileService fileService;
  
  @PostMapping("/upload")
  public String upload(
    @RequestParam("file") MultipartFile file
  ) {
    String url = fileService.upload(file);
    return url;
  }

}
