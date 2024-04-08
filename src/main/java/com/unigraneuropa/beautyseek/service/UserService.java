package com.unigraneuropa.beautyseek.service;
import java.util.List;
import com.unigraneuropa.beautyseek.exception.RegisterNotFoundException;
import java.util.Optional;
import java.util.ArrayList;
import com.unigraneuropa.beautyseek.model.User;
import com.unigraneuropa.beautyseek.repository.UserRepository;
import org.springframework.stereotype.Service;
@Service
// este service do Spring // talvez mudar o nome
public class UserService {
   private final UserRepository userRepository; // atributo final em uma classe

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // todos metodos do CRUD ();
    // vai ler todos os usuarios (READ)
    public List<User> getAllUsers(){
     List<User> userList = new ArrayList();
     userList.addAll(userRepository.findAll());// adcionando dentro da lista
     return userList;
     // linha 18 19 20   poderia ser resumida em unica linha
      //return userRepository.findAll();
    //projencao select from users
    /// SELECT * FROM USERS; todos os usuarios
    }

    // vai ler apenas um Usuario (READ)
    public User getUserById(Integer id) throws RegisterNotFoundException {
    // SELECT * FROM USERS //  WHERE id ="id";
     Optional<User> validUser = userRepository.findById(id);
     if(validUser.isPresent()){//se exite or  nao
         return validUser.get();
     }else{
         throw new RegisterNotFoundException();
     }
    }

    // vai criar um novo Usuario(CREATE)
    public User createUser(User user){
     // insert into users values (...);
         return userRepository.save(user);
    }

    // vai atualizar um usuario existente(update);
    public User updateUser(Integer id,User user) throws RegisterNotFoundException {
      //UPDATE USER  SET USER ="id";
     if(userRepository.existsById(id)){
        user.setId(id);// estamos colocando id dentro User
        return userRepository.save(user);
     }else{
        throw new RegisterNotFoundException();
     }
    }

    //vai deleta um usuario existente (DELETE)
    public boolean deleteUser(Integer id){
     //DELETE USER WHERE USER = 'id';
        if(userRepository.existsById(id)){
         userRepository.deleteById(id);
         return true;
        }else{
         return false;
        }
    }
}
