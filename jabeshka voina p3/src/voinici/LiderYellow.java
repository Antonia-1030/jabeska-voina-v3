package voinici;
import java.awt.*;

public class LiderYellow extends Piece{
    public LiderYellow(int row, int col, Color color){
        this.row    = row;
        this.col    = col;
        this.color = color;
    }

    public boolean isMoveValid(int moveRow, int moveCol) {

        int rowCoefficient = Math.abs(moveRow - this.row);
        int colCoefficient = moveCol - this.col;

        return  rowCoefficient == 4 ||
                colCoefficient == 4;
    }

    public boolean isAttackValid(int attackRow, int attackCol) {
        return false;
    }
}
