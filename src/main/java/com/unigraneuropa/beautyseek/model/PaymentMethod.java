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
@Table(name="paymenMethods")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private boolean creditCard;
    private boolean debitCard;
    private boolean cash;
    private boolean ted;
    private boolean doc;
    private boolean qrCode;
}
