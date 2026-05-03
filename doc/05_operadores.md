# 📘 Guia — Operadores em Java (`aritméticos`, `relacionais`, `lógicos` e `atribuição`)

Documento técnico focado em **operadores Java**, cobrindo fundamentos matemáticos, comparações, lógica booleana e operadores de atribuição, com exemplos práticos e pegadinhas comuns.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Operadores** são elementos fundamentais do `Java` que permitem:
- Executar **operações matemáticas**
- Realizar **comparações**
- Trabalhar com **lógica booleana**
- **Atribuir e atualizar valores** em variáveis

Eles atuam diretamente sobre **variáveis**, **literais** e **expressões**, influenciando o fluxo e o resultado do programa. Entender a **ordem**, o **tipo retornado** e o **contexto de uso** evita bugs difíceis de diagnosticar.

---

## 🧩 Blocos Semânticos 🧠🔎

### ➗ Operadores Aritméticos

Utilizados para cálculos matemáticos básicos.

Operadores:
- `+` ➜ soma
- `-` ➜ subtração
- `*` ➜ multiplicação
- `/` ➜ divisão
- `%` ➜ resto da divisão

Exemplo conceitual:
- Valores guardados em memória são combinados e o **resultado pode ser impresso ou armazenado**.

⚠️ **Atenção com divisão inteira**:
- Operação entre dois `int` gera sempre `int`
- Parte decimal é descartada

✅ Para obter decimal:
- Um dos operandos deve ser `double` ou `float`
- Ou usar `casting` (não recomendado como prática padrão)

---

### ➕ Operador `+` (Adição vs Concatenação)

O operador `+` é **sobrecarregado**:

- `int + int` ➜ **adição**
- `String + qualquer coisa` ➜ **concatenação**

📌 Regra importante:
- A partir do momento que uma `String` aparece na expressão, **todos os `+` seguintes concatenam**

Exemplo conceitual:
- `10 + 20 + " texto"` ➜ `"30 texto"`
- `"texto " + 10 + 20` ➜ `"texto 1020"`

---

### 📐 Operadores Relacionais

Realizam **comparações** e **sempre retornam `boolean`** (`true` ou `false`).

Operadores:
- `<` ➜ menor que
- `>` ➜ maior que
- `<=` ➜ menor ou igual
- `>=` ➜ maior ou igual
- `==` ➜ igualdade
- `!=` ➜ diferença

📌 Importante:
- `=` ➜ atribuição
- `==` ➜ comparação

⚠️ Tipos incompatíveis não podem ser comparados  
Exemplo inválido:
- `int` com `String`

---

### ✅ Operadores Lógicos

Combinam expressões booleanas.

Operadores:
- `&&` ➜ **AND** (E)
- `||` ➜ **OR** (OU)
- `!` ➜ **NOT** (negação)

---

### 🔗 Operador Lógico `&&` (AND)

✅ Retorna `true` **somente se todas as condições forem verdadeiras**.

Uso típico:
- Validação de regras
- Múltiplos requisitos obrigatórios

Exemplo conceitual:
- Idade mínima **E** salário mínimo

📌 Se **uma condição for `false`**, o resultado final será `false`.

---

### 🔀 Operador Lógico `||` (OR)

✅ Retorna `true` se **pelo menos uma condição for verdadeira**.

Uso típico:
- Alternativas válidas
- Uma condição já é suficiente

Exemplo conceitual:
- Ter dinheiro na conta corrente **OU** na poupança

📌 Mesmo se uma condição falhar, outra verdadeira garante o resultado `true`.

---

### 🧮 Operadores de Atribuição

Servem para **atribuir ou atualizar valores**, reduzindo código repetitivo.

Operadores:
- `=`
- `+=`
- `-=`
- `*=`
- `/=`
- `%=`

Exemplo conceitual:
- `x = x + 10` ➜ `x += 10`

✅ Mais limpo  
✅ Mais legível  
✅ Muito usado em código profissional

---

### 🔁 Operadores Unários (Incremento e Decremento)

Usados principalmente em **contadores**.

Operadores:
- `++` ➜ incremento
- `--` ➜ decremento

Formas:
- Pré-incremento ➜ `++contador`
- Pós-incremento ➜ `contador++`

Diferença:
- **Antes** ➜ incrementa primeiro, depois usa
- **Depois** ➜ usa primeiro, depois incrementa

📌 Muito comuns em `loops` (`for`, `while`).

---

### 🛑 Observações Importantes

- Operadores retornam **valores**, não ações mágicas
- Tipo da variável influencia o resultado
- `casting` força conversão, mas pode gerar perda de dados
- Código legível evita bugs lógicos disfarçados

---

## 🚀 Síntese Final ✅🧠

- Operadores realizam **cálculos**, **comparações** e **lógica**
- `+` soma ou concatena dependendo do contexto
- Divisão entre `int` resulta em `int`
- Operadores relacionais retornam `boolean`
- `&&` exige todas as condições verdadeiras
- `||` exige apenas uma condição verdadeira
- Operadores de atribuição economizam código
- `++` e `--` variam conforme posição
- Tipos e ordem das operações importam

---