package juliacazeri.projeto.spring.dto;

import jakarta.validation.constraints.*;

public class UsuarioDTO{
    private Long id;

    @NotBlank(message = "O nome do usuário é obrigatório.")
    private String nome;

    @Email(message = "O e-mail informado é inválido!")
    private String email;

    private String telefone;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}