# 📘 Guia — Regex em Java com `Pattern` e `Matcher`

Guia técnico e progressivo sobre **expressões regulares em Java**, focado no uso prático das classes `Pattern` e `Matcher`.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Expressões regulares** são uma **linguagem especializada para busca e validação de padrões em texto**, amplamente usada para **extração**, **validação** e **análise sintática**.  
Em Java, o trabalho com regex gira principalmente em torno de duas classes do pacote `java.util.regex`:
- `Pattern` → **representa e compila a expressão regular**
- `Matcher` → **aplica o padrão sobre um texto**

Mesmo desenvolvedores experientes recorrem com frequência a documentação e ferramentas externas, pois regex exige **atenção extrema à sintaxe e ao comportamento dos metacaracteres**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Classes Fundamentais: `Pattern` e `Matcher`

Para trabalhar com regex em Java, o fluxo é sempre:

- Compilar a expressão com `Pattern.compile(...)`
- Aplicar o padrão sobre um texto usando `pattern.matcher(texto)`
- Percorrer as ocorrências com `matcher.find()`

🔑 **Conceito-chave**: o `Matcher` **varre o texto da esquerda para a direita**, avançando o índice após cada correspondência encontrada.

📌 Métodos essenciais:
- `matcher.start()` → posição inicial do match
- `matcher.group()` → valor encontrado

---

### 🔠 Metacaracteres Básicos

Metacaracteres funcionam como **atalhos semânticos** para conjuntos de caracteres.

Principais exemplos:

- `\\d` → **dígitos (`0–9`)**
- `\\D` → **não-dígitos**
- `\\s` → **espaços em branco** (`space`, `tab`, `newline`)
- `\\S` → **não-espaços**
- `\\w` → **letras, dígitos e `_`**
- `\\W` → **negação de `\\w`**

⚠️ Em Java, **`\` precisa ser escapado**, portanto regex usa `\\`.

---

### 📏 Range (Intervalos)

Ranges permitem definir **conjuntos personalizados** com colchetes `[]`.

Exemplos:
- `[ABC]` → **A ou B ou C**
- `[A-Z]` → **letras maiúsculas**
- `[a-fA-F0-9]` → **hexadecimal**

✅ Facilita regras como **restrição de valores válidos** sem repetir caracteres.

---

### 🔢 Quantificadores

Quantificadores dizem **quantas vezes** um padrão pode aparecer:

- `?` → **0 ou 1**
- `*` → **0 ou mais**
- `+` → **1 ou mais**
- `{n}` → exatamente `n`
- `{n,m}` → de `n` até `m`

📌 Sem quantificadores, o Java assume **1 ocorrência por padrão**.

---

### 🧠 Agrupamento, Alternância e Delimitadores

Ferramentas que aumentam muito o poder da regex:

- `( )` → **agrupamento**
- `|` → **OU lógico**
- `$` → **fim da linha**
- `^` → **início da linha**

💡 Essenciais para **validações corretas**, evitando matches parciais incorretos.

---

### 🔐 Validação de Hexadecimal

Regra típica:
- Deve começar com `0x` ou `0X`
- Seguido por **1 ou mais** caracteres `[0-9a-fA-F]`

Regex conceitual:
- início obrigatório
- agrupamentos
- quantificadores
- delimitadores de fim

✅ Sem quantificadores corretos, apenas **parte do valor** é capturada.

---

### 📧 Regex para E-mails (Busca vs Validação)

Buscar e validar são problemas diferentes:

- `Matcher.find()` → **encontra padrões dentro de textos**
- `String.matches()` → **valida a string inteira**

📌 Elementos levados em conta:
- Nome: letras, números, `_`, `-`, `.`
- Literal `@`
- Domínio com repetições: `.com`, `.br`, `.org`, etc.

⚠️ Regex **não valida existência real de domínio**, apenas **forma sintática**.

---

### 🧭 Âncoras e Negação

Dois usos distintos do caractere `^`:

1️⃣ **Âncora de início de linha**
- Ex: `^\\w+` → primeira palavra da linha

2️⃣ **Negação em range**
- Ex: `[^ABC]` → tudo que **não** seja A, B ou C

📌 Negação **é case-sensitive**.

---

### 🛠 Ferramentas de Apoio

💻 Sites interativos de regex ajudam a:
- Visualizar cada parte da expressão
- Depurar padrões complexos
- Entender quantificadores e âncoras em tempo real

✅ Uso recomendado antes de implementar diretamente no Java.

---

## 🚀 Síntese Final ✅🧠

- **Regex é poderosa, mas exige prática constante**
- `Pattern` compila, `Matcher` executa
- Metacaracteres simplificam buscas complexas
- Quantificadores controlam repetição
- Ranges evitam redundância
- Delimitadores evitam matches incorretos
- Buscar ≠ Validar (`find` vs `matches`)
- Ferramentas visuais facilitam o aprendizado

---