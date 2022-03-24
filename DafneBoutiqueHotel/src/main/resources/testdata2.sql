DROP TABLE dafne_reservations IF EXISTS;
CREATE TABLE IF NOT  dafne_reservations (id INT PRIMARY KEY AUTO_INCREMENT, bedsize VARCHAR (25), breakfast BIT (1), price FLOAT, suite VARCHAR (25)); 
