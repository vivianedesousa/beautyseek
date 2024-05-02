package com.unigraneuropa.beautyseek.model;
// estas sao anotacaoes de classes
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.*;//para o casso ao banco dedos

@Data// getters setters, toString ,equals hascode
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="availableDays")
public class AvailableDay {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NonNull // para criar o construtor
    private boolean monday;
    @NonNull
    private boolean tuesday;
    @NonNull
    private boolean wednesday;
    @NonNull
    private boolean thursday;
    @NonNull
    private boolean friday;
    @NonNull
    private boolean saturday;
    @NonNull
    private boolean sunday;
}
