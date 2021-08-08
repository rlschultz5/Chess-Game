package org.schultz.piece;

import org.schultz.ChessBoard;
import org.schultz.ChessPoint;
import org.schultz.PlayerColor;

public class Knight extends ChessPiece {

    public Knight(PlayerColor playerColor) {
        super(playerColor);
    }

    @Override
    public boolean validMove(ChessPoint start, ChessPoint end, ChessBoard chessBoard) {
        int xDifference = Math.abs(start.getX()-end.getX());
        int yDifference = Math.abs(start.getY()- end.getY());
        boolean knightMove = ((xDifference == 2) && (yDifference == 1)) || ((xDifference == 1) && (yDifference == 2));
        boolean endSpotEmpty = chessBoard.isPointEmpty(end.getX(), end.getY());
        boolean endIsBlack = false;
        ChessPiece endPiece;

        if(!endSpotEmpty) {
            endPiece = chessBoard.currentPiece(end.getX(), end.getY());
            endIsBlack = endPiece.playerColor == PlayerColor.BLACK;
        }

        if(knightMove){
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

        System.out.println("Invalid move.");
        return false;
    }


}
