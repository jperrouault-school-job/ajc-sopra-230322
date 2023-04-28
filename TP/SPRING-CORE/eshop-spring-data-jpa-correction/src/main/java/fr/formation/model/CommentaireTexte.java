package fr.formation.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Texte") // Valeur du champ discriminant de la table commentaire
public class CommentaireTexte extends Commentaire {
	@Column(name = "com_commentaire", nullable = false)
	private String texte;

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}
}
