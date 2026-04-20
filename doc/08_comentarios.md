# 📘 Guia Completo — Comentários em Java

Este guia apresenta os tipos de **comentários em Java**, suas aplicações, boas práticas e o uso correto do **JavaDoc** dentro do desenvolvimento profissional.

---

## 🧠 Resumo

Comentários em Java são trechos de código que **não são executados pela JVM**.

Eles servem apenas para documentação interna do código e comunicação entre desenvolvedores.

Existem três tipos principais:

* Comentário de uma linha
* Comentário de múltiplas linhas
* JavaDoc (documentação oficial)

---

## 💻 O que são Comentários

Comentários são instruções ignoradas pelo compilador e não fazem parte do bytecode final.

📌 Ou seja: 
Eles não afetam a execução do programa.

São usados para:

* Explicar trechos de código
* Documentar decisões técnicas
* Gerar documentação oficial (JavaDoc)

---

## ✏️ Tipos de Comentários em Java

## 📌 Comentário de uma linha

Usa `//`

```java 
    id="q8xv3n"
    // Isso é um comentário de uma linha
    System.out.println("Olá");
```

## 📌 Comentário de múltiplas linhas

```java
    /*Isso é um comentário
    de múltiplas linhas
    */
    System.out.println("Olá");
```

### Características:

* Permite várias linhas de comentário
* Tudo entre /* e */ é ignorado
* Usado para explicações maiores
* Não deve ser usado de forma desorganizada


## 📌 JavaDoc (comentário oficial)

Usa /** ... */

```java
    /**
    * Isso é um JavaDoc
    */
```  

### Características:

* Comentário oficial do Java
* Usado para documentar classes e métodos
* Pode gerar documentação automática
* Suporta formatação e HTML

### 📘 Exemplo de JavaDoc com descrição

```java
    /**
      * Classe responsável por demonstrar o uso de JavaDoc.
      */
    public class Exemplo {
    }
```   

### 📚 JavaDoc em Métodos

```java
    /**
      * Imprime uma mensagem no console.
      *
      * @param msg mensagem a ser exibida
      */
    public void imprimir(String msg) {
        System.out.println(msg);
    }
```

### 🧠 Como visualizar JavaDoc

No IntelliJ IDEA:

* Ctrl + Q → mostra documentação do método
* Ctrl + Click → navega para implementação

### ⚙️ Por que o JavaDoc é importante

O JavaDoc é usado para:

* Documentar APIs
* Facilitar uso de bibliotecas
* Permitir entendimento do código sem leitura interna
* Padronizar documentação em equipes

📌 Exemplo real: 
classes da própria API do Java usam JavaDoc extensivamente.

---

## ⚠️ Boas práticas com comentários

*✔ Usar quando necessário:*
* Explicar decisões de negócio complexas
* Documentar APIs públicas
* Explicar regras não óbvias

*❌ Evitar:*
* Comentários óbvios
* Explicar código autoexplicativo
* Comentários desatualizados
* Excesso de comentários de linha

---

## 🧠 Filosofia de código limpo

A prática moderna de desenvolvimento (Clean Code) recomenda:

*Código deve ser autoexplicativo.*

📌 Ou seja: 
Se você precisa comentar tudo, o código provavelmente está mal escrito.

---

## 💡 Problema comum com comentários

Comentários podem se tornar obsoletos:

* Código muda
* Comentário não é atualizado
* Informação fica errada

👉 Isso gera mais confusão do que ajuda.

---

## 📘 Quando comentários são úteis

Comentários são válidos quando:

* Explicam decisões de negócio
* Justificam regras específicas
* Documentam APIs públicas
* Explicam comportamento não óbvio

---

## 🚀 Resumo final

* Comentários não são executados pelo Java
* Existem 3 tipos: //, /* */ e JavaDoc
* JavaDoc é o único tipo recomendado para documentação profissional
* Comentários devem ser usados com moderação
* Código limpo deve ser preferencialmente autoexplicativo
* Comentários desatualizados são um problema comum em sistemas reais

---