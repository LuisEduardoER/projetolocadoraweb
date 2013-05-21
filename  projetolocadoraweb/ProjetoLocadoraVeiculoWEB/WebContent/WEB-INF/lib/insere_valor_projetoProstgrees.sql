
/*INSERE VALOR NA TABLE LOGIN*/

INSERT INTO USUARIO VALUES
(1 , 'Diego Tiburcio dos Santos' , 'diego.santos' , 'diego'  ),
(2 , 'Leandro Tiburcio dos Santos' , 'leandro.tiburcio' , 'leandro'  ),
(3 , 'José Henrique Silveira' , 'jose.henrique' , 'jose'  ),
(4 , 'Nick "S.H.I.E.L.D" Fury' , 'nick.fury' , 'fury'  ),
(5 , 'Julia Tiburcio Lourenço' , 'julia.tiburcio' , 'julia'  );

INSERT INTO AGENCIA VALUES
(1 , 'Bela Vista - AG.01' , 'Guarulhos' , 'São Paulo' , 'Brasil' , 0),
(2 , 'Carapicuíba - AG.01' , 'Carapicuíba' , 'São Paulo' , 'Brasil' , 1),
(3 , 'Rio de Janeiro - AG.23' , 'Rio de Janeiro' , 'Rio de Janeiro' , 'Brasil' , 2),
(4 , 'Sorocaba - AG.03' , 'Sorocaba' , 'São Paulo' , 'Brasil' , 3),
(5 , 'Santa Cruz AG.01' , 'São Paulo' , 'São Paulo' , 'Brasil' , 4),
(6 , 'Santa Cruz AG.02' , 'São Paulo' , 'São Paulo' , 'Brasil' , 4);

INSERT INTO CLIENTE (nome , registro , telefone , email , tipo , status) VALUES
( 'Diego T. dos Santos' , '134.321.123-01' , '1124053548' , 'diego.santos@hotmail.com' , 'PF' , 'Y'),
( 'Maria Alvares' , '321.123.321-01' , '1234567890' , 'example@hotmail.com' , 'PF' , 'Y'),
( 'XYZ Company' , '38.123.382/0001-12' ,  '1134536895' , 'corporate@hotmail.com' , 'PJ' , 'Y'),
( 'ABS Telecom'  , '12.321.123/0001-56' , '6134514532' , 'bts@hotmail.com' , 'PJ' , 'Y');


INSERT INTO PF (idClienteFK , sexo , dtaNascimento , rg , numHabilitacao , estadoEmissor , primeiraHabilitacao , validadeCartMotorista) VALUES
( 1 , 'M' , '1988-01-05' ,  '41.314.324-01' , '12345678910' , 'SP' , '2010-03-17' , '1988-09-21'),
( 2 , 'F' , '1966-12-23' ,  '41.314.564-01' , '41234567829' , 'MG' , '2009-03-05' , '2020-09-21');

INSERT INTO PJ (idClienteFK , razaoSocial ) VALUES
(3 , 'XYZ Company LTDA' ),
(4 , 'ABS Telecom LTDA' );

INSERT INTO GRUPO VALUES
(1 ,	'A - Econômico' ,	99.9 ,	39.9),
(2 ,	'C - Econômico com Ar' ,	139 ,	75),
(3 ,	'F - Intermediário' ,	178 ,	95),
(4 ,	'G - Intermediário Wagon Especial' ,	245 ,	132),
(5 ,	'H - Executivo'  ,	294 ,	157),
(6 ,	'I - Utilitário' ,	223 ,	123),
(7 ,	'J - Vans'	, 290	, 156),
(8 ,	'K - Executivo Luxo' ,	357	, 190),
(9 ,	'L - Executivo Especial'	, 393	, 211),
(10 ,	'M - Intermediário Wagon' ,	189 ,	101),
(11 ,	'N - Pick-up' 	, 154	, 83),
(12 ,	'P - 4 x 4 Especial' 	, 487	, 262),
(13 ,	'R - Minivan' 	, 246	, 132),
(14 ,	'U - Furgão'	, 167	, 91),
(15 ,	'V - Picku-up com Ar'	, 175	, 95),
(16 ,	'Y - Blindado'	, 512	, 332);


INSERT INTO VEICULO (fabricante , placa , cidade , km , chassi , modelo , estado , idgrupofk) VALUES
('Volkswagen' , 'ABC-1234' , 'São Paulo' , '1.0' , '9BWCA11J0Y4000001' , 'GOL 1.0' , 'São Paulo' , 2),
('Chevrolet' , 'DBJ-4321' , 'Jundiaí' , '1.0' , '5CWSA11J0J4000403' , 'Celta 1.0' , 'São Paulo' , 1),
('Fiat' , 'YGY-4564' , 'Belo Horizonte' , '1.0' , '7FGSA22J9C4045892' , 'Novo Uno 1.0' , 'Minas Gerais' , 1),
('Ford' , 'UIO-9087' , 'Salvador' , '1.6' , '3YUUS45H9U9900403' , 'Fiesta Sedan 1.6' , 'Bahia' , 3);


insert into veiculo_agencia (idveiculofk , idagenciafk) values
(1 , 1),
(2 , 1),
(2 , 4),
(3 , 1),
(4 , 1),
(1 , 2),
(2 , 2),
(3 , 3),
(4 , 3),
(1 , 5),
(2 , 6),
(3 , 5);

insert into forma_pagamento (tipo , total) values
('Cheque' , 50.4),
('Cheque' , 49.6),
('Dinheiro' , 90.4),
('Dinheiro' , 148.9),
('Cartao' , 59.4),
('Cartao' , 123.99);

insert into cheque (nomeBanco , numAgencia , numCCO , nomeTitular , cpfTitular , foneTitular , idFormaPagamentoFK) values
('Itaú' , '0123' , '12345-2' , 'Rodrigo Alves' , '134.321.123-01' , '1123430932' , 1),
('Bradesco' , '2301' , '32123-9' , 'Amanda Raimunda da Silva' , '321.123.890-09' , '11998218912' , 2);