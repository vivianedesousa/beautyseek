package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
    @GetMapping("/list")
    public void listFeedback(){

    }
    @GetMapping("/list/{id}")
    public void getFeedback(int id){
    }
    @GetMapping("/new")
    public void newFeedback(){

    }
    @PostMapping("/save")
    public void saveFeedback (){

    }
    @GetMapping("/edit/{id}")
    public void editFeedback(int id){
    }

    @PostMapping("/update/{id}")
    public void updateFeedback(){
    }

    @GetMapping("/delete/{id}")
    public void deleteFeedback() {

    }
}