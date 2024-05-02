package com.unigraneuropa.beautyseek.model;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.*;//para o casso ao banco dedos


@Data// getters setters, toString ,equals hascode
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="users") // nome da tabela
// DEPOIS REVISAR ESTA PARTE DA HERENCA
@Inheritance (strategy=InheritanceType.JOINED)// para indicar que tabela user possuir sobr classe faz parte da heranca
public abstract class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
