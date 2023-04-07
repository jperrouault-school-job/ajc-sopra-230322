-- Sélectionner le nom du produit, sa / ses dates d'achat (avec jointure)

SELECT pro_nom, ach_date
FROM produit p
INNER JOIN achat a ON a.ach_produit_id = p.pro_id;


-- Sélectionner TOUS les clients (nom, prénom) et la date de commande si elle est dispo
SELECT cli_nom, cli_prenom, cmd_id, cmd_date
FROM client
LEFT JOIN commande ON cmd_client_id = cli_id;

SELECT cli_nom, cli_prenom, cmd_id, cmd_date
FROM commande
RIGHT JOIN client ON cmd_client_id = cli_id;




-- Sélectionner le nom du produit, sa / ses dates d'achat, l'id du client (jointure)
SELECT pro_nom, ach_date, cmd_client_id
FROM produit
INNER JOIN achat ON ach_produit_id = pro_id
INNER JOIN commande ON ach_commande_id = cmd_id;

-- Sélectionner le nom du produit, sa / ses dates d'achat, l'id du client et son prénom (jointure)
SELECT pro_nom, ach_date, cmd_client_id, cli_prenom
FROM produit
INNER JOIN achat ON ach_produit_id = pro_id
INNER JOIN commande ON ach_commande_id = cmd_id
INNER JOIN client ON cli_id = cmd_client_id;




-- Sélectionner les achats
-- > Avec les informations du client
-- > Avec les informations du produit
SELECT ach_id, cli_nom, cli_prenom, pro_nom
FROM achat
INNER JOIN commande ON cmd_id = ach_commande_id
INNER JOIN client ON cli_id = cmd_client_id
INNER JOIN produit ON pro_id = ach_produit_id;

