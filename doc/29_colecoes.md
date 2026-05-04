# 📘 Guia — Coleções Java: Ordenação Avançada, Busca, Conversões, Iteração e Estruturas de Dados

Guia técnico consolidado abordando **`Comparator`**, **`Binary Search`**, **conversões entre `List` e `Array`**, **`Iterator`**, **`Set`**, **`NavigableSet`**, **`Map`**, **`NavigableMap`** e **`Queue`**, com foco em comportamento interno, contratos e boas práticas.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 Após dominar `equals`, `hashCode`, `List` e `Comparable`, o próximo passo é entender **flexibilidade de ordenação**, **buscas eficientes**, **remoção segura**, **estruturas sem duplicidade**, **estruturas baseadas em chave/valor** e **filas com prioridade**.  
Este conteúdo aprofunda o **Framework de Coleções do Java**, explicando **quando** e **por que** usar cada estrutura — sempre respeitando contratos técnicos e performance.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🔀 `Comparator` — Ordenação Sob Demanda

- Usado quando **não é desejável mudar a ordem natural (`Comparable`)**
- Ideal para **ordenações contextuais**
- Não altera a classe original

✅ Características:

- Implementa `Comparator<T>`
- Método `compare(T o1, T o2)`
- Retorna valor **negativo**, **zero** ou **positivo**

💡 **Uso típico**:

```java
    Collections.sort(lista, new MangaByIdComparator());
    lista.sort(new MangaByPrecoComparator());
```

✅ Vantagem crítica:

Evita quebrar sistemas grandes quando a ordem “padrão” já é usada em produção

---

### 🔎 Binary Search

- Método: `Collections.binarySearch`
- **Exige lista previamente ordenada** (pela mesma regra!)
- Retorna:
  - Índice → se encontrado
  - -(pontoDeInserção) - 1 → se não encontrado

⚠️ Regras:

- Ordenação e busca devem usar o **mesmo critério**
- Pode usar `Comparator`

💡 Usado para:

- Busca rápida
- Descobrir **onde inserir mantendo ordem**

---

### 🔁 Conversão entre `List` e `Array`

**List → Array**

Exemplo:
```java
    Integer[] array = lista.toArray(new Integer[0]);
```

✅ Boas práticas:

- Usar `new T[0]`
- Mais eficiente e recomendado

**Array → List**

Exemplo:
```java
    List<Integer> lista = Arrays.asList(array);
```

⚠️ Cuidado:

- **Lista imutável em tamanho**
- Alterações refletem no array original

✅ Solução segura:

```java
    List<Integer> lista = new ArrayList<>(Arrays.asList(array));
```

✅ Java 9+:
```java
    List<Integer> lista = List.of(1, 2, 3);
```

---

### 🔄 `Iterator` — Remoção Segura

❌ Proibido:

- Remover elementos usando `for-each`

✅ Correto:

- Usar `Iterator`

Exemplo:
```java
    Iterator<Manga> it = mangas.iterator();
    while(it.hasNext()) {
        if(it.next().getQuantidade() == 0) {
            it.remove();
        }
    }
```

✅ Alternativa moderna (Java 8+):
```java
    mangas.removeIf(m -> m.getQuantidade() == 0);
```

---

### 🧺 `Set` — Elementos Únicos

#### `HashSet`

- ❌ **Sem ordem garantida**
- ✅ Usa `hashCode` + `equals`

#### `LinkedHashSet`

- ✅ **Mantém a ordem de inserção**
- ✅ **Ainda sem elementos duplicados**

✅ **Ideal para:**

- Garantir **unicidade**
- Limpar duplicados automaticamente ao inserir

⚠️ **Igualdade depende de:**

- Implementação correta de `equals`
- Implementação correta de `hashCode`

---

### 🌲 `NavigableSet` / `TreeSet`

- Implementa `SortedSet`
- ✅ **Sempre ordenado**
- Usa `Comparable` ou `Comparator`
- Complexidade: **`O(log n)`**

⚠️ **Atenção crítica:**

- **`TreeSet` NÃO usa `equals`**
- Elementos são considerados duplicados se `compareTo()` retornar `0`

✅ **Métodos poderosos:**
- `lower`
- `floor`
- `higher`
- `ceiling`
- `pollFirst`
- `pollLast`
- `descendingSet`

---

### 🧠 Comparação: `Set` vs `TreeSet`

- **`HashSet`**
    - Usa `equals`: ✅
    - Usa comparação (`compareTo` / `Comparator`): ❌
    - Mantém ordem: ❌

- **`TreeSet`**
    - Usa `equals`: ❌
    - Usa comparação (`compareTo` / `Comparator`): ✅
    - Mantém ordem: ✅

---

### 🗺️ `Map` — Chave & Valor

- ❌ **Não é uma `Collection`**
- ✅ **Chaves únicas**
- ✅ **Valores podem se repetir**

#### `HashMap`

- ❌ **Sem ordem garantida**

#### `LinkedHashMap`

- ✅ **Mantém ordem de inserção**

✅ **Operações principais:**

- `put`
- `get`
- `containsKey`
- `entrySet`
- `keySet`
- `values`

✅ **Navegação recomendada:**

- Iterar usando `entrySet` para acesso simultâneo à **chave** e ao **valor**

Exemplo:
```java
    for (Map.Entry<K, V> entry : map.entrySet())
```

#### 🧱 Map com Objetos

Exemplo:
```java
    Map<Consumidor, Manga> compras;
```

- Chave usa `equals` + `hashCode`
- Ideal para associações diretas

✅ Caso comum:

Um consumidor → vários produtos

Exemplo:
```java
    Map<Consumidor, List<Manga>>
```

#### 🌲 `NavigableMap` / `TreeMap`

- Equivalente ao `TreeSet` para mapas
- ✅ **Ordena pela chave**
- Exige `Comparable` ou `Comparator` **da chave**

✅ **Métodos principais:**

- `headMap`
- `tailMap`
- `subMap`
- `higherKey`
- `ceilingKey`
- `floorKey`

⚠️ **Submaps são *views*:**

- Alterações refletem **diretamente no mapa original**

---

### 🚦 `Queue` e `PriorityQueue`

#### `Queue`

- Modelo **FIFO** → **First In, First Out**

#### `PriorityQueue`

- ✅ **Ordem definida por prioridade**
- Usa `Comparable` ou `Comparator`

✅ **Métodos essenciais:**

- `add` / `offer`
- `peek`
- `poll`
- `remove`

💡 **Importante:**

- A ordem interna **não é visível**
- A ordem correta aparece **na remoção dos elementos**

✅ **Casos reais de uso:**

- Processamento por prioridade
- Filas de pedidos
- Agendamento de tarefas

---

## 🚀 Síntese Final ✅🧠

- `Comparator` permite **flexibilidade sem efeitos colaterais**
- `Binary Search` exige lista **ordenada corretamente**
- Conversões entre `List` e `Array` têm **armadilhas**
- Remoção segura usa `Iterator` ou `removeIf`
- `Set` garante **unicidade**
- `TreeSet` **ignora `equals`**
- `Map` trabalha por **chave**
- `TreeMap` ordena pela **chave**
- `PriorityQueue` resolve problemas por **prioridade**
- **Contrato correto = código confiável**

---