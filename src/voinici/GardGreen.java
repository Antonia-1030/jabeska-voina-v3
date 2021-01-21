package voinici;
import java.awt.*;

public class GardGreen {
    private int row;
    private int col;

    public GardGreen(int row, int col){
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

        return  rowCoeficient == 4 &&
                colCoeficient == 1;
    }
    //grafichno predstavyane
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(120, 430, 50, 50);
        g.fillOval(220,430,50,50);
        g.fillOval(320,430,50,50);
        g.fillOval(420,430,50,50);
    }
    //border na figurite
    public void border(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillOval(118, 428, 55, 55);
        g.fillOval(218,428,55,55);
        g.fillOval(318,428,55,55);
        g.fillOval(418,428,55,55);
    }
}
