package org.schultz.piece;

import org.schultz.ChessBoard;
import org.schultz.ChessPoint;
import org.schultz.PlayerColor;


public class Pawn extends ChessPiece {
    private boolean usedOnce = false;

    public Pawn(PlayerColor playerColor) {
        super(playerColor);
    }

    @Override
    public boolean validMove(ChessPoint start, ChessPoint end, ChessBoard chessBoard) {
        int xDifference = Math.abs(start.getX() - end.getX());
        int yDifference = Math.abs(start.getY() - end.getY());
        boolean endSpotEmpty = chessBoard.isPointEmpty(end.getX(), end.getY());
        ChessPiece endPiece = null;
        boolean endIsBlack = false;

        if(!endSpotEmpty) {
            endPiece = chessBoard.currentPiece(end.getX(), end.getY());
            endIsBlack = endPiece.playerColor == PlayerColor.BLACK;
        }

        //WHITE turn
        if(playerColor == PlayerColor.WHITE) {
            if ((start.getX() + 1 == end.getX()) && (yDifference == 0) && (endSpotEmpty)) {
                usedOnce = true;
                return true;
            }
            if ((start.getX() + 2 == end.getX()) && (yDifference == 0) && (usedOnce == false) && (endSpotEmpty)
                    && chessBoard.isPointEmpty(start.getX() + 1, start.getY())) {
                usedOnce = true;
                return true;
            }
            if ((start.getX() + 1 == end.getX()) && (start.getY() + 1 == end.getY()) &&
                    (!endSpotEmpty && endIsBlack) ) {
                usedOnce = true;
                return true;
            }
            if ((start.getX() + 1 == end.getX()) && (start.getY() - 1 == end.getY()) &&
                    (!endSpotEmpty && endIsBlack)) {
                usedOnce = true;
                return true;
            }
        }
        //BLACK turn
        if(playerColor == PlayerColor.BLACK) {
            if ((start.getX() - 1 == end.getX()) && (yDifference == 0) && (endSpotEmpty)) {
                usedOnce = true;
                return true;
            }
            if ((start.getX() - 2 == end.getX()) && (yDifference == 0) && (usedOnce == false) && (endSpotEmpty)
                    && chessBoard.isPointEmpty(start.getX() - 1, start.getY())) {
                usedOnce = true;
                return true;
            }
            if ((start.getX() - 1 == end.getX()) && (start.getY() + 1 == end.getY()) &&
                    (!endSpotEmpty  && !endIsBlack)) {
                usedOnce = true;
                return true;
            }
            if ((start.getX() - 1 == end.getX()) && (start.getY() - 1 == end.getY())
                    && (!endSpotEmpty && !endIsBlack)) {
                usedOnce = true;
                return true;
            }
        }
        System.out.println(chessBoard.toString());
        System.out.println("Pawns can move:\n" +
                "  2 spaces forward on first move\n" +
                "  1 space forward after first move\n" +
                "  or diagonally forward 1 space to kill an opponent\n");
        return false;

//        //Can not kill moving forward
//        if((start.getY() == end.getY()) && !chessBoard.isPointEmpty(end.getX(), end.getY())){
//            System.out.println("Can not kill moving forward.");
//            return false;
//        }
//        //A pawn can move 2 spaces on their first move
//        if((usedOnce == false) && (Math.abs(start.getX() - end.getX()) > 2)){
//            System.out.println("Pawns can only move 2 spaces on their first move.");
//            return false;
//        }
//        //Pawns can only move 1 space after their first move
//        if((usedOnce == true) && (Math.abs(start.getX() - end.getX()) > 1)){
//            System.out.println("Pawns can only move more than 1 space on their first move.");
//            return false;
//        }
//        //Pawns can not move sideways
//        if((Math.abs(start.getY() - end.getY()) > 1) || (start.getX() == end.getX()) ||
//                ((Math.abs(start.getY() - end.getY()) == 1) && (Math.abs(start.getY() - end.getY()) > 1))){
//            System.out.println("Pawns can only move forward, unless killing an opponent.");
//            return false;
//        }
//        //WHITE pawn
//        if(chessBoard.currentPiece(start.getX(),start.getY()).getPlayerColor() == PlayerColor.WHITE){
//            ////Checks if moving backward
//            if(start.getX() >= end.getX()){
//                System.out.println("Pawns can not move backwards.");
//                return false;
//            }
//            if((start.getX() + 2 == end.getX())){
//                if(!chessBoard.isPointEmpty(end.getX(), end.getY()) &&
//                        !chessBoard.isPointEmpty(end.getX() - 1, end.getY())){
//                    System.out.println("That route is being blocked.");
//                    return false;
//                }
//            }
//            if ((start.getX() + 1 == end.getX()) &&
//                    ((start.getY() + 1 == end.getY()) || (start.getY() - 1 == end.getY()))) {
//                if(chessBoard.isPointEmpty(end.getX(), end.getY())) {
//                    System.out.println("Pawns can only move forward, unless killing an opponent.");
//                    return false;
//                }
//            }
//
//        }
//        //BLACK pawn
//        if(chessBoard.currentPiece(start.getX(),start.getY()).getPlayerColor() == PlayerColor.BLACK){
//            //Checks if moving backward
//            if(start.getX() <= end.getX()){
//                System.out.println("Pawns can not move backwards.");
//                return false;
//            }
//            if((start.getX() - 2 == end.getX())){
//                if(!chessBoard.isPointEmpty(end.getX(), end.getY()) &&
//                        !chessBoard.isPointEmpty(end.getX() + 1, end.getY())){
//                    System.out.println("That route is being blocked.");
//                    return false;
//                }
//            }
//            if ((start.getX() - 1 == end.getX()) &&
//                    ((start.getY() + 1 == end.getY()) || (start.getY() - 1 == end.getY()))) {
//                if(chessBoard.isPointEmpty(end.getX(), end.getY())){
//                    System.out.println("Pawns can only move forward, unless killing an opponent.");
//                    return false;
//                }
//            }
//        }
//        usedOnce = true;
//        return true;
    }

}
