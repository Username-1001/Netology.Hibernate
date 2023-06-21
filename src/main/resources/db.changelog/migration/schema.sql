SET SCHEMA 'public';

CREATE TABLE IF NOT EXISTS persons
(
    name         varchar(30) NOT NULL ,
    surname      varchar(30) NOT NULL ,
    age          int2 CHECK ( age > 0 ),
    phone_number varchar(20),
    city_of_living varchar(30) NOT NULL,
    PRIMARY KEY (name, surname, age)
);

INSERT INTO persons
VALUES ('Vasya', 'Vasin', 26, '890012578963', 'Moscow'),
       ('Petya', 'Petin', 27, '890012578963', 'Kazan'),
       ('Ivan', 'Ivanov', 28, '890012578963', 'Moscow'),
       ('Poligraf', 'Poligrafov', 29, '890012578963', 'Kazan');