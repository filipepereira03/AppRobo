# Projeto de Cadastro de Robôs

Este projeto é uma aplicação Java simples para o cadastro de robôs. Ele permite que o usuário insira informações sobre um robô, como ID, nome e modelo, e armazene essas informações em um conjunto. O usuário também pode listar todos os robôs cadastrados.

## Estrutura do Projeto

O projeto é composto por quatro classes principais:

- `Main`: Esta é a classe principal que inicia a aplicação.
- `AppRobo`: Esta classe é responsável pela interface gráfica do usuário e manipulação dos eventos.
- `CadastraRobo`: Esta classe é responsável por adicionar e listar os robôs.
- `Robo`: Esta é a classe de modelo que representa um robô.

## Funcionalidades

- **Cadastro de Robôs**: O usuário pode cadastrar um robô fornecendo um ID (número inteiro), nome (apenas letras e espaços são permitidos) e modelo. Se um robô com o mesmo ID já existir, o sistema não permitirá o cadastro.
- **Listagem de Robôs**: O usuário pode listar todos os robôs cadastrados.
- **Limpar Campos**: O usuário pode limpar todos os campos de entrada.

## Como Executar

Para executar este projeto, você precisa ter o Java instalado em seu sistema. Abra o projeto no IntelliJ IDEA e execute a classe `Main`.
