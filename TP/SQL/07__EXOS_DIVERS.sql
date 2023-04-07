-- Sélectionner le nom et prénom du client id 3
SELECT cli_nom, cli_prenom
FROM client
WHERE cli_id = 3;

-- Sélectionner le nom et le delta prix vente / prix achat des produits
SELECT pro_nom, (pro_prix_vente - pro_prix_achat) AS delta
FROM produit;

-- Sélectionner les produits qui n'ont plus de stock
SELECT pro_nom
FROM produit
WHERE pro_stock = 0;

-- Sélectionner les dates de commande
SELECT cmd_date
FROM commande;

-- Sélectionner la note et le texte des commentaires
SELECT com_note, com_commentaire FROM commentaire;

-- Sélectionner la date d'achat du produit id 4 et de la commande id 1
SELECT ach_date
FROM achat
WHERE   ach_produit_id = 4
AND     ach_commande_id = 1;


-- --- jointures ci-dessous ---

-- Sélectionner les dates de commande avec le nom & prénom de leur client
SELECT cmd_date, cli_nom, cli_prenom
FROM commande
INNER JOIN client ON cli_id = cmd_client_id;

-- Sélectionner le nom des produits avec le nom de ses fournisseurs
SELECT pro_nom, fou_nom
FROM produit
INNER JOIN fournisseur ON fou_id = pro_fournisseur_id;

-- Sélectionner le nom du produit id 4 avec le nom de son fournisseur
SELECT pro_nom, fou_nom
FROM produit
INNER JOIN fournisseur ON fou_id = pro_fournisseur_id
WHERE pro_id = 4;

-- Sélectionner le nom du produit id 2 avec sa date d'achat
SELECT pro_nom, ach_date
FROM produit
INNER JOIN achat ON ach_produit_id = pro_id
WHERE pro_id = 2;

-- Sélectionner la note et le texte des commentaires avec le nom du client et le nom du produit
SELECT com_note, com_commentaire, cli_nom, pro_nom
FROM commentaire
INNER JOIN client ON cli_id = com_client_id
INNER JOIN produit ON pro_id = com_produit_id;

-- Sélectionner les produits qui n'ont pas été vendus
SELECT *
FROM produit
LEFT JOIN achat ON ach_produit_id = pro_id
WHERE ach_id IS NULL;


-- Avec requête imbriquée --
SELECT *
FROM produit
WHERE pro_id NOT IN (SELECT ach_produit_id FROM achat);

