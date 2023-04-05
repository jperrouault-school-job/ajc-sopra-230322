-- Insertion de données dans la table "client"
INSERT INTO client
	(CLI_NOM, CLI_PRENOM, CLI_AGE, CLI_ADRESSE, CLI_EMAIL, CLI_NUMERO_TELEPHONE)
	VALUES
	('PERROUAULT', 'Jérémy', 19, 'Chez moi', 'jeremy.perrouault@gmail.com', '0666902957'),
	('DROUIN', 'Alexis', 25, 'Chez lui', 'alexis.drouin@gmail.com', '07xx'),
	('YU', 'Hélène', 25, 'Chez elle', 'helene.yu@gmail.com', '06xx');

INSERT INTO client
	(CLI_NOM, CLI_PRENOM, CLI_AGE, CLI_ADRESSE, CLI_EMAIL, CLI_NUMERO_TELEPHONE)
	VALUES
	('DURAND', 'Marie', 25, 'Ad', 'marie.durand@gmail.com', '+3356');


-- Insertion de données dans la table "fournisseur"
INSERT INTO fournisseur
	(FOU_NOM, FOU_ADRESSE, FOU_NUMERO_TELEPHONE, FOU_RESPONSABLE)
	VALUES
		('GOPRO', 'A SAN FRANCISCO !', '00155154785164', 'Albert'),
		('DJI', 'San Francisco', '005152349955', 'Michel'),
		('Basik', 'Quelque part en France', '0245612378', 'Albert');


-- Insertion de données dans la table "produit"
INSERT INTO produit
	(PRO_REFERENCE, PRO_NOM, PRO_MODELE, PRO_PRIX_ACHAT, PRO_PRIX_VENTE, PRO_FOURNISSEUR_ID)
	VALUES
		('GP007', 'GoPRO HERO 7', 'Unique', 100, 349.99, 1),
		('GK001', 'GoPRO KARMA', 'Edition spéciale', 500, 699.99, 1),
		('MVP', 'MAVIC PRO', 'Wow', 998.99, 999.99, 2),
		('MVP2', 'MAVIC PRO 2 PACK', 'Edition collector', 650, 1349.99, 2),
		('PARA', 'Parachute France', 'Atom Legend R', 4950, 6999.99, 3),
		('COMBISUMMER', 'Combinaison été', 'beau bleu', 150, 350, 3),
		('TONFLY', 'Casque Tonfly', 'Superbe', 400, 500, 3);


-- Insertion de données dans la table "commande"
INSERT INTO commande
	(CMD_DATE, CMD_ETAT, CMD_QUANTITE, CMD_CLIENT_ID)
	VALUES
		(NULL, 2, 1, 1),
        ('2018-07-01 23:55:03', 0, 2, 2),
		('2019-03-27', 0, 2, 1),
		('2018-03-27', 0, 1, 3);


-- Insertion de données dans la table "achat"
INSERT INTO achat
(ACH_DATE, ACH_MONTANT, ACH_QUANTITE, ACH_PROMO, ACH_PRODUIT_ID, ACH_COMMANDE_ID)
	VALUES
		('2018-07-01 23:54:20.200', 100, 1, true, 4, 1),
		('2018-07-01 23:55:03', 349.99, 1, false, 1, 2),
        ('2019-03-26', 689.99, 1, false, 2, 2),
		('2019-03-27', 699.99, 2, true, 2, 3),
		('2018-03-27', 1300, 1, true, 4, 4);


-- Insertion de données dans la table "commentaire"
INSERT INTO commentaire
	(COM_COMMENTAIRE, COM_NOTE, COM_PRODUIT_ID, COM_CLIENT_ID)
	VALUES
		('Résiste bien à l''eau', 5, 1, 1);


-- Insertion de données dans la table "promotion"
INSERT INTO promotion
	(PMT_MONTANT, PMT_NOM, PMT_PRODUIT_ID)
	VALUES
		(30, '30 euros de réduc sur la GoPRO HERO 7 !!!', 1);
