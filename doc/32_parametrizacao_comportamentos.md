# 📘 Guia — Parametrizando Comportamentos em Java

Como **parametrizar regras de negócio** para criar código mais **flexível**, **escalável** e **fácil de manter**, utilizando `interfaces`, **polimorfismo**, **classes anônimas**, `Predicate`, `lambda expressions` e `generics`.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Parametrizar comportamentos** significa **mover a lógica que muda** para fora dos métodos, passando essa lógica como **parâmetro**.  
O objetivo é evitar duplicação, reduzir `ifs`, facilitar manutenção e permitir que o **comportamento varie sem alterar o código central**.

Esse conceito é a base para padrões modernos do `Java 8+`, como:

- `Predicate`
- `Streams`
- `Lambdas`
- Programação funcional

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🚗 Problema Inicial: Filtros Acoplados

Temos uma classe `Car` com atributos como:

- `name`
- `color`
- `year`

E uma lista de carros (`List<Car>`).

Primeira abordagem:

- Criar métodos específicos como:
  - filtrar carros **verdes**
  - filtrar carros **vermelhos**
  - filtrar carros **antes de determinado ano**

🔴 Problema:

- Código duplicado
- Cada novo requisito → **novo método**
- A única mudança real está no `if`

➡️ **Código não escala.**

---

### 🔍 Primeira Melhoria: Parametrizando Dados (ainda insuficiente)

Evolução natural:

- Um único método `filterByColor(String color)`
- O dado muda, mas a **condição ainda está fixa**

✅ Melhorou um pouco  
❌ Continua limitado quando o critério vira `year`, `price`, `power`, etc.

---

### 🧠 Ideia Central: Parametrizar o Comportamento

Observação chave:

> **O que muda não é o método, é a condição dentro do `if`.**

Então:

- Por que não **passar essa condição como parâmetro?**

Isso nos leva a:

- `interfaces`
- `polimorfismo`

---

### 🧩 Interface como Contrato de Comportamento

Criamos uma `interface` para representar a regra:

- Exemplo conceitual:

  - `CarPredicate`
  - Método: `boolean test(Car car)`

📌 Agora o método de filtro:

- Não sabe **qual regra será aplicada**
- Apenas executa `predicate.test(car)`

➡️ **Regra de negócio desacoplada**

---

### 🎭 Classes Anônimas: Primeiro Passo Real

Na chamada do método, criamos:

- Uma **classe anônima**
- Que implementa `CarPredicate`
- E define o comportamento ali, no ponto de uso

✅ Resultado:

- Um único método `filter`
- Comportamento flexível
- Zero duplicação

---

### ✨ Lambdas: A Evolução Natural (Java 8+)

Como a `interface` possui apenas **um método abstrato**, ela é uma:
- **Functional Interface**

Isso permite substituir:

- Classe anônima longa por
  - **Lambda expression**

📌 Exemplo conceitual:

- `(car) -> car.getColor().equals("GREEN")`
- `(car) -> car.getYear() < 2015`

➡️ **Menos código, mesma intenção**

---

### ✅ Usando `Predicate` da API Java

Importante insight:

> **Você não precisa reinventar a roda.**

O Java já possui:

- `Predicate<T>` em `java.util.function`

Ele define exatamente:

- `boolean test(T t)`

✅ Benefícios:

- Integração nativa com `Streams`
- Maior padronização
- Código profissional

---

### 🧬 Tornando o Método Genérico

Último passo:

- Generalizar o método de filtro para **qualquer tipo**

💡 Uso de `generics`:

- `<T>`
- `List<T>`
- `Predicate<T>`

Resultado:

- Um único método que:
  - Filtra `Car`
  - Filtra `Integer`
  - Filtra qualquer tipo de objeto

📌 Exemplo conceitual:

- Filtrar carros
- Filtrar números pares
- Filtrar qualquer coleção

➡️ **Reutilização total**

---

## 🚀 Síntese Final ✅🧠

- **Parametrizar comportamento** remove `ifs` duplicados
- A regra de negócio passa a vir por **parâmetro**
- `interfaces` + `polimorfismo` tornam o código flexível
- **Classes anônimas** permitem comportamento local
- **`lambda expressions`** reduzem drasticamente o código
- `Predicate<T>` já resolve esse problema na API Java
- `generics` permitem criar soluções reutilizáveis
- Esse conceito é a base de `Streams` e programação funcional

---