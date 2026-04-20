# 📘 Guia — Coesão em Java (Orientação a Objetos)

Este guia apresenta o conceito de **coesão em programação orientada a objetos**, explicando como organizar classes com **responsabilidade única**, evitando mistura de contextos diferentes dentro do mesmo código.

---

## 🧠 Resumo

**Coesão** está relacionada ao **propósito de uma classe**.

Uma classe altamente coesa tem:

* Um único objetivo
* Responsabilidades bem definidas
* Código mais fácil de manter e evoluir

Quando uma classe faz muitas coisas diferentes, ela se torna **pouco coesa** e difícil de manter.

---

## 🧩 O que é coesão

Coesão significa que uma classe deve representar **apenas um conceito do mundo real**.

Quanto maior a coesão:

* Mais organizado o código
* Mais fácil de entender
* Mais fácil de modificar sem quebrar outras partes

---

## ⚠️ Problema da baixa coesão

Um erro comum é misturar responsabilidades diferentes na mesma classe.

Exemplo de problema conceitual:

* Misturar **Aluno** e **Professor** na mesma classe

Isso gera:

- Código confuso
- Dificuldade de manutenção
- Alterações que afetam partes não relacionadas
- Alta chance de bugs

### 🧱 Exemplo de baixa coesão

Quando uma classe mistura conceitos diferentes:

* Atributos de aluno
* Atributos de professor

Problema principal:

* Mudanças em “professor” afetam “aluno”
* Mudanças em “aluno” afetam “professor”

### 🧪 Outro exemplo de baixa coesão

Uma classe perde coesão quando:

* Representa um objeto
* E também executa lógica de execução (main/teste)

---

## 🧠 Separação correta de responsabilidades

O correto é separar os conceitos:

### 📌 Princípio importante

Cada classe deve ter um único propósito.

Se você não consegue descrever a classe em uma frase simples, ela provavelmente não é coesa.

---

## 🧠 Boas práticas de coesão

* Uma classe = um propósito
* Um domínio por classe
* Separar entidades diferentes
* Separar execução de modelo
* Evitar classes “tudo em um”

---

## 🚀 Resumo final

* Coesão é o grau de foco de uma classe
* Alta coesão = responsabilidade única
* Baixa coesão = mistura de conceitos
* Classes devem representar um único domínio
* Separar responsabilidades melhora manutenção

---