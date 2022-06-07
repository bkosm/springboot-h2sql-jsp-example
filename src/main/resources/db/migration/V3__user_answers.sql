CREATE TABLE user_answers
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    user_id        INT     NOT NULL REFERENCES users (id),
    answer_id      INT     NOT NULL REFERENCES answer (id),
    user_selection BOOLEAN NOT NULL
);
