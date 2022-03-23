CREATE TABLE Dafne_boutique_hotel(
id long AUTO_INCREMENT,
suite VARCHAR (25) NOT NULL,
bedsize VARCHAR (25) NOT NULL,
price float NOT NULL,
breakfast boolean NOT NULL,
PRIMARY KEY (id)
);
INSERT INTO Dafne_boutique_hotel (suite, bedsize, price, breakfast) VALUES (suite1, bedsize1, 1, true);
INSERT INTO Dafne_boutique_hotel (suite, bedsize, price, breakfast) VALUES (suite2, bedsize2, 2, false);
