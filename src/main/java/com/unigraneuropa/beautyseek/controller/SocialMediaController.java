package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Address;
import com.unigraneuropa.beautyseek.model.SocialMedia;
import com.unigraneuropa.beautyseek.service.SocialMediaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/SocialMedias")

public class SocialMediaController {
    private final SocialMediaService  socialMediaService ;

    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @GetMapping
    public String listSocialMedias(Model model) {
        model.addAttribute("socialMedias",socialMediaService.getAllSocialMedias());
        return "addresses/list"; // Nome do template Thymeleaf para listar endereços
    }

    @GetMapping("/new")
    public String newSocialMediaForm(Model model) {
        model.addAttribute("SocialMedia", new SocialMedia());
        return "SocialMedias/new"; // Formulário Thymeleaf para novo endereço
    }

    @PostMapping
    public String createSocialMedia(@ModelAttribute SocialMedia socialMedia) {
        socialMediaService.createSocialMedia(socialMedia);
        return "redirect:/addresses"; // Redireciona para a lista de endereços após a criação
    }


    @GetMapping("/edit/{id}")
    public String editSocialMediaForm(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute("socialMedia", socialMediaService.getSocialMediaById(id));
            return "socialMedias/edit"; // Formulário Thymeleaf para editar endereço
        } catch (RegisterNotFoundException e) {
            return "redirect:/socialMedias"; // Redireciona para a lista se o endereço não for encontrado
        }
    }

    @PostMapping("/update/{id}")
    public String updateSocialMedia(@PathVariable Integer id, @ModelAttribute SocialMedia socialMedia) {
        try {
            socialMediaService.updateSocialMedia(id, socialMedia);
            return "redirect:/socialMedias"; // Redireciona para a lista de endereços após a atualização
        } catch (RegisterNotFoundException e) {
            return "redirect:/socialMedias"; // Redireciona para a lista se o endereço não puder ser atualizado
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteSocialMedia(@PathVariable Integer id) {
        if (socialMediaService.deleteSocialMedia(id)) {
            return "redirect:/ socialMedias"; // Redireciona para a lista após a exclusão
        } else {
            return "redirect:/socialMedias"; // Redireciona para a lista se o endereço não puder ser excluído
        }
    }

}
