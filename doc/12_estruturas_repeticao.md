# 📘 Guia Completo — Estruturas de Repetição em Java

Este guia apresenta as principais **estruturas de repetição em Java**, explicando como executar blocos de código múltiplas vezes, controlar o fluxo das iterações e interromper ou pular ciclos quando necessário.

---

## 🧠 Resumo

Estruturas de repetição permitem que um programa **execute o mesmo bloco de código várias vezes**, com base em uma condição.

Em Java, as principais estruturas são:

* `while`
* `do while`
* `for`
* Controle de fluxo com `break`
* Controle de fluxo com `continue`

---

## 🔂 Estrutura de Repetição

### 🔁 WHILE

O `while` executa um bloco de código **enquanto** uma condição for verdadeira.

#### 📌 Conceito

* A condição é verificada **antes** da execução
* Se a condição for falsa desde o início, o bloco **não executa nenhuma vez**
* A condição deve retornar **boolean**

#### 📌 Sintaxe básica

```java
    while (condicao) {
        // código executado enquanto a condição for true
    }
```

#### ⚠️ Ponto de atenção

A variável de controle *precisa ser alterada dentro do laço*
Caso contrário, o loop será *infinito*

### 🔁 DO WHILE

O do while é semelhante ao while, mas com uma diferença importante.

#### 📌 Conceito

* O bloco é executado *pelo menos uma vez*
* A condição é verificada *após* a execução

#### 📌 Sintaxe básica

```java
    do {
        // código executado pelo menos uma vez
    } while (condicao);
```

---

### 🧠 Diferença principal

* `while` → Pode executar zero vezes
* `do while` → Executa no *mínimo uma vez*

---

### 🔢 FOR

O for é a estrutura mais utilizada quando se sabe quantas vezes o laço deve executar.

#### 📌 Conceito

* Muito usado para contagens e índices
* Possui três partes bem definidas

#### 📌 Sintaxe básica

```java
    for (inicializacao; condicao; incremento) {
        // código executado a cada iteração
    }
```

#### 🧠 Partes do for

* Inicialização (int i = 0)
* Condição (i < 10)
* Incremento/decremento (i++)

---

## 🚫 Controle de Fluxo

### 🚫 BREAK

O break é usado para interromper completamente um laço de repetição.

#### 📌 Conceito

* Encerra o loop imediatamente
* Ignora qualquer código restante no laço
* Deve estar dentro de um *loop* ou *switch*

#### 📌 Uso comum

```java
    for (int i = 0; i <= 50; i++) {
        if (i > 25) {
            break;
        }
        System.out.println(i);
    }
```   

#### ⚠️ Observações importantes

* O break *não encerra apenas o if*
* Ele *sai do laço mais externo*
* Usado para evitar processamento desnecessário

### 🔀 CONTINUE

O continue é o *oposto do break*.

#### 📌 Conceito

* Interrompe apenas a *iteração atual*
* O loop continua na próxima repetição
* Ignora o código que está abaixo dentro da mesma iteração

#### 📌 Exemplo conceitual

```java
    for (int i = 1; i <= 50; i++) {
        if (i < 25) {
            continue;
        }
        System.out.println(i);
    }
```   

#### 🧠 Comportamento

Quando o *continue* é alcançado:

* O restante da iteração é ignorado
* O laço continua normalmente

---

### 🧠 Comparação: BREAK vs CONTINUE

#### 📌 BREAK

* Encerra o laço completamente
* Sai do loop
* Usado quando a condição final já foi atingida

#### 📌 CONTINUE

* Pula apenas a iteração atual
* Continua o loop
* Usado para ignorar casos indesejados

---

## 🧠 Conceitos finais

* Estruturas de repetição evitam código duplicado
* *while* testa a condição antes
* *do while* executa ao menos uma vez
* *for* é ideal para contagens
* *break* encerra loops prematuramente
* *continue* ignora apenas a iteração atual
* Controle de fluxo melhora performance e legibilidade

---

## 🚀 Resumo final

* Repetições são fundamentais na programação
* Laços permitem automatizar tarefas repetitivas
* Variáveis de controle evitam loops infinitos
* *break* e *ontinue* refinam o fluxo de execução
* Código bem controlado é mais eficiente e limpo
* Entender o comportamento do loop evita bugs críticos

---