# 📘 Guia — Enumerações (`enum`) em Java

Documentação técnica sobre **enumerações em `Java`**, abordando introdução, tipagem forte, construtores e atributos, sobrescrita de métodos e busca por atributos.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 `enum` é um **tipo especial de classe** usado quando existe um 
**conjunto limitado e conhecido de valores**. Ele garante **consistência de dados**, 
**segurança de tipos** e elimina erros comuns causados por uso de `String`, `int` ou constantes soltas. 
Além disso, `enum` suporta **atributos**, **construtores**, **métodos**, **sobrescrita** 
e **comportamento polimórfico**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧠 Introdução às Enumerações
- Usadas para representar **escolhas limitadas**:
  - Pessoa `FISICA` ou `JURIDICA`
  - Dias da semana
  - Tipos de pagamento
- Evitam **inconsistência de dados** comuns com `String`.

❌ Problema com `String`:
- Erros de digitação
- Diferença entre maiúsculas/minúsculas
- Falta de validação em tempo de compilação

✅ Solução com `enum`:

Exemplo:
```java
    public enum TipoCliente {
      PESSOA_FISICA,
      PESSOA_JURIDICA
    }
```

📌 O compilador garante que **somente valores válidos** sejam utilizados.

---

### 🔗 Enumeração como Tipo de Atributo

- `enum` pode ser usado como **tipo de atributo**
- Força a utilização de valores válidos

Exemplo:
```java
  public class Cliente {
      private String nome;
      private TipoCliente tipoCliente;
  }
```

✅ Uso correto:

Exemplo:
```java
  Cliente cliente = new Cliente("Akira", TipoCliente.PESSOA_FISICA);
```

🧠 Benefício:

- Erros são capturados **em tempo de compilação**
- Código mais seguro e expressivo

---

### 🏗️ Construtores e Atributos em `enum`

- `enum` é uma classe especial
- Possui **construtor privado implícito**
- Pode conter atributos e métodos

Exemplo:
```java
  public enum TipoCliente {
      PESSOA_FISICA(1, "Pessoa Física"),
      PESSOA_JURIDICA(2, "Pessoa Jurídica");
  
      private final int valor;
      private final String nomeRelatorio;
  
      private TipoCliente(int valor, String nomeRelatorio) {
          this.valor = valor;
          this.nomeRelatorio = nomeRelatorio;
      }
  
      public int getValor() {
          return valor;
      }
  
      public String getNomeRelatorio() {
          return nomeRelatorio;
      }
  }
```

📌 Ideal para:

- Integração com banco de dados
- Relatórios
- Conversão de valores numéricos

---

### 🧱 Enumeração Declarada Dentro de Classes

- `enum` pode ser declarada dentro de outra classe

Exemplo:
```java
  public class Cliente {
      public enum TipoPagamento {
          DEBITO,
          CREDITO
      }
  
      private TipoPagamento tipoPagamento;
  }
```

⚠️ Observação:

- Funciona corretamente
- Separar em arquivo próprio é mais **organizado**

---

### 🔁 Sobrescrita de Métodos em `enum`

- Cada valor da enumeração pode ter **comportamento próprio**
- Aplica **polimorfismo**

Exemplo:
```java
  public enum TipoPagamento {
      DEBITO {
          @Override
          public double calcularDesconto(double valor) {
              return valor * 0.10;
          }
      },
      CREDITO {
          @Override
          public double calcularDesconto(double valor) {
              return valor * 0.05;
          }
      };
  
      public abstract double calcularDesconto(double valor);
  }
```

✅ Benefícios:

- Elimina `if/else`
- Código mais limpo
- Fácil manutenção

---

### 🔍 Busca de Enumeração por Atributo

- Útil ao receber dados externos (`String`, banco, arquivos)

Exemplo:
```java
  public static TipoCliente buscarPorNomeRelatorio(String nome) {
      for (TipoCliente tipo : TipoCliente.values()) {
          if (tipo.getNomeRelatorio().equalsIgnoreCase(nome)) {
              return tipo;
          }
      }
      return null;
  }
```

📌 Permite:

- Converter `String ➜ enum`
- Acessar outros atributos com segurança

---

## 🚀 Síntese Final ✅🧠

- `enum` representa conjuntos fechados de valores
- Substitui `String` e constantes estáticas
- Garante segurança de tipos
- Pode conter atributos e construtores
- Suporta sobrescrita de métodos
- Implementa polimorfismo
- Facilita integração com banco e relatórios

---