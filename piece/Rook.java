package org.schultz.piece;

import org.schultz.ChessBoard;
import org.schultz.ChessPoint;
import org.schultz.PlayerColor;

public class Rook extends ChessPiece {

    public Rook(PlayerColor playerColor) {
        super(playerColor);
    }

    @Override
    public boolean validMove(ChessPoint start, ChessPoint end, ChessBoard chessBoard) {
        int xDifference = Math.abs(start.getX()-end.getX());
        int yDifference = Math.abs(start.getY()- end.getY());
        boolean endSpotEmpty = chessBoard.isPointEmpty(end.getX(), end.getY());
        boolean movingUp = start.getY() > end.getY();
        boolean movingLeft = start.getX() > end.getX();
        ChessPiece endPiece;
        boolean endIsBlack = false;

        if(!endSpotEmpty) {
            endPiece = chessBoard.currentPiece(end.getX(), end.getY());
            endIsBlack = endPiece.playerColor == PlayerColor.BLACK;
        }

        //If moving vertical
        if(yDifference == 0){
            if(movingLeft){
                for (int i = 1; i < xDifference; i++) {
                    if (!chessBoard.isPointEmpty(start.getX() - i, start.getY())) {
                        System.out.println("Invalid move.");
                        return false;
                    }
                }
            }
            else{
                for (int i = 1; i < xDifference; i++) {
                    if (!chessBoard.isPointEmpty(start.getX() + i, start.getY())) {
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
        //If moving horizontal
        if(xDifference == 0){
            if(movingUp){
                for (int i = 1; i < yDifference; i++) {
                    if (!chessBoard.isPointEmpty(start.getX(), start.getY() - i)) {
                        System.out.println("Invalid move.");
                        return false;
                    }
                }
            }
            else{
                for (int i = 1; i < yDifference; i++) {
                    if (!chessBoard.isPointEmpty(start.getX(), start.getY() + i)) {
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
