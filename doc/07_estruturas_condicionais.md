# **Estruturas de Controle**

Estruturas de controle em hava são elementos que permitem alterar
o fluxo de execução do programa, como condicionais (if, else,
switch) e laços de repetição (for, while, do-while).
Elas controlam decisões e repetições com base em condições.

##### **Condicionais**

**if-else**

    int idade = 15;

    if(idade >=18){
        System.out.println("Maior de idade");
    } else if(idade >=13){
        System.out.println("Adolescente");
    }else{
        System.out.println("Criança");
    }

**switch**

    // O switch aceita dados dos tipos: char, int, byte, short, enum, String
    byte dia = 5;    
    int dia = 3;
    switch(dia){
        case 1:
            System.out.println("Domingo");
            break;
        case 2:
            System.out.println("Segunda");
            break;
        default:
        System.out.println("Outro dia");
    }

**Operador ternário**

O operador ternário é uma forma compacta de substituir um if-else simples,
ideal para atribuir valores com base em uma condição.

    // Sintaxe:
    (condição)?valorSeVerdadeiro :valorSeFalso;

    // Verifica se é par ou ímpar
    int num = 10;
    String tipo = (num % 2 == 0) ? "Par" : "Ímpar";

##### **Laço de repetição**

**for**

    // Contar de 0 a 10
    for(int i = 0; i< 10;i++){
        System.out.println("For "+i);
    }

**while**

A condição é verificada antes de executar o bloco.
Se for falsa desde o início, o código pode não rodar nenhuma vez.

    // Imprimir a soma dos 100 primeiros números
    int count = 1;
    int soma = 0;
    while(count <=100){
        soma +=count;
        count++;
    }
    System.out.println(soma);

**do-while**

O bloco é executado pelo menos uma vez, porque a condição só é testada depois.

    int x = 5;
    do{
        System.out.println("Executa pelo menos uma vez: "+x);
        x--;
    }while(x >5);