-- Modifier le nom du client 1
UPDATE client
SET cli_nom = 'NOUVEAU 2'
WHERE cli_id = 1;

SELECT * FROM client;

-- Modifier le prix de vente du produit 2 (faire *2)
UPDATE produit
SET pro_prix_vente = (pro_prix_vente * 2)
WHERE pro_id = 2;

SELECT * FROM produit;



-- Création d'une table temporaire
SELECT * INTO tmpproduit
FROM produit;

select * from tmpproduit;

-- Reprendre des infos de la table temporaire (si besoin)
UPDATE produit p
SET pro_prix_vente = (SELECT tmp.pro_prix_vente FROM tmpproduit tmp WHERE tmp.pro_id = p.pro_id);

-- Supprimer la table temporaire
DROP TABLE tmpproduit;
