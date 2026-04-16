# Polimorfismo
Polimorfismo é um dos pilares da programação orientada a objetos e permite que um mesmo método ou objeto apresente
comportamentos diferentes dependendo do contexto. Isso quer dizer que podemos tratar objetos de classes diferentes da
maneira uniforme, desde que compartilhem uma mesma superclasse ou implementem a mesma interface.

Em java, o polimorfismo ocorre principalmente de duas formas: **Sobrecarga(Overloading)** e **Sobrescrita(Overriding)**.
A sobrecarga acontece quando criamos vários métodos com o mesmo nome, mas com parâmetros diferentes, dentro da mesma 
classe.

A sobrecarga é resolvida em tempo de compilação(polimorfismo estático).
```java
public class Calculadora{
    public int somar(int a, int b) {
        return a + b;
    }
    
    public double somar(double a, double b) {
        return a + b;
    }
}
```
Nesse caso, o método `somar` tem duas versões. O compilador vai decidir qual método chamar com base nos tipos dos 
argumentos passados.

No caso da sobrescrita é resolvida em tempo de execução. Isso acontece quando usamos herança
```java
class Animal {
    public void emitirSom() {
        System.out.println("O animal faz um som.");
    }
}

class Cachorro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("O cachorro late.");
    }
}

class Gato extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("O gato mia.");
    }
}
```
Em pratica: 
```java
public class Teste {
    public static void main(String[] args) {
        Animal a1 = new Cachorro();
        Animal a2 = new Gato();

        a1.emitirSom();
        a2.emitirSom();
    }
}
```

Mesmo que as variaveis sejam do tipo `Animal`, o método executado será o da classe(`Cachorro` ou `Gato`).Isso acontece 
porque em tempo de execuçãp o Java identidifica o tipo real do objeto e chama o método sobrescrito correspondente.

O polimorfismo traz maior flexibilidade, reutilização de codigo e facilidade de manutenção.