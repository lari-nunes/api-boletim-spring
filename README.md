# API de Boletim Escolar 🏫 
## Sobre o projeto
Este projeto é desenvolvendo uma API RESTful que permite cadastrar alunos, cursos, disciplinas e notas. Também permite gerar boletins escolares, com o status de aprovação ou reprovação do aluno, levando em consideração a média 7.

## Índice
- [Tecnologias](#tecnologias)
- [Instalação](#instalação)
- [Acessar projeto](#acessar-projeto)
- [API Endpoints](#api-endpoints)

## Tecnologias 
- Java 17
- Spring Boot 3.2.0
- Maven
- Lombok
- Spring Web
- Spring JPA
- MySQL

## Instalação

1. Clona o repositório:

```bash
git clone https://github.com/lari-nunes/trabalho-java-spring.git
```
2. Entre na pasta do projeto
3. Instale dependências com Maven

## Acessar projeto
O projeto está acessível no endereço http://localhost:8080/.

## API Endpoints
A API fornece os seguintes endpoints:

- Aluno
```markdown
GET /aluno - Acessar alunos 

POST /aluno - Criar um novo aluno

PUT /aluno/{id} - Atualizar um aluno

DELETE /aluno/{id} - Deletar um aluno

```
- Curso
```markdown
GET /curso - Acessar cursos 

POST /curso - Criar um novo curso

PUT /curso/{id} - Atualizar um curso

DELETE /curso/{id} - Deletar um curso
```
- Disciplina
```markdown
GET /disciplina - Acessar disciplinas 

POST /disciplina - Criar uma nova disciplina

PUT /disciplina/{id} - Atualizar uma disciplina

DELETE /disciplina/{id} - Deletar uma disciplina
```
- Boletim
```markdown
GET /boletim - Acessar boletins 

POST /boletim - Criar um novo boletim

PUT /boletim/{id} - Atualizar um boletim

DELETE /boletim/{id} - Deletar um boletim
```
<div align="center">
Projeto feito por Larissa Nunes ❤️
</div>
