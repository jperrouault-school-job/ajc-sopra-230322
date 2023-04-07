-- Démo
SELECT * FROM client;
SELECT cli_nom, cli_prenom FROM client;

SELECT 'Coucou '||cli_prenom AS hello, '2' AS demo1, 3 AS demo2, cli_nom FROM client;




-- Sélectionner tous les clients
SELECT * FROM client;

-- Sélectionner le nom et le prix de vente de tous les produits
SELECT pro_nom, pro_prix_vente FROM produit;

-- Sélectionner toutes les commandes
SELECT * FROM commande;


-- Sélectionner le nom, et le prénom du client
-- > en renommant les colonnes "cli_nom" et "cli_prenom" par "nom" et "prenom"
SELECT cli_nom AS nom, cli_prenom AS prenom FROM client;


-- Sélectionner tous les nom & prénom des clients dans une seule colonne
-- > L'afficher en majuscules

SELECT UPPER(cli_nom||' '||cli_prenom) AS nom_prenom FROM client;

SELECT CONCAT(UPPER(cli_nom), ' ', UPPER(cli_prenom)) FROM client;


-- Sélectionner tous les mois et années des commandes (au format « mois-année »)
-- > Si la date est NULL, afficher « 0 »

SELECT
    COALESCE(
        DATE_PART('month', cmd_date)||'-'||DATE_PART('year', cmd_date),
        '0'
    )
FROM commande;

SELECT
    DATE_PART('month', cmd_date)||'-'||DATE_PART('year', cmd_date),
    CONCAT(DATE_PART('month', cmd_date), '-', DATE_PART('year', cmd_date))
FROM commande;