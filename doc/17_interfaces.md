# 📘 Guia — Interfaces em Java: Contratos, Implementação Múltipla e Recursos Avançados

Este guia explica **o papel das `interface`s em `Java`**, desde o conceito básico de contrato até recursos modernos introduzidos a partir do `Java 8`.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Interfaces em `Java` funcionam como contratos**: elas definem **o que** deve ser feito, mas não **como**, deixando a implementação para as classes concretas.  
Até o `Java 7`, todas as declarações de métodos em uma `interface` eram **obrigatoriamente abstratas**.  
A partir do `Java 8`, o modelo evoluiu, permitindo **métodos `default`** (com implementação) e **métodos `static`**, mantendo compatibilidade com código legado e ampliando o poder da linguagem.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 📜 Conceito Fundamental de Interface

Uma `interface`:
- **Não é uma `class`**
- **Não pode ser instanciada diretamente**
- Serve como **contrato de implementação**
- Define **comportamentos obrigatórios**

📌 Todos os métodos declarados são, por padrão:
- **`public`**
- **`abstract`** (até `Java 7`)

📌 Exemplo conceitual:
- `DataLoader` define o método `load`
- Classes concretas **devem implementar** esse método

---

### 🛠️ Criando e Implementando uma Interface

Quando uma classe implementa uma `interface`:
- Usa-se a palavra-chave **`implements`**
- **Não se utiliza `extends`**
- Todos os métodos abstratos devem ser implementados

✅ Exemplos:
- `DatabaseLoader` → carrega dados do banco
- `FileLoader` → carrega dados de arquivos

💬 A `interface` define o contrato, e cada classe decide **como** cumprir esse contrato.

---

### 🔗 Implementação de Múltiplas Interfaces

✨ **Grande vantagem das `interface`s**:

📌 Uma mesma classe pode implementar **quantas interfaces forem necessárias**.

Exemplo:
- `DatabaseLoader` implementa:
  - `DataLoader`
  - `DataRemover`

⚠️ Diferente de `class`:
- Uma classe **não pode** herdar de várias classes (`extends`)
- Mas **pode implementar várias `interface`s**

---

### 🚀 Métodos `default` — Evolução no Java 8

Antes do `Java 8`:
- Adicionar um método novo a uma `interface` **quebrava todas as classes**

💡 Solução:
- Introdução de métodos **`default`**

✅ Características:
- Possuem **implementação**
- **Não obrigam** as classes existentes a implementar
- Podem ser **sobrescritos** pelas classes

🧩 Exemplo conceitual:
- `checkPermission()` implementado na `interface`
- Classes podem aceitar o padrão ou sobrescrever

---

### 🔁 Sobrescrita e Modificadores de Acesso

📌 Regras importantes:
- Métodos em `interface` são **sempre `public`**
- Ao implementar, **não é permitido reduzir a visibilidade**
- Acesso nunca pode ser mais restritivo que o original

📊 Ordem de visibilidade:
- `private` → `default` (pacote) → `protected` → `public`

⚠️ Interfaces exigem implementação **sempre `public`**

---

### 🧱 Atributos em Interfaces

📌 Todos os atributos em uma `interface` são implicitamente:
- **`public`**
- **`static`**
- **`final`**

✅ Ou seja:
- São **constantes**
- Não podem ser modificadas

📌 Declarar modificadores é **redundante**, mas permitido para fins didáticos.

---

### ⚙️ Métodos `static` em Interfaces

Introduzidos a partir do `Java 8`.

✅ Características:
- Pertencem à `interface`
- **Não podem ser sobrescritos**
- São chamados diretamente pela `interface`

📌 Exemplo conceitual:
- `DataLoader.retrieveMaxDataSize()`

📍 Podem coexistir com métodos `static` de classes concretas, mesmo com o mesmo nome.

---

## 🚀 Síntese Final ✅🧠

- **`interface` define contratos**, não implementação direta
- Todos os métodos são **`public abstract`** por padrão
- Classes usam **`implements`**, nunca `extends`
- **Implementação múltipla** é permitida
- `Java 8` introduziu métodos **`default`** e **`static`**
- Métodos `default` evitam quebra de código legado
- Métodos `static` pertencem à `interface`
- Atributos são sempre **`public static final`**
- Interfaces promovem **desacoplamento**, **polimorfismo** e código mais sustentável

---