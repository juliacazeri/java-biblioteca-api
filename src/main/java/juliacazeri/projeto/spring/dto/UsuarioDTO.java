package juliacazeri.projeto.spring.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO{
    private Long id;

    @NotBlank(message = "Nome do usuário é obrigatório")
    private String nome;

    @Email(message = "Email inválido")
    private String email;

    private String telefone;
}