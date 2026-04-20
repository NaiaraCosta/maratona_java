# 📘 Guia — Blocos de Inicialização em Java

Este guia apresenta o conceito de **blocos de inicialização em Java**, explicando como eles funcionam na criação de objetos, sua ordem de execução e como ajudam a evitar duplicação de código entre construtores.

---

## 🧠 Resumo

Blocos de inicialização são trechos de código executados automaticamente **sempre que um objeto é criado**, independentemente do construtor utilizado.

Características principais:

* Executados antes do construtor
* Executados toda vez que uma instância é criada
* Usados para inicialização comum entre construtores
* Evitam duplicação de código

---

## 🧩 O que são blocos de inicialização

Blocos de inicialização são blocos de código definidos dentro da classe, sem nome e sem retorno, que são executados automaticamente ao criar um objeto.

Exemplo:

```java
    {
        System.out.println("inicialização executada");
    }
```

Eles são executados **antes de qualquer construtor**.

### ⚙️ Problema sem blocos de inicialização

Sem blocos de inicialização, a lógica de inicialização precisa ser repetida em todos os construtores.

Exemplo de problema:

* Inicializar arrays manualmente em cada construtor
* Duplicação de lógica
* Maior risco de inconsistência entre construtores

### 🧱 Exemplo com array de episódios

Uma classe pode ter um array inicializado com valores padrão:

```java
    int[] episodios = new int[10];
```

Ou preenchido manualmente:

```java
    for (int i = 0; i < episodios.length; i++) {
        episodios[i] = i + 1;
    }
```

Sem blocos de inicialização, esse código precisaria ser repetido em cada construtor.

### 🔁 Repetição em múltiplos construtores

Quando a classe possui mais de um construtor:

* Cada construtor precisa inicializar os mesmos dados
* Isso gera duplicação de código
* Pode causar inconsistência entre objetos criados de formas diferentes

### 🚀 Solução: bloco de inicialização de instância

O bloco de inicialização resolve esse problema centralizando a lógica.

Exemplo:

```java
    {
        System.out.println("iniciando bloco de inicialização");
        episodios = new int[100];
        for (int i = 0; i < episodios.length; i++) {
            episodios[i] = i + 1;
        }
    }
```

Independentemente do construtor chamado, esse bloco sempre será executado.

### ⚠️ Ordem de execução

A ordem de execução na criação de um objeto segue este fluxo:

* Alocação de memória para o objeto
* Inicialização dos atributos com valores padrão ou definidos
* Execução do bloco de inicialização
* Execução do construtor

###  🧠 Importante

* O bloco de inicialização é executado antes do construtor
* Ele é executado toda vez que um objeto é criado
* Ele não depende do construtor chamado
* Pode ser colocado em qualquer posição da classe (geralmente no início)

---

## 🚀 Resumo final

* Blocos de inicialização executam automaticamente na criação de objetos
* São executados antes dos construtores
* Evitam duplicação de código entre construtores
* São úteis para inicialização comum de atributos
* A ordem de execução segue: memória → atributos → bloco → construtor

---