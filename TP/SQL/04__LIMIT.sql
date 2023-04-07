-- Sélectionner les 2 produits les moins cher (prix de vente)
SELECT *
FROM produit
ORDER BY pro_prix_vente
LIMIT 2;

-- Sélectionner les 2 suivants
SELECT *
FROM produit
ORDER BY pro_prix_vente
OFFSET 2
LIMIT 2;
