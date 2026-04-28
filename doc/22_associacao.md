# 📘 Guia — Associação em Java (Relacionamento entre Objetos)

Este guia apresenta o conceito de **associação em Java**, com foco em como objetos se relacionam, principalmente em cenários de **um para muitos (1:N)**.

---

## 🧠 Resumo

Associação é o conceito que define o **relacionamento entre objetos/classes**.

Na prática, significa que um objeto pode:

* Referenciar outro objeto
* Ou um conjunto de objetos
* Formando estruturas como **1 para 1, 1 para N, N para 1 e N para N**

---

## 🧩 O que é Associação

Associação representa como classes se conectam no mundo orientado a objetos.

Exemplo conceitual:

* Uma **Escola** pode ter vários **Professores**
* Um **Professor** pode pertencer a uma **Escola**

Esses relacionamentos são modelados através de:

* Atributos de referência
* Arrays de objetos
* (Futuramente) coleções como List, Set e Map

---

## 🔁 Tipos de Relacionamento

### 👤 Um para Um (1:1)

* Um objeto se relaciona com apenas outro único objeto

### 👥 Um para Muitos (1:N)
* Um objeto referencia **vários objetos**
    Exemplo: uma escola com vários professores

### 👥 Muitos para Um (N:1)
* Vários objetos apontam para um único objeto
    Exemplo: vários professores em uma mesma escola

### 🔄 Muitos para Muitos (N:N)
* Ambos os lados possuem múltiplas referências
    Exemplo: estudantes e cursos

### 👨‍🏫 Exemplo: Escola e Professores (1 para muitos)

Neste cenário:

* Uma **Escola** pode conter vários **Professores**
* O relacionamento é implementado com **array de objetos**

#### 🏫 Classe Escola

* Atributo: nome
* Atributo: professores[] (array de objetos Professor)
* Método: imprimir()
    Exemplo de lógica de impressão:  
    * Exibe o nome da escola
    * Percorre o array de professores
    * Verifica se o array não é nulo antes de acessar

#### 👨‍🏫 Classe Professor

* Atributo: **nome**
* Método: getter/setter
* Pode ser impresso individualmente

#### 🔄 Comportamento do relacionamento

* A escola guarda múltiplos professores
* Os professores são passados via array
* A impressão percorre os objetos usando estrutura de repetição
* Pode haver sobrecarga de construtor para facilitar criação com ou sem professores

---

## ⚠️ Cuidados importantes

* Sempre validar `null` antes de acessar objetos associados
* Arrays podem estar vazios ou não inicializados
* Evitar `NullPointerException` ao acessar relações
* Escolher bem entre:
  * inicializar via construtor
  * ou via setter após criação

---

## 🚀 Resumo final

* Associação representa relacionamento entre objetos em Java
* Pode ser `1:1`, `1:N`, `N:1` ou `N:N`
* No exemplo, `Escola → Professores` é um relacionamento **um para muitos**
* Arrays são usados para representar múltiplos objetos associados
* Sempre validar nulidade para evitar erros em tempo de execução

---