# 📘 Guia — Estruturas de Repetição em Java (`while`, `do while`, `for`, `break`, `continue`)

Documento técnico introdutório sobre **laços de repetição em `Java`**, explicando funcionamento, sintaxe, armadilhas comuns e exercícios práticos aplicados ao dia a dia de desenvolvimento.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Estruturas de repetição** permitem que um mesmo bloco de código seja executado diversas vezes **enquanto uma condição for satisfeita**.  
Em `Java`, os principais laços são `while`, `do while` e `for`, além dos comandos de controle `break` e `continue`.  
Todos dependem de **expressões booleanas (`boolean`)** e exigem atenção especial à **alteração do estado das variáveis**, evitando loops infinitos.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🔁 `while` — Laço com condição prévia

- Executa **somente se a condição for `true`**.
- A condição deve resultar em um `boolean`.
- **Risco comum**: esquecer de alterar a variável de controle ➜ loop infinito.

**Exemplo conceitual:**
- Contador inicia em `0`
- Condição: `count < 10`
- Incremento obrigatório dentro do bloco (`count++` ou `count += 1`)

✅ Se a condição iniciar como `false`, o bloco **não executa nenhuma vez**.

---

### 🔂 `do while` — Execução garantida

- Executa o bloco **pelo menos uma vez**, **independente da condição**.
- A condição só é verificada **após** a primeira execução.

✅ Útil em cenários raros onde **uma execução inicial é obrigatória**, mesmo com condição falsa.  
⚠️ Uso menos comum no mercado.

---

### 🔢 `for` — Laço indexado

- Ideal para **contagens**, **listas**, **arrays** e **coleções**.
- Estrutura composta por **3 partes**:
  1. Inicialização (ex: `int i = 0`)
  2. Condição (ex: `i < 10`)
  3. Incremento/decremento (ex: `i++` ou `i--`)

📌 Normalmente usa-se `i`, `j`, `k` como índices por convenção.

✅ O `for` concentra **declaração, condição e evolução** em um único ponto ➜ maior legibilidade.

---

### 🧮 Exercício — Números pares até 1.000.000

**Estratégias possíveis:**
- Incrementar de `2` em `2`
- Usar operador de resto (`%`)

✅ Solução mais robusta:
- Verificar `i % 2 == 0`
- Mantém o código **flexível** caso a regra de negócio mude (ex: começar em `1`)

💡 **Boa prática:** pensar sempre em **mudanças futuras de requisitos**.

---

### ⛔ `break` — Interrupção imediata

- Encerra **totalmente** o laço (`for`, `while`, `do while`)
- Também funciona em `switch`
- **Não encerra apenas o `if`**, mas o laço externo

✅ Ideal para:
- Parar processamento quando o objetivo já foi atingido
- Evitar desperdício de recursos

📍 Exemplo: imprimir somente os **25 primeiros números**, mesmo que o laço vá até `50`.

---

### 🔁 `continue` — Pular iteração

- **Ignora o restante da iteração atual**
- Retorna para o início do laço
- O laço **continua executando**

✅ Útil quando:
- Parte do processamento deve ser ignorada em certas condições
- Evita execuções pesadas desnecessárias (ex: `I/O`, chamadas externas)

📌 Muito usado para **filtros dentro de loops grandes**.

---

## 🚀 Síntese Final ✅🧠

- **`while`** executa enquanto a condição for `true`
- **`do while`** executa pelo menos uma vez
- **`for`** é ideal para contagens e índices
- **`break`** interrompe completamente o laço
- **`continue`** pula apenas a iteração atual
- Loops exigem **controle de estado** para evitar execução infinita
- Pensar em **regras de negócio futuras** gera código mais sustentável
- Uso correto de `break` e `continue` melhora **performance e clareza**

---