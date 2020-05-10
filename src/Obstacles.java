public class Obstacles {
	// Variables
	int x, y;// Position du coin en haut � gauche
	int hauteur, largeur;
	Etages etage;

	// Constructeur
	public Obstacles(int x, int y, int hauteur, int largeur, Etages etage) {
		this.x = x;
		this.y = y;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.etage = etage;
	}
	
	// Getters
	public int getx() {
		return this.x;
	}

	public int gety() {
		return this.y;
	}

	public int getHauteur() {
		return this.hauteur;
	}

	public int getLargeur() {
		return this.largeur;
	}

	public Etages getEtage() {
		return this.etage;
	}
	// Setters
	public void setx(int ligne) {
		if (ligne < 0) {
			System.out.println("Position de ligne entr�e n�gative");
		} else {
			this.x = ligne;
		}

	}

	public void sety(int colonne) {
		if (colonne < 0) {
			System.out.println("Position de colonne entr�e n�gative");
		} else {
			this.y = colonne;
		}
	}

	public void setLargeur(int maLargeur) {
		if (maLargeur < 0) {
			System.out.println("Largeur entr�e n�gative");
		} else {
			this.largeur = maLargeur;
		}
	}

	public void setHauteur(int maHauteur) {
		if (maHauteur < 0) {
			System.out.println("Hauteur entr�e n�gative");
		} else {
			this.hauteur = maHauteur;
		}
	}
}
