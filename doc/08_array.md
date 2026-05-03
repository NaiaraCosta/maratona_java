# 📘 Guia — Arrays em Java (Fundamentos, Iteração e Multidimensionais)

**Introdução prática aos `arrays` em `Java`, cobrindo declaração, inicialização, iteração, valores padrão e estruturas multidimensionais.**

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Arrays** são estruturas fundamentais para armazenar **múltiplos valores do mesmo tipo** sob uma **única referência**. Em `Java`, todo `array` é um **objeto**, mesmo quando armazena tipos primitivos.
Eles possuem **tamanho fixo**, são **indexados a partir de `0`** e oferecem diferentes formas de **inicialização** e **iteração**, incluindo `for` tradicional e `foreach`.
Também é possível trabalhar com **arrays multidimensionais**, que são **arrays de arrays**, permitindo estruturas mais complexas como tabelas e matrizes irregulares.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Conceito Base de `array`

- **Arrays agrupam dados do mesmo tipo** (`int`, `float`, `char`, `boolean`, `String`, etc.).
- Substituem múltiplas variáveis como `idade1`, `idade2`, `idade3`.
- Um `array` **é sempre um objeto**.
- A variável que o referencia é um **tipo reference**.

Exemplo:
```java
  int[] idades;
  idades = new int[3];
```

✅ Aqui:

- **idades** é uma **referência**
- `new int[3]` cria um **objeto em memória** com 3 posições

---

### 🧠 Tipos de Variáveis e null

- Tipos **primitivos** não aceitam `null`
- Tipos `referenc` aceitam `null`

➡️ `null` indica **ausência de referência a um objeto**.

---

### 🔢 Índices e Limites

- O índice **sempre começa em 0**
- Um `array` de tamanho **3** possui índices **0, 1, 2**
- Acessar índice inválido gera **ArrayIndexOutOfBoundsException**

Exemplo:
```java
  idades[0] = 21;
  idades[1] = 15;
  idades[2] = 11;
```

| Tipo                   | Valor Padrão            |
|------------------------|-------------------------|
| byte, short, int, long | 0                       |
| float, double          | 0.0                     |
| char                   | '\u0000' (espaço vazio) |
| boolean                | false                   |
| Tipos reference        | null                    |

--- 

### 🔁 Iteração com for

A forma clássica de percorrer um array:

Exemplo:
```java
    for (int i = 0; i < nomes.length; i++) {
        System.out.println(nomes[i]);
    }
```

✅ Uso de length:

- Evita erros
- Torna o código escalável
- Adapta a lógica ao tamanho real do `array`

--- 

### 🚀 Iteração com foreach

Forma simplificada para acessar valores, sem índices:

Exemplo:
```java
    for (int num : numeros) {
        System.out.println(num);
    }
```

⚠️ Atenções:

- Não fornece índice
- Não permite acesso direto a posições específicas
- Ideal para leitura simples

--- 

### 🧪 Inicialização Direta de arrays

#### Forma simplificada (sem new explícito):

Exemplo:
```java
    int[] numeros = {1, 2, 3, 4, 5};
```

#### Com new + valores:

Exemplo:
```java
    int[] numeros = new int[]{1, 2, 3, 4, 5};
```

✅ O tamanho é calculado automaticamente.

--- 

### 🧩 Arrays Multidimensionais

- São **arrays que armazenam outros arrays**
- Estrutura comum: `int[][]`

Exemplo:
```java
    int[][] dias = new int[3][];
```

✅ Apenas a **base** precisa de tamanho inicial.
As subestruturas podem variar.

--- 

### 🧱 Inicialização Dinâmica (Irregular)

Exemplo:
```java
    dias[0] = new int[2];
    dias[1] = new int[3];
    dias[2] = new int[6];
```

➡️ Isso cria uma **matriz irregular**.
📌 Cada `dias[i]` é um `int[]` independente.

--- 

### 🔄 Iteração em Arrays Multidimensionais

#### Usando for aninhado:

Exemplo:
```java
    for (int i = 0; i < dias.length; i++) {
        for (int j = 0; j < dias[i].length; j++) {
            System.out.println(dias[i][j]);
        }
    }
```

✅ Uso correto de `dias[i].length`
✅ Evita suposições de tamanho

--- 

### 🔁 Multidimensional com foreach

Exemplo:
```java
    for (int[] arrayBase : dias) {
        for (int num : arrayBase) {
            System.out.println(num);
        }
    }
```

⭐ Mais legível
⭐ Menos propenso a erros
⚠️ Sem acesso a índices

--- 

### ♻️ Referência e Garbage Collector

Quando um `array` recebe uma nova referência:

Exemplo:
```java
    nomes = new String[5];
```

- O `array` antigo **perde a referência**
- Torna-se elegível ao Garbage Collector

✅ Memória antiga é liberada automaticamente.

--- 

### 🚀 Síntese Final ✅🧠

- `arrays` **são objetos**
- Variáveis de array são **tipos reference**
- Índices começam em **0**
- Tamanho é fixo após criação
- `length` é essencial para iteração segura
- Valores padrão são inicializados automaticamente
- `for` dá controle total
- `foreach` simplifica leitura
- Arrays multidimensionais são **arrays de arrays**
- Subarrays podem ter tamanhos diferentes
- Reatribuição perde a referência anterior
- Uso correto evita exceções como `ArrayIndexOutOfBoundsException` e `NullPointerException`

--- 