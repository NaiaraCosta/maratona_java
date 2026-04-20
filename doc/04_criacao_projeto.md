# 📘 Guia Completo — Criação de Projeto Java no IntelliJ IDEA

Este guia mostra como criar e estruturar um projeto Java dentro da IDE IntelliJ IDEA.

---

## 🧠 Resumo

Ao criar um projeto Java, a IDE já configura automaticamente:

* Estrutura de pastas
* JDK
* Sistema de build
* Diretórios de saída

---

## 📁 Estrutura do projeto

Um projeto Java padrão contém:

* src → código fonte
* out → arquivos compilados (.class)
* .idea → configurações da IDE

👉 A pasta principal para desenvolvimento é src.

---

## ⚙️ Criação do projeto

Passos:

* New Project
* Selecionar Java
* Definir JDK (ex: Java 15 ou LTS 11)
* Nome do projeto: Maratona Java
* Finalizar criação

📌 JAVA_HOME

A IDE utiliza a variável:

**JAVA_HOME**

para localizar o JDK automaticamente.

---

## 💻 Criação de classe

Para criar uma classe:

* Botão direito em src
* New → Java Class
* Nome da classe

📌 Regra importante:

O nome da classe deve ser igual ao nome do arquivo.

## 🚀 Exemplo de classe

```java
    public class OlaDevDojo {
        public static void main(String[] args) {
            System.out.println("Hello World");
        }
    }
```

---

##  ▶️ Execução

Formas de executar:

*   Botão Run ▶
*   Shift + F10

📌 A IDE compila automaticamente antes de executar.

---

## 🚀 Resumo final

*   Projeto já vem estruturado automaticamente
*   src contém o código fonte
*   Execução é feita com um clique
*   Não é necessário usar terminal manualmente

---