package com.unigraneuropa.beautyseek.model;
import java.util.ArrayList;

import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="services") // ligacao com atabela  la no banco de dados.
public class ServiceOffered {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String type;
    // fazer depois
    @ManyToMany
    @JoinTable(name="services_has_entrepreneurs",// nome da tabela
            joinColumns=@JoinColumn(name="service_id"),//  nome da chave intrageira
            inverseJoinColumns=@JoinColumn(name="entrepreneur_id"))// nome da chave da outra tabela
    private ArrayList<Entrepreneur> enterprisings; /// associacao Bidirencial quando um ta dentro do outro;
}
