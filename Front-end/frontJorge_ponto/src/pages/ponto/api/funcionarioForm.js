import React, { useState } from 'react';
import { adicionarFuncionario } from './funcionarios';

const FuncionarioForm = () => {
  const [nome, setNome] = useState('');
  const [cpf, setCpf] = useState('');
  const [email, setEmail] = useState('');
  const [dataAdmissao, setDataAdmissao] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    const funcionarioDTO = {
      nome,
      cpf,
      email,
      dataAdmissao: new Date(dataAdmissao).toISOString().split('T')[0], // Formatando para ISO Date
    };
    try {
      const novoFuncionario = await adicionarFuncionario(funcionarioDTO);
      console.log('Funcionário adicionado com sucesso:', novoFuncionario);
      // Limpar campos após adicionar
      setNome('');
      setCpf('');
      setEmail('');
      setDataAdmissao('');
    } catch (error) {
      console.error('Erro ao adicionar funcionário:', error);
    }
  };

  return (
    <div>
      <h2>Adicionar Funcionário</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" value={nome} onChange={(e) => setNome(e.target.value)} placeholder="Nome" required />
        <input type="text" value={cpf} onChange={(e) => setCpf(e.target.value)} placeholder="CPF" required />
        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Email" required />
        <input type="date" value={dataAdmissao} onChange={(e) => setDataAdmissao(e.target.value)} placeholder="Data de Admissão" required />
        <button type="submit">Adicionar</button>
      </form>
    </div>
  );
};

export default FuncionarioForm;
