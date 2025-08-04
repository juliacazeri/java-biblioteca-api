package juliacazeri.projeto.spring.service;

import juliacazeri.projeto.spring.dto.EditoraDTO;

import java.util.List;

public interface EditoraService{
    List<EditoraDTO> listarTodos();
    EditoraDTO buscarPorId(Long id);
    EditoraDTO criar(EditoraDTO dto);
    EditoraDTO atualizar(Long id, EditoraDTO dto);
    void deletar(Long id);
}