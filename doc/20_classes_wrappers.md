# 📘 Guia — Classes Utilitárias no Java: Wrappers, Boxing e Unboxing

Documento introdutório sobre **classes utilitárias `Wrapper` em Java**, explicando conceitos fundamentais, motivação, regras de uso e os mecanismos de **`autoboxing`** e **`unboxing`**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 O Java é uma linguagem **orientada a objetos**, ou seja, todo o seu design foi pensado para trabalhar com **objetos**, **classes**, **herança**, **interfaces** e **polimorfismo**.  
Apesar disso, a linguagem mantém **tipos primitivos** (`int`, `double`, `boolean`, etc.) por razões históricas e de **performance**, e esses tipos **não são objetos**.

Esse contraste gera um problema conceitual e prático:  
como usar valores primitivos em um ecossistema totalmente baseado em objetos?

Para resolver essa lacuna, o Java fornece as **classes `Wrapper`**, que **encapsulam tipos primitivos em objetos**, permitindo que esses valores se comportem como qualquer outro objeto do sistema.

Essas classes permitem:
- Tratar valores primitivos como **objetos completos**
- Utilizar **métodos utilitários** associados aos tipos
- Permitir **passagem por referência**
- Trabalhar com **estruturas do pacote de coleções**
- Integrar primitivas a **APIs OO**, **threads** e **mecanismos de sincronização**

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 O que são Wrappers?

Wrappers são **classes que representam tipos primitivos como objetos**.

Cada tipo primitivo possui uma classe `Wrapper` correspondente, cuja responsabilidade é **encapsular um valor primitivo dentro de um objeto**, adicionando comportamento (métodos) e permitindo que esse valor seja tratado como referência.

📌 Tipos primitivos e seus Wrappers:

- `byte` → `Byte`
- `short` → `Short`
- `int` → `Integer` (**exceção**)
- `long` → `Long`
- `float` → `Float`
- `double` → `Double`
- `char` → `Character` (**exceção**)
- `boolean` → `Boolean`

➡️ Regra geral: **mesmo nome do tipo primitivo com a primeira letra maiúscula**, exceto `int` e `char`, que se tornam `Integer` e `Character`.

`int` é apenas um valor numérico na memória
`Integer` é um objeto que contém um `int` dentro e oferece métodos para manipulá-lo

#### 🧬 Relação com Orientação a Objetos

- Tipos primitivos **não herdam de** `Object`
- `Wrappers` **são objetos reais** e herdam direta ou indiretamente de `Object`
- Todas as classes numéricas `Wrapper` herdam de `Number`

Exemplo de hierarquia simplificada:
```text
    Object
     ├── Number
     │    ├── Byte
     │    ├── Short
     │    ├── Integer
     │    ├── Long
     │    ├── Float
     │    └── Double
     ├── Character
     └── Boolean
```

Isso permite:

- Uso de **polimorfismo**
- Criação de **métodos genéricos**
- Chamada de **métodos utilitários**
- Uso em **APIs orientadas a objetos**

💡 Exemplo conceitual:

- Um método que recebe `Number` pode aceitar qualquer wrapper numérico, algo impossível com tipos primitivos

#### ⚠️ Diferença Crítica: Valor vs Objeto

Essa é uma das diferenças mais importantes para evitar erros de lógica.

- Tipos primitivos seguem regras fixas de **tamanho em memória**
- Wrappers seguem regras de **herança, identidade e polimorfismo**

📌 Exemplo conceitual:
- Um `int` pode ser atribuído a um `long` por conversão implícita
- Um `Integer` **não é** um `Long`, mesmo que contenham valores compatíveis

```java
    int x = 10;
    long y = x; // válido
    
    Integer a = 10;
    // Long b = a; // inválido
```

➡️ Ao usar `Wrappers`, **não existe conversão automática baseada em tamanho**

As regras passam a ser **orientação a objetos**, não aritmética

#### 🔄 Autoboxing e Unboxing

Esses mecanismos foram introduzidos no Java 5 para reduzir verbosidade

##### 📦 Autoboxing

Conversão automática de **tipo primitivo → Wrapper**

Exemplo conceitual:
- `int` → `Integer`

Exemplo prático:
```java
    Integer numero = 10; // autoboxing
```

