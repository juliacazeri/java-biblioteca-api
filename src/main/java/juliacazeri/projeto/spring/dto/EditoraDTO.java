package juliacazeri.projeto.spring.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EditoraDTO{
    private Long id;

    @NotBlank(message = "O nome da editora do livro é obrigatório.")
    private String nome;

    private String endereco;
}