# Mario Kart Simulador

### Jogo desenvolvido para o trabalho final da disciplina de Desenvolvimento de Sistemas do 2º Ano do Curso Técnico em Informática Integrado ao Ensino Médio, IFNMG - Campus Salinas. Back-end e Front-end desenvolvidos em Java com a IDE NetBeans.

---

## Como executar

### Pré-requisitos

- [JDK](https://www.oracle.com/br/java/technologies/downloads/) versão 17 ou superior
- [Maven](https://maven.apache.org/) versão 3.6.3 ou superior
- [NetBeans](https://netbeans.apache.org/front/main/index.html) (opcional) versão 13 ou superior

### Passos

```bash
# 1. Entre na pasta do projeto
cd frontend

# 2. Inicialize o jogo
mvn exec:java
```

Uma janela será aberta com a tela inicial do game. Depois dela há uma tela de seleção de idioma (português, inglês ou espanhol) e posteriormente o jogo é definitivamente iniciado (sorteio de personagens e execução de rodadas). Ao longo da partida novos personagens podem ser desbloqueados e novos bônus aparecem, existindo uma grande surpresa ao "platinar" o jogo!

> Caso tenha o NetBeans instalado, basta abrir o jogo na IDE e executar "Run ▶" na tela [FrmInicio.java](./src/main/java/ifnmg/frontend/FrmInicio.java)

---

## Regras do Jogo

#### Para mais informações acerca das regras e dinâmica do jogo, confira o [repositório de regras e instruções](https://github.com/ifnmgsal-inf/mariokartsimulator-java-2025), organizado pelo professor [Leonardo Humberto](https://github.com/leonardo-silva).