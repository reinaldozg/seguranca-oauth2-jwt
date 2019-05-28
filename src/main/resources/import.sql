INSERT INTO cliente(id, cpf, idade, nome) VALUES (1, '12345678900', 32, 'Reinaldo dos Santos');
INSERT INTO cliente(id, cpf, idade, nome) VALUES (2, '98765432100', 22, 'João da Silva Medeiros');
INSERT INTO cliente(id, cpf, idade, nome) VALUES (3, '98765456766', 20, 'Maria d Sousa Medeiros');
INSERT INTO cliente(id, cpf, idade, nome) VALUES (4, '86567666666', 40, 'Paula de Sousa Medeiros');
INSERT INTO cliente(id, cpf, idade, nome) VALUES (5, '33242325245', 25, 'Joaquim de Oliveira');

INSERT INTO apolice(codigo_apolice, premio, proposta, cliente_fk) VALUES (10000000001, '5184.01', 22000000022, 1);
INSERT INTO apolice(codigo_apolice, premio, proposta, cliente_fk) VALUES (10000000002, '3189.78', 22000000023, 1);
INSERT INTO apolice(codigo_apolice, premio, proposta, cliente_fk) VALUES (10000000003, '2555.14', 22000000024, 2);
INSERT INTO apolice(codigo_apolice, premio, proposta, cliente_fk) VALUES (10000000004, '4345.32', 22000000025, 2);
INSERT INTO apolice(codigo_apolice, premio, proposta, cliente_fk) VALUES (10000000005, '1223.55', 22000000026, 3);
INSERT INTO apolice(codigo_apolice, premio, proposta, cliente_fk) VALUES (10000000006, '6776.00', 22000000027, 3);
INSERT INTO apolice(codigo_apolice, premio, proposta, cliente_fk) VALUES (10000000007, '7888.98', 22000000028, 4);
INSERT INTO apolice(codigo_apolice, premio, proposta, cliente_fk) VALUES (10000000008, '8009.00', 22000000029, 4);
INSERT INTO apolice(codigo_apolice, premio, proposta, cliente_fk) VALUES (10000000009, '9.000', 22000000030, 5);
INSERT INTO apolice(codigo_apolice, premio, proposta, cliente_fk) VALUES (10000000010, '1.500', 22000000031, 5);

INSERT INTO usuario(id, nome, email, senha) VALUES (1, 'Administrador', 'adm@email.com', '$2a$10$W0wSDvIndEbL2l0.1wt/tOcMQJey0s97egaApJpskI.fUeNkwmnMe');
INSERT INTO usuario(id, nome, email, senha) VALUES (2, 'Basico', 'basico@email.com', '$2a$10$wLVdTjERINPUF7LQeLXgLOs0Zzsuu0RX6eigP3DvcShz0ci9zlEDO');

INSERT INTO permissao(id, descricao) VALUES (1, 'ROLE_PESQUISAR_APOLICE');
INSERT INTO permissao(id, descricao) VALUES (2, 'ROLE_CADASTRAR_APOLICE');
INSERT INTO permissao(id, descricao) VALUES (3, 'ROLE_ATUALIZAR_APOLICE');
INSERT INTO permissao(id, descricao) VALUES (4, 'ROLE_REMOVER_APOLICE');

INSERT INTO usuario_permissao(usuario_id, permissao_id) VALUES (1, 1);
INSERT INTO usuario_permissao(usuario_id, permissao_id) VALUES (1, 2);
INSERT INTO usuario_permissao(usuario_id, permissao_id) VALUES (1, 3);
INSERT INTO usuario_permissao(usuario_id, permissao_id) VALUES (1, 4);

INSERT INTO usuario_permissao(usuario_id, permissao_id) VALUES (2, 1);
INSERT INTO usuario_permissao(usuario_id, permissao_id) VALUES (2, 2);
INSERT INTO usuario_permissao(usuario_id, permissao_id) VALUES (2, 3);

