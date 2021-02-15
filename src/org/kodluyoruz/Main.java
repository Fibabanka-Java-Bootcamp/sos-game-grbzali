package org.kodluyoruz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome the SOS Game!");
        System.out.println("Board size you want to play?");
        int boardSize = 0;
        do {
            System.out.println("Please enter a between 3-7 number for board size!");
            while (!scan.hasNextInt()) {
                System.out.println("a letter???...Please enter a between 3-7 NUMBER!!!");
                scan.next();
            }
            boardSize = scan.nextInt();
        } while (boardSize < 3 || boardSize > 7);
        Sos game = new Sos(boardSize);
        game.createBoard();
        game.showBoard();
        int rowInput = 0;
        int colInput = 0;
        while (!game.isBoardFull()) {
            if (game.getCurrentPlayer().equals("human")) {
                System.out.println("Your turn...");
                do {
                    System.out.println("Please enter a empty cell for mark!");
                    do {
                        System.out.println("Please enter a between 1-" + boardSize + " row number!");
                        while (!scan.hasNextInt()) {
                            System.out.println("a letter???...Please enter a between 1-" + boardSize + " row NUMBER!!!");
                            scan.next();
                        }
                        rowInput = scan.nextInt() - 1;

                    } while (rowInput + 1 <= 0 || rowInput + 1 > boardSize);

                    do {
                        System.out.println("Please enter a between 1-" + boardSize + " column number!");
                        while (!scan.hasNextInt()) {
                            System.out.println("a letter???...Please enter a between 1-" + boardSize + " column NUMBER!!!");
                            scan.next();
                        }
                        colInput = scan.nextInt() - 1;
                    } while (colInput + 1 <= 0 || colInput + 1 > boardSize);

                }while (!game.markBoard(rowInput,colInput));
                game.markBoard(rowInput, colInput);

                if(game.checkWin()) System.out.println("SCORE! ONCE AGAIN ");
                else game.changePlayerAndMark();
            } else {
                game.markBoardRandom();
                if(game.checkWin()) System.out.println("SCORE!");
                else game.changePlayerAndMark();
            }
            game.checkWin();
            game.showBoard();
            System.out.println();
        }
        game.endGame();
    }
}

