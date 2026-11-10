import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import ErrorPage from './pages/ErrorPage';
import Usuario from './pages/Usuario';
import Investimento from './pages/Investimento';
import InstituicaoBancaria from './pages/InstituicaoBancaria';
import Menu from './components/Menu';
import Login from './pages/Login';
import Cadastro from './pages/Cadastro';

function App() {
  
  return (
    <div>
      <Menu />
      <Routes>
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/" element={<Login />} />
        <Route path="/home" element={<Home />} />
        <Route path="/usuarios" element={<Usuario />} />
        <Route path="/investimentos" element={<Investimento />} />
        <Route path="/instituicoes" element={<InstituicaoBancaria />} />
        <Route path="*" element={<ErrorPage />} />
      </Routes>
    </div>
  );
}
export default App;