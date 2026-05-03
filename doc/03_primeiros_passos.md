# 📘 Guia — Instalação, Configuração e Primeiros Passos com Java (`JDK` 15 + `IntelliJ IDEA`)

Documento técnico introdutório cobrindo **instalação do Java**, **configuração de ambiente**, **compilação manual**, **uso de IDE**, **organização com pacotes** e **comentários em código Java**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Java** é uma linguagem de programação de **alto nível**, projetada para ser **portável**, **padronizada** e **independente de plataforma**. O fluxo clássico envolve a escrita de arquivos `*.java`, compilação via `javac` gerando `*.class` (**`bytecode`**) e execução pela **`JVM`** (*Java Virtual Machine*).  
A partir do **Java 9**, o ciclo de releases passou a ser **semestral**, com versões **`LTS`** (*Long Term Support*) sendo as mais adotadas por empresas. Neste guia, usamos o **`JDK 15`** para aprendizado e exploramos desde a linha de comando até o uso do **`IntelliJ IDEA Community`**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### ☕ Conceitos Fundamentais do Java

- **Arquivos `*.java`** → código-fonte legível por humanos.
- **Compilador `javac`** → transforma o código em **`bytecode`** (`*.class`).
- **`JVM`** → executa o `bytecode`, adaptando para o **sistema operacional**.
- Linguagens de **alto nível** priorizam legibilidade.
- Linguagens de **baixo nível** (ex: `assembly`) priorizam performance.

✨ **Java equilibra legibilidade, performance e portabilidade.**

---

### 🕰️ Versionamento e Estratégia de Releases

- Até o **`Java 8`**, releases eram lentos e espaçados.
- A partir do **`Java 9`**, releases a cada **6 meses**.
- **Versões `LTS`**:
  - `Java 8` → amplamente usado (legado).
  - `Java 11` → **LTS atual (à época)**.
  - `Java 17` → próximo **LTS**.
- Versões intermediárias (`12`–`16`) servem para **testar novas features**.

✅ **Empresas priorizam estabilidade → usam `LTS`.**

---

### 📦 Download e Instalação do `JDK`

- O **`JDK`** inclui:
  - **`JRE`** (*Java Runtime Environment*)
  - **Compilador `javac`**
  - Ferramentas (`java`, `javadoc`, etc.)
- Distribuições:
  - **`Oracle JDK`**
  - **`OpenJDK`**
- Cada **sistema operacional** possui uma build específica (`Windows`, `Linux`, `macOS`).
- Exemplo:
  - `Windows x64 Installer`
  - Instalação padrão em:  
    `C:\Program Files\Java\jdk-15`

---

### ⚙️ Configurando Variáveis de Ambiente

📌 Objetivo: permitir que **qualquer aplicação** encontre o Java.

#### Variável `JAVA_HOME`

- Aponta para a **raiz do JDK**  
Exemplo:
```text
    JAVA_HOME=C:\Program Files\Java\jdk-15
```

#### Variável `PATH`
- Adicionar:
```text
    %JAVA_HOME%\bin
````
🚫 **Erro comum**:
- Colocar `\bin` no `JAVA_HOME` **e também** no `PATH` → caminho inválido.

✅ Após configurar:
- Reabrir o terminal.
- Testar:
- `java -version`
- `javac -version`

---

### 🧪 Compilação Manual com Terminal

Exemplo: 
```text
    OlaDevDojo.java
```

**Regras essenciais**:

- Nome da **`public class`** = nome do arquivo.
- Sensível a **maiúsculas/minúsculas**.
- Método principal:
```java
    public static void main(String[] args)
```

#### Passo a passo:

1. Navegar até a pasta do arquivo:
Exemplo:
```bash
  cd Dev
```

2. Compilar:
Exemplo:
```bash
  javac OlaDevDojo.java
```

3. Executar:
Exemplo:
```bash
  OlaDevDojo.java
```

📌 Sempre **recompilar** após modificar o .java.

---

### 🧠 Uso de IDE — IntelliJ IDEA Community

- IDE moderna e amplamente utilizada no mercado.
- **Autocomplete, análise em tempo real, atalhos, build automático**.
- Detecta o `JAVA_HOME` automaticamente.
- Criação de projeto:
  - Tipo: Java
    - SDK: JDK 15

🎯 Benefício principal: **foco total no códig**o, não na infraestrutura.

---

### 🗂️ Organização de Código com Pacotes

- Pacotes = **estrutura de diretórios**.

Convenção:
```text
    dominio.invertido.projeto.modulo
```

Exemplo:
```text
    academy.devdojo.maratonajava.introducao
```

📌 **Toda classe em pacote deve iniciar com**:
```java
    package academy.devdojo.maratonajava.introducao;
```

✅ Benefícios:

- Organização
- Isolamento
- Escalabilidade
- Evita conflitos de nomes

---

### 💬 Comentários em Java

#### Tipos existentes:

1. Comentário de linha
```java
    // comentário
```

2. Comentário de múltiplas linhas
```java
    /* comentário */
```

3. JavaDoc (OFICIAL)
```java
    /**
     * comentário
     */
```

🚨 **Boas práticas:**

- Evitar comentários redundantes.
- Código deve ser **autoexplicativo**.
- Usar JavaDoc em:
  - Classes públicas
  - Métodos públicos
- Essencial para **documentação de API**s.

📖 IDE permite visualizar documentação via atalhos (**Ctrl + clique**).

---

## 🚀 Síntese Final ✅🧠

- Java compila `*.java` em `*.class` usando `javac`.
- A `JVM` executa o `bytecode` de forma portável.
- Versões `LTS` são padrão no mercado.
- `JAVA_HOME` e `PATH` são essenciais para funcionamento global.
- Compilação manual ajuda a entender o fluxo real.
- IDEs como `IntelliJ IDEA` aumentam produtividade.
- Pacotes organizam grandes bases de código.
- Comentários devem ser **mínimos e intencionais**.
- `JavaDoc` é o padrão profissional de documentação.

---