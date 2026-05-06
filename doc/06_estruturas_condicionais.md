# 📘 Guia — Estruturas Condicionais em Java (`if`, `else`, `else if`, `ternário` e `switch`)

Guia técnico completo sobre **controle de fluxo condicional em `Java`**, cobrindo decisões simples, múltiplas condições, avaliação booleana e escolhas estruturadas.

O objetivo deste material é explicar **como o Java toma decisões em tempo de execução**, detalhando não apenas a sintaxe, mas também o **comportamento do compilador**, as **boas práticas** e os **erros comuns** que surgem no uso de estruturas condicionais.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Estruturas condicionais** permitem que o programa **decida qual caminho executar** com base em uma **expressão `boolean`**, cujo resultado só pode ser `true` ou `false`.

Em Java, **nenhuma decisão condicional existe sem uma expressão booleana explícita**. Isso é diferente de algumas linguagens que aceitam valores numéricos como condição.

Essas estruturas são usadas constantemente para:
- validações de dados
- regras de negócio
- classificações e enquadramentos
- controle de acesso
- fluxos alternativos de execução

Neste guia são abordados:
- `if`
- `else`
- `else if`
- operador ternário `?:`
- tabela verdade (`&&`, `||`)
- `switch`
- erros comuns de escopo e inicialização de variáveis

Tudo com foco em **clareza**, **boas práticas** e **comportamento real do compilador Java**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### ✅ Estrutura Condicional `if`

A estrutura mais básica de decisão em Java.

Ela executa um bloco de código **somente se** a condição for avaliada como `true`.

📌 Características fundamentais:
- A condição deve **obrigatoriamente resultar em um `boolean`**
- O bloco associado ao `if` só será executado se a condição for verdadeira
- Caso contrário, o fluxo segue para fora do bloco

Sintaxe conceitual:
- `if (condição) { ... }`

Exemplo:
```java
    if (idade >= 18) {
        System.out.println("Maior de idade");
    }
```

📌 **Boas práticas**

- Sempre utilizar `{}` mesmo para uma única linha
- Isso evita erros ao adicionar novas instruções no futuro
- Aumenta a legibilidade e reduz bugs sutis

⚠️ **Erro comum**

Usar um valor não booleano como condição

Exemplo:
```java
    if (idade) { } // ❌ ERRO DE COMPILAÇÃO
```

Em Java, números **não representam verdadeiro ou falso** automaticamente.

---

### 🚫 Estrutura else

Representa o **caminho alternativo** quando a condição do `if` é falsa.

Regras fundamentais:

- O else sempre pertence a um `if`
- Ele não possui condição própria
- Se o `if` não for executado, o `else` **será executado obrigatoriamente**

Exemplo:
```java
    if (saldo >= valorCompra) {
        System.out.println("Compra aprovada");
    } else {
        System.out.println("Saldo insuficiente");
    }
```

📌 Diferença conceitual importante:

- `if` + `else` → **decisão binária** (sim ou não)
- Dois `if` separados → **condições independentes**

Exemplo:
```java
    if (nota >= 7) {
        System.out.println("Aprovado");
    }

    if (nota < 7) {
        System.out.println("Reprovado");
    }
```

Embora funcione, esse código **avalia duas condições** 
quando uma decisão binária seria suficiente.

---

### 🔀 Estrutura `else if`

Usada quando existem **mais de duas possibilidades**, 
todas relacionadas à mesma decisão.

Funcionamento detalhado:

- As condições são avaliadas **em ordem**
- A primeira condição avaliada como true é executada
- As demais são **ignoradas**
- No máximo um **único bloco será executado**

Exemplo:
```java
    if (nota >= 9) {
        System.out.println("Excelente");
    } else if (nota >= 7) {
        System.out.println("Bom");
    } else if (nota >= 5) {
        System.out.println("Recuperação");
    } else {
        System.out.println("Reprovado");
    }
```

✅ Ideal para:

- Categorias
- Faixas de valores
- Classificações
- Regras mutuamente exclusivas

📌 O `else` **final cobre todos os casos restantes**, 
eliminando comparações desnecessárias e tornando o código mais seguro.

---

### 🧠 Variáveis, Escopo e Inicialização

Uma das regras mais rígidas do Java:

**⚠️ Variáveis locais precisam ser inicializadas antes do uso**

Isso ocorre porque o compilador **não aceita qualquer possibilidade 
de uso de um valor indefinido**.

Exemplo:
```java
    int resultado;

    if (condicao) {
        resultado = 10;
    }

    System.out.println(resultado); // ❌ ERRO DE COMPILAÇÃO
```

Mesmo que logicamente “**sempre caia no `if`**”, o compilador não assume isso.

✅ Soluções possíveis:

- Inicializar a variável antes do `if`
- Garantir atribuição em todos os caminhos (`if`, `else if`, `else`)

Exemplo:
```java
    int resultado = 0;

    if (condicao) {
        resultado = 10;
    }
```

📌 Essa regra força o desenvolvedor 
a escrever código **determinístico e seguro**.

---

### 🔄 Operador de Negação !

O operador `!` **inverte o valor de um boolean**.

Tabela simples:

- !true → false
- !false → true

Uso recomendado:

