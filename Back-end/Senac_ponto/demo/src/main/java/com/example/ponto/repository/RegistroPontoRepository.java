package com.example.ponto.repository;

import com.example.ponto.models.domain.RegistroPonto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ponto.enterprise.CustomQuerydslPredicateExecutor;

import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;

@Repository
public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long>, CustomQuerydslPredicateExecutor<RegistroPonto> {

    Page<RegistroPonto> findAll(Pageable pageable);

    Page<RegistroPonto> findByFuncionarioId(Long funcionarioId, Pageable pageable);

    Page<RegistroPonto> findByFuncionarioIdAndDataHoraBetween(Long funcionarioId, LocalDateTime startDateTime, LocalDateTime endDateTime, Pageable pageable);
}
