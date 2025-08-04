package juliacazeri.projeto.spring.service;

import juliacazeri.projeto.spring.dto.EmprestimoDTO;

import java.util.List;

public interface EmprestimoService{
    List<EmprestimoDTO> listarTodos();
    EmprestimoDTO buscarPorId(Long id);
    EmprestimoDTO criar(EmprestimoDTO dto);
    EmprestimoDTO devolver(Long id);
    void deletar(Long id);
    List<EmprestimoDTO> listarAtivosPorUsuario(Long usuarioId);
    List<EmprestimoDTO> listarAtrasados();
}