package juliacazeri.projeto.spring.service.ipml;

import juliacazeri.projeto.spring.dto.UsuarioDTO;
import juliacazeri.projeto.spring.exception.ResourceNotFoundException;
import juliacazeri.projeto.spring.model.Usuario;
import juliacazeri.projeto.spring.repository.UsuarioRepository;
import juliacazeri.projeto.spring.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    private UsuarioDTO toDTO(Usuario u){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());
        dto.setTelefone(u.getTelefone());
        return dto;
    }

    private Usuario toEntity(UsuarioDTO dto){
        Usuario u = new Usuario();
        u.setId(dto.getId());
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setTelefone(dto.getTelefone());
        return u;
    }

    @Override
    public List<UsuarioDTO> listarTodos(){
        return usuarioRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO buscarPorId(Long id){
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O usuário não foi encontrado!"));
        return toDTO(u);
    }

    @Override
    public UsuarioDTO criar(UsuarioDTO dto){
        Usuario salvo = usuarioRepository.save(toEntity(dto));
        return toDTO(salvo);
    }

    @Override
    public UsuarioDTO atualizar(Long id, UsuarioDTO dto) {
        Usuario existente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O usuário não foi encontrado!"));
        existente.setNome(dto.getNome());
        existente.setEmail(dto.getEmail());
        existente.setTelefone(dto.getTelefone());
        existente = usuarioRepository.save(existente);
        return toDTO(existente);
    }

    @Override
    public void deletar(Long id){
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O usuário não foi encontrado!"));
        usuarioRepository.delete(u);
    }
}