# 📘 Guia — Concorrência Avançada em Java (`java.util.concurrent`)

Guia técnico completo sobre **concorrência em Java**, cobrindo do básico de **operações atômicas** até **`CompletableFuture`**, **programação assíncrona**, **encadeamento de tarefas** e **coordenação de múltiplas execuções concorrentes**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Concorrência em Java** vai muito além de `Thread` e `synchronized`.  
O pacote **`java.util.concurrent`** fornece **abstrações de alto nível** para criar aplicações:

- **Seguras contra condições de corrida**
- **Escaláveis**
- **Performáticas**
- **Mais legíveis e fáceis de manter**

Este guia percorre a evolução natural do aprendizado em concorrência:

➡️ Controle manual  
➡️ Locks avançados  
➡️ Coleções concorrentes  
➡️ Filas bloqueantes  
➡️ `Executors`  
➡️ Programação assíncrona com `Future` e `CompletableFuture`

---

## 🧩 Blocos Semânticos 🧠🔎

---

### ⚛️ Variáveis Atômicas — `AtomicInteger`

- `count++` **não é atômico**
- Em múltiplas `Thread`s gera **condição de corrida**
- `synchronized` resolve, mas **degrada performance**

✅ **`AtomicInteger`**

- Pacote `java.util.concurrent.atomic`
- Implementa **CAS — Compare And Swap**
- Não utiliza `lock` explícito

Principais métodos:

- `incrementAndGet`
- `getAndIncrement`
- `get`

Outros tipos:

- `AtomicLong`
- `AtomicBoolean`
- `AtomicIntegerArray`

---

### 🔐 `synchronized` vs `ReentrantLock`

✅ Vantagens do `ReentrantLock`:

- Controle de **fairness**
- `tryLock(timeout)`
- Interrupção de `Thread`
- Verificação: `isHeldByCurrentThread`

⚠️ Desvantagem:

- **Gerenciamento manual**
- Necessidade obrigatória de `try / finally`
- Risco de **deadlock** se esquecer `unlock()`

📌 Regra prática:

> Use `synchronized` sempre que possível;  
> use `Lock` apenas se precisar de funcionalidades extras.

---

### 🚦 Conditions — `await`, `signal`, `signalAll`

Substituem:

- `wait`
- `notify`
- `notifyAll`

Criação:

- `Condition condition = lock.newCondition()`

Mapeamento:

- `wait()` → `condition.await()`
- `notify()` → `condition.signal()`
- `notifyAll()` → `condition.signalAll()`

📛 Erro comum:

- Chamar `signal` sem possuir o `lock`

---

### 📖✍️ `ReentrantReadWriteLock`

- **Leitores concorrentes**
- **Escrita exclusiva**

Métodos:

- `readLock()`
- `writeLock()`

📌 Ideal para:

- Muitas leituras
- Poucas escritas

✅ Leitores não bloqueiam leitores  
❌ Escritores bloqueiam tudo

---

### 📋 `CopyOnWriteArrayList`

Coleção baseada em **imutabilidade por cópia**:

- Cada modificação cria **nova lista**
- Iteradores são **seguros**
- Nunca lança `ConcurrentModificationException`

⚠️ Atenção:

- Alto custo de memória
- Objetos internos **devem ser imutáveis**

---

### 📦 `ArrayBlockingQueue`

Fila bloqueante e limitada (**bounded**):

- `put()` → bloqueia se cheia
- `take()` → bloqueia se vazia

📌 Excelente para padrão **Producer / Consumer**

---

### 🔄 `LinkedTransferQueue`

Fila híbrida (Java `7+`):

Une:

- `ConcurrentLinkedQueue`
- `SynchronousQueue`
- `LinkedBlockingQueue`

Métodos importantes:

- `add`
- `offer`
- `put`
- `transfer`
- `tryTransfer`
- `take`
- `poll`

✅ Suporte a bloqueio e não bloqueio  
✅ Comunicação direta produtor ↔ consumidor

---

### 🧵 `Executors` — Thread Pools

Problema:

- Criar `Thread` manualmente **não escala**

✅ Solução:

- **Desacoplamento** entre submissão e execução

Tipos:

- `newFixedThreadPool`
- `newSingleThreadExecutor`
- `newCachedThreadPool`

📌 Benefícios:

- Controle de recursos
- Reutilização de threads
- Melhor desempenho

⚠️ Importante:

- Sempre chamar `shutdown()`

---

### ⏱️ `ScheduledExecutorService`

Executa tarefas:

- Após atraso (`schedule`)
- Periodicamente (`scheduleAtFixedRate`)
- Com atraso entre execuções (`scheduleWithFixedDelay`)

Diferença:

- **Fixed Rate:** tempo absoluto
- **Fixed Delay:** tempo após término

---

### 📞 `Callable` vs `Runnable`

- `Runnable` → retorno `void`
- `Callable<T>` → retorno genérico + exceção

Executado via:

- `ExecutorService.submit()`

Retorno:

- `Future<T>`

✅ Ideal quando precisa de resultado

---

### 🕰️ `Future`

- Representa um resultado **que chegará no futuro**
- Execução **assíncrona**

Métodos principais:

- `get()`
- `get(timeout)`
- `isDone`
- `cancel`

📛 Cuidado:

- `get()` é **bloqueante**
- Sempre usar `timeout`

---

### ⚡ `CompletableFuture`

Evolução do `Future`

✅ Vantagens:

- Execução assíncrona
- Encadeamento de tarefas
- Manipulação de erros
- Não exige `Executor` explícito

Criação:

- `supplyAsync`
- `runAsync`

Consumo:

- `get`
- `join` (**não lança checked exceptions**)

---

### 🔗 Encadeamento com `CompletableFuture`

Principais métodos:

- `thenApply`
- `thenCompose`
- `thenAccept`

📌 Diferença:

- `thenApply` → transforma valor
- `thenCompose` → encadeia outro `CompletableFuture`

✅ Ideal para pipelines assíncronos

---

### 🌊 `CompletableFuture` + Streams

⚠️ Problema comum:

- `Stream` é **lazy**
- `join` dentro do `map` executa sequencialmente

✅ Solução:

1. Criar lista de `CompletableFuture`
2. Depois fazer `join`

---

### 🧵 Executor customizado + `ThreadFactory`

- `CompletableFuture` usa `ForkJoinPool.commonPool`
- Possível definir `Executor` próprio
- Customizar threads via `ThreadFactory`

Exemplo de controle:

- Nome da thread
- Prioridade
- Daemon

---

### 🧮 `allOf` e `anyOf`

✅ `allOf`
- Finaliza quando **todas** as tarefas terminam

✅ `anyOf`
- Finaliza quando **uma** termina

📌 Casos de uso:

- `allOf`: agregação de resultados
- `anyOf`: múltiplas fontes equivalentes (ex: cotação)

---

## 🚀 Síntese Final ✅🧠

- `Atomic*` evita `lock`
- `Lock` dá controle, mas é perigoso
- `Conditions` substituem `wait/notify`
- `ReadWriteLock` separa leitura e escrita
- Coleções concorrentes evitam corrupção
- `BlockingQueue` coordena produtor/consumidor
- `Executors` são essenciais para escala
- `Callable` retorna valor
- `Future` é assíncrono, mas limitado
- `CompletableFuture` é o **padrão moderno**
- `thenCompose` permite pipelines eficientes
- `allOf` e `anyOf` coordenam múltiplas tarefas

---