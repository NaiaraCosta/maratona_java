# 🔀 Estruturas de Controle

As estruturas de controle permitem **alterar o fluxo de execução do programa**.

💡 Com elas, é possível tomar decisões e repetir ações com base em condições.

---

## 🧠 Tipos principais

* 🔀 **Condicionais** → tomam decisões
* 🔁 **Laços de repetição** → executam blocos várias vezes

---

## 🔀 Condicionais

### 📌 if / else

Utilizado para executar blocos de código com base em condições:

```
int idade = 15;

if (idade >= 18) {
    System.out.println("Maior de idade");
} else if (idade >= 13) {
    System.out.println("Adolescente");
} else {
    System.out.println("Criança");
}
```

---

### 🔄 switch

Usado quando há várias opções baseadas em um mesmo valor.

💡 Tipos aceitos: `char`, `int`, `byte`, `short`, `enum`, `String`

```
int dia = 3;

switch (dia) {
    case 1:
        System.out.println("Domingo");
        break;
    case 2:
        System.out.println("Segunda");
        break;
    default:
        System.out.println("Outro dia");
}
```

---

### ⚡ Operador ternário

Forma reduzida de um `if-else` simples.

### 📌 Sintaxe

```
(condição) ? valorSeVerdadeiro : valorSeFalso;
```

---

### 💻 Exemplo

```
// Verifica se é par ou ímpar
int num = 10;
String tipo = (num % 2 == 0) ? "Par" : "Ímpar";
```

---

## 🔁 Laços de repetição

### 🔄 for

Ideal quando você sabe quantas vezes deseja repetir:

```
// Contar de 0 a 9
for (int i = 0; i < 10; i++) {
    System.out.println("For " + i);
}
```

---

### 🔁 while

A condição é verificada **antes da execução**.

⚠️ Pode não executar nenhuma vez se a condição for falsa.

```
// Soma dos 100 primeiros números
int count = 1;
int soma = 0;

while (count <= 100) {
    soma += count;
    count++;
}

System.out.println(soma);
```

---

### 🔁 do-while

Executa o bloco **pelo menos uma vez**, pois a condição é verificada depois.

```
int x = 5;

do {
    System.out.println("Executa pelo menos uma vez: " + x);
    x--;
} while (x > 5);
```

---

## 🚀 Resumo rápido

* 🔀 Condicionais → controlam decisões (`if`, `switch`, ternário)
* 🔁 Laços → repetem execução (`for`, `while`, `do-while`)
* ⚡ Ternário → forma reduzida de `if-else`
* ⚠️ `while` pode não executar, `do-while` executa ao menos uma vez