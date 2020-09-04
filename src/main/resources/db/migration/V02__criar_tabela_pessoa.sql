CREATE TABLE pessoa (
	codigo BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,	
	logradouro VARCHAR(100) NULL,
	numero VARCHAR(6) NULL,
	complemento VARCHAR(50) NULL,
	bairro VARCHAR(50) NULL,
	cidade VARCHAR(50) NULL,
	estado CHAR(2) NULL,
	cep VARCHAR(8) NULL,	
	ativo tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cidade, estado, cep, ativo) VALUES ('Herbert Pancini de Andrade', 'Rua Manoel Gomes', '15', NULL, 'Nova Bethânia', 'Viana', 'ES', '29138241', 1);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cidade, estado, cep, ativo) VALUES ('Danielle Pancini de Andrade', 'Rua Manoel Gomes', '15', NULL, 'Nova Bethânia', 'Viana', 'ES', '29138241', 1);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cidade, estado, cep, ativo) VALUES ('Marta Clarinda Pancini', 'Rua Manoel Gomes', '15', NULL, 'Nova Bethânia', 'Viana', 'ES', '29138241', 1);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cidade, estado, cep, ativo) VALUES ('Roberto Clarindo de Andrade', 'Rua Manoel Gomes', '15', NULL, 'Nova Bethânia', 'Viana', 'ES', '29138241', 1);