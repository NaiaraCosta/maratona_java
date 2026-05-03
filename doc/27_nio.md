# 📘 Guia — Java NIO: `Path`, `Paths`, `Files` e Utilitários Avançados

Guia técnico completo sobre o pacote `java.nio.file`, abordando desde conceitos básicos até operações avançadas com arquivos, diretórios, atributos, navegação e compactação.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 O pacote **`java.nio.file`** (introduzido no `Java 7`) moderniza a API de I/O ao substituir o uso direto da classe `File` por uma abordagem mais **performática**, **segura** e **expressiva**.  
Ele separa **representação de caminho** (`Path`) de **operações** (`Files`), adiciona suporte robusto a diferentes sistemas operacionais, facilita operações complexas e promove um estilo de código mais defensivo e previsível.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 📂 `Path`, `Paths` e `Files`

- **`Path`** é uma **interface** que representa um caminho no sistema de arquivos.
- **`Paths`** é uma **classe utilitária** usada para criar instâncias de `Path`.
- **`Files`** centraliza **todas as operações** (criação, cópia, leitura, escrita, atributos).

✅ Separação clara de responsabilidade:

- **`Path` → o caminho**
- **`Files` → a ação**

Exemplo:
```java
    Path p = Paths.get("pasta", "arquivo.txt");
    Files.createFile(p);
```

---

### 🏗️ Criação de Diretórios e Arquivos

- `Files.createDirectory()` → cria **apenas um nível**
- `Files.createDirectories()` → cria **todos os níveis necessários**
- `Files.createFile()` → cria um arquivo

⚠️ Lança exceção se já existir (boa prática defensiva).

Exemplo:
```java
    if (Files.notExists(path)) {
        Files.createFile(path);
    }
```

---

### 📄 Cópia e Renomeação

- `Files.copy(source, target)`
- Opção `StandardCopyOption.REPLACE_EXISTING`

💡 Trabalha sempre com `Path`, nunca diretamente com `File`.

---

### 🧭 Normalização de Caminhos (`normalize`)

Remove elementos redundantes como `.` e `...`

Exemplo:
```java
    Path p = Paths.get("home/../home/arquivo.txt").normalize();
```

🔎 **Normalizar não garante existência**, apenas ajusta o caminho lógico.

---

### 🔗 Resolução de Caminhos (`resolve`)

Combina caminhos:

- Absoluto + Relativo ✅
- Relativo + Absoluto ❌ (retorna o absoluto)

Exemplo:
```java
    base.resolve("arquivo.txt");
```

⚠️ **Ambos devem ser absolutos ou relativos**, caso contrário lança exceção.

---

### 🧬 Atributos de Arquivos (`BasicFileAttributes`)

Interfaces de leitura:

- `BasicFileAttributes`
- `DosFileAttributes`
- `PosixFileAttributes`

Leitura via:

```java
    BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
```

Inclui:

- `creationTime`
- `lastModifiedTime`
- `lastAccessTime`

---

### ✏️ Alteração de Atributos (`FileAttributeView`)

Classes que **terminam** com `View` permitem alteração.

Exemplo:
```java
    BasicFileAttributeView view =Files.getFileAttributeView(path, BasicFileAttributeView.class);
    view.setTimes(null, FileTime.fromMillis(System.currentTimeMillis()), null);
```

---

### 🪟 DosFileAttributes (Windows)

Permite manipular:

- Arquivo oculto
- Read-only

Exemplo:
```java
    Files.setAttribute(path, "dos:hidden", true);
```

Ou via `DosFileAttributeView`.

---

### 🐧 PosixFileAttributes (Unix/Linux)

Trabalha com permissões (`rwx`).

Exemplo:
```java
    Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-xr--");
```

⚠️ Não suportado no Windows.

---

### 📁 Listagem com `DirectoryStream`

Lista apenas o primeiro nível do diretório.

Exemplo:
```java
    try (DirectoryStream<Path> stream =
        Files.newDirectoryStream(Paths.get("."))) {
        for (Path p : stream) {
        System.out.println(p.getFileName());
        }
        }
```

---

### 🌲 Navegação Recursiva — `SimpleFileVisitor`

Utilizado em conjunto com **`Files.walkFileTree`** para percorrer diretórios de forma **recursiva**.

📌 **Métodos principais sobrescrevíveis**:
- `preVisitDirectory`
- `visitFile`
- `visitFileFailed`
- `postVisitDirectory`

✅ **Permite implementar**:
- ✅ **Busca** de arquivos
- ✅ **Cópia** recursiva
- ✅ **Filtros** personalizados
- ✅ **Limpeza** de diretórios
- ✅ **Inspeção profunda** da árvore de arquivos

---

### 🎯 Filtros Avançados — `PathMatcher`

Utiliza padrões `glob:` ou `regex:` para **comparação de caminhos** de forma declarativa.

```java
    PathMatcher matcher = FileSystems.getDefault()
    .getPathMatcher("glob:**/*.{java,class}");
```

💡 Extremamente útil quando combinado 
com `SimpleFileVisitor` para filtrar arquivos durante a navegação.

---

### 🗜️ Compactação — `ZipOutputStream`

Permite a **criação manual** de arquivos `.zip` usando streams.

📄 Fluxo básico:

1. Criar `ZipEntry`
2. Chamar `putNextEntry`
3. Copiar conteúdo com `Files.copy`
4. Finalizar com `closeEntry`

```java
    zip.putNextEntry(new ZipEntry(file.getFileName().toString()));
    Files.copy(file, zip);
    zip.closeEntry();
```

---

## 🚀 Síntese Final ✅🧠

- `Path` substitui File como representação de caminho
- `Files` centraliza operações com o sistema de arquivos
- Normalizar, resolver e relativizar evitam bugs sutis
- Atributos são lidos por interfaces e alterados via `View`
- `DirectoryStream` lista apenas um nível
- `SimpleFileVisitor` permite navegação recursiva
- `PathMatcher` simplifica filtros complexos
- `ZipOutputStream` permite compactação manual e controlada 

--- 