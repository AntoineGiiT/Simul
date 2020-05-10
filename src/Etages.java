import java.util.ArrayDeque;
import java.util.Deque;

public class Etages {
	// Variables
	int niveau;
	int nbEscaliers;
	int nbObstacles;
	int nbIssues;
	Deque<Obstacles> obstacles;
	Deque<Escaliers> escaliers;
	Deque<Issues> issues;
	private Modele modele;
	
	// Constructeur
	public Etages(int niveau) {
		this.niveau = niveau;
		this.obstacles = createAllObstacles();
		this.escaliers = createEscaliers();
		this.issues = createIssues();
	}
	
	// Getters
	public int getNiveau() {
		return this.niveau;
	}
	public Deque<Obstacles> getObstacles(){
		return this.obstacles;
	}
	
	// Setters
	public void setNbEscaliers(int nbEscaliers) {
		this.nbEscaliers = nbEscaliers;
	}
	public void setNbObstacles(int nbObstacles) {
		this.nbObstacles = nbObstacles;
	}
	
	// Méthodes
	public Deque<Issues> createIssues(){
		Deque<Issues> result = new ArrayDeque<>();
		if(this.niveau == 0) {
			int nbIssues = this.nbIssues;
			for(int i = 0; i < nbIssues; i++) {
				if(i==0) {
					Issues issue = new Issues(10, (int)(modele.getHeight()/2), 50, 50);
					result.add(issue);
				}
				if(i==1) {
					Issues issue = new Issues(modele.getWidth()-10-50, (int)(modele.getHeight()/2), 50, 50);
					result.add(issue);
				}
				if(i==2) {
					Issues issue = new Issues((int)(modele.getWidth()/2), modele.getHeight() - 10 -50, 50, 50);
					result.add(issue);
				}
				if(i==3) {
					Issues issue = new Issues((int)(modele.getWidth()/2), 10, 50, 50);
					result.add(issue);
				} 
			}
		}
		return result;
	}
	
	public boolean isFree(int x, int y, double taille) {
		Deque<Obstacles> obstacles = this.obstacles;
		for(Obstacles o : obstacles) {
			if(!((x + taille >o.x && x <o.x + o.largeur) && (y + taille >o.y && y<o.y + o.hauteur))) {
				return true;
			}
		}
		return false;
	}
	
	public Deque<Escaliers> createEscaliers(){
		int nbEscaliers = this.nbEscaliers;
		Deque<Escaliers> result = new ArrayDeque<>();
		for(int i = 0; i < nbEscaliers; i++) {
			Escaliers e = new Escaliers(100 ,100 , 30, 30, this, modele.getEtagesRDC());
			result.add(e);
		}
		return result;
	}
	public Deque<Obstacles> createAllObstacles(){
		Deque<Obstacles> result = new ArrayDeque<>();
		result = createMur(result);
		result = separateEtage(result);
		result = insertObstacle(result);
		return result;
	}
	
	public Deque<Obstacles> insertObstacle(Deque<Obstacles> result){
		int nbObstacles = this.nbObstacles;
		for(int i = 0; i < nbObstacles; i++) {
			int h = 10 + (int)(Math.random()*(100-10));
			int l = 10 + (int)(Math.random()*(100-10));
			int x = (int)(Math.random()*modele.getWidth())-l;
			int y = (int)(Math.random()*modele.getHeight())-h;
			Obstacles o = new Obstacles(x, y, h, l, this);
			result.add(o);
		}
		return result;
	}
	public Deque<Obstacles> createMur(Deque<Obstacles> result){
		Obstacles murHaut = new Obstacles(0, 0, 10 , modele.getWidth(), this);
		Obstacles murBas = new Obstacles(modele.getHeight() - 10, 0, 10, modele.getWidth(), this);
		Obstacles murDroite = new Obstacles(modele.getWidth() - 10, 00, modele.getHeight(), 10, this);
		Obstacles murGauche = new Obstacles(0, 0, modele.getHeight(), 10, this);
		result.add(murGauche);
		result.add(murDroite);
		result.add(murHaut);
		result.add(murBas);
		return result;
	}
	public Deque<Obstacles> separateEtage(Deque<Obstacles> result){//entre 1 et 4
		int nbSalles = (int)(Math.random()*3);
		Deque<Integer> positionMur = new ArrayDeque<>();
		Deque<Double> repartition = new ArrayDeque<>();
		double sum = 0.0;
		double facteur = 50.0; // plus c'est grand moins ça change
		for(int i = 0; i<nbSalles; i++) {
			double k = Math.random() + facteur;
			sum += k;
			repartition.add(k);
		}
		for (Double k : repartition) {
			positionMur.add(((int)(k/sum)*modele.getWidth()));
		}
		for (Integer a : positionMur) {
			Obstacles mur = new Obstacles(0, a, 5, modele.getHeight(), this);
			result.add(mur);
		}
		return result;
	}
}
