# 📘 Guia — `Scanner` em Java: Tokens e Delimitadores

Documento técnico sobre **tokenização de texto em Java**, abordando o uso de **delimitadores** com `String` e a classe utilitária `Scanner`.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Tokenização** é o processo de **dividir uma `String` em partes menores (tokens)** a partir de um ou mais **delimitadores**.  
Esses delimitadores podem ser **caracteres simples**, como vírgulas ou espaços, ou até **expressões regulares**.

Em Java, existem duas abordagens principais para lidar com tokens:

- Uso direto da classe `String`, com o método `split()`
- Uso da classe utilitária `Scanner`, que oferece **leitura sequencial e tipada**

Apesar de haver relação com **expressões regulares**, o foco aqui é a **extração e conversão de dados**, não a validação de padrões complexos.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### ✂️ Tokens e Delimitadores com `String.split()`

A forma mais direta de tokenizar texto em Java é utilizando o método:

- `String.split(regex)`

📌 Características principais:

- Recebe uma **expressão regular** como delimitador
- Retorna um **array de `String`**
- Todos os tokens são tratados como texto

✅ Exemplos de delimitadores comuns:

- `","` → vírgula
- `" "` → espaço em branco
- `"\\d"` → qualquer dígito numérico
- Qualquer padrão válido de regex

📎 Após o `split`, é comum:

- Iterar com `for-each`
- Aplicar `trim()` para remover espaços excedentes

---

### ⚠️ Limitações do `String.split()`

Mesmo que os tokens representem valores lógicos ou numéricos:

- O retorno é **sempre `String`**
- Conversões precisam ser feitas manualmente (`parseInt`, `parseBoolean`, etc.)

🚫 Isso pode gerar:

- Código mais verboso
- Maior chance de erro
- Menor clareza em dados mistos

---

### 🎯 Introdução à Classe `Scanner`

A classe `Scanner`, do pacote `java.util`, oferece uma solução **mais poderosa e flexível** para trabalhar com tokens.

✅ Vantagens principais:

- Suporte a **tipagem automática**
- Leitura sequencial por **ponteiros internos**
- Delimitadores configuráveis via regex

📌 O `Scanner` pode ser inicializado diretamente com uma `String`.

---

### 🔧 Delimitador no `Scanner`

Por padrão, o `Scanner` usa **espaços em branco** como delimitador.

Para personalizar:

- Utiliza-se `scanner.useDelimiter(regex)`

🔑 O delimitador:

- Pode ser uma vírgula
- Pode ser um número
- Pode ser qualquer expressão regular válida

Isso permite reaproveitar conhecimentos básicos de regex sem complexidade excessiva.

---

### 🔄 Iteração com `hasNext()` e `next()`

O funcionamento do `Scanner` é baseado em dois passos fundamentais:

1. Verificar se existe próximo token  
2. Consumir o token

📌 Métodos essenciais:

- `hasNext()` → verifica se ainda há tokens
- `next()` → retorna o próximo token como `String`

🔍 O `Scanner` mantém **dois ponteiros internos**:

- Um para verificação
- Outro para avanço na leitura

---

### 🧠 Leitura Tipada com `Scanner`

Um dos maiores diferenciais do `Scanner` é a leitura **já convertida para tipos primitivos**.

✅ Métodos comuns:

- `hasNextInt()` / `nextInt()`
- `hasNextBoolean()` / `nextBoolean()`

🧩 Estratégia comum:

- Verificar o tipo
- Ler como tipo específico
- Caso contrário, consumir como `String`

Isso evita parsing manual e torna o código **mais seguro e expressivo**.

---

### 🧩 Comparação Conceitual

Diferenças fundamentais entre as abordagens:

- `String.split()`
    - Simples e direto
    - Sempre retorna `String`
    - Ideal para textos homogêneos
- `Scanner`
    - Mais poderoso
    - Suporta tipos primitivos
    - Leitura controlada e sequencial
    - Ideal para dados heterogêneos

---

## 🚀 Síntese Final ✅🧠

- **Tokens** são os valores obtidos após a divisão do texto
- **Delimitadores** definem onde o texto será quebrado
- `String.split()` é rápido e simples
- `Scanner` oferece leitura sequencial e tipada
- O delimitador do `Scanner` é configurável
- `Scanner` reduz a necessidade de conversões manuais
- **Ambas as abordagens são complementares e úteis em Java**

---