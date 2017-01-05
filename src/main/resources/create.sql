DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS government_institution;
DROP TABLE IF EXISTS payment;

CREATE TABLE account (
  id                INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  login             VARCHAR(250) NOT NULL UNIQUE,
  password          VARCHAR(250) NOT NULL UNIQUE,
  name              VARCHAR(250) NOT NULL,
  surname           VARCHAR(250) NOT NULL,
  email             VARCHAR(250),
  type              ENUM("government", "employer", "employee"),
  registration_time BIGINT         NOT NULL
);

CREATE TABLE employee (
  id                INT UNSIGNED REFERENCES account (id),
  money             INT UNSIGNED NOT NULL,
  salary_rate       FLOAT,
  money_update_time BIGINT         NOT NULL
);

CREATE TABLE government_institution (
  id             INT UNSIGNED REFERENCES account (id),
  time_of_update BIGINT  NOT NULL,
  money          INT NOT NULL
);

CREATE TABLE payment (
  id               INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  transaction_time BIGINT NOT NULL,
  amount           INT  NOT NULL,
  payer            INT UNSIGNED REFERENCES account (id),
  receiver         INT UNSIGNED REFERENCES account (id)
)