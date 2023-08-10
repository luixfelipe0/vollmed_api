# vollmed_api
API Rest de um aplicativo de uma clínica médica, desenvolvido usando Java Spring Boot.

![Captura de tela da documentação da API, na interface do Swagger UI.](https://github.com/luixx0/vollmed_api/assets/119303049/6c220816-52e9-4e56-9628-1b524982d874)


#DESCRIÇÃO E FUNCIONALIDADES DO PROJETO

Vollmed é um aplicativo de uma clínica médica, com o objetivo de realizar as funcionalidades de cadastrar, listar, atualizar e deletar tanto um médico quanto um paciente no MySQL, que foi utilizado como o banco de dados desse projeto. Outra funcionalidade notável é a de cadastro e cancelamento de consultas.

O projeto contém um sistema de segurança utilizando TokensJWT, para simular a autenticação de um usuário logado no sistema, visto que a política de criação de sessão dessa API é de STATELESS, ou seja, ela não guarda sessão.

Toda a configuração de segurança foi testada, e é necessário devolver no cabeçalho de todas as requisições, o TokenJWT recebido no momento do login.

Foram respeitadas todas as regras de negócio da aplicação, tratanto as exceções caso haja invalidação dessas regras, que são elas:

- O paciente não pode marcar uma consulta com um médico já ocupado naquele dia e naquele horário.
- O paciente não pode marcar duas consultas no mesmo dia.
- O paciente não pode marcar uma consulta fora do horário de funcionamento da clínica. (Seg - Sab / 07h às 19h)
- O paciente não pode marcar uma consulta com um médico inativo no sistema.
- O paciente inativo no sistema não pode marcar uma consulta.
- O paciente deve marcar uma consulta com no mínimo 30 minutos de antecedência.

Também foi utilizado as migrations com o flyway, para fazer o controle de versão do banco de dados, adicionando e criando novas tabelas e colunas no MySQL, além de querys personalizadas para determinados métodos nos repositories, para fazer select no banco de dados.

#TECNOLOGIAS USADAS

Nesse projeto foi utilizado as seguintes dependências com o Maven:

- DevTools
- Lombok
- Spring Boot starter JPA
- Spring Boot starter validation
- Spring Boot starter security
- Spring Boot starter test
- MySQL flyway
- auth0 jwt
- junit

Todo o projeto foi desenvolvido através do IntelliJ IDEA, utilizando a linguagem Java e o framework Spring Boot, foi utilizado de testes automatizados e unitários das funcionalidades envolvendo os Controllers e os Repositories, e documentado usando o Swagger UI.

#AGRADECIMENTOS

Esse projeto foi desenvolvido com a formação Java e Spring Boot da Alura, deixo aqui meus agradecimentos ao instrutor Rodrigo Ferreira.
