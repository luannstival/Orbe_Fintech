import { useEffect, useState } from "react";
import type { IUsuario } from "../types/IUsuario";
import UsuarioItem from "../components/UsuarioItem";
import UsuarioForm from "../components/UsuarioForm";
import type { INovoUsuario } from "../types/INovoUsuario";
import { Link } from "react-router-dom";

function Usuario() {

  const [usuarios, setUsuarios] = useState<IUsuario[]>([]);
  const [emEdicao, setEmEdicao] = useState<IUsuario | null>(null);

  useEffect(() => {
    fetch(`${import.meta.env.VITE_API_URL}/usuarios`)
      .then((resposta) => resposta.json())
      .then((dados) => setUsuarios(dados));
  }, []);

  function cadastrarUsuario(usuario: INovoUsuario) {
    fetch(`${import.meta.env.VITE_API_URL}/usuarios`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(usuario),
    })
      .then((resposta) => {
        if (resposta.ok) {
          resposta.json().then((novo) => setUsuarios([...usuarios, novo]));
        }
      });
  }

  function editarUsuario(usuario: IUsuario) {
    setEmEdicao(usuario);
  }

  function atualizarUsuario(id: number, dados: INovoUsuario) {
    fetch(`${import.meta.env.VITE_API_URL}/usuarios/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(dados),
    }).then((resposta) => {
      if (resposta.ok) {
        resposta.json().then((atualizado) => {
          setUsuarios(usuarios.map((u) => (u.idUsuario === id ? atualizado : u)));
          setEmEdicao(null);
        });
      }
    });
  }

  function excluirUsuario(id: number) {
    fetch(`${import.meta.env.VITE_API_URL}/usuarios/${id}`, { method: "DELETE" })
      .then((resposta) => {
        if (resposta.ok) {
          setUsuarios(usuarios.filter((u) => u.idUsuario !== id));
        }
      });
  }

  return (
    
    <div className="usuarios">
      <h1>Usuários</h1>
      {emEdicao && <p>Editando: {emEdicao.nmUsuario}</p>}
      <UsuarioForm
        onAtualizar={(dados) => {
          if (emEdicao) atualizarUsuario(emEdicao.idUsuario, dados);
        }}
        onCadastrar={cadastrarUsuario}
        usuarioInicial={emEdicao ?? undefined}
        key={emEdicao?.idUsuario ?? 0}
      />
      <ul>
        <p>{usuarios.length} Usuários cadastrados</p>
        {usuarios.map((u) => (<UsuarioItem key={u.idUsuario} usuario={u} onExcluir={excluirUsuario} onEditar={editarUsuario} />))}
      </ul>
      <button><Link to="/home">Voltar para Home</Link></button>
    </div>
  );
}
export default Usuario;