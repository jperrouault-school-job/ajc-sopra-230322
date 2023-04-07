
-- Exemples
SELECT cmd_client_id
FROM (SELECT cmd_date, cmd_client_id FROM commande) t;


SELECT
    cli_nom,
    (SELECT COUNT(cmd_id) FROM commande WHERE cmd_client_id = cli_id)
FROM client;

SELECT
    cli_nom, COUNT(cmd_id)
FROM client
LEFT JOIN commande ON cmd_client_id = cli_id
GROUP BY cli_id;


SELECT MAX(cmd_client_id) FROM commande;

SELECT cli_nom, cli_id
FROM client
WHERE cli_id = (SELECT MAX(cmd_client_id) FROM commande);


-- Sélectionner le nom & prénom des clients qui ont une commande
SELECT cli_nom, cli_prenom
FROM client
WHERE cli_id IN (SELECT cmd_client_id FROM commande);

-- > Les id client qui sont dans la table commande
SELECT cmd_client_id FROM commande;


-- Sélectionner le nom des produits qui n'ont pas été acheté
SELECT pro_nom
FROM produit
WHERE pro_id NOT IN (SELECT ach_produit_id FROM achat);

-- > Les id produit qui sont dans la table achat
SELECT ach_produit_id FROM achat;


-- Sélectionner le nom & prénom des clients avec le nombre de commandes passées
SELECT
    cli_nom,
    cli_prenom,
    (SELECT COUNT(cmd_id) FROM commande WHERE cmd_client_id = cli_id) AS nb_commandes
FROM client;

-- > Le nombre de commandes
SELECT COUNT(cmd_id) FROM commande;

-- > Le nombre de commandes pour UN client (id 1 par exemple)
SELECT COUNT(cmd_id) FROM commande WHERE cmd_client_id = 1;


-- Sélectionner le nom & prénom des clients avec leur date mini & date maxi des commandes (commandes du client en question bien sûr)
SELECT
    cli_nom,
    cli_prenom,
    (SELECT MIN(cmd_date) FROM commande WHERE cmd_client_id = cli_id) AS premiere_date,
    (SELECT MAX(cmd_date) FROM commande WHERE cmd_client_id = cli_id) AS deniere_date
FROM client;


-- > La date minimum pour une commande
SELECT MIN(cmd_date) FROM commande;

-- > La date minimum pour une commande en particulier (par exemple qui a l'id client = 1)
SELECT MIN(cmd_date) FROM commande WHERE cmd_client_id = 1;
