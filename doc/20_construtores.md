# 📘 Guia — Construtores e Sobrecarga em Java

Este guia apresenta o conceito de **construtores em Java**, explicando como eles funcionam na criação de objetos, como ocorre a **sobrecarga de construtores** e como utilizar o recurso `this()` para reaproveitamento de código dentro da própria classe.

---

## 🧠 Resumo

Construtores são responsáveis por **inicializar objetos** no momento da sua criação.

Características principais:

* Não possuem tipo de retorno
* Possuem o mesmo nome da classe
* São executados automaticamente na criação do objeto
* Podem ser sobrecarregados

Mesmo que você não defina um construtor, o Java cria um **construtor padrão automaticamente** durante a compilação.

---

## 🧩 O que são construtores

Um construtor é um bloco especial que define como um objeto será criado.

Exemplo de estrutura:

```java
    public Anime() {
    }
```

Regras importantes:

* O nome deve ser igual ao nome da classe
* Não pode ter retorno (nem void)
* Pode ter parâmetros ou não

### ⚙️ Construtor padrão do Java

Se nenhuma implementação for feita, o Java adiciona automaticamente um construtor vazio.

Isso significa que todas as classes possuem pelo menos um construtor, mesmo que invisível no código-fonte.

### ⚠️ Diferença entre método e construtor

Um erro comum é confundir construtores com métodos.

Se você adiciona um retorno, como void, o elemento deixa de ser um construtor e passa a ser um método comum.

Exemplo:

```java
    public void Anime() {
    }
```

Nesse caso, isso **não é um construtor**, é um método.

### 🧠 Sobrecarga de construtores

Assim como métodos, construtores também podem ser sobrecarregados.

Isso significa que podemos ter:

* Mais de um construtor na mesma classe
* Diferentes combinações de parâmetros

Exemplo de problema resolvido pela sobrecarga:

* Antes: apenas um jeito de criar o objeto
* Depois: múltiplas formas de criação

#### 🧱 Exemplo de sobrecarga

Uma classe pode ter:

* Construtor vazio
* Construtor com parâmetros
* Construtor com diferentes combinações

Exemplo conceitual:

```java
    public Anime() {
    }
    
    public Anime(String nome) {
    }
    
    public Anime(String nome, String tipo, int episodios, String genero) {
    }
```

### 🔁 Uso de this() entre construtores

Dentro de um construtor, é possível chamar outro construtor da própria classe usando this().

Isso permite evitar repetição de código.

#### 📌 Regras importantes

* *this()* só pode ser usado dentro de construtores
* Deve ser **a primeira linha executável**
* Não pode haver outra instrução antes dele

### 🧠 Reaproveitamento de construtores

Quando um construtor chama outro:

* O fluxo é redirecionado para o construtor chamado
* Depois retorna para continuar a execução original

Isso permite centralizar a lógica de inicialização.

### ⚙️ Inicialização de objetos

Construtores permitem inicializar objetos diretamente na criação:

* Antes: inicialização via métodos separados
* Depois: inicialização completa no construtor

Exemplo conceitual:

* Nome
* Tipo
* Episódios
* Gênero
* Estúdio

### ⚠️ Regras importantes de uso

* Se um construtor é definido, o Java não adiciona outro automaticamente
* A assinatura (parâmetros) define qual construtor será chamado
* Alterar assinatura pode quebrar código existente
* Construtores sempre são executados antes de qualquer método da classe

---

## 🚀 Resumo final

* Construtores inicializam objetos em Java
* Sempre têm o mesmo nome da classe
* Não possuem retorno
* Podem ser sobrecarregados
* O Java cria um construtor padrão se nenhum for definido
* *this()* permite chamar outro construtor da mesma classe
* *this()* deve ser a primeira linha do construtor
* Construtores são executados antes de qualquer método
* Sobrecarga permite múltiplas formas de criação de objetos

---