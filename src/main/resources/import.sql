INSERT INTO account (id, date_of_birth, name, surname, immagine) VALUES (1100, '1966-11-08', 'Gordon', 'Ramsay', '/images/uploads/account-photos/gr.webp');
INSERT INTO account (id, date_of_birth, name, surname, immagine) VALUES (1200, '1960-01-22', 'Jamie', 'Oliver', '/images/uploads/account-photos/jo.webp');
INSERT INTO account (id, date_of_birth, name, surname, immagine) VALUES (1300, '1971-10-15', 'Giada', 'De Laurentiis', '/images/uploads/account-photos/gdl.jpeg');
INSERT INTO account (id, date_of_birth, name, surname, immagine) VALUES (1400, '1949-12-02', 'Wolfgang', 'Puck', '/images/uploads/account-photos/wp.jpeg');
INSERT INTO account (id, date_of_birth, name, surname, immagine) VALUES (1500, '1968-09-15', 'Ina', 'Garten', '/images/uploads/account-photos/ig.jpeg');
INSERT INTO account (id, date_of_birth, name, surname, immagine) VALUES (1600, '1954-01-22', 'Emeril', 'Lagasse', '/images/uploads/account-photos/el.jpeg');
INSERT INTO account (id, date_of_birth, name, surname, immagine) VALUES (1700, '1959-04-19', 'Nigella', 'Lawson', '/images/uploads/account-photos/nl.jpeg');
INSERT INTO account (id, date_of_birth, name, surname, immagine) VALUES (1800, '1973-03-10', 'Bobby', 'Flay', '/images/uploads/account-photos/bf.jpeg');
INSERT INTO account (id, date_of_birth, name, surname, immagine) VALUES (1900, '1970-03-16', 'Rachael', 'Ray', '/images/uploads/account-photos/rr.webp');
INSERT INTO account (id, date_of_birth, name, surname, immagine) VALUES (2000, '1975-09-26', 'Paula', 'Deen', '/images/uploads/account-photos/pd.jpeg');
INSERT INTO account (id, date_of_birth, name, surname, immagine) VALUES (2100, '1963-09-12', 'Heinz', 'Beck', '/images/uploads/account-photos/heinz-beck.jpeg');
INSERT INTO account (id, date_of_birth, name, surname, immagine) VALUES (2200, '1960-10-19', 'Bruno', 'Barbieri', '/images/uploads/account-photos/bruno-barbieri.jpg');
INSERT INTO account (id, date_of_birth, name, surname, immagine) VALUES (2300, '1947-08-18', 'Iginio', 'Massari', '/images/uploads/account-photos/iginio-massari.jpeg');

INSERT INTO cuoco (date_of_birth, id, name, surname, account_id) VALUES ('1966-11-08', 100100, 'Gordon', 'Ramsay', 1100);
INSERT INTO cuoco (date_of_birth, id, name, surname, account_id) VALUES ('1960-01-22', 100200, 'Jamie', 'Oliver', 1200);
INSERT INTO cuoco (date_of_birth, id, name, surname, account_id) VALUES ('1971-10-15', 100300, 'Giada', 'De Laurentiis', 1300);
INSERT INTO cuoco (date_of_birth, id, name, surname, account_id) VALUES ('1949-12-02', 100400, 'Wolfgang', 'Puck', 1400);
INSERT INTO cuoco (date_of_birth, id, name, surname, account_id) VALUES ('1968-09-15', 100500, 'Ina', 'Garten', 1500);
INSERT INTO cuoco (date_of_birth, id, name, surname, account_id) VALUES ('1954-01-22', 100600, 'Emeril', 'Lagasse', 1600);
INSERT INTO cuoco (date_of_birth, id, name, surname, account_id) VALUES ('1959-04-19', 100700, 'Nigella', 'Lawson', 1700);
INSERT INTO cuoco (date_of_birth, id, name, surname, account_id) VALUES ('1973-03-10', 100800, 'Bobby', 'Flay', 1800);
INSERT INTO cuoco (date_of_birth, id, name, surname, account_id) VALUES ('1970-03-16', 100900, 'Rachael', 'Ray', 1900);
INSERT INTO cuoco (date_of_birth, id, name, surname, account_id) VALUES ('1975-09-26', 101000, 'Paula', 'Deen', 2000);
INSERT INTO cuoco (date_of_birth, id, name, surname, account_id) VALUES ('1963-09-12', 4200, 'Heinz', 'Beck', 2100);
INSERT INTO cuoco (date_of_birth, id, name, surname, account_id) VALUES ('1960-10-19', 4300, 'Bruno', 'Barbieri', 2200);
INSERT INTO cuoco (date_of_birth, id, name, surname, account_id) VALUES ('1947-08-18', 4400, 'Iginio', 'Massari', 2300);

