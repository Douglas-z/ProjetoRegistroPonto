import React from 'react';
import FuncionariosList from './components/FuncionariosList';
import FuncionarioForm from './components/FuncionarioForm';
import RegistrosList from './components/RegistrosList';

function App() {
  return (
    <div className="App">
      <FuncionariosList />
      <FuncionarioForm />
      <RegistrosList />
    </div>
  );
}

export default App;
