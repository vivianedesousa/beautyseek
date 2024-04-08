package com.unigraneuropa.beautyseek.controller;

import com.unigraneuropa.beautyseek.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")// acessar o controler do USER
public class UserController{
  private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // aqui vamos  mapear as rotas htpp que cliente vai digita  na interface
  @GetMapping("")
    public void listUser(){

  }

}
