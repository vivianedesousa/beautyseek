package com.unigraneuropa.beautyseek.model;
import java.util.Date;
// estas sao anotacaoes de classes
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.*;//para o casso ao banco dedos
@Data// getters setters, toString ,equals hascode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="feedbacks")
public class Feedback{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String note;
    private String message;
    private Date  date;
    private Scheduling  Scheduling;// relacao de agregacao
    private User from;// relacao de composicao // que vai fazer o feedback
    private User to; // relacao de compisicao   // que vai receber o feedback
}
