package juliacazeri.projeto.spring.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class EmprestimoDTO{
    private Long id;

    @NotNull(message = "O ID do livro é obrigatório.")
    private Long idLivro;

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long idUsuario;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Long getIdLivro(){
        return idLivro;
    }
    public void setIdLivro(Long idLivro){
        this.idLivro = idLivro;
    }

    public Long getIdUsuario(){
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario){
        this.idUsuario = idUsuario;
    }

    public LocalDate getDataEmprestimo(){
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo){
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista(){
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista){
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal(){
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal){
        this.dataDevolucaoReal = dataDevolucaoReal;
    }
}