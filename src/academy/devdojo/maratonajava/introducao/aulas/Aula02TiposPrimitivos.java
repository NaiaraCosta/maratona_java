package academy.devdojo.maratonajava.introducao.aulas;

/*
public class Aula02TiposPrimitivos {
    // int, double, float, char, byte, short, long, boolean
    public static void main(String[] args) {
        int idade = 10;
        System.out.println("A idade é " + idade + " anos");
    }
}
*/

/*
public class Aula02TiposPrimitivos {
    // int, double, float, char, byte, short, long, boolean
    public static void main(String[] args) {
        int idade = 10;
        long numeroGrande = 100000;
        double salarioDouble = 2000;
        float salarioFloat = 2500;
        byte idadeByte = -128;
        short idadeShort = 10;
        boolean verdadeiro = true;
        boolean falso = false;
        char caractere = '\u0041';  // UNICODE
        char character = 87;        // ASCII

        System.out.println("A idade é "+idade+" anos");
        System.out.println(falso);
        System.out.println("char: " + caractere);
        System.out.println("char_1: " + character);
    }
}
*/

/*
public class Aula02TiposPrimitivos {
    // int, double, float, char, byte, short, long, boolean
    public static void main(String[] args) {
        int idade = (int) 10000000000L;
        long numeroGrande = (long) 155.23;
        double salarioDouble = 2000.0D;
        float salarioFloat = (float) 2500.0D;
        byte idadeByte = 127;
        short idadeShort = 32000;
        boolean verdadeiro = true;
        boolean falso = false;
        char caractere = '\u0041';  // UNICODE
        char character = 87;        // ASCII

        System.out.println("A idade é "+idade+" anos");
        System.out.println(falso);
        System.out.println("char: " + caractere);
        System.out.println("char_1: " + character);
        System.out.println(numeroGrande);
    }
}
*/

public class Aula02TiposPrimitivos {

    // int, double, float, char, byte, short, long, boolean
    static void main(String[] args) {
        int idade = (int) 10000000000L;
        long numeroGrande = (long) 155.23;
        double salarioDouble = 2000.0D;
        float salarioFloat = (float) 2500.0D;
        byte idadeByte = 127;
        short idadeShort = 32000;
        boolean verdadeiro = true;
        boolean falso = false;
        char caractere = '\u0041';  // UNICODE
        char character = 87;        // ASCII

        String nome = "Goku";

        System.out.println("A idade é " + idade + " anos");
        System.out.println(falso);
        System.out.println("char: " + caractere);
        System.out.println("char_1: " + character);
        System.out.println(numeroGrande);
        System.out.println("Oi meu nome é " + nome);
    }

}