# Sistema de Cadastro de Clientes para Desktop em Banco de Dados SQLite em 3 camadas utilizando o padrão Abstract Factory.

## Contextualização

 - O projeto é uma versão do sistema para a IDE NetBeans e Console.<br> 
 - O projeto no NetBeans deve ser chamado cadastrocliente_desktop_bd_dao_3c_sqlite.<br>
 - Os arquivos .bat permite sua compilação e execução via linha de comando, estando o java configurado.<br>
 - Este programa possui diversas classes organizada nos pacotes visão, controle, modelo e dao.<br>
 - Utiliza o padrão abstract factory para abstrair o armazenamento em SQLite.
 - Toda iteração com banco de dados é tratada diretamente pelo DAO(Data Access Object).<br>
 - Os dados de configuração (Servidor, Database) da integração do java com o banco de dados estão no arquivo src/dao/SQLiteDadosBanco.java.<br>
 - A especificação da fábrica a ser utilizada é feita na interface Factory.java.
  - A pasta src contêm os fontes do projeto e na pasta  lib o driver jdbc para SQLite.<br>

## Arquivos

- *.sql - Script do banco de daddos.
- build.xml - Arquivo de configuração da ferramenta de automação Ant.
- *.bat - Arquivos de lote(Batch) de console para tarefas compilar, executar, documentar, empacotar e limpar o projeto.
