---
# Interfaces em Java

Uma interface em Java é um **contrato** que define um conjunto de métodos que uma classe deve implementar. Diferente das classes abstratas, interfaces **não representam uma herança de comportamento**, mas sim uma garantia de que determinadas ações estarão disponíveis.

Interfaces são amplamente utilizadas para promover **baixo acoplamento**, **flexibilidade** e **polimorfismo**.

---

## Quando usar interfaces?
- Quando diferentes classes precisam ter o mesmo comportamento
- Quando não há relação direta de herança entre as classes
- Para definir contratos
- Para permitir herança múltipla de comportamento
- Para desacoplar implementações

---

## Declarando uma interface

```java
public interface Animal {
    void emitirSom();
}
```
---
## Implementando uma interface
```java
public class Cachorro implements Animal {

    @Override
    public void emitirSom() {
        System.out.println("O cachorro está latindo.");
    }
}
```
Uso: 
```java
public class InterfaceTest {
    public static void main(String[] args) {
        Animal animal = new Cachorro();
        animal.emitirSom();
    }
}
```
---
## Características das interfaces
- Métodos são implicitamente public e abstract
- Atributos são implicitamente public static final
- Não possuem construtores
- Não podem ser instanciadas
- Podem ser implementadas por várias classes
- Uma classe pode implementar várias interfaces
---
## Métodos em interfaces (Java 8+)
### Métodos `default`
permitem implementação padrão dentro da interface.
```java
public interface Animal {
    default void dormir() {
        System.out.println("O animal está dormindo.");
    }
}
```
### Métodos `static`
pertencem à interface e não a classe que a implementa.
```java
public interface Util {
    static void mostrarMensagem() {
        System.out.println("Mensagem da interface.");
    }
}
```
### Métodos private (Java 9+).
Usados para reutilização interna dentro da interface.

---
## Interface × Classe abstrata
- Interface define contratos
- Classe abstrata pode fornecer implementação
- Uma classe pode implementar várias interfaces
- Uma classe só pode estender uma classe abstrata
- Interfaces não possuem atributos de instância
---