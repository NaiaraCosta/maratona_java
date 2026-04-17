## Sobrecarga

A sobrecarga permite definir vários métodos com o mesmo nome em uma mesma classe, desde que possuam listas de
parâmetros diferentes em número, tipo ou ordem.

```java
public class Calculadora {

    // Soma dois inteiros
    public int somar(int a, int b) {
        return a + b;
    }

    // Sobrecarga: soma três inteiros
    public int somar(int a, int b, int c) {
        return a + b + c;
    }

    // Sobrecarga: soma dois números de ponto flutuante
    public double somar(double a, double b) {
        return a + b;
    }

    // como utilizar no main
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println(calc.somar(2, 3));        // Saída: 5
        System.out.println(calc.somar(2, 3, 4));     // Saída: 9
        System.out.println(calc.somar(2.5, 3.7));    // Saída: 6,2
    }
}
```
