
CREATE TABLE demo(
    dem_id SERIAL,
    dem_nom VARCHAR(150), -- Par défaut, c'est NULLABLE
    dem_prenom VARCHAR(50) NOT NULL, -- On autorise pas les valeurs NULL
    dem_adresse VARCHAR(150) NOT NULL DEFAULT 'Valeur par défaut' -- Sans rien préciser, on aura la valeur par défaut
);

-- Pour les types de données
-- INT - entier
-- BIT - boolean
-- VARCHAR(n) - texte n carac max
-- TEXT - texte variable (pas de maxi)
-- DATE - date
-- DATETIME - date
-- TIMESTAMP - date
-- FLOAT - réel
-- DECIMAL(n, m) - n = nombre de chiffres, m = nombre chiffres après virgule (1254,86)

-- NULL (NULL POSSIBLE)
-- NOT NULL (NULL PAS POSSIBLE)



-- Créer une nouvelle table "reparateur"
-- > id, nom (varchar 150car.)
CREATE TABLE reparateur(
    rep_id SERIAL,
    rep_nom VARCHAR(150) NOT NULL
);