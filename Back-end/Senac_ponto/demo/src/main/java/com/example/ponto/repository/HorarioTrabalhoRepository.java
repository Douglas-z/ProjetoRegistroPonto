package com.example.ponto.repository;

import com.example.ponto.models.domain.HorarioTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ponto.enterprise.CustomQuerydslPredicateExecutor;

@Repository
public interface HorarioTrabalhoRepository extends JpaRepository<HorarioTrabalho, Long>, CustomQuerydslPredicateExecutor<HorarioTrabalho> {
}
