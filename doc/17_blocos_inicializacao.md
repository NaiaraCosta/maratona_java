## Blocos de Inicialização

Em Java, **blocos de inicialização** são trechos de código usados para **executar instruções de configuração** antes que
o objeto ou a classe sejam utilizados.  
Eles servem para **inicializar variáveis** ou executar algum código automaticamente, **sem precisar chamar um método
explicitamente**.

Existem dois tipos de blocos de inicialização:

---

### 🔹 1. Bloco de inicialização de instância

É executado **toda vez que um objeto é criado**, **antes** do construtor.

```java
public class Exemplo {
    private int numero;

    // Bloco de inicialização de instância
    {
        numero = 10;
        System.out.println("Bloco de instância executado!");
    }

    public Exemplo() {
        System.out.println("Construtor executado!");
    }

    public static void main(String[] args) {
        new Exemplo();
    }
    /*
    Saída:
        Bloco de instância executado!
        Construtor executado!
*/
}
```

---

### 🔹 2. Bloco de inicialização estático

É executado apenas uma vez, quando a classe é carregada pela JVM (antes de qualquer objeto ser criado ou método
estático ser chamado).

```java
public class Configuracao {
    static {
        System.out.println("Bloco estático executado!");
    }

    public static void main(String[] args) {
        System.out.println("Main executado!");
    }
}
/*
    Saída:
        Bloco estático executado!
        Main executado!
*/
```

---

| Tipo          | Quando é executado                   | Quantas vezes | Usado para                      |
|---------------|--------------------------------------|---------------|---------------------------------|
| **Instância** | Ao criar cada novo objeto            | Várias vezes  | Inicializar atributos de objeto |
| **Estático**  | Quando a classe é carregada pela JVM | Uma vez       | Inicializar variáveis estáticas |
