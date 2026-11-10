import { useState } from "react";
import { useNavigate } from 'react-router-dom'
import type { IUsuario } from "../types/IUsuario";

function Login() {

    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const navigate = useNavigate();
    const [erro, setErro] = useState("");


    function enviarLogin(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();
        fetch(`${import.meta.env.VITE_API_URL}/usuarios`)
            .then((resposta) => resposta.json())
            .then((usuarios: IUsuario[]) => {
                const encontrado = usuarios.find((u) => u.dsEmail === email && u.dsSenha === senha);
                if (encontrado) {
                    navigate("/home");
                } else {
                    setErro("E-mail ou senha inválidos.");
                }
            });
        console.log("Email:", email);
    }

    return (
        <div>
            <h1>Página de Login </h1>
            <p>Digite e-mail e senha cadastrados para acessar o sistema:</p>
            Não possui conta? <a href="/cadastro">Clique aqui</a> para realizar o cadastro.<br />
            <br />
            <form onSubmit={enviarLogin}>
                <div>
                    <label htmlFor="email">Email:</label>
                    <input
                        type="email"
                    id="email"
                    value={email}
                    placeholder="E-mail"
                    onChange={(e) => setEmail(e.target.value)}
                />
            </div>
            <div>
                <label htmlFor="senha">Senha:</label>
                <input
                    id="senha"
                    type="password" value={senha}
                    placeholder="Senha"
                    onChange={(e) => setSenha(e.target.value)}
                />
            </div>
            <button type="submit">Entrar</button>
            {erro && <p role="alert">{erro}</p>}
        </form>
        </div>
    );
}
export default Login;