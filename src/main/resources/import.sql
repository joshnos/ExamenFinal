INSERT INTO login.role (id,name) VALUES ('1', 'ADMIN');
INSERT INTO login.role (id,name) VALUES ('2', 'EMP');
INSERT INTO login.role (id,name) VALUES ('3', 'USER');
INSERT INTO login.user_role (user_id, role_id) VALUES ('1', '3');
INSERT INTO login.user_role (user_id, role_id) VALUES ('2', '3');
INSERT INTO login.user_role (user_id, role_id) VALUES ('3', '1');
INSERT INTO login.user_role (user_id, role_id) VALUES ('4', '2');
INSERT INTO login.user_role (user_id, role_id) VALUES ('5', '2');
INSERT INTO login.ciudad (id_ciudad, name) VALUES ('1', 'Cochabamba');
INSERT INTO login.ciudad (id_ciudad, name) VALUES ('2', 'La Paz');
INSERT INTO login.user (id, email, name, password, id_ciudad) VALUES ('1', 'jorge@admin.com', 'JorgeAdmin', '$2a$10$TC/fQGES7u.A.dVGzPmGG.3wLKiY5JOM1sy/kOENzLJ523tHo7cou', '1');
INSERT INTO login.user (id, email, name, password, id_ciudad) VALUES ('2', 'carlos@user.com', 'Carlos', '$2a$10$g0/w4E77.LAE.U16p9T7C.gkN8kpZasZJ/bFxBvwRG6HbP7b1CyvC', '1');
INSERT INTO login.user (id, email, name, password, id_ciudad) VALUES ('3', 'fernanda@user.com', 'Fernanda', '$2a$10$EQqLfHCcMpLKPDPT4LUp5u6IS6CKiOA15Pk72mzddUGFFg/dL1IX.', '2');
INSERT INTO login.user (id, email, name, password, id_ciudad) VALUES ('4', 'elis@restaurante.com', 'Elis', '$2a$10$piZdnPVa/sl3tV5BDgUXoOGEQRy3bwaSjAR.5DMdSaJgVOqgsX04K', '2');
INSERT INTO login.user (id, email, name, password, id_ciudad) VALUES ('5', 'napolis@restaurante.com', 'Napolis', '$2a$10$4CZKeqm3UsyMX4G7K2H7QuFuJ35WAUj2s//NUovhl3ZHeaj3/Rw6O', '1');
INSERT INTO login.user_role (user_id, role_id) VALUES ('1', '1');
INSERT INTO login.user_role (user_id, role_id) VALUES ('2', '3');
INSERT INTO login.user_role (user_id, role_id) VALUES ('3', '3');
INSERT INTO login.user_role (user_id, role_id) VALUES ('4', '2');
INSERT INTO login.user_role (user_id, role_id) VALUES ('5', '2');
INSERT INTO login.empresa (id_empresa, calificacion, descripcion`, image, nombre, telefono, id_ciudad, direccion_id, user_id) VALUES ('1', '0', 'Pizzeria Elis, la mejor pizza de la ciudad ', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrdWV_DMpMonod7KJ53pXDh9ybxEhwkwZ0QHAU72HmZnxfuT2EBg', 'Elis', '2401778', '2', '2', '4');
INSERT INTO login.empresa (id_empresa, calificacion, descripcion`, image, nombre, telefono, id_ciudad, direccion_id, user_id) VALUES ('2', '0', 'La mejor pizza que encontraras', '', 'Napolis', 'https://scontent.fcbb1-1.fna.fbcdn.net/v/t1.0-9/18341733_1308410225902504_4549967646486291410_n.jpg?oh=166118732b4c12800fdfaa4643ce890c&oe=5AC1A62E', '1', '4', '5');
INSERT INTO login.direccion (id, latitud, longitud) VALUES ('1', '-17.373403901735262', '-66.1523426110216');
INSERT INTO login.direccion (id, latitud, longitud) VALUES ('2', '-16.507503915566062', '-68.1288022075023');


