package com.example.ponto.resource;

import com.example.ponto.dto.FuncionarioDTO;
import com.example.ponto.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController extends AbstractController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios() {
        List<FuncionarioDTO> funcionarios = funcionarioService.listarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarFuncionarioPorId(@PathVariable Long id) {
        FuncionarioDTO funcionario = funcionarioService.buscarFuncionarioPorId(id);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> adicionarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO novoFuncionario = funcionarioService.adicionarFuncionario(funcionarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> atualizarFuncionario(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO funcionarioAtualizado = funcionarioService.atualizarFuncionario(id, funcionarioDTO);
        if (funcionarioAtualizado != null) {
            return ResponseEntity.ok(funcionarioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        boolean deleted = funcionarioService.deletarFuncionario(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
