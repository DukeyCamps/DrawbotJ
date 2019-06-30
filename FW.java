import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

public class FW extends JFrame

{
	boolean not_prepared = true;
	int x;
	int y;
	int width = 1920;
	int count = 0;
	int height = 1080;
	int sortscore = 0;
	int colorNum;
	double vg = 40;
	int as = 20;
	Color color1;
	boolean NOT_SORTING = true;
	int ITERATIONS = 0;
	int GLOBAL_R = rand.nextInt(255);
	int GLOBAL_G = rand.nextInt(255);
	int GLOBAL_B = rand.nextInt(255);
	static Random rand = new Random();
	static Color colorScheme;
	String rentype = "classic";
	ArrayList<Color> units = new ArrayList<>();	//TODO: read about List vs ArrayList

	public static void main(String[] args)		// main method

	{

		FW app = new FW(); 			// an applet is created

	}

	public FW()

	{

		setUndecorated(true); 		 // removes the top most bar
		setSize(width, height);		 // sets the size to screen width/height
		setState(6); 				 // has no current usage : setting frames
		setDefaultCloseOperation(3); // sets what happens on close
		setVisible(true); 			 // sets the frame visible
		setResizable(false);		 // doesn't allow resizing
		setTitle("Cool"); 			 // sets a title because why not
		x = (-35 * as);				 // sets the first x equal to : values (under 30 vs over 50)*-as make a
									 // difference
		y = 0; 						 // the first y to be displaced
		changeRenderType();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void paint(Graphics g)    						// THE ACTUAL DRAWING
	{
                  //		System.out.println("that happened");
//		if (!NOT_SORTING) {// IF SORTING
//		
//			if (y > height) {//IF HEIGHT REACHED
//				sortscore = 0;
//				revamp(false);
//				//sort the list
//				int n = units.size();
//				
//				for(int i = 0;i<n-1;i++) {
//					for(int j = 0; j < n-i-1; j++)
//					if(cc_value(units.get(j)) > cc_value(units.get(j+1))) {
//						System.out.println(cc_value(units.get(j)) +" swapped " + cc_value(units.get(j+1)));
//						Color swapper = units.get(j);
//						units.set(j, units.get(j+1));
//						units.set(j+1, swapper);
//						sortscore++;
//					}
//				}//DONE A SORTING PASS
//				
//				//NOW RENDER IT ON THE SCREEN HERE
//				
//			for(int i = 0; i < units.size(); i++) {
//			
//			g.setColor(units.get(i)); // setting the color for the UNIT
//			endhit();
//                     //			g.setColor(setColor(this.rentype));					//setting the color for the UNIT
//			g.fillRect(x, y, as, as);
//			x += vg; // spacing by width
//			as = (int) vg;										//conversion float -> int										//spacing by width
//			repaint();				
//			System.out.println("repainted");
//				}
//			
//
//count++;
//System.out.println("happened + count"+count + " s"+sortscore);
//			
//			
//			}
//						//repaint the canvas
////			g.drawRect(x, y, as, as);							//actual UNIT drawing
////			g.fillRect(x, y, as, as);
////			g.fillOval(x+50, y+39, as+50, as+50);
////			repaint(); // repaint the canvas
//			
//			
////			revamp(false);
//			if(count > 15) {
//				NOT_SORTING = true;
//				System.out.println("reDWDADWApainted");
//				count = 0;
//			}
//			System.out.println("last line");
//		}
		
		
		
		
		
		
		
//		else if(NOT_SORTING) {
		
		
		
		if(not_prepared) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 40));	
			not_prepared = false;
		}
		
		
		
//		if (y > height) {
//			NOT_SORTING = false;
//			g.drawString("Saved cubes "+units.size(), 1100, height - 100);
//			// END OF HEIGHT REACHED
////			System.out.println("Finished.");
//			ITERATIONS++;
//			revamp(true);
//			
//		if(y > height && count < 55) {
			
//			NOT_SORTING = false;
			
