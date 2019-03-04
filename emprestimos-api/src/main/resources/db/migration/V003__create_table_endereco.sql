CREATE TABLE endereco(
  idEndereco BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  tipo VARCHAR(20) NOT NULL,
  cep VARCHAR(10),
  rua VARCHAR(100) NOT NULL,
  numero VARCHAR(20) NOT NULL,
  bairro VARCHAR(50) NOT NULL,			
  idCidade BIGINT(20) NOT NULL,
  FOREIGN KEY(idCidade) REFERENCES cidade(idCidade)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
