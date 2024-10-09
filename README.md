JavaFL Compiler & SECD/FPM Abstract Machine
Descrição
Este repositório contém:
  
  - JavaFL
  - SECD/FPM

Requisitos
Para rodar os exemplos e o projeto, você precisará ter os seguintes programas instalados:
  
  Java Development Kit (JDK) para compilar e rodar o código Java.
  JavaCC para processar o arquivo de gramática.

Como rodar os exemplos:
  Os exemplos já estão incluídos no código-fonte. Siga os passos abaixo para compilar.

1. Preparar o compilador JavaFL:
  No diretório principal, execute os seguintes comandos para preparar o compilador:

  - javacc Jfl.jj
  - javac *.java

2. Compilar o arquivo .jfl:
Use o compilador para transformar o código em um arquivo .jfl no código Java correspondente dentro da pasta SECD:

  - java Jfl nome_arquivo.jfl

Esse comando irá gerar os arquivos Java compilados dentro do diretório SECD/.

3. Compilar e rodar a máquina SECD:
Agora, navegue até a pasta SECD/ e compile os arquivos gerados:

  - javac *.java

Para executar o programa na máquina SECD, use o comando:

  - java Main
  
Exemplos
Você encontrará vários exemplos prontos na pasta. Para rodar um exemplo específico, siga os mesmos passos acima substituindo nome_arquivo.jfl pelo nome do arquivo de exemplo desejado.
