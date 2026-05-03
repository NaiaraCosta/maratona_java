# 📘 Guia — Exceções em Java: `Error`, `Exception`, `RuntimeException` e Boas Práticas

Documento técnico consolidado sobre **exceções em Java**, cobrindo desde **`Error`** até **exceções customizadas**, incluindo **regras de sobrescrita**, **`try-catch-finally`**, **`try-with-resources`** e **multi-catch**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 Em Java, **exceções representam fluxos anormais** que interrompem o caminho ideal de execução do programa. Nem todas são previsíveis ou controláveis. Algumas **podem (e devem) ser tratadas**, enquanto outras **indicam falhas graves da JVM**.

🔹 **Tudo em Java é objeto**, inclusive exceções  
🔹 Todas derivam de `Throwable`  
🔹 Existem diferenças fundamentais entre **`Error`**, **`Exception`**, **`RuntimeException`**  
🔹 Tratar exceções corretamente é **obrigação profissional**

---

## 🧩 Blocos Semânticos 🧠🔎

### 🚨 Errors — Situações Irrecuperáveis

**`Error`** representa falhas **graves da JVM**, normalmente **irreversíveis em tempo de execução**.

📌 Exemplos comuns:
- **`OutOfMemoryError`**
- **`StackOverflowError`**

✅ Características:
- São filhas de `Throwable`
- **Não devem ser tratadas**
- Exigem **correção do código ou ambiente** e nova execução

🔥 **`StackOverflowError`** ocorre quando:
- Há **recursividade sem condição de parada**
- A **stack de chamadas** excede o limite de memória

👉 Solução: corrigir o algoritmo (ex: parar recursão)

---

### ⚠️ Estrutura da Hierarquia de Exceções

```text
  Throwable
   ├── Error
   └── Exception
        ├── RuntimeException (unchecked)
        └── Checked Exceptions
```

📌 **Tudo que NÃO é RuntimeException é checked**

---

### 🚀 RuntimeException — Exceções Unchecked

Exceções **não obrigatórias de tratamento** em tempo de compilação.

📌 Características:

- Herdeiras de `RuntimeException`
- Geralmente indicam **erro do desenvolvedor**
- O código **compila mesmo sem tratamento**

📛 Exemplos:

- `NullPointerException`
- `ArithmeticException`
- `ClassCastException`
- `ArrayIndexOutOfBoundsException`
- `IllegalArgumentException`

💡 **Quando acontecem**, 99% das vezes: **O código está errado**

---

### ✅ Checked Exceptions — Tratamento Obrigatório

Exceções que **o compilador exige tratamento**.

📌 Características:

- Filhas diretas de `Exception`
- Devem ser:
  - Tratadas com `try-catch`
  - Ou declaradas com `throws`

📛 Exemplos:

- `IOException`
- `FileNotFoundException`
- `SQLException`

💥 **Sem tratamento ➜ código não compila**

---

### 🧯 try-catch — Tratamento de Exceções

Exemplo:
```java
    try {
            // código que pode falhar
            } catch (Exception e) {
            e.printStackTrace();
    }
```

✅ Boas práticas:

- **Nunca** deixar `catch` vazio ❌
- Evitar **lógica de negócio dentro do** `catch`
- Tratar exceções **mais específicas primeiro**

📎 e.printStackTrace():

- **Mostra toda a stack de chamadas**
- Ferramenta essencial para **debug**

---

### 🔁 Lançando Exceções (throw)

✅ Para validar regras de negócio:

Exemplo:
```java
    if (b == 0) {
        throw new IllegalArgumentException("Argumento não pode ser zero");
    }
```

📌 Use quando:

O estado do método é inválido
Não faz sentido continuar a execução

🔎 `IllegalArgumentException`:

- Filha de `RuntimeException`
- Sem obrigação de `throws`

---

### 📦 throws — Propagando a Exceção

Exemplo:
```java
    if (b == 0) {
        throw new IllegalArgumentException("Argumento não pode ser zero");
    }
```

📌 Usado quando:

- O método **não deve decidir** como tratar
- A responsabilidade é do **método chamador**

⚠️ Para exceções checked **é obrigatório**

---

### 🔄 Capturar e Relançar Exceções

Exemplo:
```java
    catch (IOException e) {
            e.printStackTrace();
        throw e;
    }
```

📌 Útil quando:

- Você quer **logar**
- Mas deixar a decisão para outro nível

✅ Também é comum relançar como `RuntimeException`:

Exemplo:
```java
    throw new RuntimeException("Erro ao criar arquivo", e);
```

---

### 🔚 finally — Execução Garantida

Exemplo:
```java
    try {
        abrirRecurso();
    } finally {
        fecharRecurso();
    }
```

✅ Sempre executado:

- Com ou sem exceção
- Mesmo com `return`
- 
📌 Principal uso:

- **Liberar recursos externos**
 - Arquivos
 - Conexões
 - Streams

---

### ♻️ try-with-resources — Forma Moderna ✅

Exemplo:
```java
    try (Reader reader = new FileReader("arquivo.txt")) {
        // uso do recurso
    }
```

✅ Vantagens:

- Fecha automaticamente
- Código mais limpo
- Menos chance de vazamento

📌 Requisitos:

- Classe deve implementar `AutoCloseable` ou `Closeable`

📎 Recursos são fechados em **ordem inversa**

---

### 🔀 Múltiplos catch — Ordem Importa

Exemplo:
```java
    try {
        // código
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
    } catch (Exception e) {
    }
```

⚠️ Regra crítica:

- **Mais genéricas sempre por último**

---

### 🧵 Multi-catch (Java 7+)

Exemplo:
```java
    catch (IOException | SQLException e) {
        e.printStackTrace();
    }
```

✅ Útil quando:

- Tratamento é o mesmo
- **Exceções não são da mesma herança**

⚠️ A variável e se torna `final`

---

### 🧩 Exceções Customizadas

Exemplo:
```java
    public class LoginInvalidoException extends Exception {
        public LoginInvalidoException(String msg) {
            super(msg);
        }
    }
```

📌 Decisão importante:

- `extends` `Exception ➜ checked`
- `extends` `RuntimeException ➜ unchecked`

✅ Use para:

- Regras de negócio específicas
- Clareza semântica
- Código profissional

---

### 🧬 Exceções e Sobrescrita (@Override)

📌 Regras fundamentais:

- Não é obrigatório declarar exceções
- Pode declarar:
  - Menos exceções
  - Exceções mais específicas
  - Exceções Runtime
- ❌ Não pode:
  - Declarar exceções mais genéricas
  - Adicionar novas checked não declaradas

---

## 🚀 Síntese Final ✅🧠

- **Error não se trata**
- `RuntimeException` **→ erro de código**
- `Checked` exige `try-catch` ou `throws`
- **Nunca ignore exceções**
- **Use** `try-with-resources` **sempre que possível**
- **Leia stack traces**
- **Seja explícito e consistente**
- **Exceções bem usadas salvam sistemas**

---