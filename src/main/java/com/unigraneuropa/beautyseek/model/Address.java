package com.unigraneuropa.beautyseek.model;
 //jdbc banco de dados
import lombok.*;
import jakarta.persistence.*;
@Getter
@Setter
@Data
@AllArgsConstructor
@RequiredArgsConstructor // com parametro
@NoArgsConstructor// o padao
@Entity
@Table(name="addresses")
public class Address {
    @Id// este vai ser chave primaria
    ///estategia a seguir  AUTO, IDENTITY, SEQUENCE e a TABLE
    @GeneratedValue(strategy=GenerationType.IDENTITY) // para banco dados fazer encremento
    private int id;
    @NonNull // para criar os contrutores
    private String state;
    @NonNull
    private String city;
    @NonNull
    private String district;
    @NonNull
    private String streetName;
    @NonNull
    private String zipCode;
    @NonNull
    private String number;
    private String compliment;
}
