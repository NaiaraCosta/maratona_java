# 📘 Guia — Sobrescrita de `toString` e Uso do Modificador `final` em Java

Guia técnico sobre **sobrescrita de métodos** e o **modificador `final`**, cobrindo tipos primitivos, tipos de referência, classes e métodos, com foco em **Orientação a Objetos** em `Java`

---

## 🧠 Resumo Contextualizado 🤯📌

💡 Este material explora conceitos centrais de **Orientação a Objetos em Java**, iniciando pela **sobrescrita do método `toString`**, herdado implicitamente da classe `Object`. Esse método é fundamental para definir como objetos são representados em forma textual, especialmente durante depuração, logs e exibição em terminal

Na sequência, o estudo aprofunda o **modificador `final`**, analisando com rigor técnico seus efeitos quando aplicado a:

- **Tipos primitivos**
- **Referências a objetos**
- **Classes**
- **Métodos**

Cada aplicação do `final` é contextualizada dentro dos pilares da Orientação a Objetos, principalmente **herança**, **encapsulamento** e **polimorfismo**, deixando explícitas as intenções de design por trás de cada uso

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧬 Sobrescrita do método `toString`

- Todo objeto em `Java` herda direta ou indiretamente da classe `Object`
- A classe `Object` define métodos fundamentais, como `equals`, `hashCode`, `toString`, entre outros
- Ao imprimir uma **variável de referência**, o `Java` executa automaticamente o método `toString()` desse objeto

Exemplo implícito:
```java
    System.out.println(obj); // equivale a System.out.println(obj.toString());
```

Por padrão, a implementação de `toString()` na classe `Object` retorna uma string composta por:

- O nome completo da classe (`getClass().getName()`)
- O caractere `@`
- O valor do `hashCode` em hexadecimal

📌 Problema: essa saída padrão **não é legível para humanos** e não representa o estado real do objeto

✅ Solução: sobrescrever o método `toString()` na própria classe, definindo uma representação textual significativa

Exemplo:
```java
    @Override
    public String toString() {
        return this.nome;
    }
```

🔑 Pontos importantes explicados em detalhe:

- O uso de `@Override` força o compilador a verificar se o método realmente está sobrescrevendo outro da superclasse
- Sem `@Override`, um erro de assinatura (como um parâmetro extra ou tipo incorreto) criaria um novo método, quebrando o polimorfismo sem gerar erro de compilação
- A chamada de `toString()` é implícita em métodos como `print`, `println`, concatenações de String e logs

---

### 🧾 Regras Fundamentais da Sobrescrita

Para que um método seja corretamente sobrescrito, as seguintes regras devem ser respeitadas:

- **Mesmo nome do método**
- **Mesma lista de parâmetros** (tipo, ordem e quantidade)
- **Tipo de retorno igual ou covariante**
  - Retorno covariante** permite retornar um subtipo do tipo original
- **O modificador de acesso não pode ser mais restritivo**

📌 Exemplo de violação de acesso:

- Um método `public` na superclasse **nunca** pode ser sobrescrito como `protected` ou `private` na subclasse

Essas regras garantem que o polimorfismo funcione corretamente, permitindo que um objeto seja tratado como seu tipo base sem perda de comportamento esperado

---

### 🔒 `final` em Tipos Primitivos (Constantes)

- Quando aplicado a tipos primitivos, `final` transforma a variável em uma **constante**
- Uma constante **deve ser inicializada obrigatoriamente** e não pode ser modificada depois

Exemplo:
```java
  public static final double VELOCIDADE_LIMITE = 250;
```

✅ Convenções de nomenclatura:

- Letras maiúsculas 
- Palavras separadas por `_` (snake_case)

📌 Observações importantes:

- Frequentemente combinado com `static`, pois a constante pertence à classe, não à instância
- Pode ser inicializado:
  - No momento da declaração
  - Em um bloco estático
  - No construtor (quando não for `static`)
- Após a inicialização, qualquer tentativa de alteração gera erro de compilação

---

### 🔗 `final` em Tipos de Referência

- `final` não torna o objeto imutável.
- Ele torna **imutável a referência**, ou seja, o endereço de memória apontado não pode mudar

Exemplo:
```java
  public final Comprador comprador = new Comprador();
```

❌ Não permitido:
```java
  carro.comprador = new Comprador(); // troca da referência
```

✅ Permitido:
```java
  carro.comprador.setNome("Naiara"); // alteração do estado interno
```

🧠 Conceito-chave explicado passo a passo:

- A variável **comprado** sempre apontará para o **mesmo objeto**
- O conteúdo interno desse objeto ainda pode ser modificado
- `final` protege a **ligação**, não o **estado**

📌 Uso comum desse conceito:

- Base para padrões como `Singleton`
- Prevenção de troca acidental de instâncias críticas
- Maior previsibilidade do código

---

### 🚧 `final` em Classes

Quando uma classe é declarada como `final`, ela **não pode ser estendida**

Exemplo:
```java
    public final class String {}
```

Explicação detalhada:

- Nenhuma outra classe pode usar `extends` nessa classe
- Consequentemente, nenhum método pode ser sobrescrito

🧠 Motivo de design:

- Garantir comportamento imutável e seguro.
- Evitar alterações indesejadas em classes fundamentais
- Reduzir riscos de inconsistências e falhas de segurança

📌 Exemplo clássico:

A classe `String` é `final` para assegurar que seu comportamento interno, imutabilidade e otimizações da JVM não sejam comprometidos

---

### 🛑 `final` em Métodos

Métodos declarados como `final` **não podem ser sobrescritos** pelas subclasses

Exemplo:
```java
    public final void imprime() {}
```

Comportamento explicado:

- O método pode ser herdado normalmente
- O comportamento permanece **fixo em toda a hierarquia**
- Garante que regras críticas não sejam alteradas em subclasses

⚠️ Observações importantes:

- Métodos `final` ainda participam do processo de herança
- Se a classe inteira for `final`, declarar métodos como `final` é tecnicamente redundante

---

## 🚀 Síntese Final ✅🧠

- `toString()` é chamado automaticamente ao imprimir objetos
- Sobrescrever `toString()` melhora legibilidade e depuração
- `@Override` garante sobrescrita real e segura
- `final` em tipos primitivos define constantes
- `final` em referências impede troca do objeto referenciado
- `final` em classes bloqueia herança
- `final` em métodos bloqueia sobrescrita
- Sobrescrita exige regras rigorosas de assinatura, retorno e acesso

---