# 📘 Guia — Orientação a Objetos em Java (Introdução)

Este guia apresenta os fundamentos de **Orientação a Objetos em Java**, com foco em **classes, objetos, atributos, referências de memória e criação de instâncias**. O objetivo é entender como o Java organiza dados do mundo real dentro de estruturas chamadas objetos.

---

## 🧠 Resumo

Orientação a Objetos permite **agrupar dados relacionados dentro de uma estrutura chamada classe**, que serve como um molde para criação de objetos.

---

## 🧱 Classes e Objetos

Em Java, uma **classe** é um molde que define como um objeto será estruturado. Já o **objeto** é a instância real criada a partir dessa classe.

---

### 📦 Classe como molde

Uma classe representa um conjunto de atributos que modelam algo do mundo real.

Exemplo: `Estudante`

```java
    public class Estudante {
        public String nome;
        public int idade;
        public char sexo;
    }
```

---

### 📌 Interpretação

* A classe define a estrutura
* Cada objeto criado terá esses atributos
* Funciona como um “molde” para instâncias

---

### 🧠 Objetos e Memória

Um objeto é criado usando new e armazenado na memória.

```java
    Estudante estudante = new Estudante();
```

#### 📌 O que acontece aqui:

* Um espaço na memória é criado
* Esse espaço contém *nome*, *idade*, *sexo*
* A variável estudante *não contém o objeto*, mas sim uma referência

---

### 🧷 Variável de Referência

A variável de referência funciona como um “controle remoto” para acessar o objeto.

```java
    estudante.nome = "Sundi";
    estudante.idade = 21;
    estudante.sexo = 'M';
```

#### 📌 Importante

* A variável aponta para o objeto na memória
* Sem referência, o objeto não pode ser acessado diretamente
* Sempre acessamos atributos via `.`

---

### 🧪 Valores Padrão em Objetos

Quando um objeto é criado, seus atributos recebem valores padrão automaticamente.


| Tipo             | Valor padrão |
| ---------------- | ------------- |
| int              | 0             |
| float/double     | 0.0           |
| char             | '\u0000' (vazio)              |
| boolean          | false              |
| String / objetos | null              |

#### 📌 Exemplo

```java
    Estudante e = new Estudante();

    System.out.println(e.nome);  // null
    System.out.println(e.idade); // 0
    System.out.println(e.sexo);  // '\u0000'
```

---

### ⚠️ Inicialização dentro da classe

Se um atributo for inicializado diretamente na classe:

```java
    public class Estudante {
        public String nome = "Zero";
    }
```

#### 📌 Consequência:

Todos os objetos começam com o mesmo valor:

```java
    Estudante e1 = new Estudante();
    Estudante e2 = new Estudante();
```

➡ Ambos terão nome = "Zero"

---

### 🔁 Múltiplos Objetos

Cada objeto ocupa um espaço independente na memória.

```java
    Estudante e1 = new Estudante();
    Estudante e2 = new Estudante();
```

#### 📌 Representação mental

    e1 → objeto A
    e2 → objeto B

Cada um com seus próprios dados.

#### 🧪 Alteração de estado

```java
    e1.nome = "Sundi";
    e2.nome = "Zoro";
```

##### 📌 Resultado:

* e1 e e2 são independentes
* Alterar um não afeta o outro

---

### 🧠 Referência vs Objeto

```java
    Estudante e = new Estudante();
```

* `e` → variável de referência
* `new Estudante()` → objeto real na memória

### 📦 Import e Organização de Pacotes

Para usar classes de outros pacotes:

```java
import javaCore.introducaoClasses.Estudante;
```

Ou com nome completo:

```java
javaCore.introducaoClasses.Estudante e = new javaCore.introducaoClasses.Estudante();
```

---

### 🧱 Criação de Objetos sem referência

```java
    new Estudante();
```

⚠️ O objeto existe, mas não pode ser acessado (sem referência).

---

### 🚨 Erros comuns

* ❌ Esquecer new ao criar objeto
* ❌ Confundir referência com objeto
* ❌ Acessar objeto sem referência
* ❌ Usar atributos sem inicialização adequada
* ❌ Alterar valor achando que afeta todos os objetos

---

## 🧠 Conceitos finais

* Classes são moldes de objetos
* Objetos vivem na memória
* Variáveis de referência apontam para objetos
* Cada objeto é independente
* Atributos têm valores padrão
* `new` sempre cria um novo espaço na memória

---

### 🚀 Resumo final

* Classes definem estrutura
* Objetos são instâncias reais
* Variáveis de referência apontam para objetos
* Cada objeto tem seus próprios valores
* Atributos podem ser inicializados automaticamente
* Modificar um objeto não afeta outros
* `new` sempre cria um novo objeto na memória

---