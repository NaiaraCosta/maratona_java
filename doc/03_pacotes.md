# 📦 Convenções de Nomenclatura de Pacotes

As convenções de nomenclatura de pacotes em Java ajudam a manter o código **organizado**, **legível** e **padronizado**.

💡 Seguir esse padrão é essencial em projetos profissionais.

---

## 🧭 Padrões principais

### 🌐 Domínio invertido

Os nomes de pacotes devem começar com o domínio da organização **invertido**:

```
com.google
org.apache
br.com.empresa
```

✔ Prefixos comuns:

* `com` → empresas comerciais
* `org` → organizações
* `edu` → instituições educacionais
* `br`, `us`, etc → código do país

---

### 🔡 Uso de letras minúsculas

Utilize **apenas letras minúsculas**:

```
✔ correto: com.empresa.service
❌ errado: com.Empresa.Service
```

💡 Isso evita conflitos com nomes de classes e melhora a consistência.

---

### 🔗 Separação por níveis

Os pacotes utilizam **ponto (`.`)** para separar níveis hierárquicos:

```
br.com.empresa.projeto.modulo
```

📂 Cada nível representa uma pasta no sistema de arquivos.

---

### 🧱 Nome do projeto e organização interna

Após o domínio, adicione:

* 📦 Nome do projeto
* 🧩 Subpacotes funcionais

Exemplos:

```
br.com.meuprojeto.model
br.com.meuprojeto.service
br.com.meuprojeto.controller
```

💡 Isso ajuda a organizar o código por responsabilidade.

---

## 🧠 Boas práticas

* 📌 Seja consistente em todo o projeto
* 📌 Use nomes claros e descritivos
* 📌 Evite abreviações desnecessárias
* 📌 Organize por responsabilidade (model, service, repository, etc.)

---

## 🚀 Resumo rápido

* 🌐 Use domínio invertido (ex: `br.com.empresa`)
* 🔡 Sempre letras minúsculas
* 🔗 Separe com ponto (`.`)
* 📦 Organize por projeto e funcionalidade