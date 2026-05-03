# 📘 Guia — Datas, Internacionalização e `java.time` no Java

Documento técnico consolidado sobre **manipulação de datas, horas, internacionalização e formatação** em Java — **do legado (`Date` / `Calendar`) até a API moderna (`java.time`)**.

---

## 🧠 Resumo Contextualizado 🤯📌

💡 **Datas sempre foram um ponto sensível no Java.**  

O ecossistema evoluiu de soluções **limitadas e hoje obsoletas** (`Date`, `Calendar`) para uma **API moderna, imutável e robusta** introduzida no Java 8 (`java.time`).  

Este guia percorre essa evolução de forma prática, cobrindo:

- ✅ Classes legadas e seus problemas
- 🌍 Internacionalização com `Locale`
- 🧮 Formatação e parsing (`DateFormat`, `SimpleDateFormat`, `DateTimeFormatter`)
- ⏱️ API moderna (`LocalDate`, `Instant`, `Duration`, `Period`)
- 🌐 Fuso horário (`ZoneId`, `ZonedDateTime`, `OffsetDateTime`)
- 🧠 Cálculos avançados (`ChronoUnit`, `TemporalAdjusters`)

---

## 🧩 Blocos Semânticos 🧠🔎

---

### 🗿 Classes Legadas: `Date` e `Calendar`

- `Date` (`java.util.Date`) trabalha com **milissegundos desde 01/01/1970 (Epoch)**.
- Internamente armazena um `long`.
- **Quase todos os métodos são `@Deprecated`**.
- Conversão principal:
    - `date.getTime()` → `long`
    - `new Date(long)`

⚠️ Problemas:

- Internacionalização fraca
- API confusa
- Mutável
- Cálculos manuais (ex: 1h = `3_600_000` ms)

`Calendar` surgiu como tentativa de correção:

- Classe **abstrata**
- Instanciada via `Calendar.getInstance()`
- Usa constantes (`Calendar.DAY_OF_WEEK`, etc.)
- Métodos úteis: `get`, `add`, `roll`

✅ Ainda comum em **sistemas legados**, mas **não recomendado para código novo**.

---

### 🌍 Internacionalização com `Locale`

A classe `Locale` (`java.util.Locale`) define:

- 🗣️ **Idioma** (`ISO 639`)
- 🌎 **País** (`ISO 3166`)

Exemplo de criação:

- `new Locale("pt", "BR")`
- `Locale.ITALY`
- `Locale.getDefault()`

Usada por:

- `DateFormat`
- `NumberFormat`
- `Currency`
- `DateTimeFormatter`

Permite **formatar datas, números e moedas** conforme cultura local.

---

### 📅 Formatação Legada: `DateFormat` e `SimpleDateFormat`

- `DateFormat` é **abstrata**
- Possui estilos prontos:
    - `SHORT`
    - `MEDIUM`
    - `LONG`
    - `FULL`

✅ Baseada no `Locale` do sistema.

`SimpleDateFormat`:
- Permite **máscaras customizadas**
- Exemplo de tokens:
    - `dd` → dia
    - `MM` → mês
    - `yyyy` → ano
    - `EEEE` → dia da semana
- Texto literal → `'texto fixo'`

⚠️ **Não é thread-safe**.

---

### 🧭 API Moderna: `java.time` (Java 8+)

- Inspirada no **Joda-Time**.  
- Totalmente **imutável**, clara e segura.

Principais classes:

- 📆 `LocalDate` → data (sem hora)
- ⏰ `LocalTime` → hora (sem data)
- 🧩 `LocalDateTime` → data + hora
- 🌐 `Instant` → timestamp UTC (`Z`)
- 🕒 `ZonedDateTime` → data + hora + zona
- 📏 `Duration` → tempo (segundos/nanos)
- 🗓️ `Period` → datas (dias/meses/anos)

✅ **Substituem completamente `Date` e `Calendar`**.

---

### ⏱️ `Instant` e Epoch Time

- Representa um ponto exato na timeline UTC.
- Baseado em **segundos + nanos desde 1970**.
- Ideal para:
    - Logs
    - Persistência
    - Integração entre sistemas

Conversões comuns:

- `Instant.now()`
- `instant.getEpochSecond()`
- `instant.getNano()`

---

### ⌛ Diferença entre Datas: `Duration` vs `Period`

- `Duration`
    - Baseada em **tempo**
    - Usa segundos
    - Funciona com `Instant`, `LocalDateTime`, `LocalTime`
- `Period`
    - Baseada em **calendário**
    - Dias, meses, anos
    - Funciona com `LocalDate`

Regra:

- ⛔ `Duration` 
- ❌ `LocalDate`  
- ✅ `Period` 
- ✔️ `LocalDate`

---

### 📐 Cálculos com `ChronoUnit`

Permite calcular diferenças diretamente:

- `ChronoUnit.DAYS.between(a, b)`
- `ChronoUnit.MONTHS.between(a, b)`
- `ChronoUnit.YEARS.between(a, b)`

✅ Ideal para **relatórios**, **idade**, **intervalos**.

---

### 🧠 Ajustes Inteligentes: `TemporalAdjusters`

Permite navegar pelo calendário semanticamente:

Exemplos:
- Próxima quinta-feira
- Primeiro dia do mês
- Último dia do ano
- Primeiro dia do próximo ano

🎯 Pode-se criar lógica customizada implementando `TemporalAdjuster`.

---

### 🌐 Zonas de Tempo: `ZoneId`, `ZonedDateTime`, `OffsetDateTime`

- `ZoneId`
    - Ex: `"America/Sao_Paulo"`, `"Asia/Tokyo"`
- `ZonedDateTime`
    - Data + hora + fuso completo
- `OffsetDateTime`
    - Data + hora + deslocamento (`-03:00`)

✅ `Instant` + `ZoneId` → conversão correta global.

---

### 🧾 Formatação Moderna: `DateTimeFormatter`

Substitui `SimpleDateFormat`.

Características:
- Imutável
- `Thread-safe`
- Integra-se com `Locale`

Tipos:
- Predefinidos (`ISO_DATE`, `ISO_DATE_TIME`)
- Customizados (`ofPattern`)

`Parsing` e `formatting` **usam o mesmo padrão**.

---

## 🚀 Síntese Final ✅🧠

- `Date` e `Calendar` → **legado**
- `Locale` → base da internacionalização
- `DateFormat` / `SimpleDateFormat` → **legado**
- `java.time` → **padrão moderno**
- `Instant` → timestamps globais (`UTC`)
- `Duration` ≠ `Period`
- `ChronoUnit` → diferenças entre datas
- `DateTimeFormatter` → formatação final

---