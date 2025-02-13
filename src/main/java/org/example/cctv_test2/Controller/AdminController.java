//package com.example.springjwt.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@ResponseBody
//public class AdminController {
//
//    @GetMapping("/admin")
//    public String adminP() {
//
//        return "Admin Controller";
//    }
//}
package org.example.cctv_test2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class AdminController {

    @GetMapping("/admin")
    public String adminP() {
        return "Admin Controller - Access granted!";
    }
}
