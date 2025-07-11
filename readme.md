# Biblioteca Spring

## Tecnologias

Linguagem de Programação e Plataforma

    Java: A linguagem de programação principal, escolhida pela sua robustez, performance e vasta comunidade.

    Spring Boot: Um poderoso framework para Java que simplifica o desenvolvimento de aplicações standalone, prontas para produção, com foco em APIs RESTful e microserviços.

Persistência de Dados

    H2 Database: Um banco de dados relacional em memória, utilizado para o ambiente de desenvolvimento e testes. Sua leveza e a capacidade de ser descartado ao final da execução da aplicação o tornam ideal para prototipagem e testes rápidos.

    JPA (Java Persistence API): A especificação padrão do Java para o mapeamento objeto-relacional, permitindo que objetos Java interajam com o banco de dados de forma intuitiva.

    Hibernate: A implementação de ORM (Object-Relational Mapping) que o Spring Boot utiliza por padrão para o JPA, gerenciando a persistência e recuperação de dados entre os objetos Java e o banco de dados.

Construção e Gerenciamento de Dependências

    Maven: Uma ferramenta de automação de construção e gerenciamento de projetos que organiza a estrutura do código, gerencia as dependências (bibliotecas) e automatiza o processo de compilação.

Ferramentas de Desenvolvimento e Auxiliares

    Lombok: Uma biblioteca que reduz a quantidade de código boilerplate (repetitivo), como getters, setters e construtores, através de anotações, tornando o código mais limpo e legível.

    Spring Boot DevTools: Um módulo que oferece funcionalidades para acelerar o ciclo de desenvolvimento, como o recarregamento automático da aplicação após alterações no código.

    H2 Console: Uma interface web que permite visualizar e interagir diretamente com o banco de dados H2 durante o desenvolvimento, facilitando a depuração e a inspeção de dados.

    dbdiagram.io: Uma ferramenta online utilizada para modelar e visualizar o esquema do banco de dados de forma gráfica, a partir de uma linguagem textual (DBML), auxiliando no design da estrutura de dados.

## Diagrama do banco de dados

[Meu Diagrama de Banco de Dados de Livros e Autores](https://dbdiagram.io/d/687060b6f413ba3508568963 "Veja o diagrama do meu banco de dados de livros e autores")]

## Instruções

Banco de Dados (H2 em memória)

O projeto utiliza H2 Database em memória. Para acessar o console durante o desenvolvimento:

Com a aplicação rodando, vá para:
http://localhost:8080/h2-console

Use as credenciais:

    JDBC URL: jdbc:h2:mem:biblioteca_db

    User Name: sa

    Password: (deixe em branco)

Clique em "Connect".



