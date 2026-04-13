package academy.devdojo.maratonajava.introducao;

public class Aula02TiposPrimitivos {

    public static void main(String[] args) {
        int age = 15;
        long bigNumber = 2000;
        double salaryDouble = 2000.0;
        float salaryFloat = 2500.0f;
        byte ageByte = -128;
        short ageShort = 10;
        boolean verdadeiro = true;
        boolean falso = false;
        char character = 65;

        String string = "Texto deve ser colocado dentro de aspas duplas em uma string";

        System.out.println("A idade é "+age+" anos");
        System.out.println(falso);
        System.out.println("char "+character);
        System.out.println(age);
        System.out.println(string+". Para concatenar com outra strin voce deve adicionar '+'.");
    }

}