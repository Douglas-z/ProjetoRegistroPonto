package com.example.ponto.service;

import com.example.ponto.dto.RegistroPontoDTO;
import com.example.ponto.models.domain.RegistroPonto;
import com.example.ponto.repository.RegistroPontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroPontoService {

    @Autowired
    private RegistroPontoRepository registroPontoRepository;

    public Page<RegistroPonto> listarRegistrosPonto(Pageable pageable) {
        return registroPontoRepository.findAll(pageable);
    }

    public RegistroPontoDTO buscarRegistroPontoPorId(Long id) {
        Optional<RegistroPonto> optionalRegistroPonto = registroPontoRepository.findById(id);
        return optionalRegistroPonto.map(RegistroPontoDTO::fromEntity).orElse(null);
    }

    public RegistroPontoDTO adicionarRegistroPonto(RegistroPontoDTO registroPontoDTO) {
        RegistroPonto registroPonto = registroPontoDTO.toEntity();
        RegistroPonto registroPontoSalvo = registroPontoRepository.save(registroPonto);
        return RegistroPontoDTO.fromEntity(registroPontoSalvo);
    }

    public RegistroPontoDTO atualizarRegistroPonto(Long id, RegistroPontoDTO registroPontoDTO) {
        Optional<RegistroPonto> optionalRegistroPonto = registroPontoRepository.findById(id);
        if (optionalRegistroPonto.isPresent()) {
            RegistroPonto registroPonto = registroPontoDTO.toEntity();
            registroPonto.setId(id);
            RegistroPonto registroPontoAtualizado = registroPontoRepository.save(registroPonto);
            return RegistroPontoDTO.fromEntity(registroPontoAtualizado);
        }
        return null;
    }

    public void deletarRegistroPonto(Long id) {
        registroPontoRepository.deleteById(id);
    }
}
