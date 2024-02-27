package com.unigraneuropa.beautyseek.model;
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
@Table (name="availableDays")
public class AvailableDay {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private boolean monday;
    private boolean tuesday;
    private boolean wednesday;
    private boolean thursday;
    private boolean friday;
    private boolean saturday;
    private boolean sunday;
}
