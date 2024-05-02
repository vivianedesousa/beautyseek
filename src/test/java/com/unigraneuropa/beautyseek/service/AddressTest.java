package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.unigraneuropa.beautyseek.repository.AddressRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;//trazer todos os metodos do pacote

@ExtendWith(MockitoExtension.class)

public class AddressTest {
    @Mock
    private AddressRepository addressRepository;
    @InjectMocks
    private AddressService  addressService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAllAddress(){

    }
    @Test
    public void testAddressById(){

    }
    @Test
    public void testCreateAddress(){
        Address address = new Address("Espirito Santo","Serra","FeuRosa","Rua dos Cravos","29.172-105","102");
        when(addressRepository.save(any(Address.class))).thenReturn(address);
        AddressService addressService = new AddressService(addressRepository);
        Address result = addressService .createAddress(new Address("Espirito Santo","Serra","FeuRosa","Rua dos Cravos","29.172-105","102"));

        assertSame(address, result);
        verify(addressRepository).save(any(Address.class));
    }
    @Test
    public void testUpdateAddress(){

    }
    @Test
    public void testDeleteAddress(){
    }

    @Test
    void testCreate() {
//        Address addressData = new Address("Rua ABC", "123", "São Paulo", "SP");
//
//        // Configurando o mock para simular uma inserção bem-sucedida
//        when(database.insert(any(Address.class))).thenReturn(true);
//
//        // Executando o método create da classe Address
//        boolean result = address.create(addressData);
//
//        // Verifica se o resultado é verdadeiro
//        assertTrue(result)
//        // Verifica se o método insert foi chamado exatamente uma vez
//        verify(database, times(1)).insert(addressData);
    }
}
