package juliacazeri.projeto.spring.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public class AutorDTO{
    private Long id;

    @NotBlank(message = "O nome do autor do livro é obrigatório.")
    private String nome;

    private String nacionalidade;

    private LocalDate dataNascimento;

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

    public String getNacionalidade(){
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade){
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }
}