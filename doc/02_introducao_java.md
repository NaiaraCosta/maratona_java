# 📘 Guia — Como o Java Funciona (JVM, Compilação e Execução)

Este guia apresenta como o Java funciona internamente, explicando o conceito de **Write Once**, **Run Anywhere**, o papel da **JVM**, o processo de **compilação** e a estrutura do **JDK** e **JRE**.

---

## 🧠 Resumo

* Java não executa diretamente no sistema operacional
* O código Java é compilado para **bytecode**
* O bytecode é executado pela **JVM (Java Virtual Machine)**
* O mesmo programa pode rodar em Windows, Linux e macOS
* O **JDK** é usado para desenvolvimento
* O **JRE** é usado apenas para execução

---

## 🧩 Problema que o Java resolve

Sistemas operacionais são diferentes:

* Windows
* Linux
* macOS

⚙️ Problema original

Sem Java:

* Cada sistema operacional exigia um programa diferente
* Aplicações não eram portáveis
* Alto custo de manutenção

---

## 🚀 Solução do Java

Java introduz uma camada intermediária:

**JVM (Java Virtual Machine)**

A JVM atua como um tradutor entre:

* Sistema operacional
* Aplicação Java

---

## 🧱 Arquitetura do Java

Fluxo geral:

1. Código fonte (.java)
2. Compilação
3. Bytecode (.class)
4. JVM executa

---

## ⚙️ Processo de compilação

### 📄 Código fonte

Arquivo escrito por humanos:

```java
    App.java
```

### ⚙️ Compilação

Usando o compilador:

```bash
    javac App.java
```

### 📦 Resultado

Geração do bytecode:

```java
    App.class
```
---

## 🧠 O que é bytecode

* Código intermediário entre Java e sistema operacional
* Não é legível diretamente por humanos
* Entendido pela JVM

---

## 🧩 JVM (Java Virtual Machine)

A JVM é responsável por:

* Interpretar bytecode
* Executar programas Java
* Adaptar execução ao sistema operacional

### 🔁 Característica principal

A JVM é específica para cada sistema operacional

---

## 🧱 Write Once, Run Anywhere

Significado:

Você escreve o código uma vez e executa em qualquer lugar.

### Como isso funciona:

* Você compila uma vez
* Gera bytecode
* JVM adapta para cada sistema

---

## ⚙️ JDK vs JRE

### 🧩 JDK (Java Development Kit)

Usado para desenvolvimento:

Inclui:

* Compilador (javac)
* JVM
* Ferramentas de debug
* Bibliotecas

### 🧩 JRE (Java Runtime Environment)

Usado apenas para execução:

Inclui:

* JVM
* Bibliotecas essenciais

### 🧩 JDK (Java Development Kit)

* JVM
* Bibliotecas essenciais

### 🧠 Diferença essencial

| Componente | Função                 |
|------------|------------------------|
| JDK        | Desenvolver aplicações |
| JRE        | Executar aplicações    |
| JVM        | Interpretar bytecode   |

---

## 🔁 JVM e sistema operacional

A JVM atua como intermediária:

* JVM → Windows
* JVM → Linux
* JVM → macOS

Ela traduz o bytecode para cada ambiente.

### 🧠 Vantagem principal

* Portabilidade total
* Um único código fonte
* Menos retrabalho

---

## ⚙️ Retrocompatibilidade

Java mantém compatibilidade entre versões:

* Código antigo continua funcionando
* Atualizações focam em:
  * Performance
  * Segurança
  * Novos recursos

---

## 🚨 Importante

Java é considerado:

* Compilado (gera bytecode)
* Interpretado (executado pela JVM)

---

## 📌 Fluxo final resumido

**.java → javac → .class → JVM → Sistema Operacional**

---

## 💡 Ideia central

Java não roda diretamente no sistema operacional — ele roda dentro da JVM.

---

## 🚀 Resumo final

* Java usa JVM para abstrair sistemas operacionais
* Código Java é compilado para bytecode
* Bytecode é executado pela JVM
* JDK é usado para desenvolvimento
* JRE é usado para execução
* Isso permite portabilidade real entre plataformas

---