INSERT INTO credentials (id, password, role, username, account_id) VALUES (200100, '$2a$10$dzij6ui0yu9tafh4tvyr.2tza/kkcj.ptjk4u2fj1lst9ajd.8sy', 'role_chef', 'gordonramsay', 1100);
INSERT INTO credentials (id, password, role, username, account_id) VALUES (200200, '$2a$10$zc60xwvw7wpflh7c2e/1ou26geyxl00t3r3nhpu2t8mxryuocz7pu', 'role_chef', 'jamieoliver', 1200);
INSERT INTO credentials (id, password, role, username, account_id) VALUES (200300, '$2a$10$zc60xwvw7wpflh7c2e/1ou26geyxl00t3r3nhpu2t8mxryuocz7pu', 'role_chef', 'giadadelaurentiis', 1300);
INSERT INTO credentials (id, password, role, username, account_id) VALUES (200400, '$2a$10$zc60xwvw7wpflh7c2e/1ou26geyxl00t3r3nhpu2t8mxryuocz7pu', 'role_chef', 'wolfgangpuck', 1400);
INSERT INTO credentials (id, password, role, username, account_id) VALUES (200500, '$2a$10$zc60xwvw7wpflh7c2e/1ou26geyxl00t3r3nhpu2t8mxryuocz7pu', 'role_chef', 'inagarten', 1500);
INSERT INTO credentials (id, password, role, username, account_id) VALUES (200600, '$2a$10$zc60xwvw7wpflh7c2e/1ou26geyxl00t3r3nhpu2t8mxryuocz7pu', 'role_chef', 'emerillagasse', 1600);
INSERT INTO credentials (id, password, role, username, account_id) VALUES (200700, '$2a$10$zc60xwvw7wpflh7c2e/1ou26geyxl00t3r3nhpu2t8mxryuocz7pu', 'role_chef', 'nigellalawson', 1700);
INSERT INTO credentials (id, password, role, username, account_id) VALUES (200800, '$2a$10$zc60xwvw7wpflh7c2e/1ou26geyxl00t3r3nhpu2t8mxryuocz7pu', 'role_chef', 'bobbyflay', 1800);
INSERT INTO credentials (id, password, role, username, account_id) VALUES (200900, '$2a$10$zc60xwvw7wpflh7c2e/1ou26geyxl00t3r3nhpu2t8mxryuocz7pu', 'role_chef', 'rachaelray', 1900);
INSERT INTO credentials (id, password, role, username, account_id) VALUES (201000, '$2a$10$zc60xwvw7wpflh7c2e/1ou26geyxl00t3r3nhpu2t8mxryuocz7pu', 'role_chef', 'pauladeen', 2000);
INSERT INTO credentials (id, password, role, username, account_id) VALUES (201100, '$2a$10$zc60xwvw7wpflh7c2e/1ou26geyxl00t3r3nhpu2t8mxryuocz7pu', 'role_chef', 'heinzbeck', 2100);
INSERT INTO credentials (id, password, role, username, account_id) VALUES (201200, '$2a$10$zc60xwvw7wpflh7c2e/1ou26geyxl00t3r3nhpu2t8mxryuocz7pu', 'role_chef', 'brunobarbieri', 2200);
INSERT INTO credentials (id, password, role, username, account_id) VALUES (201300, '$2a$10$zc60xwvw7wpflh7c2e/1ou26geyxl00t3r3nhpu2t8mxryuocz7pu', 'role_chef', 'iginiomassari', 2300);
INSERT INTO ingrediente (id, nome) VALUES (100, 'Farina'), (200, 'Zucchero'), (300, 'Burro'), (400, 'Uova'), (500, 'Latte'), (600, 'Sale'), (700, 'Pepe'), (800, 'Olio'), (900, 'Aglio'), (1000, 'Cipolla'), (1100, 'Carote'), (1200, 'Patate'), (1300, 'Pomodori'), (1400, 'Basilico'), (1500, 'Prezzemolo'), (1600, 'Rosmarino'), (1700, 'Timo'), (1800, 'Origano'), (1900, 'Cannella'), (2000, 'Noce Moscata'), (2100, 'Vaniglia'), (2200, 'Cioccolato'), (2300, 'Mandorle'), (2400, 'Noci'), (2500, 'Pistacchi'), (2600, 'Arachidi'), (2700, 'Lenticchie'), (2800, 'Fagioli'), (2900, 'Ceci'), (3000, 'Riso'), (3100, 'Grano'), (3200, 'Mais'), (3300, 'Avena'), (3400, 'Quinoa'), (3500, 'Salmone'), (3600, 'Tonno'), (3700, 'Gamberi'), (3800, 'Pollo'), (3900, 'Manzo'), (4000, 'Maiale'), (4100, 'Agnello'), (4200, 'Pesce Spada'), (4300, 'Sogliola'), (4400, 'Baccalà'), (4500, 'Scampi'), (4600, 'Calamari'), (4700, 'Cozze'), (4800, 'Vongole'), (4900, 'Funghi'), (5000, 'Tartufo');

