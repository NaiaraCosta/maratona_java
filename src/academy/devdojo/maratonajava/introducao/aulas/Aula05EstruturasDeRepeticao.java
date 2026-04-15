package academy.devdojo.maratonajava.introducao.aulas;

public class Aula05EstruturasDeRepeticao {

    static void main(String[] args) {
        // while, do while, for
        int count = 0;
        while (count < 10) {
            System.out.println(++count);
        }

        count = 0;
        while (count < 10) {
            System.out.println(count++);
        }

        count = 0;
        do {
            System.out.println("dentro do do-while " + ++count);
        } while (count < 10);

        for (int i = 0; i < 10; i++) {
            System.out.println("For " + i);
        }


        // Imprima os primeiros 25 numeros de um dado valor. Por exemplo, 50
        int valorMax = 50;
        for (int i = 0; i <= valorMax; i++) {
            if (i > 25) {
                break;
            }

            System.out.println(i);
        }
    }

}