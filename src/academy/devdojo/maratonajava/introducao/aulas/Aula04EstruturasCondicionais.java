package academy.devdojo.maratonajava.introducao.aulas;

public class Aula04EstruturasCondicionais {

    // !  -> NEGAÇÃO

    static void main(String[] args) {
        int idade = 15;
        boolean isAutorizadoComprarBebiba = idade >= 18;

        if (isAutorizadoComprarBebiba) {
            System.out.println("Autorizado a comprar bebida alcólica");
        }

        if (!isAutorizadoComprarBebiba) {
            System.out.println("Não Autorizado a comprar bebida alcólica");
        }

        boolean c = false;

        if (c) {
            System.out.println("Dentro de algo que nunca deve ser feito");
        }

        System.out.println("Fora do if");


        // idade < 15 categoria infantil
        // idade >= 15 && idade < 18 categoria juvenil
        // idade >=18 categoria adulto
        int idade1 = 10000;
        String categoria;

        if (idade1 < 15) {
            categoria = "Categoria Infantil";
        } else if (idade >= 15 && idade < 18) {
            categoria = "Categoria Juvenil";
        } else {
            categoria = "Categoria Adulto";
        }
        // categoria = idade < 15 ? "Categoria Infantil" : idade >= 15 && idade < 18 ? "Categoria Juvenil" : "Categoria Adulto";

        System.out.println(categoria);


        // Doar se salario > 5000
        double salario = 6000;

        //(condicao) ? verdadeiro : falso
        String resultado = salario > 5000 ? "Eu vou doar 500 pro DevDojo" : "Ainda não tenho condições, mas vou ter!";

        System.out.println(resultado);

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
    }

}