import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

public class FW_BUBBLE extends JFrame

{


	boolean first_iter = false;




	boolean not_prepared = true;
	int x;
	int y;
	int width = 1920;
	int count = 0;
	int height = 1080;
	int sortscore = 0;
	int colorNum;
	double vg = 500;
	int as = 20;
	Color color1;
	int color_iterator = 0;
	boolean NOT_SORTING = true;
	int ITERATIONS = 0;
	int GLOBAL_R = rand.nextInt(255);
	int GLOBAL_G = rand.nextInt(255);
	int GLOBAL_B = rand.nextInt(255);
	static Random rand = new Random();
	static Color colorScheme;
	int sort_changes = 0;
	String rentype = "classic";
	String currentMode = "";
	int floatiter = 0;
	int i = 0;
	//MODES : RENDERING/SORTING/FINALIZING
	//RENDERING - Creating a random chain of colors
	//SORTING - Doing a single sorting pass
	//FINALIZING - Drawing the cubes in list order
	ArrayList<Color> units = new ArrayList<>();	//TODO: read about List vs ArrayList

	public static void main(String[] args)		// main method

	{

		FW_BUBBLE app = new FW_BUBBLE(); 			// an applet is created

	}

	public FW_BUBBLE()

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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 //===================================================================================================
	  //===================================================================================================
	public void paint(Graphics g){//=========================================================================
 
	System.out.println(first_iter);

		//TODO: Make it draw the pic back after the first iteration
		if(first_iter){
			// System.out.println("iterating...");
		endhit();					
		// System.out.println("the color is "+color_iterator + " and the array size is "+units.size());
		g.setColor(units.get(color_iterator));
		// System.out.println("set color to "+units.get(color_iterator));
		as = (int) vg;										
		x += vg;																
		g.fillRect(x - as, y, as, as);
		repaint();		
			



		color_iterator++;

			if(y > height) {
				color_iterator = 0;
				revamp(false);

				if(i < units.size() - 1){
					for(int j = 0; j < units.size() - i - 1;j++){
						if(cc_value(units.get(j)) < cc_value(units.get(j+1))){
							Color temp = units.get(j);
							units.set(j, units.get(j+1));
							units.set(j + 1, temp);
							sort_changes++;
						}
					}
						if(sort_changes == 0){
							System.out.println("sort changes is 0");
							first_iter = false;	
							units.clear();
							changeRenderType();
							revamp(true);
						}
						else{
							sort_changes = 0;
						}
							// sleep(1L);
				}
				//TRANSLATE THIS TO THE FOR LOOP

				// color_iterator = 0;
				// units.set(floatiter++ -1, units.get(floatiter - 1));
				// sleep(1);
				// y = 0;x = 0;
				// System.out.println("HEIGHT REACHED!!!");
			}
		}
		else{





		if(y > height) {
			first_iter = true;
			revamp(false);
			if(!first_iter){
			revamp(true);
			g.drawString("Saved cubes "+units.size(), 1100, height - 100);
			ITERATIONS++;
			System.out.println("What rev "+ITERATIONS);
				if (this.vg < 5) 
				{
					changeRenderType();
					super.paint(g);
					g.drawRect(0, 0, width, height);
					changeRenderType();
					System.out.println("Exiting... " + vg);
					this.vg = 500;
					this.x = 0 - as; 							
					this.y = 0 - as;
					GLOBAL_G = rand.nextInt(255);
					GLOBAL_B = rand.nextInt(255);
					GLOBAL_R = rand.nextInt(255);
					x = -as;
					y = 0;
				}


												
			//SUMMARY: checks if x > width, converts the double cube sizes, adds to x, repaints, fills rectangle
					  }
			
			}
			if(not_prepared) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 60));	
			not_prepared = false;
			}

			endhit();
			g.setColor(setColor(this.rentype));					
			as = (int) vg;										
			x += vg;																
			g.fillRect(x - as, y, as, as);
			repaint();		


		}
		
		}//===================================================================================================
		//===================================================================================================
	   //===================================================================================================
		
		
		
		
		


	
	/*EXPLANATORY PSEUDO-CODE HERE
	So what i want to do is this:
	Write a bubble sort function that bubble sorts a pass each time y > height
	...
	now after it has passed bubble sorting, it has to start drawing using the newly
	created arraylist. since the colors are in order, all i want to do is for each
	paint pass, to redistribute the color back onto the canvas. I mean, how hard could it be? right?

	1.Start off with a way to infinitely paint the same canvas
	2.Insert the list sorting algorithm
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
			{R = 142;G =48+rand.nextInt(20); B = rand.nextInt(20)+150;}
			else
			{R = 52;G = 152;B = rand.nextInt(30)+200;}
			
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
