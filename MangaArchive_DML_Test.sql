-- Insert into demografia table
INSERT INTO demografia (demografia_id, nombre) VALUES (1, 'Demography 1');
INSERT INTO demografia (demografia_id, nombre) VALUES (2, 'Demography 2');
INSERT INTO demografia (demografia_id, nombre) VALUES (3, 'Demography 3');
INSERT INTO demografia (demografia_id, nombre) VALUES (4, 'Demography 4');
INSERT INTO demografia (demografia_id, nombre) VALUES (5, 'Demography 5');

-- Insert into nacionalidad table
INSERT INTO nacionalidad (nacionalidad_id, nombre) VALUES (1, 'Nationality 1');
INSERT INTO nacionalidad (nacionalidad_id, nombre) VALUES (2, 'Nationality 2');
INSERT INTO nacionalidad (nacionalidad_id, nombre) VALUES (3, 'Nationality 3');
INSERT INTO nacionalidad (nacionalidad_id, nombre) VALUES (4, 'Nationality 4');
INSERT INTO nacionalidad (nacionalidad_id, nombre) VALUES (5, 'Nationality 5');

-- Insert into autor table
INSERT INTO autor (autor_id, nombre, nacionalidad_id) VALUES (1, 'Author Name 1', 1);
INSERT INTO autor (autor_id, nombre, nacionalidad_id) VALUES (2, 'Author Name 2', 2);
INSERT INTO autor (autor_id, nombre, nacionalidad_id) VALUES (3, 'Author Name 3', 3);
INSERT INTO autor (autor_id, nombre, nacionalidad_id) VALUES (4, 'Author Name 4', 1);
INSERT INTO autor (autor_id, nombre, nacionalidad_id) VALUES (5, 'Author Name 5', 2);

-- Insert into tipo_genero table
INSERT INTO tipo_genero (tipo_genero_id, nombre_genero) VALUES (1, 'Genre 1');
INSERT INTO tipo_genero (tipo_genero_id, nombre_genero) VALUES (2, 'Genre 2');
INSERT INTO tipo_genero (tipo_genero_id, nombre_genero) VALUES (3, 'Genre 3');
INSERT INTO tipo_genero (tipo_genero_id, nombre_genero) VALUES (4, 'Genre 4');
INSERT INTO tipo_genero (tipo_genero_id, nombre_genero) VALUES (5, 'Genre 5');

-- Insert into manga table
INSERT INTO manga (manga_id, titulo, precio, autor_id, demografia_id) VALUES (1, 'Manga Title 1', 10, 1, 1);
INSERT INTO manga (manga_id, titulo, precio, autor_id, demografia_id) VALUES (2, 'Manga Title 2', 12, 2, 2);
INSERT INTO manga (manga_id, titulo, precio, autor_id, demografia_id) VALUES (3, 'Manga Title 3', 15, 3, 3);
INSERT INTO manga (manga_id, titulo, precio, autor_id, demografia_id) VALUES (4, 'Manga Title 4', 8, 4, 4);
INSERT INTO manga (manga_id, titulo, precio, autor_id, demografia_id) VALUES (5, 'Manga Title 5', 20, 5, 5);

-- Insert into genero table
INSERT INTO genero (manga_id, tipo_genero_id) VALUES (1, 1);
INSERT INTO genero (manga_id, tipo_genero_id) VALUES (2, 2);
INSERT INTO genero (manga_id, tipo_genero_id) VALUES (3, 3);
INSERT INTO genero (manga_id, tipo_genero_id) VALUES (4, 4);
INSERT INTO genero (manga_id, tipo_genero_id) VALUES (5, 5);

-- Insert into tomo table
INSERT INTO tomo (manga_id, tomo_num, stock) VALUES (1, 1, 20);
INSERT INTO tomo (manga_id, tomo_num, stock) VALUES (2, 1, 15);
INSERT INTO tomo (manga_id, tomo_num, stock) VALUES (3, 1, 25);
INSERT INTO tomo (manga_id, tomo_num, stock) VALUES (4, 1, 30);
INSERT INTO tomo (manga_id, tomo_num, stock) VALUES (5, 1, 10);