package voinici;

import java.awt.*;

public class Turtle {
    int row;
    int col;
    //try random position
    int randPosition=(int)(Math.random() * 4+1);

    public Turtle(int row,int col){
        this.row=row;
        this.col=col;
    }

    public void render(Graphics g){
        g.setColor(Color.RED);

        if (randPosition==1){
            g.drawOval(20,230,50,50);
            g.drawOval(420,230,50,50);
        }
        if (randPosition==2){
            g.drawOval(120,230,50,50);
            g.drawOval(320,230,50,50);
        }
        if (randPosition==3){
            g.drawOval(20,230,50,50);
            g.drawOval(120,230,50,50);
        }
        else
            g.drawOval(320,230,50,50);
        g.drawOval(420,230,50,50);
    }
}
