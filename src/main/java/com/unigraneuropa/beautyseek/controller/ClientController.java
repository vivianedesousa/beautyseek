package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.AvailableDay;
import com.unigraneuropa.beautyseek.model.AvailableTime;
import com.unigraneuropa.beautyseek.model.Client;
import com.unigraneuropa.beautyseek.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Clients")
public class ClientController {
  private final ClientService clientService;
@Autowired
  public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients",clientService.getAllClients());
        return "Clients/list"; // Nome do template Thymeleaf para listar endereços
    }

    @GetMapping("/new")
    public String newClientFom(Model model) {
        model.addAttribute("Clients", new Client());
        return "AvailableTimes/new"; // Formulário Thymeleaf para novo endereço
    }

    @PostMapping
    public String createClient(@ModelAttribute Client client) {
        clientService.createClient(client);
        return "redirect:/Clients"; // Redireciona para a lista de endereços após a criação
    }

    //https://beautyseek.com/addresses/edit/999
    @GetMapping("/edit/{id}")
    public String editClientForm(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute(" client", clientService.getClientById(id));
            return " availableDays/edit"; // Formulário Thymeleaf para editar endereço
        } catch (RegisterNotFoundException e) {
            return "redirect:/clients"; // Redireciona para a lista se o endereço não for encontrado
        }
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable Integer id, @ModelAttribute Client client) {
        try {
            clientService.updateClient(id,client );
            return "redirect:/Clients"; // Redireciona para a lista de endereços após a atualização
        } catch (RegisterNotFoundException e) {
            return "redirect:/Clients"; // Redireciona para a lista se o endereço não puder ser atualizado
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Integer id) {
        if (clientService.deleteClient(id)) {
            return "redirect:/clients"; // Redireciona para a lista após a exclusão
        } else {
            return "redirect:/clients"; // Redireciona para a lista se o endereço não puder ser excluído
        }
    }

}
