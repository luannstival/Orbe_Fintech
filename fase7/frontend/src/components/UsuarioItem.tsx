import type { IUsuario } from "../types/IUsuario";

interface IUsuarioItemProps {
  usuario: IUsuario;
  onExcluir: (idUsuario: number) => void;
  onEditar: (novoUsuario: IUsuario) => void;
}

function UsuarioItem({ usuario, onExcluir, onEditar}: IUsuarioItemProps) {

  return (
    <li>
      {usuario.nmUsuario} - {usuario.dsEmail}
      <button onClick={() => onExcluir(usuario.idUsuario)}>Excluir</button>
      <button onClick={() => onEditar(usuario)}>Editar</button>
    </li>
  );
}
export default UsuarioItem;