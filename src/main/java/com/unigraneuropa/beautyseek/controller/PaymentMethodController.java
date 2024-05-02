package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.PaymentMethodService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RequestMapping("/PaymentMethod")
public class PaymentMethodController {
    private final PaymentMethodService  paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }
    // aqui vamos  mapear as rotas htpp que cliente vai digita  na interface
    @GetMapping("/list")
    public void listPaymentMethod(){

    }
    @GetMapping("/list/{id}")
    public void getPaymentMethod(int id){
    }
    @GetMapping("/new")
    public void newPaymentMethod(){

    }
    @PostMapping("/save")
    public void savePaymentMethod(){

    }
    @GetMapping("/edit/{id}")
    public void editPaymentMethod(int id){
    }

    @PostMapping("/update/{id}")
    public void updatePaymentMethod(){
    }

    @GetMapping("/delete/{id}")
    public void deletePaymentMethod() {

    }
}
