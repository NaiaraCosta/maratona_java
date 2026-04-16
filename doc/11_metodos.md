## Métodos

É um bloco de cógido que define um comportamento ou ação que um objeto pode executar. Ele é declarado numa
classe e pode receber parametros, executar instruções e opcionalmente retornar um valor.

```java
public class Carro {
    public String nome;
    public String modelo;
    public int ano;

    // método sem retorno (void)
    public void exibir() {
        System.out.println(nome + " " + modelo + " - Ano: " + ano);
    }

    // Método com PARÂMETROS e RETORNO.
    // O tipo de retorno é int, indicado antes do nome do método.
    // O método calcularIdade faz: anoAtual - ano
    // Neste caso: 2025 - 2023 = 2
    public int calcularIdade(int anoAtual) {
        return anoAtual - ano;
    }
}
```

```java
public class Principal {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        carro1.nome = "Hyundai";
        carro1.modelo = "HB20";
        carro1.ano = 2023;

        // Chamando o método com parâmetro e armazenando o retorno.
        int idade1 = carro1.calcularIdade(2025);
        // Imprimir no terminal o nome, modelo e idade do carro.
        // Saída esperada:
        // Hyundai HB20 tem 2 anos.
        System.out.println(carro1.nome + " " + carro1.modelo + " tem " + idade1 + " anos.");
    }
}
```