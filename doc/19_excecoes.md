# 📘 Guia — Exceções em Java: `Error`, `Exception`, `RuntimeException` e Boas Práticas

Documento técnico consolidado sobre **exceções em Java**, cobrindo desde **`Error`** até **exceções customizadas**, incluindo **regras de sobrescrita**, **`try-catch-finally`**, **`try-with-resources`** e **multi-catch**, com foco em compreensão conceitual, uso correto e boas práticas profissionais.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 Em Java, **exceções representam fluxos anormais de execução** — situações em que o programa **não consegue seguir o caminho normal previsto**. Nem toda falha é igual: algumas **podem e devem ser tratadas**, enquanto outras **indicam problemas graves no ambiente de execução da JVM**.

Pontos fundamentais:

🔹 **Tudo em Java é objeto**, inclusive exceções  
🔹 Todas as exceções derivam direta ou indiretamente de `Throwable`  
🔹 Existem diferenças fundamentais entre **`Error`**, **`Exception`** e **`RuntimeException`**  
🔹 Tratar exceções corretamente não é opcional — é **obrigação profissional**

📌 O uso adequado de exceções melhora:
- Confiabilidade
- Legibilidade
- Manutenibilidade
- Diagnóstico de falhas em produção

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🚨 Errors — Situações Irrecuperáveis

A classe **`Error`** representa falhas **graves da JVM**, geralmente **não recuperáveis em tempo de execução**.

📌 Exemplos comuns:

- **`OutOfMemoryError`** — falta de memória no heap
- **`StackOverflowError`** — estouro da pilha de chamadas

✅ Características principais:

- São filhas diretas de `Throwable`
- **Não devem ser tratadas com `try-catch`**
- Indicam a necessidade de:
  - Correção do código
  - Ajuste de configuração
  - Nova execução da aplicação

🔥 **`StackOverflowError`** ocorre quando:
- Existe **recursividade infinita**
- Falta uma **condição de parada**
- A **stack de chamadas** ultrapassa o limite disponível da JVM

👉 Solução sempre envolve **corrigir o algoritmo**, nunca capturar o erro.

#### ⚠️ Estrutura da Hierarquia de Exceções

```text
    Throwable
     ├── Error
     └── Exception
          ├── RuntimeException (unchecked)
          └── Checked Exceptions
```

📌 Regra fundamental: **Tudo que não herda de** `RuntimeException` é `checked exception`

Essa hierarquia define:

- O que o compilador **exige tratamento**
- O que é responsabilidade **exclusiva do desenvolvedor corrigir**

##### 🚀 RuntimeException — Exceções Unchecked

Exceções `unchecked` são aquelas que **não exigem tratamento obrigatório** em tempo de compilação

📌 Características:

- Herdam de `RuntimeException`
- Associadas, quase sempre, a **erros de programação**
- O código **compila mesmo sem** `try-catch` **ou** `throws`

Exemplos comuns:

- `NullPointerException`
- `ArithmeticException`
- `ClassCastException`
- `ArrayIndexOutOfBoundsException`
- `IllegalArgumentException`

💡 Regra prática:

Quando uma `RuntimeException` ocorre, o problema quase sempre está no código, não no fluxo externo.

✅ Elas devem ser **corrigidas**, não apenas tratadas.

##### ✅ Checked Exceptions — Tratamento Obrigatório

`Checked exceptions` são aquelas que o **compilador obriga a tratar**

📌 Características:

- Filhas diretas de `Exception`
- Representam **problemas previsíveis do mundo externo**
- Devem ser:
  - Tratadas com `try-catch`
  - Ou declaradas com `throws`

📛 Exemplos clássicos:

- `IOException`
- `FileNotFoundException`
- `SQLException`

💥 Regra clara:

**Sem tratamento ➜ código não compila**

---

### 🧯 try-catch — Tratamento de Exceções

Estrutura básica:

```java 
    try {
        // código que pode falhar
    } catch (Exception e) {
        e.printStackTrace();
    }
```

✅ Boas práticas essenciais:

- **Nunca** deixar bloco catch vazio
- Evitar lógica de negócio dentro do `catch`
- Capturar **exceções mais específicas primeiro**
- Tratar apenas o que faz sentido naquele nível do código

📎 `e.printStackTrace()`:

- Exibe toda a `stack trace`
- Mostra
  - Classe
  - Método
  - Linha
