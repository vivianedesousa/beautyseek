package com.unigraneuropa.beautyseek.model;
import java.util.Date;
// estas sao anotacaoes de classes
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.*;//para o casso ao banco dedos


@Data// getters setters, toString ,equals hascode
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="feedbacks")
public class Feedback{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String rating;
    @NonNull
    private String message;
    @NonNull
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
