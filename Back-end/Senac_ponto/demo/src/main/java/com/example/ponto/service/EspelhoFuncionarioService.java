package com.example.ponto.service;

import com.example.ponto.dto.RegistroPontoDTO;
import com.example.ponto.models.domain.RegistroPonto;
import com.example.ponto.repository.RegistroPontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspelhoFuncionarioService {

    @Autowired
    private RegistroPontoRepository registroPontoRepository;

    public Page<RegistroPontoDTO> listarRegistrosPontoFuncionario(Long funcionarioId, Pageable pageable) {
        return registroPontoRepository.findByFuncionarioId(funcionarioId, pageable)
                .map(RegistroPontoDTO::fromEntity);
    }

    public Page<RegistroPontoDTO> listarRegistrosPontoFuncionarioPorData(Long funcionarioId, LocalDate data, Pageable pageable) {
        LocalDateTime startOfDay = data.atStartOfDay();
        LocalDateTime endOfDay = data.atTime(23, 59, 59);

        return registroPontoRepository.findByFuncionarioIdAndDataHoraBetween(funcionarioId, startOfDay, endOfDay, pageable)
                .map(RegistroPontoDTO::fromEntity);
    }

    public Page<RegistroPontoDTO> listarRegistrosPontoTodosFuncionarios(Pageable pageable) {
        return registroPontoRepository.findAll(pageable)
                .map(RegistroPontoDTO::fromEntity);
    }
}
