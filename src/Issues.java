public class Issues {
	// Variables
	int x, y;
	int hauteur, largeur;
	
	// Constructeur
	public Issues(int x, int y, int hauteur, int largeur) {
		this.x = x;
		this.y = y;
		this.hauteur = hauteur;
		this.largeur = largeur;
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

	// Setters
	public void setx(int ligne) {
		if (ligne < 0) {
			System.out.println("Position de ligne entrée négative");
		} else {
			this.x = ligne;
		}

	}

	public void sety(int colonne) {
		if (colonne < 0) {
			System.out.println("Position de colonne entrée négative");
		} else {
			this.y = colonne;
		}
	}

	public void setLargeur(int maLargeur) {
		if (maLargeur < 0) {
			System.out.println("Largeur entrée négative");
		} else {
			this.largeur = maLargeur;
		}
	}

	public void setHauteur(int maHauteur) {
		if (maHauteur < 0) {
			System.out.println("Hauteur entrée négative");
		} else {
			this.hauteur = maHauteur;
		}
	}
}