-- Ricetta di Gordon Ramsay (cuoco_id 100100)
INSERT INTO ricetta (cuoco_id, id, descrizione, immagine, name) VALUES (100100, 1000, 'Beef Wellington', '/images/uploads/ricetta-photos/123bw.jpeg', 'Beef Wellington');

-- Ricetta di Jamie Oliver (cuoco_id 100200)
INSERT INTO ricetta (cuoco_id, id, descrizione, immagine, name) VALUES (100200, 2000, 'Pasta al Limone', '/images/uploads/ricetta-photos/123pl.webp', 'Pasta al Limone');

-- Ricetta di Giada De Laurentiis (cuoco_id 100300)
INSERT INTO ricetta (cuoco_id, id, descrizione, immagine, name) VALUES (100300, 3000, 'Lemon Ricotta Cookies', '/images/uploads/ricetta-photos/123lrc.jpeg', 'Lemon Ricotta Cookies');

-- Ricetta di Wolfgang Puck (cuoco_id 100400)
INSERT INTO ricetta (cuoco_id, id, descrizione, immagine, name) VALUES (100400, 4000, 'Smoked Salmon Pizza', '/images/uploads/ricetta-photos/123ssp.jpeg', 'Smoked Salmon Pizza');

-- Ricetta di Ina Garten (cuoco_id 100500)
INSERT INTO ricetta (cuoco_id, id, descrizione, immagine, name) VALUES (100500, 5000, 'Chicken Pot Pie', '/images/uploads/ricetta-photos/123cpp.jpeg', 'Chicken Pot Pie');

-- Ricetta di Emeril Lagasse (cuoco_id 100600)
INSERT INTO ricetta (cuoco_id, id, descrizione, immagine, name) VALUES (100600, 6000, 'Shrimp Creole', '/images/uploads/ricetta-photos/123sc.jpeg', 'Shrimp Creole');