//		}
		if(y > height) {
			
			revamp(true);
			g.drawString("Saved cubes "+units.size(), 1100, height - 100);
			ITERATIONS++;
			if (this.vg < 9) {
				changeRenderType();
				super.paint(g);
				g.drawRect(0, 0, width, height);
				changeRenderType();
				System.out.println("Exiting... " + vg);
				this.vg = 500;
				this.x = 0 - as; 							//gets rid of the corner crap;
				this.y = 0 - as;
				GLOBAL_G = rand.nextInt(255);
				GLOBAL_B = rand.nextInt(255);
				GLOBAL_R = rand.nextInt(255);
				x = -as;
				y = 0;
				
			}}
		
															// TODO: 1)save coords
		endhit();
		g.setColor(setColor(this.rentype));					//setting the color for the UNIT
		as = (int) vg;										//conversion float -> int
		x += vg;											//spacing by width
//		g.drawRect(x, y, as, as);							//actual UNIT drawing
		repaint();											//repaint the canvas
		g.fillRect(x -as, y, as, as);
//		g.fillOval(x+50, y+39, as+50, as+50);
		

		}

		
		
		
		
		


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Color setColor(String rendertype) // a method that makes a new color using the 'GLOBAL' variables as limits

	{
		int R = 0, G = 0, B  = 0;
		if(rendertype.equals("classic-red"))
		{
			R = rand.nextInt(255);
			G = 0;
			B = 0;
		}
		else if(rendertype.equals("classic-green"))
		{
			R = 0;
			G = rand.nextInt(255);
			B = 0; 
		}
		else if(rendertype.equals("classic-blue"))
		{
			R = 0;
			G = 0;
			B = rand.nextInt(255);
		}
		else if(rendertype.equals("scatter"))
		{
			R = rand.nextInt(GLOBAL_R + 1);
			G = rand.nextInt(GLOBAL_G + 1);
			B = rand.nextInt(GLOBAL_B + 1);
		}
		else if(rendertype.equals("classic-white"))
		{
			
			if(rand.nextInt(2) == 0)
			{R = 255;G = 255;B = 255;}
			else
			{R = 0;G = 0;B = 0;}
			
		}
		
		else if(rendertype.equals("classic-5"))
		{
			
			if(rand.nextInt(2) == 0)
			{R = 39;G =60; B = rand.nextInt(117)+60;}
			else
			{R = 0;G = 0;B = 0;}
			
		}
		
			
		color1 = new Color(R, G, B); //CREATES THE COLOR HERE FROM THE RENDER PARAMETERS
		if(units.size() > 1000000) {
			units.clear();
			System.out.println("Cleared, "+ units.size());
		}
		if(x < 1 && y < 1) {
			for(int i = 0; i < units.size(); i++) {// DISPLAY COLORS
			}
		}
		units.add(color1);
		return color1;
	}

	public void revamp(boolean changevg) // (x,y) = (0,0) && smaller w/h

	{

		x = 0;
		y = 0;
		if(changevg) {
		this.vg = this.vg / 1.03;
		}
//		using();
	
	}
	
	

	public void using() // a method that prints current global scopes; TODO: make this a return type

	{

		System.out.println("R:" + GLOBAL_R + '\n' + "G:" + GLOBAL_G + '\n' + "B:" + GLOBAL_B);

	}
		
	
	public void changeRenderType()
	
	
	{
		int combo = rand.nextInt(5);
		switch(combo) 
		{
		case 0: 	this.rentype = "classic-red";   break;
		case 1: 	this.rentype = "classic-green";   break;
		case 2: 	this.rentype = "classic-blue";   break;
		case 3: 	this.rentype = "classic-white"; break;
		default: 	this.rentype = "classic-5";   break;
		}
		
	}
	
	
	
	public void sleep(long l) // a method that pauses the thread throughout the delay
	{
		try {
			Thread.sleep(l);
		} catch (Exception ex) {
			System.out.println("Error");

		}
	}
	void endhit() {
		if (x > width) {									// END OF WIDTH REACHED
			x = (0 - as);
			y += as;
		}
	}
	public int cc_value(Color c) {
		return c.getRed() + c.getGreen() + c.getBlue();
	}
}
