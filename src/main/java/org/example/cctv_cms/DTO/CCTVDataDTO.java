package org.example.cctv_cms.DTO;

import lombok.Data;

@Data
public class CCTVDataDTO {
    private String id; // 데이터 ID
    private String cctvNum; // CCTV 번호
    private String detectedObjects; // 감지된 객체
    private String time; // 시간
    private String imageData; // 이미지 데이터

    // 생성자
    public CCTVDataDTO(String id, String cctvNum, String detectedObjects, String time, String imageData) {
        this.id = id;
        this.cctvNum = cctvNum;
        this.detectedObjects = detectedObjects;
        this.time = time;
        this.imageData = imageData;
    }

    // Getter
    public String getId() { return id; }
    public String getCctvNum() { return cctvNum; }
    public String getDetectedObjects() { return detectedObjects; }
    public String getTime() { return time; }
    public String getImageData() { return imageData; }
}
