import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api',
  headers: {
    'Content-Type': 'application/json',
  },
});

export const adicionarFuncionario = async (funcionario) => {
  try {
    const response = await api.post('/funcionarios', funcionario);
    return response.data;
  } catch (error) {
    throw new Error(`Erro ao cadastrar funcionário: ${error}`);
  }
};

export const listarFuncionarios = async () => {
  try {
    const response = await api.get('/funcionarios');
    return response.data;
  } catch (error) {
    throw new Error(`Erro ao listar funcionários: ${error}`);
  }
};

