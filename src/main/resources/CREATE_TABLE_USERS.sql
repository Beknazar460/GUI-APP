create table users
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email           VARCHAR(50) NOT NULL,
    user_first_name VARCHAR(45) NOT NULL,
    user_pass       VARCHAR(45) NOT NULL,
    user_last_name  VARCHAR(45) NOT NULL,
    phone_number    VARCHAR(20) NOT NULL,
    constraint email_UNIQUE
        unique (email)
)