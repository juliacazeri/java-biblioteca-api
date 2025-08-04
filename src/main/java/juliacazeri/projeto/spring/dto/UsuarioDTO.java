package juliacazeri.projeto.spring.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO{
    private Long id;

    @NotBlank(message = "O nome do usuário é obrigatório.")
    private String nome;

    @Email(message = "O e-mail informado é inválido!")
    private String email;

    private String telefone;
}