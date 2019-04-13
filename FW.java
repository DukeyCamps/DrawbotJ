import java.awt.Color;
import java.awt.Graphics;
import java.io.PrintStream;
import java.util.Random;
import javax.swing.JFrame;

public class FW extends JFrame

{

int x;
int y;
int width = 1920;
int height = 1080;
int colorNum;
double vg = 500;
int as = 20;
Color color1;
int GLOBAL_R = rand.nextInt(255);
int GLOBAL_G = rand.nextInt(GLOBAL_R);
int GLOBAL_B = rand.nextInt(255);
static Random rand = new Random();
static Color colorScheme;


public static void main(String[] args)

{



FW app = new FW();

}



public FW()

{

setUndecorated(true);
setSize(width, height);
setState(6);
setDefaultCloseOperation(3);
setVisible(true);
setResizable(false);
setTitle("Cool");
x = (-as);
y = 0;

}



public void paint(Graphics g)

{

try
{
Thread.sleep(0L);
} catch (Exception ex) {
System.out.println("Error");

}


if (x > width) {

x = (0 - as);
y += as;

}


if (y > height) {

System.out.println("Finished.");
revamp();


try {
System.out.println("Current vg: "+as);
Thread.sleep(0L);
} catch (Exception ex) {
System.out.println("Error");
}


if(this.vg < 7){


System.out.println("Exiting... "+vg);
this.vg = 500;
this.x = 0-as;
this.y = 0-as;
GLOBAL_G = rand.nextInt(255);
GLOBAL_B = rand.nextInt(255);
GLOBAL_R = rand.nextInt(GLOBAL_G);
x = -as;
y = 0;

}

}



g.setColor(color1);
as = (int)vg;
x += vg;
g.drawRect(x, y, as, as);
this.setColor();
repaint();
g.fillRect(x, y, as, as);


}



public void setColor()

{

int R = rand.nextInt(GLOBAL_R+1);
int G = rand.nextInt(GLOBAL_G+1);
int B = rand.nextInt(GLOBAL_B+1);
color1 = new Color(R, G, B);

}



public void revamp()

{

x=0;
y=0;
this.vg =this.vg / 1.05;
using();


}



public void using()

{


System.out.println("R:" + GLOBAL_R + '\n' +"G:" + GLOBAL_G + '\n' + "B:" + GLOBAL_B);

}

}
