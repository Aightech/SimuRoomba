package SimuRoomba;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
	private long time;
	
	private Controller GUI;
	private JPanel buttonPanel;
	
	private JPanel onMapPanel;
	private JButton onMapButtons[];
	
	private JPanel behaviorPanel;
	private JButton behaviorButtons[];
	
	
	
	public static void main(String[] args) 
	{
		Environment env = new Environment(400,400); 
		
		Simulation simulation = new Simulation(env);
	    
	    simulation.addBot(new Robot());
	    
	    simulation.start();

	}
	
	

	 public Simulation(Environment env)
	 {
		 this.myEnv = env;
		 
		 this.GUI = new Controller(this);
		 
		 setBackground(Color.white);
		 setOpaque(true);
		 
		 
		this.setPreferredSize(new Dimension(this.myEnv.getWidth(), this.myEnv.getHeigth())); // Taille de la fenetre
		
		JFrame ma_fenetre = new JFrame("Cercle rouge");
		
		this.onMapPanel = new JPanel();
		//On crée une première grille pour les nombres
		//GridLayout(int rows, int cols)
		GridLayout onMapGrid = new GridLayout(1,3);
		onMapPanel.setLayout(onMapGrid);
		//createEmptyBorder(North , West , South , East)
		//la fonction setBorder nous permet de séparer proprement les différents panels que nous utilisons
		onMapPanel.setBorder(BorderFactory.createEmptyBorder(6,2,2,3));
		
		//On crée tous les boutons des nombres
		this.onMapButtons = new JButton[3];
		for(int i = 0 ; i < 3; i++)
		{
			this.onMapButtons[i] = new JButton(String.valueOf(i));
			this.onMapPanel.add(this.onMapButtons[i]);
			//Pour chaque bouton on ajoute une action d'écoute
			//this.nbButtons[i].addActionListener(this);
		}
		
		
		this.behaviorPanel = new JPanel();
		GridLayout behaviorGrid = new GridLayout(1,3);
		behaviorPanel.setLayout(behaviorGrid);
		//createEmptyBorder(North , West , South , East)
		//la fonction setBorder nous permet de séparer proprement les différents panels que nous utilisons
		behaviorPanel.setBorder(BorderFactory.createEmptyBorder(6,2,2,3));
		
		//On crée tous les boutons des nombres
		this.behaviorButtons = new JButton[3];
		for(int i = 0 ; i < 3; i++)
		{
			this.behaviorButtons[i] = new JButton(String.valueOf(i));
			this.behaviorPanel.add(this.behaviorButtons[i]);
			//Pour chaque bouton on ajoute une action d'écoute
			//this.nbButtons[i].addActionListener(this);
		}
		
		this.buttonPanel = new JPanel();
		GridLayout buttonGrid = new GridLayout(2,1);
		buttonPanel.setLayout(buttonGrid);
		
		buttonPanel.add(onMapPanel,BorderLayout.WEST); // Le contenu est l'objet Move
		buttonPanel.add(behaviorPanel, BorderLayout.SOUTH);
		
		ma_fenetre.add(this, BorderLayout.WEST);
		ma_fenetre.add(buttonPanel, BorderLayout.EAST);
		//
		ma_fenetre.pack();
		ma_fenetre.setVisible(true);
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
		 this.GUI.start();
		 
		while(true)
		{
			this.update();
		}
		 
	 }
	 
	 public void update()
	 {
		 double dt = (System.nanoTime() - this.time) / 1e9;
		 this.time=System.nanoTime();
		 this.myEnv.setSampleTime(dt);
		 this.myBots.get(0).generateNext(this.myEnv);
		 //this.myEnv.update();
		//this.
	 }
	 
	 
	 
	 public class Controller extends Thread {

	        private Simulation sim;

	        public Controller(Simulation model) {
	            this.sim = model;
	        }

	        @Override
	        public void run() {
	            while (true) 
	            {
	                try {Thread.sleep(10);} 
	                catch (InterruptedException ex) {}
	                sim.repaint();
	            }
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
	  
	  
	  
	  /**
	   * affiche l'objet onMap sur la fenetre
	   * @param obj OnMap object
	   * @param g
	   */
	  public void display(OnMap obj,Graphics g)
	  {
			Graphics2D g2 = (Graphics2D) g;
			Pos pos = obj.getPos();
			// on dessin un disque rouge
			g2.setColor(Color.red);
			if(obj.getShape()==OnMap.shapes[0])
				g2.fillOval((int)pos.getX(),(int) pos.getY(),(int)obj.getSize() , (int)obj.getSize());
			else if(obj.getShape()==OnMap.shapes[1])
				g2.fillRect((int)pos.getX(),(int) pos.getY(), (int)obj.getSize(), (int)obj.getSize());
			else if(obj.getShape()==OnMap.shapes[2])//TODO gérer les polygon
				g2.fillRect((int)pos.getX(),(int) pos.getY(), (int)obj.getSize(), (int)obj.getSize());
			
			
	  }


}
