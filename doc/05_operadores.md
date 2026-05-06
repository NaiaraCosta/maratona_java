# 📘 Guia — Operadores em Java (`aritméticos`, `relacionais`, `lógicos` e `atribuição`)

Documento técnico focado em **operadores Java**, cobrindo fundamentos matemáticos, comparações, lógica booleana e operadores de atribuição, com exemplos práticos, explicações passo a passo e **pegadinhas comuns** que aparecem no dia a dia do desenvolvimento.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Operadores** são componentes centrais da linguagem `Java`. Eles permitem que o programa:

- Execute **operações matemáticas**
- Realize **comparações entre valores**
- Aplique **lógica booleana** para decisões
- **Atribua, atualize e manipule valores** em variáveis

Os operadores atuam diretamente sobre:
- **Variáveis**
- **Literais**
- **Expressões**

Eles influenciam não apenas o resultado das operações, mas também o **fluxo de execução do programa**.  
Compreender a **ordem de avaliação**, o **tipo do resultado retornado** e o **contexto de uso** é essencial para evitar erros sutis e bugs difíceis de identificar.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### ➗ Operadores Aritméticos

Utilizados para realizar **cálculos matemáticos básicos** entre valores numéricos.

Operadores disponíveis:
- `+` ➜ soma
- `-` ➜ subtração
- `*` ➜ multiplicação
- `/` ➜ divisão
- `%` ➜ resto da divisão (módulo)

📌 Funcionamento geral:
- Valores armazenados em memória são lidos
- A operação é aplicada
- O **resultado pode ser impresso, atribuído a uma variável ou usado em outra expressão**

⚠️ **Atenção com divisão inteira**:
- Se **ambos os operandos forem `int`**, o resultado será sempre `int`
- A parte decimal é **descartada**, não arredondada

Exemplo conceitual:
- `10 / 3` ➜ resultado `3`, e não `3.33`

✅ Para obter resultado decimal:
- Pelo menos um operando deve ser `double` ou `float`
- Ou usar `casting` (opção válida, porém deve ser usada com cuidado)

---

### ➕ Operador `+` (Adição vs Concatenação)

O operador `+` em Java é **sobrecarregado**, ou seja, seu comportamento muda conforme o tipo dos operandos.

Regras principais:
- `int + int` ➜ **adição matemática**
- `String + qualquer tipo` ➜ **concatenação de texto**

📌 Regra-chave:
- A partir do momento em que uma `String` aparece na expressão, **todos os `+` seguintes passam a concatenar**, e não somar.

Exemplos conceituais:
- `10 + 20 + " texto"` ➜ `"30 texto"`
- `"texto " + 10 + 20` ➜ `"texto 1020"`

🔎 Ordem de avaliação importa:
- A expressão é avaliada **da esquerda para a direita**.

---

### 📐 Operadores Relacionais

Os operadores relacionais realizam **comparações entre valores** e **sempre retornam um valor booleano**:

- `true`
- `false`

Operadores existentes:
- `<` ➜ menor que
- `>` ➜ maior que
- `<=` ➜ menor ou igual
- `>=` ➜ maior ou igual
- `==` ➜ igualdade
- `!=` ➜ diferença

📌 Atenção a um erro clássico:
- `=` ➜ operador de **atribuição**
- `==` ➜ operador de **comparação**

⚠️ Restrições importantes:
- Tipos incompatíveis não podem ser comparados diretamente
- Exemplo inválido:
    - Comparar `int` com `String`

✅ O resultado de qualquer operador relacional **sempre será booleano**.

---

### ✅ Operadores Lógicos

Os operadores lógicos são usados para **combinar expressões booleanas**, normalmente em estruturas de decisão (`if`, `while`, `for`).

Operadores disponíveis:
- `&&` ➜ **AND** (E)
- `||` ➜ **OR** (OU)
- `!` ➜ **NOT** (negação)

Eles avaliam condições e produzem um **resultado booleano final**.

---

### 🔗 Operador Lógico `&&` (AND)

✅ Retorna `true` **somente se todas as expressões forem verdadeiras**.

Uso típico:
- Validação de regras obrigatórias
- Situações em que **todas as condições precisam ser atendidas**

Exemplo conceitual:
- Ter idade mínima **E**
- Possuir salário mínimo exigido

📌 Regra importante:
- Se **uma única condição for `false`**, o resultado final será `false`
- Java utiliza **avaliação de curto-circuito**: se a primeira condição já for falsa, as demais podem nem ser avaliadas

---

### 🔀 Operador Lógico `||` (OR)

✅ Retorna `true` se **pelo menos uma condição for verdadeira**.

Uso típico:
- Opções alternativas válidas
- Quando **qualquer uma das condições já satisfaz a regra**

Exemplo conceitual:
- Ter dinheiro na conta corrente **OU**
- Ter dinheiro na poupança

📌 Mesmo que uma condição falhe, basta outra ser verdadeira para que o resultado final seja `true`.

---

### 🧮 Operadores de Atribuição

Os operadores de atribuição servem para **atribuir ou atualizar valores**, reduzindo repetição de código e aumentando legibilidade.

Operadores disponíveis:
- `=`  ➜ atribuição simples
- `+=` ➜ soma e atribui
- `-=` ➜ subtrai e atribui
- `*=` ➜ multiplica e atribui
- `/=` ➜ divide e atribui
- `%=` ➜ resto e atribui

Exemplo conceitual:
- `x = x + 10` ➜ `x += 10`

✅ Código mais limpo  
✅ Menos repetição  
✅ Muito comum em código profissional

---

### 🔁 Operadores Unários (Incremento e Decremento)

Usados principalmente para **controle de contadores**, índices e laços de repetição.

Operadores:

- `++` ➜ incremento
- `--` ➜ decremento

Formas de uso:

- **Pré-incremento** ➜ `++contador`
- **Pós-incremento** ➜ `contador++`

Diferença fundamental:

- **Pré** ➜ incrementa primeiro, depois utiliza o valor
- **Pós** ➜ utiliza primeiro, depois incrementa

Exemplo:
```java
    int x = 5;
    int a = ++x; // x torna-se 6, a = 6

    x = 5; 
    int b = x++; // b = 5, então x se torna 6
```

📌 Esses operadores são extremamente comuns em estruturas como:

- `for`
- `while`
- `do-while`

---

### 🛑 Observações Importantes

- Operadores **retornam valores**; eles não executam ações isoladas
- O **tipo dos operandos** influencia diretamente o resultado
- `casting` pode forçar conversões, mas pode gerar **perda de dados**
- Expressões mal escritas podem gerar **bugs lógicos silenciosos**
- Código claro e bem estruturado é a melhor forma de prevenir erros

---

## 🚀 Síntese Final ✅🧠

- Operadores realizam **cálculos**, **comparações** e **operações lógicas**
- O operador `+` pode **somar ou concatenar**, dependendo do contexto
- Divisão entre `int` resulta sempre em `int`
- Operadores relacionais retornam `boolean`
- `&&` exige **todas** as condições verdadeiras
- `||` exige **apenas uma** condição verdadeira
- Operadores de atribuição reduzem repetição de código
- `++` e `--` mudam comportamento conforme a posição
- Tipo dos dados e ordem das operações são fundamentais para o resultado correto

---