Create database dbrevenda;
Use dbrevenda;

Create table carro
	Id_carro int not null primary key
	, Marca varchar(255) not null,
	, Modelo varchar(255) not null
	
;


Create table estoque
	Id_carro int not null primary key
	, ano date not null
	, cor varchar(45) not null
	, quilometragem double not null
	, placa varchar(10)
	, valorFIPE double not null
	
;

Create table vendedores
Id_vendedor int not null primary key
, Nome varchar (45)
, Sexo varchar (15)
, Cpf varchar (11)
, Celular varchar (11) 
;

Create table cliente
Id_cliente
, Nome varchar (45)
, Sexo varchar (15)
, Cpf varchar (11)
, Tel_residencial
, Tel_celular
;
Create table vendas
Id_vendas primary key
, Id_cliente foreing key
, Id_modelo foreing key
, Id_vendedor foreing key
, valor_revenda double not null
, data date
;