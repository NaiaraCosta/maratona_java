## Modificadores de Acesso

Os modificadores de acesso são importantes porque controlam a visibilidade e o encapsulamento dos dados e comportamentos
numa aplicação. Eles permitem que o desenvolvedor defina quais partes do código podem ser acessadas ou modificadas por
outras classes, ajudando a proteger informações sensíveis, evitar erros causados por uso indevido de atributos e manter
uma estrutura mais organizada e segura. são fundamentais para aplicar o encapsulamento.

Em java, existem quatro tipos de modificadores de acesso:

- public: Qualquer classe pode ter acesso, inclusive classes de outros pacotes.
- protected: Acesso permitido para a própria classe, para classes do mesmo pacote e para subclasses (mesmo que estejam
  em pacotes diferentes).
- private: Somente a própria classe tem acesso.
- default: Acesso permitido apenas para classes do mesmo pacote.