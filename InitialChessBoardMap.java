//package org.schultz;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class InitialChessBoardMap {
//    public Map<String, ChessPiece> chessBoard = new LinkedHashMap<String, ChessPiece>();
//
//    public InitialChessBoardMap() {
//        chessBoard.put("A8", new ChessPiece(PieceType.ROOK,PlayerColor.WHITE));
//        chessBoard.put("B8", new ChessPiece(PieceType.KNIGHT,PlayerColor.WHITE));
//        chessBoard.put("C8", new ChessPiece(PieceType.BISHOP,PlayerColor.WHITE));
//        chessBoard.put("D8", new ChessPiece(PieceType.QUEEN,PlayerColor.WHITE));
//        chessBoard.put("E8", new ChessPiece(PieceType.KING,PlayerColor.WHITE));
//        chessBoard.put("F8", new ChessPiece(PieceType.BISHOP,PlayerColor.WHITE));
//        chessBoard.put("G8", new ChessPiece(PieceType.KNIGHT,PlayerColor.WHITE));
//        chessBoard.put("H8", new ChessPiece(PieceType.ROOK,PlayerColor.WHITE));
//
//        chessBoard.put("A7", new ChessPiece(PieceType.PAWN,PlayerColor.WHITE));
//        chessBoard.put("B7", new ChessPiece(PieceType.PAWN,PlayerColor.WHITE));
//        chessBoard.put("C7", new ChessPiece(PieceType.PAWN,PlayerColor.WHITE));
//        chessBoard.put("D7", new ChessPiece(PieceType.PAWN,PlayerColor.WHITE));
//        chessBoard.put("E7", new ChessPiece(PieceType.PAWN,PlayerColor.WHITE));
//        chessBoard.put("F7", new ChessPiece(PieceType.PAWN,PlayerColor.WHITE));
//        chessBoard.put("G7", new ChessPiece(PieceType.PAWN,PlayerColor.WHITE));
//        chessBoard.put("H7", new ChessPiece(PieceType.PAWN,PlayerColor.WHITE));
//
//        String[] alpha = new String[]{"A","B","C","D","E","F","G","H"};
//        for(int i = 6; i > 2; i--){
//            for(int j = 0; j < 8; j++){
//                chessBoard.put(alpha[j] + i, null);
//            }
//        }
//
//        chessBoard.put("A2", new ChessPiece(PieceType.PAWN,PlayerColor.BLACK));
//        chessBoard.put("B2", new ChessPiece(PieceType.PAWN,PlayerColor.BLACK));
//        chessBoard.put("C2", new ChessPiece(PieceType.PAWN,PlayerColor.BLACK));
//        chessBoard.put("D2", new ChessPiece(PieceType.PAWN,PlayerColor.BLACK));
//        chessBoard.put("E2", new ChessPiece(PieceType.PAWN,PlayerColor.BLACK));
//        chessBoard.put("F2", new ChessPiece(PieceType.PAWN,PlayerColor.BLACK));
//        chessBoard.put("G2", new ChessPiece(PieceType.PAWN,PlayerColor.BLACK));
//        chessBoard.put("H2", new ChessPiece(PieceType.PAWN,PlayerColor.BLACK));
//
//        chessBoard.put("A1", new ChessPiece(PieceType.ROOK,PlayerColor.BLACK));
//        chessBoard.put("B1", new ChessPiece(PieceType.KNIGHT,PlayerColor.BLACK));
//        chessBoard.put("C1", new ChessPiece(PieceType.BISHOP,PlayerColor.BLACK));
//        chessBoard.put("D1", new ChessPiece(PieceType.KING,PlayerColor.BLACK));
//        chessBoard.put("E1", new ChessPiece(PieceType.QUEEN,PlayerColor.BLACK));
//        chessBoard.put("F1", new ChessPiece(PieceType.BISHOP,PlayerColor.BLACK));
//        chessBoard.put("G1", new ChessPiece(PieceType.KNIGHT,PlayerColor.BLACK));
//        chessBoard.put("H1", new ChessPiece(PieceType.ROOK,PlayerColor.BLACK));
//    }
//
//    public String printBoardPositions(){
//        String listOfPositions = "";
//
//        listOfPositions += "--------Current Chess Board--------\n";
//        for (String currentPosition: chessBoard.keySet()){
//            String position = currentPosition;
//            if(chessBoard.get(position) == null){
//                listOfPositions += "POS: " + position + " EMPTY\n";
//            }
//            else {
//                ChessPiece chessPiece = chessBoard.get(position);
//                listOfPositions += "POS: " + position + "  Type: " + chessPiece.getPieceType() + "  Color: " + chessPiece.getPlayerColor() + "\n";
//            }
//        }
//        listOfPositions += "---------------------------------";
//        return listOfPositions;
//    }
//}
