package org.example.cctv_test2.service;

import org.example.cctv_test2.dto.LogDTO;
import org.example.cctv_test2.entity.CctvImageEntity;
import org.example.cctv_test2.entity.LogEntity;
import org.example.cctv_test2.repository.CctvImageRepository;
import org.example.cctv_test2.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//
//@Service
//public class LogService {
//    private final LogRepository logRepository;
//
//    public LogService(LogRepository logRepository) {
//        this.logRepository = logRepository;
//    }
//    public void saveLog(LogDTO logDTO) {
//        LogEntity logEntity = new LogEntity();
//        logEntity.setCctvNum(logDTO.getCctvNum());
//        logEntity.setDetectedObjects(logDTO.getDetectedObjects());
//        logEntity.setLogTime(logDTO.getLogTime());
//        logRepository.save(logEntity);
//    }
//
//    public List<LogDTO> getAllLogs() {
//        return logRepository.findAll().stream().map(log -> {
//            LogDTO dto = new LogDTO();
//            dto.setId(log.getId());
//            dto.setCctvNum(log.getCctvNum());
//            dto.setDetectedObjects(log.getDetectedObjects());
//            dto.setLogTime(log.getLogTime());
//            dto.setImageData(imageData); // 이미지 데이터 설정
//
//            return dto;
//        }).collect(Collectors.toList());
//    }
//@Service
//public class LogService {
//    private final LogRepository logRepository;
//    private final CctvImageRepository cctvImageRepository; // 이미지 리포지토리 주입
//
//    public LogService(LogRepository logRepository, CctvImageRepository cctvImageRepository) {
//        this.logRepository = logRepository;
//        this.cctvImageRepository = cctvImageRepository;
//    }
//
//    public void saveLog(LogDTO logDTO) {
//        LogEntity logEntity = new LogEntity();
//        logEntity.setCctvNum(logDTO.getCctvNum());
//        logEntity.setDetectedObjects(logDTO.getDetectedObjects());
//        logEntity.setLogTime(logDTO.getLogTime());
//        logRepository.save(logEntity);
//    }
//
//    public List<LogDTO> getAllLogs() {
//        return logRepository.findAll().stream().map(log -> {
//            LogDTO dto = new LogDTO();
//            dto.setId(log.getId());
//            dto.setCctvNum(log.getCctvNum());
//            dto.setDetectedObjects(log.getDetectedObjects());
//            dto.setLogTime(log.getLogTime());
//
//            // CCTV 번호로 이미지 데이터 검색
//            CctvImageEntity imageEntity = cctvImageRepository.findByCctvNum(log.getCctvNum());
//            if (imageEntity != null) {
//                dto.setImageData(imageEntity.getImageData());
//            }
//
//            return dto;
//        }).collect(Collectors.toList());
//    }
//}


import org.example.cctv_test2.dto.LogDTO;
import org.example.cctv_test2.entity.LogEntity;
import org.example.cctv_test2.repository.LogRepository;
import org.example.cctv_test2.repository.CctvImageRepository;
import org.example.cctv_test2.entity.CctvImageEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogService {

    private final LogRepository logRepository;
    private final CctvImageRepository cctvImageRepository; // 이미지 리포지토리 주입

    public LogService(LogRepository logRepository, CctvImageRepository cctvImageRepository) {
        this.logRepository = logRepository;
        this.cctvImageRepository = cctvImageRepository;
    }

    // 로그 저장
    public void saveLog(LogDTO logDTO) {
        LogEntity logEntity = new LogEntity();
        logEntity.setCctvNum(logDTO.getCctvNum());
        logEntity.setDetectedObjects(logDTO.getDetectedObjects());
        logEntity.setLogTime(logDTO.getLogTime());
        logRepository.save(logEntity);
    }

    // 모든 로그 조회 (CCTV 번호에 맞는 이미지 포함)
    public List<LogDTO> getAllLogs() {
        return logRepository.findAll().stream().map(log -> {
            LogDTO dto = new LogDTO();
            dto.setId(log.getId());
            dto.setCctvNum(log.getCctvNum());
            dto.setDetectedObjects(log.getDetectedObjects());
            dto.setLogTime(log.getLogTime());
            return dto;
        }).collect(Collectors.toList());
    }
}

