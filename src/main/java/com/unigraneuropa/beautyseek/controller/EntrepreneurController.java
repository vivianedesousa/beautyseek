package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.EntrepreneurService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Entrepreneur")
public class EntrepreneurController {
    private final EntrepreneurService entrepreneurService;

    public EntrepreneurController(EntrepreneurService entrepreneurService) {
        this.entrepreneurService = entrepreneurService;
    }
    @GetMapping("/list")
    public void listEntrepreneur(){
    }
    @GetMapping("/list/{id}")
    public void getEntrepreneur(int id){
    }
    @GetMapping("/new")
    public void newEntrepreneur(){

    }
    @PostMapping("/save")
    public void saveEntrepreneur(){

    }
    @GetMapping("/edit/{id}")
    public void editEntrepreneur(int id){
    }

    @PostMapping("/update/{id}")
    public void updateEntrepreneur(){
    }

    @GetMapping("/delete/{id}")
    public void deleteEntrepreneur() {

    }
}
