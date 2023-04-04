package uml1;

public enum Os {
	WINDOWS("1991"), MACOS("2001"), LINUX("1985");

	// Attribut de valeur
	private String annee;

	public String getAnnee() {
		return annee;
	}
	
	private Os(String annee) {
		this.annee = annee;
	}
}
