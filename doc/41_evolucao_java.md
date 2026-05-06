# 📘 Guia — Java Moderno: Evolução da Linguagem (`Java` 8 → 26)

Documento técnico **direto, progressivo e completo**, focado em **fundamentos reais**, **exemplos compreensíveis**, **contexto histórico** e **evolução consistente da linguagem `Java`**, sem remover **nenhum conteúdo previamente trabalhado**, apenas **organizando, refinando e enriquecendo**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 A evolução do `Java` é uma resposta direta a **problemas concretos enfrentados por desenvolvedores e arquitetos ao longo de décadas**.  
Nada foi criado “do nada” ou “por moda”.

Os principais desafios históricos foram:

- **Concorrência complexa e cheia de armadilhas**
- **Código verboso e difícil de manter**
- **Modelos de dados mutáveis e frágeis**
- **Sistemas grandes sem encapsulamento real**
- **Dificuldade de escalar aplicações com segurança**

A partir do `Java 8`, a linguagem passa por uma **mudança estrutural profunda**, que culmina (no `Java 21+`) em:

- ✅ Concorrência simples, segura e escalável
- ✅ Modelagem de domínio forte
- ✅ Código mais expressivo e legível
- ✅ Redução drástica de *boilerplate*
- ✅ Performance previsível

Este guia explica **do zero absoluto**, em **baby steps**, conectando sempre:
**problema → conceito → solução → impacto prático**.

---

## 🧩 Blocos Semânticos 🧠🔎

---


## 🧩 Blocos Semânticos 🧠🔎

---

### 🧵 Threads e Memória — Fundamento Obrigatório

#### 📌 Conceito básico de `Thread`

Uma **`Thread`** é um fluxo de execução independente dentro do mesmo programa.

- Um único programa `Java` pode ter **várias `threads`**
- Todas compartilham:
  - A **mesma memória heap**
  - Os mesmos objetos
- Cada `thread` tem sua **própria pilha de execução**

📌 Em termos simples:
> Uma `thread` é como um “funcionário” executando tarefas em paralelo dentro da mesma empresa (o processo).

Exemplo simples:

```java
    new Thread(() -> System.out.println("Executando em paralelo")).start();
```

#### 🧠 Como a Memória Funciona de Verdade

Para entender `volatile`, é obrigatório entender como a CPU trabalha

- A `memória RAM` é relativamente lenta
- A `CPU` possui `cache`, muito mais rápido
- As `threads` podem:
  - Ler valores do `cache`
  - Não perceber alterações feitas por outras `threads`

📌 A JVM não garante automaticamente que todas as `threads` leiam os valores atualizados da `RAM`

➡️ Isso gera o problema conhecido como problema de visibilidade

#### ⚠️ **volatile** — O Problema Real e a Solução Correta

❌ Exemplo Sem volatile (bug clássico de visibilidade)
```java
    public class ExemploSemVolatile {

        private static boolean executar = true;

        public static void main(String[] args) throws Exception {

            Thread worker = new Thread(() -> {
                System.out.println("Thread iniciada");
                while (executar) {
                    // trabalho simulado
                }
                System.out.println("Thread finalizada");
            });

            worker.start();
        
            Thread.sleep(2000);
            executar = false;
            System.out.println("Flag alterada para false");
        }
    }
```

**❓ O que a gente espera?**

- Após 2 segundos, executar vira `false`
- A `thread` sai do `while`
- O programa termina

**💥 O que pode acontecer?**

- A thread nunca para
- O loop vira infinito

**🤯 Por que isso acontece? (conceito)**

- A `thread worker` pode carregar **executar** apenas para o cache da CPU
- Ela continua lendo o valor do cache
- A **alteração** feita pela `thread main` fica **invisível**

📌 Esse problema **não é bug da JVM**, é **comportamento normal de arquiteturas modernas**

✅ O Mesmo Exemplo Com `volatile`
```java
    public class ExemploComVolatile {

        private static volatile boolean executar = true;
        
        public static void main(String[] args) throws Exception {
        
            Thread worker = new Thread(() -> {
              System.out.println("Thread iniciada");
              while (executar) {
                // trabalho simulado
              }
              System.out.println("Thread finalizada");
            });
        
            worker.start();
        
            Thread.sleep(2000);
            executar = false;
            System.out.println("Flag alterada para false");
        }
    }
```

**✅ O que mudou conceitualmente?**

A palavra-chave `volatile` diz à `JVM`:

❗ Não use cache local para essa variável
✅ Leia sempre da **memória principal**
✅ Publique imediatamente as escritas

##### 📌 Definição conceitual correta de `volatile`

`volatile` garante **visibilidade entre** `threads` e **ordem de leitura/escrita**

**✅ O que ele resolve:**

- Problema de visibilidade
- Problema de reordenação perigosa

**❌ O que ele NÃO resolve:**

