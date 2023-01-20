# 💲 PROJETO DE LOCADORA DE VEICULOS - SANTANDER CODERS
> *Turma 938 - Santander Coders - Trilha Web FullStack*

### 😎 Grupo:
- Ailton Luz
- Felipe Zanardo
- Matheus Ribeiro Panobianco
- Ramon Carvalho

## 📋 Projeto - Programação Orientada a Objetos II

> Para executar o projeto é necessário adicionar a biblioteca Gson, onde o arquivo .jar está disponível na subpasta biblioteca-jar dentro pasta src.

##  Enunciado do Projeto

Criar uma aplicação que gerencie o aluguel de veículos, onde cada item abaixo seja considerado:

### Itens obrigatórios
- Cadastrar os veículos;
- Alterar um veículo cadastrado;
- Buscar um veículo por parte do nome;
- Cadastrar a agência onde o veículo será alugado/devolvido;
- Alterar a agência onde o veículo será alugado/devolvido;
- Buscar uma agência por parte do nome ou do logradouro do endereço;
- Cadastrar o cliente (pessoa fisica/juridica)
- Alterar o cliente (pessoa fisica/juridica)
- Alugar um veículo para pessoa fisica;
- Alugar um veículo para pessoa juridica;
- Devolver um veículo para pessoa fisica;
- Devolver um veículo para pessoa juridica;
- Gerar um comprovante com todos os dados do aluguel (aberto para o grupo decidir o que vai ser demonstrado);
- Gerar um comprovante com todos os dados da devolução (aberto para o grupo decidir o que vai ser demonstrado);

### Itens bônus
- Paginar as listas envolvidas;
- Os dados deverão ser gravados em arquivos, simulando uma base de dados;

### Regras de negócio
* RN1: Os veículos não podem ser repetidos;
* RN2: Tipos de veículos que serão considerados: Carro, Moto, Caminhões;
* RN3: Os aluguéis e devoluções terão o local, data e horario;
* RN4: Os veículos que estiverem alugados não poderão estar disponíveis;
* RN5: Agências não podem estar duplicadas;
* RN6: Clientes não podem estar duplicados;
* RN7: Regras de devolução:
    - Caso pessoa fisica tenha ficado com o carro mais que 5 dias terá direito a 5% de desconto.
    - Caso pessoa juridica tenha ficado com o carro mais que 3 dias terá direito a 10% de desconto.
* Valores base da diária por tipo de veículo:
    - Tipo de Veículo	Valor por dia
        1. Moto	R$ 100,00
        2. Carro	R$ 150,00
        3. Caminhão	R$ 200,00
        
### Entregas
- O projeto deverá ser em grupo de 5 pessoas;
- O projeto deverá ser entregue no github;
- Realizar uma apresentação apresentando os pontos mais desafiadores do projeto, os perrengues passados e um resumo do que foi entregue e o que não pode ser entregue;
- Explicar onde aplicaram os pontos aprendidos nesse módulo;
  Destacando os príncipios SOLID aplicados, e os que não foram utilizados o porquê.
