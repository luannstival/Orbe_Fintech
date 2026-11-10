export interface INovoInvestimento {
  idUsuario: number;
  nmInvestimento: string;
  tpInvestimento: string;
  vlInvestido: number;
  vlAtual: number | null;
  dtInvestimento: string;
}
