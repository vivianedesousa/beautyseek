package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.AvailableDayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/AvailableDay")
public class AvailableDayController {
    private final AvailableDayService availableDayService;

    public AvailableDayController(AvailableDayService availableDayService) {
        this.availableDayService = availableDayService;
    }

    @GetMapping("")
    public void listAvailableDay(){
    }
}
