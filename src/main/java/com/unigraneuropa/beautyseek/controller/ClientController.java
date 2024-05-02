package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("/list")
    public void listClient(){
    }
    @GetMapping("/list/{id}")
    public void getClient(int id){
    }
    @GetMapping("/new")
    public void newClient(){

    }
    @PostMapping("/save")
    public void saveClient(){

    }
    @GetMapping("/edit/{id}")
    public void editClient(int id){
    }

    @PostMapping("/update/{id}")
    public void updateClient(){
    }

    @GetMapping("/delete/{id}")
    public void deleteClient() {

    }
}
