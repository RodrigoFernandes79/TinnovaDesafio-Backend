
# Projeto API JSON RESTfull 

 Desafio de uma aplicação de um cadastro de veículo finalizado para o processo seletivo Tinnova

### Especificação da Entidade Veiculo
```
{
    veiculo : String,
    marca : String,
    ano : Integer,
    descricao : text,
    vendido : boolean,
    created : datetime,
    updated : datetime
}
```
## Tecnologias utilizadas no Projeto:
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- MySql
- Insomnia 


## Aplicações  do Projeto:
- Permitir o cadastro de veículos;
- Permitir atualização de dados de um veículo;
- Permitir a exclusão de um veículo;
- Exibir a informação de quantos veiculos estão como não vendidos na base;

## Aplicação  em Camadas:

![AlicacaoCamadas](https://user-images.githubusercontent.com/83513696/139479915-43c64049-3370-4e32-8b83-914fa8ee9111.png)
### Usamos o padrão camadas separando a aplicação backend em três camadas: 
- Controladores Rest (Resource)
- Camada de Serviços (Service)
- Camada de Acesso a dados (Repository)
### Todas as três camadas conversam com a Entidade Veiculo.


## Endpoints das APIs no Insomnia:
#### Buscar os registros de veículos na base (GET):
```
http://localhost:8080/veiculos
```
![mostrarVeiculos](https://user-images.githubusercontent.com/83513696/139466908-a8075671-6334-4086-a566-51bb00af5d0d.png)

#### Buscar os registros da quatidade de veículos que não foram vendidos base (GET):
```
http://localhost:8080/veiculos/VeiculosNaoVendidos
```
![veiculosNaoVendidos](https://user-images.githubusercontent.com/83513696/139474141-b5155152-71af-4d89-9753-6e69780ccbd9.png)
#### Buscar informações do veiculo por ID (GET)
```
http://localhost:8080/veiculos/15
```
![mostrarVeiculoId](https://user-images.githubusercontent.com/83513696/139468973-1a6c8eb0-68b6-47d6-9ef2-89844aebc7be.png)
#### Cadastrar veiculo na base (POST)

- JSON da entrada de dados do veiculo
```
{
    "veiculo": "Palio",
    "marca":"Fiat",
    "ano":2004,
    "descricao":"Único Dono!",
    "vendido":true,
    "created":"2019-03-04T14:44:01.544+00:00"
}
```
```
http://localhost:8080/veiculos
```
![criarVeiculo](https://user-images.githubusercontent.com/83513696/139471554-33324eac-cf83-458f-8129-358a11a4c523.png)
#### Atualizar informações de veiculo (PUT)
```
http://localhost:8080/veiculos/1
```
- JSON da entrada de dados do veiculo 
```
{
   "veiculo": "Onix",
    "marca": "Chevrolet",
    "ano": 2016,
    "descricao":"Veículo em perfeito estado!",
    "vendido": false,
    "created": "2021-10-27T23:59:02Z",
    "updated": null
}
```
![criarVeiculo](https://user-images.githubusercontent.com/83513696/139470579-2daa80d9-71c8-42e4-8cfc-1df24722e92f.png)
#### Atualizar apenas se o veiculo foi vendido ou não (PATCH)
```
http://localhost:8080/veiculos/1
```
- JSON da entrada de dados para atualização. Neste endpoint apenas o atributo vendido pode ser alterado.
```
{
    "vendido":true	
}
```
![atualizarRestricoes](https://user-images.githubusercontent.com/83513696/139472252-d446806e-2007-43ad-a896-8218b0ae5a1a.png)
#### Deletar o veiculo registrado na base (DELETE)
```
http://localhost:8080/veiculos/20
```
![deletarPorId](https://user-images.githubusercontent.com/83513696/139472966-a863c66d-30c4-4b25-b3a0-9fb8c62c0965.png)
## Aplicação persistida no Banco de Dados MySql:
![tabelaVeiculo](https://user-images.githubusercontent.com/83513696/139478268-76668486-a02f-49dc-9deb-ae03df574919.png)

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/RodrigoFernandes79/TinnovaDesafio-Backend.git

# executar o projeto
./mvnw spring-boot:run
```
# Autor

Rodrigo Holanda Fernandes
