package juliacazeri.projeto.spring.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutorDTO{
    private Long id;

    @NotBlank(message = "Nome do autor é obrigatório")
    private String nome;

    private String nacionalidade;

    private LocalDate dataNascimento;
}