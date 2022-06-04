CREATE TABLE users
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(50) NOT NULL,
    email    VARCHAR(50) NOT NULL,
    country  VARCHAR(50) NOT NULL,
    points   INTEGER     NOT NULL,
    password VARCHAR(50) NOT NULL,
    is_admin BOOLEAN     NOT NULL
);

INSERT INTO users (name, email, country, points, password, is_admin)
VALUES ('bart', 'bart@bart.pl', 'pl', 0, 'bart', true);
