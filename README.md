# LiterAlura
​
![Java](https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=java)
![Spring](https://img.shields.io/badge/Spring_Boot-3-green?style=for-the-badge&logo=spring)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13-blue?style=for-the-badge&logo=postgresql)

​
Aplicação de console para consulta de livros, desenvolvida como parte do desafio do programa **Oracle Next Education (ONE) G6** em parceria com a Alura. A aplicação permite que usuários busquem por livros em uma API externa, e salvem os dados em um banco de dados local.
​
## ✨ Funcionalidades
​
-   **Busca de Livros por Título**: Permite ao usuário buscar livros pelo título na API da Gutendex.
-   **Listagem de Livros Registrados**: Exibe todos os livros que foram salvos no banco de dados local.
-   **Listagem de Autores Registrados**: Exibe todos os autores que foram salvos no banco de dados.
-   **Listagem de Autores Vivos em Determinado Ano**: Permite filtrar e listar autores que estavam vivos em um ano específico.
-   **Listagem de Livros por Idioma**: Exibe a quantidade de livros para cada idioma registrado no banco de dados.
-   **Persistência de Dados**: Utiliza Spring Data JPA para salvar, atualizar e consultar dados de livros e autores no banco de dados PostgreSQL.
    ​
## 🛠️ Tecnologias Utilizadas
​
-   **Java 17**: Versão mais recente do Java com suporte de longo prazo (LTS).
-   **Spring Boot 3**: Framework para facilitar a criação de aplicações Java.
-   **Spring Data JPA**: Para facilitar a comunicação com o banco de dados e a persistência de dados.
-   **PostgreSQL**: Banco de dados relacional para armazenar os dados da aplicação.
-   **Maven**: Gerenciador de dependências do projeto.
-   **API da Gutendex**: API pública para obter os dados dos livros.
-   **Jackson**: Biblioteca para converter objetos Java para JSON e vice-versa.
    ​
## ⚙️ Pré-requisitos
​
Antes de começar, você vai precisar ter instalado em sua máquina:
-   Java JDK 17 ou superior
-   Maven 3.8 ou superior
-   PostgreSQL 13 ou um banco de dados compatível.
-   Acesso à internet para consultar a API da Gutendex.
    ​
## 🚀 Como Executar
​
1.  **Configure o banco de dados:**
    - Crie um banco de dados no PostgreSQL chamado `literalura`.
    - Atualize as credenciais do banco de dados no arquivo `application.properties`.
2.  **Execute a aplicação:**
    - Abra o projeto em sua IDE de preferência.
    - Execute a classe `LiteraluraApplication.java`.
