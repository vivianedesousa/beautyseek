package com.unigraneuropa.beautyseek.model;
import lombok.*;
import jakarta.persistence.*;//para o casso ao banco dedos

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="availableTimes")
public class AvailableTime {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
   @NonNull
    private boolean morning;
   @NonNull
    private boolean afternoon;
   @NonNull
    private boolean evening;
}
