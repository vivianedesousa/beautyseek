package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.AvailableDayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/AvailableDay")
public class AvailableDayController {
    private final AvailableDayService availableDayService;

    public AvailableDayController(AvailableDayService availableDayService) {
        this.availableDayService = availableDayService;
    }

    @GetMapping("/list")
    public void listAvailableDay(){
    }
    @GetMapping("/list/{id}")
    public void getAvailableDay(int id){
    }
    @GetMapping("/new")
    public void newAvailableDay(){

    }
    @PostMapping("/save")
    public void saveAvailableDay(){

    }
    @GetMapping("/edit/{id}")
    public void editAvailableDay(int id){
    }

    @PostMapping("/update/{id}")
    public void updateAvailableDay(){
    }

    @GetMapping("/delete/{id}")
    public void deleteAvailableDay() {

    }
}
