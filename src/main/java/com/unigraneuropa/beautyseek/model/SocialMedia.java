package com.unigraneuropa.beautyseek.model;
// estas sao anotacaoes de classes  A mostrar para seguir
import lombok.AllArgsConstructor;///  um contrtutor com todos os argumentos / atributos
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;// construtor defull
import jakarta.persistence.Entity; // representcao de intetide  do JPA  usar para  mapeamento de classes
// na tabela do BD
import jakarta.persistence.*;//para o casso ao banco dedos
@Data// getters setters, toString ,equals hascode
@AllArgsConstructor
@Getter//remove depois
@Setter// remove depois
@NoArgsConstructor
@Entity
@Table (name="socialMedias")
// anotacoes  de atributos de dentro das classes
public class SocialMedia {
    @Id// este vai ser chave primaria
    ///estategia a seguir  AUTO, IDENTITY, SEQUENCE e a TABLE
    @GeneratedValue(strategy=GenerationType.IDENTITY) // para banco dados fazer encremento
    private int  id;
    private String whatsApp;
    private String instagram;
    private String facebook;
}
