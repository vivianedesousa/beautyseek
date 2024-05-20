package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Address;
import com.unigraneuropa.beautyseek.model.Client;
import com.unigraneuropa.beautyseek.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClientTest {

    @Autowired
    private ClientService clientService;

    @MockBean
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        Address address = new Address();
        address.setId(1); // Configurando um ID fictício para o endereço

        Client client1 = new Client("123456789", "Carlos Silva", 'M', "11-98765-4321", address);
        Client client2 = new Client("987654321", "Maria Oliveira", 'F', "21-12345-6789", address);
        List<Client> clients = Arrays.asList(client1, client2);

        when(clientRepository.findAll()).thenReturn(clients);
        when(clientRepository.findById(1)).thenReturn(Optional.of(client1));
        when(clientRepository.save(any(Client.class))).thenAnswer(i -> i.getArgument(0));
        when(clientRepository.existsById(1)).thenReturn(true);
        when(clientRepository.existsById(999)).thenReturn(false);
    }

    @Test
    void getAllClientsTest() {
        List<Client> clients = clientService.getAllClients();
        assertNotNull(clients);
        assertEquals(2, clients.size());
    }

    @Test
    void getClientByIdFoundTest() throws RegisterNotFoundException {
        Client client = clientService.getClientById(1);
        assertNotNull(client);
        assertEquals("Carlos Silva", client.getName());
    }

    @Test
    void getClientByIdNotFoundTest() {
        assertThrows(RegisterNotFoundException.class, () -> clientService.getClientById(999));
    }

    @Test
    void createAndUpdateClientTest() {
        Address newAddress = new Address(); // Suponha que newAddress já esteja configurado
        Client newClient = new Client("258963147", "João Pereira", 'M', "32-98765-4321", newAddress);

        Client savedClient = clientService.createClient(newClient);
        assertNotNull(savedClient);
        assertEquals("João Pereira", savedClient.getName());

        savedClient.setName("João P. Silva");
        try {
            Client updatedClient = clientService.updateClient(3, savedClient);
            assertNotNull(updatedClient);
            assertEquals("João P. Silva", updatedClient.getName());
        } catch (RegisterNotFoundException exception) {
            fail("A exceção RegisterNotFoundException foi lançada: " + exception.getMessage());
        }
    }

    @Test
    void deleteClientSuccessTest() {
        assertTrue(clientService.deleteClient(1));
    }

    @Test
    void deleteClientFailureTest() {
        assertFalse(clientService.deleteClient(999));
    }
}
