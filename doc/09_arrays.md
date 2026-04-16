## **Arrays**

São estruturas de dados que armazenam vários valores do mesmo tipo em uma única variável.
Cada valor é acessado por um índice numérico, começando em 0.

![array.png](img/array.png)

// Declara e inicializa um array de inteiros
int[] numeros = {10, 20, 30, 40};
System.out.println("Números dentro do array: ");

// O for-each percorre todos os elementos do array automaticamente
for(int num :numeros){
    System.out.println(num);
}

// O for tradicional usa índices para acessar cada elemento
for(int i = 0;i<numeros.length;i++){
    System.out.println(numeros[i]);
}
##### **Arrays Multidimensionais**

Um array multidimensional é um array que contém outros arrays.
O tipo mais comum é o array bidimensional, que pode ser visualizado como uma tabela
(linhas e colunas).


![array_1.png](img/array_1.png)

// Declara e inicializa um array bidimensional (matriz)
int[][] matriz = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
                 };

// Exibe os elementos da matriz usando for convencional
System.out.println("Elementos da matriz(for):");
for(int i = 0; i<matriz.length;i++){
    for(int j = 0; j<matriz[i].length;j++){
        System.out.print(matriz[i][j]+" ");
    }
    System.out.println();
}

// Exibe os elementos da matriz usando for-each
System.out.println("Elementos da matriz (usando for-each):");
for(int[] linha :matriz){
    for(int elemento :linha){
        System.out.print(elemento +" ");
    }
    System.out.println();
}
