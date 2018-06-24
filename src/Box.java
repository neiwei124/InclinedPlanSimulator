//Box class

//import packages
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Box {
    double theta, size = 50; //angle of which the box is rotated and box size
    double xInit, yInit; //the initial x and y value for starting the animation
    double mass; //mass of box
    double[] xPos; //all the x coordinates of box
    double[] yPos; //all the y coordinates of box
    double xCenter, yCenter; //center point of box - intended to draw fbd and fnet with tails at the centre
    
    //box constructor
    public Box(double t, double m, int x, int y) {
        this.theta = t;
        this.mass = m;
        this.xInit = x;
        this.yInit = y;
        
        //gets all the xy coordinates from initial x and y
        this.xPos = getXCoordinates(this.xInit);
        this.yPos = getYCoordinates(this.yInit);
        findCenter();
        
    }
    
    //calculates all the x coordinates of the box for xPos[]
    private double[] getXCoordinates(double x){
        double[] a = new double[4];
        a[0] = x; //x1
        a[1] = size * Math.cos(theta) + x; //x2
        a[2] = size * Math.sin(theta) + a[1]; //x3
        a[3] = size * Math.sin(theta) + x; //x4
        
        return a;
    }
    
    //calculates all the y coordinates of the box for yPos[]
    private double[] getYCoordinates(double y){
        double[] a = new double[4];
        a[0] = y; //y1
        a[1] = size * Math.sin(theta) + y; //y2
        a[2] = a[1] - size * Math.cos(theta); //y3
        a[3] = y - size * Math.cos(theta); //y4
        
        return a;
    }
    
    //method for finding the centre coordinates of the box
    private void findCenter(){
        double dist = ( Math.sqrt( (xPos[1] - xPos[3])*(xPos[1] - xPos[3]) + (yPos[1] - yPos[3])*(yPos[1] - yPos[3]) ) ) /2;
        xCenter = xPos[1] - dist * Math.cos(Math.PI/4 + theta);
        yCenter = yPos[1] - dist * Math.sin(Math.PI/4 + theta);
        
    }
    
    //draws the box onto the draw panel
    public void draw(Graphics g){
        g.setColor(Color.red);
        Polygon p = new Polygon();
        for (int i = 0; i < xPos.length; i++) {
            p.addPoint((int)Math.round(this.xPos[i]), (int)Math.round(this.yPos[i]));
        }
        g.fillPolygon(p);
    }
    
    //updates the position of box
    public void update(double x){ //the added x value from x initial
        this.xPos[0] = x + this.xInit;
        this.yPos[0] = this.yInit + x * Math.tan(this.theta); //calculates the box y1 value
        //gets the rest of x and y coordinates and updates the centre
        this.xPos = this.getXCoordinates(this.xPos[0]);
        this.yPos = this.getYCoordinates(this.yPos[0]);
        findCenter();
        
    }  
}
