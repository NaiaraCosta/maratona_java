# 📘 Guia Completo — Ambiente de Desenvolvimento Java (IDE IntelliJ IDEA)

Este guia apresenta a configuração do ambiente de desenvolvimento Java utilizando o IntelliJ IDEA e o fluxo inicial de criação de projetos.

---

## 🧠 Resumo

No desenvolvimento Java moderno, não utilizamos apenas um editor de texto.

Utilizamos uma IDE (Integrated Development Environment), que automatiza:

* Escrita de código
* Compilação automática
* Execução do programa
* Detecção de erros em tempo real
* Organização de projetos

---

## 💻 IDE (Ambiente de Desenvolvimento)

Uma IDE é uma ferramenta que centraliza todas as necessidades do desenvolvedor.

### Principais funcionalidades

* Editor inteligente com autocompletar
* Compilação integrada
* Execução com um clique
* Debugger
* Análise de erros em tempo real

### 🔥 IntelliJ IDEA

O IntelliJ IDEA é uma das IDEs mais utilizadas no desenvolvimento Java profissional.

#### Características

* Muito usado no mercado internacional
* Alta produtividade
* Integração completa com o JDK
* Excelente suporte ao ecossistema Java

#### Versões:

* Community (gratuita)
* Ultimate (paga)

👉 Para aprendizado, a versão Community é suficiente.

##### 💰 Observação sobre custo

* Aproximadamente 15 USD/mês na versão paga
* Possui versões gratuitas para estudantes em alguns casos

---

## ⚙️ Instalação e Configuração do IntelliJ IDEA

### ⬇️ Download e instalação

Durante a instalação:

* Baixe a versão Community Edition
* Execute o instalador
* Clique em Next até finalizar
* Execute o IntelliJ IDEA

### 🎨 Configuração inicial

Após abrir a IDE:

* Ajustar tamanho da fonte (ex: 18 ou 22)
* Escolher tema (Light ou Dark)
* Configurar preferências de editor

💡 Essas configurações são pessoais e não afetam o código.

### 🔌 Plugins úteis

O IntelliJ permite instalação de plugins para melhorar a experiência.

#### Exemplo:

* Presentation Assistant → exibe atalhos na tela

📌 Isso ajuda no aprendizado de shortcuts.

### ⌨️ Atalhos importantes

* Alt + Insert → criar classes/arquivos
* Ctrl + Shift + F10 → executar projeto
* Alt + F12 → abrir terminal
* Shift + Shift → busca global

### 🧠 Comportamento da IDE

A IDE:

* Compila o código automaticamente em segundo plano
* Detecta erros antes da execução
* Sugere correções automaticamente

---

## 📘 Criação de Projeto Java no IntelliJ IDEA

### 📁 Criando um novo projeto

Passos:

1. Clique em New Project
2. Selecione Java
3. Verifique o JDK (detectado automaticamente)
4. Clique em Next
5. Nome do projeto: 👉 Maratona-Java
6. Clique em Finish

💡 O IntelliJ detecta automaticamente o Java instalado via variável de ambiente.

### 📂 Estrutura do projeto

O projeto é organizado da seguinte forma:

* 📁 src → código fonte Java
* 📁 out → arquivos compilados (.class)
* ⚙️ arquivos de configuração da IDE

**👉 O foco do desenvolvedor é sempre a pasta src.**

---

## ☕ Criando uma classe Java

Para criar uma classe:

* Clique com botão direito em src
* New → Java Class
* Defina o nome da classe

### Convenção de nomes:

   ` ✔ HelloDevDojo`  
   `❌ hellodevdojo`

### 📌 Regras:

* Classes começam com letra maiúscula
* Palavras compostas também seguem padrão PascalCase

---

### 💻 Estrutura básica de uma classe Java

```java
    public class HelloDevDojo {    
        public static void main(String[] args) {
            System.out.println("Olá, Dev Dojo!");
        }
    }
```

### 🧠 Explicação:

* public class → define a classe
* main → ponto de entrada da aplicação
* System.out.println → imprime no console

---

## 🚀 Execução do programa

Você pode executar de duas formas:

* ▶ Botão Run (play)
* ⌨ Ctrl + Shift + F10

A IDE automaticamente:

1. Compila o código
2. Gera bytecode (.class)
3. Executa na JVM

---

## 📦 Build vs Run

*   *Buil* → apenas compila o projeto
*   *Run* → compila e executa

A saída do build vai para:

* out/

---

## ⚠️ Erros comuns

* Nome da classe diferente do arquivo → erro de compilação
* Falta de ponto e vírgula → erro de sintaxe
* Código não atualizado → precisa salvar e recompilar

💡 A IDE já aponta esses erros antes da execução.

---

## 🚀 Resumo final

* IDE substitui o desenvolvimento manual
* IntelliJ IDEA automatiza o fluxo de trabalho
* Projeto Java começa na pasta src
* Classe deve seguir convenções de nome
* Execução pode ser feita via botão Run
* IDE compila e executa automaticamente

---