package com.example.ponto.resource;

import com.example.ponto.models.domain.HorarioTrabalho;
import com.example.ponto.service.HorarioTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horariotrabalho")
public class HorarioTrabalhoController extends AbstractController {

    private final HorarioTrabalhoService horarioTrabalhoservice;

    @Autowired
    public HorarioTrabalhoController(HorarioTrabalhoService service) {
        this.horarioTrabalhoservice = service;
    }

    @PostMapping
    public ResponseEntity<HorarioTrabalho> create(@RequestBody HorarioTrabalho entity) {
        HorarioTrabalho save = horarioTrabalhoservice.salvar(entity);
        return ResponseEntity.created(URI.create("/api/horariotrabalho/" + entity.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<HorarioTrabalho> horarioTrabalho = horarioTrabalhoservice.buscaTodos(pageable);
        return ResponseEntity.ok(horarioTrabalho);
    }

    @GetMapping("{id}")
    public ResponseEntity<HorarioTrabalho> findById(@PathVariable("id") Long id) {
        Optional<HorarioTrabalho> horariotrabalho = horarioTrabalhoservice.buscaPorId(id);
        return horariotrabalho
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
        horarioTrabalhoservice.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<HorarioTrabalho> update(@PathVariable("id") Long id, @RequestBody HorarioTrabalho entity) {
        HorarioTrabalho alterado = horarioTrabalhoservice.alterar(id, entity);
        return ResponseEntity.ok(alterado);
    }
}
