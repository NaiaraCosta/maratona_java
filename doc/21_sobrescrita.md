# Sobrescrita de Métodos (Override)

A sobrescrita de métodos é um conceito fundamental da Programação Orientada a Objetos (POO) e ocorre quando uma subclasse redefine um método da sua superclasse, fornecendo uma implementação diferente para o mesmo comportamento.
A sobrescrita está diretamente relacionada ao polimorfismo, permitindo que um mesmo método tenha comportamentos diferentes dependendo do objeto que o executa.

### O que caracteriza a sobrescrita?
- O método sobrescrito deve existir na superclasse
- A subclasse fornece uma nova implementação do método
- A assinatura do método deve ser a mesma:
  - Mesmo nome
  - Mesmo tipo de retorno
  - Mesma lista de parâmetros
- O método da subclasse substitui o da superclasse em tempo de execução

### Regras importantes da sobrescrita
- O método não pode ser final
- Métodos private não podem ser sobrescritos
- O nível de acesso não pode ser mais restritivo que o da superclasse
- Recomenda-se o uso da anotação @Override
- A sobrescrita acontece apenas entre superclasse e subclasse

```java
// Superclasse
public class Animal {
    public void emitirSom() {
        System.out.println("O animal está emitindo um som.");
    }
}

// Subclasse
public class Cachorro extends Animal {

    @Override
    public void emitirSom() {
        System.out.println("O cachorro está latindo: Au au!");
    }
}

// Classe de teste
public class OverrideTest {
    public static void main(String[] args) {
        Animal animal = new Cachorro();
        animal.emitirSom(); // chama o método da subclasse
    }
}
```
### saída esperada:
```
O cachorro está latindo: Au au!
```
### Por que usar sobrescrita?
- Para especializar comportamentos herdados.
- Para permitir polimorfismo.
- Para adaptar métodos genéricos a situações específicas.
- Para tornar o código mais flexível e extensível.

### Sobrescrita × Sobrecarga (diferença rápida)

- Sobrescrita (Override) : ocorre entre classes relacionadas por herança.
- Sobrecarga (Overload): ocorre na mesma classe, com métodos de mesmo nome e parâmetros diferentes.

### Quando usar sobrescrita?
- Quando a subclasse precisa de um comportamento diferente da superclasse
- Quando existe uma clara relação “é um”
- Quando o método herdado não atende completamente a necessidade da subclasse