package com.unigraneuropa.beautyseek.controller;

import com.unigraneuropa.beautyseek.service.ServiceOfferedService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Service")
public class ServiceOfferedController {
    private final ServiceOfferedService serviceOfferedService ;
    public ServiceOfferedController(ServiceOfferedService serviceOfferedService) {
        this.serviceOfferedService = serviceOfferedService;
    }
    @GetMapping("")
    public void listServiceOffered(){

    }
}
