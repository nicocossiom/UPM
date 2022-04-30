# Definición del esquema y las tablas

DROP SCHEMA IF EXISTS series;
CREATE SCHEMA series;
USE series;

CREATE TABLE serie (
  id_serie INT,
  titulo VARCHAR(100),
  sinopsis VARCHAR(200),
  idioma VARCHAR(50),
  fecha_estreno DATE,
  PRIMARY KEY (id_serie)
);

CREATE TABLE temporada (
  n_temporada INT,
  n_capitulos INT,
  fecha_estreno DATE,
  id_serie INT,
  PRIMARY KEY (id_serie, n_temporada),
  FOREIGN KEY (id_serie) REFERENCES serie (id_serie)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE usuario (
  id_usuario INT,
  nombre VARCHAR(50),
  apellido1 VARCHAR(50),
  apellido2 VARCHAR(50),
  fotografia LONGBLOB,
  PRIMARY KEY (id_usuario)
);

CREATE TABLE genero (
  id_genero INT,
  descripcion VARCHAR(50),
  PRIMARY KEY (id_genero)
);

CREATE TABLE comenta (
  id_usuario INT,
  id_serie INT,
  texto VARCHAR(300),
  fecha DATE,
  PRIMARY KEY (id_usuario, id_serie, fecha),
  FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_serie) REFERENCES serie (id_serie)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE pertenece (
  id_serie INT,
  id_genero INT,
  PRIMARY KEY (id_serie, id_genero),
  FOREIGN KEY (id_serie) REFERENCES serie (id_serie)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_genero) REFERENCES genero (id_genero)
    ON DELETE CASCADE ON UPDATE CASCADE
);


# Inserción de datos

INSERT INTO serie(id_serie, titulo, sinopsis, idioma, fecha_estreno) VALUES(1, 'The Big Bang Theory', 'Leonard y Sheldon son científicos destacados en Caltech, amigos a su vez de Howard y Raj, que son presentados como unos completos geeks.', 'Inglés', '2007-09-24');
INSERT INTO serie(id_serie, titulo, sinopsis, idioma, fecha_estreno) VALUES(2, 'Gambito de dama', 'Un absorbente drama de época que reivindica el ajedrez.', 'Inglés', '2020-10-23');
INSERT INTO serie(id_serie, titulo, sinopsis, idioma, fecha_estreno) VALUES(3, 'Aquí no hay quien viva', 'Se narra la vida de una peculiar comunidad de vecinos de la ficticia calle Desengaño, 21.', 'Español', '2003-09-07');
INSERT INTO serie(id_serie, titulo, sinopsis, idioma, fecha_estreno) VALUES(4, 'La casa de papel', 'Un misterioso hombre conocido como El Profesor está planeando el mayor atraco de la historia.', 'Español', '2017-05-05');

INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(1, 17, '2007-09-24', 1);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(2, 23, '2008-09-22', 1);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(3, 23, '2009-09-21', 1);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(4, 24, '2010-09-23', 1);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(5, 24, '2011-09-22', 1);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(6, 24, '2012-09-27', 1);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(7, 24, '2013-09-26', 1);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(8, 24, '2014-09-22', 1);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(9, 24, '2015-09-21', 1);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(10, 24, '2016-09-19', 1);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(11, 24, '2017-09-25', 1);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(12, 24, '2018-09-24', 1);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(1, 7, '2020-10-23', 2);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(1, 17, '2003-09-07', 3);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(2, 13, '2004-03-24', 3);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(3, 33, '2004-10-06', 3);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(4, 14, '2005-11-09', 3);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(5, 13, '2006-04-06', 3);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(1, 15, '2017-05-05', 4);
INSERT INTO temporada(n_temporada, n_capitulos, fecha_estreno, id_serie) VALUES(2, 26, '2019-07-19', 4);

INSERT INTO usuario(id_usuario, nombre, apellido1, apellido2) VALUES(1, 'Daniel', 'Pérez', 'Villalba');
INSERT INTO usuario(id_usuario, nombre, apellido1, apellido2) VALUES(2, 'Laura', 'Mora', 'Ugarte');
INSERT INTO usuario(id_usuario, nombre, apellido1, apellido2) VALUES(3, 'Cristina', 'Iniesta', 'Gil');
INSERT INTO usuario(id_usuario, nombre, apellido1, apellido2) VALUES(4, 'Juan', 'Cabeza', 'Tébar');

INSERT INTO genero(id_genero, descripcion) VALUES (1, 'Acción');
INSERT INTO genero(id_genero, descripcion) VALUES (2, 'Comedia');
INSERT INTO genero(id_genero, descripcion) VALUES (3, 'Terror');
INSERT INTO genero(id_genero, descripcion) VALUES (4, 'Drama');
INSERT INTO genero(id_genero, descripcion) VALUES (5, 'Ciencia ficción');

INSERT INTO comenta(id_usuario, id_serie, texto, fecha) VALUES (4, 1, 'Es una buena serie, la recomiendo.', '2018-12-19');
INSERT INTO comenta(id_usuario, id_serie, texto, fecha) VALUES (2, 1, 'La mejor serie de todos los tiempos.', '2019-04-19');
INSERT INTO comenta(id_usuario, id_serie, texto, fecha) VALUES (3, 1, 'No es para tanto como dicen...', '2020-01-30');
INSERT INTO comenta(id_usuario, id_serie, texto, fecha) VALUES (2, 1, 'Bueno, igual exageré con mi comentario anterior.', '2020-02-06');
INSERT INTO comenta(id_usuario, id_serie, texto, fecha) VALUES (2, 4, 'Una serie imprescindible', '2020-10-12');
INSERT INTO comenta(id_usuario, id_serie, texto, fecha) VALUES (3, 3, 'Tronchante', '2021-03-22');

INSERT INTO pertenece(id_serie, id_genero) VALUES (1, 2);
INSERT INTO pertenece(id_serie, id_genero) VALUES (2, 2);
INSERT INTO pertenece(id_serie, id_genero) VALUES (2, 4);
INSERT INTO pertenece(id_serie, id_genero) VALUES (3, 2);
INSERT INTO pertenece(id_serie, id_genero) VALUES (4, 1);
INSERT INTO pertenece(id_serie, id_genero) VALUES (4, 5);