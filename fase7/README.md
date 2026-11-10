# Orbe Fintech — Fase 7 (Integration)

Projeto acadêmico da Fase 7 do curso de Análise e Desenvolvimento de Sistemas (FIAP).
Autora: Luann Stival Machado Rabelo.

O **Orbe Fintech** é um sistema de controle financeiro pessoal que cresce a cada fase. Nesta fase, o
back-end (Java + Spring Boot + Oracle) foi integrado a um front-end em React, com três entidades
implementadas de ponta a ponta: **Usuário**, **Investimento** e **Instituição Bancária**.

## Estrutura da entrega

```
Orbe-Fintech-Fase7/
├── backend/                       Projeto Spring Boot (Java 21, Maven)
├── frontend/                      Projeto React + Vite + TypeScript
├── script_fintech_corrigido.sql   Script de criação das tabelas no Oracle
└── README.md
```

## Tecnologias

- **Back-end:** Java 21, Spring Boot 4.1.2, Spring Web, Spring Data JPA (Hibernate), driver JDBC da Oracle, Maven.
- **Banco de dados:** Oracle da FIAP (`jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL`).
- **Front-end:** React 19, Vite, TypeScript, React Router.

## 1. Banco de dados (Oracle da FIAP)

1. Conecte-se ao Oracle da FIAP com a sua conta.
2. Execute o script `script_fintech_corrigido.sql` para criar as tabelas.
3. Crie o usuário de teste do login (dados fictícios):

```sql
INSERT INTO t_usuario (nm_usuario, nr_cpf, ds_email, ds_senha, dt_nascimento)
VALUES ('Usuario Teste', '12345678909', 'teste@orbe.test', 'teste123', DATE '1990-01-01');
COMMIT;
```

## 2. Como rodar o back-end

O back-end **não guarda senha no código**. A conexão com o Oracle usa duas variáveis de ambiente:

| Variável          | O que colocar                       |
|-------------------|-------------------------------------|
| `ORACLE_USER`     | usuário da sua conta Oracle da FIAP |
| `ORACLE_PASSWORD` | senha da sua conta Oracle da FIAP   |

**Pela IDE (IntelliJ):** em *Run > Edit Configurations*, preencha as duas variáveis em
*Environment variables* e execute a classe `OrbefintechApplication`.

**Pelo terminal** (na pasta `backend`, exemplo no PowerShell do Windows):

```powershell
$env:ORACLE_USER="seu_usuario"
$env:ORACLE_PASSWORD="sua_senha"
.\mvnw.cmd spring-boot:run
```

O back-end sobe em `http://localhost:8080`.

## 3. Como rodar o front-end

Na pasta `frontend`:

1. Crie um arquivo chamado `.env` (na mesma pasta do `package.json`) com esta linha:

   ```
   VITE_API_URL=http://localhost:8080/api
   ```

2. Instale as dependências e inicie:

   ```
   npm install
   npm run dev
   ```

3. Abra `http://localhost:5173`.

> O back-end autoriza (CORS) o endereço `http://localhost:5173`. Use essa porta.
> O arquivo `.npmrc` da pasta já resolve um aviso de versões do `npm install`; não precisa mexer nele.

## 4. Login de teste

| Campo | Valor             |
|-------|-------------------|
| E-mail | `teste@orbe.test` |
| Senha  | `teste123`        |

Também é possível criar uma conta nova pela tela **Criar conta** (`/cadastro`).

## 5. Telas do front-end

| Rota            | Tela                                                         |
|-----------------|--------------------------------------------------------------|
| `/`             | Login (porta de entrada)                                     |
| `/cadastro`     | Criar conta (novo usuário)                                   |
| `/home`         | Página inicial, com links para as áreas do sistema           |
| `/usuarios`     | Consultar, cadastrar, editar e excluir usuários              |
| `/investimentos`| Consultar, cadastrar, editar e excluir investimentos         |
| `/instituicoes` | Consultar, cadastrar, editar e excluir instituições bancárias|
| qualquer outra  | Página de erro personalizada ("Página não encontrada")       |

Ao cadastrar um **investimento**, informe o **ID de um usuário que já existe** (o ID aparece na lista
da tela de Usuários). O código Compe da instituição tem **no máximo 3 caracteres** e não pode se repetir.

## 6. Endpoints da API (REST)

Todos sob `http://localhost:8080/api`:

| Recurso          | Endpoints                                                                                       |
|------------------|-------------------------------------------------------------------------------------------------|
| `/usuarios`      | `GET /usuarios`, `GET /usuarios/{id}`, `POST /usuarios`, `PUT /usuarios/{id}`, `DELETE /usuarios/{id}` |
| `/investimentos` | `GET /investimentos`, `GET /investimentos/{id}`, `POST /investimentos`, `PUT /investimentos/{id}`, `DELETE /investimentos/{id}` |
| `/instituicoes`  | `GET /instituicoes`, `GET /instituicoes/{id}`, `POST /instituicoes`, `PUT /instituicoes/{id}`, `DELETE /instituicoes/{id}` |

Códigos de status usados: **200** (consulta e atualização), **201** (criação), **204** (exclusão),
**400** (pedido incompleto), **404** (registro não encontrado) e **409** (dado duplicado, como CPF ou código Compe).

## 7. Arquitetura do back-end

Cada entidade tem as quatro camadas: **Model** (`@Entity`) → **Repository** (`JpaRepository`) →
**Service** (regras de negócio) → **Controller** (`@RestController`).

## 8. Limitações conhecidas

Este é um projeto acadêmico e algumas partes são simples de propósito:

- O **login é básico**: o front-end consulta a lista de usuários e compara e-mail e senha. A senha fica
  em texto no banco e a API de usuários devolve esse campo. Num sistema real, o back-end validaria uma
  senha criptografada.
- As páginas **não são protegidas**: quem digitar o endereço de uma rota consegue abri-la sem fazer login.
- Só a tela de **Criar conta** mostra aviso de erro. Nas demais, quando o back-end recusa um dado
  (código Compe repetido, ID de usuário inexistente), a tela simplesmente não muda.
- Ao **editar** uma instituição para um código Compe que já existe em outra, o back-end responde com erro 500.
- O endereço do back-end e o CORS estão configurados para uso local (`localhost`).
- Apenas **3 entidades** foram implementadas. Outras partes do modelo (contas bancárias, transações,
  rendas e gastos) ficam como evolução futura.
