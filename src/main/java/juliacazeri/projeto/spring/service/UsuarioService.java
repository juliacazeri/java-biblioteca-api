package juliacazeri.projeto.spring.service;

import juliacazeri.projeto.spring.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService{
    List<UsuarioDTO> listarTodos();
    UsuarioDTO buscarPorId(Long id);
    UsuarioDTO criar(UsuarioDTO dto);
    UsuarioDTO atualizar(Long id, UsuarioDTO dto);
    void deletar(Long id);
}