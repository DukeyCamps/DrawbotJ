package cuberot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

public class FW_BUBBLE extends JFrame

{

	
//	SQUARE BEING DRAWN(top-left-x ; top-left-y; width; height)
//	TODO: Get rid of as or vg, since they can just be casted instead of taking up memory
//	as/vg are just a way to represent width/height @function:revamp(true)
	static Random rand = new Random();
	static Color colorScheme;
	Color color1;
	String currentMode = "";
	String rentype = "classic";
	ArrayList<Color> units = new ArrayList<>();

	private static final long serialVersionUID = 1L;
	boolean first_iter = false;
	boolean not_prepared = true;
	boolean NOT_SORTING = true;
	double vg = 500;
	int as = 20;
	int x;
	int y;
	int width = 1920;
	int count = 0;
	int height = 1080;
	int sortscore = 0;
	int colorNum;
	int color_iterator = 0;
	int floatiter = 0;
	int sort_changes = 0;
	int ITERATIONS = 0;
	int GLOBAL_R = rand.nextInt(255);
	int GLOBAL_G = rand.nextInt(255);
	int GLOBAL_B = rand.nextInt(255);
	int i = 0;

	public static void main(String[] args)

	{

		@SuppressWarnings("unused")
		FW_BUBBLE app = new FW_BUBBLE();

	}

	public FW_BUBBLE()

	{

		setUndecorated(true); 
		setSize(width, height); 
		setState(6); 
		setDefaultCloseOperation(3); 
		setVisible(true); 
		setResizable(false); 
		setTitle("Cool"); 
		x = (-35 * as); 		
		y = 0;
		changeRenderType();

	}

	public void paint(Graphics g) {

		System.out.println(first_iter);

		if (first_iter) {

			endhit();
			g.setColor(units.get(color_iterator));
			as = (int) vg;
			x += vg;
			g.fillRect(x - as, y, as, as);
			repaint();

			color_iterator++;

			if (y > height) {
				color_iterator = 0;
				revamp(false);

				if (i < units.size() - 1) {
					
					for (int j = 0; j < units.size() - i - 1; j++) 
						
						if (cc_value(units.get(j)) < cc_value(units.get(j + 1))) {
							Color temp = units.get(j);
							units.set(j, units.get(j + 1));
							units.set(j + 1, temp);
							sort_changes++;
							
						}
					
					
					if (sort_changes == 0) {
						System.out.println("sort changes is 0");
						first_iter = false;
						units.clear();
						changeRenderType();
						revamp(true);
					} else {
						sort_changes = 0;
					}
				}
			}
		} else {

			if (y > height) {
				first_iter = true;
				revamp(false);
				if (!first_iter) {
					revamp(true);
					g.drawString("Saved cubes " + units.size(), 1100, height - 100);
					ITERATIONS++;
					System.out.println("What rev " + ITERATIONS);
					if (this.vg < 5) {
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
				}

			}
			if (not_prepared) {
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

	}

	/*
	 * EXPLANATORY PSEUDO-CODE HERE So what i want to do is this: Write a bubble
	 * sort function that bubble sorts a pass each time y > height ... now after it
	 * had passed bubble sorting, it has to start drawing using the newly created
	 * arraylist. since the colors are in order, all i want to do is to redist the color
	 * after a paint pass
	 * 
	 * 
	 * 1.Start off with a way to infinitely paint the same canvas 2.Insert the list
	 * sorting algorithm
	 * 
	 * *delete this after*
	 */

	public Color setColor(String rendertype)	{
		
		int R = 0, G = 0, B = 0;
		
		//TODO: just use a switch instead
		
		if (rendertype.equals("classic-red")) {
			R = rand.nextInt(255);
			G = 0;
			B = 0;
		} else if (rendertype.equals("classic-green")) {
			R = 0;
			G = rand.nextInt(255);
			B = 0;
		} else if (rendertype.equals("classic-blue")) {
			R = 0;
			G = 0;
			B = rand.nextInt(255);
		} else if (rendertype.equals("scatter")) {
			R = rand.nextInt(GLOBAL_R + 1);
			G = rand.nextInt(GLOBAL_G + 1);
			B = rand.nextInt(GLOBAL_B + 1);
		} else if (rendertype.equals("classic-white")) {

			if (rand.nextInt(2) == 0) {
				R = 255;
				G = 255;
				B = 255;
			} else {
				R = 0;
				G = 0;
				B = 0;
			}

		}

		else if (rendertype.equals("classic-5")) {

			if (rand.nextInt(2) == 0) {
				R = 0;
				G = 145 + rand.nextInt(55);
				B = rand.nextInt(20) + 150;
			} else {
				R = 200 + rand.nextInt(55);
				G = 0;
				B = rand.nextInt(30) + 20;
			}

		}

		color1 = new Color(R, G, B); 
		if (units.size() > 1000000) {
			units.clear();
			System.out.println("Cleared, " + units.size());
		}
		if (x < 1 && y < 1) {
			for (int i = 0; i < units.size(); i++) {
			}
		}
		units.add(color1);
		return color1;
	}

	public void revamp(boolean changevg)

	{

		x = 0;
		y = 0;
		if (changevg) {
			this.vg = this.vg / 1.03;
		}


	}

	public void using() //TODO: make this a return type or delete it

	{

		System.out.println("R:" + GLOBAL_R + '\n' + "G:" + GLOBAL_G + '\n' + "B:" + GLOBAL_B);

	}

	public void changeRenderType()

	{
		int combo = rand.nextInt(5);
		switch (combo) {
		case 0:
			this.rentype = "classic-red";
			break;
		case 1:
			this.rentype = "classic-green";
			break;
		case 2:
			this.rentype = "classic-blue";
			break;
		case 3:
			this.rentype = "classic-white";
			break;
		default:
			this.rentype = "classic-5";
			break;
		}

	}

	public void sleep(long l) 
	{
		try {
			Thread.sleep(l);
		} catch (Exception ex) {
			System.out.println("Error");

		}
	}

	void endhit() {
		if (x > width) { 
			x = (0 - as);
			y += as;
		}
	}

	public int cc_value(Color c) {
		return c.getRed() + c.getGreen() + c.getBlue();
	}
}
