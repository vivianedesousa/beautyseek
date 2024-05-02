package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.model.Address;
import com.unigraneuropa.beautyseek.model.Client;
import com.unigraneuropa.beautyseek.model.User;
import com.unigraneuropa.beautyseek.repository.ClientRepository;
import com.unigraneuropa.beautyseek.repository.UserRepository;
import jakarta.persistence.*;
import lombok.NonNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class ClientTest {
    @Mock // ele nao depende do service
    private ClientRepository clientRepository ;
    @InjectMocks// ele vai ultilizar o repository(ele necessita que repositoy seja criado )
    private ClientService clientService;
    @Test
    public void testAllClient(){

    }
    @Test
    public void testClientById(){

    }
    // craete vai ser primeiro na banco do banco de dados
    @Test
    public void testCreateClient(){
        Address adress =new Address("Espirito Santo","Serra","FeuRosa","Rua dos Cravos","29.172-105","102");
         User newUser = new Client();
    }
    @Test
    public void testUpdateClient(){

    }
    @Test
    public void testDeleteClient(){
    }

}
