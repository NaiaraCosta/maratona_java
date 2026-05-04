# 📘 Guia — `Method Reference` em Java (`static`, instância, classe e construtores)

Documento técnico sobre **`method references` em Java**, cobrindo **referência a métodos estáticos**, **métodos de instância**, **métodos não estáticos via classe** e **referência a construtores**, sempre em conjunto com **interfaces funcionais**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **`Method reference`** é uma **sintaxe reduzida de Lambda** usada quando a expressão **chama apenas um método**.  
Ela melhora a **legibilidade**, reduz **boilerplate** e mantém **total compatibilidade** com **interfaces funcionais**, respeitando o **`functional descriptor`** (parâmetros + retorno).

📌 Regra de ouro:
> **Se a Lambda chama somente um método, você pode usar `method reference`.**

Tipos abordados:
- `Classe::metodoEstatico`
- `objeto::metodoInstancia`
- `Classe::metodoInstancia`
- `Classe::new` (construtor)

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🔹 Visão Geral — Lambda ➜ `Method Reference`

📌 Exemplo conceitual:

- Lambda: `s -> s.length()`
- Method reference: `String::length`

✅ Condição obrigatória:

- A assinatura do método **deve ser compatível** com o método abstrato da interface funcional.

Esse alinhamento ocorre via:

- **Target Type**
- **Functional Descriptor**

---

### 🧷 Referência a Método Estático (`Classe::metodoEstatico`)

📌 Cenário:

- Uso com `Comparator<T>`
- Método estático recebe **dois parâmetros** e retorna `int`

🧠 Estratégia:

- Criar uma classe utilitária de comparação

📦 Exemplo estrutural:

- Classe de domínio: `Anime`
- Classe de serviço: `AnimeComparators`

📌 Método estático:

- Recebe dois `Anime`
- Retorna `int`

✅ Uso com `sort`:

- `Collections.sort(lista, AnimeComparators::compareByTitle)`
- Alternativa moderna: `lista.sort(AnimeComparators::compareByEpisodes)`

✨ Benefícios:

- Código desacoplado
- Vários critérios reutilizáveis
- Substitui classes anônimas ou Lambdas verbosas

---

### 🧷 Referência a Método de Instância (`objeto::metodo`)

📌 Cenário:

- O método **não é estático**
- É necessário um **objeto específico**

📌 Estrutura:

- Instanciar `AnimeComparators`
- Passar a instância no `sort`

✅ Exemplo conceitual:

- `animeComparators::compareByEpisodes`

🔎 Diferença essencial:

- O **objeto é conhecido no momento da referência**
- A Lambda delega diretamente para aquele objeto

✨ Resultado:

- Sintaxe mais curta que uma Lambda explícita
- Mesmo contrato funcional do `Comparator`

---

### 🧷 Referência a Método Não Estático de uma Classe (`Classe::metodoInstancia`)

📌 Cenário clássico:

- Comparação de `String`
- Uso de `Comparable`

📌 Exemplo:

- `List<String>.sort(String::compareTo)`

🔎 Conceito importante:

- O primeiro parâmetro vira o **objeto chamador**
- O segundo vira o **argumento do método**

📌 Outro uso poderoso:

- Conversão de tipos

✅ Exemplo:

- `Function<String, Integer>`
- Lambda equivalente: `s -> Integer.parseInt(s)`
- Method reference: `Integer::parseInt`

✨ Vantagem:

- Tipagem forte
- Máxima legibilidade
- Zero ruído sintático

---

### 🧷 `Method Reference` com `Predicate` e `BiPredicate`

📌 Uso com `List::contains`

✅ Interface funcional:

- `BiPredicate<T, U>`

📌 Exemplo mental:

- Primeiro argumento: `List<String>`
- Segundo argumento: `String`
- Retorno: `boolean`

✅ Method reference:

- `List::contains`

🔍 Execução:

- `biPredicate.test(lista, "nome")`

Resultado:

- `true` se existir
- `false` caso contrário

---

### 🧱 Referência a Construtor (`Classe::new`)

📌 Introdução ao `Supplier<T>`

- Não recebe argumentos
- Retorna um objeto

✅ Uso:

- Criar objetos via Lambda

📌 Lambda comum:

- `() -> new Anime()`

📌 Method reference:

- `Anime::new`

⚠️ Importante:

- O objeto **só é criado ao chamar** `supplier.get()`

---

### 🔀 Construtores com Parâmetros — `Function` e `BiFunction`

📌 Problema:

- Construtor com parâmetros
- `Supplier` não resolve

✅ Solução:

- `Function<T, R>` → 1 parâmetro
- `BiFunction<T, U, R>` → 2 parâmetros

📌 Exemplo:

- Construtor: `Anime(String title, Integer episodes)`
- Interface: `BiFunction<String, Integer, Anime>`

✅ Lambda:

- `(title, episodes) -> new Anime(title, episodes)`

✅ Method reference:

- `Anime::new`

⚠️ Regra essencial:

> **A criação do objeto acontece somente ao chamar `apply(...)`.**

---

## 🚀 Síntese Final ✅🧠

- **`Method reference` é Lambda reduzida**
- Só pode ser usada quando há **uma única chamada de método**
- Sempre depende de **interface funcional**
- Tipos suportados:
    - `Classe::metodoEstatico`
    - `objeto::metodoInstancia`
    - `Classe::metodoInstancia`
    - `Classe::new`
- Compatibilidade garantida pelo **functional descriptor**
- `Supplier` cria objetos sem argumentos
- `Function` e `BiFunction` suportam construtores parametrizados
- Criação de objetos ocorre em `get()` ou `apply()`
- Código fica **mais limpo, expressivo e legível**

---