# 📘 Guia — Orientação a Objetos em Java (Classes, Objetos, Coesão e Referências)

**Introdução sólida aos fundamentos de `Orientação a Objetos` em `Java`, cobrindo `classes`, `objetos`, `atributos`, `variáveis de referência`, `coesão` e comportamento de referência em memória.**

Este material foi elaborado para criar uma base conceitual clara, progressiva e consistente, essencial para compreender como o `Java` organiza dados, comportamento e memória por meio do paradigma de Orientação a Objetos.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Orientação a Objetos (`OO`)** é o pilar central do desenvolvimento em `Java`.  
Enquanto variáveis **primitivas** armazenam apenas **valores simples e isolados**, objetos permitem **agrupar dados relacionados** e comportamentos em uma única unidade lógica que representa uma entidade do mundo real.

Através de **classes**, definimos o formato dessas entidades. A partir delas, criamos **objetos**, que vivem na memória e são acessados por **variáveis de referência**.  
Essas referências não armazenam o objeto em si, mas **apontam para ele**, o que influencia diretamente o comportamento do programa, o compartilhamento de dados e o uso de memória.

O entendimento correto desses conceitos é essencial para escrever código:
- **Manutenível**, por separar responsabilidades
- **Organizado**, por modelar corretamente o domínio
- **Escalável**, por permitir extensão sem efeitos colaterais

Tudo isso respeitando princípios fundamentais, como **alta coesão**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Limitações das Variáveis Primitivas

- Tipos primitivos armazenam **apenas um valor**
- Cada variável existe de forma **isolada**
- Não há relação semântica entre variáveis distintas

Exemplo:
```java
    int idade = 12;
    char sexo = 'M';
    String nome = "William Suane";
```

🚫 Não existe vínculo estrutural entre `idade`, `sexo` e `nome`
➡️ Elas não representam formalmente **uma entidade única**  
➡️ O relacionamento entre esses dados depende apenas da interpretação do programador

📌 Esse modelo se torna **frágil** à medida que o sistema cresce, dificultando manutenção, evolução e reutilização do código.

---

### 🧠 Conceito de Objeto

- Um **objeto** representa uma entidade do mundo real ou conceitual
- Agrupa **dados relacionados** (atributos)
- Pode possuir **comportamentos** (métodos)
- Vive em um **único espaço de memória**

📌 **Exemplo conceitual de entidade:**

- Pessoa
- Estudante
- Produto
- Conta bancária

➡️ Um objeto existe como uma **unidade coesa**, e não como variáveis soltas e independentes.

---

### 🧩 Classe: o Molde do Objeto

- Uma **classe** é um **template** (molde)
- Define quais **atributos** e **comportamentos** os objetos terão
- Não representa um objeto em si
- Não executa sozinha (não possui `main` por padrão)

Exemplo:
```java
    public class Estudante {
        public String nome;
        public int idade;
        public char sexo;
    }
``` 

⭐ Essa classe não cria objetos, apenas define como eles serão

📌 Ela descreve a estrutura e o formato dos dados, mas não os armazena ou manipula diretamente.

---

### 🧪 Criando Objetos (Instanciação)

Para criar um objeto, utiliza-se o operador new.

Exemplo:
```java
    Estudante estudante = new Estudante();
```

✅ Aqui temos claramente:

- **Variável de referência:** estudante
- **Objeto em memória:** criado por `new Estudante()`

📌 O operador `new` **sempre cria um novo objeto em memória**

Cada execução do new resulta em uma instância diferente

---

### 🎮 Variável de Referência

- Funciona como um **controle remoto**
- Não contém o objeto
- Apenas **aponta para o endereço onde o objeto está**

Exemplo:
```java
    estudante.nome = "Luffy";
    estudante.idade = 18;
    estudante.sexo = 'M';
```

✅ O operador `.` é usado para:

- Acessar atributos
- Invocar métodos do objeto

📌 A referência e o objeto são conceitos distintos, mas interligados.

---

### 🔍 Acessando Dados do Objeto

Exemplo:
```java
    System.out.println(estudante.nome);
    System.out.println(estudante.idade);
    System.out.println(estudante.sexo);
```

⚠️ Imprimir apenas a variável de referência:
```java
    System.out.println(estudante);
```

➡️ O que aparece não é o conteúdo do objeto
➡️ É uma representação textual da **referência** (endereçamento/identificação interna)

📌 Sem sobrescrever `toString`, o conteúdo lógico do objeto não é exibido.

---

### ⚙️ Valores Padrão em Atributos

Atributos de classe recebem valores padrão automaticamente quando o objeto é criado

| Tipo                  | Valor Padrão              |
|-----------------------|---------------------------|
| int                   | 0                         |
| char                  | '\u0000' (caractere nulo) |
| boolean               | false     <br/>           |
| String / objetos<br/> | null                      |

📌 Isso acontece porque os atributos fazem parte do **objeto**, e o Java garante inicialização segura.

⚠ Diferente de **variáveis locais**, que **não recebem valores padrão**.

---

### ⚠️ Inicialização Direta na Classe

É possível inicializar atributos diretamente na classe

Exemplo:
```java
    public String nome = "Zoro";
```

🚨 Atenção aos efeitos colaterais:

- Todos os objetos criados a partir da classe começarão com esse valor
- Pode gerar comportamentos inesperados se não for intencional

✅ O valor pode ser sobrescrito depois:

Exemplo:
```java
    estudante.nome = "Sanji";
```

📌 Use inicialização direta apenas quando o valor padrão fizer sentido para **todos os casos**.

---

### 🎯 Alta Coesão (Conceito Fundamental)

Coesão representa o nível de foco de uma classe em um único propósito.

🚫 Exemplo ruim:
```java
    public class Estudante {
        public String nome;
        public int idade;
        public String nomeProfessor;
    }
```

❌ Mistura conceitos diferentes
❌ Cria dependências desnecessárias
❌ Viola o princípio da responsabilidade única

✅ Exemplo correto:
```java
    public class Estudante { ... }
    public class Professor { ... }
```

⭐ **Uma classe deve ter um único papel claro**

📌 Alta coesão facilita manutenção, testes e evolução do sistema.

---

### 🧪 Classes de Domínio vs Classes de Teste

- Classes de domínio
  - Representam entidades do sistema
  - Não executam código diretamente
  - Não possuem `main`
- Classes de teste:
    - Contêm o método `public static void main`
    - São usadas para executar e validar o comportamento

✅ Boa prática de organização

Exemplo:
```java
    dominio/
    └── Estudante.java
    teste/
    └── EstudanteTest.java
```

📌 Separar domínio e execução melhora clareza e estrutura do projeto.

---

## 🚀 Síntese Final ✅🧠

- **Classes** são moldes
- **Objetos** são instâncias em memória
- Variáveis de referência apontam para objetos
- Atributos recebem valores padrão automaticamente
- `new` cria objetos
- O operador `.` acessa dados e comportamentos
- Inicialização na classe afeta todos os objetos
- **Alta coesão** é essencial para código saudável
- Classes de domínio não executam código
- Duas referências podem apontar para o mesmo objeto
- Perder uma referência significa perder o acesso ao objeto

---