# 📘 Guia — Padrões de Projeto em `Java` (Builder, Factory, Singleton e DTO)

Documento técnico consolidado sobre **padrões de projeto** aplicados em `Java`, focado em **organização de código**, **clareza na criação de objetos**, **desacoplamento** e **manutenção em ambientes reais**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Padrões de projeto** são soluções consagradas para **problemas recorrentes** no desenvolvimento de software.  
Eles não são código pronto, mas **modelos de pensamento** que ajudam a escrever código mais **legível**, **flexível** e **manutenível**.

Neste guia, são abordados os padrões:

- `Builder`
- `Factory`
- `Singleton` (Eager, Lazy e `enum`)
- `Data Transfer Object (DTO)`

Todos os exemplos usam `Java` e refletem cenários comuns do dia a dia corporativo.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Builder Pattern 🏗️

O **problema** resolvido pelo `Builder` é a **criação de objetos complexos** com muitos parâmetros no `constructor`.

#### ❌ Problema clássico

- `constructor` com muitos argumentos (`String`, `int`, etc.)
- Baixa legibilidade
- Difícil manutenção
- Dependência de ferramentas como `Ctrl + P` para entender a ordem dos parâmetros

#### ✅ Solução com `Builder`

- Criação passo a passo
- Métodos descritivos
- Encadeamento de chamadas (*method chaining*)

Exemplo:
```java
    Person person = new Person.Builder()
        .firstName("William")
        .lastName("Souza")
        .username("w.souza")
        .email("william@email.com")
        .build();
```

#### 🔧 Características técnicas:

- `constructor` da classe principal geralmente é `private`
- Classe `Builder` é `static`
- Métodos retornam `this`
- Método `final build()` retorna o objeto externo

✅ Resultado: código mais autoexplicativo, seguro e escalável.

---

### 🏭 Factory Pattern 🏭

O Factory resolve o problema de **desacoplamento da criação de objetos**.

🎯 Objetivo

Separar:

- Regra de negócio
- Criação concreta de objetos

📌 Exemplo conceitual

Criar moedas (Currency) com base no país (Country), sem expor as classes concretas.

Exemplo:
```java
    Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
```

💡 Benefícios

- Chamador **não conhece** a implementação
- Facilita mudanças futuras
- Isola regras complexas de criação

⚠️ Observação

O Factory é frequentemente usado em conjunto com:

- `Builder`
- `Singleton`
- `Strategy`

---

### 🧬 Singleton Pattern

O Singleton garante que apenas uma instância da classe exista em todo o sistema.

#### ✅ Eager Initialization

Exemplo:
```java
    private static final Aircraft INSTANCE = new Aircraft();
```

- Criado no carregamento da classe
- Simples
- `Thread-safe` por definição

❌ Desvantagem:

- Mesmo que nunca seja usado, o objeto é criado

#### 🐢 Lazy Initialization 

A instância só é criada **quando necessária**.

Exemplo:
```java
    if (instance == null) {
        instance = new Aircraft();
    }
```

⚠️ Problema:

- Não é thread-safe em ambientes multithread

✅ Solução padrão:

- Double-Checked Locking

Exemplo:
```java
    if (instance == null) {
        synchronized (Aircraft.class) {
            if (instance == null) {
                instance = new Aircraft();
            }
        }
    }
```

🧠 Observações

- Reduz impacto de `synchronized`
- Ainda exige cuidado em métodos internos (bookSeat, por exemplo)

##### 🧬 Singleton com enum 🧾✅

✅ **Forma mais segura e recomendada em Java**

Exemplo:
```java
    public enum AircraftSingleton {
        INSTANCE;
    }
```

✅ Vantagens

- `thread-safe` por padrão
- Imune a `Reflection`
- Código mais simples
- Garantia absoluta de instância única

⚠️ Mesmo assim, lógica interna ainda precisa ser segura para múltiplas threads.

---

### 📦 Data Transfer Object (DTO) 📤📥

O DTO resolve o problema de transporte de dados agregados entre sistemas ou camadas.

**🎯 Cenário típico**

Enviar para uma API ou front-end dados de:

- Aircraft
- Person
- Country
- Currency

❌ Sem DTO: vários objetos
✅ Com DTO: **um objeto enxuto**

**✅ Estrutura**

- Classe simples
- Apenas atributos necessários
- Sem regras de negócio
- Pode usar `Builder`

Exemplo:
```java
    ReportDTO report = ReportDTO.Builder()
        .aircraftName("787-900")
        .country("BRAZIL")
        .currency("BRL")
        .personName("William")
        .build();
```

📌 Benefícios

Redução de acoplamento
Menos tráfego de dados
Contrato claro entre sistemas

---

## 🚀 Síntese Final ✅🧠

- **`Builder`** melhora a criação de objetos complexos.
- **`Factory`** desacopla a lógica de criação.
- **`Singleton`** garante **uma única instância** compartilhada.
- **`enum Singleton`** é a solução mais segura em `Java`.
- **`DTO`** agrega dados e simplifica a comunicação entre camadas.
- **Todos os padrões** melhoram legibilidade, manutenção e escalabilidade.
- **Padrões não são obrigatórios**, mas ferramentas estratégicas.
- **Conhecimento de contexto** é essencial para aplicá-los

---