package juliacazeri.projeto.spring.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EditoraDTO{
    private Long id;

    @NotBlank(message = "Nome da editora é obrigatório")
    private String nome;

    private String endereco;
}