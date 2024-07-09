package com.example.ponto.service;

import com.example.ponto.dto.FuncionarioDTO;
import com.example.ponto.models.Funcionario;
import com.example.ponto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream()
                .map(FuncionarioDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public FuncionarioDTO buscarFuncionarioPorId(Long id) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
        return optionalFuncionario.map(FuncionarioDTO::fromEntity).orElse(null);
    }

    public FuncionarioDTO adicionarFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioDTO.toEntity(funcionarioDTO);
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        return FuncionarioDTO.fromEntity(funcionarioSalvo);
    }

    public FuncionarioDTO atualizarFuncionario(Long id, FuncionarioDTO funcionarioDTO) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
        if (optionalFuncionario.isPresent()) {
            Funcionario funcionario = funcionarioDTO.toEntity(funcionarioDTO);
            funcionario.setId(id);
            Funcionario funcionarioAtualizado = funcionarioRepository.save(funcionario);
            return FuncionarioDTO.fromEntity(funcionarioAtualizado);
        }
        return null;
    }

    public boolean deletarFuncionario(Long id) {
        if (funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
