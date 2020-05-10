public class Escaliers {
	// Variables
	int x, y;
	int hauteur, largeur;
	Etages a,b; 
	
	// Constructeur
	public Escaliers(int x, int y, int hauteur, int largeur, Etages a, Etages b) {
		this.x = x;
		this.y = y;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.a = a;
		this.b = b;
	}

	// Getters
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public int getHauteur() {
		return this.hauteur;
	}

	public int getLargeur() {
		return this.largeur;
	}
	
	public Etages getEtageA() {
		return this.a;
	}
	public Etages getEtageB() {
		return this.b;
	}

	// Setters
	public void setX(int ligne) {
		if (ligne < 0) {
			System.out.println("Position de ligne entrée négative");
		} else {
			this.x = ligne;
		}
	}
	
	public void setY(int colonne) {
		if (colonne < 0) {
			System.out.println("Position de ligne entrée négative");
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
	
	public void setEtageA(Etages a) {
		this.a = a;
	}
	
	public void setEtageB(Etages b) {
		this.b = b;
	}
}
