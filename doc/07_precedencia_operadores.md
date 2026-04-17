# 🧠 Precedência de Operadores

A **precedência de operadores** define **a ordem em que as operações são executadas** em uma expressão.

💡 Quando há vários operadores, o Java segue uma hierarquia — **nem sempre é da esquerda para a direita**.

---

## 📊 Ordem de precedência (do maior para o menor)

```
1. ()                      → Parênteses
2. ++, --                  → Incremento / Decremento (prefixado)
3. *, /, %                 → Multiplicação, divisão, resto
4. +, -                    → Soma e subtração
5. <, >, <=, >=            → Comparação
6. ==, !=                  → Igualdade
7. &&                      → E lógico
8. ||                      → OU lógico
9. =, +=, -=, *=, /=       → Atribuição
```

---

## ⚙️ Como funciona na prática

### 📌 Exemplo 1

```
int resultado = 10 + 5 * 2;
```

✔ Primeiro multiplica:

```
5 * 2 = 10
```

✔ Depois soma:

```
10 + 10 = 20
```

---

### 📌 Exemplo 2 (com parênteses)

```
int resultado = (10 + 5) * 2;
```

✔ Parênteses têm prioridade:

```
10 + 5 = 15
```

✔ Depois multiplica:

```
15 * 2 = 30
```

---

## 🔁 Associatividade

Quando operadores têm **mesma precedência**, o Java usa a associatividade:

* ➡️ **Esquerda → direita** (mais comum)
* ⬅️ **Direita → esquerda** (ex: atribuição)

### 📌 Exemplo

```
int x = 10 - 5 - 2;
```

✔ Resolvido da esquerda para direita:

```
(10 - 5) = 5
5 - 2 = 3
```

---

## ⚠️ Cuidado com pegadinhas

### ❌ Exemplo confuso

```
boolean resultado = true || false && false;
```

✔ Primeiro `&&`, depois `||`:

```
false && false = false
true || false = true
```

---

## 💡 Dica importante

> ✅ Use parênteses sempre que quiser deixar o código mais claro

Mesmo que você saiba a precedência, isso evita erros e melhora a leitura.

---

## 🚀 Resumo rápido

* 🧠 Define a ordem das operações
* 📊 Segue uma hierarquia (não é aleatório)
* 🔝 Parênteses têm maior prioridade
* ⚠️ Operadores lógicos costumam confundir
* ✅ Use parênteses para evitar erros