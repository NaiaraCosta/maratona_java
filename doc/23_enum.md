---
# `enum` em Java

O `enum` (enumeration) em Java é um tipo especial de classe utilizado para representar um **conjunto fixo de constantes**. Ele é muito usado quando um valor só pode assumir **opções previamente definidas**, tornando o código mais seguro, legível e fácil de manter.

Enums evitam o uso excessivo de constantes (`static final`) espalhadas pelo código e reduzem erros causados por valores inválidos.

---

## Quando usar `enum`?
- Quando existe um conjunto fixo de valores possíveis
- Para representar estados, tipos ou categorias
- Para evitar valores inválidos
- Para deixar o código mais legível e semântico

---

## Exemplo simples de `enum`

```java
public enum DiaSemana {
    SEGUNDA,
    TERCA,
    QUARTA,
    QUINTA,
    SEXTA,
    SABADO,
    DOMINGO
}
```
##  Uso do `enum`:
```java
public class EnumTest {
    public static void main(String[] args) {
        DiaSemana dia = DiaSemana.SEXTA;
        System.out.println(dia);
    }
}
```
---
## Características do enum
- É implicitamente public static final 
- Herda de java.lang.Enum 
- Não pode herdar de outra classe 
- Pode implementar interfaces
- Pode conter atributos, métodos e construtores 
- Construtores de enum são sempre private
---
## `enum` com atributos e contrutor
```java
public enum NivelAcesso {
    ADMIN(1),
    USUARIO(2),
    CONVIDADO(3);

    private int codigo;

    NivelAcesso(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
```
Uso:
```java
NivelAcesso nivel = NivelAcesso.ADMIN;
System.out.println(nivel.getCodigo());
```
---
## Métodos comuns de `enum`
- values() → retorna todos os valores do enum
- valueOf(String) → converte uma String em um enum
- name() → retorna o nome da constante
- ordinal() → retorna a posição da constante (evite usar)
Exemplo:
```java
for (DiaSemana dia : DiaSemana.values()) {
    System.out.println(dia);
}
```
---
`enum` em estruturas de controle
```java
public class EnumSwitchTest {
    public static void main(String[] args) {
        DiaSemana dia = DiaSemana.DOMINGO;

        switch (dia) {
            case SABADO:
            case DOMINGO:
                System.out.println("Fim de semana");
                break;
            default:
                System.out.println("Dia útil");
        }
    }
}
```
---
## Boas práticas com `enum`
- Use nomes em MAIÚSCULO para as constantes
- Evite usar ordinal()
- Prefira enum a constantes soltas
- Use atributos e métodos quando necessário
---