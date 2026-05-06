# 📘 Guia — Orientação a Objetos em Java: Herança

Guia técnico completo sobre **herança em Java**, cobrindo conceitos fundamentais, boas práticas, armadilhas comuns e comportamento interno da JVM.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Herança** em `Java` é um mecanismo de **reuso e especialização** que permite que uma classe **herde atributos e métodos** de outra
Ela representa semanticamente um relacionamento do tipo **"é um"** (*is-a*), diferentemente de associação ou composição (*has-a*)

Em termos práticos:

- A **classe base (superclasse)** define comportamentos e dados comuns.
- A **classe derivada (subclasse)** especializa ou estende esses comportamentos.

Ao longo deste guia, veremos:

- Diferença entre **associação** e **herança**
- Uso correto da palavra-chave `extends`
- **Sobrescrita** de métodos
- Uso adequado do `super`
- Modificador de acesso `protected`
- Regras de **construtores em herança**
- **Sequência de inicialização** de classes e objetos na JVM

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 👤 Classe

#### 👤 Classe Base: `Pessoa`

Uma classe **genérica** representa um conceito amplo do domínio do problema, normalmente situado no topo da hierarquia de herança

No exemplo abaixo, `Pessoa` modela uma entidade comum do mundo real, com atributos que fazem sentido para qualquer pessoa, independentemente do papel que ela exerça no sistema

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

🔎 Insight Técnico

- Classes **genéricas** ficam no topo da hierarquia de herança e devem conter apenas aquilo que é comum a todas as subclasses
- Evite acoplamento forte: **Pessoa tem** um **Endereco**, mas **Endereco não referencia Pessoa**
  - Isso é um exemplo de **associação**, não de herança
  - A relação é: uma pessoa **possui** um endereço, mas não é um endereço

#### 🧑‍💼 Classe Especializada: Funcionario

Um **funcionário é uma pessoa**, portanto a relação semântica correta é de **herança**

Nesse caso, **Funcionario** reaproveita tudo o que já existe em **Pessoa** e adiciona apenas o que é específico desse novo conceito

Exemplo:
```java
    public class Funcionario extends Pessoa {
        private double salario;
    }
```

✅ Funcionario herda automaticamente:

- Todos os atributos **não privados** de Pessoa
- Todos os métodos **não privados** de Pessoa
- O comportamento definido na superclasse

⚠️ Boa prática fundamental:

- Use herança apenas quando existir uma relação semântica real de especialização
- Herança não deve ser usada apenas para reaproveitar código

| Relação    | Conceito       |
|------------|----------------|
| Associação | tem um (has-a) |
| Herança    | é um (is-a)    |

📌 Exemplos coerentes:

- Pessoa tem um Endereco
- Funcionario é uma Pessoa

---

### 🔁 Sobrescrita de Métodos (@Override)

A sobrescrita permite que a subclasse **altere ou complemente** o comportamento herdado da superclasse

No exemplo a seguir, o método imprime() de Funcionario reaproveita o comportamento de Pessoa e adiciona um novo detalhe

Exemplo:
```java
    @Override
    public void imprime() {
        super.imprime();
        System.out.println(this.salario);
    }
```

✅ Regras obrigatórias para sobrescrita:

- A assinatura do método deve ser exatamente a mesma
- O tipo de retorno deve ser o mesmo (ou covariante)
- A visibilidade **não pode ser reduzida**
- O uso de `@Override` é altamente recomendado

🔎 Por que usar super.imprime()?

- Garante que toda a lógica da superclasse seja executada
- Evita duplicação de código
- Facilita manutenção e evolução do sistema

---

### 🏷️ Modificador de Acesso protected

O modificador protected resolve um problema clássico em herança: **permitir acesso às subclasses sem expor o atributo para o mundo todo**

📌 Comparação de visibilidade:

- `private` → acesso apenas dentro da própria classe
- `protected` → acesso por subclasses e classes do mesmo pacote
- `public` → acesso irrestrito

Exemplo:
```java
    @Override
    protected String nome;
```

🔎 Esclarecimento importante

- `@Override` **não se aplica a atributos**
- O exemplo acima não é válido do ponto de vista sintático, mas ilustra a ideia de tornar o atributo `protected`

Forma correta:
```java
    protected String nome;
```
Com protected, a subclasse pode acessar diretamente:
```java
    System.out.println(this.nome);
```

⚠️ Cuidado

- Evite expor indiscriminadamente atributos como `protected`
- Prefira encapsulamento com métodos (`get` / `set`) quando fizer sentido

---

### 🛠️ Construtores e super

Quando a superclasse possui um construtor com parâmetros, a subclasse **deve obrigatoriamente** chamá-lo explicitamente

Isso garante que o estado da superclasse seja inicializado corretamente

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

📌 Regras críticas sobre construtores:

- A chamada a `super()` deve ser sempre a **primeira instrução**
- Se nenhum `super(...)` for declarado, o Java tenta chamar `super()` sem argumentos
- Se a superclasse não possuir um construtor vazio ➜ ocorre **erro de compilação**

🔎 Analogia simples

Construir um objeto é como montar uma casa: o **alicerce (superclasse)** precisa estar pronto antes dos andares superiores (subclasse)

---

### ⚙️ Sequência de Inicialização (JVM)

Ao criar um objeto que envolve herança, a JVM segue uma **ordem rígida e previsível**

Ordem exata de execução:

1. Blocos estáticos da superclasse
2. Blocos estáticos da subclasse
3. Alocação de memória para objetos da superclasse
4. Inicialização dos atributos da superclasse
5. Blocos de inicialização da superclasse
6. Construtor da superclasse
7. Alocação de memória para objetos da subclasse
8. Inicialização dos atributos da subclasse
9. Blocos de inicialização da subclasse
10. Construtor da subclasse

🔎 Por que isso importa?

- Evita acessar atributos ainda não inicializados
- Ajuda a entender comportamentos inesperados durante a criação de objetos
- É fundamental para depuração e leitura correta de código complexo

---

### 🚫 Herança Múltipla em Java

❌ Java **não permite herança múltipla de classes**, ou seja, uma classe não pode estender mais de uma classe concreta

Exemplo inválido:
```java
    class A {}
    class B {}
    class C extends A, B {} // ERRO
```

✅ Alternativas corretas:

- Uso de `interface`
- Uso de **composição** em vez de herança

🔎 Motivo principal:

- Evitar ambiguidades como o clássico `Diamond Problem`

---

## 🚀 Síntese Final ✅🧠

- **Herança representa um relacionamento "é um"**
- Use `extends` para especialização real
- Fuja de herança excessiva (alto acoplamento)
- Métodos podem ser sobrescritos com `@Override`
- `super` referencia métodos e construtores da superclasse
- `protected` libera acesso controlado para subclasses
- Construtores da superclasse devem ser respeitados
- A JVM segue uma **ordem rígida de inicialização**
- **Herança múltipla não existe em Java**

---