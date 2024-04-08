package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/Schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // aqui vamos  mapear as rotas htpp que cliente vai digita  na interface
    @GetMapping("")
    public void listSchedule(){
    }
}
