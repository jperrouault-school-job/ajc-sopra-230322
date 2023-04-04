package uml2;

public class Personne {
	protected String nom;
	protected String prenom;
	private Civilite civilite = Civilite.FEMME;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	
	public void question() {
		
	}
	
	public void reponse() {
		
	}
	
	public void partirEnPause() {
		
	}
}
