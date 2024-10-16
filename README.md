JavaFL Compiler & SECD/FPM Abstract Machine
Descrição
Este repositório contém:
  
  - JavaFL
  - SECD/FPM

Requisitos
Para rodar os exemplos e o projeto, você precisará ter os seguintes programas instalados:
  
  Java Development Kit (JDK) para compilar e rodar o código Java.
  JavaCC para processar o arquivo de gramática.

Como rodar os exemplos
  Os exemplos já estão incluídos no código-fonte. Siga os passos abaixo para compilar.

1. Preparar o compilador JavaFL
   
  No diretório principal, execute os seguintes comandos para preparar o compilador:

  - javacc Jfl.jj
  - javac *.java

2. Compilar o arquivo .jfl
   
Use o compilador para transformar o código em um arquivo .jfl no código Java correspondente dentro da pasta SECD:

  - java Jfl nome_arquivo.jfl

Esse comando irá gerar os arquivos Java compilados dentro do diretório SECD/.

3. Compilar e rodar a máquina SECD
   
Agora, navegue até a pasta SECD/ e compile os arquivos gerados:

  - javac *.java

Para executar o programa na máquina SECD, use o comando:

  - java Main
  
Exemplos
Você encontrará vários exemplos prontos na pasta. Para rodar um exemplo específico, siga os mesmos passos acima substituindo nome_arquivo.jfl pelo nome do arquivo de exemplo desejado.


------------- Gramática e Expressões regulares da Linguagem -----------------
 
Gramática:
  
  JFL -> (FUN)* MAIN
  MAIN -> "main" "=" EXP
  FUN -> ID (ID)* "=" EXP
  EXP -> NUM  | ID  | "let" ID "=" EXP "in" EXP |
         "if" "(" EXP ")" "then" EXP "else" EXP | "(" EXP ((OP EXP)| EXP*) ")"
        | "cons" "("EXP,EXP")" | "case" EXP "of" "{" "<" NUM ">" "<" ID* ">" -> EXP "}"+
  OP -> "+" | "-" | "*" | "/" | "<" | ">" | "<=" | ">=" | "==" | "&&" | "||"

Expressões regulares:   

  SKIP :
  {
    " "
  | "\t"
  | "\n"
  | "\r"
  }
  
  TOKEN :
  {
    <MAIN: "main">
  | <ATRIB: "=">
  | <VIRGULA: ",">
  | <APARENTESES:"(">
  | <FPARENTESES:")">
  | <PRINT: "print">
  | <IF: "if">
  | <THEN: "then">
  | <ELSE: "else">
  | <LET: "let">
  | <IN: "in">
  | <ADD: "+">
  | <SUB: "-">
  | <MULT: "*">
  | <DIV: "/">
  | <MAIOR: ">">
  | <MENOR: "<">
  | <MAIORIGUAL: ">=">
  | <MENORIGUAL: "<=">
  | <IGUAL: "==">
  | <AND: "&&">
  | <OR: "||">
  | <CONS: "cons">
  | <CASE: "case">
  | <OF: "of">
  | <ACHAVES: "{">
  | <FCHAVES: "}">
  | <CASEATRIB: "->">
  | <BOOLTRUE: "true">
  | <BOOLFALSE: "false">
  }
  
  TOKEN :
  {
    <NUM : (["0"-"9"])+>
   |< ID: ["a"-"z","A"-"Z"] ( ["a"-"z","A"-"Z","0"-"9"])*>
  }
