package academy.devdojo.maratonajava.introducao.aulas;

public class Aula06Arrays {

    public static void main(String[] args) {
        int[] idades = new int[3];
        System.out.println(idades[1]);
        idades[0] = 21;
        idades[1] = 15;
        idades[2] = 11;
        System.out.println(idades);
        System.out.println(idades[0]);
        System.out.println(idades[1]);
        System.out.println(idades[2]);

        // byte, short, int, long, float e double 0
        // char '\u0000' ' '
        // boolean false
        // String null

        String[] nomes = new String[3];
        nomes[0] = "Goku";
        nomes[1] = "Kurosaki";
        nomes[2] = "Luffy";
        // nomes[3] = "Hinata";

        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);
        }

        int[] numeros = new int[3];
        int[] numeros2 = {1, 2, 3, 4, 5};
        int[] numeros3 = new int[]{5, 4, 3, 2, 1};

        for (int i = 0; i < numeros2.length; i++){
            System.out.println(numeros2[i]);
        }

        // for (int i = 0; i < numeros2.length; i++){
        //     System.out.println(numeros3[i]);
        // }

        // for each (variavel local de referencia : array)
        for (int num : numeros3) {
            System.out.println(num);
        }
    }

}