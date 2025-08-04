package juliacazeri.projeto.spring.service.ipml;

import juliacazeri.projeto.spring.dto.LivroDTO;
import juliacazeri.projeto.spring.exception.ResourceNotFoundException;
import juliacazeri.projeto.spring.model.Autor;
import juliacazeri.projeto.spring.model.Editora;
import juliacazeri.projeto.spring.model.Livro;
import juliacazeri.projeto.spring.repository.AutorRepository;
import juliacazeri.projeto.spring.repository.EditoraRepository;
import juliacazeri.projeto.spring.repository.LivroRepository;
import juliacazeri.projeto.spring.service.LivroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroServiceImpl implements LivroService{

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final EditoraRepository editoraRepository;

    public LivroServiceImpl(LivroRepository livroRepository, AutorRepository autorRepository, EditoraRepository editoraRepository){
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.editoraRepository = editoraRepository;
    }

    private LivroDTO toDTO(Livro livro){
        LivroDTO dto = new LivroDTO();
        dto.setId(livro.getId());
        dto.setTitulo(livro.getTitulo());
        dto.setIsbn(livro.getIsbn());
        dto.setAnoPublicacao(livro.getAnoPublicacao());
        dto.setIdAutor(livro.getAutor() != null ? livro.getAutor().getId() : null);
        dto.setIdEditora(livro.getEditora() != null ? livro.getEditora().getId() : null);
        dto.setQuantidadeEstoque(livro.getQuantidadeEstoque());
        return dto;
    }

    private Livro toEntity(LivroDTO dto){
        Autor autor = autorRepository.findById(dto.getIdAutor())
                .orElseThrow(() -> new ResourceNotFoundException("O autor não foi encontrado!"));
        Editora editora = editoraRepository.findById(dto.getIdEditora())
                .orElseThrow(() -> new ResourceNotFoundException("A editora não foi encontrada!"));

        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setIsbn(dto.getIsbn());
        livro.setAnoPublicacao(dto.getAnoPublicacao());
        livro.setAutor(autor);
        livro.setEditora(editora);
        livro.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        return livro;
    }

    @Override
    public List<LivroDTO> listarTodos(){
        return livroRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LivroDTO buscarPorId(Long id){
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O livro não foi encontrado!"));
        return toDTO(livro);
    }

    @Override
    public LivroDTO criar(LivroDTO dto){
        if(livroRepository.findByIsbn(dto.getIsbn()).isPresent()){
            throw new IllegalArgumentException("Este ISBN já foi cadastrado.");
        }
        Livro livro = toEntity(dto);
        livro = livroRepository.save(livro);
        return toDTO(livro);
    }

    @Override
    public LivroDTO atualizar(Long id, LivroDTO dto){
        Livro existente = livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O livro não foi encontrado!"));
        existente.setTitulo(dto.getTitulo());
        existente.setAnoPublicacao(dto.getAnoPublicacao());
        existente.setQuantidadeEstoque(dto.getQuantidadeEstoque());

        Autor autor = autorRepository.findById(dto.getIdAutor())
                .orElseThrow(() -> new ResourceNotFoundException("O autor não foi encontrado!"));
        Editora editora = editoraRepository.findById(dto.getIdEditora())
                .orElseThrow(() -> new ResourceNotFoundException("A editora não foi encontrada!"));

        existente.setAutor(autor);
        existente.setEditora(editora);

        existente = livroRepository.save(existente);
        return toDTO(existente);
    }

    @Override
    public void deletar(Long id){
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O livro não foi encontrado!"));
        livroRepository.delete(livro);
    }
}