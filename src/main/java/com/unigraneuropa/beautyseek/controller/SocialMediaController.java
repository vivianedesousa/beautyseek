package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.SocialMediaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SocialMedia")

public class SocialMediaController {
    private final SocialMediaService  socialMediaService ;

    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @GetMapping("")
    public void listSocialMedia(){

    }
}
