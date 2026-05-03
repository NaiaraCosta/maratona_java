# 📘 Guia — Classes Utilitárias no Java: Wrappers, Boxing e Unboxing

Documento introdutório sobre **classes utilitárias `Wrapper` em Java**, explicando conceitos fundamentais, motivação, regras de uso e os mecanismos de **`autoboxing`** e **`unboxing`**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 O Java é uma linguagem **orientada a objetos**, porém possui **tipos primitivos** (`int`, `double`, `boolean`, etc.) que **não são objetos**.  
Para integrar esses tipos ao modelo OO — especialmente em **coleções**, **polimorfismo**, **threads** e **APIs utilitárias** — o Java fornece as **classes `Wrapper`**, que **encapsulam tipos primitivos em objetos**.

Essas classes permitem:
- Tratar valores primitivos como **objetos**
- Utilizar **métodos utilitários**
- Permitir **passagem por referência**
- Trabalhar com **estruturas do pacote de coleções**

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 O que são Wrappers?

Wrappers são **classes que representam tipos primitivos como objetos**.  

Cada tipo primitivo possui um equivalente `Wrapper`.

📌 Tipos primitivos e seus Wrappers:

- `byte` → `Byte`
- `short` → `Short`
- `int` → `Integer` (**exceção**)
- `long` → `Long`
- `float` → `Float`
- `double` → `Double`
- `char` → `Character` (**exceção**)
- `boolean` → `Boolean`

➡️ Regra geral: **mesmo nome do tipo primitivo com a primeira letra maiúscula**, exceto `int` e `char`.

---

### 🧬 Relação com Orientação a Objetos

- Tipos primitivos **não herdam de `Object`**
- Wrappers **são objetos** e herdam de `Object`
- Classes numéricas herdam de `Number`

📌 Exemplo:

- `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double` → **herdam de `Number`**

Isso permite:

- Uso de **polimorfismo**
- Chamada de **métodos**
- Uso em **APIs OO**

---

### ⚠️ Diferença Crítica: Valor vs Objeto

- Tipos primitivos seguem regras de **tamanho em memória**
- Wrappers seguem regras de **herança e polimorfismo**

📌 Exemplo conceitual:

- Um `int` pode caber em um `long`
- Um `Integer` **não é** um `Long`

➡️ Ao usar Wrappers, **não existe conversão automática baseada em tamanho**, apenas **compatibilidade por herança**.

---

### 🔄 Autoboxing e Unboxing

#### 📦 Autoboxing

Conversão automática de **tipo primitivo → Wrapper**

Exemplo conceitual:
- `int` → `Integer`

➡️ O Java faz isso automaticamente quando necessário.

#### 📤 Unboxing

Conversão automática de **Wrapper → tipo primitivo**

Exemplo conceitual:

- `Integer` → `int`

➡️ Também automático, mas exige atenção para evitar `NullPointerException`.

---

### 🧰 Métodos Utilitários dos Wrappers

Wrappers fornecem **métodos estáticos e de instância** que não existem nos tipos primitivos.

📌 Exemplos comuns:
- `Integer.parseInt(String)`
- `Double.parseDouble(String)`
- `Boolean.parseBoolean(String)`

⚠️ Construtores diretos como `new Integer(...)` estão **deprecated**.  

✅ Use sempre métodos como `parseXxx` ou `valueOf`.

---

### 🔤 Destaque: Classe `Character`

A classe `Character` possui **métodos utilitários poderosos**, todos **estáticos**:

- `Character.isDigit(char)`
- `Character.isLetter(char)`
- `Character.isUpperCase(char)`
- `Character.isLowerCase(char)`
- `Character.toUpperCase(char)`
- `Character.toLowerCase(char)`

📌 Esses métodos facilitam validações que manualmente seriam complexas.

---

### 📦 Wrappers e Coleções

Estruturas do pacote `java.util`:
- `List`
- `Set`
- `Map`

❌ **Não aceitam tipos primitivos** 

✅ Trabalham apenas com **referências**

📌 Exemplo conceitual:

- ❌ Lista de `int`
- ✅ Lista de `Integer`

Motivo: coleções armazenam **objetos**, não valores brutos.

---

### 🧵 Wrappers e Concorrência

- Sincronização (`synchronized`) trabalha com **objetos**
- Wrappers são amplamente usados em **ambientes concorrentes**
- Essenciais para `threads`, locks e controle de estado compartilhado

---

### ✅ Boas Práticas

- Utilize **tipos primitivos sempre que possível**
- Use **Wrappers quando necessário**, especialmente:
  - Coleções
  - APIs que exigem objetos
  - Polimorfismo
  - Concorrência
- Evite construtores deprecated
- Prefira **métodos estáticos utilitários**

---

## 🚀 Síntese Final ✅🧠

- **Wrappers encapsulam tipos primitivos em objetos**
- Cada tipo primitivo possui um `Wrapper`
- Exceções: `Integer` e `Character`
- Wrappers permitem **OO completo**, métodos e polimorfismo
- **`autoboxing`**: primitivo → objeto
- **`unboxing`**: objeto → primitivo
- Coleções exigem **Wrappers**
- `Character` oferece métodos utilitários valiosos
- **Prefira primitivos**, use Wrappers quando necessário

---