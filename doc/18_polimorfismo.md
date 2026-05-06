# 📘 Guia — Polimorfismo em Java: Conceitos, Funcionamento e Boas Práticas

Este documento apresenta **polimorfismo em `Java` do zero até cenários reais**, integrando de forma progressiva e explícita conceitos fundamentais como `abstract class`, `interface`, `widening cast`, `narrowing cast`, `instanceof` e **programação orientada a interfaces**, formando uma base sólida para compreensão e aplicação prática no desenvolvimento orientado a objetos.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Polimorfismo** significa literalmente **múltiplas formas**.  
Em termos práticos, em `Java`, isso representa a capacidade de **uma variável de referência mais genérica apontar para objetos de tipos mais específicos**, permitindo que **o comportamento correto seja decidido e executado em tempo de execução**, e não em tempo de compilação.

Esse comportamento depende diretamente de três pilares da orientação a objetos em Java:

- **Herança**
- **Interfaces**
- **Sobrescrita de métodos (`override`)**

📌 O grande benefício do polimorfismo é o **desacoplamento**:  
o código cliente deixa de depender de **classes concretas** e passa a depender de **contratos e comportamentos**, tornando o sistema mais flexível, extensível e fácil de manter.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧱 Estrutura Base do Domínio

📌 Criamos uma hierarquia de produtos para representar um domínio de negócio simples e realista

Estrutura definida:

- `abstract` class Produto
  - Atributos:
    - nome
    - valor
  - Métodos:
    - getNome()
    - getValor()
- Subclasses concretas:
  - Computador
  - Tomate
  - Televisao

✅ A classe Produto é abstrata porque **não faz sentido instanciar um produto genérico**

Ela existe apenas para **definir um modelo comum** e **regras compartilhadas** entre todos os tipos de produto

📌 Uma classe abstrata pode:

- Possuir atributos
- Possuir métodos concretos
- Possuir métodos abstratos
- Servir como tipo de referência em polimorfismo

---

### 🏷️ Interface como Contrato (Taxavel)

Criamos a interface Taxavel, responsável por definir um **contrato de tributação**

Ela declara o método:

- `double` calcularImposto()

📌 Esse método **não define como o imposto é calculado**, apenas **exige que ele exista**

Esse é o papel essencial de uma interface: Definir **o que deve ser feito**, sem se preocupar **como** será feito

✅ A classe Produto declara:

Exemplo:
```java
    public abstract class Produto implements Taxavel
```

📌 Como Produto também é **abstrata**, ela **não é obrigada a implementar** o método calcularImposto() 

A responsabilidade pela implementação concreta é transferida para as subclasses, isso cria uma separação clara entre:

- **Contrato** (Taxavel)
- **Modelo base** (Produto)
- **Implementações concretas** (Computador, Tomate, Televisao)

---

### 💰Sobrescrita do Método calcularImposto()

Cada tipo de produto possui uma regra de imposto diferente:

- Computador → imposto mais alto (exemplo: 21%)
- Tomate → imposto reduzido (exemplo: 6%)
- Televisao → regra semelhante a outros eletrônicos

Cada classe **sobrescreve** (`override`) o método calcularImposto() definido no contrato

📌 Aqui ocorre **polimorfismo de método**:

- O método chamado é sempre o mesmo: calcularImposto()
- A **implementação executada depende do tipo real do objeto**, não do tipo da variável de referência

Esse comportamento é resolvido **em tempo de execução**, por meio do mecanismo de `dynamic dispatch` do Java.

---

### 🗂️ Camada de Serviço (Regra de Negócio)

Criamos a classe **CalculadoraImposto** com o objetivo de:

- Separar **regra de negócio** do **modelo**
- Centralizar a lógica de cálculo e exibição de impostos
- Gerar relatórios ou saídas padronizadas

Implementação inicial:

- Um método específico para cada tipo
  - calcularImpostoComputador
  - calcularImpostoTomate

Resultado obtido:

❌ Código duplicado  
❌ Forte acoplamento às classes concretas  
❌ Baixa escalabilidade  
❌ Alterações frequentes sempre que surgem novos produtos

