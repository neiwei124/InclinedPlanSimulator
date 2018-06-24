//Ramp class
// random message
//import packages
import java.awt.Color;
import java.awt.Graphics;

public class Ramp {
    double theta; //angle of incline
    double u; //friction coefficient
    double length; //base length of ramp
    int[] xPos; //all the x coordinates of ramp
    int[] yPos; //all the y coordinates of ramp
    int gWidth, gLength; //drawpanel length and width to get the ramp into scale
    double scaleToGrid; //value to get the ramp to scale
    
    //ramp constructor
    public Ramp(double t, double coF, double l, int gw, int gl, double sg){
        this.gWidth = gw;
        this.scaleToGrid = sg;
        this.theta = t;
        this.u = coF;
        this.length = l*this.scaleToGrid;
        this.gLength = gl;
        this.xPos = this.getXCoordinates();
        this.yPos = this.getYCoordinates();
    }
    
    //calculates all the x coordinates of the ramp for xPos[]
    private int[] getXCoordinates(){
        int[] a = new int[3];
        int x = (int)Math.round(this.gWidth - scaleToGrid);
        a[0] = x;
        a[1] = a[2] = (int)(x - this.length);
        return a;
    }
    
    //calculates all the y coordinates of the ramp for yPos[]
    private int[] getYCoordinates(){
        int[] a = new int[4];
        int y = this.gLength;
        a[0] = a[1] = y;
        a[2] = (int)(y - this.length*Math.tan(theta));
        return a;
    }
    
    //updates xy coordinates of ramp by the user updating the angle/length
    public void update(double d, String w){
        if (w.equals("angle")) {
            this.theta = d;
        }
        else{
            this.length = d*this.scaleToGrid;
        }
        this.xPos = this.getXCoordinates();
        this.yPos = this.getYCoordinates();  
    }
    
    //draws the ramp onto draw panel
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, gWidth, gLength);
        g.setColor(Color.black);
        g.fillPolygon(this.xPos, this.yPos, 3);
    }
    
}
