import api from './apiConfig';

export const listarRegistrosPonto = async () => {
  try {
    const response = await api.get('/registroponto');
    return response.data;
  } catch (error) {
    console.error('Erro ao buscar registros de ponto:', error);
    throw error;
  }
};
