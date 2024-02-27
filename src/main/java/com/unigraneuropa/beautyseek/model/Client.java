package com.unigraneuropa.beautyseek.model;
///estas sao as anotacoes da classe
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="clients")
public class Client extends User{
    // precisamos verificar a relacacao da classe cleinte com servico
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String identificationNumber;
    private String name;
    private char gender;
    private String phoneNumber;
    private Address address;// relaco de agregacao;
}
