package academy.devdojo.maratonajava.introducao.exercicios;

public class Aula02EstruturasCondicionaisExercicios {

    public static void main(String[] args) {

        // Dado um determinado salário anual,
        // calcule o valor do imposto de renda a ser pago,
        // considerando as seguintes faixas:
        double salarioAnual = 70000;
        double primeiraFaixa = 9.70 / 100;
        double segundaFaixa = 37.35 / 100;
        double terceiraFaixa = 49.50 / 100;
        double valorImposto;

        if (salarioAnual <= 34712) {
            valorImposto = salarioAnual * primeiraFaixa;
        } else if (salarioAnual >= 34713 && salarioAnual <= 68507) {
            valorImposto = salarioAnual * segundaFaixa;
        } else {
            valorImposto = salarioAnual * terceiraFaixa;
        }

        System.out.println(valorImposto);


        // Imprima o dia da semana, considerando 1 como domingo
        byte dia = 10;
        // char, int, byte, short, enum, String
        switch (dia) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Ter");
                break;
            case 4:
                System.out.println("Qua");
                break;
            case 5:
                System.out.println("Qui");
                break;
            case 6:
                System.out.println("Sex");
                break;
            case 7:
                System.out.println("Sab");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }


        String sexo = "F";
        switch (sexo) {
            case "M":
                System.out.println("Homem");
                break;
            case "F": {
                System.out.println("Mulher");
                break;
            }
            default:
                System.out.println("Inválido");
                break;
        }


        // Utilizando switch e dados os valores de 1 a 7,
        // imprima se é dia útil ou final de semana
        // Considerando 1 como domingo
        byte dia1 = 6;
        switch (dia1) {
            case 1:
            case 7:
                System.out.println("FDS");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("Dia útil");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

}