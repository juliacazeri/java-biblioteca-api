package juliacazeri.projeto.spring.service.ipml;

import juliacazeri.projeto.spring.dto.EditoraDTO;
import juliacazeri.projeto.spring.exception.ResourceNotFoundException;
import juliacazeri.projeto.spring.model.Editora;
import juliacazeri.projeto.spring.repository.EditoraRepository;
import juliacazeri.projeto.spring.service.EditoraService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditoraServiceImpl implements EditoraService{

    private final EditoraRepository editoraRepository;

    public EditoraServiceImpl(EditoraRepository editoraRepository){
        this.editoraRepository = editoraRepository;
    }

    private EditoraDTO toDTO(Editora e){
        EditoraDTO dto = new EditoraDTO();
        dto.setId(e.getId());
        dto.setNome(e.getNome());
        dto.setEndereco(e.getEndereco());
        return dto;
    }

    private Editora toEntity(EditoraDTO dto){
        Editora e = new Editora();
        e.setId(dto.getId());
        e.setNome(dto.getNome());
        e.setEndereco(dto.getEndereco());
        return e;
    }

    @Override
    public List<EditoraDTO> listarTodos(){
        return editoraRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EditoraDTO buscarPorId(Long id){
        Editora e = editoraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("A editora não foi encontrada!"));
        return toDTO(e);
    }

    @Override
    public EditoraDTO criar(EditoraDTO dto){
        Editora salvo = editoraRepository.save(toEntity(dto));
        return toDTO(salvo);
    }

    @Override
    public EditoraDTO atualizar(Long id, EditoraDTO dto){
        Editora existente = editoraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("A editora não foi encontrada!"));
        existente.setNome(dto.getNome());
        existente.setEndereco(dto.getEndereco());
        existente = editoraRepository.save(existente);
        return toDTO(existente);
    }

    @Override
    public void deletar(Long id){
        Editora e = editoraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("A editora não foi encontrada!"));
        editoraRepository.delete(e);
    }
}