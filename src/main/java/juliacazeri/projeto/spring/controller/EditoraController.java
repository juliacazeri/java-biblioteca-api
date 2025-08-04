package juliacazeri.projeto.spring.controller;

import jakarta.validation.Valid;
import juliacazeri.projeto.spring.dto.EditoraDTO;
import juliacazeri.projeto.spring.service.EditoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editoras")
public class EditoraController{

    private final EditoraService editoraService;

    public EditoraController(EditoraService editoraService){
        this.editoraService = editoraService;
    }

    @GetMapping
    public ResponseEntity<List<EditoraDTO>> listar(){
        return ResponseEntity.ok(editoraService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditoraDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(editoraService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<EditoraDTO> criar(@Valid @RequestBody EditoraDTO dto){
        EditoraDTO criado = editoraService.criar(dto);
        return ResponseEntity.status(201).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditoraDTO> atualizar(@PathVariable Long id, @Valid @RequestBody EditoraDTO dto){
        return ResponseEntity.ok(editoraService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        editoraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}