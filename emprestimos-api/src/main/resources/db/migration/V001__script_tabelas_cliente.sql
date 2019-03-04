
CREATE TABLE estado (
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(30) NOT NULL,
  sigla varchar(2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE tipo_usuario (
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  descricao varchar(200)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE permissao_tipo_usuario (
  id_permissao bigint(20) NOT NULL,
  id_tipo_usuario bigint(20) NOT NULL,
  FOREIGN KEY(id_permissao) REFERENCES permissao(id),
  FOREIGN KEY(id_tipo_usuario) REFERENCES tipo_usuario(id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE usuario (
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  telefone varchar(15),
  id_tipo_usuario bigint(20) NOT NULL,  
  FOREIGN KEY(id_tipo_usuario) REFERENCES tipo_usuario(id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE cliente (
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  observacao varchar(200),
  cpf varchar(15),
  nome_comercio varchar(200),
  id_usuario bigint(20),
  FOREIGN KEY(id_usuario) REFERENCES usuario(id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

