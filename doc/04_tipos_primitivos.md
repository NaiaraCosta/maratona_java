# 📘 Guia — Tipos Primitivos em Java e Convenções de Código

Documento técnico para introduzir **tipos primitivos**, **convenções de variáveis**, **casting**, **`String`** e **fixação prática**, com foco em clareza, padrão profissional e entendimento de memória.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 Java possui **8 tipos primitivos**, responsáveis por armazenar **valores simples diretamente na memória**.  
Eles seguem regras rígidas de **declaração**, **tamanho em memória**, **limites de valor** e **convenções de nomenclatura**.

Além disso, entender:
- **Inicialização**
- **Impressão no console**
- **Concatenação**
- **Casting**
- Diferença entre **tipo primitivo** e **tipo de referência (`String`)**

é essencial para escrever código Java correto, legível e profissional.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Tipos Primitivos em Java

Os **8 tipos primitivos** são **palavras reservadas**, escritas **sempre em minúsculo**:

- `byte`
- `short`
- `int`
- `long`
- `float`
- `double`
- `char`
- `boolean`

✅ Todos armazenam **valores simples**  
✅ Não possuem métodos  
✅ Possuem **tamanho fixo em memória**

---

### 🧭 Convenção de Nomes (Variáveis e Classes)

✅ **Classes**
- Primeira letra **maiúscula**
- `UpperCamelCase`

✅ **Variáveis**
- Primeira letra **minúscula**
- Palavras compostas em `camelCase`

Exemplos:
- `idade`
- `idadeDoPai`
- `dataRecebimentoSalario`

🔔 **Boa prática:** usar nomes em **inglês** para padronização internacional.

---

### 🧾 Declaração e Inicialização de Variáveis

A sintaxe segue sempre o padrão:
```text
    tipo nome = valor;
```

Exemplo:
```java
    int idade = 10;
```

📌 Apenas declarar **não executa nada** — é necessário **usar** o valor.

---

### 🖨️ Impressão no Console e Concatenação

Uso do método:
```java
    System.out.println();
```

- Variável **sem aspas** → valor da memória
- Texto **com aspas** → `String` literal

Concatenação:
```java
    System.out.println("Idade: " + idade);
```

✅ Sempre usar `+`  
❌ Vírgula gera erro (exceto em `printf`, visto depois)

---

### 🧠 Memória e Tamanho dos Tipos

A diferença entre os tipos é a **quantidade de bits alocados**:

- `byte` → **1 byte** (8 bits) → -128 a 127
- `short` → **2 bytes**
- `int` → **4 bytes**
- `long` → **8 bytes**
- `float` → **4 bytes**
- `double` → **8 bytes**
- `char` → **2 bytes**
- `boolean` → **1 bit lógico**

📌 Limites importam ao escolher o tipo correto.

---

### 🔄 Literais, Prefixos e Sufixos

Valores escritos diretamente no código são **literais**.

- Inteiros → `int` por padrão
- Decimais → `double` por padrão

Forçar tipo:
- `float` → sufixo `f`
- `long` → sufixo `L`

Exemplos:
```java
    float salario = 2500.0f;
    long populacao = 8000000000L;
```

---

### 🔀 Casting (Conversão Forçada)

**Casting** é forçar um tipo maior em um menor.

Sintaxe:
```java
    (tipo) valor
```

Exemplo:
```java
    int idade = (int) 15000000000L;
```

⚠️ **Risco:** perda de dados (bits são cortados).

✅ Seguro apenas quando você **tem certeza** do valor.

---

### 🔡 Tipo `char` e Tabela ASCII / Unicode

O tipo `char` armazena **um único caractere**:

- Aspas simples: `'A'`
- Pode receber valor numérico (ASCII)

Exemplo:
```java
    char letra = 65; // imprime 'A'
```

Exemplo (UNICODE):
```java
    char letra = '\u0041'; // 'A'
```

📌 Usa **2 bytes** para suportar caracteres asiáticos.

---

### 🧵 `String` — Tipo de Referência
`String` **não é tipo primitivo**.

✅ É uma **classe**
✅ Começa com letra **maiúscula**
✅ Usa aspas **duplas**

Exemplo:
```java
    String nome = "William";
```

Concatenação funciona da mesma forma:
```java
    System.out.println("Oi, meu nome é " + nome);
```

---

## 🚀 Síntese Final ✅🧠

- **Tipos primitivos** armazenam valores simples em memória
- Todos são escritos em **minúsculo**
- Variáveis seguem `camelCase`
- `System.out.println()` imprime valores
- `+` concatena textos e variáveis
- `float` e `long` exigem sufixos (`f`, `L`)
- **Casting** força conversão, mas pode perder dados
- `char` trabalha com ASCII e Unicode
- `String` é **tipo de referência**, não primitivo
- Código bem nomeado é **auto-documentado**

---