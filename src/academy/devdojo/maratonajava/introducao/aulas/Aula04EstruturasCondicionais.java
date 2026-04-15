package academy.devdojo.maratonajava.introducao.aulas;

public class Aula04EstruturasCondicionais {

    // !  -> NEGAÇÃO

    public static void main(String[] args) {
        int idade = 15;
        boolean isAutorizadoComprarBebiba = idade >= 18;

        if (isAutorizadoComprarBebiba) {
            System.out.println("Autorizado a comprar bebida alcólica");
        }

        if (!isAutorizadoComprarBebiba) {
            System.out.println("Não Autorizado a comprar bebida alcólica");
        }

        boolean c = false;

        if (c == true) {
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
    }

}