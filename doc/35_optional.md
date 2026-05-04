# 📘 Guia — `Optional` em `Java` 8+ (Introdução e Uso Prático)

Guia técnico sobre a classe `Optional`, seu propósito, criação, boas práticas e aplicação prática em cenários reais com repositórios.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **`Optional`** é uma classe introduzida no `Java 8` com foco principal em **reduzir problemas de `NullPointerException`** e **tornar explícito quando um método pode não retornar valor**.  
Em vez de retornar `null`, um método passa a retornar um **wrapper semântico** que obriga o desenvolvedor a lidar com a ausência de valor de forma consciente, favorecendo **código mais legível, seguro e funcional**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🎁 O que é `Optional` e por que usar

- **`Optional`** é um objeto que **encapsula outro objeto**, podendo ou não conter um valor.
- Objetivo central: **evitar `NullPointerException`**.
- Torna **explícito no contrato do método** que o retorno pode ser ausente.
- Substitui padrões antigos como:
  - Retorno de `null`
  - Cadeias extensas de `if (obj != null)`

✅ **Benefício-chave**: quando você vê um método retornando `Optional<T>`, você **já é forçado a pensar no cenário negativo**.

---

### ⚠️ Problema clássico sem `Optional`

- Método retorna `null` quando não encontra valor.
- Em outro ponto do código, algo como `name.toUpperCase()` é chamado.
- Resultado: **`NullPointerException` em tempo de execução**.

---

### 🛠️ Formas de criar um `Optional`

✅ Três formas principais:

- **`Optional.of(valor)`**
  - Valor **não pode ser `null`**
  - Caso seja `null`, lança `NullPointerException`

- **`Optional.ofNullable(valor)`**
  - Aceita valor ou `null`
  - Se `null`, retorna `Optional.empty()`

- **`Optional.empty()`**
  - Cria explicitamente um `Optional` vazio

📌 **Boa prática**: quando não há certeza se o valor existe, **use sempre `ofNullable`**.

---

### 🔍 Extraindo valores do `Optional`

- **`orElse(valorPadrao)`**
  - Retorna o valor interno ou um padrão

- **`orElseGet(() -> valor)`**
  - Usa `Supplier`, valor só é criado se necessário

- **`orElseThrow(() -> exception)`**
  - Lança exceção se vazio
  - Muito útil para validações obrigatórias

---

### ✅ Execução condicional com `ifPresent`

- **`ifPresent(consumer)`**
  - Executa ação **somente se houver valor**
  - Usa `Consumer<T>` (`void accept(T t)`)

📌 Ideal para efeitos colaterais:

- Logs
- Atualizações
- Operações sem retorno

---

### 🚫 Quando **NÃO** usar `Optional`

❌ **Não usar como parâmetro de método**  
❌ **Não usar como atributo de classe**

Motivos:

- `Optional` **não é serializável**
- Quebra integração com frameworks como `JPA` e `Hibernate`
- A própria API da Oracle **desencoraja esses usos**

✅ **Uso recomendado**: **apenas como retorno de métodos**

---

### 🧪 Exemplo prático — Repositório de `Manga`

#### 📦 Domínio `Manga`

- Atributos
  - `Integer id`
  - `String title`
  - `int chapters`
- `setters` apenas para `title` e `chapters`

---

#### 🗃️ Repositório simulando banco em memória

- Lista `static` de `Manga`
- Métodos retornam **`Optional<Manga>`**

---

### 🔄 Reuso com `Predicate<Manga>`

✅ Em vez de duplicar código:

- Criar método genérico
  - `findBy(Predicate<Manga> predicate)`
- Métodos especializados
  - `findByTitle`
  - `findById`

📌 **Vantagem**:

- Menos duplicação
- Mais flexibilidade
- Melhor aderência à **programação funcional**

---

### ✅ Casos de uso resolvidos com `Optional`

#### 1️⃣ Atualizar título se existir

- Usar `findByTitle`
- Aplicar `ifPresent`
- Atualizar com `setTitle`

---

#### 2️⃣ Buscar por `id` e lançar exceção se não existir

- Usar `findById`
- Aplicar `orElseThrow`
- Exceção: `IllegalArgumentException`

---

#### 3️⃣ Criar novo objeto se não existir

- Usar `findByTitle`
- Aplicar `orElse` ou `orElseGet`
- Retornar novo `Manga`

📌 **Destaque**: `orElseGet` é preferível quando a criação do objeto é custosa.

---

## 🚀 Síntese Final ✅🧠

- `Optional` evita `NullPointerException`.
- Torna ausência de valor **explícita no método**.
- Usa-se principalmente como **retorno de métodos**.
- Possui múltiplas formas seguras de extração de valor.
- Facilita código mais **legível, funcional e expressivo**.
- Combina muito bem com `Predicate`, `Consumer` e `Supplier`.
- **Não deve** ser usado como parâmetro ou atributo de classe.

---