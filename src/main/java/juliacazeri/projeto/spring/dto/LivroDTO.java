package juliacazeri.projeto.spring.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDTO{
    private Long id;

    @NotBlank(message = "Título do livro é obrigatório")
    private String titulo;

    @NotBlank(message = "ISBN é obrigatório")
    private String isbn;

    @NotNull(message = "Ano de publicação é obrigatório")
    @Min(value = 1500, message = "Ano de publicação inválido")
    private Integer anoPublicacao;

    @NotNull(message = "ID da editora é obrigatório")
    private Long idEditora;

    @NotNull(message = "ID do autor é obrigatório")
    private Long idAutor;

    @NotNull(message = "Quantidade em estoque é obrigatória")
    @Min(value = 0, message = "Quantidade não pode ser negativa")
    private Integer quantidadeEstoque;
}