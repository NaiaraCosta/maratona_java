# 📘 Guia Completo — Compilação Manual em Java (javac e java)

Este guia explica como funciona o processo de compilação manual no Java.

---

## 🧠 Resumo

O Java não executa diretamente o código fonte (.java).

Ele segue um processo em 3 etapas:

1. Código fonte (.java)
2. Compilação (javac)
3. Execução (java)

---

## ⚙️ javac (Compilador)

O comando:

```bash
  javac NomeDaClasse.java
```

### Função:

* Converte código fonte em bytecode
* Gera arquivo .class
* Não executa o programa

📌 Resultado:

Arquivo compilado .class

---

## 💻 java — Execução

O comando:

```bash
    java NomeDaClasse  `
```

### Função:

* Executa o bytecode
* Utiliza a JVM
* Não usa extensão .class

📌 Importante:

Nunca executar com extensão:

```bash
    java NomeDaClasse.class
```

### 📁 Fluxo completo de execução

#### 1\. Código fonte

```java
    public class OlaDevDojo {    
        public static void main(String[] args) { 
            System.out.println("Hello World");    
        }
    }
```

#### 2\. Compilação

```bash    
  javac OlaDevDojo.java  
```

#### 3\. Execução

```bash
    java OlaDevDojo
```

---

### ⚠️ Erros comuns

### ❌ Nome da classe diferente do arquivo

* Arquivo: ola.java
* Classe: Ola

👉 Isso gera erro de compilação

### ❌ Falta de ponto e vírgula

```java
    System.out.println("Hello World");  
```

👉 erro de compilação

### ❌ Não recompilar após alterações

Sempre que alterar o código:

**👉 rodar javac novamente**

---

## 🧠 Conceito importante

* javac gera bytecode
* JVM executa bytecode
* Java não roda diretamente no sistema operacional

---

## 🚀 Resumo final

* .java → código fonte
* javac → gera .class
* java → executa programa
* JVM faz a ponte com o sistema operacional

---