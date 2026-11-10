import { Link } from 'react-router-dom';

function Menu() {
  return (
    <nav>
      <Link to="/">Login</Link>
      <Link to="/cadastro">Cadastro</Link>

    </nav>
  );
}
export default Menu;