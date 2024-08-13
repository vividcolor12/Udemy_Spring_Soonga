CREATE TABLE product(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL ,
    price int not null ,
    description varchar(500),
    primary key (id)
)

INSERT INTO product VALUES (NULL, "pen", 2000, "black pink")
