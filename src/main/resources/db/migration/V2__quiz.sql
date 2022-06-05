CREATE TABLE quiz
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    user_id    INT          NOT NULL REFERENCES users (id),
    name       VARCHAR(50)  NOT NULL,
    definition VARCHAR(200) NOT NULL
);

CREATE TABLE question
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    quiz_id     INT          NOT NULL REFERENCES quiz (id),
    description VARCHAR(200) NOT NULL
);

CREATE TABLE answer
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    question_id INT          NOT NULL REFERENCES question (id),
    text        VARCHAR(200) NOT NULL,
    is_correct  BOOLEAN      NOT NULL
);
