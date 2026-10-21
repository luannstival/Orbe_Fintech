-- ORBE FINTECH - FASE 6
-- Atividade: cadastro, alteracao, consultas e dashboard (Oracle)
-- Base: script_fintech_corrigido.sql + Orbe_Fintech_Carga_Inicial.sql.
-- Os identificadores abaixo foram conferidos na base usada na atividade:
-- Ana: usuario 1, ultima despesa 8, ultimo investimento 3;
-- Diego: usuario 4, conta 5, receita 13, despesa 14, investimento 6.
-- Execute os cadastros somente sobre a carga inicial, antes de Diego existir.
-- Este arquivo registra os comandos executados e validados; os INSERTs de
-- Diego nao devem ser repetidos na base atual.
-- Os dados pessoais e a credencial abaixo sao ficticios e de teste.

-- ================================================================
-- 1. CADASTRO
-- ================================================================

-- 1.1 Cadastrar um novo usuario.
-- ID_USUARIO e gerado pelo Oracle; DT_NASCIMENTO e opcional.
INSERT INTO T_USUARIO (
    NM_USUARIO, NR_CPF, DS_EMAIL, DS_SENHA
)
VALUES (
    'Diego Almeida Costa', '98765432100',
    'diego.costa@orbe.test', 'credencial_ficticia_diego_2026'
);

-- 1.2 Cadastrar a conta bancaria do usuario 4 na instituicao 1.
-- Os valores padrao sao VL_SALDO = 0 e ST_CONTA = 'ATIVA'.
INSERT INTO T_CONTA_BANCARIA (
    ID_USUARIO, ID_INSTITUICAO, NR_AGENCIA, NR_CONTA, TP_CONTA
)
VALUES (
    4, 1, '0456', '24680-3', 'CORRENTE'
);

-- 1.3 Cadastrar receita (ENTRADA) do usuario 4.
-- Os SELECTs localizam os IDs reais de conta e categoria.
INSERT INTO T_TRANSACAO (
    ID_USUARIO, ID_CONTA, ID_CATEGORIA,
    VL_TRANSACAO, TP_MOVIMENTACAO, TP_REGISTRO, DS_TRANSACAO
)
VALUES (
    4,
    (SELECT ID_CONTA
       FROM T_CONTA_BANCARIA
      WHERE ID_USUARIO = 4
        AND ID_INSTITUICAO = 1
        AND NR_AGENCIA = '0456'
        AND NR_CONTA = '24680-3'),
    (SELECT ID_CATEGORIA
       FROM T_CATEGORIA_TRANSACAO
      WHERE NM_CATEGORIA = 'Salário'),
    3500.00, 'ENTRADA', 'BANCARIO', 'Salário de Diego'
);

-- 1.4 Cadastrar despesa (SAIDA) do usuario 4.
-- ID_CONTA e NULL porque o pagamento foi feito em dinheiro.
INSERT INTO T_TRANSACAO (
    ID_USUARIO, ID_CONTA, ID_CATEGORIA,
    VL_TRANSACAO, TP_MOVIMENTACAO, TP_REGISTRO, DS_TRANSACAO
)
VALUES (
    4,
    NULL,
    (SELECT ID_CATEGORIA
       FROM T_CATEGORIA_TRANSACAO
      WHERE NM_CATEGORIA = 'Transporte'),
    85.00, 'SAIDA', 'MANUAL', 'Transporte pago em dinheiro'
);

-- 1.5 Cadastrar investimento do usuario 4.
INSERT INTO T_INVESTIMENTO (
    ID_USUARIO, NM_INVESTIMENTO, TP_INVESTIMENTO,
    VL_INVESTIDO, DT_INVESTIMENTO
)
VALUES (
    4, 'CDB Horizonte Inicial', 'CDB',
    500.00, TO_DATE('28/09/2026', 'DD/MM/YYYY')
);

COMMIT;

-- ================================================================
-- 2. ALTERACAO
-- ================================================================

-- 2.1 Alterar usuario pelo seu ID.
UPDATE T_USUARIO
   SET NM_USUARIO = 'Diego Almeida Costa Neto',
       DS_EMAIL = 'diego.costa.neto@orbe.test'
 WHERE ID_USUARIO = 4;

-- 2.2 Alterar receita pelos IDs do usuario e da transacao.
UPDATE T_TRANSACAO
   SET VL_TRANSACAO = 3650.00,
       DS_TRANSACAO = 'Salário de Diego - valor corrigido'
 WHERE ID_TRANSACAO = 13
   AND ID_USUARIO = 4
   AND TP_MOVIMENTACAO = 'ENTRADA';

-- 2.3 Alterar despesa pelos IDs do usuario e da transacao.
UPDATE T_TRANSACAO
   SET VL_TRANSACAO = 90.00,
       DS_TRANSACAO = 'Transporte pago em dinheiro - valor corrigido'
 WHERE ID_TRANSACAO = 14
   AND ID_USUARIO = 4
   AND TP_MOVIMENTACAO = 'SAIDA';

-- 2.4 Alterar investimento pelos IDs do usuario e do investimento.
UPDATE T_INVESTIMENTO
   SET VL_ATUAL = 510.00
 WHERE ID_INVESTIMENTO = 6
   AND ID_USUARIO = 4;

COMMIT;

-- ================================================================
-- 3. CONSULTAS SIMPLES
-- ================================================================

