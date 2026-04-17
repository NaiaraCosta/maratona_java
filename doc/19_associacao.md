# Associação

A **associação** é um tipo de relacionamento entre classes onde uma classe **usa** ou **conhece** a outra, mas uma não depende da existência da outra para existir.

Ou seja: os objetos são **independentes**, apenas se relacionam para cumprir alguma funcionalidade.

## O que caracteriza a associação?

- Uma classe possui uma **referência** a outra
- As classes **podem existir separadamente**
- Representa um relacionamento do tipo **“usa um”**
- Pode ser **unidirecional** ou **bidirecional**

## Exemplo simples de associação

```java
public class Professor {
    private String nome;

    public Professor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
```

```java
public class Escola {
    private Professor professor; // Associação

    public Escola(Professor professor) {
        this.professor = professor;
    }

    public void mostrarProfessor() {
        System.out.println(professor.getNome());
    }
}
```

```java
public class EscolaTest {
public static void main(String[] args) {
Professor professor = new Professor("Carlos");
Escola escola = new Escola(professor);

        escola.mostrarProfessor();
    }
}
/*
Saída:
Carlos
*/
```