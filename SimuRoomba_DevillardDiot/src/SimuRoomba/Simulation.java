package SimuRoomba;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * The Simulation class
 * @author Alexis Devillard and Tiphaine Diot
 *
 */
public class Simulation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * Environment of the simulation: containing the dim of the room and the different obstacles and durts
	 */
	public Environment myEnv;
	
	/**
	 * List of the robot of the simulation
	 */
	public ArrayList<Robot> myBots = new ArrayList<Robot>();
	
	/**
	 * Current time of the simulation
	 */
	private long time;
	
	/**
	 * Object to create the graphical thread
	 */
	private Controller GUI;
	
	/**
	 * The graphical frame 
	 */
	private JFrame ma_fenetre;
	
	/**
	 * Some attributes for interactive GUI
	 */
	private JPanel buttonPanel;
	
	private JPanel onMapPanel;
	private JButton onMapButtons[];
	private String onMapItem[] = {"Robot","Obstacle","Durt"};
	
	private JPanel behaviorPanel;
	private JButton behaviorButtons[];
	private String behaviorType[] = {"Random","Around","Clever"};
	
	/**
	 * Boolean to switch from a GUI or Terminal simulation
	 */
	private boolean GUIactive=false;
	
	
	
	public static void main(String[] args) 
	{
		//create a environment of 4m x 4m
		Environment env = new Environment(400,400); 
		
		//create the simulation (here in GUI mode)
		Simulation simulation = new Simulation(env,true);
	    
		//add a robot to the simulation
	    simulation.addBot(new Robot());
	    
	    
	    //launch the simulation
	    simulation.start();

	}
	
	
