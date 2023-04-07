SELECT * FROM client;

SELECT * FROM commande;

SELECT *
FROM client, commande
WHERE cli_id = cmd_client_id;

-- Sélectionner le nom du produit, sa / ses dates d'achat
SELECT pro_nom, ach_date
FROM produit, achat
WHERE ach_produit_id = pro_id;

-- Sélectionner le nom du produit, sa / ses dates d'achat, l'id du client
SELECT pro_nom, ach_date, cmd_client_id
FROM produit, achat, commande
WHERE ach_produit_id = pro_id
AND ach_commande_id = cmd_id;

-- Sélectionner le nom du produit, sa / ses dates d'achat, l'id du client et son prénom
SELECT pro_nom, ach_date, cmd_client_id, cli_prenom
FROM produit, achat, commande, client
WHERE ach_produit_id = pro_id
AND ach_commande_id = cmd_id
AND cmd_client_id = cli_id;