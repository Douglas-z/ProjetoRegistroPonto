package com.example.ponto.service;

import com.example.ponto.enterprise.exception.NotFoundException;
import com.example.ponto.models.domain.HorarioTrabalho;
import com.example.ponto.repository.HorarioTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioTrabalhoService {

    private final HorarioTrabalhoRepository horarioTrabalhorepository;

    @Autowired
    public HorarioTrabalhoService(HorarioTrabalhoRepository repository) {
        this.horarioTrabalhorepository = repository;
    }

    public HorarioTrabalho salvar(HorarioTrabalho entity) {
        return horarioTrabalhorepository.save(entity);
    }

    public Page<HorarioTrabalho> buscaTodos(Pageable pageable) {
        var list = horarioTrabalhorepository.findAll(pageable);

        if (list.isEmpty()){
            throw new NotFoundException("Nenhum Horario de trabalho encontrado");
        }

        return list;
    }

    public Optional<HorarioTrabalho> buscaPorId(Long id) {
        return horarioTrabalhorepository.findById(id);
    }
    public long calcularHorasTrabalhadas(Long id) {
        HorarioTrabalho horarioTrabalho = horarioTrabalhorepository.findById(id).orElse(null);
        if (horarioTrabalho != null && horarioTrabalho.getHoraEntrada() != null && horarioTrabalho.getHoraSaida() != null) {
            // Calcula a duração entre a hora de entrada e a hora de saída
            Duration duracaoTrabalho = Duration.between(horarioTrabalho.getHoraEntrada(), horarioTrabalho.getHoraSaida());

            // Subtrai a duração do intervalo de descanso (1 hora e meia) da duração total de trabalho
            duracaoTrabalho = duracaoTrabalho.minus(Duration.ofMinutes(90));

            // Define o limite padrão de horas por dia
            long limiteHorasPorDia = 8;

            // Verifica se a duração total de trabalho é menor ou igual ao limite de horas por dia
            if (duracaoTrabalho.toHours() <= limiteHorasPorDia) {
                // Se for, retorna a duração total de trabalho em horas
                return duracaoTrabalho.toHours();
            } else {
                // Calcula as horas extras
                long horasExtras = duracaoTrabalho.toHours() - limiteHorasPorDia;

                // Limita as horas extras a um máximo de duas horas
                if (horasExtras > 2) {
                    horasExtras = 2;
                }

                // Retorna as horas extras
                return horasExtras;
            }
        }
        return 0; // Retorna 0 se não houver dados suficientes para calcular as horas trabalhadas
    }

    @Transactional
    public HorarioTrabalho alterar(Long id, HorarioTrabalho alterado) {
        return horarioTrabalhorepository.findById(id)
                .map(horarioTrabalho -> {
                    horarioTrabalho.setHoraEntrada(alterado.getHoraEntrada());
                    horarioTrabalho.setHoraSaida(alterado.getHoraSaida());
                    horarioTrabalho.setHoraIntervalo(alterado.getHoraIntervalo());
                    horarioTrabalho.setDiasTrabalhados(alterado.getDiasTrabalhados());
                    return horarioTrabalhorepository.save(horarioTrabalho);
                })
                .orElseThrow(() -> new RuntimeException("Horário de trabalho não encontrado"));
    }

    public void remover(Long id) {
        horarioTrabalhorepository.deleteById(id);
    }
}



