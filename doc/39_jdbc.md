# 📘 Guia — JDBC Avançado na Prática (MySQL + Docker)

Documentação técnica **completa e consolidada** do módulo de `JDBC`, cobrindo **todas as 3 partes do conteúdo**, do uso de `Statement` até `CRUD completo`, `Transações`, `RowSet`, `PreparedStatement`, `CallableStatement` e arquitetura em camadas.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 Este guia apresenta uma **imersão progressiva em JDBC**, partindo de operações básicas (`INSERT`, `DELETE`, `UPDATE`, `SELECT`) até recursos avançados como **`ResultSet` navegável**, **`PreparedStatement`**, **`CallableStatement` (Stored Procedures)**, **`RowSet` conectado e desconectado**, **`Transações`**, e culmina na construção de um **CRUD completo via console**, com organização em **camadas (`repository`, `service`, `domain`)**, boas práticas e foco em **robustez e manutenibilidade**.

Tudo é feito utilizando:
- **`MySQL` rodando em `Docker`**
- **`JDBC` puro**
- **`Maven`**
- **`Lombok`**
- **`Log4j2`**

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧹 Delete com `Statement`

- Remoção de registros via SQL

Exemplo:
```sql
    DELETE FROM producer WHERE id = ?
```

- Uso de camada de serviço (ProducerService) para
    - Validar `id`
    - Centralizar regras de negócio

- Camadas claras
    - `domain` → entidade (`Producer`)
    - `repository` → acesso ao banco
    - `service` → regras
    - `test/view` → simulação do cliente

📌 **Boa prática:** nunca acessar repository direto da view.

---

### ✏️ `Update` com `Statement`

Atualização controlada (ID nunca muda)

Exemplo:
```sql
    UPDATE producer SET name = ? WHERE id = ?
```

- Validações
    - id ≠ null
    - id > 0
- Criação de método utilitário

Exemplo:
```sql
    requireValidId(Integer id)
```

---

### 🔍 `Select` com `ResultSet`

**🔹 findAll**

- Uso de ResultSet
- Conversão de linhas → objetos Java
- Retorno de List<Producer>
- Nunca retornar null, sempre lista vazia

**🔹 findByName**

Exemplo:
```sql
    SELECT id, name FROM producer WHERE name LIKE '%valor%'
```

📌 Iteração via

```sql
    while (rs.next()) { ... }
```
---

### 🧬 `ResultSetMetaData` 🔍📊

Permite explorar a **estrutura do resultado** retornado por uma `query` JDBC, sem conhecimento prévio das colunas.

#### 📌 O que pode ser obtido

- Quantidade de colunas (`getColumnCount()`)
- Nome da tabela (`getTableName()`)
- Nome da coluna (`getColumnName()`)
- Tipo da coluna (`getColumnTypeName()`)
- Tamanho / capacidade (`getColumnDisplaySize()`)

💡 **Casos de uso comuns**

- 📄 Geração dinâmica de **relatórios**
- 🧠 **Queries dinâmicas** (quando o schema não é fixo)
- 🔌 **Integrações externas** e sistemas genéricos

---

### 🧠 `DatabaseMetaData` — Capacidades do Driver JDBC ⚙️🧪

Explora o que o **driver JDBC suporta**, permitindo decisões técnicas em tempo de execução.

#### 📌 Tipos de `ResultSet` suportados

- `TYPE_FORWARD_ONLY`
- `TYPE_SCROLL_INSENSITIVE`
- `TYPE_SCROLL_SENSITIVE`

#### ✅ Recursos verificáveis

- Navegação reversa (cursor bidirecional)
- Atualização direta de dados
- Suporte à concorrência (`CONCUR_READ_ONLY`, `CONCUR_UPDATABLE`)

💡 Essencial para verificar se o banco/driver aceita **`ResultSet` scrollable ou updatable**.

---

### 🔄 `ResultSet` `Scrollable` & `Updatable` 🚀📥

Permite **navegação avançada** e **alteração direta de registros** sem escrever novo SQL.

#### 🧭 Navegação avançada

- `first()`
- `last()`
- `absolute(n)`
- `relative(n)`

#### 🔍 Verificações de posição

- `isFirst()`
- `isLast()`

#### ✏️ Atualização direta

Exemplo:
```java
rs.updateString("name", novoValor);
rs.updateRow();
```

📌 **Sem novo SQL** para update.

---

### ➕ `Insert` & `Delete` com `ResultSet`

- Inserção

Exemplo:
```java
    rs.moveToInsertRow();
    rs.updateString("name", valor);
    rs.insertRow();
```

- Cancelamento

Exemplo:
```java
    rs.cancelRowUpdates();
```

- Remoção

Exemplo:
```java
    rs.deleteRow();
```

---

### ⚡ `PreparedStatement`

✅ Mais rápido e seguro

- Pré-compilação do `SQL`
- Proteção contra `SQL Injection`
- Substituição de parâmetros:

Exemplo:
```sql
    WHERE name LIKE ?
```
```java
    ps.setString(1, "%valor%");
```

📌 **Nunca concatenar SQL com input do usuário.**

---

### ☎️ CallableStatement (Stored Procedures)

Utilizado para executar:

- `Stored Procedures`
- `Functions`

Exemplo:
```sql
    CREATE PROCEDURE find_producer_by_name(IN pname VARCHAR(100))
    BEGIN
        SELECT * FROM producer WHERE name LIKE pname;
    END;
```
```java
    CallableStatement cs = con.prepareCall("{call find_producer_by_name(?)}");
```

📌 **Uso mais raro hoje**, mas importante conhecer.

---

### 🔌 RowSet — JDBC Avançado

#### ✅ JdbcRowSet (Connected)

- Mantém conexão aberta
- `Scrollable` e `updatable` por padrão
- Pode usar `Listeners`

Exemplo:
```java
    JdbcRowSet jrs = RowSetProvider.newFactory().createJdbcRowSet();
```

#### ✅ CachedRowSet (Disconnected)

- Trabalha **em memória**
- Desconecta do banco

Exemplo:
```java
    crs.acceptChanges();
```

⚠️ Cuidado com:

- `autoCommit`
- Conflitos de concorrência
- Atualizações manuais

#### 🧷 RowSetListener

Permite reagir a eventos:

- Cursor move
- `Insert`
- `Update`
- `Delete`

Usado para:

- Sincronização
- Logs
- Refresh automático

---

### 🔐 Transações JDBC

- **Atomicidade real**
-
- Desabilitar autoCommit:

Exemplo:
```java
    con.setAutoCommit(false);
```

- Finalizar:

Exemplo:
```java
    con.commit();
```

- Reverter:

Exemplo:
```java
    con.rollback();
```

📌 Essencial para:

- `Batch insert`
- Operações financeiras
- Consistência de dados

---

### 🚀 Síntese Final ✅🧠

- `JDBC` domina acesso a dados em Java
- `Statement` → básico
- `PreparedStatement` → seguro e performático
- `CallableStatement` → procedures
- `ResultSet` → leitura e navegação
- `RowSet` → dados conectados e desconectados
- `Transactions` → consistência garantida

---