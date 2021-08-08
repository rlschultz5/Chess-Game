package org.schultz;

import java.util.Scanner;

public class ChessFrontEnd {

    private static final String WELCOME_MESSAGE = "***Welcome to Chess***";
    private static final String MENU =
            "MENU:\n" +
            "M: Display Menu\n" +
            "P: Print The Board\n" +
            "N: New Game\n" +
            "EXIT: Quits the game";
    private static final String INVALID_MOVE = "Sorry, that is an invalid move. Please try again.";
    private static final String INVALID_MOVE_CHECK = "This move puts you in check. Please try again.";
    private static final String CHECKMATE = "CHECKMATE! CONGRATULATIONS! YOU'VE WON THE GAME!";
    private static final String THANK_YOU = "Thank you for playing!";


    private static void frontEndApplication() {
        int gameCount = 0;
        ChessBoard newChessGame = new ChessBoard();
        Scanner userInput = new Scanner(System.in);
        System.out.println(MENU);
        System.out.println("Please enter your command: ");
        String command = userInput.nextLine();
        command = command.trim().toLowerCase();


        while(!command.equals("exit")) {
            //if command is M - printing menu again
            if (command.equals("m")) {
                System.out.println(MENU);
            }
            if (command.equals("p")) {
                System.out.println(newChessGame.toString());
            }
            if (command.equals("n")) {
                if(gameCount == 0){
                    gameCount++;
                    try {
                        gamePlay();
                    }catch (ChessBoard.GameOverException e){
                        System.out.println(e.getMessage());
                    }
                }
                else{
                    System.out.println("Are you sure you want to start a new game? (Y/N)");
                    command = userInput.nextLine();
                    if(command.trim().equalsIgnoreCase("y")){
                        gameCount++;
                        try {
                            gamePlay();
                        }catch (ChessBoard.GameOverException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~");
            System.out.println("Please enter your command: ");
            command = userInput.nextLine();
            command = command.trim().toLowerCase();

        }
        System.out.println(MENU);

    }


    public static void gamePlay() throws ChessBoard.GameOverException {
        ChessBoard chessGame = new ChessBoard();
        Scanner userInput = new Scanner(System.in);
        String command = "";
        String startingInput = "";
        String endingInput = "";
        //Turn 0 = WHITE, Turn 1 = BLACK
        PlayerColor currentTurn = PlayerColor.WHITE;

        System.out.println("Welcome to your chess match!");
        System.out.println("Player WHITE goes first");
        System.out.println(chessGame.toString());


        while(!command.equals("exit")) {
            if(currentTurn == PlayerColor.WHITE){
                System.out.println("Player WHITE's turn");
            }
            else{
                System.out.println("Player BLACK's turn");
            }

            System.out.println("Please enter starting point:");
            command = userInput.nextLine().trim().toLowerCase();
            if(command.equals("exit")){
                break;
            }
            startingInput = command;

            System.out.println("Please enter ending point:");
            command = userInput.nextLine().trim().toLowerCase();
            if(command.equals("exit")){
                break;
            }
            endingInput = command;
            if(areValidPoints(startingInput,endingInput)){
                ChessPoint startPoint = getChessPoint(startingInput);
                ChessPoint endPoint = getChessPoint(endingInput);
                if(chessGame.verifyMove(startPoint,endPoint, currentTurn)){
                    chessGame.makeMove(startPoint,endPoint);
                    System.out.println(chessGame.toString());
                    if(currentTurn == PlayerColor.WHITE){
                        currentTurn = PlayerColor.BLACK;
                    }
                    else{
                        currentTurn = PlayerColor.WHITE;
                    }
                }

            }
            else{
                System.out.println(chessGame.toString());
                System.out.println("Invalid points. Please try again.");
            }


        }

    }

    /**
     * Checks if user input spaces are valid
     *
     * @param start Starting space given by user
     * @param end Ending space given by user
     * @return true if they're valid spaces, otherwise false
     */
    private static boolean areValidPoints(String start, String end){
        if((start.length() != 2) || (end.length() != 2)){
            return false;
        }
        if(start.equals(end)){
            System.out.println("Start and end position can't be the same.");
            return false;
        }

        //Checks if x-coordinate is a-g
        if((start.charAt(0) < 'a') || (start.charAt(0) > 'h') || (end.charAt(0) < 'a') || (end.charAt(0) > 'h')){
            return false;
        }
        //Checks if y-coordinate is between 1-8
        if((start.charAt(1) < '0') || (start.charAt(1) > '8') || (end.charAt(1) < '0') || (end.charAt(1) > '8')){
            return false;
        }




//        boolean startPoint = false;
//        boolean endPoint = false;
//        for (int i = 0; i < ChessBoard.boardLetters.length; i++) {
//            if(start.charAt(0) == ChessBoard.boardLetters[i]){
//                startPoint = true;
//            }
//            if(end.charAt(0) == ChessBoard.boardLetters[i]){
//                endPoint = true;
//            }
//        }
//        if(!startPoint || !endPoint){
//            return false;
//        }
//
//        if((start.charAt(1) < 0) || (start.charAt(1) > ChessBoard.BOARD_LENGTH) ||
//                (end.charAt(1) < 0) || (end.charAt(1) > ChessBoard.BOARD_LENGTH)){
//            return false;
//        }

        return true;
    }

    private static ChessPoint getChessPoint(String userInput){
        int x = Math.abs(Character.getNumericValue(userInput.charAt(1))-8);
        int y = userInput.charAt(0) - 97;

        return new ChessPoint(x,y);
    }


    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        frontEndApplication();
        System.out.println(THANK_YOU);

//        char a = 'h';
//        System.out.println(a-97);


//        ChessBoard chessGame = new ChessBoard();
//        System.out.println(chessGame.chessBoard[1][0]);

    }
}
