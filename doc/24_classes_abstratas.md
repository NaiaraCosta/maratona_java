---
# Classes Abstratas em Java

Uma classe abstrata em Java é uma classe que **não pode ser instanciada** e serve como um **modelo base** para outras classes. Ela é utilizada quando se deseja definir **comportamentos comuns**, deixando parte da implementação para as subclasses.

Classes abstratas são muito usadas em conjunto com **herança** e **polimorfismo**.

---

## Quando usar classes abstratas?
- Quando existe uma relação clara do tipo **“é um”**
- Quando várias classes compartilham comportamentos comuns
- Quando parte do comportamento deve ser obrigatoriamente implementado pelas subclasses
- Quando faz sentido fornecer implementação base

---

## Declarando uma classe abstrata

```java
public abstract class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public void dormir() {
        System.out.println(nome + " está dormindo.");
    }
}
```
---
## Métodos abstratos
Métodos abstratos são métodos sem implementação, declarados apenas com a assinatura.
Eles devem ser implementados pelas subclasses concretas.
```java
public abstract class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public abstract void emitirSom();
}
```
---
## Implementando uma classe abstrata
```java
public class Cachorro extends Animal {

    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("O cachorro está latindo.");
    }
}
```
Uso:
```java
public class AbstractTest {
    public static void main(String[] args) {
        Animal animal = new Cachorro("Rex");
        animal.emitirSom();
    }
}
```
---
## Características das classes abstratas
- Não podem ser instanciadas
- Podem conter métodos abstratos e métodos concretos
- Podem conter atributos e construtores
- Podem ter métodos final, static e private
- Podem implementar interfaces
- Uma classe pode estender apenas uma classe abstrata
---
## Regras importantes
Uma classe que possui pelo menos um método abstrato deve ser abstrata
- Subclasses concretas devem implementar todos os métodos abstratos
- Métodos abstratos não podem ser `final`
- Métodos abstratos não podem ser `private`
- Métodos abstratos não podem ser `static`
---
## Classe abstrata × Interface
- Classe abstrata pode conter implementação
- Interface define apenas contratos (até Java 7)
- Uma classe pode implementar várias interfaces
- Uma classe só pode estender uma classe abstrata
- Classes abstratas permitem atributos de instância
---
## Boas práticas com classes abstratas
- Use quando houver comportamento comum real
- Evite criar classes abstratas sem métodos abstratos (salvo exceções)
- Prefira interfaces quando não houver implementação compartilhada
- Nomeie classes abstratas de forma clara e semântica
---