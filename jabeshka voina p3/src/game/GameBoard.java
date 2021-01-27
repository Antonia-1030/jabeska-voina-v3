package game;

import voinici.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard extends JFrame implements MouseListener {
    private Object selectedPiece;
    private Object[][] pieceCollection=new Object[5][5];
    public static boolean isGameOver=false;

    public GameBoard() {
        //green
        this.pieceCollection[4][0]=(new LiderGreen(4,0,Color.GREEN));
        this.pieceCollection[4][1]=(new GardGreen(4,1,Color.GREEN));
        this.pieceCollection[4][2]=(new GardGreen(4,2,Color.GREEN));
        this.pieceCollection[4][3]=(new GardGreen(4,3,Color.GREEN));
        this.pieceCollection[4][4]=(new GardGreen(4,3,Color.GREEN));

        //yellow
        this.pieceCollection[0][0]=(new LiderYellow(0,0,Color.YELLOW));
        this.pieceCollection[0][1]=(new GardYellow(0,1,Color.YELLOW));
        this.pieceCollection[0][2]=(new GardYellow(0,2,Color.YELLOW));
        this.pieceCollection[0][3]=(new GardYellow(0,3,Color.YELLOW));
        this.pieceCollection[0][4]=(new GardYellow(0,4,Color.YELLOW));

        //size and close
        this.setSize(500, 500);
        this.setVisible(true);
        this.addMouseListener(this);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.getBoardDimension(e.getY());
        int col = this.getBoardDimension(e.getX());

        // check if correct
        if (this.selectedPiece != null) {

            // TODO: change position
            GardYellow g1 = (GardYellow) this.selectedPiece;
            g1.move(row, col);
            GardGreen g2 = (GardGreen) this.selectedPiece;
            g2.move(row, col);
            LiderYellow l1 = (LiderYellow) this.selectedPiece;
            l1.move(row, col);
            LiderGreen l2 = (LiderGreen) this.selectedPiece;
            l2.move(row, col);

            this.selectedPiece = null;
            this.repaint();
        }

        if (this.isFull(row, col)) {
            this.selectedPiece = this.getPiece(row, col);
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                GameTile tile = new GameTile(row, col);
                tile.redTile(g);
                tile.blackTile(g);
                tile.grayTile(g);
                tile.dotTile(g);
                tile.setBackground(Color.WHITE);
                Turtle t=new Turtle(row,col);
                t.render(g);
                this.renderGamePiece(g, row, col);
            }
        }
    }

    private int getBoardDimension(int coordinates) {
        return coordinates / GameTile.FIELD_SIZE;
    }

    private boolean isFull(int row, int col) {
        return this.getPiece(row, col) != null;
    }

    private Object getPiece(int row, int col) {
        return this.pieceCollection[row][col];
    }

    private void renderGamePiece(Graphics g, int row, int col) {

        if(this.isFull(row, col)) {

            Piece p = (Piece) this.getPiece(row, col);
            p.render(g);
        }
    }
}
