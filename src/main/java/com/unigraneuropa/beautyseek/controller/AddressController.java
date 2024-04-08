package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/Address")
public class AddressController {
    private final AddressService addressService;

public AddressController(AddressService addressService) {
    this.addressService = addressService;
    }
    @GetMapping("")
    public void listAddress(){

    }
}
