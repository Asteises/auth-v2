DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS roles
(
    id        UUID PRIMARY KEY NOT NULL,
    role_name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS users
(
    id       UUID PRIMARY KEY NOT NULL,
    name     VARCHAR(100),
    email    VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS users_roles
(
    user_id UUID,
    role_id UUID,
    CONSTRAINT users_roles_pk PRIMARY KEY (user_id, role_id),
    CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES users ON DELETE CASCADE,
    CONSTRAINT role_id_fk FOREIGN KEY (role_id) REFERENCES roles ON DELETE CASCADE
);

INSERT INTO roles (id, role_name)
VALUES ('123e4567-e89b-12d3-a456-426655440000', 'USER');
INSERT INTO roles (id, role_name)
VALUES ('223e4567-e89b-12d3-a456-426655440000', 'ADMIN');

INSERT INTO users (id, name, email, password)
VALUES ('323e4567-e89b-12d3-a456-426655440000', 'Filipp', 'filipp@mail.ru',
        '$2a$05$mQUL1F0c5W5Hp58gm.VeA.aTOVtFFJ/iR0afQ09LRQlYI93ZzWY4y');
INSERT INTO users (id, name, email, password)
VALUES ('423e4567-e89b-12d3-a456-426655440000', 'admin', 'admin@admin.ru',
        '$2a$05$mQUL1F0c5W5Hp58gm.VeA.aTOVtFFJ/iR0afQ09LRQlYI93ZzWY4y');

INSERT INTO users_roles (user_id, role_id)
VALUES ('323e4567-e89b-12d3-a456-426655440000', '123e4567-e89b-12d3-a456-426655440000');
INSERT INTO users_roles (user_id, role_id)
VALUES ('423e4567-e89b-12d3-a456-426655440000', '223e4567-e89b-12d3-a456-426655440000');