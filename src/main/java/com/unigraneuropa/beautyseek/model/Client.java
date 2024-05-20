package com.unigraneuropa.beautyseek.model;
///estas sao as anotacoes da classe
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="clients")
public class Client extends User{
    // precisamos verificar a relacacao da classe cleinte com servico
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NonNull// para quando o campo nao ser nulo
    private String identificationNumber;
    @NonNull
    private String name;
    @NonNull
    private char gender;
    @NonNull
    private String phoneNumber;

    @OneToOne// relacionamento entre as entidades CLIENTE AND ADDRESS
    @JoinColumn (name="address_id",referencedColumnName="id") // relacao entre duas entidades
    @NonNull
    private Address address;// relaco de agregacao;
}
