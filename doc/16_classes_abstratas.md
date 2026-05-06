# 📘 Guia — `Classes` `Abstratas` em `Java`

Guia técnico e direto sobre **uso de `classes abstratas` em `Java`**, seus objetivos de `design`, regras, hierarquia e aplicação prática com `métodos abstratos`

Este material foi refinado para funcionar como **conteúdo de estudo**, mantendo rigorosamente a estrutura original e ampliando a clareza com explicações progressivas, exemplos práticos e contextualização conceitual

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **`Classes abstratas` existem para resolver problemas de `design de código`**, não de arquitetura
Elas atuam no **nível do modelo de domínio e da orientação a objetos**, ajudando a organizar responsabilidades, contratos e reaproveitamento de código

Uma `classe abstrata` representa um **conceito genérico**, isto é, uma **ideia que faz sentido no modelo**, mas que **não deve existir como objeto concreto no sistema**

No domínio de exemplo, **`Funcionario` não existe isoladamente**: o que existe são **`Gerente`**, **`Desenvolvedor`**, etc
A `classe abstrata` define:

- ✅ **O contrato comum** (o que todo funcionário deve saber fazer)
- ✅ **O estado compartilhado** (dados que todo funcionário possui)
- ✅ **Implementações parciais reutilizáveis**

Enquanto isso, as subclasses definem **o comportamento específico**, respeitando esse contrato

📌 Em termos simples:

> **A classe abstrata diz *o que* deve existir. As classes concretas dizem *como*.**

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Conceito de `Classe Abstrata`

Uma `classe abstrata` em Java:

- É declarada com a palavra-chave `abstract`
- **Não pode ser instanciada**
- É criada para ser **estendida**
- Pode possuir:
  - **Atributos**
  - **Construtores**
  - **Métodos concretos**
  - **Métodos abstratos**

📌 Uma `classe abstrata` representa uma ideia genérica**, não um objeto real

#### Exemplo conceitual rápido

`Funcionario` representa o **conceito de funcionário**, não um funcionário específico
Um objeto real só existe quando o conceito é especializado:

- `Gerente`
- `Desenvolvedor`
- `Analista`

#### 🧑‍💼 Exemplo de Domínio: `Funcionario`

No domínio escolhido:

- `Funcionario` funciona como um **template**
- Centraliza dados comuns, como:
  - `String nome`
  - `double salario`
- Possui um **construtor**, mesmo sendo abstrata

📌 Mesmo sendo abstrata, **o construtor é necessário**, pois:

- As subclasses **herdam os atributos**
- O estado precisa ser inicializado
- A inicialização ocorre via `super(...)`

Exemplo:
```java
    public abstract class Funcionario {
  
        protected String nome;
        protected double salario;
  
        public Funcionario(String nome, double salario) {
            this.nome = nome;
            this.salario = salario;
        }
    }
```

📌 O construtor **nunca é chamado diretamente**, mas sempre a partir da subclasse

#### 🚫 Instanciação Proibida

- **Funcionario funcionario** = `new Funcionario(...)` ❌
- Classes `abstract` **não podem ser instanciadas**
- Apenas subclasses concretas podem gerar objetos

📌 O tipo pode ser abstrato, o objeto nunca

Exemplo:
```java
  Funcionario funcionario = new Gerente("Ana", 8000.0);
```

- O **tipo da referência** é abstrato ✅
- O **objeto real** é concreto ✅
- Isso habilita **polimorfismo**

---

### 🧬 Herança e abstract

- Gerente **é um** Funcionario
- Desenvolvedor **é um** Funcionario
- O relacionamento é do tipo **IS-A**

📌 Herança funciona normalmente com `abstract`

#### Diferença fundamental

📌 `abstract ≠ interface`

| Classe Abstrata        | Interface                  |
|------------------------|----------------------------|
| Possui estado          | Não possui estado          |
| Possui construtor      | Não possui construtor      |
| Implementação parcial  | Contrato puro (em geral)   |

#### ⚙️ Poder Real: Métodos Abstratos

Métodos abstratos:

- São declarados com `abstract`
- **Não possuem corpo**
- Representam um **contrato obrigatório**
- Precisam ser implementados pelas subclasses

Exemplo:
```java
    public abstract void calcularBonus();
```

📌 Eles definem **o que deve ser feito**, mas não **como**

**Analogia simples**

Um método abstrato é como uma cláusula no contrato dizendo **"todo funcionário tem bônus"**, sem definir o cálculo

---

### ✅  Contrato Obrigatório

Regras importantes:

- Se uma subclasse **concreta** não implementar um método abstrato:
  - ❌ **Erro de compilação**
- Classes **abstratas intermediárias**
  - ✅ Podem ignorar a implementação

📌 A primeira classe concreta da hierarquia deve cumprir todos os contratos abstratos herdados

---

### 🧬 Cadeia de Classes Abstratas

Exemplo conceitual:
```plaintext
  Object 
  └── Pessoa (abstract) 
      └── Funcionario (abstract) 
          └── Gerente (concreta)
```

 📌 Regras fundamentais:

- Uma **classe abstrata** pode estender outra **classe abstrata**
- Não é obrigada a implementar métodos abstratos herdados
- **A primeira classe concreta da cadeia é obrigada a implementar todos**

#### 🖨️ Implementação Herdada

- ️ Se Funcionario implementar um método abstrato de Pessoa, todas as subclasses (`Gerente`, `Desenvolvedor`) **herdam automaticamente**

📌 **Implementar uma vez resolve para todo o ramo da hierarquia**, reduzindo duplicação e erros

---

### 🧱 Métodos Concretos em Classes Abstratas

- São totalmente permitidos ✅
- Servem para comportamentos compartilhados:
  - `toString()`
  - `imprimirDados()`
  - `validarSalario()`
  - `deletarFuncionario()`

 📌 As subclasses podem:

- Usar diretamente ✅
- Sobrescrever quando necessário ✅

---

## 🚀 Síntese Final ✅🧠

- **Classes abstratas não podem ser instanciadas**
- **Representam conceitos genéricos do domínio**
- Funcionam como **templates de código**
- Podem conter:
  - Estado
  - Construtores
  - Métodos concretos
  - Métodos abstratos
- **Métodos abstratos não possuem corpo**
- Subclasses concretas **são obrigadas a implementar**
- Classes abstratas podem herdar de outras abstraitas
- `abstract` e `final` não podem coexistir
-  Favorecem:
    - ✅ Polimorfismo
    - ✅ Segurança de contrato
    - ✅ Design limpo, reutilizável e expressivo

---