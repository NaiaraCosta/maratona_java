# 📘 Guia Completo — Operadores em Java

Este guia apresenta os principais **operadores em Java**, incluindo operadores aritméticos, relacionais, lógicos e de atribuição, além de seus comportamentos em memória e uso prático no desenvolvimento.

---

## 🧠 Resumo

Operadores em Java são elementos utilizados para **realizar cálculos, comparações e manipulação de valores booleanos ou numéricos**.

Eles são divididos em categorias:

* Aritméticos
* Relacionais
* Lógicos
* Atribuição
* Unários (incremento/decremento)

---

## 💻 Operadores Aritméticos

São usados para operações matemáticas básicas.

### ➕ Operadores:

* Soma: `+`
* Subtração: `-`
* Multiplicação: `*`
* Divisão: `/`
* Resto: `%`

#### 📌 Comportamento importante (tipos)

* Operações com `int` retornam `int`
* Divisão entre inteiros ignora casas decimais

Exemplo:

* `10 / 20 = 0` (inteiro)
* Para decimal, usar `double`

---

## 🔄 Cast (conversão de tipo)

* Pode forçar resultado decimal
* Ex: converter `int` para `double`

---

## 📌 Operador de Resto (%)

Usado para obter o resto de uma divisão.

#### 💡 Exemplo:

    20 % 2 = 0

#### 🧠 Uso comum:

* Verificar se número é **par ou ímpar**

Regra:

* Resto = 0 → par
* Resto ≠ 0 → ímpar

---

## 🔗 Operadores Relacionais

Retornam sempre um valor **boolean (`true` ou `false`)**.

### 📌 Operadores:

* `>`  Maior que
* `<`  Menor que
* `>=` Maior ou igual
* `<=` Menor ou igual
* `==` Igual
* `!=` Diferente

### ⚠️ Regras importantes

* `=` É atribuição
* `==` É comparação
* Tipos incompatíveis não podem ser comparados
* Ex: `String` vs `int` → Erro de compilação

---

## 🧠 Operadores Lógicos

Usados para combinar múltiplas condições.

### 🔥 AND (`&&`)

* Só retorna `true` se **todas as condições forem verdadeiras**

### 🔥 OR (`||`)

* Retorna `true` se **pelo menos uma condição for verdadeira**

### ❗ NOT (`!`)

* Inverte o valor booleano

### 💡 Exemplo conceitual

* Idade > 30 && salário > x → acesso permitido
* Conta corrente > valor || conta poupanca > valor → compra liberada

### 🧪 Comportamento importante

* `&&` → exige todas verdadeiras
* `||` → exige apenas uma verdadeira
* Resultado sempre booleano

### 💰 Exemplo prático — Sistema de compra (OR)

#### Cenário:

* Conta corrente
* Conta poupança
* Valor do produto (ex: PlayStation)

#### Regra:

Compra liberada se:

* contaCorrente > valor **OU**
* contaPoupanca > valor

#### 📌 Resultado:

* Uma condição verdadeira já libera compra

---

## ⚙️ Operadores de Atribuição

Servem para **alterar o valor de variáveis existentes** de forma simplificada.


### 📌 Forma tradicional:

```java
    bonus = bonus + 1000;
```

### 🔥 Forma otimizada:

```java
    bonus += 1000;
```

### 📌 Operadores:

* `+=`
* `-=`
* `*=`
* `/=`
* `%=`

### 🧠 Exemplo:

* `bonus` = 1800
* `bonus += 1000` → 2800
* `bonus -= 1000` → 1800
* `bonus *= 2` → 3600
* `bonus /= 2` → 1800

### ⚠️ Hardcoding

#### ❌ Problema:

* Valores fixos no código

📌 Ex:

```java
    bonus = bonus + 1000;
```

✔ Melhor:

* Usar variáveis e operadores compostos

---

## 🔢 Operadores Unários

### ➕ Incremento:

* `contador++` (pós-incremento)
* `++contador` (pré-incremento)

### ➖ Decremento:

* `contador--`
* `--contador`

### ⚠️ Diferença importante

Pós-incremento:

```java
    contador++
```

* Usa valor atual
* Depois incrementa

Pré-incremento:

```java
    ++contador
```

* Incrementa primeiro
* Depois usa valor

### 🧪 Comportamento em execução

* Debug com IntelliJ:
  * Breakpoints
  * Step (F8)
  * Evaluate Expression

📌 Importante:

Ordem de execução altera resultado

---

## 🧠 Conceitos finais

* Operadores sao base da logica em java
* `&&` → Todas condicoes
* `||` → Qualquer condicao
* `++` E-- sao essenciais para loops
* Operadores de atribuicao simplificam codigo
* Tipos influenciam diretamente o resultado das operacoes

---

## 🚀 Resumo final

* Operadores controlam cálculos e decisões no Java
* Existem operadores aritméticos, lógicos, relacionais e de atribuição
* Booleanos são fundamentais em comparações
* Incremento/decremento são amplamente usados em estruturas de repetição
* Entender tipos evita erros de compilação e lógica

---