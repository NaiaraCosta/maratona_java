# ⚙️ Métodos

Um **método** é um bloco de código que define um **comportamento ou ação** que um objeto pode executar.

💡 Ele é declarado dentro de uma classe e pode:

* 📥 Receber parâmetros
* ⚙️ Executar instruções
* 📤 Retornar um valor (ou não)

---

## 🧱 Estrutura de um método

```
tipoRetorno nomeMetodo(parâmetros) {
    // corpo do método
}
```

---

## 🧠 Tipos de métodos

### 🔹 Método sem retorno (`void`)

* Não retorna nenhum valor
* Apenas executa uma ação

```
public void exibir() {
    System.out.println("Exibindo dados...");
}
```

---

### 🔹 Método com retorno

* Retorna um valor
* Precisa usar `return`

```
public int calcularIdade(int anoAtual) {
    return anoAtual - ano;
}
```

---

## ⚠️ Não confunda: retorno vs saída

Essa é uma dúvida MUITO comum 👇

---

### 📤 Saída (output)

É quando você **mostra algo na tela**.

```
System.out.println("Olá");
```

✔ Apenas exibe informação
❌ Não devolve valor para o programa

---

### 📥 Retorno (return)

É quando o método **devolve um valor para quem chamou**.

```
public int somar(int a, int b) {
    return a + b;
}
```

✔ Pode ser usado em outras partes do código
✔ Faz parte da lógica do programa

---

### 💡 Exemplo comparando

```
public void exibir() {
    System.out.println("Olá"); // saída
}

public int somar(int a, int b) {
    return a + b; // retorno
}
```

---

### 🎯 Regra simples

> 📤 `println` → mostra
> 📥 `return` → devolve

---

## 📥 Parâmetros

Parâmetros são valores que o método recebe para trabalhar.

```
public int somar(int a, int b) {
    return a + b;
}
```

---

## ▶️ Chamando métodos

```
Carro carro1 = new Carro();

int idade = carro1.calcularIdade(2025);
```

---

## 🚀 Resumo rápido

* ⚙️ Método → comportamento
* 📥 Parâmetros → entrada
* 📤 Saída → exibir na tela
* 📥 Retorno → devolver valor
* 🔹 `void` → sem retorno
* 🧠 Retorno ≠ saída