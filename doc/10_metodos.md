# 📘 Guia — Orientação a Objetos em Java: Métodos (Do Básico ao Avançado)

Documento técnico consolidado sobre **métodos em `Java`**, cobrindo definição, parâmetros, retorno, `void`, passagem por valor vs referência, uso de `this`, `varargs` e boas práticas aplicadas.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Métodos representam o comportamento das classes**. Enquanto atributos descrevem o estado, métodos definem **ações executadas por um objeto**.  
Neste guia, você verá como métodos são declarados, chamados e executados no contexto de um objeto, além de entender:

- Diferença entre **retorno** e **saída**
- Uso de `void` vs métodos com retorno
- Parâmetros e argumentos
- Passagem de valores **primitivos** e por **referência**
- Uso correto do `this`
- `varargs` (`...`)
- Armadilhas comuns e boas práticas

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Estrutura Básica de um Método
Um método em `Java` possui:

- **Modificador de acesso** (`public`, `private`, etc.)
- **Tipo de retorno** (`void` ou um tipo)
- **Nome do método**
- **Parâmetros** (opcional)
- **Corpo** (`{}`)

Exemplo:
```java
    public void somaDoisNumeros() {
        System.out.println(10 + 10);
    }
```

🔎 **Importante:**

- retorno ≠ `System.out.println`
- `void` **indica nenhum valor retornado**

---

### ▶️ Execução de Métodos

Métodos são executados **a partir de um objeto**:

Exemplo:
```java
    Calculadora calc = new Calculadora();
    calc.somaDoisNumeros();
```

📌 Diferença essencial:

- **Atributos**: obj.atributo = valor
- **Métodos**: obj.metodo()

---

### 🧮 Parâmetros e Argumentos

- **Parâmetros**: definidos no método
- **Argumentos**: valores passados na chamada

Exemplo:
```java
    public void multiplica(int num1, int num2) {
        System.out.println(num1 * num2);
    }
    
    calc.multiplica(10, 20);
```

📎 Regra crítica:
**Todo parâmetro deve ter tipo + identificador**

❌ Errado:
```java
    int a, b;
```

✅ Certo:
```java
    int a, int b;
```

---

### 🔁 Métodos com Retorno

Métodos podem retornar valores com `return`.

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
O tipo de retorno define **o que pode ser recebido** por quem chama.

---

### 🚨 Validações com return

`return` **encerra o método imediatamente**.

Exemplo:
```java
    public double divide(double a, double b) {
        if (b == 0) {
            return 0;
        }
        return a / b;
    }
```

✅ Mais limpo que `if/else` extensos
✅ Evita execuções inválidas

---

### 🛑 return em Métodos void
Mesmo métodos `void` podem usar `return` sem valor, 
como um `break` **de método**:

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

---

### 🧬 Parâmetros Primitivos (Passagem por Valor)

Tipos primitivos (`int`, `double`, etc.) são **copiados**.

Exemplo:
```java
    public void alteraNumeros(int a, int b) {
        a = 99;
        b = 33;
    }
```

📌 O valor original **não é alterado** no método chamador.
✅ **Sempre passa uma cópia**

---

### 🔗 Parâmetros por Referência (Objetos)

Objetos são passados por **referência**.

Exemplo:
```java
    public void imprime(Estudante e) {
        System.out.println(e.nome);
    }
```

📌 Alterações no método:

- ✅ Afetam o objeto original
- ⚠️ Podem gerar efeitos colaterais

🔒 **Boa prática**: evitar alterar estado do objeto recebido

---

### 🧭 Palavra-Chave this

`this` referencia o objeto atual.

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

✅ Melhora clareza
✅ Evita ambiguidades
✅ Indica acesso a **atributos do objeto**

---

### 🧺 varargs — Parâmetros Variáveis

Permite receber **quantidade variável de argumentos**:

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

📌 Regras:
... sempre no **último parâmetro**
Internamente, é tratado como um `array`

---

## 🚀 Síntese Final ✅🧠

- **Métodos definem comportamento**
- `void` não retorna valor
- `return` encerra o método
- Parâmetros ≠ argumentos
- Tipos primitivos → **cópia**
- Objetos → **referência**
- `this` aponta para o objeto atual
- `varargs` simplifica múltiplos argumentos
- Validações evitam erros como `NullPointerException`

---