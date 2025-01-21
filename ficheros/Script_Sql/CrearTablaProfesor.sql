CREATE TABLE profesor
(
    id INT(11) PRIMARY KEY auto_increment NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    modulo VARCHAR(50) NOT NULL,
    FOREIGN KEY (modulo) REFERENCES modulo(codigo)
);