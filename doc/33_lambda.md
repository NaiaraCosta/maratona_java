# 📘 Guia — Lambdas em Java (`Predicate`, `Consumer`, `Function`)

Documento técnico sobre **expressões Lambda em Java**, com foco no uso das interfaces funcionais `Predicate`, `Consumer` e `Function` do pacote `java.util.function`, explicando **contratos funcionais**, **sintaxe** e **boas práticas**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Lambdas** fazem parte do paradigma de **programação funcional em Java** e permitem escrever código **mais conciso, legível e expressivo**.  
Elas **dependem exclusivamente de interfaces funcionais**, ou seja, interfaces que possuem **apenas um método abstrato**.  
O método abstrato de cada interface define o **contrato da Lambda**, especificando **parâmetros** e **tipo de retorno**.

Interfaces mais comuns:

- `Predicate<T>` → recebe `T` e retorna `boolean`
- `Consumer<T>` → recebe `T` e retorna `void`
- `Function<T, R>` → recebe `T` e retorna `R`

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🔍 Lambda + `Predicate<T>`

`Predicate<T>` é uma **interface funcional** do pacote `java.util.function`.

📌 **Contrato funcional**

- Método abstrato: `test(T t)`
- Retorno: `boolean`

✅ Regras fundamentais:

- A interface **deve ter apenas um método abstrato**
- Métodos adicionais só são permitidos se forem `default`
- A Lambda **deve retornar `boolean`**

📌 Exemplo conceitual:

- Parâmetro: `Car`
- Expressão: verifica uma condição (`true` ou `false`)

💡 Exemplo de comportamento:
- `car.getColor().equals(Color.GREEN)` → retorna `boolean`

✨ Observações:

- O tipo do parâmetro pode ser omitido (`Car car` → `car`)
- Parênteses obrigatórios apenas com **zero ou múltiplos parâmetros**
- Lambdas são **funções anônimas**, não pertencem a nenhuma `class`

---

### 🧪 Conceito-chave: Interface Funcional

✅ **Interface funcional**:

- Contém **exatamente um método abstrato**
- Define totalmente o contrato da Lambda
- Pode ter múltiplos métodos `default`

❌ Erro comum:

- Criar outro método abstrato → a interface deixa de ser funcional

📌 Mentalidade correta:

> **O método abstrato é o contrato que define como a Lambda deve se comportar**

---

### 🔄 Lambda + `Consumer<T>`

`Consumer<T>` representa uma operação que **consome um valor** e **não retorna nada**.

📌 **Contrato funcional**

- Método abstrato: `accept(T t)`
- Retorno: `void`

✅ Uso ideal:

- Impressão
- Log
- Persistência
- Processamento sem retorno

📌 Exemplo conceitual:

- Percorrer uma `List<T>`
- Aplicar uma operação em cada elemento

💡 Padrão comum:

- Criar um método genérico tipo `forEach`
- Receber `List<T>` + `Consumer<T>`
- Aplicar `consumer.accept(elemento)`

✨ Simplificações permitidas:

- O tipo do parâmetro pode ser omitido
- Parênteses podem ser removidos com um único parâmetro

---

### 🔁 Lambda + `Function<T, R>`

`Function<T, R>` é usada para **transformações**, onde um valor entra e **outro sai**.

📌 **Contrato funcional**

- Método abstrato: `apply(T t)`
- Retorno: `R`

✅ Uso clássico:

- Mapear coleções
- Converter tipos
- Processar e retornar novos valores

📌 Exemplo conceitual:

- Entrada: `String`
- Saída: `Integer` (`length`)
- Entrada: `String`
- Saída: `String` (`toUpperCase`)

💡 Padrão comum:

- Método genérico `map`
- Recebe `List<T>` + `Function<T, R>`
- Retorna `List<R>`

✅ Importante:

- `T` e `R` **podem ser iguais ou diferentes**
- A tipagem é inferida automaticamente pelo compilador

---

## 🚀 Síntese Final ✅🧠

- **Lambdas exigem interfaces funcionais**
- **Interface funcional = 1 método abstrato**
- `Predicate<T>` → retorna `boolean`
- `Consumer<T>` → retorna `void`
- `Function<T, R>` → transforma `T` em `R`
- O **método abstrato define o contrato da Lambda**
- Lambdas tornam o código **mais conciso e expressivo**
- Tipos e parênteses podem ser omitidos quando há inferência
- Lambdas são **funções anônimas**, não métodos de `class`

---