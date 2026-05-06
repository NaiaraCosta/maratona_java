# 📘 Guia — Instalação, Configuração e Primeiros Passos com Java (`JDK` 15 + `IntelliJ IDEA`)

Documento técnico introdutório cobrindo **instalação do Java**, **configuração de ambiente**, **compilação manual**, **uso de IDE**, **organização com pacotes** e **comentários em código Java**, com foco didático e progressivo para iniciantes.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Java** é uma linguagem de programação de **alto nível**, projetada desde sua origem para ser **portável**, **padronizada** e **independente de plataforma**.  
O fluxo clássico de desenvolvimento em Java envolve:

- Escrita de arquivos `*.java` (código-fonte),
- Compilação com o compilador `javac`, gerando arquivos `*.class`,
- Execução desses arquivos pela **`JVM`** (*Java Virtual Machine*), responsável por adaptar o programa ao sistema operacional.

Esses arquivos `*.class` contêm **`bytecode`**, um formato intermediário que não depende diretamente do hardware.

A partir do **Java 9**, o Java passou a adotar um ciclo de releases **semestral**, com versões **`LTS`** (*Long Term Support*) sendo as mais utilizadas em ambientes corporativos devido à sua estabilidade e suporte prolongado.  
Neste guia, utilizamos o **`JDK 15`** como base para aprendizado, explorando desde a linha de comando até o uso da IDE **`IntelliJ IDEA Community`**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### ☕ Conceitos Fundamentais do Java

- **Arquivos `*.java`**  
  Contêm o código-fonte escrito pelo desenvolvedor, legível por humanos.

- **Compilador `javac`**  
  Analisa o código-fonte, verifica erros de sintaxe e converte o conteúdo em **`bytecode`** (`*.class`).

- **Arquivos `*.class` (bytecode)**  
  Código intermediário padronizado, independente de sistema operacional.

- **`JVM`** (*Java Virtual Machine*)  
  Ambiente responsável por carregar o bytecode, gerenciar memória, executar instruções e converter o código para instruções nativas do sistema.

- Linguagens de **alto nível** priorizam clareza, abstração e produtividade.
- Linguagens de **baixo nível** (como `assembly`) priorizam controle direto do hardware e performance máxima, com menor abstração.

✨ **Java busca equilibrar legibilidade, performance e portabilidade**, abstraindo detalhes de hardware sem abrir mão de eficiência em execução.

---

### 🕰️ Versionamento e Estratégia de Releases

- Até o **`Java 8`**, os lançamentos eram esporádicos e pouco previsíveis.
- A partir do **`Java 9`**, passou-se a adotar um **ciclo fixo de 6 meses**.
- **Versões `LTS` (Long Term Support)** recebem suporte estendido, correções de segurança e são preferidas em produção:
  - `Java 8` → amplamente utilizado em sistemas legados.
  - `Java 11` → **LTS consolidado** por muitos anos.
  - `Java 17` → LTS atual amplamente adotado hoje.
- Versões intermediárias (`12` a `16`) têm vida curta e servem principalmente para:
  - Introduzir novas funcionalidades,
  - Permitir testes e feedback da comunidade.

✅ **Empresas priorizam estabilidade, previsibilidade e compatibilidade**, por isso adotam versões `LTS`.

---

### 📦 Download e Instalação do `JDK`

- O **`JDK`** (*Java Development Kit*) inclui:
  - **`JRE`** (*Java Runtime Environment*),
  - Compilador `javac`,
  - Ferramentas como `java`, `javadoc`, `jshell`, entre outras.

- Principais distribuições:
  - **`Oracle JDK`** (oficial da Oracle),
  - **`OpenJDK`** (implementação aberta, base da maioria das distribuições).

- Cada **sistema operacional** exige uma versão específica:
  - `Windows`
  - `Linux`
  - `macOS`

Exemplo de instalação no Windows:
```bash
    C:\Program Files\Java\jdk-15
```

📌 O diretório raiz do JDK será utilizado na configuração de ambiente.

---

### ⚙️ Configurando Variáveis de Ambiente

📌 **Objetivo:** permitir que o sistema operacional e outras aplicações encontrem o Java a partir de qualquer terminal.

#### Variável `JAVA_HOME`

- Deve apontar para a **pasta raiz do** `JDK` **instalado**.

Exemplo:
```bash
    JAVA_HOME=C:\Program Files\Java\jdk-15
```

#### Variável `PATH`

- Deve incluir o diretório `bin` do `JDK` para permitir a execução dos comandos `java` e `javac` em qualquer local.

Exemplo:
```bash
    JAVA_HOME=C:\Program Files\Java\jdk-15
```

