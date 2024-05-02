package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.AvailableTimeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/AvailableTime")
public class AvailableTimeController {
    private final AvailableTimeService availableTimeService;

    public AvailableTimeController(AvailableTimeService availableTimeService) {
        this.availableTimeService = availableTimeService;
    }
    @GetMapping("/list")
    public void listAvailableTime(){
    }
    @GetMapping("/list/{id}")
    public void getAvailableTime(int id){
    }
    @GetMapping("/new")
    public void newAvailableTime(){

    }
    @PostMapping("/save")
    public void saveClient(){

    }
    @GetMapping("/edit/{id}")
    public void editAvailableTime(int id){
    }

    @PostMapping("/update/{id}")
    public void updateAvailableTime(){
    }

    @GetMapping("/delete/{id}")
    public void deleteAvailableTime() {

    }
}
