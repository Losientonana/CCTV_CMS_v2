package org.example.cctv_test2.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.cctv_test2.service.CctvImageService;

@Getter
@Setter
public class CctvImageDTO {
    private String cctvNum;
    private String imageData;

    public CctvImageDTO() {
    }

    public CctvImageDTO(String cctvNum, String imageData) {
        this.cctvNum = cctvNum;
        this.imageData = imageData;
    }
}
