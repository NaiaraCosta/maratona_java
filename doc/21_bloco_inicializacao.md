# 📘 Guia — Inicialização e Modificadores static em Java

Este guia apresenta de forma completa os conceitos de **blocos de inicialização**, **atributos estáticos** e **métodos estáticos** em Java, explicando comportamento, ordem de execução e boas práticas.

---

## 🧠 Resumo

* Blocos de inicialização executam automaticamente na criação de objetos
* Blocos estáticos executam apenas uma vez no carregamento da classe
* Atributos `static` pertencem à classe, não ao objeto
* Métodos `static` não dependem de instância
* `this` não pode ser usado em contexto estático
* `static` é ideal para dados e comportamentos globais

---

## 🧩 Blocos de inicialização (instância)

Blocos de inicialização são executados automaticamente **sempre que um objeto é criado**.

Exemplo de estrutura:

```java
    {
        System.out.println("Bloco de inicialização executado");
    }
```

---

### ⚙️ Problema

* Código de inicialização precisa ser repetido
* Aumenta a duplicação
* Pode gerar inconsistência

---

### 🚀 Solução

Centralizar a lógica no bloco de inicialização:

* Executado independentemente do construtor
* Garante consistência entre objetos

---

#### ⚠️ Ordem de execução

1. Alocação de memória
2. Inicialização de atributos
3. Bloco de inicialização
4. Construtor

---

####🧠 Importante

* Executado toda vez que um objeto é criado
* Independente do construtor utilizado
* Ideal para lógica comum entre construtores

---

#### Atributos `static`

Atributos `static` pertencem à classe, não às instâncias.

```java
    public static double velocidadeLimite = 250;
```

---

### ⚙️ Problema

Sem `static`:

*Cada objeto possui a sua própria cópia
*Alterações afetam apenas um objeto

---

### 🚀 Solução

Usar `static` para compartilhar o valor:

```java
    Carro.velocidadeLimite = 180;
```

---

### 🔁 Comportamento

* Uma única cópia em memória
* Compartilhado por todos os objetos
* Independente da quantidade de instâncias

---

#### ⚠️ Boa prática

✔ Acessar via classe:

```java
    Carro.velocidadeLimite
```

❌ Evitar via instância:

```java
    c1.velocidadeLimite
```

---

### 🧩 Métodos `static`

Métodos `static` pertencem à classe e não dependem de objeto.

```java
    public static void setVelocidadeLimite(double valor) {
        Carro.velocidadeLimite = valor;
    }
```

---

#### ⚠️ Regra fundamental

Dentro de métodos estáticos:

* ✔ Pode acessar atributos estáticos
* ✔ Pode chamar métodos estáticos
* ❌ Não pode usar `this`
* ❌ Não pode acessar atributos de instância

---

#### 🧠 Justificativa

* Método pode ser executado sem objeto
* Logo, não existe instância garantida

---

#### Erro comum

```java
    this.velocidadeLimite // inválido
```

---

#### Uso recomendado

Utilizar métodos `static` quando:

* Não dependem de estado do objeto
* Representam comportamento global
* São utilitários (ex: cálculos)

---

#### 🔍 Exemplo importante

```java
    public static void main(String[] args)
```

* Método de entrada da aplicação
* Executado sem instância

---

#### 🧩 Blocos de inicialização static

```java
    static {
        System.out.println("Executado uma vez");
    }
```

---

#### ⚙️ Problema

Bloco de instância executando lógica repetida:

* Desnecessário
* Pode impactar performance

---

#### 🚀 Solução

Mover lógica para bloco estático:

* Executado apenas uma vez
* Compartilhado por todos os objetos

---

#### 🔁 Comportamento

* Executado ao carregar a classe
* Antes de qualquer objeto existir

---

#### ⚠️ Ordem de execução completa

1.Blocos de inicialização estáticos
2.Atributos estáticos
3.Carregamento da classe
4.Alocação de memória do objeto
5.Atributos de instância
6.Bloco de inicialização
7.Construtor

---

#### 🚫 Limitação

Dentro de bloco estático:

* ❌ Não pode acessar atributos de instância

---

#### 🔁 Múltiplos blocos

* Permitidos
* Executados uma única vez
* Seguem a ordem do código

---

#### 🧠 Comparação geral

| Elemento        | Pertence a | Execução           | Frequência       |
|-----------------|------------|--------------------|------------------|
| Atributo comum  | Objeto     | Ao criar objeto    | Múltiplas vezes  |
| Atributo static | Classe     | Ao carregar classe | Uma vez          |
| Bloco instância | Objeto     | Ao criar objeto    | Múltiplas vezes  |
| Bloco static    | Classe     | Ao carregar classe | Uma vez          |
| Método comum    | Objeto     | Via instância      | Depende          |
| Método static   | Classe     | Sem instância      | Global           |

---

## 🚀 Resumo final

* Blocos de inicialização evitam duplicação entre construtores
* static transforma atributos em compartilhados
* Métodos static não dependem de objeto
* Blocos estáticos executam apenas uma vez
* Contexto estático não acessa contexto de instância
* Use static para comportamento e estado global

---