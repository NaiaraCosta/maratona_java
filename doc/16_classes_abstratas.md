# 📘 Guia — `Classes` `Abstratas` em `Java`

Guia técnico e direto sobre **uso de `classes abstratas` em `Java`**, seus objetivos de `design`, regras, hierarquia e aplicação prática com `métodos abstratos`.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **`Classes abstratas` existem para resolver problemas de `design de código`**, não de arquitetura. Elas representam **conceitos genéricos** que **não devem ser instanciados diretamente**, funcionando como **templates** para subclasses concretas.

No domínio de exemplo, **`Funcionario` não existe isoladamente**: o que existe são **`Gerente`**, **`Desenvolvedor`**, etc. A `classe abstrata` define **o contrato e o estado comum**, enquanto as subclasses definem **o comportamento específico**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Conceito de `Classe Abstrata`

- Declarada com a palavra-chave `abstract`
- **Não pode ser instanciada**
- Criada para ser **estendida**
- Pode possuir:
  - **Atributos**
  - **Construtores**
  - **Métodos concretos**
  - **Métodos abstratos**

📌 **Uma `classe abstrata` representa uma ideia genérica**, não um objeto real.

---

### 🧑‍💼 Exemplo de Domínio: `Funcionario`

- `Funcionario` é um **template**
- Possui atributos comuns como:
  - `String nome`
  - `double salario`
- Possui `constructor` para suportar `herança`

📌 Mesmo sendo abstrata, **o construtor é necessário**, pois as subclasses precisam inicializar o estado herdado via `super`.

---

### 🚫 Instanciação Proibida

- `Funcionario funcionario = new Funcionario(...)` ❌
- Classes `abstract` **não podem ser instanciadas**
- Apenas subclasses concretas podem gerar objetos

📌 **O tipo pode ser abstrato, o objeto nunca.**

---

### 🧬 Herança e `abstract`

- `Gerente` **é um** `Funcionario`
- `Desenvolvedor` **é um** `Funcionario`
- Herança funciona normalmente com `abstract`

📌 **`abstract` ≠ interface — há estado e implementação parcial.**

---

### 🛑 `abstract` vs `final`

- `abstract` → deve ser estendida
- `final` → não pode ser estendida

🚨 **Jamais podem coexistir na mesma classe**

---

### ⚙️ Poder Real: `Métodos Abstratos`

- Declarados com `abstract`
- **Não possuem corpo**
- Existem apenas como **contrato**
- Forçam implementação nas subclasses

```java
  public abstract void calcularBonus();
```

📌 Garante que toda subclasse implemente sua própria regra.

---

### 💰 Exemplo: Cálculo de Bonus

- **Gerente** → **20%**
- **Desenvolvedor** → **5%**

📌 A chamada ocorre via **Funcionario**, mas **quem executa é o objeto real**, aplicando `polimorfismo`.

---

### ✅ Contrato Obrigatório

- Se uma subclasse concreta **não implementar** o método abstrato:
  - ❌ Erro de compilação
- Classes abstratas **intermediárias não são obrigadas** a implementar

📌 **A primeira classe concreta da hierarquia deve cumprir todos os contratos**.

---

### 🧬 Cadeia de Classes Abstratas

Exemplo:
```text
    Object
    └── Pessoa (abstract)
        └── Funcionario (abstract)
            └── Gerente (concreta)
```

📌 Regras:

- Uma **classe abstrata** pode estender outra **classe abstrata**
- Não é obrigada a implementar métodos abstratos herdados
- **A primeira concreta sim**

---

### 🖨️ Implementação Herdada

- Se **Funcionario** implementar um método abstrato de Pessoa
- Todas as subclasses (**Gerente**, **Desenvolvedor**) **herdam automaticamente**

📌 **Implementar uma vez resolve para todo o ramo**.

---

### 🧱 Métodos Concretos em Classes Abstratas

- Permitidos ✅
- Úteis para comportamentos comuns:
  - `toString()`
  - `imprimir()`
  - `deletarFuncionario()`

📌 Subclasses podem **usar ou sobrescrever**.

---

## 🚀 Síntese Final ✅🧠

- **Classes abstratas não podem ser instanciadas**
- **Representam conceitos genéricos**
- Servem como **templates**
- Podem conter **estado, construtor e métodos**
- **Métodos abstratos não possuem corpo**
- Subclasses **são obrigadas a implementar**
- Classes abstratas podem herdar de outras abstratas
- `abstract` e `final` **não podem coexistir**
- Favorecem **polimorfismo, segurança de contrato e design limpo**

---