-- 3.1 Consultar usuario por ID. A senha fica fora do resultado.
SELECT ID_USUARIO    "ID do Usuário (PK)",
       NM_USUARIO    "Nome",
       NR_CPF        "CPF",
       DS_EMAIL      "E-mail",
       DT_NASCIMENTO "Data de Nascimento"
  FROM T_USUARIO
 WHERE ID_USUARIO = 4;

-- 3.2 Consultar despesa pelos IDs do usuario e da transacao.
-- ID_CONTA sera NULL porque esta despesa foi paga em dinheiro.
SELECT ID_TRANSACAO "ID da Transação (PK)",
       ID_USUARIO   "ID do Usuário (FK)",
       ID_CATEGORIA "ID da Categoria da Transação (FK)",
       ID_CONTA     "ID da Conta Bancária (FK)",
       VL_TRANSACAO "Valor da Transação",
       DT_TRANSACAO "Data da Transação",
       DS_TRANSACAO "Descrição da Transação"
  FROM T_TRANSACAO
 WHERE ID_USUARIO = 4
   AND ID_TRANSACAO = 14
   AND TP_MOVIMENTACAO = 'SAIDA';

-- 3.3 Consultar investimento pelos IDs do usuario e investimento.
SELECT ID_INVESTIMENTO "ID do Investimento (PK)",
       ID_USUARIO      "ID do Usuário (FK)",
       NM_INVESTIMENTO "Nome do Investimento",
       TP_INVESTIMENTO "Tipo do Investimento",
       VL_INVESTIDO    "Valor Investido",
       VL_ATUAL        "Valor Atual",
       DT_INVESTIMENTO "Data do Investimento"
  FROM T_INVESTIMENTO
 WHERE ID_USUARIO = 4
   AND ID_INVESTIMENTO = 6;

-- ================================================================
-- 4. CONSULTAS ORDENADAS
-- ================================================================

-- 4.1 Despesas do usuario 1, da mais recente a mais antiga.
-- O ID desempata transacoes realizadas na mesma data e hora.
SELECT ID_TRANSACAO "ID da Transação (PK)",
       ID_USUARIO   "ID do Usuário (FK)",
       VL_TRANSACAO "Valor da Transação",
       DT_TRANSACAO "Data da Transação",
       DS_TRANSACAO "Descrição da Transação"
  FROM T_TRANSACAO
 WHERE ID_USUARIO = 1
   AND TP_MOVIMENTACAO = 'SAIDA'
 ORDER BY DT_TRANSACAO DESC, ID_TRANSACAO DESC;

-- 4.2 Investimentos do usuario 1, do mais recente ao mais antigo.
-- O ID desempata investimentos com a mesma data.
SELECT ID_INVESTIMENTO "ID do Investimento (PK)",
       ID_USUARIO      "ID do Usuário (FK)",
       NM_INVESTIMENTO "Nome do Investimento",
       VL_INVESTIDO    "Valor Investido",
       VL_ATUAL        "Valor Atual",
       DT_INVESTIMENTO "Data do Investimento"
  FROM T_INVESTIMENTO
 WHERE ID_USUARIO = 1
 ORDER BY DT_INVESTIMENTO DESC, ID_INVESTIMENTO DESC;

-- ================================================================
-- 5. DASHBOARD: UMA LINHA PARA O USUARIO 1
-- ================================================================

-- Cada subconsulta escolhe uma linha antes das juncoes.
-- LEFT OUTER JOIN conserva o usuario se faltar despesa ou investimento.
SELECT U.ID_USUARIO      "ID do Usuário (PK)",
       U.NM_USUARIO      "Nome",
       U.DS_EMAIL        "E-mail",
       D.ID_TRANSACAO    "ID da Última Despesa",
       D.DS_TRANSACAO    "Última Despesa",
       D.VL_TRANSACAO    "Valor da Última Despesa",
       D.DT_TRANSACAO    "Data da Última Despesa",
       I.ID_INVESTIMENTO "ID do Último Investimento",
       I.NM_INVESTIMENTO "Último Investimento",
       I.VL_INVESTIDO    "Valor Investido",
       I.VL_ATUAL        "Valor Atual",
       I.DT_INVESTIMENTO "Data do Último Investimento"
  FROM T_USUARIO U
       LEFT OUTER JOIN (
           SELECT ID_USUARIO, ID_TRANSACAO, DS_TRANSACAO,
                  VL_TRANSACAO, DT_TRANSACAO
             FROM T_TRANSACAO
            WHERE ID_USUARIO = 1
              AND TP_MOVIMENTACAO = 'SAIDA'
            ORDER BY DT_TRANSACAO DESC, ID_TRANSACAO DESC
            FETCH FIRST 1 ROW ONLY
       ) D
           ON (U.ID_USUARIO = D.ID_USUARIO)
       LEFT OUTER JOIN (
           SELECT ID_USUARIO, ID_INVESTIMENTO, NM_INVESTIMENTO,
                  VL_INVESTIDO, VL_ATUAL, DT_INVESTIMENTO
             FROM T_INVESTIMENTO
            WHERE ID_USUARIO = 1
            ORDER BY DT_INVESTIMENTO DESC, ID_INVESTIMENTO DESC
            FETCH FIRST 1 ROW ONLY
       ) I
           ON (U.ID_USUARIO = I.ID_USUARIO)
 WHERE U.ID_USUARIO = 1;

-- Resultado conferido: 1 linha; ultima despesa 8; ultimo investimento 3.
