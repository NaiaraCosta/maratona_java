## Modificador `static`

O modificador `static` em Java é usado para declarar membros de classe — ou seja, variáveis e métodos que pertencem à
classe, e não a um objeto específico.

Isso significa que esses membros são compartilhados por todas as instâncias da classe e podem ser acessados sem criar
um objeto.
___

### Atributos `static`

Quando um atributo é `static`, todas as instâncias da classe compartilham o mesmo valor dessa variável.

```java
public class Contador {
    public static int total;

    public Contador() {
        total++;
    }
}
```

```java
public class ContadorTest {
    public static void main(String[] args) {
        new Contador();
        new Contador();
        new Contador();
        System.out.println(Contador.total);
    }
}
/*
Saída:
3
*/
```

---

### Blocos `static`

Um bloco de inicialização estático é executado apenas uma vez, quando a classe é carregada pela JVM,
antes de qualquer objeto ser criado.

Ele é útil para inicializar variáveis estáticas complexas (como arrays, listas, etc).

```java
public class Anime {
    private static int[] episodios;

    /*
     * ORDEM DE INICIALIZAÇÃO (JVM):
     * 1. Blocos static {} → executados UMA VEZ (na carga da classe)
     * 2. Alocação de memória do objeto
     * 3. Atributos de instância recebem valor default
     * 4. Blocos de instância {} → executados por objeto
     * 5. Construtor é executado
     */
    static {
        System.out.println("Dentro do bloco de inicialização 1");
        episodios = new int[100];
        for (int i = 0; i < episodios.length; i++) {
            episodios[i] = i + 1;
        }
    }

    static {
        System.out.println("Dentro do bloco de inicialização 2");
    }

    static {
        System.out.println("Dentro do bloco de inicialização 3");
    }

    { // Bloco de instância
        System.out.println("Dentro do bloco de inicialização não estático");
    }

    public Anime() {
        for (int episodio : Anime.episodios) {
            System.out.print(episodio + " ");
        }
        System.out.println();
    }
}

```

```java
    public class AnimeTest {
    public static void main(String[] args) {
        Anime anime1 = new Anime();
        Anime anime2 = new Anime();
        Anime anime3 = new Anime();
    }
}
/*
Saída:
Dentro do bloco de inicialização 1
Dentro do bloco de inicialização 2
Dentro do bloco de inicialização 3
Dentro do bloco de inicialização não estático
1 2 3 4 5 ... 100
Dentro do bloco de inicialização não estático
1 2 3 4 5 ... 100
Dentro do bloco de inicialização não estático
1 2 3 4 5 ... 100
*/
```

---

### Métodos `static`

Um método estático também pertence à classe, e não precisa de um objeto para ser chamado.
Ele não pode acessar diretamente atributos ou métodos de instância, pois não existe um objeto associado a ele.

```java
public class Calculadora {
    public static int soma(int a, int b) {
        return a + b;
    }
}

public class CalculadoraTest {
    public static void main(String[] args) {
        System.out.println(Calculadora.soma(10, 5));
    }
}
/*
Saída:
15
*/
```

| Tipo                   | Pertence a | Quantas vezes é executado            | Pode acessar membros de instância? |
|------------------------|------------|--------------------------------------|------------------------------------|
| **Atributo estático**  | Classe     | Compartilhado entre todos os objetos | ❌                                  |
| **Método estático**    | Classe     | —                                    | ❌                                  |
| **Bloco estático**     | Classe     | 1 vez                                | ❌                                  |
| **Bloco de instância** | Objeto     | 1 por instância                      | ✅                                  |
