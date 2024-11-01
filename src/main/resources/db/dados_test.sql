INSERT INTO public."admin" (cpf, email, nome, senha, usuario)
VALUES ('12101380935', 'mateus@gmail.com', 'Mateus', '$2a$10$CZfxCesliAr1r853YuY4CexWsL5.CMw5CiDXMyUQ6e7/nqc7ryQVq',
        'mateuslh'), -- senha 1234
       ('20368211037', 'paulo@gmail.com', 'Paulo', '$2a$10$Osu0sos3f0kBReRsnnh./eHZQI.lPGswYrJe7Ei3wMXb/YGgXW1xm',
        'paulada');-- senha 1234

INSERT INTO public.categoria (descricao)
VALUES ('papelaria');

INSERT INTO public.feira (descricao, "local", nome)
VALUES ('descricao1', 'local1', 'feira1'),
       ('descricao2', 'local2', 'feira2'),
       ('descricao3', 'local3', 'feira3');

INSERT INTO public.feira_admin (feira_id, admin_id)
VALUES (1, 1),
       (2, 2);

INSERT INTO public.evento ("data", feira_id)
VALUES ('2024-11-01', 1),
       ('2024-11-04', 2);

INSERT INTO public.feirante (cnpj, email, nome_empresa, nome_feirante, telefone, feira_id)
VALUES ('78635198000177', 'feirinha1@gmail.com', 'feirinha 1 ltda', 'feirinha 1', '(48) 991485139', 1),
       ('78635198000177', 'feirinha2@gmail.com', 'feirinha 2 ltda', 'feirinha 2', '(48) 991485139', 2);


INSERT INTO public.feirante_categoria (feirante_id, categoria_id)
VALUES (1, 1),
       (2, 1);
