create table usuario ( 
nome varchar(40), 
cargo varchar(35), 
login varchar(35) not null, 
senha varchar (35) not null, 
email varchar(50),
primary key(login)); 

create table cliente (
id int not null auto_increment,
nome varchar (40),
endereco varchar (50),
uf varchar(02),
telefone varchar(15),
documento varchar(15),
email varchar(50),
tipo enum('credor','devedor'),
primary key(id));

create table divida (
id int not null auto_increment,
credor int,
devedor int,
data_atualizacao date,
valor_divida float,
primary key (id),
foreign key (credor) references cliente(id),
foreign key (devedor) references cliente(id)
);

create table pagamento (
id int not null auto_increment,
divida int,
data_pagamento date,
valor_pago float,
primary key (id),
foreign key (divida) references divida(id));

create table registra_pagamento (
id int not null auto_increment,
data_pagamento date,
id_usuario varchar(35),
id_devedor int,
id_credor int,
primary key (id),
foreign key (id_usuario) references usuario(login),
foreign key (id_devedor) references cliente(id),
foreign key (id_credor) references cliente(id));

create table inscreve_divida (
id int not null auto_increment,
data_inscricao date,
id_usuario varchar(35),
id_devedor int,
id_credor int,
primary key (id),
foreign key (id_usuario) references usuario(login),
foreign key (id_devedor) references cliente(id),
foreign key (id_credor) references cliente(id));

