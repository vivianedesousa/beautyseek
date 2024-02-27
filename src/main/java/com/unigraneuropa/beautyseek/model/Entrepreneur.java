package com.unigraneuropa.beautyseek.model;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="entrepreneurs")
public class Entrepreneur extends User{
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   private String fantasyName;
   private String corporateName;
   private String registerNumber;
   private String phoneNumber;
   // aqui esta as relacoes entre classes
   private PaymentMethod paymentMethod; // associacao
   private AvailableTime availableTime;
   private SocialMedia SocialMedia;
   private AvailableDay availableDay;
   private Address address;// agregacao;
   private ArrayList<Service> services;// associacao Bidirencial quando um ta dentro do outro;

   public Entrepreneur(int id, String email, String password) {
      super(id, email, password);
   }
}
