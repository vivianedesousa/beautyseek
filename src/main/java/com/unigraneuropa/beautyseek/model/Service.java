package com.unigraneuropa.beautyseek.model;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="services")
public class Service {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String type;
    private ArrayList<Entrepreneur> enterprisings; /// associacao Bidirencial quando um ta dentro do outro;
}
