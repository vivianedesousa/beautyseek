package com.unigraneuropa.beautyseek.controller;
import com.unigraneuropa.beautyseek.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//isto esta sendo criado para o usuario cominunicar com CRUD do sistema.
@RequestMapping("/user")// acessar o controler do USER
public class UserController{
  private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    /// foram criadas todas as URL
    // aqui vamos  mapear as rotas htpp que cliente vai digita  na interface
  @GetMapping("/list")// http://beautyseek.com/user/list
    public void listUser(){ // para listar todos os usuarios
  }
  @GetMapping("/list/{id}")
    public void getUser(int id){ //lista um usuario;
  }
  @GetMapping("/new")
    public void newUser(){ //todo vez que quero acessar um apagina vou usar o metodo GEt
    //  exemplo (https://www.udemy.com/course/formacao-linux-completa-do-basico-ao-avancado/)

  }
  @PostMapping("/save")
  public void saveUser(){ // enviando uma imformacao
  //    exemplo (depois de preenche campo cadastro vc precisar s(ubmeter aqui vai ser POST ));

  }
  @GetMapping("/edit/{id}")
  public void editUser(int id){ //acessar  apagina de edicao de dados

  }
  @PostMapping("/update/{id}")
  public void updateUser(){ // para comfimar o envio dos novo dados

  }
  @GetMapping("/delete/{id}")
  public void deleteUser(){ //deletar a contar do usuario

  }
}
