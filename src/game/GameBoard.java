package game;
import voinici.*;
import boiniPozicii.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard extends JFrame implements MouseListener{
    private Object selectedPiece;
    private Object[][] pieceCollection;

    public GameBoard() {
        //zeleni
        this.pieceCollection[4][0]=(new LiderGreen(4,0));
        this.pieceCollection[4][1]=(new GardGreen(4,1));
        this.pieceCollection[4][2]=(new GardGreen(4,2));
        this.pieceCollection[4][3]=(new GardGreen(4,3));
        this.pieceCollection[4][4]=(new GardGreen(4,3));

        //jalti
        this.pieceCollection[0][0]=(new LiderYellow(0,0));
        this.pieceCollection[0][1]=(new GardYellow(0,1));
        this.pieceCollection[0][2]=(new GardYellow(0,2));
        this.pieceCollection[0][3]=(new GardYellow(0,3));
        this.pieceCollection[0][4]=(new GardYellow(0,4));

        //Razmer i zatvaryane
        this.setSize(500, 500);
        this.setVisible(true);
        this.addMouseListener(this);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.getBoardDimention(e.getY());
        int col = this.getBoardDimention(e.getX());
        // proverka za vyarnost
        if(this.selectedPiece != null) {

            // TODO: smyana na koordinati
            GardYellow g1=(GardYellow) this.selectedPiece;
            g1.move(row,col);
            GardGreen g2=(GardGreen) this.selectedPiece;
            g2.move(row, col);
            LiderYellow l1=(LiderYellow) this.selectedPiece;
            l1.move(row,col);
            LiderGreen l2=(LiderGreen) this.selectedPiece;
            l2.move(row,col);

            this.selectedPiece = null;
            this.repaint();
        }

        if(this.isFull(row, col)) {
            this.selectedPiece = this.getPiece(row, col);
        }
    }

//grafiki na prilojenie
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                BoinaPoziciya tile = new BoinaPoziciya(row, col);
                tile.redTile(g); tile.blackTile(g);
                tile.grayTile(g); tile.dotTile(g);
                tile.setBackground(Color.WHITE);
                GardYellow g1=new GardYellow(row,col);
                g1.border(g);
                g1.render(g);
                GardGreen g2=new GardGreen(row,col);
                g2.border(g);
                g2.render(g);
                LiderGreen l1=new LiderGreen(row,col);
                l1.render(g);
                LiderYellow l2=new LiderYellow(row,col);
                l2.render(g);
            }
        }
    }
    private int getBoardDimention(int coordinates) {
        return coordinates / BoinaPoziciya.FIELD_SIZE;
    }

    private boolean isFull(int row, int col) {
        return this.getPiece(row, col) != null;
    }

    private Object getPiece(int row, int col) {
        return this.pieceCollection[row][col];
    }
}
