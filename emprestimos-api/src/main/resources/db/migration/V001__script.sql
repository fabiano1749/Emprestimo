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

CREATE TABLE entidade (
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  tipo VARCHAR(40) NOT NULL,
  nome varchar(50) NOT NULL,
  observacao varchar(200),
  cpf varchar(15),
  nome_comercio varchar(200),
  data_registro date NOT NULL,
  id_status bigint(20) NOT NULL,
  id_usuario bigint(20),	

  username varchar (100),
  senha varchar (200),	
  id_tipo_usuario bigint(20), 
	
  FOREIGN KEY(id_status) REFERENCES status(id),	
  FOREIGN KEY(id_tipo_usuario) REFERENCES tipo_usuario(id), 
  FOREIGN KEY(id_usuario) REFERENCES entidade(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE endereco(
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  tipo VARCHAR(20) NOT NULL,
  cep VARCHAR(10),
  rua VARCHAR(100) NOT NULL,
  numero VARCHAR(20) NOT NULL,
  bairro VARCHAR(50) NOT NULL,
  complemento VARCHAR(45),			
  id_cidade BIGINT(20) NOT NULL,
  id_entidade BIGINT(20) NOT NULL,
  FOREIGN KEY(id_cidade) REFERENCES cidade(id),
  FOREIGN KEY(id_entidade) REFERENCES entidade(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE contato (
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  tipo varchar(30) NOT NULL,
  email varchar(100),
  fixo varchar(15),
  celular varchar(15),
  id_entidade bigint(20) NOT NULL,
  FOREIGN KEY(id_entidade) REFERENCES entidade(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE conta(
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  saldo_inicial decimal NOT NULL,
  id_status bigint(20) NOT NULL,
  id_usuario bigint(20) NOT NULL, 
  FOREIGN KEY(id_status) REFERENCES status(id),
  FOREIGN KEY(id_usuario) REFERENCES entidade(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE motivo_operacao(
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  tipo VARCHAR(20) NOT NULL,
  descricao VARCHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE operacao(
  id bigint(20) PRIMARY KEY AUTO_INCREMENT,
  tipo VARCHAR(20) NOT NULL,
  data_reg date NOT NULL,
  data_operacao date NOT NULL,	
  valor decimal NOT NULL,
  observacao VARCHAR(200),
  id_usuario bigint(20) NOT NULL,
  id_conta bigint(20) NOT NULL,	
  id_status bigint(20) NOT NULL,
  id_motivo_operacao bigint(20),	
  id_beneficiario bigint(20),
  id_conta_destino bigint(20),	
  juros_valor decimal,
  juros_percentual decimal,
  quant_parcelas int,
  intervalo_entre_parcelas int,
  id_cliente bigint(20),
  FOREIGN KEY(id_motivo_operacao) REFERENCES motivo_operacao(id),
  FOREIGN KEY(id_beneficiario) REFERENCES entidade(id),  
  FOREIGN KEY(id_usuario) REFERENCES entidade(id),
  FOREIGN KEY(id_conta) REFERENCES conta(id),
  FOREIGN KEY(id_conta_destino) REFERENCES conta(id),
  FOREIGN KEY(id_cliente) REFERENCES entidade(id),
  FOREIGN KEY(id_status) REFERENCES status(id)
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
  FOREIGN KEY(id_emprestimo) REFERENCES operacao(id),
  FOREIGN KEY(id_parent) REFERENCES parcela(id),
  FOREIGN KEY(id_status) REFERENCES status(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



