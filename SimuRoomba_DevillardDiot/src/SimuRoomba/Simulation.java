package SimuRoomba;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Main Loop of the Simulation
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public class Simulation extends JPanel {

	/**
	 * @attributs: myEnv, myBots, graphicInterface
	 */
	public boolean graphicInterface;
	public Environment myEnv;
	public ArrayList<Robot> myBots = new ArrayList<Robot>();
	
	public static void main(String[] args) 
	{
		JFrame ma_fenetre = new JFrame("Cercle rouge");
		Simulation simulation = new Simulation();
		simulation.setPreferredSize(new Dimension(400, 400)); // Taille de la fenetre
	    ma_fenetre.setContentPane(simulation); // Le contenu est l'objet Move
	    ma_fenetre.pack();
	    ma_fenetre.setVisible(true);
	    
	    simulation.addBot(new Robot());
	    
	    while (true)
		{
			
			// attend 0.01 sec
			try  { Thread.sleep(10); }
			catch (Exception e) {}
			// Redessine la fenetre (appelle automatiquement entre autres m.paint())
			simulation.repaint();
		}

	}
	
	  /**
	   * Fonction appelee automatiquement quand le JPanel est (re)dessine a l'ecran
	   */
	  public void paint(Graphics g) {
	      super.paint(g); // Dessine le contenu d'un panel
	    // on recupere la zone de dessin
	    Graphics2D g2 = (Graphics2D) g;
	    
	    // on efface l'écran
	    g2.setColor(Color.white);
	    g2.fillRect(0, 0, (int)g2.getClipBounds().getWidth(),(int) g2.getClipBounds().getHeight());
	    
	  //TODO on dessine l'environement 
	    /*
	    for(int i=0;i<this.myBots.size();i++)
	    {
		    display(this.myBots.get(i),g);
	    }*/
	    
	    //on redessine tous les robots
	    for(int i=0;i<this.myBots.size();i++)
	    {
		    display(this.myBots.get(i),g);
	    }
	    
	    
	    
	    
	    // on rend la main
	    g2.dispose();
	  }
	  
	  
	  public void display(OnMap obj,Graphics g)
	  {
			Graphics2D g2 = (Graphics2D) g;
			Pos pos = obj.getPos();
			// on dessin un disque rouge
			g2.setColor(Color.red);
			if(obj.getShape()==OnMap.shapes[0])
				g2.fillOval(pos.getX(), pos.getY(), 40, 40);
			System.out.println(OnMap.shapes[0]);
	  }
	

	 public Simulation()
	 {
		 setBackground(Color.white);
		 setOpaque(true);
	 }
	 public void setEnv(Environment e)
	 {
		 this.myEnv = e;
	 }
	 public void addBot(Robot rob)
	 {
		 this.myBots.add(rob);
	 }
	 public void start()
	 {
		 
	 }


}
