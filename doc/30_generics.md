# 📘 Guia — Generics em Java: Fundamentos, Wildcards, Classes e Métodos Genéricos

Guia técnico e progressivo sobre **`Generics` em Java**, cobrindo **introdução**, **problema histórico**, **`Type Erasure`**, **`Wildcard` (`? extends` / `? super`)**, **classes genéricas**, **métodos genéricos** e **boas práticas de design**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Generics foram introduzidos no Java 5 (1.5)** para resolver um problema crítico: **falta de segurança de tipo em tempo de compilação**.
Antes dos generics, coleções aceitavam qualquer `Object`, o que causava erros apenas **em tempo de execução** (`ClassCastException`).

Com generics:

- O **compilador valida tipos**
- O código fica **mais seguro, legível e reutilizável**
- Mantém compatibilidade com versões antigas via **`Type Erasure`**

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🕰️ O Problema Antes dos Generics (Java ≤ 1.4)

- Coleções armazenavam apenas `Object`
- Era possível misturar tipos diferentes na mesma `List`
- Uso excessivo de:
  - `instanceof`
  - *casts*
- Erros só apareciam **em tempo de execução**

❌ Exemplo problemático:

```java
    List lista = new ArrayList();
    lista.add("String");
    lista.add(123);
```

✅ Consequência:

Código frágil
Difícil de manter
Alto risco de `ClassCastException`

---

### ✅ Introdução dos `Generics` (Segurança em Tempo de Compilação)

Com generics:

Exemplo:
```java
    List<String> lista = new ArrayList<>();
    lista.add("Texto"); 
    // lista.add(123); ❌ Erro de compilação
```

✅ Benefícios:

- Tipagem forte
- Elimina casts
- Documentação implícita do código

⚠️ **Importante**:

Generics funcionam **apenas em tempo de compilação**.

---

### 🧹 `Type Erasure`

- O tipo genérico é removido após a compilação
- Na JVM, tudo vira Object

💡 Motivo:

- Compatibilidade com bilhões de sistemas Java antigos

❗ Consequência:

- Em runtime, o Java não sabe o tipo genérico
- Por isso, validação ocorre no compilador

---

### 🐾 Wildcards (?) — Generalização Controlada

Wildcards resolvem limitações de generics com herança.

🔀 Problema Clássico: List<Animal> ≠ List<Cachorro>

Mesmo com herança

Exemplo:
```java
    List<String> lista = new ArrayList<>();
    lista.add("Texto"); 
    // lista.add(123); ❌ Erro de compilação
```

Isso **não funciona**

Exemplo:
```java
    List<Animal> = List<Cachorro> ❌
```

➡️ **`Generics` são invariantes**

---

### ✅ ? extends — Leitura (Covariância)

Exemplo:
```java
    List<? extends Animal>
```

✅ Aceita:

- `List<Animal>`
- `List<Cachorro>`
- `List<Gato>`

⚠️ Restrição:

- **Não permite adicionar elementos**
- Apenas leitura

✅ Regra:

- `Producer` `Extends`

✅ ? super — Escrita (Contravariância)

---

### ✅ `? super — Escrita (Contravariância)

Exemplo:
```java
    List<? super Animal>
```

✅ Aceita:

- `List<Animal>`
- `List<Object>`

✅ Permite:

- `add(new Cachorro())`
- `add(new Gato())`

⚠️ Restrição:

- Leitura apenas como `Object`

✅ Regra:

- **Consumer Super**

---

### 🧠 Resumo Prático dos Wildcards

| Uso      | Sintaxe     | Pode ler | Pode Escrever |
| -------- | ----------- | -------- |---------------|
| Producer | ? extends T | ✅       | ❌             |
| Consumer | ? super T   | ✅       | ✅             |

---

### 🏗️ Classes Genéricas

💡 **Objetivo:**

Evitar duplicação de código para tipos diferentes.

#### ❌ Problema Sem Generics

- `CarRentalService`
- `BoatRentalService`
- 

➡️ **Código idêntico**, apenas os **tipos mudam**

--- Código idêntico, apenas tipos mudam

Exemplo:
```java
    public class RentalService<T> {
        private List<T> disponiveis;
        
        public RentalService(List<T> disponiveis) {
          this.disponiveis = disponiveis;
        }
        
        public T buscarDisponivel() {
          return disponiveis.remove(0);
        }
        
        public void retornar(T objeto) {
          disponiveis.add(objeto);
        }
    }
```

✅ Benefícios:

- Reutilização
- Tipagem forte
- Código enxuto

#### 🧪 Usando a Classe Genérica

Exemplo:
```java
    RentalService<Carro> serviceCarro = new RentalService<>(listaDeCarros);
    Carro carro = serviceCarro.buscarDisponivel();
    serviceCarro.retornar(carro);
```

➡️ **O tipo T é resolvido em tempo de compilação**

---

###  🧬 Métodos Genéricos

Quando **não faz sentido tornar a classe inteira genérica**.

✅ Sintaxe Correta

Exemplo:
```java
    public static <T> List<T> criarLista(T elemento) {
        List<T> lista = new ArrayList<>();
        lista.add(elemento);
        return lista;
    }
```

#### 🔒 Métodos Genéricos com Limites (bounds)

Exemplo:
```java
    public static <T extends Comparable<T>> void ordenar(List<T> lista)
```

✅ Garante:

- O tipo possui contratos específicos
- Uso seguro de métodos

---

### ⚠️ Complexidade & Boas Práticas

💡 Atenções importantes:

- Generics **aumentam complexidade de leitura**
- Usar apenas quando **realmente agrega valor**
- Frameworks usam intensivamente (`Spring`, `Hibernate`)

✅ Recomendação:

**Generalize no núcleo do domínio**, não prematuramente.

---

### 🚀 Síntese Final ✅🧠

- `Generics` garantem segurança em tempo de compilação
- `Type Erasure` mantém compatibilidade
- `Wildcards` resolvem problemas de herança
- `? extends` → leitura
- `? super` → escrita
- Classes genéricas evitam duplicação
- Métodos genéricos trazem flexibilidade
- Uso excessivo prejudica legibilidade
- **Bom design equilibra poder e simplicidade**

---