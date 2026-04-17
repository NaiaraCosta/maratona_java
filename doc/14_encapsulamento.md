## Encapsulamento

O encapsulamento em Java é um princípio da programação orientada a objetos que consiste em ocultar os detalhes internos
de uma classe, expondo apenas o necessário por meio de métodos públicos (getters e setters).

### Getter e Setter

``` java
public class Aluno {
    private String nome;
    private int numeroAluno;
    
    public String getNome() {
        return nome;
    }
    
    public int getNumeroAluno() {
        return numeroAluno;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setNumeroAluno(int numeroAluno) {
        this.numeroAluno = numeroAluno;
    }
}    
```
