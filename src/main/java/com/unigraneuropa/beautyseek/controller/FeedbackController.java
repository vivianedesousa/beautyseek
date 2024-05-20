package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Client;
import com.unigraneuropa.beautyseek.model.Feedback;
import com.unigraneuropa.beautyseek.service.ClientService;
import com.unigraneuropa.beautyseek.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

@Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
    @GetMapping
    public String listFeedbacks(Model model) {
        model.addAttribute("Feedbacks",feedbackService.getAllFeedbacks());
        return "Feedbacks/list"; // Nome do template Thymeleaf para listar endereços
    }

    @GetMapping("/new")
    public String newFeedbackFom(Model model) {
        model.addAttribute("Feedbacks", new Feedback());
        return "AvailableTimes/new"; // Formulário Thymeleaf para novo endereço
    }

    @PostMapping
    public String createFeedback(@ModelAttribute Feedback feedback) {
        feedbackService.createFeedback(feedback);
        return "redirect:/Clients"; // Redireciona para a lista de endereços após a criação
    }

    //https://beautyseek.com/addresses/edit/999
    @GetMapping("/edit/{id}")
    public String editFeedbackForm(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute(" feedback", feedbackService.getFeedbackById(id));
            return "feedbacks/edit"; // Formulário Thymeleaf para editar endereço
        } catch (RegisterNotFoundException e) {
            return "redirect:/feedback"; // Redireciona para a lista se o endereço não for encontrado
        }
    }

    @PostMapping("/update/{id}")
    public String updateFeedback(@PathVariable Integer id, @ModelAttribute Feedback feedback) {
        try {
            feedbackService.updateFeedback(id,feedback);
            return "redirect:/Feedbacks"; // Redireciona para a lista de endereços após a atualização
        } catch (RegisterNotFoundException e) {
            return "redirect:/Feedbacks"; // Redireciona para a lista se o endereço não puder ser atualizado
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteFeedback(@PathVariable Integer id) {
        if (feedbackService.deleteFeedback(id)) {
            return "redirect:/feedbacks"; // Redireciona para a lista após a exclusão
        } else {
            return "redirect:/feedbacks"; // Redireciona para a lista se o endereço não puder ser excluído
        }
    }

}