# 🔐 Modificadores de Acesso

Os **modificadores de acesso** controlam a **visibilidade** de classes, atributos e métodos.

💡 Eles são fundamentais para:

* 🔒 Proteger dados sensíveis
* 🧠 Aplicar encapsulamento
* 🧩 Organizar o código
* ⚠️ Evitar uso indevido de atributos

---

## 🧠 Tipos de modificadores

Em Java, existem quatro níveis de acesso:

---

### 🌍 `public`

* Acesso liberado para **qualquer classe**
* Inclusive em **outros pacotes**

```
public class Carro {
    public String nome;
}
```

✔ Maior nível de visibilidade

---

### 🧬 `protected`

* Acesso permitido para:

  * Mesma classe
  * Mesmo pacote
  * Subclasses (mesmo em pacotes diferentes)

```
protected String modelo;
```

💡 Muito usado em herança

---

### 🔒 `private`

* Acesso permitido **apenas dentro da própria classe**

```
private int ano;
```

✔ Mais seguro
✔ Base do encapsulamento

---

### 📦 (default / package-private)

* Sem modificador explícito
* Acesso apenas dentro do **mesmo pacote**

```
String cor;
```

⚠️ Não usa palavra-chave

---

## 📊 Comparação

| Modificador | Mesma Classe | Mesmo Pacote | Subclasse | Outros Pacotes |
| ----------- | ------------ | ------------ | --------- | -------------- |
| `public`    | ✔            | ✔            | ✔         | ✔             |
| `protected` | ✔            | ✔            | ✔         | ❌*           |
| `default`   | ✔            | ✔            | ❌         | ❌           |
| `private`   | ✔            | ❌            | ❌         | ❌          |

💡 `protected` permite acesso em subclasses fora do pacote

---

## 🧠 Encapsulamento na prática

O uso mais comum é combinar:

* 🔒 atributos `private`
* ⚙️ métodos `public` (getters/setters)

---

### 💻 Exemplo

```
public class Pessoa {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
```

✔ Controle total sobre os dados
✔ Maior segurança

---

## ⚠️ Boas práticas

* 🔒 Prefira `private` para atributos
* 🌍 Use `public` apenas quando necessário
* 🧬 Use `protected` em herança
* 📦 Evite depender de `default` em projetos grandes

---

## 🚀 Resumo rápido

* 🔐 Controlam quem pode acessar o quê
* 🔒 `private` → mais seguro
* 🌍 `public` → mais acessível
* 🧬 `protected` → herança
* 📦 `default` → mesmo pacote
* 🧠 Base do encapsulamento