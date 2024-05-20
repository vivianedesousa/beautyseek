package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.ServiceOffered;
import com.unigraneuropa.beautyseek.model.SocialMedia;
import com.unigraneuropa.beautyseek.service.PaymentMethodService;
import com.unigraneuropa.beautyseek.service.ServiceOfferedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/services")
public class ServiceOfferedController {

    private final ServiceOfferedService serviceOfferedService;

    @Autowired
    public  ServiceOfferedController(ServiceOfferedService serviceOfferedService) {
        this.serviceOfferedService = serviceOfferedService;
    }

    @GetMapping
    public String ServiceOffered(Model model) {
        model.addAttribute("serviceOfered",serviceOfferedService.getAllServiceOffered());
        return "services/list"; // Nome do template Thymeleaf para listar endereços
    }

    @GetMapping("/new")
    public String newServiceOfferedForm(Model model) {
        model.addAttribute("ServiceOffered", new ServiceOffered());
        return "services/new"; // Formulário Thymeleaf para novo endereço
    }

    @PostMapping
    public String createServiceOffered(@ModelAttribute ServiceOffered serviceOffered){
        serviceOfferedService.createServiceOffered(serviceOffered);
        return "redirect:/services"; // Redireciona para a lista de endereços após a criação
    }

    @GetMapping("/edit/{id}")
    public String editServiceOfferedForm(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute("ServiceOffered", serviceOfferedService.getServiceOfferedById(id));
            return "services/edit"; // Formulário Thymeleaf para editar endereço
        } catch (RegisterNotFoundException e) {
            return "redirect:/services"; // Redireciona para a lista se o endereço não for encontrado
        }
    }

    @PostMapping("/update/{id}")
    public String updateServiceOffered(@PathVariable Integer id, @ModelAttribute ServiceOffered ServiceOffered) {
        try {
            serviceOfferedService.updateServiceOffered(id, ServiceOffered);
            return "redirect:/services"; // Redireciona para a lista de endereços após a atualização
        } catch (RegisterNotFoundException e) {
            return "redirect:/services"; // Redireciona para a lista se o endereço não puder ser atualizado
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteServiceOffered(@PathVariable Integer id) {
        if (serviceOfferedService.deleteServiceOffered(id)) {
            return "redirect:/services"; // Redireciona para a lista após a exclusão
        } else {
            return "redirect:/services"; // Redireciona para a lista se o endereço não puder ser excluído
        }
    }
}
