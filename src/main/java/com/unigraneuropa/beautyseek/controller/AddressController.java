package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/Address")
public class AddressController {
    private final AddressService addressService;

public AddressController(AddressService addressService) {
    this.addressService = addressService;
    }
    @GetMapping("/list")
    public void listAddress(){
    }
    @GetMapping("/list/{id}")
    public void getAddress(int id){
    }
    @GetMapping("/new")
    public void newAddress(){

    }
    @PostMapping("/save")
    public void saveAddress(){

    }
    @GetMapping("/edit/{id}")
    public void editAddress(int id){
    }

    @PostMapping("/update/{id}")
    public void updateAddress(){
    }

    @GetMapping("/delete/{id}")
    public void deleteAddress() {

    }
}
