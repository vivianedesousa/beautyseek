package com.unigraneuropa.beautyseek.service;

import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import com.unigraneuropa.beautyseek.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.unigraneuropa.beautyseek.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;//trazer todos os metodos do pacote

@SpringBootTest
public class AddressTest {
    // injenvcao dependencia  @Autowired:sping freame atravez de refexao vai entender que essa proeidade ta anotada com Autowired
    // vai buscar essa depencia dentro do contexto dele e vai injeta para mim
    @Autowired//  Esta anotação é usada para criar uma simulação (mock) de
    private AddressService addressService;

    @MockBean
    private AddressRepository addressRepository;

    @BeforeEach
        //executar antes de fazer qualquer testeIsso é útil quando você precisa configurar
        // um estado inicial ou realizar
        // algumas preparações antes de executar cada teste individualmente.
    void setUp() {
        Address address1 = new Address("SP", "São Paulo", "Centro", "Rua A", "12345-678", "100");
        Address address2 = new Address("RJ", "Rio de Janeiro", "Zona Sul", "Rua B", "87654-321", "200");
        List<Address> addresses = Arrays.asList(address1, address2);

        when(addressRepository.findAll()).thenReturn(addresses);
        // quando eu buscar todos no banco de dados usando o reposit uma list devera ser retornada = ADDRESSES
        when(addressRepository.findById(1)).thenReturn(Optional.of(address1));
        // quando eu buscar pelo ID 1 no  banco de dados usando o reposit um objeto devera ser retornada=ADDRESS1
        when(addressRepository.save(any(Address.class))).thenAnswer(i -> i.getArgument(0));
        //  quando eu salva no bc o endereco este endereco dever ser o retorno
        when(addressRepository.existsById(1)).thenReturn(true);
        // quando eu verifico a existencia do ID 1 o restorno vai verdadeiro
        when(addressRepository.existsById(999)).thenReturn(false);
        // vai retorna falaso porque nao exist ID 999 vai retorna FALSE
    }

    @Test
    void getAllAddressesTest() { // leitura de todos
        // linhq 49  ele vai criar lista e buscar os address BC
        List<Address> addresses = addressService.getAllAddresses();
        assertNotNull(addresses);
        // ela slista nao pode ser nula se ela nao  for nula vai passar no teste
        assertEquals(2, addresses.size());
        // teste de igualdade  size (tamanho da lista que e igual  esta relacionado linha 30 32  acima)
    }

    @Test
// leitura de 1 address pelo id
    void getAddressByIdFoundTest() throws RegisterNotFoundException {
        // é uma chamada a um método da classe AddressService. Presumivelmente, este método getAddressById
        // está definido na classe AddressService e é responsável por buscar um endereço pelo
        // seu ID no banco de dados ou em alguma fonte de dados.
        Address address = addressService.getAddressById(1);
        assertNotNull(address);// nao for nullo pasar no teste
        assertEquals("SP", address.getState());
        // comparar o esatdo endereco com SAO PAULO ID (1) SE FOR VERDADE PASSAR NO TESTE
    }

    @Test
// vai testa  a resposta de um erro se funcionar
    void getAddressByIdNotFoundTest() {
        assertThrows(RegisterNotFoundException.class, () -> addressService.getAddressById(999));
        // > addressService.getAddressById(999)); eu simulei este erro porque nao existe ID 99  se existe vai
        // vai lancar uma exception ( resumindo algo inesperado no sistema).
    }

    @Test
        // aqui esta sendo testado o CREATE AND UPDATE  (porque para atualizar preciso ter algo criado)
    void createAndUpdateAddressTest() {
        Address newAddress = new Address("MG", "Belo Horizonte", "Centro", "Rua C", "11223-445", "300");
        Address savedAddress = addressService.createAddress(newAddress);// aqui ja ta salvo
        // as duas linha acima vai ser a preparacao para o teste
        // aqui vai ser feito teste
        assertNotNull(savedAddress); // verificar se for salvo
        assertEquals("MG", savedAddress.getState());
        // assertEquals("Belo Horizonte", savedAddress.getCity()); // posso fazer os 2 ao mesmo tempo;
        // esta verificando pelo estado que savou eo estado correto.

        // Testing update
        savedAddress.setStreetName("Nova Rua C");
        try {
            // criar um objeto de endereco aparti da atualizacao do objeto que foi criado acima na linha 75
            Address updatedAddress = addressService.updateAddress(3, savedAddress);
            // vai fazer o teste
            assertNotNull(updatedAddress); // se nao for nulo ja atualizou
            assertEquals("Nova Rua C", updatedAddress.getStreetName());//.  e para CHAMR O GET
            // vai teste se o nome da rua vou atualizado
        } catch (RegisterNotFoundException exception) {
            fail("o registro nao existe" + exception.getMessage());
            //  String error="o registro nao existe";
            //   fail(error);
            // caso nao encontrar nehum registro com id 3
        }
    }

    @Test
// para testa se deu certo
    void deleteAddressSuccessTest() {
        assertTrue(addressService.deleteAddress(1));
        // vai da certo poque quero deletar algo que existe no meu BC
    }

    @Test
// simulacao de um teste errado que nao existe dentro BC
    void deleteAddressFailureTest() {
        assertFalse(addressService.deleteAddress(999));
        // aqui vai ser falso.
    }
}
