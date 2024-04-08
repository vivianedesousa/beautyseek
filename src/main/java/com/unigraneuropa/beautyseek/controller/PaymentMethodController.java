package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.PaymentMethodService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RequestMapping("/PaymentMethod")
public class PaymentMethodController {
    private final PaymentMethodService  paymentMethodService  ;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }
    // aqui vamos  mapear as rotas htpp que cliente vai digita  na interface
    @GetMapping("")
    public void listPaymentMethod(){

    }
}
