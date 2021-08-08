package org.schultz.piece;

import org.schultz.ChessBoard;
import org.schultz.ChessPoint;
import org.schultz.PlayerColor;

public class Bishop extends ChessPiece {

    public Bishop(PlayerColor playerColor) {
        super(playerColor);
    }

    @Override
    public boolean validMove(ChessPoint start, ChessPoint end, ChessBoard chessBoard) {
        int xDifference = Math.abs(start.getX()-end.getX());
        int yDifference = Math.abs(start.getY()- end.getY());
        boolean diagonal = xDifference == yDifference;
        boolean endSpotEmpty = chessBoard.isPointEmpty(end.getX(), end.getY());
        boolean movingUpLeft = ((start.getX() > end.getX()) && (start.getY() > end.getY()));
        boolean movingUpRight = (start.getX() > end.getX()) && (start.getY() < end.getY());
        boolean movingDownLeft = (start.getX() < end.getX()) && (start.getY() > end.getY());
        boolean movingDownRight = (start.getX() < end.getX()) && (start.getY() < end.getY());
        boolean endIsBlack = false;
        ChessPiece endPiece;

        if(!endSpotEmpty) {
            endPiece = chessBoard.currentPiece(end.getX(), end.getY());
            endIsBlack = endPiece.playerColor == PlayerColor.BLACK;
        }

        if(diagonal){
            if(movingUpLeft){
                for (int i = 1; i < xDifference; i++) {
                    if (!chessBoard.isPointEmpty(start.getX() - i, start.getY() - i)) {
                        System.out.println("Invalid move.");
                        return false;
                    }
                }
            }
            if(movingUpRight){
                for (int i = 1; i < xDifference; i++) {
                    if (!chessBoard.isPointEmpty(start.getX() - i, start.getY() + i)) {
                        System.out.println("Invalid move.");
                        return false;
                    }
                }
            }
            if(movingDownLeft){
                for (int i = 1; i < xDifference; i++) {
                    if (!chessBoard.isPointEmpty(start.getX() + i, start.getY() - i)) {
                        System.out.println("Invalid move.");
                        return false;
                    }
                }
            }
            if(movingDownRight){
                for (int i = 1; i < xDifference; i++) {
                    if (!chessBoard.isPointEmpty(start.getX() + i, start.getY() + i)) {
                        System.out.println("Invalid move.");
                        return false;
                    }
                }
            }
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