-- Ricetta di Nigella Lawson (cuoco_id 100700)
INSERT INTO ricetta (cuoco_id, id, descrizione, immagine, name) VALUES (100700, 7000, 'Chocolate Guinness Cake', '/images/uploads/ricetta-photos/123cgc.jpeg', 'Chocolate Guinness Cake');

-- Ricetta di Bobby Flay (cuoco_id 100800)
INSERT INTO ricetta (cuoco_id, id, descrizione, immagine, name) VALUES (100800, 8000, 'Grilled Steak', '/images/uploads/ricetta-photos/123gst.jpeg', 'Grilled Steak');

-- Ricetta di Rachael Ray (cuoco_id 100900)
INSERT INTO ricetta (cuoco_id, id, descrizione, immagine, name) VALUES (100900, 9000, 'Spaghetti Carbonara', '/images/uploads/ricetta-photos/123spag.avif', 'Spaghetti Carbonara');

-- Ricetta di Paula Deen (cuoco_id 101000)
INSERT INTO ricetta (cuoco_id, id, descrizione, immagine, name) VALUES (101000, 10000, 'Southern Fried Chicken', '/images/uploads/ricetta-photos/123sfrc.jpeg', 'Southern Fried Chicken');

-- Ricetta di Karl Heinzback (cuoco_id 4200)
INSERT INTO ricetta (cuoco_id, id, descrizione, immagine, name) VALUES (4200, 11000, 'Sacher Torte', '/images/uploads/ricetta-photos/123st.jpeg', 'Sacher Torte');

-- Ricetta di Bruno Barbieri (cuoco_id 4300)
INSERT INTO ricetta (cuoco_id, id, descrizione, immagine, name) VALUES (4300, 12000, 'Risotto ai Funghi', '/images/uploads/ricetta-photos/123rfp.jpeg', 'Risotto ai Funghi');

-- Ricetta di Iginio Massari (cuoco_id 4400)
INSERT INTO ricetta (cuoco_id, id, descrizione, immagine, name) VALUES (4400, 13000, 'Tiramisù', '/images/uploads/ricetta-photos/123tsu.jpeg', 'Tiramisù');

-- Riga ricetta per Beef Wellington (ricetta_id 1000)
INSERT INTO riga_ricetta (id, ricetta_id, ingrediente_id, quantita) VALUES (100, 1000, 100, '300g'), (200, 1000, 200, '100g'), (300, 1000, 300, '200g'), (400, 1000, 400, '4'), (500, 1000, 500, '150ml'), (600, 1000, 600, 'q.b.'), (700, 1000, 700, 'q.b.'), (800, 1000, 800, '50ml');

-- Riga ricetta per Pasta al Limone (ricetta_id 2000)
INSERT INTO riga_ricetta (id, ricetta_id, ingrediente_id, quantita) VALUES (900, 2000, 100, '400g'), (1000, 2000, 200, '150g'), (1100, 2000, 300, '100g'), (1200, 2000, 400, '3'), (1300, 2000, 500, '200ml'), (1400, 2000, 900, '2 spicchi'), (1500, 2000, 1000, '1'), (1600, 2000, 1100, '2');

-- Riga ricetta per Lemon Ricotta Cookies (ricetta_id 3000)
INSERT INTO riga_ricetta (id, ricetta_id, ingrediente_id, quantita) VALUES (1700, 3000, 100, '250g'), (1800, 3000, 200, '200g'), (1900, 3000, 300, '150g'), (2000, 3000, 400, '2'), (2100, 3000, 1200, '100g'), (2200, 3000, 1300, '100g'), (2300, 3000, 1400, 'q.b.');

