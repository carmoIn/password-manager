-- liquibase formatted sql

-- changeset helci:021020222150-1
CREATE TABLE passwords
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    created  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated  TIMESTAMP WITHOUT TIME ZONE,
    removed  TIMESTAMP WITHOUT TIME ZONE,
    active   BOOLEAN DEFAULT TRUE                    NOT NULL,
    user_id  BIGINT                                  NOT NULL,
    name     VARCHAR(255)                            NOT NULL,
    site     VARCHAR(255)                            NOT NULL,
    password VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_passwords PRIMARY KEY (id)
);

-- changeset helci:021020222150-2
CREATE TABLE users
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    created  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated  TIMESTAMP WITHOUT TIME ZONE,
    removed  TIMESTAMP WITHOUT TIME ZONE,
    active   BOOLEAN DEFAULT TRUE                    NOT NULL,
    name     VARCHAR(255)                            NOT NULL,
    username VARCHAR(255)                            NOT NULL,
    email    VARCHAR(255)                            NOT NULL,
    password VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

-- changeset helci:021020222150-3
ALTER TABLE passwords
    ADD CONSTRAINT uc_passwords_id UNIQUE (id);

-- changeset helci:021020222150-4
ALTER TABLE users
    ADD CONSTRAINT uc_users_id UNIQUE (id);

-- changeset helci:021020222150-5
ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);

-- changeset helci:021020222150-6
ALTER TABLE passwords
    ADD CONSTRAINT FK_PASSWORDS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

