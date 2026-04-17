## Construtores

Construtores em Java são métodos especiais usados para inicializar objetos ao criá-los com a palavra-chave new. Eles
têm o mesmo nome da classe, não possuem tipo de retorno (nem mesmo void) e são executados automaticamente no momento da
instanciação. Servem para garantir que o objeto comece em um estado válido, permitindo a atribuição inicial de valores
aos atributos por meio de parâmetros. Por exemplo, um construtor pode receber nome e idade de um aluno e já definir
esses dados ao criar o objeto, promovendo encapsulamento e evitando estados inconsistentes.

```java
// Classe Aluno com construtor
public class Aluno {
    private String nome;
    private int idade;

    // Construtor
    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método para exibir os dados
    public void exibir() {
        System.out.println("Aluno: " + nome + ", Idade: " + idade);
    }

    // Método main para testar
    public static void main(String[] args) {
        // Criando um objeto usando o construtor
        Aluno aluno1 = new Aluno("Maria", 20);

        // Exibindo os dados
        aluno1.exibir(); // Saída: Aluno: Maria, Idade: 20
    }
}
```