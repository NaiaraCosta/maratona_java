# 📘 Guia Completo — Curso Java (Maratona Java)

Este documento reúne os principais conceitos iniciais do Java, incluindo **tipos primitivos, variáveis, memória, casting, String, convenções de código, debug e boas práticas de desenvolvimento**.

---

## 🧠 Resumo

Java é uma linguagem fortemente tipada baseada em:

* Tipos primitivos (valores simples em memória)
* Tipos por referência (como String)
* Regras de declaração e convenções de código
* Manipulação de memória de forma abstrata
* Ferramentas de debug e execução no IntelliJ IDEA

---

## 💻 Ambiente, IDE e Organização de Código

### ⚙️ Execução no IntelliJ IDEA

Atalhos importantes:

* `Ctrl + Shift + F10` → Executa a classe atual
* `Shift + F10` → Executa novamente a última execução
* `Ctrl + F9` → Rebuild do projeto

### 🧠 Atalho de criação de main

No IntelliJ, para criar rapidamente o método `main`, basta digitar `psvm` e pressionar `Tab`. Isso gera automaticamente a estrutura básica do método principal:

    psvm + Tab

Gera automaticamente:

```java
        public static void main(String[] args) {
        }
```

---

## 📦 Tipos Primitivos em Java

Java possui 8 tipos primitivos:

* int
* double
* float
* char
* byte
* short
* long
* boolean

### 📌 Características

* Sempre em letras minúsculas
* Representam valores simples
* Armazenam diretamente na memória
* Não são objetos

---

## 🧠 Conceito de memória

Cada variável ocupa um espaço na memória com tamanho fixo definido pelo tipo.

### 📊 Exemplos de declaração

```java
    int idade = 10;
    double salario = 2500.50;
    float altura = 1.75f;
    long populacao = 9000000000L;
    boolean ativo = true;
    char inicial = 'A';
```

---

## ⚠️ Literais e Sufixos (L, F, D)

### 📌 Problema de tipos literais

Por padrão:

* Números inteiros → int
* Números decimais → double

###  🔧 Solução: sufixos

```java
    float salario = 2500.50f;
    long numeroGrande = 100000L;
    double valor = 10.5d;
```

### ⚠️ Regras importantes

* `f` → Float
* `l` → Long
* `d` → Double (opcional)

---

## 🔁 Casting (Conversão de tipos)

### 📌 O que é casting?

É a conversão explícita entre tipos primitivos.

### 🧱 Exemplo (narrowing)

```java
    long valorGrande = 10000L;
    int valorPequeno = (int) valorGrande;
```

### ⚠️ Problema do casting

Pode ocorrer perda de dados:

* valores são truncados
* parte da informação é descartada

### 📊 Analogia

long = balde grande
int = copo pequeno

➡ Ao transferir, pode transbordar ou perder conteúdo

### ❌ Má prática

Usar casting sem necessidade pode gerar:

* Perda de precisão
* Bugs silenciosos
* Comportamento imprevisível

---

## 🧵String em Java

###📌 O que é String?

String NÃO é tipo primitivo.

É um:

Tipo de referência (classe)

### 📌 Declaração

```java
    String nome = "João";
```

### 📌 Diferença de aspas

* 'A' → char
* "A" → String

### 🔗 Concatenação

```java
    System.out.println("Olá " + nome);
```

### 📌 Regras importantes

* String é classe
* Usa aspas duplas
* Pode armazenar textos grandes
* É imutável

---

## 🧠 Memória e concatenação

Quando usamos:

```java
    String mensagem = "Olá " + nome;
```

O Java:

* Cria múltiplos objetos temporários
* Concatena valores em memória
* Gera uma nova string final

---

## ⚙️ Convenções de código

### 📌 Variáveis (camelCase)

```java
    int idadeDoPai;
    String nomeCompleto;
```

✔ Primeira letra minúscula
✔ Palavras seguintes com maiúscula

### 📌 Classes (PascalCase)

```java
    public class OlaDevDojo {
    }
```

### 📌 Boas práticas

* Nomes descritivos
* Inglês recomendado
* Evitar abreviações confusas

---

## 🔍 Debug no IntelliJ IDEA

### 📌 O que é debug?

Permite executar o código passo a passo.

### ⚙️ Atalhos

* `Shift + F9` → Iniciar debug
* `F8` → Step over (linha por linha)
* `F9` → Continuar execução

### 🧠 O que o debug mostra

* Valores das variáveis em tempo real
* Fluxo de execução
* Estado da memória

### 📌 Uso prático

Permite identificar:

* Erros lógicos
* Valores inesperados
* Comportamento da aplicação

---

## ⚠️ Comentários e debug vs código limpo

### 📌 Comentários
* `//` → Linha única
* `/* */` → Múltiplas linhas
* JavaDoc → Documentação oficial

### 📌 Boas práticas

* Evitar comentários óbvios
* Preferir código legível
* Usar javadoc quando necessário

---

## 🚀 Resumo final

* Java possui 8 tipos primitivos
* String é tipo de referência, não primitivo
* Casting pode causar perda de dados
* Sufixos definem tipos literais (L, F, D)
* Variáveis seguem camelCase
* Classes seguem PascalCase
* Debug ajuda a entender execução passo a passo
* Concatenação usa `+`
* Código limpo é mais importante que comentários excessivos
* Memória é abstraída, mas ainda é fundamental no entendimento

---