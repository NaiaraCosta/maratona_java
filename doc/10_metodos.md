# 📘 Guia — Orientação a Objetos em Java: Métodos (Do Básico ao Avançado)

Documento técnico consolidado sobre **métodos em `Java`**, cobrindo definição, parâmetros, retorno, `void`, passagem por valor vs referência, uso de `this`, `varargs` e boas práticas aplicadas.

Este material aprofunda o entendimento de como **métodos organizam o comportamento** das classes, explicando não apenas a sintaxe, mas também o **fluxo de execução**, o **contrato de retorno** e as **implicações de memória** envolvidas.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Métodos representam o comportamento das classes**.  
Enquanto **atributos** descrevem o estado de um objeto, métodos definem **ações que podem ser executadas** por esse objeto ao longo de sua vida útil.

Neste guia, você verá como métodos são **declarados**, **chamados** e **executados** no contexto de um objeto, além de entender:

- Diferença entre **retorno** e **saída**
- Uso de `void` vs métodos com retorno
- Parâmetros e argumentos
- Passagem de valores **primitivos** e por **referência**
- Uso correto do `this`
- `varargs` (`...`)
- Armadilhas comuns e boas práticas

📌 Entender métodos é essencial para escrever código:
- Reutilizável
- Legível
- Coeso
- Seguro contra efeitos colaterais

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Estrutura Básica de um Método

Um método em `Java` é composto por diversos elementos bem definidos:

- **Modificador de acesso** (`public`, `private`, `protected`)
- **Tipo de retorno** (`void` ou um tipo concreto)
- **Nome do método** (verbo ou ação)
- **Parâmetros** (opcional)
- **Corpo** do método (`{}`)

Exemplo:
```java
    public void somaDoisNumeros() {
        System.out.println(10 + 10);
    }
```

🔎 **Importante:**

- `return` ≠ `System.out.println`
- `System.out.println` apenas **exibe saída**
- `void` **indica que nenhum valor é retornado ao chamador**

📌 Um método void executa uma ação, mas não produz um valor reutilizável.

---

### ▶️ Execução de Métodos

Métodos **não executam sozinhos**.

Eles são **executados a partir de um objeto**, por meio de uma variável de referência.

Exemplo:
```java
    Calculadora calc = new Calculadora();
    calc.somaDoisNumeros();
```

## 📌 Diferença essencial:

- **Atributos:** `obj.atributo = valor`
- **Métodos:** `obj.metodo()`

➡️ O operador `.` indica **acesso ao conteúdo e comportamento** do objeto.

---

### 🧮 Parâmetros e Argumentos

- **Parâmetros:** definidos na assinatura do método
- **Argumentos:** valores fornecidos na chamada do método

Exemplo:
```java
    public void multiplica(int num1, int num2) {
        System.out.println(num1 * num2);
    }
    calc.multiplica(10, 20);
```

📎 **Regra crítica:** Todo parâmetro **deve declarar seu tipo e seu identificador**.

Exemplo errado:
```java
    int a, b;
```

Exemplo certo:
```java
    int a, int b;
```

📌 A assinatura do método define **exatamente** como ele deve ser chamado.

---

### 🔁 Métodos com Retorno

Métodos podem **retornar valores** usando a palavra-chave `return`.

Exemplo:
```java
    public double divide(double a, double b) {
        return a / b;
    }
```

Uso:
```java
    double resultado = calc.divide(20, 2);
```

📌 **Contrato do método:**

- O tipo de retorno define o **tipo do valor produzido**.
- Quem chama o método deve respeitar esse contrato.

✅ Métodos com retorno permitem:

- Reutilização do resultado
- Composição de expressões
- Encadeamento lógico

---

### 🚨 Validações com `return`
A instrução `return` **encerra imediatamente o método**, mesmo que existam linhas abaixo.

Exemplo:
```java
    public double divide(double a, double b) {
        if (b == 0) {
            return 0;
        }
        return a / b;
    }
```

✅ Vantagens:

- Código mais limpo
- Menos aninhamentos desnecessários
- Evita execuções inválidas

- 📌 Essa técnica é conhecida como *early return*.

---

### 🛑 `return` em Métodos `void`

Mesmo métodos `void` podem usar `return` sem valor, funcionando como um freio de execução.

Exemplo:
```java
    public void imprimeDivisao(double a, double b) {
        if (b == 0) {
            System.out.println("Não existe divisão por zero");
            return;
        }
        System.out.println(a / b);
    }
```

📌 Conceitualmente:

- `return` em `void` ≈ `break` de método
- Interrompe o fluxo antes do final

---

### 🧬 Parâmetros Primitivos (Passagem por Valor)

Tipos primitivos (`int`, `double`, `boolean`, etc.) são passados por valor.

Exemplo:
```java
    public void alteraNumeros(int a, int b) {
        a = 99;
        b = 33;
    }
```

📌 O que acontece:

- O método recebe cópias dos valores.
- O valor original fora do método não é alterado.

✅ Regra absoluta: **Tipos primitivos sempre passam uma cópia.**

---

### 🔗 Parâmetros por Referência (Objetos)
Objetos são passados por **referência** (mais precisamente, a referência é copiada).

Exemplo:
```java
    public void imprime(Estudante e) {
        System.out.println(e.nome);
    }
```

📌 Implicações:

- Alterações no objeto afetam o original.
- A referência aponta para o mesmo objeto em memória.

⚠️ Risco:
- Efeitos colaterais involuntários.

🔒 Boa prática:
- Evitar modificar o estado de objetos recebidos como parâmetro.
- Priorizar métodos que apenas consultam dados (read-only).

---

### 🧭 Palavra-Chave `this`
`this` representa o objeto atual que está executando o método.

Exemplo:
```java
    public class Estudante {
        String nome;
        int idade;
    
        public void imprime() {
            System.out.println(this.nome);
            System.out.println(this.idade);
        }
        
    }
```
 
Benefícios do uso de `this`:

- Evita ambiguidades.
- Deixa explícito que o acesso é a um atributo do objeto.
- Torna o código mais legível e pedagógico.
📌 `this` é especialmente útil quando parâmetros têm o mesmo nome dos atributos.
 
---

## 🧺 `varargs` — Parâmetros Variáveis

`varargs` permite receber um número variável de argumentos.

Exemplo:
```java
    public void somaVarArgs(int... numeros) {
        int soma = 0;
        for (int n : numeros) {
            soma += n;
        }
        System.out.println(soma);
    }
```

Uso:
```java
    calc.somaVarArgs(1, 2, 3, 4, 5);
```

📌 Regras importantes:
- `...` deve estar **no último parâmetro**.
- Internamente, o `varargs` é tratado como um array.

✅ Simplifica chamadas
✅ Evita sobrecarga excessiva de métodos

---

## 🚀 Síntese Final ✅🧠

- **Métodos definem comportamento**
- `void` indica ausência de retorno
- `return` encerra o método imediatamente
- Parâmetros ≠ argumentos
- Tipos primitivos são passados por **cópia**
- Objetos são passados por **referência**
- `this` aponta para o objeto atual
- `varargs` simplifica múltiplos argumentos
- Validações antecipadas evitam erros como `NullPointerException`

---