package academy.devdojo.maratonajava.javacore.Bintroducaometodos.teste;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Pessoa;

public class PessoaTeste01 {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        // pessoa.nome = "jiraya";
        pessoa.setNome("Jiraya");
        pessoa.setIdade(70);
        pessoa.imprime();
        // System.out.println(pessoa.getNome());
        // System.out.println(pessoa.getIdade());
    }

}