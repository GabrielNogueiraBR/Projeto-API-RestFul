# Projeto API RestFul
 Repositório criado para armazenar o projeto desenvolvido durante a aula de Programação Orientada a Objetos na Faculdade de Engenharia de Sorocaba (FACENS) pelo aluno Gabriel Augusto Nogueira.

## Projeto: 

1. Construa uma API RestFul com SpringBoot, seguindo os modelos e a arquitetura de sistema apresentados durante a disciplina. 
1. Esse projeto terá 2 modelos. Temos os seguintes modelos: Escola e  Curso
    - Uma Escola possui vários Cursos e um Curso só pode ser de uma Escola.
    - Defina pelo menos 5 atributos para cada uma das classes acima a sua escolha. O código de cada modelo deverá ser gerado automaticamente. 
1. Implemente as seguintes funcionalidades (endpoints) nos Controladores:

**Escola:**

- Listar todas as escolas
- Listar uma escola pelo código
- Cadastrar uma escola
- Remover uma escola (somente se ela não tiver cursos)
- Alterar os dados de uma escola (Somente 2 dados/atributos podem ser alterados)
- Listar todos os cursos de uma escola

**Curso:**

- Cadastrar um curso (sempre associar o curso a uma escola).
- Listar todos os cursos.
- Listar um curso pelo código.
- Remover um curso
- Alterar um curso (somente 1 dado do curso poderá ser alterado).