package team.squad.checkers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by williammattern on 3/6/17.
 * @author John A. Squier
 */
public class CheckersBoard {
    private Cell[][] theBoard;
    private Stack<Piece> blackPieces;
    private Stack<Piece> redPieces;

    public CheckersBoard() {
        this.theBoard = new Cell[8][8];
        this.blackPieces = new Stack<>();
        this.redPieces = new Stack<>();
        this.initializePieces();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                theBoard[i][j] = new Cell(i, j); // also colors the cells

                // fill the correct cells w pieces
                if (i <= 2) {
                    if (theBoard[i][j].getCellColor().equals(Color.BLACK)) {
                        theBoard[i][j].setHasPiece(true);
                        theBoard[i][j].setChecker(redPieces.pop());
                    }
                } else if (i >= 5) {
                    if (theBoard[i][j].getCellColor().equals(Color.BLACK)) {
                        if (theBoard[i][j].getCellColor().equals(Color.BLACK)) {
                            theBoard[i][j].setHasPiece(true);
                            theBoard[i][j].setChecker(blackPieces.pop());
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @param i the x-position of the cell (0 is the bottom row)
     * @param j the y-position of the cell (0 is the left column)
     * @return the cell at the given x,y coords.
     */
    public Cell getCell(int i, int j){
        return theBoard[i][j];
    }

    /**
     * Creates 12 black pieces and 12 red pieces and places them in their appropriate stacks.
     * Think of this like creating two stack of checkers off to the side of the board before they get
     * placed on the board itself.
     */
    public void initializePieces(){
        for (int i =0; i < 12; i++){
            Piece thisPiece = new Piece(Color.BLACK);
            blackPieces.push(thisPiece);
        }
        for (int i =0; i < 12; i++){
            Piece thisPiece = new Piece(Color.RED);
            redPieces.push(thisPiece);
        }
    }

    /**
     * Used to determine the winner, if any.
     * @return the Color of the winner's pieces or null if there is currently no winner.
     */
    public Color whoHasWon() {
        if ( redPieces.size() == 12 ) {
            return Color.BLACK;
        }
        else if ( blackPieces.size() == 12 ) {
            return Color.RED;
        }
        else {
            return null; // could later change to unchecked exception NoPlayerWonException()
        }
    }
}
