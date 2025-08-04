package juliacazeri.projeto.spring.service;

import juliacazeri.projeto.spring.dto.LivroDTO;

import java.util.List;

public interface LivroService{
    List<LivroDTO> listarTodos();
    LivroDTO buscarPorId(Long id);
    LivroDTO criar(LivroDTO dto);
    LivroDTO atualizar(Long id, LivroDTO dto);
    void deletar(Long id);
}