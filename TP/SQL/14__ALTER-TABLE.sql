-- Ajouter un numéro de téléphone (Nullable, texte de 20 car.) à la table reparateur
ALTER TABLE reparateur ADD COLUMN rep_telephone VARCHAR(20);

-- Modifier le type de données
ALTER TABLE reparateur ALTER COLUMN rep_telephone TYPE VARCHAR(20);

-- Modifier les options NULL / NOT NULL
ALTER TABLE reparateur ALTER COLUMN rep_telephone SET NOT NULL;
ALTER TABLE reparateur ALTER COLUMN rep_telephone DROP NOT NULL;