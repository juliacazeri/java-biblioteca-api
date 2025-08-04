package juliacazeri.projeto.spring.controller;

import jakarta.validation.Valid;
import juliacazeri.projeto.spring.dto.EmprestimoDTO;
import juliacazeri.projeto.spring.service.EmprestimoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController{

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService){
        this.emprestimoService = emprestimoService;
    }

    @GetMapping
    public ResponseEntity<List<EmprestimoDTO>> listarTodos(){
        return ResponseEntity.ok(emprestimoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(emprestimoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<EmprestimoDTO> criar(@Valid @RequestBody EmprestimoDTO dto){
        EmprestimoDTO criado = emprestimoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}/devolver")
    public ResponseEntity<EmprestimoDTO> devolver(@PathVariable Long id){
        EmprestimoDTO atualizado = emprestimoService.devolver(id);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        emprestimoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{usuarioId}/ativos")
    public ResponseEntity<List<EmprestimoDTO>> listarAtivosPorUsuario(@PathVariable Long usuarioId){
        return ResponseEntity.ok(emprestimoService.listarAtivosPorUsuario(usuarioId));
    }

    @GetMapping("/atrasados")
    public ResponseEntity<List<EmprestimoDTO>> listarAtrasados(){
        return ResponseEntity.ok(emprestimoService.listarAtrasados());
    }
}