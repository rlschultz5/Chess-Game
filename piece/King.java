package org.schultz.piece;

import org.schultz.ChessBoard;
import org.schultz.ChessPoint;
import org.schultz.PlayerColor;

/**
 * This class represents the King chess piece and validates a move by start and end ChessPoints
 */
public class King extends ChessPiece {

    /**
     * This constructor creates a King ChessPiece
     *
     * @param playerColor color of ChessPiece
     */
    public King(PlayerColor playerColor) {
        super(playerColor);
    }

    /**
     * Determines whether the King can move from the start spot to the end spot
     *
     * @param start starting ChessPoint
     * @param end ending ChessPoint
     * @param chessBoard current ChessBoard
     * @return true is move is legal, otherwise false
     */
    @Override
    public boolean validMove(ChessPoint start, ChessPoint end, ChessBoard chessBoard) {
        int xDifference = Math.abs(start.getX()-end.getX());
        int yDifference = Math.abs(start.getY()- end.getY());
        boolean endSpotEmpty = chessBoard.isPointEmpty(end.getX(), end.getY());
        ChessPiece endPiece;
        boolean endIsBlack = false;

        if(!endSpotEmpty) {
            endPiece = chessBoard.currentPiece(end.getX(), end.getY());
            endIsBlack = endPiece.playerColor == PlayerColor.BLACK;
        }

        //Checks if move is only 1 spot away
        if((xDifference <= 1) && (yDifference <= 1)){
            if(endSpotEmpty){
                return true;
            }
            //WHITE turn
            if((playerColor == PlayerColor.WHITE) && endIsBlack){
                return true;
            }
            //BLACK turn
            if((playerColor == PlayerColor.BLACK) && !endIsBlack){
                return true;
            }
        }
        return false;
    }

}
