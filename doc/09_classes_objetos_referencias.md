# 📘 Guia — Orientação a Objetos em Java (Classes, Objetos, Coesão e Referências)

**Introdução sólida aos fundamentos de `Orientação a Objetos` em `Java`, cobrindo `classes`, `objetos`, `atributos`, `variáveis de referência`, `coesão` e comportamento de referência em memória.**

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Orientação a Objetos (`OO`)** é o pilar central do desenvolvimento em `Java`.  
Enquanto variáveis primitivas armazenam **valores simples**, objetos permitem **agrupar dados relacionados** em uma única estrutura que representa algo do mundo real.  
Através de **classes**, criamos **objetos** que vivem em memória e são acessados por **variáveis de referência**.  
O entendimento correto desses conceitos é essencial para escrever código **manutenível**, **organizado** e **escalável**, respeitando princípios como **alta coesão**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Limitações das Variáveis Primitivas

- Tipos primitivos armazenam **apenas um valor**
- Não existe relação entre variáveis separadas

Exemplo:
```java
    int idade = 12;
    char sexo = 'M';
    String nome = "Rorizar";
```

🚫 Não há vínculo entre idade, sexo e nome
➡️ Não representam uma entidade única

---

### 🧠 Conceito de Objeto

- Um **objeto** representa uma entidade do mundo real
- Agrupa atributos relacionados
- Vive em um **único espaço de memória**

---

### 🧩 Classe: o Molde do Objeto

- Classe é um template
- Define atributos e comportamentos (métodos)
- Não executa sozinha (sem main)

Exemplo:
```java
    public class Estudante {
        public String nome;
        public int idade;
        public char sexo;
    }
```

⭐ Essa classe **não cria objetos**, apenas define como eles serão

---

### 🧪 Criando Objetos (Instanciação)

Exemplo:
```java
    Estudante estudante = new Estudante();
```

✅ Aqui temos:

- Variável de referência: estudante
- Objeto em memória: `new` Estudante()

📌 O operador **new sempre cria um objeto**

---

### 🎮 Variável de Referência

- Funciona como um **controle remoto**
- Aponta para um objeto em memória

Exemplo:
```java
    estudante.nome = "Luffy";
    estudante.idade = 18;
    estudante.sexo = 'M';
```

✅ Acesso aos atributos usando o operador .

---

### 🔍 Acessando Dados do Objeto

Exemplo:
```java    
    System.out.println(estudante.nome);
    System.out.println(estudante.idade);
    System.out.println(estudante.sexo);
```

⚠️ Imprimir apenas a variável de referência:

Exemplo:
```java    
    System.out.println(estudante);
```

➡️ Exibe o **endereço de memória** (referência)

---

### ⚙️ Valores Padrão em Atributos

Atributos de classe possuem valores padrão automaticamente:

| Tipo             | Valor Padrão |
|------------------|--------------|
| int              | 0            |
| char             | '\u0000'     |
| boolean          | false        |
| String / objetos | null         |

📌 Diferente de variáveis locais!

---

###  ⚠️ Inicialização Direta na Classe

Exemplo:
```java    
    public String nome = "Zoro";
```

🚨 Cuidado:

- Todos os objetos criados herdarão esse valor
- Pode gerar efeitos colaterais indesejados

✅ Ainda é possível sobrescrever depois:

Exemplo:
```java    
    estudante.nome = "Sanji";
```

---

### 🎯 Alta Coesão (Conceito Fundamental)

**Coesão** = foco da classe em um **único propósito**

🚫 Exemplo ruim: 
```java
    public class Estudante {
        public String nome;
        public int idade;
        public String nomeProfessor;
    }
```

❌ Mistura conceitos diferentes
❌ Dificulta manutenção
❌ Viola responsabilidade única

✅ Exemplo correto:
```java
    public class Estudante { ... }
    public class Professor { ... }
```

⭐ **Uma classe = um único papel claro**

---

### 🧪 Classes de Domínio vs Classes de Teste

- **Domínio**: representam o mundo real
- **Teste**: possuem `public` `static` `void` `main`

✅ Boa prática:

```text
    dominio/
    └── Estudante.java
    teste/
    └── EstudanteTest.java
```

---

## 🚀 Síntese Final ✅🧠

- **Classes** são moldes
- **Objetos** são instâncias em memória
- Variáveis de referência apontam para objetos
- Atributos possuem valores padrão
- `new` cria objetos
- Acesso aos dados é feito com .
- Inicialização na classe afeta todos os objetos
- **Alta coesão** = código saudável
- Classes de domínio não devem executar código
- Duas referências podem apontar para o mesmo objeto
- Perder uma referência significa perder o acesso ao objeto

---