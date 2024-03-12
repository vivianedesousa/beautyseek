package com.unigraneuropa.beautyseek.model;
import java.util.Date;
import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private  Date date;
    private  Time time;
    ///reacaoes
    @OneToOne
    @JoinColumn (name="entrepreneur_id",referencedColumnName="id")// aqui  esta chave estrangeira do banco
    private Entrepreneur enterprising;// relacao composicao
    @OneToOne
    @JoinColumn (name="client_id",referencedColumnName="id")
    private Client client; //relacao compossicao
}
