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
    private String rating;
    private String message;
    private Date  date;
    @OneToOne
    @JoinColumn (name="schedule_id",referencedColumnName="id")
    private Schedule  schedule;
    @OneToOne
    @JoinColumn (name="from",referencedColumnName="id")
    private User from;
    @OneToOne
    @JoinColumn (name="to",referencedColumnName="id")// aqui  esta chave estrangeira do banco
    private User to; // relacao de compisicao   // que vai receber o feedback
}
