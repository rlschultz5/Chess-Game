package org.schultz;

import org.schultz.piece.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.schultz.PlayerColor.BLACK;
import static org.schultz.PlayerColor.WHITE;

public class ChessBoard {
    protected static final int BOARD_LENGTH = 8;
    protected static final char[] boardLetters = new char[]{'a','b','c','d','e','f','g','h'};
    private List<ChessPiece> killed = new ArrayList<>();
    private King kingWHITE = new King(WHITE);
    private King kingBLACK = new King(BLACK);

    private ChessPiece[][] chessBoard = new ChessPiece[][]{
            {new Rook(WHITE),new Knight(WHITE),new Bishop(WHITE),kingWHITE,new Queen(WHITE),new Bishop(WHITE),
                    new Knight(WHITE),new Rook(WHITE)},
            {new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),new Pawn(WHITE),
                    new Pawn(WHITE),new Pawn(WHITE)},
            {null,null,null,null,null,null,null,null},
            {null,null,null,null,null,null,null,null},
            {null,null,null,null,null,null,null,null},
            {null,null,null,null,null,null,null,null},
            {new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),new Pawn(BLACK),
                    new Pawn(BLACK),new Pawn(BLACK)},
            {new Rook(BLACK),new Knight(BLACK),new Bishop(BLACK),new Queen(BLACK),kingBLACK,new Bishop(BLACK),
                    new Knight(BLACK),new Rook(BLACK)},
            };

    public String toString(){
        String currentChessBoard = "";
        char xPosition = 'A';
        int yPosition = 8;

        System.out.println("  A\t\t\t\t\t  B\t\t\t\t\t  C\t\t\t\t\t  D\t\t\t\t\t  E\t\t\t\t\t" +
                "  F\t\t\t\t\t  G\t\t\t\t\t  H");
        for (int i = 0; i < chessBoard.length; i++) {
            currentChessBoard += 8-i;
            for (int j = 0; j < chessBoard.length; j++) {
                if(chessBoard[i][j] == null){
                    currentChessBoard += " (open)\t\t\t\t";
                }
                else {
                    currentChessBoard += " " + chessBoard[i][j] + "\t\t";
                }
            }
            currentChessBoard += "\n";
        }

        return currentChessBoard;
    }

    public int getLengthOfBoard(){
        return chessBoard.length;
    }

    /**
     * Checks if point is empty
     *
     * @param x X value of point
     * @param y Y value of point
     * @return true if point is empty, otherwise false
     */
    public boolean isPointEmpty(int x, int y){
        if(chessBoard[x][y] != null){
            return false;
        }
        return true;
    }

    /**
     * Returns the chess piece of a spot on the board
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @return ChessPiece that is on the spot on the board
     */
    public ChessPiece currentPiece(int x, int y){
        return chessBoard[x][y];
    }

    /**
     * Checks if start and end points are valid
     *
     * @param start Starting point
     * @param end Ending point
     * @return true if points are on the board, otherwise false
     */
    public boolean areValidPoints(ChessPoint start, ChessPoint end){
        //If start or end point is off the board, return false
        if(start.getX() < 0 || start.getX() > BOARD_LENGTH || end.getX() < 0 || end.getX() > BOARD_LENGTH ||
                start.getY() < 0 || start.getY() > BOARD_LENGTH || end.getY() < 0 || end.getY() > BOARD_LENGTH){
            return false;
        }
        return true;
    }

    /**
     * Verifies the move the user is trying to make is legal
     *
     * @param startPoint ChessPoint moving from
     * @param endPoint ChessPoint moving to
     * @throws IllegalArgumentException when the player doesn't have a chess piece in start spot,
     * end spot is already being used by same player, same player's other piece is in the way
     * @return true if move can be made, otherwise false
     */
    public boolean verifyMove(ChessPoint startPoint, ChessPoint endPoint, PlayerColor player){
        //Checks if player has a piece on start spot
        if(this.chessBoard[startPoint.getX()][startPoint.getY()] == null){
            System.out.println("You do not have a chess piece on this starting space.");
            return false;
        }
        //Checks if player is trying to move their own piece
        if(chessBoard[startPoint.getX()][startPoint.getY()].getPlayerColor() != player){
            System.out.println("That is not your piece to move.");
            return false;
        }

        //Checks if player already has a piece on the end spot
        if((chessBoard[endPoint.getX()][endPoint.getY()] != null) &&
                (chessBoard[endPoint.getX()][endPoint.getY()].getPlayerColor() == player)){
            System.out.println("You already occupy that end space.");
            return false;
        }
        return this.chessBoard[startPoint.getX()][startPoint.getY()].validMove(startPoint,endPoint,this);
    }

    /**
     * Executes user's move
     *
     * @param startPoint ChessPoint moving from
     * @param endPoint ChessPoint moving to
     */
    public void makeMove(ChessPoint startPoint, ChessPoint endPoint) throws GameOverException {
        if(!(this.chessBoard[endPoint.getX()][endPoint.getY()] == null)){
            killed.add(this.chessBoard[endPoint.getX()][endPoint.getY()]);
        }
        this.chessBoard[endPoint.getX()][endPoint.getY()] = this.chessBoard[startPoint.getX()][startPoint.getY()];
        this.chessBoard[startPoint.getX()][startPoint.getY()] = null;
        if(killed.contains(kingBLACK)){
            throw new GameOverException("Congratulations player WHITE! You have won the chess game!"){};
        }
        if(killed.contains(kingWHITE)){
            throw new GameOverException("Congratulations player BLACK! You have won the chess game!"){};
        }
    }

    public static class GameOverException extends Throwable {
        public GameOverException(String message) {
            super(message);
        }
    }
}
