# ☕ Introdução ao Java

Java é uma linguagem de programação de **alto nível**, **orientada a objetos** e muito utilizada para criar aplicações **multiplataforma**.

Ela está presente em:

* 🖥️ Aplicações desktop
* 🌐 Sistemas web
* 📱 Apps Android
* ☁️ Backends e microsserviços

---

## 🧠 Como o Java funciona?

Diferente de outras linguagens, o Java **não é executado diretamente pelo sistema operacional**.

Ele utiliza uma camada intermediária que garante portabilidade:

> 💡 **O código Java roda na JVM (Java Virtual Machine)**

---

## 🔄 Processo de compilação e execução

### 📌 Fluxo simplificado

```
.java → javac → .class (bytecode) → JVM (JIT) → Código nativo
```

---

## ⚙️ Etapas detalhadas

### 1️⃣ Escrita do código

O desenvolvedor cria um arquivo:

```
Arquivo.java
```

---

### 2️⃣ Compilação (javac)

O compilador transforma o código em **bytecode**:

```
javac Arquivo.java
```

➡️ Gera:

```
Arquivo.class
```

📦 Esse arquivo contém **instruções intermediárias independentes do sistema operacional**.

---

### 3️⃣ Execução na JVM

A **JVM** executa o bytecode utilizando:

* 🔍 **Interpretador** → executa linha por linha
* ⚡ **JIT (Just-In-Time Compiler)** → converte partes do código para **código nativo** em tempo de execução

---

## 🧩 O que é Bytecode?

Bytecode é um formato intermediário que permite a portabilidade do Java:

* 📌 Não é código fonte
* 📌 Não é código de máquina direto
* 📌 Pode rodar em qualquer sistema com JVM

---

## 🌍 Portabilidade (WORA)

### ✨ Write Once, Run Anywhere

💡 A principal vantagem do Java é o conceito de:

> "Escreva uma vez, execute em qualquer lugar"

Graças à JVM, você pode rodar o mesmo código em:

* 🪟 Windows
* 🐧 Linux
* 🍎 macOS

Sem precisar recompilar!

---

## 🖼️ Representação visual

![Diagrama do fluxo Java](img/img.png)

---

## 🚀 Resumo rápido

* ☕ Java é **multiplataforma**
* 🔄 Usa **bytecode + JVM**
* ⚡ Possui otimização com **JIT**
* 🌍 Permite **portabilidade real**
