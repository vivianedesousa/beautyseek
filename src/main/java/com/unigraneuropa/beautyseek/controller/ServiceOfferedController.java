package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.ServiceOfferedService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Service")
public class ServiceOfferedController {
    public ServiceOfferedController(ServiceOfferedService serviceOfferedService) {
    }
    @GetMapping("/list")
    public void listServiceOffered(){
    }
    @GetMapping("/list/{id}")
    public void getServiceOffered(int id){
    }
    @GetMapping("/new")
    public void newServiceOffered(){

    }
    @PostMapping("/save")
    public void saveServiceOffered(){

    }
    @GetMapping("/edit/{id}")
    public void editServiceOffered(int id){
    }
    @PostMapping("/update/{id}")
    public void updateServiceOffered(){
    }
    @GetMapping("/delete/{id}")
    public void deleteServiceOffered() {

    }
}
