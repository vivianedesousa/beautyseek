package com.unigraneuropa.beautyseek.model;
// estas sao anotacaoes de classes  A mostrar para seguir
import lombok.*;
import jakarta.persistence.Entity; // representcao de intetide  do JPA  usar para  mapeamento de classes
// na tabela do BD
import jakarta.persistence.*;//para o casso ao banco dedos
@Data// getters setters, toString ,equals hascode
@RequiredArgsConstructor
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
    @NonNull
    private String whatsApp;
    @NonNull
    private String instagram;
    @NonNull
    private String facebook;
}
