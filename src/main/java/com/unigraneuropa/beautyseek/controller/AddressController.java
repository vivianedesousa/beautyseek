package com.unigraneuropa.beautyseek.controller;

import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Address;
import com.unigraneuropa.beautyseek.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public String listAddresses(Model model) {
        model.addAttribute("addresses", addressService.getAllAddresses());
        return "addresses/list"; // Nome do template Thymeleaf para listar endereços
    }

    //https://beautyseek.com/addresses/new
    @GetMapping("/new")
    public String newAddressForm(Model model) {
        model.addAttribute("address", new Address());
        return "addresses/new"; // Formulário Thymeleaf para novo endereço
    }

    @PostMapping
    public String createAddress(@ModelAttribute Address address) {
        addressService.createAddress(address);
        return "redirect:/addresses"; // Redireciona para a lista de endereços após a criação
    }


    //https://beautyseek.com/addresses/edit/999
    @GetMapping("/edit/{id}")
    public String editAddressForm(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute("address", addressService.getAddressById(id));
            return "addresses/edit"; // Formulário Thymeleaf para editar endereço
        } catch (RegisterNotFoundException e) {
            return "redirect:/addresses"; // Redireciona para a lista se o endereço não for encontrado
        }
    }

    @PostMapping("/update/{id}")
    public String updateAddress(@PathVariable Integer id, @ModelAttribute Address address) {
        try {
            addressService.updateAddress(id, address);
            return "redirect:/addresses"; // Redireciona para a lista de endereços após a atualização
        } catch (RegisterNotFoundException e) {
            return "redirect:/addresses"; // Redireciona para a lista se o endereço não puder ser atualizado
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Integer id) {
        if (addressService.deleteAddress(id)) {
            return "redirect:/addresses"; // Redireciona para a lista após a exclusão
        } else {
            return "redirect:/addresses"; // Redireciona para a lista se o endereço não puder ser excluído
        }
    }
}
