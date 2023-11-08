create database blvcrud;
use blvcrud;


create table clientes(
	idcli int primary key auto_increment,
    nome varchar(50) not null,
    email varchar(150) not null,
    senha varchar(50) not null
);

describe clientes;

insert into clientes (nome, email, senha) values ('Kilderys Abreu', 'kilderysabreu@recode.com', '123123');
select * from clientes;