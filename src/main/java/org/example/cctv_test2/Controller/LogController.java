package org.example.cctv_test2.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class LogController {

    @GetMapping("/log")
    public String log() {
        return "log";
    }
}
