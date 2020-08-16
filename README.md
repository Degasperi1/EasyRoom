# EasyRoom

O EasyRoom é um sistema desenvolvido para o ramo hoteleiro. O sistema permite o gerenciamento completo de um hotel ou uma cadeia de hotéis.

No escopo inicial do EasyRoom, estão previstas as seguintes funcionalidades:
  - Cadastro e manutenção de quartos, salões e demais dependências do estabelecimento.
  - Cadastro de clientes (pessoas físicas e jurídicas)
  - Cadastro de produtos.
  - Gerência de estoque.
  - Reserva de hospedagens.


#Script inicial do Banco

-- CRIAÇÃO DAS TABELAS

create table estado(id_estado serial not null, ds_estado varchar(45) not null, 
	ie_estado varchar(2) not null, ie_situacao varchar(1) not null,
	constraint PK_estado primary key (id_estado));

create table cidade(id_cidade serial not null, ds_cidade varchar(45) not null, id_usuario_cadastro integer not null, 
	ie_situacao varchar(1) not null, id_estado integer not null,
	constraint PK_cidade primary key (id_cidade),
	constraint FK_cidade_estado foreign key (id_estado) references estado);

create table produto(id_produto serial not null, ds_produto varchar(45) not null, vl_venda decimal(11,2) not null,
	id_usuario_cadastro integer not null, ie_situacao varchar(1) not null,
	constraint PK_produto primary key (id_produto));

create table permissao(id_permissao serial not null, ds_permissao varchar(45) not null, id_usuario_cadastro integer not null, 
	ie_situacao varchar(1) not null,
	constraint PK_permissao primary key (id_permissao));

create table tipo_quarto(id_tipo_quarto serial not null, ds_tipo_quarto varchar(45) not null, nr_capacidade integer not null, 
	nr_comodo integer not null, nr_banheiro integer not null, id_usuario_cadastro integer not null, vl_reserva decimal(11,2) not null, 
	ie_situacao varchar(1) not null, 
	constraint PK_tipo_quarto primary key (id_tipo_quarto)); 

create table quarto(id_quarto serial not null, nr_quarto varchar(45) not null, nr_andar varchar(45) not null, 
	id_usuario_cadastro integer not null, ie_situacao varchar(1) not null, id_tipo_quarto integer not null, 
	constraint PK_quarto primary key (id_quarto),
	constraint FK_quarto_tipo_quarto foreign key (id_tipo_quarto) references tipo_quarto);

create table entidade(id_entidade serial not null, ds_endereco varchar(45) not null, ds_bairro varchar(45) not null, 
	nr_endereco varchar(45) not null, ie_situacao varchar(1) not null, id_usuario_cadastro integer not null, 
	nr_telefone varchar(45), nr_celular varchar(45), ds_email varchar(45), id_cidade integer not null, 
	constraint PK_entidade primary key (id_entidade), 
	constraint FK_entidade_cidade foreign key (id_cidade) references cidade);

create table pessoa_fisica(id_pessoa_fisica serial not null, nm_pessoa_fisica varchar(45) not null, 
	nr_cpf varchar(11) not null, nr_rg varchar(10) not null, dt_nascimento date not null, ie_sexo varchar(45) not null, 
	id_entidade integer not null,
	constraint PK_pessoa_fisica primary key (id_pessoa_fisica), 
	constraint FK_pessoa_fisica_entidade foreign key (id_entidade) references entidade);

create table usuario(id_usuario serial not null, ds_usuario varchar(45) not null, ds_senha varchar(45) not null, 
	dt_criacao date not null, dt_alteracao_senha date not null, id_pessoa_fisica integer not null, 
	constraint PK_usuario primary key (id_usuario), 
	constraint FK_usuario_pessoa_fisica foreign key (id_pessoa_fisica) references pessoa_fisica);

create table permissao_usuario(id_permissao integer not null, id_usuario integer not null, 
	id_usuario_cadastro integer not null, 
	constraint PK_permissao_usuario primary key (id_permissao, id_usuario), 
	constraint FK_permissao_usuario_permissao foreign key (id_permissao) references permissao,
	constraint FK_permissao_usuario_usuario foreign key (id_usuario) references usuario);

create table funcionario(id_funcionario serial not null, dt_admissao date not null, vl_salario decimal(11,2) not null, 
	dt_demissao date, nr_ctps varchar(45), nr_serie varchar(45), nr_pis varchar(45), dt_expedicao_ctps varchar(45), 
	id_pessoa_fisica integer not null, 
	constraint PK_funcionario primary key (id_funcionario), 
	constraint FK_funcionario_pessoa_fisica foreign key (id_pessoa_fisica) references pessoa_fisica);

create table pessoa_juridica(id_pessoa_juridica serial not null, nm_fantasia varchar(45) not null,
 	nm_razao_social varchar(45) not null, nr_cnpj varchar(45) not null, id_entidade integer not null, 
 	constraint PK_pessoa_juridica primary key (id_pessoa_juridica), 
 	constraint FK_pessoa_juridica_entidade foreign key (id_entidade) references entidade);

create table reserva(id_reserva serial not null, dt_reserva date not null, vl_total_reserva decimal(11,2) not null,  
	id_usuario_cadastro integer not null, id_entidade integer not null, 
	constraint PK_reserva primary key (id_reserva), 
	constraint FK_reserva_entidade foreign key (id_entidade) references entidade);

create table reserva_quarto(id_reserva integer not null, id_quarto integer not null, 
	dt_inicio date not null, dt_fim date not null,
	constraint PK_reserva_quarto primary key (id_reserva, id_quarto), 
	constraint FK_reserva_quarto_reserva foreign key (id_reserva) references reserva, 
	constraint FK_reserva_quarto_quarto foreign key (id_quarto) references quarto);

create table lote(id_lote serial not null, dt_lote date not null, vl_lote decimal(11,2) not null, 
	id_usuario_cadastro integer not null, id_entidade integer not null, 
	constraint PK_lote primary key (id_lote), 
	constraint FK_lote_entidade foreign key (id_entidade) references entidade);

create table lote_produto(id_produto integer not null, id_lote integer not null, dt_validade date not null, 
	qt_produto integer not null, vl_compra decimal(11,2) not null, 
	constraint PK_lote_produto primary key (id_produto, id_lote), 
	constraint FK_lote_produto_lote foreign key (id_lote) references lote, 
	constraint FK_lote_produto_produto foreign key (id_produto) references produto);


