import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    private static Player playerOne;
    private static Player playerTwo;
    static char[][] board;
    static boolean gameEnded = false;

    public static void main(String[] args) {
        out.println("Hello! Welcome to my Tic Tac Toe game!");
        Scanner playerName = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Please enter Player One's name: ");
        playerOne = new Player(playerName.nextLine(), 'X'); // Read user input
        out.println("Hello, " + playerOne.name() + "! You'll be playing X!"); // Output user input
        out.print("Please enter Player Two's name: ");
        playerTwo = new Player(playerName.nextLine(), 'O');
        out.println("Hello, " + playerTwo.name() + "! You'll be playing O!");


        boardSetup();
        while (!gameEnded) {
            updateBoard(playerOne);
            if (gameEnded) break;
            updateBoard(playerTwo);
            if (gameEnded) break;
        }
        out.println("Goodbye! Thank you for playing my Tic Tac Toe game!");
    }

    public static void boardSetup() {
        board = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < 2)
                System.out.println("---------");
        }
    }

    public static void displayBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < 2)
                System.out.println("---------");
        }
    }

    public static int userInput() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Please enter a cell: ");
        return myObj.nextInt();
    }

    public static void updateBoard(Player player) {
        out.println(player.name() + "'s Turn!");
        int playerInput = userInput();
        switch (playerInput) {
            case 1:
                if (isValid(playerInput))
                    board[0][0] = player.letter();
                else
                    out.println("Please enter an available cell.");
                break;
            case 2:
                if (isValid(playerInput))
                    board[0][1] = player.letter();
                else
                    out.println("Please enter an available cell.");
                break;
            case 3:
                if (isValid(playerInput))
                    board[0][2] = player.letter();
                else
                    out.println("Please enter an available cell.");
                break;
            case 4:
                if (isValid(playerInput))
                    board[1][0] = player.letter();
                else
                    out.println("Please enter an available cell.");
                break;
            case 5:
                if (isValid(playerInput))
                    board[1][1] = player.letter();
                else
                    out.println("Please enter an available cell.");
                break;
            case 6:
                if (isValid(playerInput))
                    board[1][2] = player.letter();
                else
                    out.println("Please enter an available cell.");
                break;
            case 7:
                if (isValid(playerInput))
                    board[2][0] = player.letter();
                else
                    out.println("Please enter an available cell.");
                break;
            case 8:
                if (isValid(playerInput))
                    board[2][1] = player.letter();
                else
                    out.println("Please enter an available cell.");
                break;
            case 9:
                if (isValid(playerInput))
                    board[2][2] = player.letter();
                else
                    out.println("Please enter an available cell.");
                break;
        }
        out.println("Updating Board...");
        displayBoard();
        checkForEnd(board);
    }

    public static boolean isValid(int userInput) {
        switch (userInput) {
            case 1:
                return (board[0][0] == ' ');
            case 2:
                return (board[0][1] == ' ');
            case 3:
                return (board[0][2] == ' ');
            case 4:
                return (board[1][0] == ' ');
            case 5:
                return (board[1][1] == ' ');
            case 6:
                return (board[1][2] == ' ');
            case 7:
                return (board[2][0] == ' ');
            case 8:
                return (board[2][1] == ' ');
            case 9:
                return (board[2][2] == ' ');
            default:
                out.println("Please enter a number between 1-9 to choose an open valid cell.");
                return false;
        }
    }

    public static void checkForEnd(char[][] board) {
        if ((checkCellValue(board[0][0]) == checkCellValue(board[0][1]) && //Checks for Top row win.
                checkCellValue(board[0][1]) == checkCellValue(board[0][2]) &&
                checkCellValue(board[0][0]) != ' ') ||

                (checkCellValue(board[1][0]) == checkCellValue(board[1][1]) && //Checks for Middle Row win.
                        checkCellValue(board[1][1]) == checkCellValue(board[1][2]) &&
                        checkCellValue(board[1][0]) != ' ') ||

                (checkCellValue(board[2][0]) == checkCellValue(board[2][1]) && //Checks for Bottom Row win.
                        checkCellValue(board[2][1]) == checkCellValue(board[2][2]) &&
                        checkCellValue(board[2][0]) != ' ') ||

                (checkCellValue(board[0][0]) == checkCellValue(board[1][1]) && //Checks for left diagonal win.
                        checkCellValue(board[1][1]) == checkCellValue(board[2][2]) &&
                        checkCellValue(board[0][0]) != ' ') ||

                (checkCellValue(board[0][2]) == checkCellValue(board[1][1]) && //Checks for right diagonal win.
                        checkCellValue(board[1][1]) == checkCellValue(board[2][0]) &&
                        checkCellValue(board[0][2]) != ' ') ||

                (checkCellValue(board[0][0]) == checkCellValue(board[1][0]) && //Checks for left column win.
                        checkCellValue(board[1][0]) == checkCellValue(board[2][0]) &&
                        checkCellValue(board[0][0]) != ' ') ||

                (checkCellValue(board[0][1]) == checkCellValue(board[1][1]) && //Checks for middle column win.
                        checkCellValue(board[1][1]) == checkCellValue(board[2][1]) &&
                        checkCellValue(board[0][1]) != ' ') ||

                (checkCellValue(board[0][2]) == checkCellValue(board[1][2]) && //Checks for right column win.
                        checkCellValue(board[1][2]) == checkCellValue(board[2][2]) &&
                        checkCellValue(board[0][2]) != ' ')) {
            exitCondition(checkCellValue(board[0][0]));
        } else if (isXorO(board[0][0]) && isXorO(board[0][1]) && isXorO(board[0][2]) &&
                isXorO(board[1][0]) && isXorO(board[1][1]) && isXorO(board[1][2]) &&
                isXorO(board[2][0]) && isXorO(board[2][1]) && isXorO(board[2][2]))
            exitCondition('D');
    }

    public static boolean isXorO(char cellIndex) {
        return (cellIndex == 'X' || cellIndex == 'O');
    }

    public static char checkCellValue(char cellIndex) {
        if (cellIndex == 'X')
            return 'X';
        else if (cellIndex == 'O')
            return 'O';
        else
            return ' ';
    }

    public static void exitCondition(char winningPlayer) {
        if (winningPlayer == 'X') {
            out.println(playerOne.name() + " wins!!");
            gameEnded = true;
        } else if (winningPlayer == 'O') {
            out.println(playerTwo.name() + " wins!!");
            gameEnded = true;
        } else {
            out.println("DRAW!!");
            gameEnded = true;
        }
    }
}