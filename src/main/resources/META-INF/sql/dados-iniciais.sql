insert into Empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao) values (1, '70.311.193/0001-87', 'Mercado do João', 'João Mercado e Distribuidor de Alimentos Ltda', 'LTDA', '2009-03-02');
insert into Empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao) values (2, '52.822.994/0001-25', 'Fale Mais', 'Fale Mais Telecom S.A.', 'SA', '1997-12-10');
insert into Empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao) values (3, '41.952.519/0001-57', 'Maria de Souza da Silva', 'Maria de Souza da Silva', 'MEI', '2014-10-15');
insert into Empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao) values (4, '16.134.777/0001-89', 'Gomes Inovação', 'José Fernando Gomes EIRELI ME', 'EIRELI', '2009-03-02');

insert into Convenio (id, desc_convenio) values (1, 'Pas');
insert into Convenio (id, desc_convenio) values (2, 'Unimed');

insert into Paciente (id, numero_convenio, convenio_id, nome, cpf, data_nascimento) values (1, '123456788',1, 'Cicero Jeferson', '043.317.773-08' ,'1988-12-14');
insert into Paciente (id, numero_convenio, convenio_id, nome, cpf, data_nascimento) values (2, '123456788',2, 'Maria Jaqueliane','043.317.773-08' ,'1988-12-14');
insert into Paciente (id, numero_convenio, convenio_id, nome, cpf, data_nascimento) values (3, '123456788',2, 'Aline Helle', '043.317.773-08' ,'1988-12-14');


insert into CondPagto (id, cond_pagto) values(1,'À vista');
insert into CondPagto (id, cond_pagto) values(2,'Convenio');
insert into CondPagto (id, cond_pagto) values(3,'Cartão de crédito');

insert into Especialidade (id, desc_especialidade) values(1,'Dermatologia');

insert into Medico (id, nome_medico, crm, especialidade_id) values(1,'Sergio',1234,1);