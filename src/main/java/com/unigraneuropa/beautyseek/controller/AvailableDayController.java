package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Address;
import com.unigraneuropa.beautyseek.model.AvailableDay;
import com.unigraneuropa.beautyseek.service.AvailableDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/AvailableDays")
public class AvailableDayController {
    private final AvailableDayService availableDayService;

 @Autowired
    public AvailableDayController(AvailableDayService availableDayService) {
        this.availableDayService = availableDayService;
    }

   @GetMapping
   public String listAvailableDays(Model model) {
      model.addAttribute("availableDays",availableDayService.getAllAvailableDays());
      return "AvailableDays/list"; // Nome do template Thymeleaf para listar endereços
   }

    @GetMapping("/new")
    public String newAvailableDayFom(Model model) {
      model.addAttribute("AvailableDays", new AvailableDay());
      return "AvailableDays/new"; // Formulário Thymeleaf para novo endereço
   }

@PostMapping
public String createAvailableDay(@ModelAttribute AvailableDay availableDay) {
   availableDayService.createAvailableDay(availableDay);
   return "redirect:/AvailableDays"; // Redireciona para a lista de endereços após a criação
}

   //https://beautyseek.com/addresses/edit/999
   @GetMapping("/edit/{id}")
   public String editAvailableDayForm(@PathVariable Integer id, Model model) {
      try {
         model.addAttribute(" availableDay", availableDayService.getAvailableDayById(id));
         return " availableDays/edit"; // Formulário Thymeleaf para editar endereço
      } catch (RegisterNotFoundException e) {
         return "redirect:/availableDays"; // Redireciona para a lista se o endereço não for encontrado
      }
   }

   @PostMapping("/update/{id}")
   public String updateAvailableDay(@PathVariable Integer id, @ModelAttribute AvailableDay availableDay) {
      try {
         availableDayService.updateAvailableDay(id,availableDay );
         return "redirect:/AvailableDays"; // Redireciona para a lista de endereços após a atualização
      } catch (RegisterNotFoundException e) {
         return "redirect:/AvailableDays"; // Redireciona para a lista se o endereço não puder ser atualizado
      }
   }

   @GetMapping("/delete/{id}")
   public String deleteAvailableDay(@PathVariable Integer id) {
      if (availableDayService.deleteAvailableDay(id)) {
         return "redirect:/availableDays"; // Redireciona para a lista após a exclusão
      } else {
         return "redirect:/availableDayS"; // Redireciona para a lista se o endereço não puder ser excluído
      }
   }
}
