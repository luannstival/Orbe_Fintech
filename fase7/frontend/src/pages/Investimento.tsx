import { useEffect, useState } from "react";
import type { IInvestimento } from "../types/IInvestimento";
import InvestimentoItem from "../components/InvestimentoItem";
import InvestimentoForm from "../components/InvestimentoForm";
import type { INovoInvestimento } from "../types/INovoInvestimento";
import { Link } from "react-router-dom";

function Investimento() {

    const [investimentos, setInvestimentos] = useState<IInvestimento[]>([]);
    const [emEdicao, setEmEdicao] = useState<IInvestimento | null>(null);


    useEffect(() => {
        fetch(`${import.meta.env.VITE_API_URL}/investimentos`)
            .then((resposta) => resposta.json())
            .then((dados) => setInvestimentos(dados));
    }, []);

    function cadastrarInvestimento(investimento: INovoInvestimento) {
        fetch(`${import.meta.env.VITE_API_URL}/investimentos`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(investimento),
        })
            .then((resposta) => {
                if (resposta.ok) {
                    resposta.json().then((novo) => setInvestimentos([...investimentos, novo]));
                }
            });
    }

    function editarInvestimento(investimento: IInvestimento) {
        setEmEdicao(investimento);
    }

    function atualizarInvestimento(id: number, dados: INovoInvestimento) {
        fetch(`${import.meta.env.VITE_API_URL}/investimentos/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(dados),
        }).then((resposta) => {
            if (resposta.ok) {
                resposta.json().then((atualizado) => {
                    setInvestimentos(investimentos.map((i) => (i.idInvestimento === id ? atualizado : i)));
                    setEmEdicao(null);
                });
            }
        });
    }

    function excluirInvestimento(id: number) {
        fetch(`${import.meta.env.VITE_API_URL}/investimentos/${id}`, { method: "DELETE" })
            .then((resposta) => {
                if (resposta.ok) {
                    setInvestimentos(investimentos.filter((i) => i.idInvestimento !== id));
                }
            });
    }
    return (

        <div className="investimentos">
            <h1>Investimentos</h1>
            <p>{investimentos.length} Investimentos cadastrados</p>
            {emEdicao && <p>Editando: {emEdicao.nmInvestimento}</p>}
            <InvestimentoForm
                onAtualizar={(dados) => {
                    if (emEdicao) atualizarInvestimento(emEdicao.idInvestimento, dados);
                }}
                onCadastrar={cadastrarInvestimento}
                investimentoInicial={emEdicao ?? undefined}
                key={emEdicao?.idInvestimento ?? 0}
            />
            <ul>
                {investimentos.map((i) => (<InvestimentoItem key={i.idInvestimento} investimento={i} onExcluir={excluirInvestimento} onEditar={editarInvestimento} />))}
            </ul>
            <button><Link to="/home">Voltar para Home</Link></button>
        </div>

    );
}
export default Investimento;