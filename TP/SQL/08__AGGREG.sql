-- Sélectionner le nombre de produits
SELECT COUNT(pro_id) AS nb FROM produit;
-- OU
SELECT COUNT(*) FROM produit;

-- Sélectionner le nombre de clients
SELECT COUNT(cli_id) AS nb FROM client;

-- Sélectionner la dernière date de commande (date plus grande)
SELECT MAX(cmd_date) AS derniere_date FROM commande;

-- Sélectionner le nombre de produits dont le delta prix vente / prix achat est > 100 euros
SELECT COUNT(pro_id) AS nb
FROM produit
WHERE (pro_prix_vente - pro_prix_achat) > 100;

SELECT COUNT(pro_id), ROUND(pro_prix_vente - pro_prix_achat) AS delta
FROM produit
WHERE (pro_prix_vente - pro_prix_achat) > 100
GROUP BY delta;

-- Sélectionner la somme totale de tous les achats (montant * quantité)
SELECT SUM(ach_montant * ach_quantite) AS total
FROM achat;

-- Sélectionner la somme totale de tous les achats (montant * quantité) avec l'id du produit concerné
SELECT SUM(ach_montant * ach_quantite) AS total, ach_produit_id
FROM achat
GROUP BY ach_produit_id;

-- Sélectionner la somme totale de tous les achats (montant * quantité), en ne gardant que ceux dont la somme dépasse 500e
SELECT SUM(ach_montant * ach_quantite) AS total, ach_produit_id
FROM achat
GROUP BY ach_produit_id
HAVING SUM(ach_montant * ach_quantite) > 500;

-- Sélectionner le nom du fournisseur et le nombre de produits qu'il fourni
SELECT fou_nom, COUNT(pro_id)
FROM fournisseur
LEFT JOIN produit ON pro_fournisseur_id = fou_id
GROUP BY fou_id;

-- Sélectionner le nom du produit id 1 avec la date de sa toute première commande (date d'achat minimum)
SELECT pro_nom, MIN(ach_date) AS premier_achat
FROM produit
INNER JOIN achat ON ach_produit_id = pro_id
WHERE pro_id = 1
GROUP BY pro_id;