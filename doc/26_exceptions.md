# Throwables em Java

## Hierarquia

`Throwable` é a classe raiz de tudo relacionado a erros e exceções em Java. Toda exceção ou erro que pode ser lançado em Java herda dela.

```
Throwable
├── Error
└── Exception
    └── RuntimeException
```

---

## Error

Representa problemas **graves e irrecuperáveis** na JVM (Java Virtual Machine). Não são causados pelo código da aplicação, mas por problemas no ambiente de execução.

**Características:**
- Não devem ser capturados ou tratados pelo programador
- O compilador não exige tratamento
- Quando ocorre, geralmente o programa não tem como se recuperar

**Exemplos comuns:**
- `StackOverflowError` — ocorre quando há recursão infinita e a pilha de chamadas estoura
- `OutOfMemoryError` — ocorre quando a JVM fica sem memória heap

---

## Exception (Checked Exception)

Representa situações **previsíveis e recuperáveis** que podem ocorrer durante a execução do programa. São chamadas de *checked* porque o compilador **te obriga** a tratá-las.

**Características:**
- O compilador exige que sejam tratadas com `try/catch` ou declaradas com `throws`
- Representam situações externas ao programa (arquivos, rede, banco de dados)
- O programador deve antecipar e tratar esses cenários

**Exemplos comuns:**
- `IOException` — erro ao ler/escrever arquivos
- `SQLException` — erro ao acessar banco de dados
- `FileNotFoundException` — arquivo não encontrado

**Exemplo de tratamento obrigatório:**
```java
try {
    FileReader file = new FileReader("arquivo.txt");
} catch (FileNotFoundException e) {
    System.out.println("Arquivo não encontrado: " + e.getMessage());
}
```

---

## RuntimeException (Unchecked Exception)

Representa **erros de lógica do programador**. São chamadas de *unchecked* porque o compilador **não te obriga** a tratá-las — mas elas podem interromper o programa em tempo de execução.

**Características:**
- O compilador não exige tratamento
- Geralmente indicam bugs no código que devem ser corrigidos, não tratados
- Responsabilidade do programador evitá-las com código correto

**Exemplos comuns:**
- `NullPointerException` — tentar acessar um objeto que é `null`
- `ArrayIndexOutOfBoundsException` — acessar um índice inválido de um array
- `ClassCastException` — tentar converter um objeto para um tipo incompatível
- `ArithmeticException` — divisão por zero

---

## Resumo

| Tipo | Causa | Compilador exige tratamento? | Deve tratar? |
|---|---|---|---|
| `Error` | Problema grave na JVM | Não | Não |
| `Exception` | Situação externa previsível | **Sim** | Sim |
| `RuntimeException` | Erro de lógica do programador | Não | Evitar com código correto |