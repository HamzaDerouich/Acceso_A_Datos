CREATE TABLE imparte
(
    profesor INT(11) NOT NULL,
    modulo VARCHAR(50) NOT NULL,
    FOREIGN KEY (modulo) REFERENCES modulo(codigo),
    FOREIGN KEY (profesor) REFERENCES profesor(id)
);