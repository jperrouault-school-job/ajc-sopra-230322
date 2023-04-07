-- Sélectionner le client ID 1
SELECT * FROM client WHERE cli_id = 1;

-- Sélectionner le produit dont le nom est égal à « Casque Tonfly »
SELECT * FROM produit WHERE pro_nom = 'Casque Tonfly';

-- Sélectionner les produits contenant « a »
SELECT * FROM produit WHERE pro_nom LIKE '%a%';

-- Sélectionner les produits commençant par « C »
SELECT * FROM produit WHERE pro_nom LIKE 'C%';

-- Sélectionner le client ID 1 ET le client ID 2
-- > Avec AND/OR et IN
SELECT * FROM client WHERE cli_id = 1 OR cli_id = 2;

SELECT * FROM client WHERE cli_id IN (1, 2);


-- Sélectionner les commandes qui n’ont pas de date
SELECT * FROM commande WHERE cmd_date IS NULL;
