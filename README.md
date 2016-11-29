**Sistema de Farmácia 2.0**
---------------------------------------------------

Este projeto foi apresentado como trabalho 2 nas disciplinas de Programação orientada ao objeto e Estrutura de dados II
formado por:
        Nome       |     Prontuario
------------------ | ---------------
   André T. Silva  |  156219-3
  Andrey Nagatani  |  156215-1
Victor P. de Assis |  146258-x

---------------------------------------------------
**Instruções de uso:**
1. Executar script de bando de dados Mysql encontrado na pasta 'MYSQLBD';
2. Se houver necessidade, configurar String de usuario e senha de conexão com o BD na classe 'ConnectionFactory.java' econtrado na camada DAO do projeto;
  * Por padrão a String de conexão está configurada com usuário = 'root' e sem senha ou seja pwd ="";
3. Executar a 'Main' do projeto, encontrada na classe 'FrmLogin.java' na camada de apresentação(View);
4. Por padrão o banco já está cadastrado com um usuário mestre, usar a seguinte chave de acesso:
  * Usuário: admin
  * Senha: admin
5. A funcionalidade(GUI) de 'Venda' está bloqueada por padrão até que se execute a abertura do caixa, para abrir e fechar caixa há a necessidade de se usar uma senha, por padrão o sistema já vem com uma senha mestre cadastrada que é:
  * Abrir e fechar o caixa: 123456789
---------------------------------------------------
**Troubleshooting(FAQ)**
Q - O eclipse falha ao tentar executar a 'main' do sistema devido a arquivos de imagens não encontrados.
A - Verificar na arvore do projeto se a pasta(folder) 'assets' está configurada como 'source folder', se não estiver, configure a mesma como tal;
