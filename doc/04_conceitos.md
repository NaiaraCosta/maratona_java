# **Sintaxe Básica**

## **Tipos de Dados**

##### **Tipos primitivos: armazenam valores simples diretamente na memória**

- byte – números inteiros pequenos (-128 a 127)
- short – inteiros curtos (-32.768 a 32.767)
- int – inteiros comuns
- long – inteiros longos
- float – números decimais de precisão simples
- double – números decimais de dupla precisão
- char – caracteres únicos (como 'A')
- boolean – valores lógicos (true ou false)
- Referência: armazenam endereços de objetos (como String, arrays e classes personalizadas)

  ![variaveispng.png](img/variaveis.png)

  ![tabela_ascii.jpg](img/tabela_ascii.jpg)

##### Variáveis**

Uma variável é um espaço na memória para armazenar um valor.

A sintaxe básica é: tipo nomeDaVariavel = valor;

Exemplos:

- int idade = 25;
- double salario = 3500.50;
- boolean ativo = true;
- String nome = "João";

##### **Operadores**

- Aritméticos: +, -, *, /, %
- Comparação: ==, !=, <, >, <=, >=
- Lógicos: &&, ||, !
- Atribuição: =, +=, -=, *=, /=
- Incremento/Decremento: ++, --

Exemplos:

int a = 10;

int b = 5;

**System.out..println(a +b); // 15**

**System.out.println(a >b); // true**

## **Principais Convenções de Nomenclatura de Pacotes**

-Domínio Invertido: Inicie com com, org, edu, ou código de país (br, us),
seguido pelo domínio da empresa/autor (ex: com.google, br.com.empresa).

-Letras Minúsculas: Use apenas minúsculas para evitar conflitos com nomes de classes.

-Separação: Utilize pontos "." para separar os níveis hierárquicos,
o que reflete a estrutura de pastas no sistema de arquivos.

-Nome do Projeto/Recurso: Após o domínio, adicione o nome do projeto
e o subpacote funcional (ex: br.com.meuprojeto.model, com.empresa.service).
