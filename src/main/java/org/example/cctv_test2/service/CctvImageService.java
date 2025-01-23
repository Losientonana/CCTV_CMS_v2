package org.example.cctv_test2.service;

import org.example.cctv_test2.dto.CctvImageDTO;
import org.example.cctv_test2.entity.CctvImageEntity;
import org.example.cctv_test2.repository.CctvImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CctvImageService {

    private final CctvImageRepository cctvImageRepository;

    public CctvImageService(CctvImageRepository cctvImageRepository) {
        this.cctvImageRepository = cctvImageRepository;
    }
    public void saveImage(CctvImageDTO cctvImageDTO) {
        CctvImageEntity cctvImageEntity = new CctvImageEntity();
        cctvImageEntity.setCctvNum(cctvImageDTO.getCctvNum());
        cctvImageEntity.setImageData(cctvImageDTO.getImageData());
        cctvImageRepository.save(cctvImageEntity);
    }

    public List<CctvImageDTO> getAllImages() {
        return cctvImageRepository.findAll().stream().map(image -> {
            CctvImageDTO dto = new CctvImageDTO();
            dto.setCctvNum(image.getCctvNum());
            dto.setImageData(image.getImageData());
            return dto;
        }).collect(Collectors.toList());
    }

}
