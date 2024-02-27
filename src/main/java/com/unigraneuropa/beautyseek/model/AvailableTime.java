package com.unigraneuropa.beautyseek.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;//para o casso ao banco dedos
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="availableTimes")
public class AvailableTime {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private boolean morning;
    private boolean afternoon;
    private boolean evening;
}
