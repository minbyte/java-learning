package com.mindasoft.boot.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;

/**
 * @author: min
 * @date: 2019/4/8 10:34
 * @version: 1.0.0
 */
@RestController
@RequestMapping("/test")
public class TestContoller {

    @GetMapping("/hi1")
    public String hi(String name, HttpServletRequest request){
        Enumeration<String> set =  request.getParameterNames();
        return "hi,"+ name;
    }

    @GetMapping("/hi2")
    public String hello(@RequestParam String name, HttpServletRequest request){
        Enumeration<String> set =  request.getParameterNames();
        return "HelloWorld,"+ name;
    }

    @GetMapping("/pay1")
    public String pay1(PayParam payParam, HttpServletRequest request){
        Enumeration<String> set =  request.getParameterNames();
        return "支付金额:" + payParam.getAmount();
    }

    @GetMapping("/pay2")
    public String pay(@RequestParam PayParam payParam, HttpServletRequest request){
        Enumeration<String> set =  request.getParameterNames();
        return "支付金额:" + payParam.getAmount();
    }

    @PostMapping("/pay3")
    public String pay3(@RequestBody PayParam payParam, HttpServletRequest request){
        Enumeration<String> set =  request.getParameterNames();
        return "支付金额:" + payParam.getAmount();
    }

    @PostMapping("/pay4")
    public String pay4(PayParam payParam, HttpServletRequest request){
        Enumeration<String> set =  request.getParameterNames();
        return "支付金额:" + payParam.getAmount();
    }

    @PostMapping("/pay5")
    public String pay5(@RequestParam PayParam payParam, HttpServletRequest request){
        Enumeration<String> set =  request.getParameterNames();
        return "支付金额:" + payParam.getAmount();
    }
}
