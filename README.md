**Sistema de Farm�cia 2.0**
---------------------------------------------------

Este projeto foi apresentado como trabalho 2 nas disciplinas de Programa��o orientada ao objeto e Estrutura de dados II
formado por:
        Nome       |     Prontuario
------------------ | ---------------
   Andr� T. Silva  |  156219-3
  Andrey Nagatani  |  156215-1
Victor P. de Assis |  146258-x

---------------------------------------------------
**Instru��es de uso:**
1. Executar script de bando de dados Mysql encontrado na pasta 'MYSQLBD';
2. Se houver necessidade, configurar String de usuario e senha de conex�o com o BD na classe 'ConnectionFactory.java' econtrado na camada DAO do projeto;
  * Por padr�o a String de conex�o est� configurada com usu�rio = 'root' e sem senha ou seja pwd ="";
3. Executar a 'Main' do projeto, encontrada na classe 'FrmLogin.java' na camada de apresenta��o(View);
4. Por padr�o o banco j� est� cadastrado com um usu�rio mestre, usar a seguinte chave de acesso:
  * Usu�rio: admin
  * Senha: admin
5. A funcionalidade(GUI) de 'Venda' est� bloqueada por padr�o at� que se execute a abertura do caixa, para abrir e fechar caixa h� a necessidade de se usar uma senha, por padr�o o sistema j� vem com uma senha mestre cadastrada que �:
  * Abrir e fechar o caixa: 123456789
---------------------------------------------------
**Troubleshooting(FAQ)**
Q - O eclipse falha ao tentar executar a 'main' do sistema devido a arquivos de imagens n�o encontrados.
A - Verificar na arvore do projeto se a pasta(folder) 'assets' est� configurada como 'source folder', se n�o estiver, configure a mesma como tal;
