# 📘 Guia — Orientação a Objetos em Java: Herança (Pt. 01 ao Pt. 05)

Guia técnico completo sobre **herança em Java**, cobrindo conceitos fundamentais, boas práticas, armadilhas comuns e comportamento interno da JVM.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Herança** em `Java` é um mecanismo de **reuso e especialização** que permite que uma classe **herde atributos e métodos** de outra.  
Ela representa semanticamente um relacionamento do tipo **"é um"** (*is-a*), diferentemente de associação/composição (*has-a*).

Ao longo deste guia, veremos:
- Diferença entre **associação** e **herança**
- Uso de `extends`
- **Sobrescrita** de métodos
- Uso correto do `super`
- Modificador de acesso `protected`
- Regras de **construtores em herança**
- **Sequência de inicialização** de classes e objetos na JVM

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 👤 Classe Base: `Pessoa`
Uma classe **genérica** que representa um conceito do mundo real.

📌 Atributos comuns:
- `nome`
- `cpf`
- `endereco`

Exemplo:
```java
    public class Pessoa {
        protected String nome;
        protected String cpf;
        protected Endereco endereco;
    
        public void imprime() {
            System.out.println(this.nome);
            System.out.println(this.cpf);
            System.out.println(this.endereco.getRua());
            System.out.println(this.endereco.getCep());
        }
    }
```

🔎 **Insight Técnico**

- Classes **genéricas** ficam no topo da hierarquia.
- Evite acoplamento forte: **Pessoa tem** um **Endereco**, mas **Endereco não referencia Pessoa**.

---

### 🧑‍💼 Classe Especializada: Funcionario

Um **funcionário é uma pessoa**, logo utilizamos **herança**.

Exemplo:
```java
    public class Funcionario extends Pessoa {
        private double salario;
    }
```

✅ Funcionario **herda automaticamente**:
- Atributos
- Métodos
- Comportamentos da classe **Pessoa**

⚠️ Boa prática:
Use herança apenas quando existir uma relação **semântica real** de especialização.

| Relação      | Conceito         |
|--------------|------------------|
| Associação   | tem um (has-a)   |
| Herança      | é um (is-a)      |


📌 Exemplos:

- **Pessoa tem um Endereco**
- **Funcionario é uma Pessoa**

---

### 🔁 Sobrescrita de Métodos (@Override)

Permite **alterar o comportamento** herdado.

Exemplo:
```java
@Override
    public void imprime() {
        super.imprime();
        System.out.println(this.salario);
    }
```

✅ Regras:

- Mesma assinatura
- Mesmo tipo de retorno
- Não reduzir visibilidade
- Usar `@Override`

🔎 `super.imprime()` chama o método da **superclasse**, executando sua lógica antes da especialização.

---

### 🏷️ Modificador protected

Resolve um problema clássico de herança.

📌 Diferença:

- `private` → só na própria classe
- `protected` → subclasses **e** classes do mesmo pacote
- `public` → todos

Exemplo:
```java
    @Override
    protected String nome;
```
✅ Permite acesso direto em subclasses:

Exemplo:
```java
    System.out.println(this.nome);
```

⚠️ Evite expor tudo como `protected`. Use com critério.

---

### 🛠️ Construtores e super

Quando a superclasse possui um construtor com parâmetros, a subclasse **é obrigada** a chamá-lo.

Exemplo:
```java
    public class Pessoa {
        public Pessoa(String nome) {
            this.nome = nome;
        }
    }
    
    public class Funcionario extends Pessoa {
        public Funcionario(String nome) {
            super(nome);
        }
    }
```

📌 Regras Críticas:

- `super()` deve ser a **primeira instrução**
- Se não declarado, o Java tenta chamar `super()` vazio
- Se não existir construtor vazio na superclasse ➜ **erro de compilação**

---

### ⚙️ Sequência de Inicialização (JVM)

Ordem exata ao criar um objeto com herança:

1. Blocos estáticos da superclasse
2. Blocos estáticos da subclasse
3. Alocação de memória da superclasse
4. Inicialização dos atributos da superclasse
5. Blocos de inicialização da superclasse
6. Construtor da superclasse
7. Alocação de memória da subclasse
8. Inicialização dos atributos da subclasse
9. Blocos de inicialização da subclasse
10. Construtor da subclasse

---

### 🚫 Herança Múltipla em Java

❌ Não existe herança múltipla de classes

Exemplo:
```java
    class A {}
    class B {}
    class C extends A, B {} // ERRO
```

✅ Alternativa:

- `interface`
- Composição

---

## 🚀 Síntese Final ✅🧠

- **Herança representa um relacionamento é um**
- Use `extends` para especialização
- Evite herança excessiva (alto acoplamento)
- Métodos podem ser sobrescritos com `@Override`
- `super` acessa métodos e construtores da superclasse
- `protected` libera acesso controlado a subclasses
- Construtores da superclasse devem ser respeitados
- A JVM segue uma **ordem rígida de inicialização**
- **Herança múltipla não existe em Java**

___