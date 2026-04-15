package academy.devdojo.maratonajava.introducao.exercicios;

/*
Prática: Crie variáveis para os campos descritos abaixo entre <> e imprima a seguinte mensagem:

Eu, <nome>, morando no endereço <endereço>, confirmo que recebi o salário de <salario>, na data <data>
 */

public class Aula01TiposPrimitivosExercicios {

    static void main(String[] args) {
        String nome = "Kirito";
        String endereco = "Av. Joao das galileias, 257";
        String dataRecebimentoSalario = "20/12/2021";

        double salario = 5431.12;

        String relatorio = "Eu,  " + nome + ", morando no endereço " + endereco + " " +
                ", confirmo que recebi o salário de " + salario + ", na data " + dataRecebimentoSalario;

        System.out.println(relatorio);
    }

}