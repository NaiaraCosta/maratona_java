# 📘 Guia Completo — Estruturas Condicionais em Java

Este guia apresenta as principais **estruturas condicionais em Java**, abordando `if`, `else`, `else if`, operador ternário, tabela verdade e `switch`, com foco em **controle de fluxo**, **legibilidade** e **comportamento lógico** do código.

---

## 🧠 Resumo

Estruturas condicionais permitem que um programa **tome decisões** com base em expressões booleanas (`true` ou `false`).

Principais estruturas:

* `if`
* `if / else`
* `if / else if / else`
* Operador ternário
* Operadores lógicos
* `switch`

---

## 💻 Estrutura Condicional IF

Usada para executar código **somente quando uma condição é verdadeira**.

### 📌 Sintaxe básica

```java
  if (condicao) {
      // código executado se a condição for true
  }
```  

### ⚠️ Regras importantes

* A condição deve retornar boolean
* = é atribuição
* == é comparação
* Sempre utilizar chaves {}

---

## 🔁 IF / ELSE

Permite definir um caminho alternativo quando o if não é executado.

### 📌 Estrutura

```java
    if (condicao) { 
        // executa se true
    } else {
        // executa se false
    }
```

### 🧠 Comportamento

* Apenas um bloco é executado
* else não possui condição
* else sempre depende de um if

---

## 🔗 IF / ELSE IF / ELSE

Usado quando existem múltiplas condições baseadas na mesma variável.

### 📌 Estrutura encadeada

```java
    if (condicao1) {
        // bloco 1
    } else if (condicao2) {
        // bloco 2
    } else {
        // bloco final
    }
```

###  🧪 Comportamento importante

A avaliação ocorre em sequência
Ao encontrar uma condição true, o restante é ignorado

---

## ⚙️ Operador Ternário

Usado para atribuir valores diretamente com base em uma condição.

### 📌 Forma tradicional (if / else)

```java
    if (condicao) {
        resultado = valor1;
    } else {
        resultado =valor2;
    }
```

### 🔥 Forma com operador ternário

```java
  resultado = condicao ? valor1 : valor2;
```

### ⚠️ Observações

* Sempre retorna um valor
* Tipos devem ser compatíveis
* Evitar ternários complexos

---

## 🧠 Operadores Lógicos

Usados para combinar condições.

### 🔥 AND (&&)

📌 Verdadeiro somente se todas forem verdadeiras

```java
    if (condicao1 && condicao2) {
        // executa apenas se ambas forem true
    }
```

#### 🧪 Tabela verdade (AND)

true && true → true
true && false → false
false && true → false
false && false → false

### 🔥 OR (||)

📌 Verdadeiro se pelo menos uma for verdadeira

```java
    if (condicao1 || condicao2) {
        // executa se qualquer uma for true
    }
```

#### 🧪 Tabela verdade (OR)

true || false → true
false || true → true
false || false → false

### ❗ NOT (!)

📌 Inversão lógica

```java
    if (!condicao) {
        // executa se a condição for false
    }
```
---

## 🔀 Estrutura SWITCH

Usada para decisões baseadas em valores fixos.

📌 Sintaxe básica

```java
    switch (valor) {
        case 1:
            System.out.println("Domingo");
            break;
        case 2:
            System.out.println("Segunda");
            break;
        default:
            System.out.println("Opção inválida");
    }
```

### ⚠️ Comportamento importante

Sem break, ocorre fall-through
default cobre valores não correspondentes
break encerra a execução do switch

---

## 🧠 Conceitos finais

* Estruturas condicionais controlam decisões
* `if` e `else` formam a base da lógica
* Operadores lógicos combinam condições
* Operador ternário simplifica atribuições
* `switch` melhora organização em escolhas diretas

---

## 🚀 Resumo final

* Condições são fundamentais em Java
* Booleanos dirigem o fluxo do programa
* Código claro evita bugs e erros lógicos
* Legibilidade é tão importante quanto funcionamento

---