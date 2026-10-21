# Atividade 2 – Fase 6: Java + Oracle (DAO)

**Curso:** Análise e Desenvolvimento de Sistemas – FIAP
**Aluno:** Luann Stival (RM572719)
**Projeto base:** Orbe Fintech

## O que foi feito

Integração de três entidades do sistema com o banco Oracle da FIAP, usando JDBC e o padrão DAO. Cada entidade tem:

- uma classe de modelo (atributos privados, construtores, getters e setters);
- uma classe DAO com os métodos `insert()` (grava um registro) e `getAll()` (consulta todos os registros e devolve uma lista de objetos);
- uma classe de teste com `main()` que insere 5 novos registros e depois exibe a listagem.

| Entidade | Tabela | DAO | Teste |
|---|---|---|---|
| Usuario | `T_USUARIO` | `UsuarioDao` | `TesteUsuario` |
| Investimento | `T_INVESTIMENTO` | `InvestimentoDao` | `TesteInvestimento` |
| InstituicaoBancaria | `T_INSTITUICAO_BANCARIA` | `InstituicaoBancariaDao` | `TesteInstituicaoBancaria` |

As exceções (`SQLException`) são tratadas com `try-catch` nas classes de teste, que exibem a mensagem do erro no console.

## Tecnologias

- Java 21
- Maven (driver JDBC `ojdbc8`)
- Oracle (instância da FIAP)
- IntelliJ IDEA

## Estrutura

```
src/main/java/br/com/fiap/
├── dao/      UsuarioDao, InvestimentoDao, InstituicaoBancariaDao
├── factory/  ConnectionFactory
├── model/    Usuario, Investimento, InstituicaoBancaria
└── view/     TesteUsuario, TesteInvestimento, TesteInstituicaoBancaria
```

## Como executar

1. Abrir o projeto no IntelliJ e aguardar o Maven carregar as dependências.
2. Conferir a conexão em `ConnectionFactory` (URL, usuário e senha da instância Oracle da FIAP).
3. Executar o `main()` de cada classe de teste, **uma vez cada**:
    1. `TesteUsuario`
    2. `TesteInstituicaoBancaria`
    3. `TesteInvestimento`

Cada teste exibe a mensagem de sucesso de cada inserção e, em seguida, a lista completa de registros da tabela.

## Observações

- Os testes inserem **dados fictícios fixos**. Executar `TesteUsuario` ou `TesteInstituicaoBancaria` uma segunda vez gera o erro `ORA-00001` (violação de restrição única), pois CPF, e-mail e código COMPE não podem se repetir. O erro é tratado pelo `try-catch` e o programa não é interrompido. Executar `TesteInvestimento` de novo não gera erro, mas duplica os investimentos.
- Os investimentos de teste usam os usuários originais da tabela (ids 1 a 4), então `TesteInvestimento` não depende da execução do `TesteUsuario`.
- O campo `vl_atual` de `Investimento` pode ser nulo (valor ainda não calculado) e é tratado como `Double` no Java.
- Os dados de teste foram removidos do banco antes da entrega, para que a execução mostre as inserções acontecendo.