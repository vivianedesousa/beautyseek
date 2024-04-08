package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.EntrepreneurService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Entrepreneur")
public class EntrepreneurController {
    private final EntrepreneurService entrepreneurService;

    public EntrepreneurController(EntrepreneurService entrepreneurService) {
        this.entrepreneurService = entrepreneurService;
    }
    @GetMapping("")
    public void listEntrepreneur(){
    }
}
