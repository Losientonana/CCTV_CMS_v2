package org.example.cctv_cms.Service;

import org.example.cctv_cms.DTO.CCTVDataDTO;
import org.example.cctv_cms.Data.CCTVData;
import org.example.cctv_cms.Repository.CCTVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CCTVService {
    private final CCTVRepository cctvRepository;

    public CCTVService(CCTVRepository cctvRepository) {
        this.cctvRepository = cctvRepository;
    }


    public void updateCCTVData(CCTVDataDTO cctvDataDTO) {
        CCTVData existingData = cctvRepository.findByCctvNum(cctvDataDTO.getCctvNum());
        CCTVData cctvData = new CCTVData();
        // DTO를 엔티티로 변환
        cctvData.setId(cctvDataDTO.getId());
        cctvData.setCctvNum(cctvDataDTO.getCctvNum());
        cctvData.setDetectedObjects(cctvDataDTO.getDetectedObjects());
        cctvData.setTime(cctvDataDTO.getTime());
        cctvData.setImageData(cctvDataDTO.getImageData());

        if (existingData != null) {
            // 기존 데이터 업데이트
            cctvRepository.save(cctvData);
        } else {
            // 새로운 데이터 저장
            cctvRepository.save(cctvData);
        }
    }

    public List<CCTVDataDTO> getAllCCTVData() {
        return cctvRepository.findAll().stream()
                .map(data -> new CCTVDataDTO(data.getId(), data.getCctvNum(), data.getDetectedObjects(), data.getTime(), data.getImageData()))
                .collect(Collectors.toList());
    }
}
