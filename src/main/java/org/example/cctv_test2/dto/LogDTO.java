package org.example.cctv_test2.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LogDTO {
    private Long id;
    private String cctvNum;
    private String detectedObjects;
    private LocalDateTime logTime;

    public LogDTO() {

    }
    public LogDTO(String cctvNum, String detectedObjects, LocalDateTime logTime) {
        this.cctvNum = cctvNum;
        this.detectedObjects = detectedObjects;
        this.logTime = logTime;
    }
}
