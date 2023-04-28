-- Nettoyages
DELETE FROM produit;
ALTER TABLE produit ALTER COLUMN pro_id RESTART WITH 1;

DELETE FROM fournisseur;
ALTER TABLE fournisseur ALTER COLUMN fou_id RESTART WITH 1;


-- Données par défaut

INSERT INTO fournisseur (fou_nom, fou_responsable)
	VALUES
		('GOPRO', 'Albert'),
		('DJI', 'Michel'),
		('Basik', 'Albert');


-- Insertion de données dans la table "produit"
INSERT INTO produit
	(pro_reference, pro_nom, pro_modele, pro_prix_vente, pro_fournisseur_id)
	VALUES
		('GP007', 'GoPRO HERO 7', 'Unique', 349.99, 1),
		('GK001', 'GoPRO KARMA', 'Edition spéciale', 699.99, 1),
		('MVP', 'MAVIC PRO', 'Wow', 999.99, 2),
		('MVP2', 'MAVIC PRO 2 PACK', 'Edition collector', 1349.99, 2),
		('PARA', 'Parachute France', 'Atom Legend R', 6999.99, 3),
		('COMBISUMMER', 'Combinaison été', 'beau bleu', 350, 3),
		('TONFLY', 'Casque Tonfly', 'Superbe', 500, 3);