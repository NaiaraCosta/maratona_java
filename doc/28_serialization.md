# 📘 Guia — Serialização em Java (Parte 1 e 2)

Introdução prática ao conceito de **serialização** e **desserialização** em `Java`, com foco em uso real, armadilhas comuns e controle avançado do processo.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Serialização** é o processo de transformar um objeto que está em memória em um **array de bytes**, permitindo persistir seu estado (por exemplo, em um arquivo) e recuperá-lo posteriormente por meio da **desserialização**.  
Esse conceito é amplamente utilizado por frameworks e bibliotecas que precisam salvar e restaurar estados de objetos de forma transparente.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Conceito Fundamental de Serialização

- **Serializar**: converter um objeto em bytes para persistência.
- **Desserializar**: reconstruir o objeto a partir desses bytes.
- Uso intenso de classes do pacote `java.io`.
- Processamento em **baixo nível**, baseado em streams de bytes.

📌 Classes-chave:

- `ObjectOutputStream`
- `ObjectInputStream`
- `FileOutputStream`
- `FileInputStream`

---

### 🧑‍🎓 Classe de Domínio (`Aluno`)

- Classe simples com atributos:
    - `id`
    - `nome`
    - `password`
- Implementa a interface `Serializable`.

✅ **Requisito obrigatório**:

- A classe **deve implementar** `Serializable`, caso contrário ocorre `NotSerializableException`.

📌 `Serializable` é uma **interface marker** (não possui métodos).

---

### 💾 Serializando um Objeto

- Criação de um método `serializar`.
- Encadeamento de streams:
    - `FileOutputStream` → `ObjectOutputStream`
- Escrita do objeto com:
    - `writeObject(objeto)`

⚠️ Exceção comum:

- `IOException`

---

### 📂 Arquivo Serializado

- Gera arquivos como `aluno.ser`.
- Conteúdo não é legível em texto:
    - Representa bytes interpretados pela `JVM`.

---

### 🔄 Desserialização

- Uso de `ObjectInputStream`.
- Leitura com:
    - `readObject()`
- Retorna `Object` → exige **casting explícito**.

⚠️ Exceções importantes:

- `ClassNotFoundException`
- `ClassCastException`

---

### 🚫 Construtor NÃO é Executado

- Durante a **desserialização**, o `constructor` **não é chamado**.
- Impacto direto em:
    - Lógicas de inicialização
    - Herança
    - Chamadas a `super()`

---

### 🔐 `transient` — Campos Ignorados

- Usado para **campos sensíveis**, como `password`.
- Campos `transient`:
    - Não são serializados
    - Retornam como `null` na desserialização

✅ Boa prática de segurança.

---

### 🆔 `serialVersionUID`

- Identificador de versão da classe serializada.
- Evita erro de incompatibilidade (`InvalidClassException`).

✅ Deve ser declarado manualmente:

- Garante compatibilidade mesmo com pequenas mudanças na classe.

---

### 🧬 Atributos `static`

- **NÃO são serializados**.
- Pertencem à classe, não ao objeto.
- Valor vem do carregamento da classe, não do arquivo serializado.

---

### 🧩 Relações com Objetos Não Serializáveis

#### Cenário:

- `Aluno` possui atributo `Turma`
- `Turma` **não implementa** `Serializable`

⚠️ Erro:
- `NotSerializableException`

---

### 🛠️ Controle Manual: `writeObject` e `readObject`

Quando **não é possível alterar a classe dependente**, usa-se controle manual:

#### Estratégia:

1. Marcar o atributo como `transient`
2. Criar métodos especiais:
    - `private void writeObject(ObjectOutputStream oos)`
    - `private void readObject(ObjectInputStream ois)`

📌 Fluxo:
- Chamar `defaultWriteObject()`
- Escrever manualmente os atributos necessários
- Ler os dados **na mesma ordem** que foram escritos
- Reconstruir o objeto manualmente

✅ Permite reconstruir o estado completo sem serializar o objeto diretamente.

---

## 🚀 Síntese Final ✅🧠

- **Serialização** transforma objetos em bytes usando `ObjectOutputStream`
- **Desserialização** reconstrói objetos via `ObjectInputStream`
- Classes devem implementar `Serializable`
- O `constructor` não é executado na desserialização
- Campos `transient` são ignorados
- Atributos `static` não participam da serialização
- `serialVersionUID` evita incompatibilidade de versões
- Objetos não serializáveis exigem controle manual com `writeObject` e `readObject`
- Ordem de escrita e leitura **deve ser idêntica**

---