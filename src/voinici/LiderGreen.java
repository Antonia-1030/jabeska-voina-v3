package voinici;
import java.awt.*;

public class LiderGreen {
    private int row;
    private int col;

    public LiderGreen(int row, int col){
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
                colCoeficient == 0;
    }
    //grafichno predstavyane
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(20, 430, 50, 50);
    }
}
