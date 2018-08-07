package com.chrisleung.other.solutions;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    char[] board;
    static final char COMPUTER_TOKEN = 'O';
    static final char PLAYER_TOKEN = 'X';

    static final char EMPTY_TOKEN = '-';
    static final int BOARD_LENGTH = 3;
    static final int BOARD_AREA = BOARD_LENGTH*BOARD_LENGTH;

    TicTacToe() {
        board = new char[BOARD_AREA];
        Arrays.fill(board, EMPTY_TOKEN);
    }

    void printBoard() {
        for(int i=0; i<BOARD_LENGTH; i++) {
            for(int j=0; j<BOARD_LENGTH; j++) {
                System.out.print(board[j+i*BOARD_LENGTH]);
                if(j < BOARD_LENGTH-1)
                    System.out.print('|');
            }
            System.out.print('\n');
        }
    }

    void addToken(int spot, char token) {
        board[spot] = token;
    }

    boolean boardIsFull() {
        for(int i=0; i<BOARD_AREA; i++) {
            if(board[i] == EMPTY_TOKEN) 
                return false;
        }
        return true;
    }

    void computerMakeMove() throws Exception {
        boolean madeMove = false;
        for(int i=0; i<BOARD_AREA; i++) {
            if(board[i] == EMPTY_TOKEN) { 
                addToken(i,COMPUTER_TOKEN);
                madeMove = true;
                break;
            }
        }
        if(!madeMove) {
            throw new Exception("No empty spaces on board");
        }
    }

    boolean humanMakeMove(int row, int col) {
        int spot = col + (3*row);
        if(board[spot] != EMPTY_TOKEN) 
            return false;
        addToken(spot,PLAYER_TOKEN);
        return true;
    }

    void reset() {
        Arrays.fill(board, EMPTY_TOKEN);
    }

    void play() throws Exception {
        printBoard();
        boolean playerTurn = true;
        while(!boardIsFull()) {
            if(playerTurn) {                
                while(true) {
                    System.out.print("Make a move (enter 0-based row and column, separated by comma): ");
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    if(input == null || input.length() == 0) continue;
                    String[] rowCol = input.split(",");
                    if(rowCol.length != 2) continue;
                    try {
                        int row = Integer.parseInt(rowCol[0]);
                        int col = Integer.parseInt(rowCol[1]);
                        if(humanMakeMove(row,col)) {
                            playerTurn = !playerTurn;
                            break;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            } else {
                computerMakeMove();
                playerTurn = !playerTurn;
            }
            printBoard();
        }

    }

    static public void main(String[] args) throws Exception {
        TicTacToe game = new TicTacToe();
        /*
        game.printBoard();
        game.addToken(1, 'X');
        game.printBoard();
        System.out.printf("Is board full? %b\n",game.boardIsFull());
        while(!game.boardIsFull()) {
            game.computerMakeMove();
            game.printBoard();
        }
        System.out.println("Board is full.");
        game.computerMakeMove();
        game.reset();
        */
        game.play();
    }
}