- Concorrência complexa
- Operações atômicas

❌ Exemplo do que volatile NÃO resolve:
```java
    volatile int contador = 0;
    
    contador++; // NÃO É THREAD-SAFE
```

Conceitualmente:

- contador++ envolve três passos:

1. Ler
2. Somar
3. Escrever

📌 `volatile` não protege esses passos

✅ Para isso, usamos:

- `synchronized`
- `AtomicInteger`

##### ✅ Quando usar `volatile` (regra mental)

Use volatile quando:

- A variável é:
  - Um **estado simples**
  - Uma **flag**
- Uma `thread` escreve
- Outras apenas leem

Exatamente como no exemplo de controle de execução
---

### ☕ Java 8 (2014) — Mudança de Paradigma

#### 📌 Conceito central

O Java deixa de ser **puramente imperativo** e passa a suportar **programação funcional**

#### ➜ Lambda

Uma `lambda` representa uma **função sem nome**, passada como valor

Antes:
```java
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Executando");
        }
    }).start();
```

Depois:
```java
    new Thread(() -> System.out.println("Executando")).start();
```

✅ Menos ruído
✅ Mais intenção

🧩 Interfaces Funcionais

#### Interface com exatamente um método abstrato.

Exemplo:
```java
    @FunctionalInterface
    interface Soma {
        int aplicar(int a, int b);
    }
```

Uso:
```java
    Soma s = (a, b) -> a + b;
```

📌 `Lambda` só funciona porque **existe uma única assinatura possível**

#### 🌊 `Streams` API

Uma `Stream` representa:

- Um **fluxo de dados**
- Processado de forma **declarativa**
- Sem modificar a coleção original

Exemplo:
```java
numeros.stream()
       .filter(n -> n > 2)
       .map(n -> n * 2)
       .forEach(System.out::println);
```

📌 Pense como um pipeline de dados, não como um for

#### 🚫 `Optional`

`Optional` representa:

- Um valor que pode existir ou não.

Exemplo:
```java
    Optional<String> nome = Optional.of("Ana");
```

✅ Evita `NullPointerException` inesperado
❌ Não substitui tudo

#### 🕒 Nova API de Data/Hora

Antes:

- APIs mutáveis 
- Nada seguras para `threads`

Depois:
```java
    LocalDate hoje = LocalDate.now();
```

✅ Imutável
✅ `Thread-safe`

#### ⚙️ `CompletableFuture`

Modelo assíncrono baseado em:

- Promessas
- Encadeamento funcional

Exemplo:
```java
    CompletableFuture
        .supplyAsync(() -> buscar())
        .thenApply(r -> transformar(r));
```

📌 Base para arquiteturas reativas.

---

### ☕ Java 9 — Modularização

Exemplo:
```java
    module app.core {
      requires java.sql;
    }
```

📌 Conceito:

- Dependências explícitas
- Encapsulamento real
- Fim do `JAR Hell`

---

### ☕ Java 10 — Inferência local

Exemplo:
```java
    var nome = "Java";
```

📌 Apenas reduz repetição
❌ Não muda tipagem

---

### ☕ Java 11 — LTS

Consolida o Java moderno:

- HTTP Client
- Execução direta de `.java`
- APIs maduras

---

### ☕ Java 12–16 — Preparação

- `Switch expressions`
- `Text Blocks`
- `Records`
- `Pattern Matching`

#### 📦 `Records`

Exemplo:
```java
    public record Usuario(String nome, int idade) {}
```

📌 `Record` representa:

- Um **portador de dados imutável**
- Um contrato claro
- Um modelo seguro

#### 🔍 `Pattern Matching for instanceof`

Exemplo:
```java
    if (obj instanceof Usuario u) {
        u.nome();
    }
```

📌 Junta:

- Verificação de tipo
- Cast seguro

---

### ☕ Java 17

#### 🧱 `Sealed Classes`

Exemplo:
```java
    sealed interface Forma permits Circulo, Quadrado {}
```

📌 Controla quem pode herdar
✅ Domínio forte e explícito

---

### ☕ Java 21

#### 🧵 `Virtual Threads`

Exemplo:
```java
    Thread.startVirtualThread(() -> {
        System.out.println("Concorrência simples");
    });
```

📌 Ideia central:

- `threads` extremamente leves
- Milhares ou milhões
- Código simples, síncrono, escalar

---

### ☕ Java 22–26

- Concorrência estruturada
- Linguagem expressiva
- JVM mais segura
- GC avançado
- Performance previsível

---

## 🚀 Síntese Final ✅🧠

- `volatile` resolve visibilidade, não atomicidade
- Concorrência é o problema mais difícil do Java
- Java 8 mudou a forma de escrever código
- `Records` e `Sealed Classes` fortalecem o domínio
- `Virtual Threads` fecham um ciclo histórico

---