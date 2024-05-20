package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Feedback;
import com.unigraneuropa.beautyseek.model.PaymentMethod;
import com.unigraneuropa.beautyseek.service.FeedbackService;
import com.unigraneuropa.beautyseek.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/PaymentMethods")
public class PaymentMethodController {
    private final PaymentMethodService  paymentMethodService;

    @Autowired
    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    // aqui vamos  mapear as rotas htpp que cliente vai digita  na interface
    @GetMapping
    public String listPaymentMethods(Model model) {
        model.addAttribute("paymentMethods", PaymentMethodService.getAllPaymentMethods());
        return "PaymentMethods/list"; // Nome do template Thymeleaf para listar endereços
    }
    @GetMapping("/new")
    public String newPaymentMethodFom(Model model) {
        model.addAttribute("PaymentMethods", new PaymentMethod());
        return "PaymentMethods/new"; // Formulário Thymeleaf para novo endereço
    }

    @PostMapping
    public String createPaymentMethod(@ModelAttribute PaymentMethod PaymentMethod) {
        paymentMethodService.createPaymentMethod(PaymentMethod);
        return "redirect:/Clients"; // Redireciona para a lista de endereços após a criação
    }

    //https://beautyseek.com/addresses/edit/999
    @GetMapping("/edit/{id}")
    public String editPaymentMethodForm(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute("paymentMethod", paymentMethodService.getPaymentMethodById(id));
            return "PaymentMethods/edit"; // Formulário Thymeleaf para editar endereço
        } catch (RegisterNotFoundException e) {
            return "redirect:/PaymentMethod"; // Redireciona para a lista se o endereço não for encontrado
        }
    }

    @PostMapping("/update/{id}")
    public String updatePaymentMethod(@PathVariable Integer id, @ModelAttribute PaymentMethod PaymentMethod) {
        try {
            paymentMethodService.updatePaymentMethod(id,PaymentMethod);
            return "redirect:/PaymentMethods"; // Redireciona para a lista de endereços após a atualização
        } catch (RegisterNotFoundException e) {
            return "redirect:/PaymentMethods"; // Redireciona para a lista se o endereço não puder ser atualizado
        }
    }

    @GetMapping("/delete/{id}")
    public String deletePaymentMethod(@PathVariable Integer id) {
        if (paymentMethodService.deletePaymentMethod(id)){
            return "redirect:/paymentMethods"; // Redireciona para a lista após a exclusão
        } else {
            return "redirect:/paymentMethods"; // Redireciona para a lista se o endereço não puder ser excluído
        }
    }
}
