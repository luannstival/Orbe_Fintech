import { useState } from "react";
import type { IInstituicaoBancaria } from "../types/IInstituicaoBancaria";
import type { INovoInstituicaoBancaria } from "../types/INovoInstituicaoBancaria";

interface IInstituicaoBancariaFormProps {
    
    onCadastrar: (instituicao: INovoInstituicaoBancaria) => void;
    instituicaoInicial?: IInstituicaoBancaria;
    onAtualizar: (instituicao: IInstituicaoBancaria) => void;
}

function InstituicaoBancariaForm({ onCadastrar, instituicaoInicial, onAtualizar }: IInstituicaoBancariaFormProps) {

    const [nmInstituicao, setNmInstituicao] = useState(instituicaoInicial?.nmInstituicao ?? "");
    const [cdCompe, setCdCompe] = useState(instituicaoInicial?.cdCompe ?? "");

    function enviar(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();
        if (instituicaoInicial) {
            onAtualizar?.({...instituicaoInicial, nmInstituicao, cdCompe});
        }else {
            onCadastrar({nmInstituicao, cdCompe});
        }
    }

    return (
        <form onSubmit={enviar}>
            <input placeholder="Nome" value={nmInstituicao} onChange={(e) => setNmInstituicao(e.target.value)} />
            <input placeholder="Código COMPE" value={cdCompe} onChange={(e) => setCdCompe(e.target.value)} />
            <button type="submit">Cadastrar</button>
        </form>
    );
}
export default InstituicaoBancariaForm;