# Sistema de Gerenciamento de Pedidos em Java

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-11%2B-blue)
![Database](https://img.shields.io/badge/Database-JDBC-orange)
![Build](https://img.shields.io/badge/Build-Maven-red)

## 📖 Sobre o Projeto

Este projeto é uma aplicação de console (CLI - Command-Line Interface) desenvolvida em Java para simular um sistema básico de gerenciamento de pedidos. Foi criado como parte do meu portfólio de estudos para aplicar e demonstrar conhecimentos fundamentais em Java, incluindo Orientação a Objetos, manipulação de coleções, e persistência de dados com JDBC.

A aplicação permite ao usuário realizar operações de **CRUD** (Create, Read, Update, Delete) para as principais entidades de um sistema de vendas: Clientes, Produtos e Pedidos.

## ✨ Funcionalidades

-   **Gerenciamento de Clientes:**
    -   [✔️] Cadastrar novos clientes.
    -   [✔️] Listar todos os clientes cadastrados.
    -   [✔️] Atualizar informações de um cliente existente.
    -   [✔️] Deletar um cliente.

-   **Gerenciamento de Produtos:**
    -   [✔️] Cadastrar novos produtos no catálogo.
    -   [✔️] Listar todos os produtos.
    -   [✔️] Atualizar o preço ou nome de um produto.
    -   [✔️] Deletar um produto.

-   **Gerenciamento de Pedidos:**
    -   [✔️] Criar novos pedidos associados a um cliente.
    -   [✔️] Adicionar múltiplos produtos e suas quantidades a um pedido.
    -   [✔️] Exibir um resumo completo do pedido, incluindo os itens e o valor total.
    -   [✔️] Listar pedidos realizados.
    -   [✔️] Atualizar o status de um pedido (ex: de `PROCESSANDO` para `ENVIADO`).

## 🛠️ Tecnologias Utilizadas

-   **Linguagem:** Java 11+
-   **Persistência de Dados:** JDBC (Java Database Connectivity)
-   **Banco de Dados:** H2 Database (ou qualquer banco de dados relacional com driver JDBC)
-   **Gerenciador de Dependências:** Apache Maven
-   **Interface:** Console (CLI)

## 🏛️ Arquitetura e Padrões de Projeto

A aplicação foi estruturada com foco na **separação de responsabilidades** para garantir um código mais limpo, organizado e de fácil manutenção.

-   **Padrão DAO (Data Access Object):** A lógica de acesso ao banco de dados foi isolada em uma camada de DAOs. Para cada entidade principal (`Client`, `Product`, `Order`), existe uma interface DAO definindo as operações de persistência e uma implementação concreta com o código JDBC.

-   **Estrutura de Pacotes:**
    -   `entities`: Contém as classes de modelo (POJOs).
    -   `dao`: Contém as interfaces DAO.
    -   `dao.impl`: Contém as implementações JDBC das interfaces DAO.
    -   `Main.java`: Ponto de entrada da aplicação, responsável pelo menu interativo com o usuário.

## 🚀 Como Executar o Projeto

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:
-   [Java JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) ou superior.
-   [Apache Maven](https://maven.apache.org/download.cgi).
-   Um cliente Git.

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    ```

2.  **Navegue até a pasta do projeto:**
    ```bash
    cd seu-repositorio
    ```

3.  **Compile o projeto e baixe as dependências com o Maven:**
    ```bash
    mvn clean install
    ```

4.  **Execute a aplicação:**
    ```bash
    java -cp target/classes Main
    ```

Após a execução, um menu interativo aparecerá no console para que você possa utilizar o sistema.

## 📈 Roadmap (Próximos Passos)

-   [ ] Implementar uma camada de Serviços para a lógica de negócio.
-   [ ] Adicionar tratamento de exceções mais robusto.
-   [ ] Criar testes unitários com JUnit para os DAOs e Serviços.
-   [ ] Evoluir o projeto para uma API REST utilizando o framework Spring Boot.
-   [ ] Criar uma interface gráfica (GUI) com JavaFX ou Swing.

## 👨‍💻 Autor

Feito com ❤️ por **[Victor Américo]**
