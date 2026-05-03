# 📘 Guia — Estruturas Condicionais em Java (`if`, `else`, `else if`, `ternário` e `switch`)

Guia técnico completo sobre **controle de fluxo condicional em `Java`**, cobrindo decisões simples, múltiplas condições, avaliação booleana e escolhas estruturadas.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Estruturas condicionais** permitem que o programa **decida qual caminho executar** com base em uma **expressão `boolean`** (`true` ou `false`).  
Elas são usadas constantemente para validações, regras de negócio, classificações e lógica de decisão.

Neste guia são abordados:
- `if`
- `else`
- `else if`
- operador ternário `?:`
- tabela verdade (`&&`, `||`)
- `switch`
- erros comuns de escopo e inicialização

Tudo com foco em **clareza**, **boas práticas** e **comportamento real do compilador**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### ✅ Estrutura Condicional `if`

A estrutura mais básica de decisão.

- Executa um bloco **apenas se** a condição for `true`
- A condição deve **obrigatoriamente retornar `boolean`**

Sintaxe conceitual:
- `if (condição) { ... }`

📌 **Boas práticas**
- Sempre utilizar `{}` mesmo para uma única linha
- Evita bugs e melhora a legibilidade

⚠️ **Erro comum**
- Usar um valor não booleano como condição (`if (idade)` ❌)

---

### 🚫 Estrutura `else`

Representa o **caso contrário** do `if`.

Regras fundamentais:
- `else` **sempre pertence a um `if`**
- Se o `if` não for executado, o `else` **sempre será**

📌 Diferença importante:
- `if` + `else` = **decisão binária**
- Dois `if` separados = **condições independentes**

---

### 🔀 Estrutura `else if`

Usada quando existem **mais de duas possibilidades**, baseadas na **mesma condição**.

Funcionamento:
- As condições são avaliadas **em cadeia**
- Quando uma é `true`, as demais **não são avaliadas**

✅ Ideal para:
- Categorias
- Faixas de idade
- Classificações

📌 **O `else` final cobre todos os casos restantes**, muitas vezes dispensando comparações extras.

---

### 🧠 Variáveis, Escopo e Inicialização

Importante regra do `Java`:

⚠️ **Variáveis locais devem ser inicializadas antes do uso**

- O compilador **não permite acesso a valores não garantidos**
- Mesmo que logicamente “sempre caia em um `if`”, o compilador exige segurança total

✅ Soluções:
- Inicializar antes do `if`
- Garantir cobertura total com `else`

---

### 🔄 Operador de Negação `!`

Inverte um valor `boolean`.

Uso recomendado:
- `if (!autorizado) { ... }`

✅ Mais legível do que:
- `if (autorizado == false)`

📌 Trabalhar com lógica **positiva** torna o código mais claro.

---

### ⚠️ Atenção: Atribuição vs Comparação

Erro clássico (comum em provas):

- `=` ➜ **atribuição**
- `==` ➜ **comparação**

Exemplo perigoso:
- `if (flag = false)` ❌  
  Isso **atribui** `false` e retorna `false`

✅ Correto:
- `if (flag == false)`
- ou `if (!flag)`

---

### ⚡ Operador Ternário `?:`

Forma **compacta** de um `if/else` simples.

Estrutura:
- `condição ? valorSeTrue : valorSeFalse`

✅ Ideal quando:
- O resultado será **atribuído diretamente a uma variável**
- Apenas **uma decisão simples**

⚠️ Não recomendado:
- Para lógica complexa
- Para múltiplas condições encadeadas

📌 Embora seja possível “encadear” ternários, isso **prejudica drasticamente a leitura**.

---

### ✅ Tabela Verdade (`&&` e `||`)

Define o resultado final de expressões com múltiplas condições.

#### 🔗 Operador `&&` (AND)

- Resultado `true` **somente se todas forem `true`**

Qualquer `false` ➜ resultado `false`

#### 🔀 Operador `||` (OR)

- Resultado `true` se **pelo menos uma for `true`**

Somente todas `false` ➜ resultado `false`

📌 Regra de ouro:
- Use `&&` quando **tudo precisa ser válido**
- Use `||` quando **uma condição já basta**

---

### 🔢 Estrutura Condicional `switch`

Alternativa mais organizada para decisões **baseadas em valores fixos**.

✅ Tipos aceitos (Java 8):
- `byte`, `short`, `int`
- `char`
- `enum`
- `String`

Funcionamento:
- Avalia o valor
- Executa o `case` correspondente
- **Sem `break`, ocorre fall-through** (execução contínua)

---

### 🧱 `break` e `default`

- `break` ➜ encerra o `switch`
- Sem `break`, os próximos `case` também executam

`default`:
- Executado quando **nenhum `case` corresponde**
- Pode estar em qualquer posição
- Boa prática: sempre usar

---

### 🧠 Uso Inteligente do `switch`

O **fall-through** pode ser usado estrategicamente.

Exemplo conceitual:
- Agrupar vários `case` que executam a **mesma lógica**
- Muito útil para classificações (ex: dia útil vs fim de semana)

📌 Funciona, mas deve ser **bem documentado** para evitar confusão.

---

## 🚀 Síntese Final ✅🧠

- `if` executa código quando a condição é `true`
- `else` cobre o caso contrário
- `else if` cria cadeias de decisão
- Condições devem retornar `boolean`
- Variáveis locais precisam ser inicializadas
- `!` simplifica lógica negativa
- `=` ≠ `==`
- Operador ternário simplifica `if/else` simples
- `&&` exige todas as condições verdadeiras
- `||` exige apenas uma verdadeira
- `switch` organiza decisões baseadas em valores fixos
- `break` evita execuções indesejadas
- `default` trata entradas não previstas

---