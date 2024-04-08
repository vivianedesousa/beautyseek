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
   @OneToOne// relacionamento entre as entidades CLIENTE AND ADDRESS
   @JoinColumn (name="paymentMethod_id",referencedColumnName="id") // relacao entre duas entidades
   private PaymentMethod paymentMethod; // associacao
   @OneToOne
   @JoinColumn (name="availableTime_id",referencedColumnName="id")
   private AvailableTime availableTime;
   @OneToOne
   @JoinColumn(name="socialMedia_id",referencedColumnName="id")
   private SocialMedia socialMedia;
   @OneToOne
   @JoinColumn (name="availableDay_id",referencedColumnName="id")
   private AvailableDay availableDay;

   @OneToOne// relacionamento entre as entidades CLIENTE AND ADDRESS
   @JoinColumn (name="address_id",referencedColumnName="id") // relacao entre duas entidades
   private Address address;// agregacao;
   @ManyToMany(mappedBy="enterprisings")// para nao precisar usar tudo de novo do  JOING  voce so usar
   // to falando que ta fzendo o mapeamento; (em relacao a service classe to falando)

   private ArrayList<ServiceOffered> servicesOffered;// associacao Bidirencial quando um ta dentro do outro;
   // dentro do banco de dados frela  N.m
   public Entrepreneur(int id, String email, String password) {
      super(id, email, password);
   }
}
