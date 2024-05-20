package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Address;
import com.unigraneuropa.beautyseek.model.Schedule;
import com.unigraneuropa.beautyseek.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

 @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // aqui vamos  mapear as rotas htpp que cliente vai digita  na interface
    @GetMapping
    public String listSchedules(Model model) {
        model.addAttribute("schedules", scheduleService.getAllSchedules());
        return "schedules/list"; // Nome do template Thymeleaf para listar endereços
    }

    //https://beautyseek.com/addresses/new
    @GetMapping("/new")
    public String newScheduleForm(Model model) {
        model.addAttribute("schedules", new Schedule());
        return "schedules/new"; // Formulário Thymeleaf para novo endereço
    }

    @PostMapping
    public String createSchedule(@ModelAttribute Schedule schedule) {
        scheduleService.createSchedule(schedule);
        return "redirect:/schedules"; // Redireciona para a lista de endereços após a criação
    }


    //https://beautyseek.com/addresses/edit/999
    @GetMapping("/edit/{id}")
    public String editScheduleForm(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute("schedules", scheduleService.getScheduleById(id));
            return "schedules/edit"; // Formulário Thymeleaf para editar endereço
        } catch (RegisterNotFoundException e) {
            return "redirect:/schedules"; // Redireciona para a lista se o endereço não for encontrado
        }
    }

    @PostMapping("/update/{id}")
    public String updateSchedule(@PathVariable Integer id, @ModelAttribute Schedule schedule) {
        try {
            scheduleService.updateSchedule(id, schedule);
            return "redirect:/scheduless"; // Redireciona para a lista de endereços após a atualização
        } catch (RegisterNotFoundException e) {
            return "redirect:/schedules"; // Redireciona para a lista se o endereço não puder ser atualizado
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable Integer id) {
        if (scheduleService.deleteSchedule(id)){
            return "redirect:/schedules"; // Redireciona para a lista após a exclusão
        } else {
            return "redirect:/schedules"; // Redireciona para a lista se o endereço não puder ser excluído
        }
    }

}
