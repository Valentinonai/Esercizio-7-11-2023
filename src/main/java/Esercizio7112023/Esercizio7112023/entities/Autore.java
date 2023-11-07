package Esercizio7112023.Esercizio7112023.entities;

import lombok.*;

import java.time.LocalDate;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Autore {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;
}
