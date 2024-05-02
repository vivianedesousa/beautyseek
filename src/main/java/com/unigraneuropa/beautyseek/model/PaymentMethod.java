package com.unigraneuropa.beautyseek.model;
 ///estas sao as anotacoes da classe
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="paymenMethods")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NonNull
    private boolean creditCard;
    @NonNull
    private boolean debitCard;
    @NonNull
    private boolean cash;
    @NonNull
    private boolean ted;
    @NonNull
    private boolean doc;
    @NonNull
    private boolean qrCode;
}
