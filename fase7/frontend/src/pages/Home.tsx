import { Link } from "react-router-dom";

function Home() {
  return (
    <div className="home">
      <h1>Bem vindo ao Orbe Fintech</h1>
      <p>
        Escolha abaixo a opção desejada para navegar pelo sistema:
      </p>
      <ul>
        <li><Link to="/usuarios">Usuário</Link></li>
        <li><Link to="/investimentos">Investimento</Link></li>
        <li><Link to="/instituicoes">Instituição Bancária</Link></li>
      </ul>
    </div>
  );
}
export default Home;