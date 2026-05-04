# 📘 Guia — `Threads` em `Java` (Fundamentos à Concorrência Avançada)

Documento técnico sobre **`Threads` em `Java`**, cobrindo desde conceitos fundamentais até sincronização, deadlocks e comunicação entre threads.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **`Threads`** representam **linhas de execução independentes** dentro de um mesmo processo.  
Em `Java`, trabalham sob controle da **`JVM`**, que gerencia escalonamento, execução e estados.  
O uso correto de `threads` permite **execução concorrente**, mas introduz **riscos reais** como condições de corrida, inconsistência de dados e **deadlocks**, exigindo mecanismos de **sincronização explícita**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧵 O que é uma `Thread`

- Pode ser entendida como:
  - ✅ Um **objeto** da classe `Thread`
  - ✅ Uma **linha de execução independente**
- Um único processo pode ter **dezenas ou milhares** de `threads`.
- A **`JVM` decide**:
  - Quando executar
  - Quando pausar
  - Quando alternar entre `threads`

📌 **Poucas garantias** são oferecidas sobre ordem ou tempo de execução.

---

### ⚙️ Tipos de `Threads`

- **`User Threads`**
  - Criadas pelo desenvolvedor
  - Mantêm a aplicação viva

- **`Daemon Threads`**
  - Threads auxiliares (ex: `Garbage Collector`)
  - Finalizadas automaticamente quando todas as `User Threads` terminam

✅ O programa termina quando **todas as `User Threads` morrem**.

---

### 🏗️ Criando `Threads`

#### ✅ Estendendo `Thread`
- Sobrescreve `run()`
- **Não recomendado** (herança limita design)

#### ✅ Implementando `Runnable` (**recomendado**)
- Separa lógica de execução da `Thread`
- Facilita reutilização e composição

📌 **Boa prática**: implementar `Runnable` e passar ao construtor de `Thread`.

---

### ▶️ `run()` vs `start()`

- **`run()`**
  - Executa na `Thread` atual (`main`)
  - ❌ Não paraleliza

- **`start()`**
  - Cria nova `Thread`
  - Executa `run()` **em paralelo**

✅ Sempre usar `start()` para concorrência real.

---

### 🧭 Estados de uma `Thread`

- **`NEW`**
- **`RUNNABLE`**
- **`RUNNING`**
- **`BLOCKED`**
- **`WAITING`**
- **`TIMED_WAITING`**
- **`TERMINATED`**

📌 Uma `Thread` **não pode ser reiniciada** após chegar a `TERMINATED`.

---

### ⏯️ `sleep()` e Prioridade

- **`Thread.sleep(ms)`**
  - Pausa a `Thread` atual
  - Vai para estado `BLOCKED`
  - ⏱️ Uma das **poucas garantias temporais**

- **Prioridade**
  - Intervalo típico `1` a `10`
  - Usar constantes:
    - `Thread.MIN_PRIORITY`
    - `Thread.NORM_PRIORITY`
    - `Thread.MAX_PRIORITY`

⚠️ **Não confiar** em prioridade para lógica de negócio.

---

### 🔄 `yield()`

- Indica ao **scheduler** que a `Thread` pode ceder execução
- ❌ **Sem garantia**
- Apenas uma **sugestão** à `JVM`

Útil apenas para **demonstração conceitual**.

---

### 🤝 `join()`

- Faz uma `Thread` **aguardar outra terminar**
- Bloqueia quem chamou o `join()`

✅ Útil quando:

- Resultado de uma `Thread` é pré-requisito
- Controle de fluxo é necessário

---

### ⚠️ Problema Clássico — Condição de Corrida

📌 Ocorre quando:

- Duas ou mais `threads`
- Acessam e modificam
- **O mesmo objeto simultaneamente**

Resultado:

- Estados inconsistentes
- Erros difíceis de reproduzir
- Bugs intermitentes em produção

---

### 🔐 `synchronized` — Lock e Exclusão Mútua

- Garante execução **atômica**
- Usa o **lock (monitor)** de um objeto

Modos:

- ✅ `synchronized` em método
- ✅ `synchronized(objeto)` em bloco

📌 Enquanto uma `Thread` segura o lock:

- Nenhuma outra entra no bloco sincronizado
- Mesmo se a `Thread` estiver em `sleep()`

---

### 🧱 `static synchronized`

- Lock aplicado à **classe**
- Usado para proteger recursos compartilhados estáticos

---

### ✅ Classes `Thread-Safe`

- Exemplo:
  - `StringBuffer`
  - `Collections.synchronizedList(...)`

⚠️ **Atenção crítica**: 
Uma classe pode usar estruturas `thread-safe`, mas **o código acima dela pode não ser**.

✅ Métodos compostos precisam de **sincronização própria**.

---

### ☠️ Deadlock

📌 Ocorre quando:

- `Thread A` segura `Lock 1` e espera `Lock 2`
- `Thread B` segura `Lock 2` e espera `Lock 1`

Resultado:

- **Nenhuma avança**
- Aplicação trava
- ❌ Sem recuperação automática

✅ Prevenção:

- **Ordem fixa de aquisição de locks**
- Evitar locks encadeados sempre que possível

---

### ⏳ `wait()`, `notify()` e `notifyAll()`

- Definidos em `Object`
- Usados para **comunicação entre threads**

Regras críticas:

- Só funcionam dentro de `synchronized`
- `wait()`:
  - Libera o lock
  - Coloca `Thread` em espera
- `notify()`:
  - Acorda **uma**
- `notifyAll()`:
  - Acorda **todas**

📌 Ideal para:

- Produtor ↔ Consumidor
- Threads que dependem de estado externo

---

### 📬 Exemplo Conceitual — Produtor / Consumidor

- `Members`:
  - Controla fila de emails
  - Usa `wait()` se fila vazia
  - Usa `notifyAll()` ao adicionar email

- `EmailDeliveryService`:
  - Threads aguardam emails
  - Processam enquanto:
    - Lista aberta **OU**
    - Emails pendentes

✅ Controle manual do ciclo de vida das `threads`.

---

## 🚀 Síntese Final ✅🧠

- `Threads` trazem **performance**, mas também **complexidade**.
- A `JVM` controla escalonamento — **ordem não é garantida**.
- Sempre usar:
  - `Runnable`
  - `start()`
  - `synchronized` quando há compartilhamento
- Prioridade e `yield()` são **heurísticas**, não regras.
- Deadlock é fatal — **prevenir é obrigatório**.
- `wait()` / `notifyAll()` permitem comunicação controlada.
- `Thread-safe` não é só a estrutura — **é o conjunto do código**.

---