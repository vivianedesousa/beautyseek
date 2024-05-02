package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.SocialMediaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SocialMedia")

public class SocialMediaController {
    private final SocialMediaService  socialMediaService ;

    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }
    @GetMapping("/list")
    public void listSocialMedia(){

    }
    @GetMapping("/list/{id}")
    public void getSocialMedia(int id){
    }
    @GetMapping("/new")
    public void newSocialMedia(){

    }
    @PostMapping("/save")
    public void saveSocialMedia(){
    }
    @GetMapping("/edit/{id}")
    public void editSocialMedia(int id){

    }
    @PostMapping("/update/{id}")
    public void updateSocialMedia(){

    }
    @GetMapping("/delete/{id}")
    public void deleteSocialMedia(){

    }
}
