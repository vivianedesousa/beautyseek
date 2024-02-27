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
    private Entrepreneur enterprising;// relacao composicao
    private Client client; //relacao compossicao
}
