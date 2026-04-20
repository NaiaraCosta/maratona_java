# 📘 Guia Completo — Arrays em Java

Este guia apresenta de forma estruturada o conceito de **arrays em Java**, incluindo criação, inicialização, iteração, arrays multidimensionais e comportamento de memória. O objetivo é entender como os arrays funcionam tanto na prática quanto conceitualmente.

---

## 🧠 Resumo

Estruturas de array em Java permitem armazenar múltiplos valores do mesmo tipo em uma única variável, organizada por **índices**.

---

## 🧱 Arrays

Arrays são estruturas de dados que armazenam uma coleção de elementos do mesmo tipo. Eles são usados para organizar dados de forma eficiente e permitem acesso rápido aos elementos por meio de índices.

### 📦 Criação e Inicialização de Arrays

#### 📌 Declaração básica

```java
    int[] numeros;
```

Aqui temos uma variável de referência que ainda não aponta para nenhum array válido.

#### 📌 Inicialização com tamanho fixo

```java
    numeros = new int[5];
```

* Cria um array com 5 posições
* Índices vão de *0* a *4*
* Valores são inicializados automaticamente com 0

#### 📌 Inicialização com valores diretos

```java
    int[] numeros = {1, 2, 3, 4, 5};
```

* O tamanho é inferido automaticamente
* Não precisa usar *new* explicitamente

#### 📌 Alternativa com new

```java
    int[] numeros = new int[]{1, 2, 3, 4, 5};
```

### 📌 Acesso por Índice

```java
    numeros[0] = 21;
    System.out.println(numeros[0]);
```

### 📌 Regras importantes:

* O índice começa em *0*
* A última posição é *length - 1*
* Acesso inválido gera erro: `ArrayIndexOutOfBoundsException`

### 📏 Propriedade length

```java
    System.out.println(numeros.length);
```

* Retorna o tamanho do array
* Muito usado em loops
* Evita erros de índice fixo

### 🔁 Iteração com for

```java
    for (int i = 0; i < numeros.length; i++) {
        System.out.println(numeros[i]);
    }
```

#### 📌 Características:

* Controle total do índice
* Permite acesso direto à posição

### 🔁 Iteração com for-each

```java
    for (int i = 0; i < numeros.length; i++) {
        System.out.println(numeros[i]);
    }
```

#### 📌 Características:

* Não usa índice
* Mais simples e legível
* Variável num é uma referência temporária
* Não permite acessar posição diretamente

### 🧠 Arrays e Memória

* Arrays são *objetos em Java*
* Variáveis de array são *referências*
* Um array não armazena valores diretamente na variável

Exemplo conceitual:

```java
    int[] a = new int[3];
    int[] b = a;
```

### 🧩 Valores Padrão

Quando um array é criado, seus valores são inicializados automaticamente:

| Tipo             | Valor padrão |
| ---------------- | ------------- |
| int              | 0             |
| float/double     | 0.0           |
| char             | '\u0000' (vazio)              |
| boolean          | false              |
| String / objetos | null              |

### 🧱 Arrays Multidimensionais

Arrays multidimensionais são arrays de arrays.

O mais comum é o array bidimensional, que pode ser visualizado como uma tabela.

#### 📌 Declaração

```java
    int[][] matriz = new int[3][3];
```

#### 📌 Interpretação:

* 3 posições principais
* Cada posição aponta para outro array de 3 posições

#### 📌 Estrutura conceitual

    matriz[0] → [0, 0, 0]
    matriz[1] → [0, 0, 0]
    matriz[2] → [0, 0, 0]

#### 📌 Acesso

```java
    matriz[0][0] = 31;
    System.out.println(matriz[0][0]);
```

### ⚠️ NullPointerException em arrays multidimensionais

```java
int[][] matriz = new int[3][];
System.out.println(matriz[0][0]);
```

Erro:

    NullPointerException

##### 📌 Motivo:

* *matriz[0*] é *null*
* Não foi inicializado com outro array

---

### 🧱 Arrays irregulares (jagged arrays)

```java
int[][] matriz = new int[3][];

    matriz[0] = new int[2];
    matriz[1] = new int[3];
    matriz[2] = new int[6];
```

##### 📌Estrutura conceitual

    [0] → [0, 0]
    [1] → [0, 0, 0]
    [2] → [0, 0, 0, 0, 0, 0]

### 🔁 Iteração em matriz

```java
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.println(matriz[i][j]);
        }
    }
```

#### 📌 Ordem:

* i percorre linhas
* j percorre colunas

### 🧠 For-each com matriz

```java
    for (int[] linha : matriz) {
        for (int valor : linha) {
            System.out.println(valor);
        }
    }
```

### 🔄 Comportamento de referência

```java
    int[][] matriz = new int[3][];
    matriz[0] = new int[]{1, 2};
    matriz[1] = new int[]{3, 4, 5};
    matriz[2] = new int[]{6, 7, 8, 9};
```

* Cada posição aponta para um array diferente
* Estrutura pode ter tamanhos diferentes

### 🚨 Erros comuns

* ❌ Índice inválido → ArrayIndexOutOfBoundsException
* ❌ Referência nula → NullPointerException

---

## 🧠 Conceitos finais

* Arrays armazenam múltiplos valores do mesmo tipo
* Índice começa em 0
* *length* define tamanho fixo
* Arrays são objetos (referências)
* Multidimensionais são arrays de arrays
* Estruturas podem ser irregulares
* For-each simplifica iteração
* Erros comuns envolvem índice e null

---

## 🚀 Resumo final

* Arrays são estruturas fixas e indexadas
* São objetos na memória
* *length* evita erros de limite
* *for* e *for-each* são formas de iteração
* Arrays multidimensionais são matrizes
* Cada posição pode apontar para outro array
* Estruturas podem variar em tamanho
* NullPointerException ocorre por falta de inicialização

---