package juliacazeri.projeto.spring.model;

import jakarta.persistence.*;

@Entity
public class Livro{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(unique = true)
    private String isbn;

    private Integer anoPublicacao;

    @ManyToOne
    private Editora editora;

    @ManyToOne
    private Autor autor;

    private Integer quantidadeEstoque;

    public Livro(){

    }

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

    public Editora getEditora(){
        return editora;
    }

    public void setEditora(Editora editora){
        this.editora = editora;
    }

    public Autor getAutor(){
        return autor;
    }

    public void setAutor(Autor autor){
        this.autor = autor;
    }

    public Integer getQuantidadeEstoque(){
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque){
        this.quantidadeEstoque = quantidadeEstoque;
    }
}