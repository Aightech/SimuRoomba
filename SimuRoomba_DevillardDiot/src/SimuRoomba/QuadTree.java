package SimuRoomba;

import java.util.ArrayList;
import java.util.List;


public class QuadTree {


	private int level;
	private List<OnMap> objects;
	private float posX, posY, width, height;
	private QuadTree[] nodes;
	
	 private Node root;

	    // helper node data type
	    private class Node {
	        int x, y;              // x- and y- coordinates
	        Node NW, NE, SE, SW;   // four subtrees
	        
	        //--------------//
	        //		|		//
	        //	NW	|	NE	//
	        //		|		//
	        //------|-------//
	        //		|		//
	        //	SW	|	SE	//
	        //		|		//
	        //--------------//
	        
	        OnMap obj;           // associated data
	        int nbObj;

	        Node(int x, int y,  OnMap pobj) {
	            this.x = x;
	            this.y = y;
	            this.obj = pobj;
	            this.nbObj =1;
	        }
	    }
	    
	    public void insert(OnMap obj) {
	        root = insert(root, obj);
	    }

	    private Node insert(Node h, OnMap obj) {
	    	
	    	if (h == null) return new Node(obj);
	    	
	    	h.nbObj++;
	    	
	    	int Tx=0;
	    	int Ty=0;
	    	int Bx=0;
	    	int By=0;
	    	
	    	
	        
	        //// if (eq(x, h.x) && eq(y, h.y)) h.value = value;  // duplicate
	        else if ( less(x, h.x) &&  less(y, h.y)) h.SW = insert(h.SW, x, y, value);
	        else if ( less(x, h.x) && !less(y, h.y)) h.NW = insert(h.NW, x, y, value);
	        else if (!less(x, h.x) &&  less(y, h.y)) h.SE = insert(h.SE, x, y, value);
	        else if (!less(x, h.x) && !less(y, h.y)) h.NE = insert(h.NE, x, y, value);
	        return h;
	    }
	
	
	
}