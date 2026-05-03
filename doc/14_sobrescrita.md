# 📘 Guia — Sobrescrita de `toString` e Uso do Modificador `final` em Java

Guia técnico sobre **sobrescrita de métodos** e o **modificador `final`**, cobrindo tipos primitivos, tipos de referência, classes e métodos, com foco em `Orientação a Objetos` em `Java`.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 Este material aborda conceitos centrais de `Orientação a Objetos`, iniciando pela **sobrescrita do método `toString`** herdado de `Object`, explicando como personalizar a representação textual de objetos. Em seguida, aprofunda o **modificador `final`**, demonstrando seu comportamento ao ser aplicado em **atributos primitivos**, **referências a objetos**, **classes** e **métodos**, sempre relacionando com `herança`, `encapsulamento` e `polimorfismo`.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧬 Sobrescrita do método `toString`
- Todo objeto em `Java` herda de `Object`.
- Ao imprimir uma **variável de referência**, o `Java` executa automaticamente o método `toString`.
- A implementação padrão retorna:
    - `getClass().getName()`
    - `@`
    - `hashCode`

📌 Problema: essa saída **não é legível para humanos**.

✅ Solução: **sobrescrever** `toString` na própria classe.

Exemplo:
```java
    @Override
    public String toString() {
        return this.nome;
    }
```

🔑 Pontos importantes:

- O uso de `@Override` garante que existe sobrescrita real.
- Sem `@Override`, um erro de assinatura pode gerar um novo método, e não uma sobrescrita.
- A chamada de `toString` é **implícita** em `System.out.println(obj)`.

---

### 🧾 Regras Fundamentais da Sobrescrita

- **Mesmo nome**
- **Mesma lista de parâmetros**
- **Tipo de retorno igual ou covariante**
- **Modificador de acesso nunca mais restritivo**

📌 Exemplo:

- `public` ➜ nunca pode virar `protected` ou `private`

---

### 🔒 `final` em Tipos Primitivos (Constantes)

- `final` transforma a variável em uma **constante**.
- Exige **inicialização obrigatória**.

Exemplo:
```java
    public static final double VELOCIDADE_LIMITE = 250;
```

✅ Convenção:

- Letras maiúsculas
- Palavras separadas por _

📌 Observações:

- Normalmente usado com `static`
- Não pode ser alterado após a inicialização
- Pode ser inicializado diretamente, em bloco estático ou no construtor

---

### 🔗 `final` em Tipos de Referência

- `final` não torna o objeto imutável.
- Torna **imutável a referência**.

Exemplo:
```java
    public final Comprador comprador = new Comprador();
```

❌ Não permitido:
```java
    carro.comprador = new Comprador();
```

✅ Permitido:
```java
    carro.comprador.setNome("Naiara");
```

🧠 Conceito-chave:
**A referência não muda, mas o estado interno do objeto pode mudar.**

📌 Uso comum:

Base para padrões como Singleton
Evita troca acidental de instância

--- 

### 🚧 `final` em Classes

Exemplo:
```java
    public final class String { }
```

- Classes final não podem ser estendidas.
- Impede `herança` e sobrescrita de métodos.

🧠 Motivo:
Garantir comportamento imutável e seguro em classes fundamentais do `Java`.

📌 Exemplo clássico:

String é `final` para evitar alteração do seu funcionamento interno.

--- 

### 🛑 `final` em Métodos

Exemplo:
```java
    public final void imprime() { }
```

- Métodos `final` não podem ser sobrescritos.
- O comportamento é fixo para toda a hierarquia.

⚠️ Observações:

- Métodos `final` ainda podem ser herdados.
- Se a classe é `final`, definir métodos como final é redundante.

--- 

## 🚀 Síntese Final ✅🧠

- `toString` é chamado automaticamente em impressões
- `@Override` garante sobrescrita real
- `final` em primitivos define constantes
- `final` em referências impede troca de objeto
- `final` em classes bloqueia herança
- `final` em métodos bloqueia sobrescrita
- Sobrescrita exige regras rígidas de assinatura e acesso

--- 