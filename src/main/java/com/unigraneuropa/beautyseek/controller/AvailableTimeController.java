package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.AvailableDay;
import com.unigraneuropa.beautyseek.model.AvailableTime;
import com.unigraneuropa.beautyseek.service.AvailableTimeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/AvailableTimes")
public class AvailableTimeController {
    private final AvailableTimeService availableTimeService;

    public AvailableTimeController(AvailableTimeService availableTimeService) {
        this.availableTimeService = availableTimeService;
    }

    @GetMapping
    public String listAvailableTimes(Model model) {
        model.addAttribute("availableTimes",availableTimeService.getAllAvailableTimes());
        return "AvailableTimes/list"; // Nome do template Thymeleaf para listar endereços
    }

    @GetMapping("/new")
    public String newAvailableTimeFom(Model model) {
        model.addAttribute("AvailableTimes", new AvailableTime());
        return "AvailableTimes/new"; // Formulário Thymeleaf para novo endereço
    }

    @PostMapping
    public String createAvailableTime(@ModelAttribute AvailableTime availableTime) {
        availableTimeService.createAvailableTime(availableTime);
        return "redirect:/AvailableDays"; // Redireciona para a lista de endereços após a criação
    }
    //https://beautyseek.com/addresses/edit/999
    @GetMapping("/edit/{id}")
    public String editAvailableTimeForm(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute(" availableTime", availableTimeService.getAvailableTimeById(id));
            return " availableTimes/edit"; // Formulário Thymeleaf para editar endereço
        } catch (RegisterNotFoundException e) {
            return "redirect:/availableTimes"; // Redireciona para a lista se o endereço não for encontrado
        }
    }

    @PostMapping("/update/{id}")
    public String updateAvailableTime(@PathVariable Integer id, @ModelAttribute AvailableTime availableTime) {
        try {
            availableTimeService.updateAvailableTime(id, availableTime.getId());
            return "redirect:/AvailableDays"; // Redireciona para a lista de endereços após a atualização
        } catch (RegisterNotFoundException e) {
            return "redirect:/AvailableDays"; // Redireciona para a lista se o endereço não puder ser atualizado
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteAvailableTime(@PathVariable Integer id) {
        if (availableTimeService.deleteAvailableTime(id)) {
            return "redirect:/availableTimes"; // Redireciona para a lista após a exclusão
        } else {
            return "redirect:/availableTimes"; // Redireciona para a lista se o endereço não puder ser excluído
        }
    }

}
