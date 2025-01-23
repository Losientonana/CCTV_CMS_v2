package org.example.cctv_test2.Controller;


import org.example.cctv_test2.dto.LogDTO;
import org.example.cctv_test2.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api")
public class LogController {
    private final LogService logService;
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/log")
    public String log() {
        return "log"; // 로그 페이지 HTML 파일 이름
    }

    @PostMapping("/log")
    @ResponseBody
    public void saveLog(@RequestBody LogDTO logDTO) {
        logService.saveLog(logDTO);
    }

    @GetMapping("/logs")
    @ResponseBody
    public List<LogDTO> getLogs() {
        return logService.getAllLogs();
    }
}
