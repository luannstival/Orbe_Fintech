import { useState } from "react";
import type { INovoUsuario } from "../types/INovoUsuario";
import { useNavigate } from "react-router-dom";
import UsuarioForm from "../components/UsuarioForm";


function Cadastro() {

    const navigate = useNavigate();
    const [erro, setErro] = useState("");


    function cadastrar(usuario: INovoUsuario) {
        fetch(`${import.meta.env.VITE_API_URL}/usuarios`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(usuario),
        }).then((resposta) => {
            if (resposta.ok) {
                navigate("/");
            } else {
                setErro("Não foi possível criar a conta. CPF ou e-mail já cadastrado?");
            }
        });
    }

    return (
        <div>
        <h1>Criar Conta</h1>
        <p>Preencha os dados abaixo para criar sua conta:</p>
        {erro && <p style={{ color: "red" }}>{erro}</p>}
        <UsuarioForm onCadastrar={cadastrar} onAtualizar={() => {}}>
            <button type="button" onClick={() => navigate("/")}>Voltar para Login</button>
        </UsuarioForm>
        </div>
    );
}
export default Cadastro;