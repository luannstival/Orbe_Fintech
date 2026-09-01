# Orbe — Projeto acadêmico de gestão financeira

A Orbe é um projeto acadêmico em desenvolvimento durante o curso de Análise e Desenvolvimento de Sistemas da FIAP.

Este repositório registra minha evolução nos estudos de programação e desenvolvimento de sistemas. Cada etapa corresponde aos conteúdos estudados e aplicados nas atividades da faculdade.

## Sobre o projeto

A proposta da Orbe é explorar a criação de uma plataforma de gestão financeira pessoal. A ideia inicial envolve o registro de informações financeiras, organização de contas e apresentação futura de orientações adequadas à realidade do usuário.

O projeto ainda está em fase de aprendizado e não representa uma aplicação financeira completa ou pronta para uso.

## Estado atual

Atualmente, o repositório possui:

- uma página estática e responsiva de cadastro financeiro desenvolvida com HTML e CSS;
- uma modelagem inicial do domínio da Fintech em Java;
- classes que representam usuários, endereços, situações financeiras, contas bancárias e transações;
- histórico de evolução mantido com Git e GitHub.

Ainda não foram implementados:

- banco de dados conectado à aplicação;
- autenticação de usuários;
- integração com instituições bancárias;
- persistência dos formulários;
- regras financeiras completas;
- aplicação back-end.

## Evolução do projeto

| Período | Conteúdo estudado | Aplicação no projeto |
|---|---|---|
| Junho de 2026 | HTML5 e CSS3 | Criação da página de cadastro inicial, formulário de renda e compromissos financeiros, Flexbox e responsividade |
| Agosto e setembro de 2026 | Orientação a objetos em Java | Criação das classes principais da Fintech, atributos privados, construtores, métodos, getters, setters e relacionamentos entre objetos |

## Interface em HTML e CSS

A primeira página representa o cadastro inicial da situação financeira do usuário.

Ela contém campos para:

- renda fixa;
- renda variável;
- gastos fixos;
- dívidas atuais.

A página possui adaptação para computadores, tablets e celulares. Os formulários ainda não enviam ou armazenam informações.

## Modelagem em Java

A primeira atividade de orientação a objetos foi desenvolvida com cinco classes principais:

- `Usuario`;
- `Endereco`;
- `SituacaoFinanceira`;
- `ContaBancaria`;
- `Transacao`.

Nesta etapa foram praticados:

- definição de classes;
- atributos privados;
- escolha de tipos de dados;
- construtores padrão e parametrizados;
- métodos de instância;
- encapsulamento com getters e setters;
- relacionamentos entre objetos;
- uso de `LocalDate` e `LocalDateTime`.

Conforme solicitado na atividade acadêmica, os métodos representam comportamentos do sistema por meio de mensagens com `System.out.println`. As regras completas ainda não foram implementadas.

## Tecnologias utilizadas

- HTML5;
- CSS3;
- Java;
- Git;
- GitHub;
- IntelliJ IDEA.

## Estrutura atual

```text
Orbe_Fintech/
├── css_html/
│   ├── pagina_1.html
│   └── pagina_1.css
├── Java/
│   └── CodificacaoClassesJava/
│       └── src/
│           ├── ContaBancaria.java
│           ├── Endereco.java
│           ├── SituacaoFinanceira.java
│           ├── Transacao.java
│           └── Usuario.java
└── README.md
```

## Como visualizar a página

Clone o repositório:

```bash
git clone https://github.com/luannstival/Orbe_Fintech.git
```

Depois, abra o arquivo abaixo em um navegador:

```text
css_html/pagina_1.html
```

## Como verificar as classes Java

Abra a pasta abaixo como projeto no IntelliJ IDEA:

```text
Java/CodificacaoClassesJava
```

No IntelliJ, utilize **Build → Build Project** para compilar as classes.

## Próximas etapas de aprendizagem

As próximas melhorias serão realizadas de acordo com os conteúdos estudados durante o curso, como:

- herança e polimorfismo;
- coleções;
- regras de negócio;
- persistência em banco de dados;
- integração entre interface e back-end.

Esses itens representam estudos futuros e ainda não estão implementados.

## Contexto acadêmico

Projeto desenvolvido como parte das atividades do curso de Análise e Desenvolvimento de Sistemas da FIAP.

O objetivo deste repositório é registrar de forma transparente minha evolução como estudante, incluindo o que já aprendi, o que consegui implementar e os próximos conteúdos que serão estudados.

## Autor

**Luann Stival** — estudante de Análise e Desenvolvimento de Sistemas na FIAP.

[LinkedIn](https://linkedin.com/in/luann-stival-6573133b5) · [GitHub](https://github.com/luannstival)

---

Última atualização: setembro de 2026.