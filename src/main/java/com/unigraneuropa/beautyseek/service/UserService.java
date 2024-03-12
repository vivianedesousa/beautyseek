package com.unigraneuropa.beautyseek.service;
import com.unigraneuropa.beautyseek.repository.UserRepository;
import org.springframework.stereotype.Service;
@Service
// este service do Spring // talvez mudar o nome
public class UserService {
   private final UserRepository userRepository; // atributo final em uma classe

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
