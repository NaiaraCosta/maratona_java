# 🎲 Tipos de Dados

Os tipos de dados em Java definem **quais valores podem ser armazenados** e **como eles são manipulados na memória**.

---

## 🔢 Tipos primitivos

Os tipos primitivos armazenam **valores simples diretamente na memória**.

### 📦 Lista de tipos

```
byte    → inteiros pequenos (-128 a 127)
short   → inteiros curtos (-32.768 a 32.767)
int     → inteiros comuns
long    → inteiros longos

float   → números decimais (precisão simples)
double  → números decimais (precisão dupla)

char    → um único caractere ('A')
boolean → valores lógicos (true ou false)
```

---

## 🧠 Tipos de referência

Diferente dos primitivos, os tipos de referência armazenam **endereços de memória** que apontam para objetos.

Exemplos:

* 🔠 `String`
* 📚 Arrays
* 🧱 Classes personalizadas

---

## 🔠 String

A `String` representa uma **sequência de caracteres (texto)**.

💡 Apesar de muito usada, **não é um tipo primitivo**, e sim um objeto.

### 📌 Características

* 📦 Pertence ao pacote `java.lang`
* 🔒 **Imutável** → não pode ser alterada após a criação
* 🧠 Amplamente utilizada para manipulação de texto

### ✍️ Formas de criação

```
String nome = "João";
String nome2 = new String("João");
```

---

## 📊 Representação visual

![Variáveis](img/variaveis.png)

![Tabela ASCII](img/tabela_ascii.png)

![Tabela Unicode](img/tabela_unicode.jpg)

---

## 🧪 Variáveis

Uma variável é um espaço na memória utilizado para **armazenar um valor**.

### 📌 Sintaxe básica

```
tipo nomeDaVariavel = valor;
```

---

### 💻 Exemplos

```
int idade = 25;
double salario = 3500.50;
boolean ativo = true;
String nome = "João";
```

---

## 🚀 Resumo rápido

* 🔢 Tipos primitivos armazenam valores diretos
* 🧠 Tipos de referência armazenam endereços de objetos
* 🔠 `String` é um objeto imutável muito utilizado
* 📦 Variáveis guardam valores na memória