package juliacazeri.projeto.spring.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmprestimoDTO {
    private Long id;

    @NotNull(message = "ID do livro é obrigatório")
    private Long idLivro;

    @NotNull(message = "ID do usuário é obrigatório")
    private Long idUsuario;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucaoPrevista;

    private LocalDate dataDevolucaoReal;
}