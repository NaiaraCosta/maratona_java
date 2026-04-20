# 📘 Guia — Sobrecarga de Métodos em Java

---

## 🧠 Resumo

A **sobrecarga de métodos (method overloading)** em Java permite criar **métodos com o mesmo nome**, desde que tenham **assinaturas diferentes**, ou seja, variem na **quantidade ou no tipo dos parâmetros**.

Ela é usada para evitar duplicação de código e oferecer diferentes formas de inicializar ou executar uma mesma operação.

---

## 🧩 Criação da classe e estrutura base

Foi criada a classe **Anime**, representando um objeto do mundo real.

A classe possui atributos como:

* Tipo (tv, manga, dorama etc.)
* Episódios
* Nome
* Gênero

---

## 🔒 Encapsulamento com getters e setters

Os atributos são acessados de forma controlada usando **getters e setters**.

### 📌 Setters

Usados para alterar valores dos atributos:

```java
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
```

#### 📌 Características

* Recebem parâmetros
* Geralmente são void
* Podem validar valores antes de atribuir
* Usam this para referenciar o atributo da classe

### 📌 Getters

Usados para acessar valores dos atributos:

```java
    public String getNome() {
        return nome;
    }
    
    public int getEpisodios() {
        return episodios;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public String getGenero() {
        return genero;
    }
```

#### 📌 Características

* Não recebem parâmetros
* Retornam o valor do atributo
* Controlam o acesso aos dados da classe

---

## 🔒 Encapsulamento com getters e setters

Inicialmente, o objeto era inicializado assim:

```java
    anime.setTipo("TV");
    anime.setEpisodios(12);
    anime.setNome("Akudama Drive");
    anime.setGenero("Ação");
```

#### 📌 Problema

* Muitas chamadas separadas
* Risco de esquecer atributos
* Codigo mais verboso

---

## 🧠 Método de inicialização (init)

Foi criado um método para centralizar a inicialização:

```java
    public void init(String nome, String tipo, int episodios) {
        this.nome = nome;
        this.tipo = tipo;
        this.episodios = episodios;
    }
```

#### 📌 Uso

```java
    anime.init("Akudama Drive", "TV", 12);
```

#### 📌 Vantagens:

* Reduz repetição de código
* Centraliza inicialização
* Melhora organização

---

## ⚠️ Evolução do problema (novo atributo)

Foi adicionado o atributo:

* gênero

Inicialmente tratado separadamente:
    
```java
    anime.setGenero("Ação");
```

#### 📌 Problema

* Quebra o fluxo de inicialização única
*  Aumenta risco de inconsistência

## 🔁 Tentativa incorreta (duplicação de método)

Foi criada uma segunda versão do método:

```java
    public void init2(String nome, String tipo, int episodios, String genero) {
        this.nome = nome;
        this.tipo = tipo;
        this.episodios = episodios;
        this.genero = genero;
    }
```

#### 📌 Problema

* Duplicação de código
* Nomes diferentes para mesma responsabilidade
* Manutenção difícil

---

## 🧠 Sobrecarga de métodos (overloading)

A solução correta é a sobrecarga de métodos.

### 📌 Implementação correta

```java
    public void init(String nome, String tipo, int episodios) {
        this.nome = nome;
        this.tipo = tipo;
        this.episodios = episodios;
    }
```

```java
    public void init(String nome, String tipo, int episodios, String genero) {
    this.init(nome, tipo, episodios);
    this.genero = genero;
    }
```

### 📌 Definição de sobrecarga

Sobrecarga de métodos ocorre quando:

* O método tem o mesmo nome
* Mas possui parâmetros diferentes (tipo ou quantidade)

### ⚠️ O que NÃO importa na sobrecarga

* Modificador de acesso (public, private)
* Tipo de retorno

### 📌 O que importa

* Nome do método
* Lista de parâmetros

### 🧩 Reuso e delegação entre métodos

Um método pode chamar outro:

```java
    this.init(nome, tipo, episodios);
```

#### 📌 Benefícios

* Evita duplicação de código
* Centraliza lógica
* Facilita manutenção

### ⚠️ Ambiguidade

A sobrecarga não pode gerar ambiguidade.

#### 📌 Problema ocorre quando:

o compilador não consegue decidir qual método usar

Resultado:

* Erro de compilação

---

## 🧠 Comportamento em execução

Durante a execução:

* O método com 3 parâmetros inicializa parte do objeto
* O método com 4 parâmetros reutiliza o primeiro
* O objeto final é completamente inicializado

---

🚀 Resumo final

* Sobrecarga de métodos permite múltiplas versões do mesmo método
* Métodos devem ter o mesmo nome
* Parâmetros devem ser diferentes (tipo ou quantidade)
* Retorno e acesso não influenciam na sobrecarga
* Evita duplicação de código
* Permite evolução sem quebrar o sistema
* Métodos podem delegar lógica entre si
* Ambiguidade deve ser evitada para não gerar erros de compilação

---