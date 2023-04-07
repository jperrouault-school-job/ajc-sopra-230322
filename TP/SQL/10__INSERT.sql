
-- Création d'une promo pour le produit id 5
INSERT INTO promotion (pmt_nom, pmt_montant, pmt_produit_id)
VALUES
('Démonstration 2', 500, 5);


-- Création d'une promo pour le produit id 6 et 7
INSERT INTO promotion (pmt_nom, pmt_montant, pmt_produit_id)
VALUES
('Démonstration 3', 600, 6),
('Démonstration 4', 700, 7);


-- Création d'une promo pour le produit id 2 et 3
INSERT INTO promotion (pmt_nom, pmt_montant, pmt_produit_id)
SELECT 'Promotion '||pro_nom, 50, pro_id
FROM produit
WHERE pro_id IN (2, 3);

SELECT * FROM promotion;



-- Insérer un nouveau produit (avec fournisseur id 1)
INSERT INTO produit (pro_nom, pro_reference, pro_modele, pro_prix_achat, pro_prix_vente, pro_fournisseur_id)
VALUES ('Chaisse', 'C007', 'La Chaise', 20, 200, 1);

SELECT * FROM produit;


-- Insérer un nouveau client
INSERT INTO client (cli_nom, cli_prenom, cli_email)
VALUES ('Bond', 'James', 'james@007.fr');

SELECT * FROM client;


-- Insérer un nouveau fournisseur
INSERT INTO fournisseur (fou_nom, fou_responsable)
VALUES ('Amazon', 'Albert');

SELECT * FROM fournisseur;

-- Insérer un nouveau produit (id nouveau fournisseur)
INSERT INTO produit (pro_nom, pro_reference, pro_modele, pro_prix_achat, pro_prix_vente, pro_fournisseur_id)
VALUES ('Casquette', 'BERET4', 'Beret France', 2, 19, 4);

INSERT INTO produit (pro_nom, pro_reference, pro_modele, pro_prix_achat, pro_prix_vente, pro_fournisseur_id)
VALUES ('Casquette', 'BERET4', 'Beret France', 2, 19, (SELECT MAX(fou_id) FROM fournisseur));

SELECT * FROM produit;


-- Insérer un nouveau commentaire (id client 1, id nouveau produit)
INSERT INTO commentaire (com_note, com_commentaire, com_client_id, com_produit_id)
VALUES (3, 'C''est moyen !', 1, 9);

SELECT * FROM commentaire;

-- Insérer une nouvelle commande (id nouveau client, date de maintenant (now()))
INSERT INTO commande (cmd_date, cmd_client_id)
VALUES (NOW(), 5);

SELECT * FROM commande;

-- Insérer 2 achats produit pour cette nouvelle commande (produit id 7 et 6, quantité 1, avec le bon prix de vente des produits)
INSERT INTO achat (ach_montant, ach_quantite, ach_commande_id, ach_produit_id)
SELECT pro_prix_vente, 1, 5, pro_id
FROM produit
WHERE pro_id IN (6, 7);

SELECT * FROM achat;