package com.example.ponto.resource;

import com.example.ponto.dto.RegistroPontoDTO;
import com.example.ponto.models.domain.RegistroPonto;
import com.example.ponto.service.RegistroPontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/registroponto")
public class RegistroPontoController extends AbstractController {

    @Autowired
    private RegistroPontoService registroPontoService;

    @GetMapping
    public ResponseEntity<Page<RegistroPontoDTO>> listarRegistrosPonto(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RegistroPonto> registros = registroPontoService.listarRegistrosPonto(pageable);
        Page<RegistroPontoDTO> dtos = registros.map(RegistroPontoDTO::fromEntity);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroPontoDTO> buscarRegistroPontoPorId(@PathVariable Long id) {
        RegistroPontoDTO registroPonto = registroPontoService.buscarRegistroPontoPorId(id);
        if (registroPonto != null) {
            return ResponseEntity.ok(registroPonto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RegistroPontoDTO> adicionarRegistroPonto(@RequestBody RegistroPontoDTO registroPontoDTO) {
        RegistroPontoDTO novoRegistroPonto = registroPontoService.adicionarRegistroPonto(registroPontoDTO);
        URI uri = URI.create("/api/registroponto/" + novoRegistroPonto.getId());
        return ResponseEntity.created(uri).body(novoRegistroPonto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroPontoDTO> atualizarRegistroPonto(@PathVariable Long id, @RequestBody RegistroPontoDTO registroPontoDTO) {
        registroPontoDTO.setId(id);
        RegistroPontoDTO registroPontoAtualizado = registroPontoService.atualizarRegistroPonto(id, registroPontoDTO);
        if (registroPontoAtualizado != null) {
            return ResponseEntity.ok(registroPontoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRegistroPonto(@PathVariable Long id) {
        registroPontoService.deletarRegistroPonto(id);
        return ResponseEntity.noContent().build();
    }
}
