package juliacazeri.projeto.spring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(unique = true)
    private String isbn;

    private Integer anoPublicacao;

    @ManyToOne
    private Editora editora;

    @ManyToOne
    private Autor autor;

    private Integer quantidadeEstoque;
}