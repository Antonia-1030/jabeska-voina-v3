package voinici;
import java.awt.*;

public class GardYellow {
    private int row;
    private int col;

    public GardYellow(int row, int col){
        this.row= row;
        this.col= col;
    }
    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }
    //validnost na hod
    public boolean isMoveValid(int moveRow, int moveCol) {

        int rowCoeficient = Math.abs(moveRow - this.row);
        int colCoeficient = moveCol - this.col;

        return  rowCoeficient == 0 &&
                colCoeficient == 0;
    }
    //grafichno predstavyane
    public void render(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillOval(20, 40, 50, 50);
        g.fillOval(120, 40, 50, 50);
        g.fillOval(220, 40, 50, 50);
        g.fillOval(320, 40, 50, 50);
    }
    //border na figurite
    public void border(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(18, 38, 55, 55);
        g.fillOval(118, 38, 55, 55);
        g.fillOval(218, 38, 55, 55);
        g.fillOval(318, 38, 55, 55);
    }
}
