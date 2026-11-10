import { useState } from "react";
import type { IUsuario } from "../types/IUsuario";
import type { INovoUsuario } from "../types/INovoUsuario";

interface IUsuarioFormProps {
    
    onCadastrar: (usuario: INovoUsuario) => void;
    usuarioInicial?: IUsuario;
    onAtualizar: (usuario: INovoUsuario) => void
    children?: React.ReactNode;

}

function UsuarioForm({ onCadastrar, usuarioInicial, onAtualizar, children }: IUsuarioFormProps) {

    const [nmUsuario, setNmUsuario] = useState(usuarioInicial?.nmUsuario ?? "");
    const [nrCpf, setNrCpf] = useState(usuarioInicial?.nrCpf ?? "");
    const [dsEmail, setDsEmail] = useState(usuarioInicial?.dsEmail ?? "");
    const [dtNascimento, setDtNascimento] = useState(usuarioInicial?.dtNascimento ?? "");
    const [dsSenha, setDsSenha] = useState(usuarioInicial?.dsSenha ?? "");

    function enviar(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();
        if (usuarioInicial) {
            onAtualizar?.({...usuarioInicial, nmUsuario, nrCpf, dsEmail, dtNascimento, dsSenha});
        }else {
            onCadastrar({nmUsuario, nrCpf, dsEmail, dtNascimento, dsSenha});
        }
    }

    return (
        <form onSubmit={enviar}>
            <input placeholder="Nome" value={nmUsuario} onChange={(e) => setNmUsuario(e.target.value)} />
            <input placeholder="CPF" value={nrCpf} onChange={(e) => setNrCpf(e.target.value)} />
            <input placeholder="E-mail" value={dsEmail} onChange={(e) => setDsEmail(e.target.value)} />
            <input placeholder="Data de Nascimento" type="date" value={dtNascimento} onChange={(e) => setDtNascimento(e.target.value)} />
            <input placeholder="Senha" type="password" value={dsSenha} onChange={(e) => setDsSenha(e.target.value)} />
            <div className="form-acoes">
                {children}
                <button type="submit">Cadastrar</button>
            </div>
        </form>
    );
}
export default UsuarioForm;