# Modificador `final`
O modificador `final` em Java é utilizado para restringir alterações em variáveis, métodos e classes. Seu principal
objetivo é garantir segurança, imutabilidade e controle de comportamento, evitando modificações indesejadas no código.

Dependendo do contexto, o `final` pode impedir:
- Reatribuição de valores
- Sobrescrita de métodos
- Herança de classes

---
## Onde o modificador `final` pode ser usado?
- Em variáveis
- Em métodos
- Em classes
---
## `final` em variáveis
Quando uma variável é declarada como final, seu valor não pode ser alterado após a inicialização.

## Características
- Deve ser inicializada uma única vez
- Funciona como uma constante
- Muito usada com static final

## Exemplo
```java
public class ExemploFinalVariavel {
    public static final int MAX_USUARIOS = 100;

    public static void main(String[] args) {
        // MAX_USUARIOS = 200; // Erro de compilação
        System.out.println(MAX_USUARIOS);
    }
}
```
---
## `final` em métodos
Quando um método é declarado como final, ele não pode ser sobrescrito pelas subclasses.

## Características
- Mantém o comportamento original do método
- Garante consistência em heranças
- Muito usado em métodos críticos

## Exemplo
```java
public class Animal {
    public final void dormir() {
        System.out.println("O animal está dormindo.");
    }
}

public class Cachorro extends Animal {
    // Erro: não é possível sobrescrever método final
    // public void dormir() { }
}
```
---
## `final` em classes
Quando uma classe é declarada como final, ela não pode ser herdada.

## Características
- Impede a criação de subclasses
- Garante que o comportamento da classe não será alterado
- Comum em classes utilitárias e imutáveis
```java
public final class Utilitaria {
    public static void mostrarMensagem() {
        System.out.println("Classe utilitária.");
    }
}

// Erro: não é possível herdar de uma classe final
// public class Teste extends Utilitaria { }
```
---
## Restrições importantes do `final`
- Classes final não podem ser herdadas
- Métodos final não podem ser sobrescritos
- Variáveis final não podem ser reatribuídas
- Um método final ainda pode ser sobrecargado
- final não impede o uso de polimorfismo, apenas limita alterações
---
## `final` x `static`
- `final`: impede modificação
- `static`: pertence à classe, não ao objeto
- `static final`: constante compartilhada por toda a aplicação