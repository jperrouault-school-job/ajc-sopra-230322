package fr.formation.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Note") // Valeur du champ discriminant de la table commentaire
public class CommentaireNote extends Commentaire {
	@Column(name = "com_note", nullable = false)
	private int note;

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
}
