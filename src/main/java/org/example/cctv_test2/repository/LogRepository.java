package org.example.cctv_test2.repository;

import org.example.cctv_test2.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<LogEntity, Long> {

    // CCTV 번호로 가장 최신 로그를 가져오는 메서드
    LogEntity findTopByCctvNumOrderByLogTimeDesc(String cctvNum);

}
