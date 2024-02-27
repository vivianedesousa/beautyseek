package com.unigraneuropa.beautyseek.model;
 //jdbc banco de dados
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="addresses")
public class Address {
    @Id// este vai ser chave primaria
    ///estategia a seguir  AUTO, IDENTITY, SEQUENCE e a TABLE
    @GeneratedValue(strategy=GenerationType.IDENTITY) // para banco dados fazer encremento
    private int id;
    private String state;
    private String city;
    private String district;
    private String streetName;
    private String zipCode;
    private String number;
    private String compliment;
}
