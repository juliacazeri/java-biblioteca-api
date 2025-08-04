package juliacazeri.projeto.spring.service.ipml;

import juliacazeri.projeto.spring.dto.AutorDTO;
import juliacazeri.projeto.spring.exception.ResourceNotFoundException;
import juliacazeri.projeto.spring.model.Autor;
import juliacazeri.projeto.spring.repository.AutorRepository;
import juliacazeri.projeto.spring.service.AutorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorServiceImpl implements AutorService{

    private final AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    private AutorDTO toDTO(Autor autor){
        AutorDTO dto = new AutorDTO();
        dto.setId(autor.getId());
        dto.setNome(autor.getNome());
        dto.setNacionalidade(autor.getNacionalidade());
        dto.setDataNascimento(autor.getDataNascimento());
        return dto;
    }

    private Autor toEntity(AutorDTO dto){
        Autor autor = new Autor();
        autor.setId(dto.getId());
        autor.setNome(dto.getNome());
        autor.setNacionalidade(dto.getNacionalidade());
        autor.setDataNascimento(dto.getDataNascimento());
        return autor;
    }

    @Override
    public List<AutorDTO> listarTodos(){
        return autorRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AutorDTO buscarPorId(Long id){
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O autor não foi encontrado!"));
        return toDTO(autor);
    }

    @Override
    public AutorDTO criar(AutorDTO dto){
        Autor autor = toEntity(dto);
        autor = autorRepository.save(autor);
        return toDTO(autor);
    }

    @Override
    public AutorDTO atualizar(Long id, AutorDTO dto){
        Autor existente = autorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O autor não foi encontrado!"));
        existente.setNome(dto.getNome());
        existente.setNacionalidade(dto.getNacionalidade());
        existente.setDataNascimento(dto.getDataNascimento());
        existente = autorRepository.save(existente);
        return toDTO(existente);
    }

    @Override
    public void deletar(Long id){
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O autor não foi encontrado!"));
        autorRepository.delete(autor);
    }
}