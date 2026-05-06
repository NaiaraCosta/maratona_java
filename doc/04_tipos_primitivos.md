# 📘 Guia — Tipos Primitivos em Java e Convenções de Código

Documento técnico para introduzir **tipos primitivos**, **convenções de variáveis**, **casting**, **`String`** e **fixação prática**, com foco em clareza conceitual, padrão profissional e entendimento explícito de **como os dados são representados e armazenados na memória**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 Em Java, os **tipos primitivos** são a forma mais básica e eficiente de armazenar dados.  
A linguagem possui **8 tipos primitivos**, responsáveis por guardar **valores simples diretamente na memória**, sem camadas extras de abstração.

Esses tipos seguem regras rígidas e bem definidas quanto a:

- **Forma de declaração**
- **Tamanho fixo em memória**
- **Intervalo mínimo e máximo de valores**
- **Regras de conversão entre tipos (casting)**
- **Convenções profissionais de nomenclatura**

Além disso, é fundamental compreender:
- O conceito de **inicialização de variáveis**
- Como ocorre a **impressão de valores no console**
- O que é **concatenação**
- A diferença entre **tipos primitivos** e **tipos de referência**, como a classe `String`

Esses fundamentos são a base para escrever **código Java correto, legível, previsível e profissional**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Tipos Primitivos em Java

Java possui exatamente **8 tipos primitivos**, todos definidos como **palavras reservadas da linguagem** e escritos **sempre em letras minúsculas**:

- `byte`
- `short`
- `int`
- `long`
- `float`
- `double`
- `char`
- `boolean`

Características essenciais dos tipos primitivos:

✅ Armazenam **valores simples**, não objetos  
✅ São armazenados **diretamente na memória**  
✅ Não possuem métodos nem comportamentos associados  
✅ Possuem **tamanho fixo**, definido pela especificação da linguagem

Eles existem para garantir **eficiência**, **previsibilidade** e **controle explícito de memória**.

---

### 🧭 Convenção de Nomes (Variáveis e Classes)

Seguir convenções de nomenclatura não é opcional: é um **padrão profissional** adotado em todo o ecossistema Java.

✅ **Classes**
- Começam com letra **maiúscula**
- Utilizam o padrão `UpperCamelCase`
- Exemplo: `Pessoa`, `CalculadoraSalario`

✅ **Variáveis**
- Começam com letra **minúscula**
- Usam o padrão `camelCase`
- Devem expressar claramente o significado do valor armazenado

Exemplos corretos:
- `idade`
- `idadeDoPai`
- `dataRecebimentoSalario`

🔔 **Boa prática recomendada:**  
Utilizar **inglês** para nomes de variáveis, métodos e classes, garantindo padronização internacional e melhor leitura em equipes globais.

---

### 🧾 Declaração e Inicialização de Variáveis

Toda variável em Java segue uma estrutura fixa:
```java
    tipo nome = valor;
```

Exemplo:
```java
    int idade = 10;
```

Componentes da declaração:

- `int` → tipo da variável
- `idade` → identificador (nome)
- `10` → valor inicial

📌 Observação importante:

- Apenas **declarar** uma variável não gera efeito visível algum.
- O valor só produz resultado quando é **utilizado**, por exemplo, 
em cálculos ou impressões no console.

---

### 🖨️ Impressão no Console e Concatenação

Para exibir informações na saída padrão (console), usa-se:
```java
    System.out.println();
```
Regras fundamentais:

- Variáveis **sem aspas** representam valores armazenados na memória
- Textos **entre aspas** são literais do tipo `String`

Exemplo:
```java
    System.out.println("Idade: " + idade);
```

Nesse caso:

- "Idade: " é um texto fixo
- idade é o valor da variável
- O operador `+` realiza **concatenação**

✅ Sempre usar `+` para concatenar
❌ Separar elementos com vírgula causa erro 
(exceto em métodos específicos como `printf`, vistos posteriormente)

---

### 🧠 Memória e Tamanho dos Tipos

Cada tipo primitivo ocupa uma **quantidade fixa de memória**, definida em bits e bytes.

Isso influencia diretamente o **intervalo mínimo e máximo** de valores que ele pode armazenar.

- `byte` → **1 byte** (8 bits) → -128 a 127
- `short` → **2 bytes** → -32.768 a 32.767
- `int` → **4 bytes** → padrão para números inteiros
- `long` → **8 bytes** → inteiros muito grandes
- `float` → **4 bytes** → números decimais
- `double` → **8 bytes** → maior precisão decimal
- `char` → **2 bytes** → representa um caractere `Unicode`
- `boolean` → valor lógico (`true` ou `false`)

📌 Escolher o tipo correto evita:

- Desperdício de memória
- Estouro de valores (`overflow`)
- Perda de precisão

---

### 🔄 Literais, Prefixos e Sufixos

**Literais** são valores escritos diretamente no código.

Regras padrões:

- Números inteiros → interpretados como `int`
- Números decimais → interpretados como `double`

Para forçar outros tipos, utilizam-se **sufixos**:

- `f` → força `float`
- `L` → força `long`

Exemplo:
```java
    float salario = 2500.0f;
    long populacao = 8000000000L;
```

📌 Sem o sufixo correto, o código não compila ou assume um tipo diferente do esperado.

---

### 🔀 Casting (Conversão Forçada)

`Casting` é a **conversão explícita** de um tipo maior **para um tipo menor**.

Sintaxe:
```java
    (tipo) valor
```

Exemplo:
```java
    int idade = (int) 15000000000L;
```

⚠️ Atenção:

- O Java **não impede** o casting
- `Bits` excedentes são descartados
- O valor final pode ser incorreto

✅ Casting só é seguro quando:

- Você conhece o valor real
- Tem certeza de que ele cabe no tipo de destino

---

### 🔡 Tipo `char` e Tabela ASCII / Unicode

O tipo `char` armazena um **único caractere**.

Características:

- Usa aspas simples: 'A'
- Armazena valores numéricos associados a caracteres

Exemplo:
```java
    char letra = 65; // imprime 'A'
```

Exemplo:
```java
    char letra = '\u0041'; // 'A'
```

📌 O char usa **2 bytes**, pois o Java adota o padrão **Unicode**, 
permitindo representar caracteres de vários idiomas.

---

### 🧵 String — Tipo de Referência

`String` não é um tipo primitivo.

Principais características:

- É uma **classe**
- Começa com letra **maiúscula**
- Armazena uma **referência a um objeto**, não o valor diretamente
- Usa **aspas duplas**

Exemplo:
```java
    String nome = "William";
```

Concatenação:
```java
    System.out.println("Oi, meu nome é " + nome);
```
📌 Apesar de parecer simples, `String` envolve conceitos como:

- `Heap` de memória
- Imutabilidade
- Objetos e referências

Esses tópicos são aprofundados mais adiante no estudo.

---

### 🚀 Síntese Final ✅🧠

- **Tipos primitivos** armazenam valores simples diretamente na memória
- Existem exatamente **8 tipos primitivos** em Java
- Todos são escritos em **letras minúsculas**
- Variáveis seguem o padrão `camelCase`
- `System.out.println()` exibe valores no console
- O operador `+` realiza concatenação
- `float` e `long` exigem sufixos (`f`, `L`)
- `Casting` força conversão, mas pode causar perda de dados
- char trabalha com **ASCII** e **Unicode**
- `String` é um **tipo de referência**, não primitivo
- Código bem nomeado é **autoexplicativo e profissional**

---