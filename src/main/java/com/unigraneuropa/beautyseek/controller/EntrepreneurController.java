package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Address;
import com.unigraneuropa.beautyseek.model.Entrepreneur;
import com.unigraneuropa.beautyseek.service.EntrepreneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Entrepreneurs")
public class EntrepreneurController {
    private final EntrepreneurService entrepreneurService;

   @Autowired
    public EntrepreneurController(EntrepreneurService entrepreneurService) {
        this.entrepreneurService = entrepreneurService;
    }

    @GetMapping
    public String listEntrepreneurs(Model model) {
        model.addAttribute("Entrepreneurs", entrepreneurService.getAllEntrepreneurs());
        return "Entrepreneurs/list"; // Nome do template Thymeleaf para listar endereços
    }

    //https://beautyseek.com/addresses/new
    @GetMapping("/new")
    public String newentrepreneurForm(Model model) {
        model.addAttribute("entrepreneur", new Entrepreneur());
        return "addresses/new"; // Formulário Thymeleaf para novo endereço
    }

    @PostMapping
    public String createEntrepreneur(@ModelAttribute Entrepreneur entrepreneur) {
        entrepreneurService.createEntrepreneur(entrepreneur);
        return "redirect:/entrepreneurs"; // Redireciona para a lista de endereços após a criação
    }


    //https://beautyseek.com/addresses/edit/999
    @GetMapping("/edit/{id}")
    public String editEntrepreneurForm(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute("entrepreneur", entrepreneurService.getEntrepreneurById(id));
            return "entrepreneurs/edit"; // Formulário Thymeleaf para editar endereço
        } catch (RegisterNotFoundException e) {
            return "redirect:/entrepreneurs"; // Redireciona para a lista se o endereço não for encontrado
        }
    }

    @PostMapping("/update/{id}")
    public String updateEntrepreneur(@PathVariable Integer id, @ModelAttribute Entrepreneur entrepreneur) {
        try {
            entrepreneurService.updateEntrepreneur(id, entrepreneur);
            return "redirect:/entrepreneurs"; // Redireciona para a lista de endereços após a atualização
        } catch (RegisterNotFoundException e) {
            return "redirect:/entrepreneurs"; // Redireciona para a lista se o endereço não puder ser atualizado
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteEntrepreneur(@PathVariable Integer id) {
        if (entrepreneurService.deleteEntrepreneur(id)) {
            return "redirect:/entrepreneurs"; // Redireciona para a lista após a exclusão
        } else {
            return "redirect:/entrepreneurs"; // Redireciona para a lista se o endereço não puder ser excluído
        }
    }

}
