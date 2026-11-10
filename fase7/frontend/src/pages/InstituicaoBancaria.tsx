import { useEffect, useState } from "react";
import type { IInstituicaoBancaria } from "../types/IInstituicaoBancaria";
import type { INovoInstituicaoBancaria } from "../types/INovoInstituicaoBancaria";
import InstituicaoBancariaItem from "../components/InstituicaoBancariaItem";
import InstituicaoBancariaForm from "../components/InstituicaoBancariaForm";
import { Link } from "react-router-dom";

function InstituicaoBancaria() {

  const [instituicaoBancaria, setInstituicaoBancaria] = useState<IInstituicaoBancaria[]>([]);
  const [emEdicao, setEmEdicao] = useState<IInstituicaoBancaria | null>(null);

  useEffect(() => {
    fetch(`${import.meta.env.VITE_API_URL}/instituicoes`)
      .then((resposta) => resposta.json())
      .then((dados) => setInstituicaoBancaria(dados));
  }, []);

  function cadastrarInstituicaoBancaria(instituicao: INovoInstituicaoBancaria) {
    fetch(`${import.meta.env.VITE_API_URL}/instituicoes`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(instituicao),
    })
      .then((resposta) => {
        if (resposta.ok) {
          resposta.json().then((novo) => setInstituicaoBancaria([...instituicaoBancaria, novo]));
        }
      });
  }

  function editarInstituicaoBancaria(instituicao: IInstituicaoBancaria) {
    setEmEdicao(instituicao);
  }

  function atualizarInstituicaoBancaria(id: number, dados: INovoInstituicaoBancaria) {
    fetch(`${import.meta.env.VITE_API_URL}/instituicoes/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(dados),
    }).then((resposta) => {
      if (resposta.ok) {
        resposta.json().then((atualizado) => {
          setInstituicaoBancaria(instituicaoBancaria.map((instituicao) => (instituicao.idInstituicao === id ? atualizado : instituicao)));
          setEmEdicao(null);
        });
      }
    });
  }

  function excluirInstituicaoBancaria(id: number) {
    fetch(`${import.meta.env.VITE_API_URL}/instituicoes/${id}`, { method: "DELETE" })
      .then((resposta) => {
        if (resposta.ok) {
          setInstituicaoBancaria((instituicoes) =>
            instituicoes.filter((instituicao) => instituicao.idInstituicao !== id)
          );
        }
      });
  }
  return (

    <div className="instituicoes">
      <h1>Instituições Bancárias</h1>
      <p>{instituicaoBancaria.length} Instituições cadastradas</p>
      {emEdicao && <p>Editando: {emEdicao.nmInstituicao}</p>}
      <InstituicaoBancariaForm
        onAtualizar={(dados: INovoInstituicaoBancaria) => {
          if (emEdicao) atualizarInstituicaoBancaria(emEdicao.idInstituicao, dados);
        }}
        onCadastrar={cadastrarInstituicaoBancaria}
        instituicaoInicial={emEdicao ?? undefined}
        key={emEdicao?.idInstituicao ?? 0}
      />
      <ul>
        {instituicaoBancaria.map((instituicao) => (<InstituicaoBancariaItem key={instituicao.idInstituicao} instituicao={instituicao} onExcluir={excluirInstituicaoBancaria} onEditar={editarInstituicaoBancaria} />))}
      </ul>
      <button><Link to="/home">Voltar para Home</Link></button>

    </div>

  );
}
export default InstituicaoBancaria;