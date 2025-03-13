package com.sjh.memories_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjh.memories_back.common.entity.ConcentrationTestEntity;
import com.sjh.memories_back.common.entity.pk.ConcentrationTestPk;

@Repository
public interface ConcentrationTestRepository extends JpaRepository<ConcentrationTestEntity, ConcentrationTestPk> {
  
}