-- Riga ricetta per Smoked Salmon Pizza (ricetta_id 4000)
INSERT INTO riga_ricetta (id, ricetta_id, ingrediente_id, quantita) VALUES (2400, 4000, 100, '300g'), (2500, 4000, 200, '100g'), (2600, 4000, 300, '200g'), (2700, 4000, 400, '4'), (2800, 4000, 500, '150ml'), (2900, 4000, 1500, '50g'), (3000, 4000, 1600, '1 rametto'), (3100, 4000, 1700, '1 rametto');

-- Riga ricetta per Chicken Pot Pie (ricetta_id 5000)
INSERT INTO riga_ricetta (id, ricetta_id, ingrediente_id, quantita) VALUES (3200, 5000, 100, '400g'), (3300, 5000, 200, '150g'), (3400, 5000, 300, '100g'), (3500, 5000, 400, '3'), (3600, 5000, 1800, 'q.b.');

-- Riga ricetta per Shrimp Creole (ricetta_id 6000)
INSERT INTO riga_ricetta (id, ricetta_id, ingrediente_id, quantita) VALUES (3700, 6000, 100, '250g'), (3800, 6000, 200, '200g'), (3900, 6000, 300, '150g'), (4000, 6000, 400, '2'), (4100, 6000, 1900, 'q.b.');

-- Riga ricetta per Chocolate Guinness Cake (ricetta_id 7000)
INSERT INTO riga_ricetta (id, ricetta_id, ingrediente_id, quantita) VALUES (4200, 7000, 100, '300g'), (4300, 7000, 200, '100g'), (4400, 7000, 300, '200g'), (4500, 7000, 400, '4'), (4600, 7000, 2000, 'q.b.');

-- Riga ricetta per Grilled Steak (ricetta_id 8000)
INSERT INTO riga_ricetta (id, ricetta_id, ingrediente_id, quantita) VALUES (4700, 8000, 100, '400g'), (4800, 8000, 200, '150g'), (4900, 8000, 300, '100g'), (5000, 8000, 400, '3'), (5100, 8000, 2100, 'q.b.');

-- Riga ricetta per Spaghetti Carbonara (ricetta_id 9000)
INSERT INTO riga_ricetta (id, ricetta_id, ingrediente_id, quantita) VALUES (5200, 9000, 100, '250g'), (5300, 9000, 200, '200g'), (5400, 9000, 300, '150g'), (5500, 9000, 400, '2'), (5600, 9000, 2200, 'q.b.');

-- Riga ricetta per Southern Fried Chicken (ricetta_id 10000)
INSERT INTO riga_ricetta (id, ricetta_id, ingrediente_id, quantita) VALUES (5700, 10000, 100, '300g'), (5800, 10000, 200, '100g'), (5900, 10000, 300, '200g'), (6000, 10000, 400, '4'), (6100, 10000, 2300, 'q.b.');

-- Riga ricetta per Sacher Torte (ricetta_id 11000)
INSERT INTO riga_ricetta (id, ricetta_id, ingrediente_id, quantita) VALUES (6200, 11000, 100, '400g'), (6300, 11000, 200, '150g'), (6400, 11000, 300, '100g'), (6500, 11000, 400, '3'), (6600, 11000, 2100, 'q.b.');

-- Riga ricetta per Risotto ai Funghi (ricetta_id 12000)
INSERT INTO riga_ricetta (id, ricetta_id, ingrediente_id, quantita) VALUES (6700, 12000, 100, '250g'), (6800, 12000, 200, '200g'), (6900, 12000, 300, '150g'), (7000, 12000, 400, '2'), (7100, 12000, 1900, 'q.b.');

-- Riga ricetta per Tiramisù (ricetta_id 13000)
INSERT INTO riga_ricetta (id, ricetta_id, ingrediente_id, quantita) VALUES (7200, 13000, 100, '300g'), (7300, 13000, 200, '100g'), (7400, 13000, 300, '200g'), (7500, 13000, 400, '4'), (7600, 13000, 2000, 'q.b.');
