# Herança

A **herança** é um dos pilares da Programação Orientada a Objetos (POO) e permite que uma classe (chamada **subclasse** ou **classe filha**) herde atributos e métodos de outra classe (chamada **superclasse** ou **classe mãe/pai**).

A ideia principal é promover **reutilização de código** e estabelecer uma relação **“é um”**.

## O que caracteriza a herança?

- A subclasse **herda** atributos e métodos da superclasse
- Relação do tipo **“é um”** (is-a)
- Promove **reutilização** e **extensibilidade** de código
- A subclasse pode:
    - Usar diretamente membros públicos/protegidos da superclasse
    - Sobrescrever (override) métodos
    - Adicionar novos atributos e métodos
- Geralmente implementada com a palavra-chave `extends` (Java)

## Exemplo simples de herança

```java
// Superclasse (classe mãe)
public class Animal {
    protected String nome;
    protected int idade;

    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void comer() {
        System.out.println(nome + " está comendo...");
    }

    public void dormir() {
        System.out.println(nome + " está dormindo...");
    }

    public String getNome() {
        return nome;
    }
}
```

```java
// Subclasse (classe filha)
public class Cachorro extends Animal {
    private String raca;

    public Cachorro(String nome, int idade, String raca) {
        super(nome, idade); // chama o construtor da superclasse
        this.raca = raca;
    }

    // Sobrescrita (override) de método
    @Override
    public void comer() {
        System.out.println(nome + " está comendo ração...");
    }

    // Método específico da subclasse
    public void latir() {
        System.out.println(nome + " está latindo: Au au!");
    }

    public String getRaca() {
        return raca;
    }
}
```

```java
public class HerancaTest {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Rex", 5, "Labrador");

        System.out.println("Nome: " + cachorro.getNome());
        System.out.println("Raça: " + cachorro.getRaca());
        
        cachorro.comer();    // método sobrescrito
        cachorro.dormir();   // método herdado
        cachorro.latir();    // método específico
    }
}
/*
Saída esperada:
Nome: Rex
Raça: Labrador
Rex está comendo ração...
Rex está dormindo...
Rex está latindo: Au au!
*/
```

## Tipos importantes de herança

- Herança simples: Uma classe filha herda de apenas uma superclasse (Java suporta apenas esse tipo)
- Herança múltipla: Uma classe herda de mais de uma superclasse (Java não suporta diretamente, mas simula com interfaces)

## Quando usar herança?

- Quando existe uma clara relação “é um”
- Quando você quer reutilizar atributos e comportamentos comuns
- Quando faz sentido sobrescrever ou estender comportamentos
- Evite herança apenas para reutilizar código (prefira composição quando possível)

## Resumo rápido

| Característica              | Herança              |
|-----------------------------|----------------------|
| Tipo de relação             | É um (is-a)          |
| Reutilização de código      | ✅ Alta               |
| Possibilidade de override   | ✅ Sim                |
| Suporte a herança múltipla  | ❌ Não (em Java)      |
| Acoplamento                 | Alto                 |
| Uso recomendado             | Com moderação        |