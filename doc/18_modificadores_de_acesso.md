# 📘 Guia — Encapsulamento, Acoplamento e Getters/Setters em Java

---

## 🧠 Resumo

Em Java, **variáveis de referência não armazenam objetos diretamente**, mas sim **endereços de memória que apontam para objetos**.

Esses objetos podem ser protegidos através de **modificadores de acesso**, garantindo controle sobre como os dados são lidos e alterados.

O uso de **encapsulamento (`private` + getters/setters)** reduz o acoplamento e protege as regras de negócio dentro das classes.

---

## 🧩 Objetos e memória

Quando criamos objetos com `new`, eles são armazenados na memória heap:

```java
    Carro carro1 = new Carro();
    Carro carro2 = new Carro();
```

### 📌 Importante

* Uma variável de referência (pessoa)
* Um objeto armazenado na memória heap
* A referência apontando para esse objeto

---

## 🔒 Atributos privados e acesso

Dentro da classe, os atributos geralmente são:

```java
    Carro carro1 = new Carro();
    Carro carro2 = new Carro();
```

### 📌 Importante

* Fora da classe → não podem ser acessados diretamente
* Dentro da classe → acesso livre

---

## 🔁 Setters (alteração de valores)

Os setters servem para **definir valores nos atributos privados**.

```java
    pessoa.setNome("Geralda");
    pessoa.setIdade(70);
```

### 📌 Características

* Recebem parâmetros
* Geralmente são void
* Podem validar dados antes de salvar

Exemplo com validação:

```java
    public void setIdade(int idade) {
        if (idade < 0) {
            System.out.println("Idade inválida");
            return;
        }
        this.idade = idade;
    }
```
### 📌 Uso do this

* Diferencia atributo do parâmetro
* Refere se ao objeto atual

---

## 📤 Getters (acesso aos valores)

Os setters servem para definir valores nos atributos privados.

```java
    public String getNome() {
        return nome;
    }
```

```java
    public int getIdade() {
        return idade;
    }
```
### 📌 Características:

* Retornam o valor do atributo
* Não recebem parâmetros
* Expõem dados de forma controlada

---

## 🧱 Acesso dentro vs fora da classe

### Dentro da classe

```java
    System.out.println(nome);
    System.out.println(idade);
```

#### 📌 Aqui:
* Não precisa de getter
* Acesso direto é permitido

### Fora da classe

Fora da classe, usamos métodos:

```java
    pessoa.getNome();
    pessoa.getIdade();
```

📌 Porque atributos são private

---

## ⚠️ Acesso direto (anti-padrão)

```java
    pessoa.nome = "Geralda";
```

---

## 🧠 Encapsulamento

Encapsulamento significa:

* Esconder dados internos
* Controlar acesso via métodos

### 📌 Estrutura correta:

* atributos → private
* métodos → public

---

## 🔁 Acoplamento entre classes

Acoplamento é o quanto uma classe depende da outra.

### 🔴 Alto acoplamento

* Acesso direto a atributos
* Mudanças quebram outras classes facilmente

### 🟢 Baixo acoplamento

* Comunicação via métodos (get e set)
* Mudanças internas não quebram o sistema

---

## 📌 Contrato entre classes

Métodos públicos formam um contrato:

* Nome do método
* Parâmetros
* Retorno

### 📌 Se esse contrato muda:

* Outras classes podem quebrar
* Aumenta o acoplamento

---

## 🧱 Uso de getters dentro da classe

Dentro da própria classe:

```java
    System.out.println(nome);
```

ou

```java 
    System.out.println(getNome());
```

### 📌 Regra prática:

* Dentro da classe → acesso direto
* Fora da classe → getters e setters

---

## 🚀 Resumo final

* Variável de referência aponta para objetos na memória
* `private` protege atributos (encapsulamento)
* `public` expõe métodos controlados
* `set` altera valores do objeto
* `get` recupera valores do objeto
* `this` referencia o próprio objeto
* baixo acoplamento é o objetivo principal
* getters e setters criam um contrato entre classes
* encapsulamento organiza e protege o código

---