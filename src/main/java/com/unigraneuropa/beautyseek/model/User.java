package com.unigraneuropa.beautyseek.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.*;//para o casso ao banco dedos
@Data// getters setters, toString ,equals hascode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="users") // nome da tabela
// DEPOIS REVISAR ESTA PARTE DA HERENCA
@Inheritance (strategy=InheritanceType.TABLE_PER_CLASS)// para indicar que tabela user possuir sobr classe faz parte da heranca
abstract class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
}
