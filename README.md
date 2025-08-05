# 📚 Biblioteca API REST em Java
API REST para gerenciamento de uma biblioteca, construída do zero em Java com Spring Boot, sem dependência de Lombok.  Permite gerenciar autores, editoras, livros, usuários e empréstimos com regras de negócio 
básicas como controle de estoque, devolução e verificação de atrasos.

##

## 🛠 Tecnologias Utilizadas
- Java (versão 24.0.1 - Oracle OpenJDK);
- Spring Boot (Web, Data JPA, Validation);
- H2 Database (em memória);
- Maven;
- Console/Postman/curl para testes da API.

##

## ✅ Funcionalidades

### 🎯 CRUD Básico
- **Autor**: criar, listar, buscar por ID, atualizar e deletar;
- **Editora**: criar, listar, buscar por ID, atualizar e deletar;
- **Livro**: criar (com vínculo a autor e editora), listar, buscar, atualizar e deletar. Verifica ISBN duplicado;
- **Usuário**: criar, listar, buscar, atualizar e deletar.

### 📚 Empréstimos
- Criar empréstimo: valida se livro existe e tem estoque, reduz estoque automaticamente, define data prevista (7 dias);
- Devolver: registra data de devolução real e repõe o estoque;
- Listar empréstimos ativos de um usuário;  
- Listar empréstimos atrasados (data prevista passada e sem devolução);  
- Buscar empréstimo por ID, listar todos e deletar.  

### 🔍 Validações e Regras
- Validações via DTOs (`@NotBlank`, `@NotNull`, intervalos e outros.);
- Tratamento de ausência de recursos com exceções (`ResourceNotFoundException`);  
- Impede criar empréstimo se não houver estoque;  
- Não permite devolver mais de uma vez; 
- Respostas padronizadas de erro com handler global.  

##

## 🔐 Validações e Tratamento de Erros
- Entradas são validadas com anotações (@NotBlank, @NotNull, @Min, @Email);
- Recursos inexistentes retornam 404 Not Found com mensagem;
- Tentativas inválidas (ex: ISBN duplicado, empréstimo sem estoque, devolução dupla) retornam 400 Bad Request;
- Erros não esperados retornam 500 Internal Server Error padronizado.

##

## 📦 Requisitos
- Java 24.0.1 (ou compatível) instalado;
- Maven instalado;
- IntelliJ IDEA ou outra IDE para compilar e executar o código;
- Qualquer cliente HTTP (Postman, curl);
- Ambiente com porta 8080 livre.

##

## 📁 Estrutura do Projeto
````
src/main/java/com/example/todolist/
├── controller/
│   └── TarefaController.java
├── controller/exception/
│   └── GlobalExceptionHandler.java
├── model/
│   └── Tarefa.java
├── repository/
│   └── TarefaRepository.java
├── service/
│   └── TarefaService.java
├── service/impl/
│   └── TarefaServiceImpl.java
└── ApiRestNuvemApplication.java
````

##

## ⚙️ Como Usar
1. Clone ou copie o repositório para sua máquina;  
2. Abra o projeto no IntelliJ IDEA;  
3. Compilar e rodar: `mvn clean install` e depois `mvn spring-boot:run`;
4. Acessar banco H2;
5.Testar endpoints com Postman/curl.
