INSERT into USER (id, username, email, password, role, enabled)  VALUES (111, 'james', 'james@gmail.com', '$2y$10$oCCEMtYELb.AF7V6GlR1p.Uuoumz3siHyJx2NBeeIC3avBpn95tcG','ADMIN', true);
INSERT into USER (id, username, email, password, role, enabled)  VALUES (112, 'kaleab','kaleab@gmail.com','$2y$10$oCCEMtYELb.AF7V6GlR1p.Uuoumz3siHyJx2NBeeIC3avBpn95tcG','SELLER', true);
INSERT into USER (id, username, email, password, role, enabled)  VALUES (113, 'serigne','serigne@gmail.com','$2y$10$oCCEMtYELb.AF7V6GlR1p.Uuoumz3siHyJx2NBeeIC3avBpn95tcG','BUYER', true);

INSERT into PERSON (id, first_name, last_name, email, phone, user_id) VALUES(111, 'kaleab', 'berhanu', 'kaleab@gmail.com','123456789',112);
INSERT into PERSON(id, first_name, last_name, email, phone, user_id) VALUES(112, 'serigne', 'modou', 'serigne@gmail.com','123456789',113);

INSERT into SELLER (id, is_approved) values (111, false);
INSERT into BUYER (id) VALUES (112);
