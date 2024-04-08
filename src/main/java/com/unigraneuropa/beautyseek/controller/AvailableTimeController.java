package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.AvailableTimeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/AvailableTime")
public class AvailableTimeController {
    private final AvailableTimeService availableTimeService;

    public AvailableTimeController(AvailableTimeService availableTimeService) {
        this.availableTimeService = availableTimeService;
    }
    @GetMapping("")
    public void listAvailableTime(){
    }
}
