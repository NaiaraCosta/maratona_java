# 📘 Guia — Estruturas de Repetição em Java (`while`, `do while`, `for`, `break`, `continue`)

Documento técnico introdutório sobre **laços de repetição em `Java`**, explicando funcionamento, sintaxe, armadilhas comuns e exercícios práticos aplicados ao dia a dia de desenvolvimento.

As estruturas de repetição são fundamentais para automatizar tarefas repetitivas, percorrer coleções de dados e implementar algoritmos de forma eficiente e controlada.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Estruturas de repetição** permitem que um mesmo bloco de código seja executado diversas vezes **enquanto uma condição for satisfeita**.

Em `Java`, os principais laços são:
- `while`
- `do while`
- `for`

Além disso, existem comandos auxiliares que controlam o fluxo interno desses laços:
- `break`
- `continue`

Todos os laços dependem de **expressões booleanas (`boolean`)**, ou seja, condições que resultam em `true` ou `false`.  
Outro ponto crítico é a **alteração do estado das variáveis de controle**, pois sem essa mudança a condição pode nunca se tornar falsa, gerando **loops infinitos**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🔁 `while` — Laço com condição prévia

O laço `while` executa um bloco de código **enquanto a condição for verdadeira**.

Características principais:
- A condição é avaliada **antes** da execução do bloco
- A condição deve resultar em um `boolean`
- Se a condição iniciar como `false`, o bloco **não executa nenhuma vez**

Sintaxe geral:
```java
    while (condicao) {
        // bloco de código
    }
```

📌 Funcionamento conceitual:

- Uma variável de controle é inicializada antes do laço
- A condição testa essa variável
- Dentro do bloco, a variável é modificada para evitar loop infinito

**Exemplo conceitual:**

- Contador inicia em `0`
- Condição: count < `10`
- Incremento obrigatório dentro do bloco (`count++` ou `count += 1`)

Exemplo:
```java
    while (condicao) {
        // bloco de código
    }
```

⚠️ **Risco comum**

Esquecer de alterar a variável de controle ➜ loop infinito

---

### 🔂 do while — Execução garantida

O laço `do while` é semelhante ao `while`, porém com uma diferença essencial:
o bloco de código é executado **pelo menos uma vez, independente da condição inicial**.

Características:

A condição é avaliada após a execução do bloco
Garantia de ao menos uma execução

Sintaxe geral:
```java
    do {
        // bloco de código
    } while (condicao);
```

Exemplo:
```java
    int tentativa = 1;

    do {
        System.out.println("Tentativa: " + tentativa);
        tentativa++;
    } while (tentativa <= 3);
```

✅ Útil em cenários específicos onde **uma execução inicial é obrigatória**, como:

- Exibição de menus
- Leitura inicial de entrada do usuário

⚠️ Uso menos comum no mercado, mas importante para compreensão completa do controle de fluxo.

---

### 🔢 for — Laço indexado

O laço `for` é o mais utilizado em Java, especialmente para:

- Contagens
- Percorrimento de `arrays`
- Iteração sobre listas e coleções

Sua principal vantagem é concentrar **toda a lógica de controle em um único ponto**.

Estrutura composta por **3 partes**:

1. Inicialização (executada uma única vez)
2. Condição (avaliada antes de cada iteração)
3. Incremento ou decremento (executado ao final de cada iteração)

Sintaxe geral:
```java
    for (inicializacao; condicao; incremento) {
        // bloco de código
    }
```

Exemplo:
```java
    for (int i = 0; i < 10; i++) {
        System.out.println(i);
    }
```

📌 Por convenção, utilizam-se:

- i, j, k como variáveis de índice em laços simples

✅ O `for` melhora a legibilidade ao deixar explícito:

- Onde começa
- Onde termina
- Como evolui a repetição

---

### ⛔ break — Interrupção imediata

O comando `break` interrompe **imediatamente** a execução do laço em que se encontra.

Características:

- Encerra `for`, `while` e `do while`
- Também é utilizado em `switch`
- Não encerra apenas o `if`, mas sim o laço externo

Exemplo:
```java
    for (int i = 1; i <= 50; i++) {
        if (i > 25) {
        break;
        }
        System.out.println(i);
    }
```

✅ Ideal para:

- Parar o processamento ao atingir um objetivo
- Economizar recursos computacionais
- Evitar execuções desnecessárias

📍 No exemplo acima, o laço poderia ir até 50, mas é interrompido ao chegar em 25.

---

### 🔁 continue — Pular iteração

O comando continue não encerra o laço, apenas:

Ignora o restante do código da **iteração atual**
Retorna imediatamente para a próxima iteração

Exemplo:
```java
    for (int i = 1; i <= 10; i++) {
        if (i % 2 != 0) {
            continue;
        }
        System.out.println(i);
    }
```

Nesse caso:

Números ímpares são ignorados
Apenas os pares são impressos

✅ Útil quando:

Parte do processamento deve ser ignorada sob certas condições
Existem operações custosas que não devem rodar sempre

📌 Muito comum para **filtros dentro de loops grandes**.

---

## 🚀 Síntese Final ✅🧠

- `while` executa enquanto a condição for true
- `do while` executa pelo menos uma vez
- `for` é ideal para contagens e índices
- `break` interrompe completamente o laço
- `continue pula apenas a iteração atual
- Todos os loops exigem **controle explícito de estado**
- Falhas nesse controle causam **loops infinitos**
- Pensar em **regras de negócio futuras** gera código mais sustentável
- Uso consciente de `break` e continue melhora **performance, clareza e legibilidade**

---