package org.example.cctv_cms.Data;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CCTVData {
    private String id;
    private String cctvNum;
    private String detectedObjects;
    private String time;
    private String imageData; // 이미지 데이터

}
