package juliacazeri.projeto.spring.dto;

import jakarta.validation.constraints.*;

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

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getIsbn(){
        return isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public Integer getAnoPublicacao(){
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }

    public Long getIdEditora(){
        return idEditora;
    }

    public void setIdEditora(Long idEditora){
        this.idEditora = idEditora;
    }

    public Long getIdAutor(){
        return idAutor;
    }

    public void setIdAutor(Long idAutor){
        this.idAutor = idAutor;
    }

    public Integer getQuantidadeEstoque(){
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque){
        this.quantidadeEstoque = quantidadeEstoque;
    }
}