package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/Schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // aqui vamos  mapear as rotas htpp que cliente vai digita  na interface
    @GetMapping("/list")
    public void listSchedule(){
    }
    @GetMapping("/list/{id}")
    public void getSchedule(int id){
    }
    @GetMapping("/new")
    public void newSchedule(){

    }
    @PostMapping("/save")
    public void saveSchedule(){

    }
    @GetMapping("/edit/{id}")
    public void editSchedule(int id){
    }
    @PostMapping("/update/{id}")
    public void updateSchedule(){
    }
    @GetMapping("/delete/{id}")
    public void deleteSchedule() {

    }

}
