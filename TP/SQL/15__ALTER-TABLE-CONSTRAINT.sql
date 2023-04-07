-- Ajouter la clé primaire sur la colonne rep_id de la table reparateur
ALTER TABLE reparateur
    ADD CONSTRAINT PK_Reparateur
    PRIMARY KEY (rep_id);

-- Ajouter une nouvelle colonne "pro_reparateur_id" sur la table produit
ALTER TABLE produit ADD COLUMN pro_reparateur_id INT;


-- ALTER TABLE produit DROP pro_reparateur_id;

-- Ajouter une contrainte de clé étrangère de produit vers reparateur
ALTER TABLE produit
    ADD CONSTRAINT FK_ProduitReparateur
    FOREIGN KEY (pro_reparateur_id)
    REFERENCES reparateur(rep_id)
    -- Si on ne précise pas ON DELETE ... ON UPDATE, par défaut c'est "NO ACTION" : empêche l'action
    -- ON DELETE SET NULL -- Si on supprime un réparateur, ça mettra la valeur NULL à l'id du réparateur du produit associé
    -- ON DELETE CASCADE -- Si on supprime un réparateur, ça supprimera les produits associés à ce réparateur
    -- ON UPDATE CASCADE -- Si on met à jour l'id d'un réparateur, ça mettra à jour l'id du réparateur du produit associé
    ;
