package voinici;
import java.awt.*;

public class LiderYellow {
    private int row;
    private int col;

    public LiderYellow(int row, int col){
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
                colCoeficient == 4;
    }
    //grafichno predstavyane
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(420,40,50,50);
    }
}
