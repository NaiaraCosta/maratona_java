# 🔄 Casting

Casting é o processo de **converter um tipo de dado em outro**.

Ele pode acontecer de duas formas:

* 🔼 **Implícito (automático)** → de um tipo menor para maior
* 🔽 **Explícito (manual)** → de um tipo maior para menor

---

## 🔼 Widening Casting (Automático)

Ocorre quando um tipo menor é convertido para um tipo maior.

💡 Esse processo é **seguro e automático**, sem risco de perda de dados.

### 📌 Ordem de conversão

```
byte → short → char → int → long → float → double
```

---

### 💻 Exemplo

```
int meuInt = 9;
double meuDouble = meuInt;
```

✔ O valor é convertido automaticamente para `double`

---

## 🔽 Narrowing Casting (Explícito)

Ocorre quando um tipo maior é convertido para um tipo menor.

⚠️ Pode haver **perda de dados**, por isso precisa ser feito manualmente.

### 📌 Ordem de conversão

```
double → float → long → int → char → short → byte
```

---

### 💻 Exemplo

```
double meuDouble = 9.78;
int meuInt = (int) meuDouble;
```

⚠️ O valor decimal será **truncado** (resultado: 9)

---

## 🧱 Casting de Objetos

Além dos tipos primitivos, também é possível fazer casting entre objetos.

---

### 🔼 Upcasting

Conversão de **subclasse → superclasse**

✔ Automático
✔ Seguro

```
Animal animal = new Cachorro();
```

---

### 🔽 Downcasting

Conversão de **superclasse → subclasse**

⚠️ Precisa ser explícito
⚠️ Pode gerar erro em tempo de execução

```
Cachorro cachorro = (Cachorro) animal;
```

---

### 🚨 Atenção

Se o objeto não for compatível, ocorre:

```
ClassCastException
```

💡 Sempre que possível, utilize `instanceof` para evitar erros.

---

## 🚀 Resumo rápido

* 🔄 Casting = conversão de tipos
* 🔼 Widening → automático e seguro
* 🔽 Narrowing → manual e pode perder dados
* 🧱 Objetos → Upcasting (seguro) / Downcasting (cuidado!)