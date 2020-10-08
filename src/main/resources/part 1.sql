INSERT INTO project.users (user_id, active, email, first_name, last_name, password, name) VALUES (1, true, 'EmailAdmina@gmail.com', 'ImięAdmina', 'NazwiskoAdmina', '{bcrypt}$2a$10$.Cd34TUP7p1l2uKpWnukluS.QHl12FqbYC0WxyWA.gCIqDG/C/1V.', 'Admin');
INSERT INTO project.users (user_id, active, email, first_name, last_name, password, name) VALUES (2, true, 'Klient@gmail.com', 'Imię Klienta', 'Nazwisko Klienta', '{bcrypt}$2a$10$5pPmmtw4JhTkONeqk0Fuzu9bsZRD7pF18AUofUNfe89oRHHCDIb6C', 'Klient');


INSERT INTO project.user_roles (user_user_id, roles) VALUES (1, 'ROLE_ADMIN');
INSERT INTO project.user_roles (user_user_id, roles) VALUES (2, 'ROLE_CLIENT');


INSERT INTO project.categories (category_id, name, status) VALUES (1, 'Konsole do gier', true);
INSERT INTO project.categories (category_id, name, status) VALUES (2, 'Smartfony i telefony komórkowe', true);
INSERT INTO project.categories (category_id, name, status) VALUES (3, 'Tablety', true);
INSERT INTO project.categories (category_id, name, status) VALUES (4, 'Smartwatche', true);