Exemplo:
```java
    if (!autorizado) {
        System.out.println("Acesso negado");
    }
```

✅ Mais legível do que:
```java
    if (autorizado == false) { }
```

📌 Trabalhar com **lógica positiva e direta facilita a leitura**, 
especialmente em regras mais complexas.

---

### ⚠️ Atenção: Atribuição vs Comparação
Um dos erros mais comuns (especialmente em provas e entrevistas):

- = ➜ atribuição
- == ➜ comparação

Exemplo:
```java
    if (flag = false) { } // ❌
```

O que acontece aqui:

- `false` é atribuído à variável **flag**
- A expressão retorna `false`
- O bloco do `if` nunca executa

✅ Formas corretas:

Exemplo:
```java
    if (flag == false) { }
```

Ou, preferencialmente:
```java
    if (!flag) { }
```

📌 Esse erro não causa falha de compilação, apenas **comportamento 
incorreto**, o que o torna ainda mais perigoso.

---

### ⚡ Operador Ternário `?`:

Forma **compacta e inline** de um `if/else` simples.

Estrutura formal:

- condição ? valorSeTrue : valorSeFalse

Exemplo:
```java
    int maior = (a > b) ? a : b;
```
Equivale a:
```java
    int maior;
    if (a > b) {
        maior = a;
    } else {
        maior = b;
    }
```

✅ Ideal quando:

- O resultado será **atribuído diretamente**
- A lógica é curta e evidente

⚠️ Não recomendado:

- Para lógica complexa
- Para múltiplos ternários encadeados

📌 Embora seja possível encadear ternários, 
isso **prejudica drasticamente a leitura e a manutenção**.

---

### ✅ Tabela Verdade (`&&` e `||`)

Permite combinar **múltiplas condições booleanas** em uma única expressão.

Esses operadores utilizam **avaliação lógica curta (short-circuit)**, 
ou seja, a avaliação pode ser interrompida assim que o 
resultado final já puder ser determinado.

---

### ✅ Tabela Verdade (&& e ||)
Permite combinar **múltiplas condições booleanas** em uma única expressão.

Esses operadores seguem avaliação **lógica curta (short-circuit)**, ou seja, 
a avaliação pode parar antes do fim se o resultado já for conhecido.

---

### 🔗 Operador && (AND)

O resultado só será `true` **se todas as condições forem** `true`

Tabela conceitual:

- true && true → true
- Qualquer false → false

Exemplo:
```java
    if (idade >= 18 && possuiDocumento) {
        System.out.println("Entrada permitida");
    }
```

---

### 🔀 Operador || (OR)

O resultado será `true` se **pelo menos uma condição** for `true`

Tabela conceitual:

- false || false → false
- Qualquer true → true

Exemplo:
```java
    if (temConvite || listaVip) {
        System.out.println("Acesso liberado");
    }
```

📌 Regra de ouro:

- Use `&&` quando **tudo precisa ser válido**
- Use `||` quando **uma condição já basta**

---

### 🔢 Estrutura Condicional `switch`

Alternativa mais organizada para decisões 
**baseadas em valores fixos e conhecidos**.

Muito utilizada quando:

- Há muitas comparações de igualdade
- A variável analisada assume poucos valores possíveis

✅ **Tipos aceitos (Java 8):**

- `byte`, 
- `short`, 
- `int`
- `char`
- `enum`
- `String`

#### Funcionamento:

- Avalia uma expressão
- Compara o valor com os respectivos `case`
- Executa o bloco correspondente
- **Sem `break`, ocorre o fall-through** (execução contínua dos próximos `case`)

Exemplo:
```java
    switch (diaSemana) {
        case "SEGUNDA":
            System.out.println("Dia útil");
            break;
        case "SABADO":
        case "DOMINGO":
            System.out.println("Fim de semana");
            break;
        default:
            System.out.println("Dia inválido");
    }
```

#### 🧱 `break` e `default`

- `break` ➜ encerra a execução do `switch`
- Sem `break`, os próximos `case` **também executam**

##### `default`:

- Executa quando **nenhum `case` corresponde**
- Pode aparecer em qualquer posição dentro do `switch`
- Boa prática: **sempre incluir**


📌 O `default` funciona como um **`else` do `switch`**.

#### 🧠 Uso Inteligente do `switch`

O **fall-through** pode ser usado de forma **intencional e estratégica**.

Uso típico:

- Agrupar vários valores que levam ao **mesmo comportamento**

Exemplo conceitual:

- Dias úteis vs fim de semana
- Categorias equivalentes
- Estados com a mesma regra

📌 Funciona perfeitamente, mas deve ser **bem documentado**, pois pode confundir leitores menos experientes.

---

## 🚀 Síntese Final ✅🧠

- `if` executa código quando a condição é `true`
- `else` representa o caminho alternativo
- `else if` cria cadeias de decisão exclusivas
- Condições devem sempre retornar `boolean`
- Variáveis locais precisam ser inicializadas
- `!` simplifica lógica negativa
- `=` ≠ `==`
- Operador ternário substitui `if/else` simples
- `&&` exige todas as condições verdadeiras
- `||` exige apenas uma condição verdadeira
- `switch` organiza decisões baseadas em valores exatos
- `break` impede execuções indesejadas
- `default` trata cenários não previstos

---