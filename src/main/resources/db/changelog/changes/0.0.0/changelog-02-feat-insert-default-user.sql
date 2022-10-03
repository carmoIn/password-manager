-- liquibase formatted sql

-- changeset helci:021020222156-1
INSERT INTO users
(created, updated, active, name, username, email, password)
VALUES (now(), now(), true, 'Usuário Teste', 'teste', 'teste@teste.com', '{bcrypt}$2a$10$bJltVLK.iz6unVBxFoaWZ.1s7zwzyx3rZu61idDpDU7MXHfk77XlK');