//package org.example.cctv_cms.Controller;
//
//import org.example.cctv_cms.DTO.CCTVDataDTO;
//import org.example.cctv_cms.Service.CCTVService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Controller
//@RequestMapping("/cctv")
//public class CCTVController {
//
//    private final CCTVService cctvService;
//
//    public CCTVController(CCTVService cctvService) {
//        this.cctvService = cctvService;
//    }
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadData(@RequestBody CCTVDataDTO cctvDataDTO) {
//        // 데이터 업데이트
//        cctvService.updateCCTVData(cctvDataDTO);
//
//
//        // 성공 메시지 반환
//        return new ResponseEntity<>("success", HttpStatus.OK);
//    }
//
//    @RequestMapping("/main")
//    public String showMainPage(Model model) {
//        model.addAttribute("cctvDataList", cctvService.getAllCCTVData());
//        return "main"; // main.html 파일을 반환
//    }
//}
//package org.example.cctv_cms.Controller;
//
//import org.example.cctv_cms.DTO.CCTVDataDTO;
//import org.example.cctv_cms.Data.CCTVData;
//import org.example.cctv_cms.Service.CCTVService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/cctv")
//public class CCTVController {
//
//    private final CCTVService cctvService;
//    private final Map<String, CCTVData> cctvDataMap = new HashMap<>(); // CCTV 데이터 저장
//
//    @Autowired
//    public CCTVController(CCTVService cctvService) {
//        this.cctvService = cctvService;
//
//        // CCTV 섹터 초기화 (미리 정의)
//        cctvDataMap.put("CCTV-001", new CCTVData());
//        cctvDataMap.put("CCTV-002", new CCTVData());
//        cctvDataMap.put("CCTV-003", new CCTVData());
//        cctvDataMap.put("CCTV-004", new CCTVData());
//        cctvDataMap.put("CCTV-005", new CCTVData());
//        cctvDataMap.put("CCTV-006", new CCTVData());
//        cctvDataMap.put("CCTV-007", new CCTVData());
//        cctvDataMap.put("Map", new CCTVData());
//    }
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadData(@RequestBody CCTVDataDTO cctvDataDTO) {
//        // CCTV 번호에 따라 이미지 데이터를 업데이트
//        CCTVData cctvData = cctvDataMap.get(cctvDataDTO.getCctvNum());
//        if (cctvData != null) {
//            cctvData.setImageData(cctvDataDTO.getImageData());
//            cctvData.setDetectedObjects(cctvDataDTO.getDetectedObjects());
//            cctvData.setTime(cctvDataDTO.getTime());
//            cctvData.setId(cctvDataDTO.getId());
//        }
//
//        // 성공 메시지 반환
//        return new ResponseEntity<>("success", HttpStatus.OK);
//    }
//
//    @RequestMapping("/main")
//    public String showMainPage(Model model) {
//        // CCTV 데이터를 List로 변환하여 모델에 추가
//        List<CCTVData> cctvDataList = new ArrayList<>(cctvDataMap.values());
//        model.addAttribute("cctvDataList", cctvDataList); // List를 모델에 추가
//        return "main"; // main.html 파일을 반환
//    }
//}
//
//package org.example.cctv_cms.Controller;
//
//import org.example.cctv_cms.DTO.CCTVDataDTO;
//import org.example.cctv_cms.Data.CCTVData;
//import org.example.cctv_cms.Service.CCTVService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/cctv")
//public class CCTVController {
//
//    private final CCTVService cctvService;
//    private final Map<String, CCTVData> cctvDataMap = new HashMap<>(); // CCTV 데이터 저장
//
//    @Autowired
//    public CCTVController(CCTVService cctvService) {
//        this.cctvService = cctvService;
//
//        // CCTV 섹터 초기화 (미리 정의)
//        cctvDataMap.put("CCTV-001", new CCTVData());
//        cctvDataMap.put("CCTV-002", new CCTVData());
//        cctvDataMap.put("CCTV-003", new CCTVData());
//        cctvDataMap.put("CCTV-004", new CCTVData());
//        cctvDataMap.put("CCTV-005", new CCTVData());
//        cctvDataMap.put("CCTV-006", new CCTVData());
//        cctvDataMap.put("CCTV-007", new CCTVData());
//        cctvDataMap.put("Map", new CCTVData());
//    }
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadData(@RequestBody CCTVDataDTO cctvDataDTO) {
//        // CCTV 번호에 따라 이미지 데이터를 업데이트
//        CCTVData cctvData = cctvDataMap.get(cctvDataDTO.getCctvNum());
//        if (cctvData != null) {
//            cctvData.setImageData(cctvDataDTO.getImageData());
//            cctvData.setDetectedObjects(cctvDataDTO.getDetectedObjects());
//            cctvData.setTime(cctvDataDTO.getTime());
//            cctvData.setId(cctvDataDTO.getId());
//        }
//
//        // 성공 메시지 반환
//        return new ResponseEntity<>("success", HttpStatus.OK);
//    }
//
//    @RequestMapping("/main")
//    public String showMainPage(Model model) {
//        // CCTV 데이터를 List로 변환하여 모델에 추가
//        List<CCTVData> cctvDataList = new ArrayList<>(cctvDataMap.values());
//        model.addAttribute("cctvDataList", cctvDataList); // List를 모델에 추가
//        return "main"; // main.html 파일을 반환
//    }
//}

package org.example.cctv_cms.Controller;

import org.example.cctv_cms.DTO.CCTVDataDTO;
import org.example.cctv_cms.Data.CCTVData;
import org.example.cctv_cms.Service.CCTVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cctv")
public class CCTVController {

    private final CCTVService cctvService;
    private final Map<String, CCTVData> cctvDataMap = new HashMap<>(); // CCTV 데이터 저장

    @Autowired
    public CCTVController(CCTVService cctvService) {
        this.cctvService = cctvService;

        // CCTV 섹터 초기화 (미리 정의)
        cctvDataMap.put("CCTV-001", new CCTVData());
        cctvDataMap.put("CCTV-002", new CCTVData());
        cctvDataMap.put("CCTV-003", new CCTVData());
        cctvDataMap.put("CCTV-004", new CCTVData());
        cctvDataMap.put("CCTV-005", new CCTVData());
        cctvDataMap.put("CCTV-006", new CCTVData());
        cctvDataMap.put("CCTV-007", new CCTVData());
        cctvDataMap.put("Map", new CCTVData());
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadData(@RequestBody CCTVDataDTO cctvDataDTO) {
        // CCTV 번호에 따라 이미지 데이터를 업데이트
        CCTVData cctvData = cctvDataMap.get(cctvDataDTO.getCctvNum());
        if (cctvData != null) {
            cctvData.setImageData(cctvDataDTO.getImageData());
            cctvData.setDetectedObjects(cctvDataDTO.getDetectedObjects());
            cctvData.setTime(cctvDataDTO.getTime());
            cctvData.setId(cctvDataDTO.getId());
        }

        // 성공 메시지 반환
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @RequestMapping("/main")
    public String showMainPage(Model model) {
        model.addAttribute("cctvDataList", cctvDataMap); // CCTV 데이터를 모델에 추가
        return "main"; // main.html 파일을 반환
    }
}