- Ferramenta fundamental para **debug e análise de falhas**

#### 🔁 Lançando Exceções (throw)

Usado para **validar regras de negócio** e estados inválidos

Exemplo:
```java
    if (b == 0) {
        throw new IllegalArgumentException("Argumento não pode ser zero");
    }
```

📌 Use `throw` quando:

- O estado do método é inválido
- Continuar a execução causaria erro lógico
- Há violação de regra de negócio

🔎 `IllegalArgumentException`:

- É `RuntimeException`
- Não exige `throws`
- Ideal para validar parâmetros

#### 📦 throws — Propagando a Exceção

Indica que o método **não irá tratar a exceção**, apenas propagá-la

📌 Uso típico:

- O método **não tem contexto suficiente** para decidir
- A responsabilidade é do **chamador**

⚠️ Para exceções `checked`: declarar com `throws` é obrigatório se não houver `catch`

📌 Isso deixa explícito o contrato do método

#### 🔄 Capturar e Relançar Exceções

Exemplo:
```java
    catch (IOException e) {
        e.printStackTrace();
        throw e;
    }
```

📌 Útil quando:

- Você precisa **registrar a falha**
- Mas quer que outro nível decida o que fazer

✅ Também é comum converter para exceção `unchecked`:

Exemplo:
```java
    throw new RuntimeException("Erro ao criar arquivo", e);
```

📌 Isso preserva o `stack trace` original

#### 🔚 finally — Execução Garantida

Estrutura clássica:
```java
    try {
        abrirRecurso();
    } finally {
        fecharRecurso();
    }
```

✅ O bloco `finally`:

- Sempre é executado
- Ocorrendo ou não exceção
- Mesmo com `return` ou erro

📌 Principal uso:

- **Liberação de recursos externos**
  - Arquivos
  - Conexões
  - Streams
  - Locks

#### ♻️ try-with-resources — Forma Moderna ✅

Introduzido no Java 7

Exemplo:
```java
    try (Reader reader = new FileReader("arquivo.txt")) {
        // uso do recurso
    }
```

✅ Vantagens:

- Recursos são fechados automaticamente
- Código mais limpo
- Menor risco de vazamento de recursos

📌 Requisitos:

- A classe deve implementar
  - `AutoCloseable` ou `Closeable`
  
📎 Recursos são fechados em **ordem inversa da declaração**

#### 🔀 Múltiplos catch — Ordem Importa

Exemplo:
```java
    try {
        // código
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (Exception e) {
    }
```

⚠️ Regra crítica: Exceções **mais genéricas sempre por último**

Caso contrário:

- Erro de compilação
- Blocos se tornam inalcançáveis

#### 🧵 Multi-catch (Java 7+)

Exemplo:
```java
    catch (IOException | SQLException e) {
        e.printStackTrace();
    }
```

✅ Use quando:

- O tratamento é exatamente o mesmo
- As exceções **não estão na mesma hierarquia direta**

⚠️ Observação importante:

- A variável e se torna implicitamente `final`

#### 🧩 Exceções Customizadas

Criar exceções próprias melhora a **clareza semântica do código**

Exemplo:
```java
    public class LoginInvalidoException extends Exception {
        public LoginInvalidoException(String msg) {
            super(msg);
        }
    }
```

📌 Decisão arquitetural importante:

- `extends Exception ➜ checked`
- `extends RuntimeException ➜ unchecked`

✅ Use exceções customizadas para:

- Regras de negócio específicas
- Erros de domínio
- Comunicação clara de falhas

#### 🧬 Exceções e Sobrescrita (@Override)

📌 Regras fundamentais na sobrescrita de métodos

✅ Permitido

- Não declarar exceções
- Declarar menos exceções
- Declarar exceções mais específicas
- Declarar `RuntimeException`

❌ Proibido:

- Declarar exceções mais genéricas
- Adicionar novas `checked exceptions` não declaradas no método original

📌 Isso garante **compatibilidade polimórfica**

---

## 🚀 Síntese Final ✅🧠

- `Error` **não se trata**
- `RuntimeException` ➜ geralmente indica **erro de código**
- Exceções `checked` exigem `try-catch` ou `throws`
- **Nunca ignore exceções**
- **Prefira** `try-with-resources`
- Leia e entenda `stack traces`
- Seja explícito, consistente e intencional
- **Exceções bem usadas salvam sistemas**

---