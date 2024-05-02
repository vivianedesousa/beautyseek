package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.model.User;
import com.unigraneuropa.beautyseek.repository.UserRepository;
import com.unigraneuropa.beautyseek.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;// vai criar uma intancia na memoria da classe a ser testada
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock // precisar criar um objeto de uma interface
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    // testes dos metodos dos services
    @Test
   public void testAllUsers(){

   }
   @Test
   public void testUserById(){

    }
    @Test
    public void testCreateUser(){

    }
    @Test
    public void testUpdateUser(){

    }
    @Test
    public void testDeleteUser(){

    }
}
