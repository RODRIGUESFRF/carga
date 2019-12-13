JAR para carga no banco de dados via csv.

Classes:
-----------> ArquivoCSV: Faz a leitura dos dados no arquivo físico CSV
-----------> Carga: Classe principal que centraliza os comandos para execução do JAR
-----------> Conexao: Classe que realiza conexão com banco e é responsável também pela inserção dos dados
-----------> PrimeiraCompra: Classe com atributos do primeiro arquico .csv
-----------> SegundaCompra: Classe com atributos do segundo arquico .csv


<<<<<<<<<<<<<<<<<< EXECUTAR ANTES DO RODAR O JAR >>>>>>>>>>>>>>>>>>>>>>>
1. alterar no log esta linha, acrescentando o pacote correto <logger name="com.carga.compras" level="DEBUG"/>
2. copiar o endereço abaixo para notepad, alterando o nome do pacote e depois execute na linha de comando:
java -Dcom.sun.jndi.ldap.object.disableEndpointIdentification=true -Dlogback.configurationFile=logback.xml -jar carga-compras-X.X.X.jar -f config.properties -d db.properties >> log-homo.log 



<<<<<<<<<<<<<<<<<< PARA GERAR O JAR >>>>>>>>>>>>>>>>>>>>>>>
1. rodar o maven/install sem gerar erros. Ele vai gerar uma pasta nesse diretorio:
C:\Users\User\.m2\repository\com\carga\compras\carga-compras\1.0.0



<<<<<<<<<<<<<<<<<< README DO ANTIGO >>>>>>>>>>>>>>>>>>>>>>>
Carga Compras para o Active Directory(AD)

Requisitos
•Java 8

Como usar

O programa carga-compras-X.X.X.jar está preparado para rodar em linha de comando e espera no mínimo 2 argumentos:

-f: Arquivo de configuração para conexão com o AD. -d: Arquivo com as configurações de banco de dados. -t: Tipo de carga a ser executada. CARGAFULL e CARGADIFF(buscará corretores criados e atualizado um dia atrás). O valor padrão CARGA_DIFF -df: Utilizado para gerar na CARGADIFF da data corrente até x dias atrás. Valor padrão é 1 e na CARGAFULL ele será ignorado. O valor deve ser maior do que 0 

Atenção:
•Os formatos dos argumentos de entrada serão explicados a seguir
•Procure sempre redirecionar a saída para um arquivo de log
•Registre no log o horário de início/término.
•Sempre confira no log se houve erro de execução
•É necessário configurar na chamada do Java a configuração do log.

Configuração de Log O parâmetro -Dlogback.configurationFile=logback.xml é a configuração de log e o arquivo logback.xml é fornecido junto com os artefatos do sistema. Neste exemplo o arquivo está sem caminho, pois o mesmo estava na mesma pasta o programa ad-corretor-X.X.X.jar foi executdo. Todos os parâmetors funcionam com caminho relativo. Deve ser relativo a pasta onde o programa será executado.

Exemplo (homologação): 
@echo comeco: %date% %time% > log-homo.log
java -Dcom.sun.jndi.ldap.object.disableEndpointIdentification=true -Dlogback.configurationFile=logback.xml -jar ad-corretor-X.X.X.jar -f config.properties -d db.properties >> log-homo.log
@echo fim: %date% %time% >> log-homo.log
                                                                                                                            

Windows

Exemplo:
java -Dcom.sun.jndi.ldap.object.disableEndpointIdentification=true -Dlogback.configurationFile=logback.xml -jar ad-corretor-X.X.X.jar -f config.properties -d db.properties >> log-homo.log
echo %ERRORLEVEL%


Linux

Exemplo:
java -Dcom.sun.jndi.ldap.object.disableEndpointIdentification=true -Dlogback.configurationFile=logback.xml -jar ad-corretor-X.X.X.jar -f config.properties -d db.properties >> log-homo.log
result=$? 
echo $result


scripts programados para rotina

Ambiente Homologação: ShellScript RE 126

Ambiente Produção: ShellScript RE 127 
