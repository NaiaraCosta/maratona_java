# 📘 Guia — Métodos, Parâmetros e Passagem de Dados em Java

Este guia explica como funcionam os **métodos em Java**, incluindo retorno de valores, passagem de parâmetros (primitivos e referência), uso de arrays, VarArgs e comportamento de memória.

---

## 🧠 Resumo

Em Java, métodos são blocos de código responsáveis por executar ações dentro de objetos.

Eles podem:

* Receber parâmetros
* Retornar valores ou não (`void`)
* Trabalhar com tipos primitivos ou tipos de referência
* Manipular dados conforme o escopo e o contexto de memória

---

## Métodos

São blocos de código definidos dentro de classes que executam tarefas específicas,
permitindo a reutilização e organização do código.

Estruturados com modificador de acesso, tipo de retorno, nome e parâmetros,
eles funcionam como funções ou procedimentos.

São essenciais na programação orientada a objetos para manipular dados de objetos.

### 🧩 Estrutura Básica

Um método em Java segue a estrutura:

```java
    public void nomeDoMetodo() {
        // instruções
    }
```

Ou com retorno:

```java
    public int nomeDoMetodo() {
        return 0;
    }
```

### 📌 Componentes de um método:

* Modificador de acesso (public)
* Tipo de retorno (void, int, double, etc.)
* Nome do método
* Parâmetros (opcional)
* Corpo do método

### 🔁 Métodos com void (sem retorno)

Métodos void executam ações, mas não retornam valores.

```java
    public void somaDoisNumeros() {
        System.out.println(10 + 10);
    }
```

#### 📌 Importante:

* Pode ter saída no console
* Mas não retorna valor para quem chamou

### 🔁 Métodos com retorno

Métodos podem retornar valores usando return.

```java
    public double divideDoisNumeros() {
        return 10.0 / 2.0;
    }
```

#### ⚠️ Regras importantes:

* O tipo de retorno deve ser respeitado
* Sempre deve haver return quando não for void

### ⚠️ Controle com return

O 'return' também interrompe a execução do método.

```java
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            return 0;
        }
        return num1 / num2;
    }
```

**📌 O return funciona como uma “saída imediata” do método.**

### 🧠 Parâmetros em métodos

Parâmetros são valores enviados para o método executar sua lógica.

```java
    public void multiplicaDoisNumeros(int num1, int num2) {
        System.out.println(num1 * num2);
    }
```

#### 📌 Regras:

* Parâmetros são variáveis locais
* Só existem dentro do método
* São recebidos na chamada do método

#### 📤 Argumentos vs Parâmetros

* *Parâmetros* → definidos no método
* *Argumentos* → valores passados na chamada

```java
    multiplicaDoisNumeros(10, 20);
```

### 🧠 Tipos primitivos (cópia de valor)

Quando passamos tipos primitivos, Java cria uma cópia do valor.

```java
    public void alteraNumeros(int num1, int num2) {
        num1 = 99;
        num2 = 33;
    }
```

#### 📌 Comportamento:

* O valor original não é alterado
* Apenas a cópia local muda

✔ Isso ocorre porque primitivos são passados por valor.

### 🧠 Tipos de referência (objetos)

Quando passamos objetos, Java envia a referência da memória.

```java
    public void imprimeEstudante(Estudante estudante) {
        estudante.nome = "Goku";
    }
```

#### 📌 Comportamento:

* O objeto original pode ser alterado
* Todas as referências apontam para o mesmo objeto

#### ⚠️ Efeito colateral em objetos

```java
    estudante.nome = "Gohan";
```

📌 Isso afeta todas as variáveis que apontam para o mesmo objeto.

#### 🧠 Palavra-chave this

Dentro de um objeto, usamos this para referenciar seus próprios atributos.

```java
    public void imprime() {
        System.out.println(this.nome);
        System.out.println(this.idade);
    }
```

##### 📌 Significado:

* *this* = objeto atual
* Evita ambiguidades com variáveis locais

#### 🎛️ Métodos dentro de objetos

Métodos podem ser chamados diretamente pela variável de referência:

```java
    estudante.imprime();
```

##### 📌 Aqui:

* A variável de referência atua como um “controle remoto”
* O objeto executa o método

#### 🧠 Encapsulamento e organização

Boa prática:

* Evitar alterar objetos recebidos diretamente
* Preferir criar novos objetos quando necessário

### 📦 Arrays como parâmetros

Arrays podem ser passados normalmente:

```java
    public void somaArray(int[] numeros) {
        int soma = 0;
  
        for (int num : numeros) {
            soma += num;
        }
  
        System.out.println(soma);
    }
```

### 🚀 VarArgs (argumentos variáveis)

VarArgs permite passar vários valores sem criar array manualmente.

```java
    public void somaVarArgs(int... numeros) {
    int soma = 0;
  
        for (int num : numeros) {
            soma += num;
        }
  
        System.out.println(soma);
    }
```

#### 📌 Uso:

```java
    somaVarArgs(1, 2, 3, 4, 5);
```

#### ⚠️ Regras do VarArgs

* Deve ser o último parâmetro
* Só pode existir um VarArgs por método
* Internamente é tratado como um array

```java
    public void exemplo(String nome, int... numeros) {
    }
```

❌ Inválido:

```java
    public void exemplo(int... numeros, String nome);  
```

### 🧠 Diferença: Array vs VarArgs

| Array                    | VarArgs                |
|--------------------------| ---------------------- |
| Precisa ser criado antes | Pode passar direto     |
| Sintaxe mais rígida      | Sintaxe mais flexível |
| int[]                    | int... |

### 🧠 Controle de execução em métodos

Fluxo de execução:

* Método é chamado
* Parâmetros são recebidos
* Lógica executa
* return encerra o método
* Retorna para quem chamou

### 🔄 Método dentro de objeto

```java
    estudante.imprime();
```

📌 O método acessa diretamente os atributos do objeto.

---

## 🧠 Conceitos finais

* Métodos executam ações dentro de objetos
* *void* não retorna valores
* *return* finaliza execução
* Primitivos são copiados
* Objetos compartilham referência
* *this* representa o objeto atual
* VarArgs simplifica múltiplos parâmetros
* Arrays e VarArgs são equivalentes internamente

---

## 🚀 Resumo final

* Métodos são blocos de comportamento
* Parâmetros são dados de entrada
* Argumentos são valores enviados
* Primitivos são passados por cópia
* Objetos são passados por referência
* Alterações em objetos afetam todas as referências
* *this* acessa o próprio objeto
* VarArgs facilita múltiplos argumentos
* *return* controla saída e fluxo do método

---