package voinici;
import java.awt.*;

public class LiderGreen extends Piece{
    public LiderGreen(int row, int col, Color color){
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
