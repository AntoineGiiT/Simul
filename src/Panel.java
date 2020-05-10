import java.awt.Color;
import java.awt.Graphics;
import java.util.Deque;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	Affichage a;
	Modele m = new Modele(100 , 1 ,700 , 500);
	
	public void paintComponent(Graphics g) {
		//FOND
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//MURS
		Deque<Individus> individus = m.getIndividus();
		g.setColor(Color.CYAN);
		for(Individus i : individus) {
			g.fillRect((int)i.getX(), (int)i.getY(), 5, 5);
		}
	}
	
}

