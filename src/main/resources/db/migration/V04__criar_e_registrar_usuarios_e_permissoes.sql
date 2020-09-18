CREATE TABLE usuario (
	codigo BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
	codigo BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao (
	codigo_usuario BIGINT(20) NOT NULL,
	codigo_permissao BIGINT(20) NOT NULL,
	PRIMARY KEY(codigo_usuario, codigo_permissao),
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
	FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (nome, email, senha) VALUES ('Administrador', 'admin@algamoney.com', '$2a$10$JXnF9fVxD/8krWW.QvRaa.PTAPscQo9IPBywQXR7.QN0zheKRrU6m');
INSERT INTO usuario (nome, email, senha) VALUES ('Maria Silva', 'maria@algamoney.com', '$2a$10$JXnF9fVxD/8krWW.QvRaa.PTAPscQo9IPBywQXR7.QN0zheKRrU6m');

INSERT INTO permissao (descricao) VALUES ('ROLE_CADASTRAR_CATEGORIA');
INSERT INTO permissao (descricao) VALUES ('ROLE_PESQUISAR_CATEGORIA');

INSERT INTO permissao (descricao) VALUES ('ROLE_CADASTRAR_PESSOA');
INSERT INTO permissao (descricao) VALUES ('ROLE_REMOVER_PESSOA');
INSERT INTO permissao (descricao) VALUES ('ROLE_PESQUISAR_PESSOA');

INSERT INTO permissao (descricao) VALUES ('ROLE_CADASTRAR_LANCAMENTO');
INSERT INTO permissao (descricao) VALUES ('ROLE_REMOVER_LANCAMENTO');
INSERT INTO permissao (descricao) VALUES ('ROLE_PESQUISAR_LANCAMENTO');

INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) VALUES (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) VALUES (1, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) VALUES (1, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) VALUES (1, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) VALUES (1, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) VALUES (1, 6);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) VALUES (1, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) VALUES (1, 8);

INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) VALUES (2, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) VALUES (2, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) VALUES (2, 8);