---

### ⚙️ Configurando Variáveis de Ambiente

📌 **Objetivo:** permitir que o sistema operacional e outras aplicações encontrem o Java a partir de qualquer terminal.

#### Variável `JAVA_HOME`

- Deve apontar para a **pasta raiz do JDK instalado**.

Exemplo:
```bash
    JAVA_HOME=C:\Program Files\Java\jdk-15
```

#### Variável `PATH`

- Deve incluir o diretório `bin` do `JDK` para permitir a execução dos comandos `java` e `javac` em qualquer local.

Exemplo:
```bash
    %JAVA_HOME%\bin
```

🚫 Erro comum:

- Definir `JAVA_HOME` já apontando para \bin e ainda assim adicionar `\bin` no `PATH`.

✅ Após a configuração:

- Feche e reabra o terminal.
- Verifique:

Exemplo:
```bash
    java -version
    javac -version
```

Esses comandos confirmam que o Java está corretamente acessível globalmente.

---

### 🧪 Compilação Manual com Terminal

- Criação do arquivo `.java`

Exemplo:
```text
    OlaDevDojo.java
```

**Regras essenciais do Java:**

- O nome da `public class` deve ser exatamente igual ao nome do arquivo.
- O Java é `case-sensitive` (diferencia maiúsculas de minúsculas).
- Toda aplicação Java inicia pelo método:
```java
    public static void main(String[] args)
```

#### Passo a passo

1. Acessar o diretório do arquivo:

Exemplo:
```bash
    cd Dev
```

2. Compilar o código-fonte:

Exemplo:
```bash
    javac OlaDevDojo.java
```

3. Executar o programa compilado:

Exemplo:
```bash
    java OlaDevDojo
```

📌 Observação importante:

- O comando java usa **o nome da classe**, não o nome do arquivo .java.
- Sempre é necessário **recompilar** após qualquer alteração no código.

---

### 🧠 Uso de IDE — IntelliJ IDEA Community

- IDE moderna, amplamente utilizada no mercado profissional.
- Oferece:
  - Autocomplete inteligente,
  - Análise de erros em tempo real,
  - Refatoração automática,
  - Gerenciamento de projetos e dependências.
- Detecta automaticamente o `JAVA_HOME`.
- Criação de projeto:
  - Tipo: Java
  - `SDK`: `JDK 15`

🎯 Benefício central: **foco total no código e na lógica**, reduzindo erros manuais e trabalho repetitivo de configuração.

---

### 🗂️ Organização de Código com Pacotes

- **Pacotes** representam uma estrutura lógica e física de diretórios.
- Facilitam organização, manutenção e escalabilidade.

Convenção padrão:
```java
    dominio.invertido.projeto.modulo
```

Exemplo:
```java
    academy.devdojo.maratonajava.introducao
```

📌 Toda classe dentro de um pacote deve iniciar com:
```java
    package academy.devdojo.maratonajava.introducao;
```

✅ Vantagens dos pacotes:

- Organização clara do projeto,
- Isolamento lógico de responsabilidades,
- Evita conflitos entre classes com o mesmo nome,
- Facilita trabalho em equipes grandes.

---

### 💬 Comentários em Java

#### Tipos existentes:

1. Comentário de linha

Exemplo:
```java
    // comentário
```

2. Comentário de múltiplas linhas

Exemplo:
```java
    /* comentário */
```

3. JavaDoc (padrão oficial)

Exemplo:
```java
    /**
     * comentário
     */
```

#### 🚨 Boas práticas

- Evitar comentários óbvios ou redundantes.
- Priorizar código claro e bem nomeado.
- Usar `JavaDoc` em:
  - Classes públicas,
  - Métodos públicos,
  - APIs reutilizáveis.

#### 📖 Comentários JavaDoc podem ser

- Gerados em HTML (`javadoc`),
- Visualizados diretamente na IDE por meio de atalhos, como **Ctrl + clique**.

---

## 🚀 Síntese Final ✅🧠

- Java transforma código `*.java` em `*.class` usando o compilador `javac`.
- A `JVM` executa o `bytecode`, garantindo portabilidade entre sistemas.
- Versões `LTS` são a preferência no mercado profissional.
- `JAVA_HOME` e `PATH` são fundamentais para o uso global do Java.
- A compilação manual ajuda a entender o fluxo real da linguagem.
- IDEs como o `IntelliJ IDEA` aumentam a produtividade e reduzem erros.
- Pacotes são essenciais para a organização de projetos.
- Comentários devem ser **intencionais, úteis e não redundantes**.
- `JavaDoc` é o padrão profissional para documentação de código Java.

---