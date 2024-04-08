package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Client;
import com.unigraneuropa.beautyseek.model.Entrepreneur;
import com.unigraneuropa.beautyseek.model.User;
import com.unigraneuropa.beautyseek.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients(){
        List<Client> clientList = new ArrayList();
        clientList.addAll(clientRepository.findAll());
        return clientList;
    }

    public Client getClientById(Integer id) throws RegisterNotFoundException {
        Optional<Client> validClient =  clientRepository.findById(id);
        if(validClient.isPresent()){
            return validClient.get();
        }else{
            throw new RegisterNotFoundException();
        }
    }
    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public Client updateClient (Integer id,Client client) throws RegisterNotFoundException {
        if(clientRepository.existsById(id)){
            client.setId(id);// estamos colocando id dentro User
            return clientRepository.save(client);
        }else{
            throw new RegisterNotFoundException();
        }
    }

    public boolean deleteClient(Integer id){
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
