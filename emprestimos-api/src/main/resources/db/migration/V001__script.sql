CREATE TABLE status (
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(30) NOT NULL,
  numero int NOT NULL, 
  descricao varchar(200)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE estado (
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(30) NOT NULL,
  sigla varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cidade(
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  id_estado BIGINT(20) NOT NULL,
  FOREIGN KEY(id_estado) REFERENCES estado(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  descricao varchar(200)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tipo_usuario (
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  descricao varchar(200),
  id_status bigint(20) NOT NULL,	
  FOREIGN KEY(id_status) REFERENCES status(id)	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao_tipo_usuario (
  id_permissao bigint(20) NOT NULL,
  id_tipo_usuario bigint(20) NOT NULL,
  FOREIGN KEY(id_permissao) REFERENCES permissao(id),
  FOREIGN KEY(id_tipo_usuario) REFERENCES tipo_usuario(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario (
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  telefone varchar(15),
  id_status bigint(20) NOT NULL,	
  id_tipo_usuario bigint(20) NOT NULL,  
  FOREIGN KEY(id_status) REFERENCES status(id),	
  FOREIGN KEY(id_tipo_usuario) REFERENCES tipo_usuario(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cliente (
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  observacao varchar(200),
  cpf varchar(15),
  nome_comercio varchar(200),
  id_status bigint(20) NOT NULL,
  id_usuario bigint(20) NOT NULL,
  FOREIGN KEY(id_status) REFERENCES status(id),	
  FOREIGN KEY(id_usuario) REFERENCES usuario(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE endereco(
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  tipo VARCHAR(20) NOT NULL,
  cep VARCHAR(10),
  rua VARCHAR(100) NOT NULL,
  numero VARCHAR(20) NOT NULL,
  bairro VARCHAR(50) NOT NULL,			
  id_cidade BIGINT(20) NOT NULL,
  id_cliente BIGINT(20) NOT NULL,
  FOREIGN KEY(id_cidade) REFERENCES cidade(id),
  FOREIGN KEY(id_cliente) REFERENCES cliente(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE contato (
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  tipo varchar(30) NOT NULL,
  email varchar(100),
  fixo varchar(15),
  celular varchar(15),
  id_cliente bigint(20) NOT NULL,
  FOREIGN KEY(id_cliente) REFERENCES cliente(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE conta(
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  saldo decimal NOT NULL,
  id_status bigint(20) NOT NULL,
  id_usuario bigint(20) NOT NULL, 
  FOREIGN KEY(id_status) REFERENCES status(id),
  FOREIGN KEY(id_usuario) REFERENCES usuario(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE operacao(
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  tipo VARCHAR(20) NOT NULL,
  data_reg date NOT NULL,
  valor decimal NOT NULL,
  observacao VARCHAR(200),
  id_usuario bigint(20) NOT NULL,
  id_conta bigint(20) NOT NULL,
  id_status bigint(20) NOT NULL,
  FOREIGN KEY(id_usuario) REFERENCES usuario(id),
  FOREIGN KEY(id_conta) REFERENCES conta(id),
  FOREIGN KEY(id_status) REFERENCES status(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tipo_entrada(
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tipo_retirada(
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE entrada(
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  id_tipo bigint(20) NOT NULL,
  id_operacao bigint(20) NOT NULL,
  FOREIGN KEY(id_tipo) REFERENCES tipo_entrada(id),
  FOREIGN KEY(id_operacao) REFERENCES operacao(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE retirada(
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  id_tipo bigint(20) NOT NULL,
  id_beneficiario bigint(20),
  id_operacao bigint(20) NOT NULL,
  FOREIGN KEY(id_tipo) REFERENCES tipo_retirada(id),
  FOREIGN KEY(id_beneficiario) REFERENCES usuario(id),
  FOREIGN KEY(id_operacao) REFERENCES operacao(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE emprestimo(
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  juros_valor decimal NOT NULL,
  juros_percentual decimal NOT NULL,
  quant_parcelas int NOT NULL,
  intervalo_entre_parcelas int NOT NULL,
  id_cliente bigint(20) NOT NULL,
  id_operacao bigint(20) NOT NULL,
  FOREIGN KEY(id_cliente) REFERENCES cliente(id),
  FOREIGN KEY(id_operacao) REFERENCES operacao(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE parcela(
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  valor_previsto decimal NOT NULL,
  valor_recebido decimal,
  numero int NOT NULL,
  vencimento date NOT NULL,
  recebimento date,
  observacao varchar(200), 
  id_emprestimo bigint(20) NOT NULL,
  id_parent bigint(20),
  id_status bigint(20) NOT NULL,
  FOREIGN KEY(id_emprestimo) REFERENCES emprestimo(id),
  FOREIGN KEY(id_parent) REFERENCES parcela(id),
  FOREIGN KEY(id_status) REFERENCES status(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;




