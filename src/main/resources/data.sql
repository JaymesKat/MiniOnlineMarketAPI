INSERT into USER (id, username, email, password, role, enabled)  VALUES (111, 'james', 'james@gmail.com', '$2y$10$oCCEMtYELb.AF7V6GlR1p.Uuoumz3siHyJx2NBeeIC3avBpn95tcG','ADMIN', true);
INSERT into USER (id, username, email, password, role, enabled)  VALUES (112, 'kaleab','kaleab@gmail.com','$2y$10$oCCEMtYELb.AF7V6GlR1p.Uuoumz3siHyJx2NBeeIC3avBpn95tcG','SELLER', true);
INSERT into USER (id, username, email, password, role, enabled)  VALUES (113, 'serigne','serigne@gmail.com','$2y$10$oCCEMtYELb.AF7V6GlR1p.Uuoumz3siHyJx2NBeeIC3avBpn95tcG','BUYER', true);

INSERT into PERSON (id, first_name, last_name, email, phone, user_id) VALUES(111, 'kaleab', 'berhane', 'kaleab@gmail.com','123456789',112);
INSERT into PERSON(id, first_name, last_name, email, phone, user_id) VALUES(112, 'serigne', 'modou', 'serigne@gmail.com','123456789',113);

INSERT into SELLER (id, is_approved) values (111, false);
INSERT into BUYER (id) VALUES (112);

INSERT into PRODUCT (id, code, date_created, description, price, quantity, title, seller_id) VALUES (111, 'ABC123', '2021-12-09', '2021 model', 2999.99, 100, 'MacBook Pro', 111);
INSERT into PRODUCT (id, code, date_created, description, price, quantity, title, seller_id) VALUES (112, 'ABC124', '2021-12-09', 'Brand new 13" screen', 1999.99, 100, 'MacBook Air', 111);
INSERT into PRODUCT (id, code, date_created, description, price, quantity, title, seller_id) VALUES (113, 'XYZ124', '2021-12-09', 'Powerful high-end', 999.99, 30, 'iPhone 12', 111);

INSERT into ORDERS (id, date_created, status, buyer_id) VALUES (121, '2021-12-13T08:33:04', 'PENDING', 112);
INSERT into ORDERS (id, date_created, status, buyer_id) VALUES (122, '2021-12-14T11:05:12', 'SHIPPED', 112);
INSERT into ORDERS (id, date_created, status, buyer_id) VALUES (123, '2021-12-10T12:38:03', 'CANCELLED', 112);
INSERT into ORDERS (id, date_created, status, buyer_id) VALUES (124, '2021-12-14T23:45:15', 'DELIVERED', 112);

INSERT into ORDER_ITEM (id, quantity, order_id, product_id) VALUES (131, 2, 121, 111);
INSERT into ORDER_ITEM (id, quantity, order_id, product_id) VALUES (132, 1, 121, 113);
INSERT into ORDER_ITEM (id, quantity, order_id, product_id) VALUES (133, 1, 122, 112);
INSERT into ORDER_ITEM (id, quantity, order_id, product_id) VALUES (134, 1, 123, 112);
INSERT into ORDER_ITEM (id, quantity, order_id, product_id) VALUES (135, 1, 124, 111);
INSERT into ORDER_ITEM (id, quantity, order_id, product_id) VALUES (136, 1, 124, 113);
