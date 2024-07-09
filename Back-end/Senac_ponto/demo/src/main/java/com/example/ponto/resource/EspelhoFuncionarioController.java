package com.example.ponto.resource;

import com.example.ponto.dto.RegistroPontoDTO;
import com.example.ponto.service.EspelhoFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/espelhofuncionario")
public class EspelhoFuncionarioController {

    @Autowired
    private EspelhoFuncionarioService espelhoFuncionarioService;

    @GetMapping("/relatoriogeral")
    public ResponseEntity<Page<RegistroPontoDTO>> listarRegistrosPontoTodosFuncionarios(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RegistroPontoDTO> registros = espelhoFuncionarioService.listarRegistrosPontoTodosFuncionarios(pageable);
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/funcionario/{funcionarioId}")
    public ResponseEntity<Page<RegistroPontoDTO>> listarRegistrosPontoFuncionario(
            @PathVariable Long funcionarioId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RegistroPontoDTO> registros = espelhoFuncionarioService.listarRegistrosPontoFuncionario(funcionarioId, pageable);
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/funcionario/{funcionarioId}/data")
    public ResponseEntity<Page<RegistroPontoDTO>> listarRegistrosPontoFuncionarioPorData(
            @PathVariable Long funcionarioId,
            @RequestParam(required = false) LocalDate data,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (data != null) {
            Page<RegistroPontoDTO> registros = espelhoFuncionarioService.listarRegistrosPontoFuncionarioPorData(funcionarioId, data, pageable);
            return ResponseEntity.ok(registros);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
