package juliacazeri.projeto.spring.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDTO{
    private Long id;

    @NotBlank(message = "O título do livro é obrigatório.")
    private String titulo;

    @NotBlank(message = "O ISBN do livro é obrigatório.")
    private String isbn;

    @NotNull(message = "O ano de publicação do livro é obrigatório.")
    @Min(value = 1500, message = "O ano de publicação informado é inválido!")
    private Integer anoPublicacao;

    @NotNull(message = "O ID da editora do livro é obrigatório.")
    private Long idEditora;

    @NotNull(message = "O ID do autor do livro é obrigatório.")
    private Long idAutor;

    @NotNull(message = "A quantidade em estoque do livro é obrigatória.")
    @Min(value = 0, message = "A quantidade em estoque não pode ser negativa!")
    private Integer quantidadeEstoque;
}