package org.example.cctv_test2.Controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Controller
//@RequestMapping("/api")
//class ImageController {
//
//    private static final Logger log = LoggerFactory.getLogger(ImageController.class);
//
//    // HashMap을 사용한 메모리 DB
//    private final Map<Long, String> imageDatabase = new ConcurrentHashMap<>();
//    private long currentId = 0;
//
//    @PostMapping("/upload")
//    @ResponseBody // 이 어노테이션을 추가하여 문자열을 직접 반환
//    public String uploadImage(@RequestBody String base64Image) {
//        // 새로운 이미지 저장
//        imageDatabase.put(++currentId, base64Image);
//
//        // 로그 남기기
//        log.info("이미지 업로드 성공: ID = {}", currentId);
//
//        return "success"; // 성공 메시지
//    }
//
//    @GetMapping("/images")
//    @ResponseBody
//    public List<String> getImages() {
//        // 이미지 리스트 반환
//        return new ArrayList<>(imageDatabase.values());
//    }
//
//    @GetMapping("/index")
//    public String index() {
//        return "index"; // HTML 파일 이름
//    }
//}

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
class ImageController {

    private static final Logger log = LoggerFactory.getLogger(ImageController.class);

    // 최대 7개의 CCTV 프레임을 위한 HashMap
    private final Map<String, String> cctvFrames = new HashMap<>();

    // CCTV 번호 목록
    private final String[] cctvNumbers = {"CCTV-001", "CCTV-002", "CCTV-003", "CCTV-004", "CCTV-005", "CCTV-006", "CCTV-007","Map"};

    @PostMapping("/upload")
    @ResponseBody
    public String uploadImage(@RequestBody Map<String, Object> payload) {
        String imageData = (String) payload.get("imageData");
        String cctvNum = (String) payload.get("cctvNum");

        // CCTV 번호 유효성 검사
        if (!isValidCctvNum(cctvNum)) {
            log.error("유효하지 않은 CCTV 번호: {}", cctvNum);
            return "{\"status\":\"error\", \"message\":\"유효하지 않은 CCTV 번호입니다.\"}";
        }

        // CCTV 번호에 해당하는 이미지 저장
        cctvFrames.put(cctvNum, imageData);

        // 로그 남기기
        log.info("CCTV 번호: {}, 이미지 업로드 성공", cctvNum);

        return "{\"status\":\"success\"}"; // 성공 메시지
    }

    @GetMapping("/images")
    @ResponseBody
    public Map<String, String> getImages() {
        // 현재 저장된 모든 CCTV 이미지 반환
        return cctvFrames;
    }

    private boolean isValidCctvNum(String cctvNum) {
        for (String num : cctvNumbers) {
            if (num.equals(cctvNum)) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/index")
    public String index() {
        return "index"; // HTML 파일 이름
    }
}
