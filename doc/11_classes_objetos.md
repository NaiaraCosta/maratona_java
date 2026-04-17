# **Orientação a objeto**

Orientação a Objetos (OO) em Java é um paradigma de programação que organiza o código
em torno de "objetos" em vez de funções ou lógica pura,
modelando entidades do mundo real com atributos (características) e métodos (comportamentos).

Baseia-se em quatro pilares fundamentais (Encapsulamento, Herança, Polimorfismo e Abstração)
para criar sistemas modulares, reutilizáveis e fáceis de manter.


![oo.png](assets/oo.png)



**Classes**

Uma **classe** é um modelo usado para representar um objeto do mundo real. Ela define as **propriedades**
(chamadas de **atributos**) e os **comportamentos** (chamados de **métodos**) que os **objetos criados a partir dela**
terão.

public class Carro {

    // Define os atributos da classe
    public String nome;
    public String modelo;
    public int ano;

    public void exibir() {
        System.out.println(nome + " " + modelo + " - Ano: " + ano);
    }
}
##### **Objetos**

Um objeto é uma ocorrência real de uma classe, com dados próprios (atributos preenchidos) e capaz de realizar ações
(chamar métodos).

public class Principal {
    public static void main(String[] args) {
        // Instanciar o objeto carro1
        Carro carro1 = new Carro();
        // Atribuir valores para os atributos da classe
        carro1.nome = "Hyundai";
        carro1.modelo = "HB20";
        carro1.ano = 2023;

        // Instanciar o objeto carro2
        Carro carro2 = new Carro();
        // Atribuir valores para os atributos da classe
        carro2.nome = "Renault";
        carro2.modelo = "C3";
        carro2.ano = 2022;

    }
}
##### **Resumo: Classe vs Objeto**


| Conceito      | Descrição                                                        |
| ------------- | ------------------------------------------------------------------ |
| **Classe**    | É o modelo ou estrutura que define atributos e comportamentos.    |
| **Objeto**    | É uma instância concreta de uma classe com valores próprios.    |
| **Atributos** | São as características do objeto (ex: nome, modelo, ano).        |
| **Métodos**  | São as ações que o objeto pode executar (ex: exibir, acelerar). |
