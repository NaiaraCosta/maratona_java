# 📘 Guia — Polimorfismo em Java: Conceitos, Funcionamento e Boas Práticas

Este documento apresenta **polimorfismo em `Java` do zero até cenários reais**, integrando `abstract class`, `interface`, `widening cast`, `narrowing cast`, `instanceof` e **programação orientada a interfaces**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Polimorfismo** significa **múltiplas formas**: a capacidade de uma variável de referência mais genérica apontar para objetos de tipos mais específicos, permitindo que **o comportamento correto seja executado em tempo de execução**.  
Em `Java`, o polimorfismo depende diretamente de **herança**, **interfaces** e **sobrescrita de métodos** (`override`).

A grande vantagem é o **desacoplamento**: o código passa a depender do **comportamento**, não da implementação concreta.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Estrutura Base do Domínio
📌 Criamos uma hierarquia de produtos:

- `abstract class Produto`
  - Atributos: `nome`, `valor`
  - Métodos: `getNome`, `getValor`
- Subclasses:
  - `Computador`
  - `Tomate`
  - `Televisao`

✅ `Produto` é **abstrata**, pois não faz sentido instanciar um produto genérico.

---

### 🏷️ Interface como Contrato (`Taxavel`)

Criamos a `interface` `Taxavel` com o método:

- `double calcularImposto()`

📌 O método **não define como o imposto é calculado**, apenas **que deve ser calculado**.

✅ `Produto implements Taxavel`  
Como `Produto` também é abstrata, **não precisa implementar o método** — a responsabilidade fica para as subclasses.

---

### 💰 Sobrescrita do Método `calcularImposto`

Cada produto calcula imposto de forma diferente:

- `Computador` → imposto maior (ex: `21%`)
- `Tomate` → imposto reduzido (ex: `6%`)
- `Televisao` → regra semelhante a eletrônicos

📌 Aqui ocorre **polimorfismo de método**:
- O método chamado é o mesmo (`calcularImposto`)
- A **implementação executada depende do objeto real**

---

### 🗂️ Camada de Serviço (Regra de Negócio)

Criamos a classe `CalculadoraImposto` para:

- Separar **regra de negócio** do **modelo**
- Gerar relatórios de imposto

Inicialmente:
- Um método para cada tipo (`Computador`, `Tomate`)

Resultado:
❌ Código duplicado  
❌ Baixa escalabilidade

---

### 🔁 Polimorfismo em Ação (Parâmetros Polimórficos)

Refatoração usando **variável de referência genérica**:

Exemplo:
```java
    public static void calcularImposto(Produto produto)
```

✅ Benefícios:

Um único método
Funciona para qualquer subclass de Produto
Extensível sem modificar o método

📌 Quem executa calcularImposto() é sempre o objeto real, não a variável de referência.

---

### 🎮 Analogia do Controle Remoto

- **Controle remoto** → variável de referência
- **TV** → objeto real

📌 **O controle define o que pode ser chamado**

📌 **A TV define como será executado**

✅ Mesmo controle funciona para TVs mais novas

❌ Não acessa funcionalidades que o controle não conhece

👉 Exatamente como no polimorfismo em `Java`

---

### 🔼 Widening Cast (Upcasting)

📌 Conversão implícita:

Exemplo:
```java
    Produto p = new Computador(...)
```

✅ Sempre segura
✅ Base do polimorfismo
✅ Acesso apenas ao que existe em **Produto**

---

### 🔽 Narrowing Cast (Downcasting)

📌 Conversão explícita:

Exemplo:
```java
    Tomate t = (Tomate) produto
```

⚠️ **Risco de** `ClassCastException`

✅ Só é segura se o objeto **realmente for do tipo esperado**

---

### 🛡️ Uso Correto de instanceof

Antes de fazer `narrowing cast`:

Exemplo:
```java
    if (produto instanceof Tomate) {
        Tomate t = (Tomate) produto;
    }
```

✅ Evita exceções
✅ Garante segurança em tempo de execução

---

### ⚠️ Exemplo Real de Erro (ClassCastException)

❌ Tentar converter:

- **Produto** que referencia um Computador
- Para **Tomate**

➡️ Erro em runtime
➡️ Sempre validar antes com `instanceof`

---

### 🧠 Programação Orientada a Interface (POI)

Exemplo com **Repositorio**:

- interface Repositorio
  - método salvar()
- Implementações:
  - RepositorioBancoDados
  - RepositorioArquivo
  - RepositorioMemoria

📌 Uso correto:

```java
    Repositorio repo = new RepositorioBancoDados();
```

✅ Troca de implementação **sem alterar o código cliente**
✅ Base de frameworks como `Spring`

---

### 🚀 Síntese Final ✅🧠

- **Polimorfismo** = **múltiplas formas**
- Baseado em `herança` e `interface`
- Variável de referência ≠ objeto real
- Método executado depende do **objeto**
- `Widening cast` é seguro e implícito
- `Narrowing cast` é explícito e perigoso
- Sempre usar `instanceof` antes do cast
- Parâmetros polimórficos eliminam duplicação
- Programar para `interface` aumenta:
  - Manutenibilidade
  - Extensibilidade
  - Qualidade do código

---