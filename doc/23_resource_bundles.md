# 📘 Guia — Internacionalização de Mensagens com `ResourceBundle`

Documento técnico focado em **internacionalização (i18n) de mensagens no backend Java** utilizando `ResourceBundle`, com suporte a múltiplos idiomas, países e estratégia de *fallback*.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **`ResourceBundle` é o mecanismo padrão do Java para internacionalizar textos** — mensagens, labels, erros e qualquer conteúdo textual exibido ao usuário.

Ele **não traduz conteúdo automaticamente**.  
O que ele faz é **selecionar o texto correto com base no `Locale` ativo**, carregando valores de arquivos `.properties` organizados por idioma e país.

📦 Muito usado em:
- Aplicações `backend`
- `APIs`
- Sistemas corporativos
- Sites multilíngues (ex: Amazon, e-commerces globais)

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🌍 O Problema que o `ResourceBundle` resolve

Imagine um sistema com múltiplos idiomas:

- 🇧🇷 Português
- 🇺🇸 Inglês
- 🇳🇱 Holandês

Você **não pode** deixar textos fixos no código.

✅ Solução: **Externalizar mensagens** e carregá-las conforme o `Locale` do usuário.

---

### 📦 O que é `ResourceBundle`

`ResourceBundle` (`java.util.ResourceBundle`) é uma **classe utilitária** que:

- Carrega arquivos de mensagens
- Seleciona o arquivo correto com base no `Locale`
- Fornece textos via **chave → valor**
- Implementa automaticamente uma estratégia de **fallback**

---

### 🗂️ Estrutura de Arquivos `.properties`

Os arquivos **devem ficar no diretório `resources` (source root)**.

📌 Formato:
```properties
    nomeBase_language_COUNTRY.properties
```

Exemplos:
```properties
    - `messages_en_US.properties`
    - `messages_pt_BR.properties`
    - `messages_nl_NL.properties`

Arquivo base (fallback final):
    - `messages.properties`
```

---

### 🧾 Sintaxe dos arquivos `.properties`

✅ Estrutura **chave = valor**

Exemplo:
```properties
  hello=Hello
  good.morning=Good Morning
```

📌 Comentários:

- `#` comentário
- `!` comentário

⚠️ Chaves devem ser idênticas em todos os arquivos.

⚠️ **Chaves devem ser idênticas em todos os arquivos.**

---

### 🌐 Obtendo o `Locale`

O `Locale` define **idioma + país**.

Exemplos:

- `Locale.getDefault()`
- `new Locale("en", "US")`
- `new Locale("pt", "BR")`

📌 Geralmente:
- 
- Obtido do navegador
- Configuração do usuário
- `Header HTTP` (Accept-Language)

Exemplo:
```java
    ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
```

- `"messages"` → **nome base do arquivo**
- `locale` → idioma e país desejados

📌 O Java escolhe o arquivo automaticamente.

---

### 📖 Obtendo Mensagens

Para recuperar valores:

Exemplo:
```java
    bundle.getString("hello");
    bundle.getString("good.morning");
```
✅ Retorna o valor correspondente ao `Locale`.

⚠️ **Se a chave não existir**, lança `MissingResourceException`.

---

### 🔁 Estratégia de Fallback 🎯

O Java segue uma ordem bem definida:

Exemplo: Locale("fr", "CA")

1. `messages_fr_CA.properties`
2. `messages_fr.properties`
3. `messages_en_US.properties` (default da JVM)
4. `messages_en.properties`
5. `messages.properties`
6. ❌ Exceção se nenhum existir

📌 **Boa prática:** sempre criar o arquivo base.

Exemplo:
```text
    messages.properties
```

---

### ✅ Quando usar o arquivo base (messages.properties)

Ideal para **textos iguais em todos os idiomas**.

Exemplo:
```properties
    app.name=My Application
    error.unexpected=Unexpected error
```

✅ Evita duplicação
✅ Reduz manutenção
✅ Garante fallback seguro

---

### 🔄 Alterando Idioma em Tempo de Execução

Basta trocar o Locale:

Exemplo:
```java
    Locale locale = new Locale("pt", "BR");
    ResourceBundle bundle =
    ResourceBundle.getBundle("messages", locale);
```

📌 **Todo o sistema passa a usar outro idioma sem recompilar**

A simples troca do `Locale` faz com que o `ResourceBundle` carregue **automaticamente** 
os textos do idioma correspondente, **sem necessidade de recompilação** da aplicação.

---

## 🚫 O que `ResourceBundle` **NÃO** faz

❌ **Não traduz textos automaticamente**  
❌ **Não resolve pluralização de forma inteligente**  
❌ **Não detecta o idioma sozinho**  
❌ **Não substitui ferramentas de tradução**

✅ **Ele apenas seleciona o texto correto com base em regras**, utilizando:

- Chaves
- Arquivos `.properties`
- `Locale`

---

## 🧠 Boas Práticas ✅

- **Centralizar todas as mensagens** (nunca hardcode no código-fonte)  
- **Usar chaves claras e padronizadas**, ex: `login.error.invalid`  
- **Sempre criar** o arquivo base `messages.properties`  
- **Definir o `Locale` explicitamente no backend**  
- **Combinar com `MessageFormat`** para mensagens com parâmetros  
- **Versionar arquivos de mensagens** junto ao código

---

## 🚀 Síntese Final ✅🧠

- `ResourceBundle` é o **padrão Java para i18n**  
- Usa arquivos `.properties`  
- Seleciona mensagens automaticamente pelo `Locale`  
- Possui estratégia de `fallback` robusta  
- Ideal para mensagens, labels e erros  
- **Não traduz — apenas resolve textos**

---