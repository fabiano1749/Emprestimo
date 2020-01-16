CREATE TABLE auditoria (
  id int(11) NOT NULL AUTO_INCREMENT,
  data_reg datetime DEFAULT NULL,
  timestamp bigint(20) NOT NULL,
  usuario varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cidade_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  id_estado bigint(20) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE conta_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  saldo_inicial double DEFAULT NULL,
  id_usuario bigint(20) DEFAULT NULL,
  id_status bigint(20) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE contato_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  celular varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  fixo varchar(255) DEFAULT NULL,
  tipo varchar(255) DEFAULT NULL,
  id_entidade bigint(20) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE endereco_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  bairro varchar(255) DEFAULT NULL,
  cep varchar(255) DEFAULT NULL,
  complemento varchar(255) DEFAULT NULL,
  numero varchar(255) DEFAULT NULL,
  referencia varchar(255) DEFAULT NULL,
  rua varchar(255) DEFAULT NULL,
  tipo varchar(255) DEFAULT NULL,
  id_cidade bigint(20) DEFAULT NULL,
  id_entidade bigint(20) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE entidade_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  tipo varchar(31) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  cpf varchar(255) DEFAULT NULL,
  data_registro date DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  observacao varchar(255) DEFAULT NULL,
  id_status bigint(20) DEFAULT NULL,
  nome_comercio varchar(255) DEFAULT NULL,
  id_usuario bigint(20) DEFAULT NULL,
  senha varchar(255) DEFAULT NULL,
  username varchar(255) DEFAULT NULL,
  id_tipo_usuario bigint(20) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE estado_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  sigla varchar(255) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE log_operacao_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  data_reg datetime DEFAULT NULL,
  descricao varchar(255) DEFAULT NULL,
  id_operacao bigint(20) DEFAULT NULL,
  id_usuario bigint(20) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE log_parcela_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  data_reg datetime DEFAULT NULL,
  descricao varchar(255) DEFAULT NULL,
  id_parcela bigint(20) DEFAULT NULL,
  id_usuario bigint(20) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE log_sistema_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  data_reg datetime DEFAULT NULL,
  descricao varchar(255) DEFAULT NULL,
  id_usuario bigint(20) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE motivo_operacao_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  tipo varchar(31) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  descricao varchar(255) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE operacao_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  tipo varchar(31) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  data_operacao date DEFAULT NULL,
  data_reg datetime DEFAULT NULL,
  observacao varchar(255) DEFAULT NULL,
  valor decimal(19,2) DEFAULT NULL,
  id_conta bigint(20) DEFAULT NULL,
  id_status bigint(20) DEFAULT NULL,
  id_usuario bigint(20) DEFAULT NULL,
  id_conta_destino bigint(20) DEFAULT NULL,
  intervalo_entre_parcelas int(11) DEFAULT NULL,
  juros_percentual decimal(19,2) DEFAULT NULL,
  juros_valor decimal(19,2) DEFAULT NULL,
  quant_parcelas int(11) DEFAULT NULL,
  id_cliente bigint(20) DEFAULT NULL,
  id_motivo_operacao bigint(20) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE parcela_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  numero int(11) DEFAULT NULL,
  observacao varchar(255) DEFAULT NULL,
  recebimento date DEFAULT NULL,
  valor_previsto decimal(19,2) DEFAULT NULL,
  valor_recebido decimal(19,2) DEFAULT NULL,
  vencimento date DEFAULT NULL,
  id_conta bigint(20) DEFAULT NULL,
  id_emprestimo bigint(20) DEFAULT NULL,
  id_parent bigint(20) DEFAULT NULL,
  id_status bigint(20) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  descricao varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao_tipo_usuario_aud (
  rev int(11) NOT NULL,
  id_tipo_usuario bigint(20) NOT NULL,
  id_permissao bigint(20) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  PRIMARY KEY (rev,id_tipo_usuario,id_permissao)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE status_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  descricao varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  numero int(11) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tipo_usuario_aud (
  id bigint(20) NOT NULL,
  rev int(11) NOT NULL,
  revtype tinyint(4) DEFAULT NULL,
  descricao varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  id_status bigint(20) DEFAULT NULL,
  PRIMARY KEY (id,rev)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

