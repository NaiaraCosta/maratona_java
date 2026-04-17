# ➗✖️➖➕ Operadores

Os operadores em Java são utilizados para **realizar cálculos**, **comparações** e **operações lógicas**.

---

## 📦 Tipos de operadores

### ➕ Aritméticos

Utilizados para operações matemáticas:

```
+, -, *, /, %
```

---

### 🔍 Comparação

Usados para comparar valores (retornam `true` ou `false`):

```
==, !=, <, >, <=, >=
```

---

### 🧠 Lógicos

Utilizados em expressões condicionais:

```
&& (E), || (OU), ! (NÃO)
```

---

### 📥 Atribuição

Servem para atribuir e atualizar valores:

```
=, +=, -=, *=, /=
```

---

### 🔁 Incremento / Decremento

```
++, --
```

---

## 🔄 Incremento: diferença importante

### 📌 Pós-incremento (`count++`)

Primeiro usa o valor atual, depois incrementa:

```
int count = 5;
int x = count++;

System.out.println(x);     // 5
System.out.println(count); // 6
```

---

### 📌 Pré-incremento (`++count`)

Primeiro incrementa, depois usa o valor:

```
int count = 5;
int x = ++count;

System.out.println(x);     // 6
System.out.println(count); // 6
```

---

## 💻 Exemplos práticos

```
int a = 10;
int b = 5;

System.out.println(a + b);  // 15
System.out.println(a > b);  // true
```

---

## 🚀 Resumo rápido

* ➕ Aritméticos → cálculos
* 🔍 Comparação → retorna verdadeiro ou falso
* 🧠 Lógicos → controlam condições
* 📥 Atribuição → atualizam valores
* 🔁 `++` e `--` → incrementam ou decrementam valores