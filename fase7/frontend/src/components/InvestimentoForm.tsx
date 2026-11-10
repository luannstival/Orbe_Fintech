import { useState } from "react";
import type { IInvestimento } from "../types/IInvestimento";
import type { INovoInvestimento } from "../types/INovoInvestimento";

interface IInvestimentoFormProps {

    onCadastrar: (investimento: INovoInvestimento) => void;
    investimentoInicial?: IInvestimento;
    onAtualizar: (investimento: INovoInvestimento) => void

}

function InvestimentoForm({ onCadastrar, investimentoInicial, onAtualizar }: IInvestimentoFormProps) {

    const [idUsuario, setIdUsuario] = useState(investimentoInicial?.idUsuario ?? 0);
    const [nmInvestimento, setNmInvestimento] = useState(investimentoInicial?.nmInvestimento ?? "");
    const [tpInvestimento, setTpInvestimento] = useState(investimentoInicial?.tpInvestimento ?? "");
    const [vlInvestido, setVlInvestido] = useState(investimentoInicial?.vlInvestido ?? "");
    const [vlAtual, setVlAtual] = useState(investimentoInicial?.vlAtual ?? "");
    const [dtInvestimento, setDtInvestimento] = useState(investimentoInicial?.dtInvestimento ?? "");

    function enviar(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();
        const investimentoAtualizado: INovoInvestimento = {
            nmInvestimento,
            tpInvestimento,
            vlInvestido: Number(vlInvestido),
            vlAtual: Number(vlAtual),
            dtInvestimento,
            idUsuario            
        };
        if (investimentoInicial) {
            onAtualizar?.({ ...investimentoInicial, ...investimentoAtualizado });
        } else {
            onCadastrar(investimentoAtualizado);
        }
    }

    return (
        <form onSubmit={enviar}>
            <input placeholder="Id Usuário" value={idUsuario} onChange={(e) => setIdUsuario(Number(e.target.value))} />
            <input placeholder="Nome" value={nmInvestimento} onChange={(e) => setNmInvestimento(e.target.value)} />
            <input placeholder="Tipo" value={tpInvestimento} onChange={(e) => setTpInvestimento(e.target.value)} />
            <input placeholder="Valor Investido" value={vlInvestido} onChange={(e) => setVlInvestido(e.target.value)} />
            <input placeholder="Valor Atual" value={vlAtual} onChange={(e) => setVlAtual(e.target.value)} />
            <input placeholder="Data de Investimento" type="date" value={dtInvestimento} onChange={(e) => setDtInvestimento(e.target.value)} />
            <button type="submit">Cadastrar</button>
        </form>
    );
}
export default InvestimentoForm;