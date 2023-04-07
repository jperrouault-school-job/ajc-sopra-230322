-- Sélectionner tous les clients par ordre alphabétique (Prénom puis Nom)
SELECT * FROM client ORDER BY cli_prenom ASC, cli_nom ASC;

-- Sélectionner les produits dont le prix d’achat est entre 100 et 1000 euros, rangés par prix de vente décroissant
SELECT *
FROM produit
-- WHERE pro_prix_achat >= 100 AND pro_prix_achat <= 1000
WHERE pro_prix_achat BETWEEN 100 AND 1000
ORDER BY pro_prix_vente DESC;