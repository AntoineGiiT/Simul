
public class Individus {
	// Variables
	double x,y,dx,dy,taille,vitesseMax;
	int tempsReaction;
	Etages etage;
	
	// Constructeur
	public Individus(int Xmin, int Xmax, int Ymin, int Ymax, Etages etage) {
		this.taille = 8 + Math.random()*(12-8);//on fait varier nos tailles entre 8 et 12
		this.x = Xmin + Math.random()*(Xmax-Xmin) - taille;
		this.y = Ymin + Math.random()*(Ymax-Ymin) - taille;
		this.vitesseMax = 0.8 + Math.random()*(1.5-0.8);
		this.dx = 2*Math.random() - 1;
		this.dy = 2*Math.random() - 1;		
		double V = Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
		this.dx = Math.random()*vitesseMax*dx/V; 
		this.dy = Math.random()*vitesseMax*dy/V;
		this.tempsReaction = 3*60 + (int)(Math.random()*2*60);
		this.etage = etage;
	}
	
	// Getters
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getDX() {
		return this.dx;
	}
	public double getDY() {
		return this.dy;
	}
	public double getTaille() {
		return this.taille;
	}
	public double getVitesseMax() {
		return this.vitesseMax;
	}
	public int getTempsReaction() {
		return this.tempsReaction;
	}
	public Etages getEtage() {
		return this.etage;
	}

	// Setters
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setDX(double dx) {
		this.dx = dx;
	}
	public void setDY(double dy) {
		this.dy = dy;
	}
	public void setTaille(double taille) {
		this.taille = taille;
	}
	public void setVitesseMax(double vitesseMax) {
		this.vitesseMax = vitesseMax;
	}
	public void setTempsReaction(int tempsReaction) {
		this.tempsReaction = tempsReaction;
	}
	public void setEtage(Etages etage) {
		this.etage = etage;
	}
}
