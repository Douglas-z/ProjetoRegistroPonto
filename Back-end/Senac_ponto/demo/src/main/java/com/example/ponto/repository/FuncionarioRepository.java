package com.example.ponto.repository;

import com.example.ponto.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ponto.enterprise.CustomQuerydslPredicateExecutor;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>, CustomQuerydslPredicateExecutor<Funcionario> {
}
