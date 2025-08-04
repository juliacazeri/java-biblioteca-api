package juliacazeri.projeto.spring.service;

import juliacazeri.projeto.spring.dto.AutorDTO;

import java.util.List;

public interface AutorService{
    List<AutorDTO> listarTodos();
    AutorDTO buscarPorId(Long id);
    AutorDTO criar(AutorDTO dto);
    AutorDTO atualizar(Long id, AutorDTO dto);
    void deletar(Long id);
}