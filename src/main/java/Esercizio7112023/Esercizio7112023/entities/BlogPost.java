package Esercizio7112023.Esercizio7112023.entities;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {
    private int id;
    private String categoria;
    private String Titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
}
