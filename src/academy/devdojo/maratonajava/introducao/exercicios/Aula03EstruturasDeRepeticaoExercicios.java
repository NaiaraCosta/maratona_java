package academy.devdojo.maratonajava.introducao.exercicios;

public class Aula03EstruturasDeRepeticaoExercicios {

    public static void main(String[] args) {
        // Imprima todos os números pares de 0 até 1000000
        for (int i = 1; i <= 1000000; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }


        // Imprima os primeiros 25 numeros de um dado valor. Por exemplo, 50
        int valorMax = 50;
        for (int i = 0; i <= valorMax; i++) {
            if (i > 25) {
                break;
            }

            System.out.println(i);
        }


        // Dado o valor de um carro, descubra em quantas ele pode ser parcelado
        // Condição valorParcela >= 1000
        double valorTotal = 30000;
        for (int parcela = 1; parcela <= valorTotal; parcela++) {
            double valorParcela = valorTotal / parcela;
            if (valorParcela < 1000) {
                break;
            }
            System.out.println("Parcela " + parcela + " R$ " + valorParcela);
        }


        // Dado o valor de um carro, descubra em quantas ele pode ser parcelado
        // Condição valorParcela >= 1000
        double valorTotal1 = 30000;
        for (int parcela = (int) valorTotal1; parcela >= 1; parcela--) {
            double valorParcela = valorTotal1 / parcela;
            if (valorParcela < 1000) {
                continue;
            }
            System.out.println("Parcela " + parcela + " R$ " + valorParcela);
        }

    }
}