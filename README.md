# 🌐 Orbe — Fintech de Controle Financeiro

> Projeto acadêmico desenvolvido ao longo do curso de **Análise e Desenvolvimento de Sistemas** na [FIAP](https://www.fiap.com.br/), evoluindo incrementalmente a cada mês conforme novos conteúdos são estudados.

---

## 📌 Sobre o projeto

A **Orbe** é uma aplicação web de controle financeiro pessoal com proposta fintech. O objetivo é permitir que o usuário registre sua renda, compromissos financeiros e receba sugestões personalizadas para melhorar sua saúde financeira.

O projeto é construído de forma progressiva: a cada mês, novas funcionalidades e melhorias são incorporadas com base nos conteúdos estudados na faculdade — tornando este repositório um registro vivo do aprendizado ao longo do curso.

---

## 🗂️ Evolução do projeto

| Mês | Conteúdo estudado | O que foi implementado |
|-----|-------------------|------------------------|
| 1   | HTML5 + CSS3      | Estrutura semântica da Página 1 (Cadastro Inicial), layout sidebar + main com Flexbox, estilização com variáveis CSS, tipografia com Google Fonts (Lora), inputs de renda e compromissos financeiros, responsividade para tablet e mobile |
| ... | ...               | *(em breve)* |

---

## 🖥️ Páginas previstas

| Página | Nome | Descrição |
|--------|------|-----------|
| `pagina_1` | Cadastro Inicial | Coleta de renda fixa, renda variável, gastos fixos e dívidas ativas |
| `pagina_2` | Gestão | *(a implementar)* |
| `pagina_3` | Integração | *(a implementar)* |
| `pagina_4` | Investimentos | *(a implementar)* |

---

## 🚀 Funcionalidades

### Implementadas
- [x] Layout com sidebar de navegação e área de conteúdo principal
- [x] Formulário de cadastro de **Renda Mensal** (fixa e variável)
- [x] Formulário de cadastro de **Compromissos Financeiros** (gastos fixos e dívidas ativas)
- [x] Responsividade para tablets (≤ 768px) e celulares (≤ 480px)
- [x] Variáveis CSS para cores, tipografia e espaçamentos
- [x] Reset CSS global

### Previstas
- [ ] Navegação funcional entre páginas
- [ ] Validação e envio dos formulários com JavaScript
- [ ] Dashboard com resumo financeiro
- [ ] Sugestões personalizadas com base nos dados inseridos
- [ ] Gráficos e relatórios
- [ ] Persistência de dados com banco de dados
- [ ] API back-end

---

## 🛠️ Tecnologias utilizadas

### Até o momento
- **HTML5** — estrutura semântica com `header`, `main`, `article`, `section`, `fieldset`
- **CSS3** — Flexbox, variáveis CSS (`:root`), media queries, pseudo-classes de hover
- **Google Fonts** — tipografia [Lora](https://fonts.google.com/specimen/Lora)

### Previstas (conforme evolução do curso)
- JavaScript — interatividade e validação
- Git & GitHub — versionamento
- SQL / Banco de dados relacional
- Back-end (a definir)

---

## 📁 Estrutura de arquivos

```
orbe/
├── HTML/
│   └── pagina_1.html       # Página de Cadastro Inicial
├── CSS/
│   └── pagina_1.css        # Estilos da página 1
├── js/
│   └── arquivo.js          # (a implementar)
└── README.md
```

*(A estrutura será atualizada conforme o projeto crescer)*

---

## 🎨 Decisões de design

| Elemento | Escolha | Valor |
|----------|---------|-------|
| Tipografia | Lora (serif) | Google Fonts |
| Cor primária (títulos) | Verde escuro | `hsl(127, 100%, 10%)` |
| Cor do corpo | Cinza médio | `hsl(0, 0%, 33%)` |
| Layout base | Sidebar fixa + conteúdo flexível | Flexbox |
| Responsividade | Sidebar vira topo em telas menores | `@media max-width: 768px` |

---

## ▶️ Como rodar localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/luannstival/orbe-fintech.git
   ```
2. Abra o arquivo `HTML/pagina_1.html` no seu navegador.

> Não é necessária nenhuma instalação nesta fase do projeto.

---

## 📚 Contexto acadêmico

Este projeto é desenvolvido como atividade prática do curso de **ADS (Análise e Desenvolvimento de Sistemas)** na **FIAP**. Cada incremento mensal reflete diretamente o conteúdo estudado naquele período, tornando o repositório um portfólio técnico progressivo.

---

## 👨‍💻 Autor

**Luann** — estudante de ADS na FIAP  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?style=flat&logo=linkedin)](https://linkedin.com/in/luann-stival-6573133b5)
[![GitHub](https://img.shields.io/badge/GitHub-black?style=flat&logo=github)](https://github.com/luannstival)

---

*Última atualização: Junho de 2026*