📌 Este cenário evidencia claramente a necessidade do polimorfismo

---

### 🔁 Polimorfismo em Ação (Parâmetros Polimórficos)

Refatoração utilizando **variável de referência genérica** como parâmetro:

Exemplo: 
```java
    public static void calcularImposto(Produto produto)
```

Agora:

- Um único método  
- Funciona para **qualquer subclasse de Produto**
- o método não precisa ser alterado quando novas subclasses são criadas.

✅ Benefícios diretos:

- Eliminação de duplicação  
- Código aberto para extensão e fechado para modificação (*Princípio OCP*)  
- Menor acoplamento.

📌 Conceito-chave: Quem executa **calcularImposto()** é sempre o **objeto real em memória**, e não a variável que o referencia.

#### 🎮 Analogia do Controle Remoto

Uma analogia simples e poderosa

- **Controle remoto** → variável de referência
- **TV** → objeto real

📌 O controle define quais botões existem (o contrato), enquanto a TV decide como cada botão funciona (a implementação).

✅ O mesmo controle funciona para TVs mais novas
❌ Não é possível acessar funções que o controle não conhece
👉 Exatamente como acontece no polimorfismo em Java

#### 🔼 Widening Cast (Upcasting)

📌 Conversão implícita de um tipo mais específico para um tipo mais genérico

Exemplo:
```java
    Produto p = new Computador(...);
```

✅ Sempre segura
✅ Não exige cast explícito
✅ É a base do polimorfismo
✅ Permite acessar apenas o que está definido em Produto

📌 O objeto continua sendo um Computador, apenas visto como Produto

#### Narrowing Cast (Downcasting)

📌 Conversão **explícita** de um tipo genérico para um tipo mais específico

Exemplo:
```java
    Tomate t = (Tomate) produto;
```

⚠️ Risco real de `ClassCastException`
✅ Só é segura se o objeto **realmente for do tipo esperado**

📌 O compilador aceita o cast, mas **a verificação ocorre em runtime**


##### 🛡️ Uso Correto de instanceof

Antes de realizar um `narrowing cast`, é essencial validar o tipo real do objeto

Exemplo:
```java
    if (produto instanceof Tomate) {
        Tomate t = (Tomate) produto;
    }
```

✅ Evita exceções em tempo de execução
✅ Garante segurança e previsibilidade
✅ Torna o código robusto

📌 A partir do Java 16+, o `instanceof` permite `pattern matching`, mas o conceito fundamental permanece o mesmo


#### ⚠️ Exemplo Real de Erro (ClassCastException)

❌ Tentativa inválida:

- Variável Produto
- Referenciando um Computador
- Convertida para Tomate

➡️ Erro em runtime (`ClassCastException`)
➡️ Compilador não detecta o problema
➡️ Sempre validar com instanceof antes do cast

---

### 🧠 Programação Orientada a Interface (POI)

Exemplo com repositório de dados:

- interface **Repositorio**
  - método **salvar()**
- Implementações concretas:
  - **RepositorioBancoDados**
  - **RepositorioArquivo**
  - **RepositorioMemoria**

Uso polimórfico correto:
```Java
    Repositorio repo = new RepositorioBancoDados();
```

✅ Código cliente não depende da implementação
✅ Troca de comportamento sem alterar o código consumidor
✅ Base conceitual de frameworks como `Spring` e `Jakarta EE`

📌 Este é o ápice do polimorfismo aplicado à arquitetura

---

## 🚀 Síntese Final ✅🧠

- **Polimorfismo** significa **múltiplas formas**
- Fundamenta-se em **herança** e **interface**
- Variável de referência **não define** o comportamento executado
- O método executado depende do **objeto real**
- `Widening cast` é implícito e seguro
- `Narrowing cast` é explícito e potencialmente perigoso
- Sempre utilizar `instanceof` antes de `downcasting`
- Parâmetros polimórficos eliminam duplicação
- Programar para **interface** aumenta:
  - Manutenibilidade
  - Extensibilidade
  - Robustez
  - Qualidade arquitetural do código

---