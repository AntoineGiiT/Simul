import java.util.ArrayDeque;
import java.util.Deque;

public class Modele {
	// Variables
	int nbIndividus, nbEtages;
	int width, height;
	Deque<Etages> etages;
	Deque<Individus> individus;
	
	// Constructeur
	public Modele(int nbIndividus, int nbEtages, int width, int height) {
		this.nbEtages = nbEtages;
		this.height = height;
		this.width = width;
		this.etages = createEtages(nbEtages);
		this.nbIndividus = nbIndividus;
		this.individus = createIndividus(nbIndividus);
	}
	
	// Getters
	public int getNbIndividus() {
		return this.nbIndividus;
	}
	public Deque<Individus> getIndividus(){
		return this.individus;
	}
	public int getNbEtages() {
		return this.nbEtages;
	}
	public Etages getEtagesRDC(){
		return this.etages.getFirst();
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	
	// Setters
	public void setWidth(int w) {
		this.width = w;
	}
	public void setHeight(int h) {
		this.height = h;
	}
	// Méthodes
	public Deque<Etages> createEtages(int nbEtages) {
		Deque<Etages> result = new ArrayDeque<>();
		for(int i = 0; i < nbEtages; i++) {
			Etages e = new Etages(i);
			result.add(e);
		}
		return result;
	}
	public Deque<Individus> createIndividus(int nbIndividus) {
		Deque<Individus> result = new ArrayDeque<>();
		Deque<Integer> repartition = new ArrayDeque<>();
		Deque<Double> repartition1 = new ArrayDeque<>();
		double sum = 0.0;
		for(int i = 0; i < this.nbEtages; i++) {
			double random = Math.random();
			sum += random;
			repartition1.add(random);
		}
		for(Double r : repartition1) {
			repartition.add((int)(nbIndividus * r/sum));
		}
		for(Etages e : this.etages) {
			int rep = repartition.removeFirst();
			for(int j = 0; j < rep; j++) {
				result.add(new Individus(0,0,this.width,this.height,e));
				int[] coord = randomCoord(e, result.getLast().getTaille());
				result.getLast().setX(coord[0]);
				result.getLast().setY(coord[1]);
			}
		}
		return result;
	}
	public int[] randomCoord(Etages e, double taille) {
		boolean isFree = false;
		int x,y;
		int[] result = {0,0};
		while(! isFree) {
			x = (int)(Math.random()*this.width);
			y = (int)(Math.random()*this.height);
			isFree = e.isFree(x, y, taille);
			result[0] = x;
			result[1] = y;
		}
		return result;
	}
}

