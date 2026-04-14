# **Casting**

Conversão de um tipo de dado para outro, pode ser implícito (automático, de menor para maior tipo)
ou explícito (manual, de maior para menor):

**Widening Casting (Automático)**

Converte um tipo menor para um tipo maior. Ocorre automaticamente.
    
    byte -> short -> char -> int -> long -> float -> double

    Exemplos: int meuInt = 9; double meuDouble = meuInt

**Narrowing Casting (Explícito)**

Converte um tipo maior para um tipo menor.

Deve ser feito manualmente colocando o tipo entre parênteses ().

    double -> float -> long -> int -> char -> short -> byte

    Exemplos: double -> double meuDouble = 9.78; int meuInt = (int) meuDouble

**Casting de Objetos (Upcasting e Downcasting)**
  
Upcasting: Converter subclasse para superclasse (automático).

Downcasting: Converter superclasse para subclasse (explícito/manual).
             Risco de ClassCastException se a instância não for compatível.