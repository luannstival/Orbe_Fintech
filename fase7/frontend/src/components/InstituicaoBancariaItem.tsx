import type { IInstituicaoBancaria } from "../types/IInstituicaoBancaria";

interface IInstituicaoBancariaItemProps {
  instituicao: IInstituicaoBancaria;
  onExcluir: (idInstituicao: number) => void;
  onEditar: (novaInstituicao: IInstituicaoBancaria) => void;
}

function InstituicaoBancariaItem({ instituicao, onExcluir, onEditar }: IInstituicaoBancariaItemProps) {

  return (
    <li>
      Nome: {instituicao.nmInstituicao} | Código Compe: {instituicao.cdCompe}
      <button onClick={() => onExcluir(instituicao.idInstituicao)}>Excluir</button>
      <button onClick={() => onEditar(instituicao)}>Editar</button>
    </li>
  );
}
export default InstituicaoBancariaItem;