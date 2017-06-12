--USUARIO
INSERT INTO investir.usuario(id, data_nasc, email, celular, nome, tipo_usuario) VALUES
( 1, '1970-03-28', 'james@hotmail.com', 	'(51)99235-4186', 'James Mauricio Tremea', 		'ADMINISTRADOR'),
( 2, '1990-12-26', 'fernando@yahoo.com.br',	'(51)99123-4567', 'Fernando B. Sturzbecher', 	'LIMITADO'),
( 3, '1980-11-01', 'ricardo@gmail.com', 	'(51)99234-5678', 'José Ricardo Robaski', 		'PREMIUM'),
( 4, '1960-05-31', 'antonio@gmail.com', 	'(51)99990-1234', 'Antônio Antonildo da Silva', 'PREMIUM');


--ROLE
insert into investir.role(id, role) values
(1, 'ROLE_ADMINISTRADOR'),
(2, 'ROLE_LIMITADO'),
(3, 'ROLE_PREMIUM');


-- TIPO_ATIVO
INSERT INTO investir.tipo_ativo(id, desc) VALUES
(1, 	'Ação'),
(2, 	'Opção'),
(3, 	'FII'),
(4, 	'Termo'),
(5, 	'Dólar'),
(6, 	'Ouro'),
(7, 	'Futuro');


-- ATIVO
INSERT INTO investir.ativo(id, descricao, ticker, vencimento, strike, tipo_ativo_id) VALUES
(  1,	'Petrobras ON',		'PETR3',	null,			0,		1),
(  2,	'Petrobras PN',		'PETR4',	null,			0,		1),
(  3,	'Vale ON',			'VALE4',	null,			0,		1),
(  4,	'Vale PN',			'VALE5',	null,			0,		1),
(  5,	'Estacio ON',		'ESTC3',	null,			0,		1),
(  6,	'Estacio PN',		'ESTC4',	null,			0,		1),
(  7,	'Petrobras ON',		'PETRF25',	'2017-06-19',	25.00,	2),
(  8,	'Petrobras ON',		'PETRF3',	'2017-06-19',	15.50,	2),
(  9,	'Petrobras ON',		'PETRG50',	'2017-07-17',	19.00,	2),
( 10,	'Petrobras ON',		'PETRG90',	'2017-07-17',	20.00,	2),
( 11,	'Ambev ON',			'ABEVF20',	'2017-06-19',	20.45,	2),
( 12,	'Ambev ON',			'ABEVF3',	'2017-06-19',	22.45,	2),
( 13,	'Ambev ON',			'ABEVG46',	'2017-07-17',	16.95,	2),
( 14,	'Ambev ON',			'ABEVG47E',	'2017-07-17',	23.70,	2),
( 15,	'XP Gaia',			'XPGA11',	null,			0,		3),
( 16,	'FII Rio Negro',	'RNGO11',	null,			0,		3),
( 17,	'General Shopping',	'FIGS11',	null,			0,		3),
( 18,	'FII Rio Bravo',	'RBVO11',	null,			0,		3),
( 19,	'Santander Agenc',	'SAAG11',	null,			0,		3),
( 20,	'XP Corp Macae',	'XPCM11',	'2017-07-17',	0,		3);


-- NOTA
INSERT INTO investir.nota(id, numero, corretora, data_exec, data_liq, corretagem, emolumentos, taxas, irrf) VALUES
(  1,	222222,	'XP Investimentos',	'2017-01-17',	'2017-01-20',	137.45,	2.35,	1.56,	0.45),
(  2,	222225,	'XP Investimentos',	'2017-01-19',	'2017-01-23',	89.45,	1.38,	0.76,	0.40),
(  3,	123001,	'Ágora',			'2017-01-30',	'2017-02-02',	189.48,	13.38,	1.74,	1.23),
(  4,	123002,	'Ágora',			'2017-01-31',	'2017-02-03',	209.65,	12.33,	2.05,	2.77);


-- CARTEIRA
INSERT INTO investir.carteira(id, usuario_id, data_ref, cred_irrf, prej_normal, prej_daytrade, prej_fii, ultima_atualizacao) VALUES
( 1,	2,	'2016-10-20',	1.35,	245.33,		0,		225.45,		'2017-01-12');


-- ATIVO_CARTEIRA
INSERT INTO investir.ativo_carteira(id, ativo_id, carteira_id, quantidade, valor) VALUES
( 1,	2,	1,	800,	9864.00),
( 2,	4,	1,	500,	7885.00),
( 3,	16,	1,	200,	16044.00),
( 4,	17,	1,	100,	9234.00),
( 5,	19,	1,	300,	18879.00),
( 6,	7,	1,	2000,	5860.00),
( 7,	11,	1,	3000,	1410.00);


-- ATIVO_NOTA
INSERT INTO investir.ativo_nota(id, nota_id, ativo_id, operacao, quantidade, valor) VALUES
( 1,	1,	1,	1,	100,	1200.00),
( 2,	1,	2,	2,	500,	6610.00),
( 3,	1,	4,	0,	200,	2910.00),
( 4,	2,	1,	2,	100,	9300.00),
( 5,	2,	1,	1,	200,	12186.00);





--AUTHENTICATION
--INSERT into sed.account(id, username, password, active, employee_id) VALUES
--(1, 'user',            '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', TRUE, 2273),
--(2, 'psico',           '$2a$10$MQsw3ipKnruWSYJnm0pLlO/vmyogQYbQkl8dPTPetCMffRwAgEr1.', TRUE, 10),
--(3, 'sandra.donner',   '$2a$10$t50c/7TKjPIcyYbeSjRnDefYqF8BcVVMAchJkzSzz87rEvlK/602G', TRUE, 2257),
--(5, 'priscila.verdum', '$2a$10$h1tOIBb9bQVDghLLn6FxLu7sDJvnQUHhbhy20c8enc95iWqTB2nvu', TRUE, 10124),
--(6, 'rodrigo.noll',    '$2a$10$h1tOIBb9bQVDghLLn6FxLu7sDJvnQUHhbhy20c8enc95iWqTB2nvu', TRUE, 2273);



-- USER_ROLES
--insert into sed.account_roles (account_id, roles_id) values
--(1, 1),
--(1, 2),
--(2, 3),
--(3, 1),
--(5, 1),
--(6, 1);

