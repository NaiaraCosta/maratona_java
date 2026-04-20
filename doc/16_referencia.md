# 📘 Guia — Variáveis de Referência em Java (Objetos e Memória)

Este guia explica como funcionam **variáveis de referência em Java**, como objetos são armazenados na memória e o que acontece quando múltiplas variáveis apontam para o mesmo objeto.

---

## 🧠 Resumo

Variáveis de referência **não armazenam objetos diretamente**, mas sim **endereços de memória (referências)**.

Isso significa que:

- Um objeto pode ter várias variáveis apontando para ele
- Uma variável pode mudar para referenciar outro objeto
- Quando um objeto perde todas as referências, ele fica inacessível na memória

---

## 🧩 Objetos e Memória

Quando criamos objetos com `new`, eles são armazenados na memória heap.

```java
    Carro carro1 = new Carro();
    Carro carro2 = new Carro();
```

---

## 🔁 Variáveis de referência

Uma variável de referência funciona como um “ponteiro” para um objeto.

Exemplo:

* *carro1* → aponta para um objeto
* *carro2* → aponta para outro objeto

---

## 🔁 Atribuição entre referências

É possível fazer uma variável apontar para o mesmo objeto de outra.

```java
    carro1 = carro2;
```

📌 **O que acontece aqui:**

* *carro1* deixa de apontar para seu objeto antigo
* *carro1* passa a apontar para o mesmo objeto de carro2*
* O objeto antigo de carro1 pode ficar sem referência

---

## ⚠️ Perda de referência (Garbage Collector)

Quando um objeto não tem mais nenhuma variável apontando para ele:

* Ele fica inacessível
* Não pode mais ser utilizado
* Será removido pelo Garbage Collector

**🧪 Exemplo de comportamento**

Antes:

* *carro1* → Objeto A
* *carro2* → Objeto B

Depois:

```java
    carro1 = carro2;
```

Agora:

* *carro1* → Objeto B
* *carro2* → Objeto B
* Objeto A → perdido na memória

---

## 🔄 Reversão da atribuição

Também é possível inverter a referência:

```java
    carro2 = carro1;
```

Agora ambos apontam para o mesmo objeto novamente.

---

## 📌 Regra importante

✔ Só podemos atribuir referências entre objetos do mesmo tipo

Exemplo válido:

```java
    Carro carro1 = new Carro();
    Carro carro2 = carro1;
```

Exemplo inválido:

```java
    Carro carro1 = new Carro();
    Professor p = carro1; // erro
```
### 🚫 Tipos incompatíveis

Java não permite:

* Carro → Professor
* Professor → Carro

Porque são tipos diferentes e não possuem relação direta.

---

## 🧠 Relação com herança

Esse comportamento será mais explorado em:

* Erança
* Olimorfismo

Onde pode haver compatibilidade entre tipos relacionados.

---

## 🧹 Organização de imports

Em alguns casos, o compilador pode remover imports não utilizados automaticamente:

* Limpeza de código
* Organização do projeto

---

## 🧠 Conceitos finais

* Variáveis de referência armazenam endereços de objetos
* Um objeto pode ter múltiplas referências
* Atribuir uma referência copia o endereço, não o objeto
* Objetos sem referência são removidos da memória
* Só é possível associar referências do mesmo tipo

---

## 🚀 Resumo final

* Objetos vivem na memória heap
* Variáveis não armazenam objetos, mas referências
* *carro1 = carro2* faz ambos apontarem para o mesmo objeto
* Objetos sem referência são perdidos (Garbage Collector)
* Tipos diferentes não podem ser atribuídos entre si
* Isso é base para herança e polimorfismo

---