// FuncionarioForm.jsx

import React, { useState } from 'react';
import axios from 'axios';

const FuncionarioForm = () => {
  const [nome, setNome] = useState('');
  const [cpf, setCpf] = useState('');
  const [email, setEmail] = useState('');
  const [dataAdmissao, setDataAdmissao] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/api/funcionarios', {
        nome,
        cpf,
        email,
        dataAdmissao,
      });
      console.log('Funcionário cadastrado com sucesso:', response.data);
      // Lógica para feedback ao usuário (redirecionamento ou mensagem de sucesso)
    } catch (error) {
      console.error('Erro ao cadastrar funcionário:', error);
      // Lógica para feedback ao usuário em caso de erro
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Nome"
        value={nome}
        onChange={(e) => setNome(e.target.value)}
        required
      />
      <input
        type="text"
        placeholder="CPF"
        value={cpf}
        onChange={(e) => setCpf(e.target.value)}
        required
      />
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        required
      />
      <input
        type="date"
        placeholder="Data de Admissão"
        value={dataAdmissao}
        onChange={(e) => setDataAdmissao(e.target.value)}
        required
      />
      <button type="submit">Cadastrar Funcionário</button>
    </form>
  );
};

export default FuncionarioForm;