/**
 * Costructor
 * @param env Environement of the simualtion
 * @param gui True for a graphical mode, false for a terminal mode
 */
	 public Simulation(Environment env,boolean gui)
	 {
		 this.myEnv = env;
		 this.GUIactive = gui;
		 if(gui)
		 {
			 this.GUI = new Controller(this);
			 this.initGUI();
		}
	 }
	 
	 
	 public void setEnv(Environment e){	this.myEnv = e;	}
	 
	 /**
	  * add a object on the environment of the simulation
	  * @param i 0: robot, 1: obstacle, 2: dirt
	  */
	 public void addOnMap(int i)
	 {
		 switch(i)
		 {
		 case 0://robot
			 this.addBot(new Robot());
			 break;
		 case 1://obstacle
			 this.myEnv.addObst(new Obstacle( (int)(this.myEnv.getWidth()*Math.random()) ,(int)(this.myEnv.getHeigth()*Math.random()) ) );
			 break;
		 case 2://dirt
			 this.myEnv.addDurt(new Durt((int)(this.myEnv.getWidth()*Math.random()) ,(int)(this.myEnv.getHeigth()*Math.random())));
			 break;
		 }
	 }
	 
	 
	 public void setBehavior(int j)
	 {
		 switch(j)
		 {
		 case 0:
		 {
			 for(int i=0;i<this.myBots.size();i++)
		    {
			    this.myBots.get(i).setBehavior(new BehaviorAlea());
		    }
		 }break;
			 
		 }
	 }
	 
	 public void addBot(Robot rob){	this.myBots.add(rob);	}
	 
	 /**
	  * Inits the simulation and launch the main loop
	  */
	 public void start()
	 {
		 //if the graphical mode is activated 
		 if(this.GUIactive)
			 this.GUI.start();
		
		this.time=System.nanoTime();		
		while(true)
		{
			this.update();
		}
		 
	 }
	 
	 /**
	  * Set the elapsed time beetween 2 update and update each robot of the simulation
	  */
	 public void update()
	 {
		 double dt = (System.nanoTime() - this.time) / 1e9;
		 this.time=System.nanoTime();
		 this.myEnv.setSampleTime(dt);
		 
		 System.out.print("Simulation:");
		 for(int i=0;i<this.myBots.size();i++)
			System.out.print("\t#robot n°"+ i + ": " + this.myBots.get(i).generateNext(this.myEnv));
		 
		 System.out.print("\n");
	 }
	 
	 /**
	  * Setup all the GUI objects
	  */
	 public void initGUI()
	 {
			 setBackground(Color.white);
			 setOpaque(true);
			 if(this.myEnv!=null)
				 this.setPreferredSize(new Dimension(this.myEnv.getWidth(), this.myEnv.getHeigth())); // Taille de la fenetre
			 else
				 this.setPreferredSize(new Dimension(200,200)); // Taille de la fenetre
			 
			ma_fenetre = new JFrame("Simulation Roomba");
			
			
			//------------ONMAP PANEL------------
			this.onMapPanel = new JPanel();
			//On crée une première grille pour les boutons ajoutant des objets de la carte
			onMapPanel.setLayout(new GridLayout(1,3));//GridLayout(int rows, int cols)
			//la fonction setBorder nous permet de séparer proprement les différents panels que nous utilisons
			onMapPanel.setBorder(BorderFactory.createEmptyBorder(6,2,2,3));//createEmptyBorder(North , West , South , East)
			
			//------------BEHAVIOR PANEL------------
			this.behaviorPanel = new JPanel();
			behaviorPanel.setLayout(new GridLayout(1,3));
			behaviorPanel.setBorder(BorderFactory.createEmptyBorder(6,2,2,3));
			
			//On crée un tableau pour tous les boutons des onMap
			this.onMapButtons = new JButton[3];
			//On crée tous un tableau pour tous le boutons des Comportements
			this.behaviorButtons = new JButton[3];
			for(int i = 0 ; i < 3; i++)
			{
				this.onMapButtons[i] = new JButton(this.onMapItem[i]);//on crée le bouton
				this.onMapPanel.add(this.onMapButtons[i]);//on ajoute le bouton au panel
				this.onMapButtons[i].addActionListener(this);//Pour chaque bouton on ajoute une action d'écoute
				
				this.behaviorButtons[i] = new JButton(this.behaviorType[i]);//on crée le bouton
				this.behaviorPanel.add(this.behaviorButtons[i]);//on ajoute le bouton au panel
				this.behaviorButtons[i].addActionListener(this);//Pour chaque bouton on ajoute une action d'écoute
			}
				
			// ------- BUTONS PANEL --------
			this.buttonPanel = new JPanel();
			buttonPanel.setLayout(new GridLayout(6,1));
			
			//on y ajoute les deux panel précedant et on insert des label Expplicatifs
			buttonPanel.add(new JLabel("OBJECTS",JLabel.CENTER));
			buttonPanel.add(new JLabel("(Click to randomly put one on the map)",JLabel.CENTER));
			buttonPanel.add(onMapPanel,BorderLayout.WEST); // Le contenu est l'objet Move
			buttonPanel.add(new JLabel("BEHAVIORS",JLabel.CENTER));
			buttonPanel.add(new JLabel("(Click to set robot(s) behavior)",JLabel.CENTER));
			buttonPanel.add(behaviorPanel, BorderLayout.SOUTH);
			
			//on place la zone représantant la pièce simulée
			ma_fenetre.add(this, BorderLayout.WEST);
			ma_fenetre.add(buttonPanel, BorderLayout.EAST);
			
			ma_fenetre.pack();
			ma_fenetre.setVisible(true);
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
	    
	    for(int i=0;i<this.myBots.size();i++)
	    {
		    display(this.myBots.get(i),g);
		    displaySensor(this.myBots.get(i),g);
	    }
	    
	    //on redessine tous les robots
	    for(int i=0;i<this.myEnv.nbDurt();i++)
	    {
		    display(this.myEnv.getDurt(i),g);
	    }
	    
	    for(int i=0;i<this.myEnv.nbObst();i++)
	    {
		    display(this.myEnv.getObst(i),g);
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
			
			g2.setColor(obj.color);
			int size = (int)obj.getSize();
			if(obj.getShape()==OnMap.shapes[0])//circle
				g2.fillOval((int)pos.getX()-size/2,(int) pos.getY()-size/2,size,size);
			else if(obj.getShape()==OnMap.shapes[1])//square
				g2.fillRect((int)pos.getX(),(int) pos.getY(), (int)obj.getSize(), (int)obj.getSize());
			else if(obj.getShape()==OnMap.shapes[2])//TODO gérer les polygon
				g2.fillRect((int)pos.getX(),(int) pos.getY(), (int)obj.getSize(), (int)obj.getSize());
			
			
	  }
	  
	  public void displaySensor(Robot rob,Graphics g)
	  {
		  Graphics2D g2 = (Graphics2D) g;
		  double dx = 0;
		  double dy = 0;
		  double thetar = rob.getPos().getTheta();
		  
		  for(int i = 0 ; i < rob.nbObstSensor() ; i++)
		  {
			  dx = rob.getObstSensor(i).getPos().getX();
			  dy = rob.getObstSensor(i).getPos().getY();
			  double ptx = rob.getPos().getX() + dx * Math.cos(thetar) + dy*Math.sin(thetar);
			  double pty = rob.getPos().getY() - dx * Math.sin(thetar) + dy*Math.cos(thetar);
			  g2.setColor(Color.BLUE);
			  g2.fillOval((int)(ptx-8),(int)( pty-8),16 , 16);
		  }
	  }
	  
	  @Override
		public void actionPerformed(ActionEvent e) 
		{
			//On regarde d'abord si on a cliqué sur un nombre
			for(int i = 0; i<3; i++)
				if(e.getSource() == this.onMapButtons[i])
					addOnMap(i);
			
			//On regarde d'abord si on a cliqué sur un nombre
			for(int i = 0; i<3; i++)
				if(e.getSource() == this.behaviorButtons[i])
					setBehavior(i);
		}
}
