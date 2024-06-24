# Iniflex test

Este projeto é uma aplicação Java que manipula uma lista de funcionários, realizando diversas operações como inserção, remoção, aumento salarial, agrupamento por função, entre outras.

## Estrutura do Projeto

O projeto contém as seguintes classes:

- `Pessoa`: Representa uma pessoa com atributos `nome` e `data de nascimento`.
- `Funcionario`: Estende a classe `Pessoa` e adiciona os atributos `salário` e `função`.
- `Principal`: Classe principal que executa as operações descritas abaixo.

## Funcionalidades

1. Inserir todos os funcionários, na mesma ordem e informações da tabela.
2. Remover o funcionário “João” da lista.
3. Imprimir todos os funcionários com todas suas informações.
    - A informação de data deve ser exibida no formato `dd/MM/aaaa`.
    - A informação de valor numérico deve ser exibida no formato com separador de milhar como ponto e decimal como vírgula.
4. Atualizar a lista de funcionários com novo valor após aumento de 10% no salário.
5. Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
6. Imprimir os funcionários, agrupados por função.
7. Imprimir os funcionários que fazem aniversário no mês 10 e 12.
8. Imprimir o funcionário com a maior idade.
9. Imprimir a lista de funcionários por ordem alfabética.
10. Imprimir o total dos salários dos funcionários.
11. Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.

## Pré-requisitos

- Java 17 ou superior
- IDE de sua preferência (recomendado: Eclipse)

## Como Executar

1. Clone este repositório:
    ```sh
    git clone https://github.com/SEU_USUARIO/FuncionarioProject.git
    ```
2. Abra o projeto em sua IDE de preferência.
3. Navegue até a classe `Principal` e execute o método `main`.

## Exemplo de Saída

A saída do programa incluirá:

- Lista de funcionários com suas informações formatadas.
- Funcionários agrupados por função.
- Funcionários que fazem aniversário nos meses de outubro e dezembro.
- Funcionário com a maior idade.
- Lista de funcionários em ordem alfabética.
- Total dos salários dos funcionários.
- Quantidade de salários mínimos que cada funcionário ganha.

## Contato

Para mais informações, entre em contato com [douglasrodriguesdepaula@hotmail.com](mailto:seu_email@example.com).
