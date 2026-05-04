# 📘 Guia — Testes Unitários com `JUnit 5` em Java

Documento prático para compreender **o papel dos testes unitários**, sua **implementação com `JUnit 5`** e **boas práticas reais usadas no mercado**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 Testes unitários existem para **garantir o comportamento do código ao longo do tempo**, principalmente em cenários de **manutenção**, **trabalho em equipe** e **evolução de regras de negócio**.  
Eles validam **unidades do código** — normalmente métodos — assegurando que mudanças futuras **não quebrem funcionalidades existentes**.  
Ao contrário do que muitos pensam, **alta cobertura de código não significa bons testes**: o valor está em **testar cenários críticos, bordas e exceções**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🧪 O que são Testes Unitários?

- Testes que validam **uma unidade isolada** do código, geralmente um método.
- Foco em **lógica de negócio**, não em `getter`/`setter`.
- Essenciais em:
    - Manutenção de código
    - Times com múltiplos desenvolvedores
    - Integração contínua (`CI`)

⚠️ **90% das reprovações técnicas** em entrevistas estão ligadas à **ausência de testes unitários**.

---

### 🏗️ Estrutura Base do Exemplo

- Classe de domínio: `Person`
    - Atributo: `age`
- Serviço de negócio: `PersonService`
    - Método: `isAdult(Person person)`
    - Regra: idade **>= 18** retorna `true`

Validação defensiva:

- `Objects.requireNonNull(person, "person can't be null")`

---

### 📦 Organização do Projeto com `Maven`

- Código de produção: `src/main/java`
- Código de teste: `src/test/java`
- Dependência:
    - `JUnit Jupiter` (`JUnit 5`)

✅ O `Maven` reconhece automaticamente testes em `src/test/java`.

---

### 🧾 Criação Automática de Testes (IDE)

- A IDE gera
    - Classe de teste: `PersonServiceTest`
    - Estrutura base com:
        - `@Test`
        - `@BeforeEach`
        - Importações corretas do `JUnit 5`

---

### ✅ Assertivas (`Assertions`)

Principais tipos:

- `assertFalse`
- `assertTrue`
- `assertEquals`
- `assertThrows`

Exemplo conceitual:

- **Esperar `false`** quando idade < 18
- **Esperar `true`** quando idade >= 18
- **Esperar exceção** quando `person` é `null`

🧠 **Assertiva = contrato** do comportamento esperado.

---

### 📝 Convenções de Nome para Testes

Boas práticas:
- Nome claro
- Autoexplicativo
- Baseado em comportamento

Formato comum

Exemplo:
```java
    shouldReturnFalse_whenAgeIsLowerThan18
```

Alternativa com `@DisplayName`:

Exemplo:
```java
    "Person should not be adult when age is lower than 18"
```

✅ Essencial para leitura em **logs de `CI/CD`**.

---

## 🔁 Independência entre Testes

- Testes **não devem compartilhar estado**
- Uso de`@BeforeEach`, garante
    - Um novo objeto a cada teste
    - Zero interferência entre cenários

⚠️ Criar objetos diretamente como atributos pode gerar **efeitos colaterais invisíveis**.

---

### 📊 Cobertura de Código

- Ferramenta: **Run with Coverage**
- Mostra:=
    - Linhas executadas
    - Métodos cobertos

⚠️ **Cobertura ≠ qualidade**

- Um teste só cobrir 100% do código **não garante** que todos os cenários foram testados.

---

### 🚨 Testando Exceções

Uso de `assertThrows` para validar:

- Tipo da exceção (`NullPointerException`, `IllegalArgumentException`)
- Mensagem da exceção (quando relevante)

📌 Importante em sistemas com:

- `Frontend`
- `APIs`
- Tratamento específico de erros por tipo de exceção

---

### 📋 Testando Métodos com Lista

Exemplo de lógica:

- Filtrar lista removendo não adultos

Cenários testados:

- Lista com idades variadas (`17`, `18`, `21`)
- Resultado esperado:
    - Lista apenas com adultos

Validações comuns:

- `assertEquals(resultado.size(), esperado)`
- Comparação de conteúdo quando necessário

---

### 🔄 Proteção contra Mudanças de Regra

Exemplo crítico:

- Regra alterada de **18 para 21 anos**

Resultado:

- ✅ Código compila
- ❌ Testes falham

💥 **Testes mostram exatamente onde a regra impactou o sistema**, evitando bugs silenciosos em produção.

---

## 🚀 Síntese Final ✅🧠

- **Testes unitários garantem estabilidade do código**
- **`JUnit 5` é o padrão moderno para testes em Java**
- **Cobertura alta não substitui bons cenários**
- **Testes devem ser independentes**
- **Exceções também precisam ser testadas**
- **Mudanças de regra são detectadas imediatamente**
- **Testes são obrigatórios em projetos profissionais modernos**
- **Escrever testes deve ser automático, não opcional**

---

