Internamente, o Java executa algo equivalente a:
C

➡️ O compilador faz isso automaticamente quando um contexto exige um objeto

##### 📤 `Unboxing`

Conversão automática de Wrapper → tipo primitivo

Exemplo conceitual:
- `Integer` → `int`

Exemplo prático:
```java
    Integer numero = 10;
    int valor = numero; // unboxing**
```

⚠️ Atenção crítica: 
Se o Wrapper for `null`, o `unboxing` causará `NullPointerException`

Exemplo:
```java
    Integer numero = null;
    int valor = numero; // NullPointerException
```

🧠 Regra prática:

- Nunca faça `unboxing` sem garantir que o objeto não é `null`

#### 🧰 Métodos Utilitários dos Wrappers

`Wrappers` fornecem **métodos estáticos e de instância** que não existem nos tipos primitivos

Esses métodos permitem:

- Conversões
- Validações
- Comparações
- Operações auxiliares

Exemplo:
```java
    int x = Integer.parseInt("123");
    double y = Double.parseDouble("3.14");
    boolean b = Boolean.parseBoolean("true");
```

⚠️ Construtores diretos como:
```java
    new Integer(10);
```

estão `deprecated` porque:

- São menos eficientes
- Ignoram mecanismos de cache internos
- Foram substituídos por métodos de fábrica

✅ Utilize:

- `valueOf(...)`
- `parseXxx(...)`

#### Destaque: Classe `Character`

A classe `Character` é um caso especial, pois trabalha com **análise de caracteres e Unicode**

Ela fornece **métodos utilitários estáticos poderosos**, como:

- `Character.isDigit(char)`
- `Character.isLetter(char)`
- `Character.isUpperCase(char)`
- `Character.isLowerCase(char)`
- `Character.toUpperCase(char)`
- `Character.toLowerCase(char)`

Exemplo:
```java
    char c = 'A';
    if (Character.isUpperCase(c)) {
        c = Character.toLowerCase(c);
    }
```

➡️ Esses métodos lidam corretamente com regras internacionais de caracteres, algo difícil de implementar manualmente

#### 📦 Wrappers e Coleções

Estruturas do pacote **java.util**:

| Tipo  | Descrição                                    |
|-------|----------------------------------------------|
| List | Permite armazenamento de elementos ordenados |
| Set   | Armazena elementos únicos                    |
| Map   | Associa chaves a valores                     |

❌ **Não aceitam tipos primitivos**

✅ Aceitam apenas **referências a objetos**

Exemplo:
```java
    List<Integer> numeros = new ArrayList<>();
    numeros.add(10); // autoboxing
```

🧠 **Por que isso acontece?**

Porque coleções armazenam **objetos**, permitindo herança, polimorfismo e uniformidade na API

#### 🧵 Wrappers e Concorrência

- Mecanismos de sincronização trabalham com **objetos**
- `Locks` e monitores são associados a instâncias
- `Wrappers` são frequentemente usados como **estado compartilhado**

📌 Exemplo conceitual: não é possível sincronizar diretamente sobre um `int`, mas é possível sobre um `Integer`

⚠️ **Observação importante:**

`Wrappers` são **imutáveis**. Alterar o valor significa criar um novo objeto, o que exige cuidado em ambientes concorrentes

#### ✅ Boas Práticas

- Utilize **tipos primitivos sempre que possível** por performance e simplicidade
- Use `Wrappers` **quando necessário**, especialmente para:
  - Coleções,
  - APIs que exigem objetos
  - Genéricos,
  - Polimorfismo
  - Concorrência
- Evite construtores deprecated
- Prefira métodos estáticos utilitários
- Tenha atenção especial com null e unboxing

---

## 🚀 Síntese Final ✅🧠

- Wrappers **encapsulam tipos primitivos em objetos**
- Cada tipo primitivo possui um `Wrapper`
- Exceções: `Integer` e `Character`
- `Wrappers` permitem **modelo OO completo**
- Oferecem métodos utilitários úteis
- `autoboxing` converte primitivo → objeto
- `unboxing` converte objeto → primitivo
- Coleções exigem `Wrappers`
- `Character` é essencial para validações textuais
- **Prefira primitivos**, use `Wrappers` quando o contexto exigir

---