Adapter Pattern

Estrutura de Classes
Pessoa
Classe que representa uma pessoa com os atributos:

nome: String
idade: int
email: String

RepositorioDePessoas (Interface)
Interface que define o contrato para qualquer repositório de pessoas.

PessoaCsvAdapter
Adapter que implementa a interface RepositorioDePessoas, mas fornece os dados de um arquivo .csv.

Lê um arquivo CSV no formato: nome,idade,email

Ignora o cabeçalho
Cria objetos Pessoa a partir de cada linha
Retorna uma List<Pessoa>
