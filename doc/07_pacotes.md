# 📘 Guia Completo — Pacotes em Java (IntelliJ IDEA)

Este guia apresenta o conceito de **pacotes em Java**, sua importância na organização de projetos e como utilizá-los corretamente no IntelliJ IDEA.

---

## 🧠 Resumo

No desenvolvimento Java, à medida que o projeto cresce, a organização do código se torna essencial.

Os **pacotes (packages)** existem justamente para isso: estruturar e agrupar classes relacionadas, facilitando manutenção, escalabilidade e legibilidade.

---

## 💻 O que são Pacotes em Java

Pacotes são **estruturas de diretórios** que organizam classes dentro de um projeto Java.

Eles funcionam como uma forma de:

* Agrupar classes com responsabilidade semelhante
* Evitar conflitos de nomes
* Organizar projetos grandes (centenas de classes)
* Melhorar manutenção e escalabilidade

📌 Em projetos reais, é comum haver dezenas de pacotes organizados por domínio ou funcionalidade.

---

## 📁 Estrutura de Projetos e Bytecode

Ao compilar um projeto Java:

* O código-fonte fica em `src/`
* O IntelliJ gera arquivos `.class` (bytecode)
* Esses arquivos são colocados na pasta de build (ex: `out/`)

Exemplo:

* `OlaDevDojo.java` → código fonte
* `OlaDevDojo.class` → bytecode compilado

---

## ⚙️ Criando e Organizando Pacotes

No IntelliJ IDEA, pacotes são criados como diretórios dentro de `src`.

### 📌 Padrão de nomenclatura de pacotes

A convenção segue:

    dominio.invertido.nomeDoProjeto.modulo

Exemplo aplicado:

    com.devdojo.maratonajava.introducao

### 🔥 Regras importantes:

* Sempre usar domínio invertido (ex: `devdojo.academy`)
* Sem espaços ou caracteres especiais
* Em minúsculo
* Estrutura hierárquica por módulos

---

## 💻 Criando Pacotes no IntelliJ IDEA

### Passos:

1. Clique com botão direito em `src`
2. Pressione `Alt + Insert`
3. Selecione **Package**
4. Informe o nome do pacote
5. Clique em Refactor

### 🔄 Refatoração

Se precisar renomear:

* Clique com botão direito no pacote
* Selecione **Refactor → Rename**
* Atalho: `Shift + F6`

---

## 📦 Estrutura gerada

Após criar o pacote:

    src/
        └── academy.devdojo.maratonaJava.introducao
    
E o IntelliJ organiza automaticamente as classes dentro dele.

---

## ☕ Movendo Classes para Pacotes

Você pode mover uma classe existente para um pacote:

* Arrastar a classe para dentro do pacote
* Ou usar Refactor (mais seguro)

Exemplo:

* Classe `OlaDevDojo.java` movida para `introducao`

---

## 📌 Importância da declaração package

Toda classe dentro de um pacote deve conter como primeira linha:

```java
    package academy.devdojo.maratonaJava.introducao;
```

---

## 🧠 Regras

* Deve ser a primeira linha não comentada do arquivo
* Define onde a classe está localizada
* É obrigatória em classes dentro de pacotes

---

## 💻 Execução do Projeto

Após alterações:

* `Ctrl + Shift + F10` → executa a aplicação
* `Ctrl + F9` → rebuild do projeto

Se necessário:

* Clique em Reload from Disk para atualizar a IDE

---

## 🧠 Como o Java interpreta pacotes

O Java usa o pacote para formar o nome completo da classe (FQCN):

    academy.devdojo.maratonaJava.introducao.OlaDevDojo

Isso evita conflitos entre classes com o mesmo nome em pacotes diferentes.

---

## ⚙️ Estrutura final do projeto

Em projetos reais:

* Cada domínio funcional vira um pacote
* O número de pacotes pode passar de dezenas
* Organização é essencial para escalabilidade

Exemplo de evolução:

* introducao
* fundamentos
* classes
* orientacao-objetos
* colecoes
* streams

---

## ⚠️ Erros comuns

* Esquecer a linha package
* Nome de pacote fora do padrão (maiúsculas, espaços)
* Mover classe sem refatoração correta
* Confundir estrutura de pastas com código-fonte

---

## 🚀 Resumo final

* Pacotes organizam classes em Java
* São representados por estrutura de diretórios
* Devem seguir padrão de domínio invertido
* Toda classe em pacote precisa declarar package
* IntelliJ automatiza a criação e organização
* Projetos reais possuem dezenas de pacotes

---