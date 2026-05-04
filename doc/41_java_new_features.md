# 📘 Guia — Atualização do JDK, `Record Classes` e `Pattern Matching for instanceof` no Java 16

Guia técnico prático sobre **atualização do JDK**, **novos recursos do Java 16** e como eles impactam **qualidade de código, testes e produtividade**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 Com a evolução do Java, novas versões do **JDK** trazem **funcionalidades que reduzem verbosidade**, **aumentam segurança** e **simplificam código legado**.  
Neste conjunto de aulas, foram abordados três pontos essenciais:

- Atualização do ambiente para o `JDK 16`
- Uso de **`record classes`** como alternativa moderna às classes imutáveis
- Introdução do **`Pattern Matching for instanceof`**, simplificando código polimórfico

Essas mudanças são cumulativas e impactam diretamente **arquitetura**, **testes unitários** e **manutenção de código**.

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🔧 Atualizando o JDK (15 → 16)

#### 📥 Download e Instalação
- Buscar por **JDK** (Oracle/OpenJDK)
- Selecionar versão `16`
- Baixar conforme o sistema operacional (`Windows x64`, por exemplo)
- Instalar seguindo o fluxo padrão (`next`, `install`, `finish`)

✅ **Não é obrigatório desinstalar versões anteriores**

#### 🌱 Atualizando Variáveis de Ambiente

- Editar variável de sistema:
    - `JAVA_HOME`
- Apontar para o diretório do novo JDK (`jdk-16`)
- Validar via terminal:
    - `java -version`
    - `mvn -v`

📌 O `Maven` passa a utilizar automaticamente o novo JDK se o `JAVA_HOME` estiver correto.

#### 🧹 Ajustes no Projeto

- Limpar build antigo:
    - `mvn clean`
- Atualizar configurações do projeto:
    - **Project SDK**: `16`
    - **Language level**: `16`
    - **Module SDK**: `16`

⚠️ Em projetos `Maven`, o compilador sobrescreve configs da IDE — configurar também no `pom.xml`.

#### ✅ Validação com Testes

- Executar testes unitários após a atualização
- Evita verificação manual classe por classe
- Reforça o valor de **testes automatizados**

---

### 📦 `Record Classes` (`Java 16`)

#### 📌 O que são `record classes`?

- Novo tipo especial de classe
- **Imutáveis por padrão**
- Geram automaticamente:
    - Construtor
    - `equals`
    - `hashCode`
    - `toString`
    - Métodos de acesso (*accessors*)

Equivalem conceitualmente ao que bibliotecas como `Lombok` oferecem.

#### 🧱 Estrutura Básica

Exemplo:
```java
    public record Manga(String name, int episodes) {}
```

✅ **Sem `getters`, `setters` ou código repetitivo**
✅ **Classe `final`**  
✅ **Campos somente leitura**

#### ❌ Restrições Importantes 🚫

**Não permite:**

- Atributos de instância extras
- Blocos de inicialização de instância

**Permite:**

- Atributos `static`
- Métodos
- Tipos genéricos
- `records` internos (*inner records*)

#### 🛠️ Construtores em `record`

- **Canonical constructor** (*gerado automaticamente*)
- **Compact constructor** (*recomendado para validações*)

**Exemplo de validação:**

- Verificar se `name` não é `null`
- Lançar `NullPointerException`

#### 🧪 Testando `record classes`

**Cenários comuns:**

- Retorno correto dos *accessors*
- Funcionamento de `equals`
- Funcionamento de `hashCode`
- Validação de exceções no construtor
- Garantir que a classe ainda é um `record`:
    - `Manga.class.isRecord()`

🛡️ **Importante para sistemas que dependem de imutabilidade.**

---

### 🔍 Pattern Matching for `instanceof`

#### 🚨 Problema Antes

Código verboso com:

- `instanceof`
- *Cast* manual

Exemplo:
```java
    if (obj instanceof Developer) {
        Developer dev = (Developer) obj;
        dev.getMainLanguage();
    }
```

#### ✅ Nova Abordagem (Java 16)

Declaração direta no `if`

Exemplo:
```java
    if (obj instanceof Developer dev) {
        dev.getMainLanguage();
    }
```

✅ Menos código
✅ Mais legibilidade
✅ Menos risco de erro

#### 🧪 Cenários de Uso

- Polimorfismo
- Serviços que recebem tipos genéricos
- Verificação segura de subclasses

📌 Se o objeto **não for** do tipo esperado:

- O **bloco** simplesmente **não é executado**
- Nenhuma exceção é lançada


#### 🧠 Importante

- O escopo da variável criada no `instanceof` é limitado ao bloco
- Excelente para código defensivo e limpo

---

🚀 Síntese Final ✅🧠

- Atualizar o JDK exige ajustes no sistema, IDE e Maven
- Testes unitários garantem segurança durante upgrades
- record classes reduzem drasticamente boilerplate
- `records` são imutáveis, final e ideais para domínio
- `Pattern Matching` for instanceof simplifica polimorfismo
- Java 16 marca um avanço significativo em produtividade
- Código moderno = menos linhas + mais legibilidade
- Testar novas features é parte do aprendizado profissional

---