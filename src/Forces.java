//Forces class

//import packages
import java.awt.*;

public class Forces {
    //fields of forces
    String name; //name of the force
    double magnitude; //magnitude of the force
    double theta; //direction of the force
    double toScale = 5; //value for drawing the forces vector to scale
    
    //forces constructor
    public Forces(String n, double t, double m){
        this.name = n;
        this.theta = t;
        this.magnitude = m;
    }
    
    //method that draws the forces
    public void draw(int x, int y, Graphics g){
        int a = 5;
        double x3, y3, x4, y4;
        
        //draws the line segment
        g.setColor(Color.blue);
        double x2 = x + toScale*magnitude*Math.cos(theta);
        double y2 = y - toScale*magnitude*Math.sin(theta);
        g.drawLine(x, y, (int)x2, (int)y2);
        
        
        //draws the arrows based on quadrants of the line segment
        //if this force is gravity
        if (name.equals("Fg")) {
            x3 = x2 + a;
            y3 = y2 - a;
            x4 = x2 - a;
            y4 = y2 - a;
        }
        
        //first quadrant
        else if (theta < Math.PI/2) {
            x3 = x2 - a;
            y3 = y2;
            x4 = x2;
            y4 = y2 + a;
        }
        
        //second quadrant
        else if (theta < Math.PI) {
            x3 = x2 + a;
            y3 = y2;
            x4 = x2;
            y4 = y2 + a;
        }
        
        //third quadrant
        else if (theta < 3*Math.PI/2) {
            x3 = x2 + a;
            y3 = y2;
            x4 = x2;
            y4 = y2 - a;
        }
        
        //forth quadrant
        else{
            x3 = x2 - a;
            y3 = y2;
            x4 = x2;
            y4 = y2 - a;
        }
        
        g.drawLine((int)x2, (int)y2, (int)x3, (int)y3);
        g.drawLine((int)x2, (int)y2, (int)x4, (int)y4);
        
        //puts the vector labels
        g.drawString(this.name, (int)x2 + 15, (int)y2);
           
    }
}
