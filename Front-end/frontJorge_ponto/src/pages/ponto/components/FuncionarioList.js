import React, { useEffect, useState } from 'react';
import { listarFuncionarios } from '../api/funcionarios';

const FuncionariosList = () => {
  const [funcionarios, setFuncionarios] = useState([]);

  useEffect(() => {
    async function fetchFuncionarios() {
      try {
        const data = await listarFuncionarios();
        setFuncionarios(data);
      } catch (error) {
        console.error('Erro ao buscar funcionários:', error);
      }
    }
    fetchFuncionarios();
  }, []);

  return (
    <div>
      <h2>Lista de Funcionários</h2>
      <ul>
        {funcionarios.map(funcionario => (
          <li key={funcionario.id}>{funcionario.nome}</li>
        ))}
      </ul>
    </div>
  );
};

export default FuncionariosList;
