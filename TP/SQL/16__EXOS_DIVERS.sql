-- Insérer 2 réparateurs "Technicien" et "Technicien Expert".
INSERT INTO reparateur (rep_nom)
VALUES  ('Technicien'),
        ('Technicien Expert');

SELECT * FROM reparateur;

-- Mettre à jour les produits : les produits du fournisseur "Basik" sont réparés par "Technicien Expert". Les autres par "Technicien".
UPDATE  produit
SET     pro_reparateur_id = 2
WHERE   pro_fournisseur_id = 3;

UPDATE  produit
SET     pro_reparateur_id = 1
WHERE   pro_fournisseur_id != 3;

SELECT * FROM produit;

-- Faire une requête qui sélectionne le nom du produit et le nom de son technicien.
SELECT pro_nom, rep_nom
FROM produit
INNER JOIN reparateur ON rep_id = pro_reparateur_id;

-- Ajouter une table pour historiser les réparations. Il faut stocker la date de réparation, la raison, et quel produit a été réparé. N'oubliez pas la clé primaire, et la clé étrangère !
CREATE TABLE reparation (
    repa_id SERIAL,
    repa_date DATE DEFAULT CURRENT_TIMESTAMP,
    repa_raison TEXT,
    repa_produit_id INT NOT NULL,
    PRIMARY KEY (repa_id)
);

ALTER TABLE reparation
    ADD CONSTRAINT FK_ReparationProduit
    FOREIGN KEY (repa_produit_id)
    REFERENCES produit (pro_id);

-- Insérer quelques réparations, avec des données au hasard.
INSERT INTO reparation (repa_raison, repa_produit_id)
VALUES  ('Test 1', 1),
        ('Test 2', 3),
        ('Test 3', 5),
        ('Test 4', 3);

SELECT * FROM reparation;

-- Faire une requête qui sélectionne le nom du produit et le nombre de réparations. Attention, les produits qui n'ont pas été réparés doivent aussi s'afficher !
SELECT
    pro_nom,
    COUNT(repa_id) AS nb_reparations
FROM produit
LEFT JOIN reparation ON repa_produit_id = pro_id
GROUP BY pro_id;

-- Ou bien, avec requête imbriquée

SELECT
    pro_nom,
    (SELECT COUNT(repa_id) FROM reparation WHERE repa_produit_id = pro_id) AS nb_reparations
FROM produit;
