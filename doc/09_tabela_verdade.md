# 🔢 Tabela Verdade

A tabela verdade é utilizada para representar o resultado de **operações lógicas**.

💡 Ela mostra todas as combinações possíveis entre valores booleanos (`true` e `false`).

---

## 🧠 Operadores lógicos principais

* 🔹 `&&` → **E (AND)**
* 🔹 `||` → **OU (OR)**
* 🔹 `!` → **NÃO (NOT)**

---

## 📊 Representação visual

![Tabela Verdade](img/tabela_verdade.png)

---

## 📌 Exemplos práticos

### 🔹 Operador AND (`&&`)

```
true && true   → true
true && false  → false
false && true  → false
false && false → false
```

---

### 🔹 Operador OR (`||`)

```
true || true   → true
true || false  → true
false || true  → true
false || false → false
```

---

### 🔹 Operador NOT (`!`)

```
!true  → false
!false → true
```

---

## 💡 Dica importante

> ⚠️ Em expressões complexas, o operador `&&` tem maior precedência que `||`

Exemplo:

```
true || false && false
```

✔ Primeiro resolve o `&&`, depois o `||`

---

## 🚀 Resumo rápido

* 🔢 Representa combinações de valores booleanos
* 🧠 Usada com operadores lógicos
* ⚠️ Importante para entender condições e decisões
* 📊 Muito utilizada em `if`, `while` e validações