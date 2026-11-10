import type { IInvestimento } from "../types/IInvestimento";

interface IInvestimentoItemProps {
    investimento: IInvestimento;
    onExcluir: (idInvestimento: number) => void;
    onEditar: (novoInvestimento: IInvestimento) => void;
}

function InvestimentoItem({ investimento, onExcluir, onEditar }: IInvestimentoItemProps) {

    return (
        <li>    
            Id: {investimento.idUsuario} |
            Nome: {investimento.nmInvestimento} |
            Tipo: {investimento.tpInvestimento} |
            Valor Investido: R${investimento.vlInvestido} |
            Valor Atual: R${investimento.vlAtual} |
            Data: {investimento.dtInvestimento} |

            <button onClick={() => onExcluir(investimento.idInvestimento)}>Excluir</button>
            <button onClick={() => onEditar(investimento)}>Editar</button>
        </li>
    );
}
export default InvestimentoItem;