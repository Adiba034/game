import java.util.Scanner;

public class Controller {
    private int size;
    private int[][] board;
    public Controller(int size) {
        this.size = size;
        this.board = new int[size][size];
       }

    public void play() {
        initializeBoard();
        printBoard();

        Scanner scanner = new Scanner(System.in);
        while (!isGameOver()) {
            System.out.print("Enter move (w/a/s/d): ");
            String move = scanner.next().trim().toLowerCase();

            if (move.equals("w")) {
                moveUp();
            }else if (move.equals("a")) {
                moveLeft();
            } else if (move.equals("s")) {
                moveDown();
            } else if (move.equals("d")) {
                moveRight();
            } else {
                System.out.println("Invalid move!");
                continue;
            }

            addNewNumber();
            printBoard();
        }

        System.out.println("Game over!");
        scanner.close();
    }

    private void initializeBoard() {
        addNewNumber();
        addNewNumber();
    }

    private void addNewNumber() {
        int row, col;
        do {
            row = (int) (Math.random() * size);
            col = (int) (Math.random() * size);
        } while (board[row][col] != 0);

        board[row][col] = Math.random() < 0.9 ? 2 : 4;
    }

    private boolean isGameOver() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
                if (i < size - 1 && board[i][j] == board[i + 1][j]) {
                    return false;
                }
                if (j < size - 1 && board[i][j] == board[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }


    private void moveUp() {
        for (int col = 0; col < size; col++) {
            for (int row = 1; row < size; row++) {
                if (board[row][col] != 0) {
                    int mergedRow = row;
                    while (mergedRow > 0 && board[mergedRow - 1][col] == 0) {
                        board[mergedRow - 1][col] = board[mergedRow][col];
                        board[mergedRow][col] = 0;
                        mergedRow--;
                    }
                    if (mergedRow > 0 && board[mergedRow - 1][col] == board[mergedRow][col]) {
                        board[mergedRow - 1][col] *= 2;
                        board[mergedRow][col] = 0;
                    }
                }
            }
        }
    }

    private void moveDown() {
        for (int col = 0; col < size; col++) {
            for (int row = size - 2; row >= 0; row--) {
                if (board[row][col] != 0) {
                    int mergedRow = row;
                    while (mergedRow < size - 1 && board[mergedRow + 1][col] == 0) {
                        board[mergedRow + 1][col] = board[mergedRow][col];
                        board[mergedRow][col] = 0;
                        mergedRow++;
                    }
                    if (mergedRow < size - 1 && board[mergedRow + 1][col] == board[mergedRow][col]) {
                        board[mergedRow + 1][col] *= 2;
                        board[mergedRow][col] = 0;
                    }
                }
            }
        }
    }
    private void moveLeft() {
        for (int row = 0; row < size; row++) {
            for (int col = 1; col < size; col++) {
                if (board[row][col] != 0) {
                    int mergedCol = col;
                    while (mergedCol > 0 && board[row][mergedCol - 1] == 0) {
                        board[row][mergedCol - 1] = board[row][mergedCol];
                        board[row][mergedCol] = 0;
                        mergedCol--;
                    }
                    if (mergedCol > 0 && board[row][mergedCol - 1] == board[row][mergedCol]) {
                        board[row][mergedCol - 1] *= 2;
                        board[row][mergedCol] = 0;
                    }
                }
            }
        }
    }
    private void moveRight() {
        for (int row = 0; row < size; row++) {
            for (int col = size - 2; col >= 0; col--) {
                if (board[row][col] != 0) {
                    int mergedCol = col;
                    while (mergedCol < size - 1 && board[row][mergedCol + 1] == 0) {
                        board[row][mergedCol + 1] = board[row][mergedCol];
                        board[row][mergedCol] = 0;
                        mergedCol++;
                    }
                    if (mergedCol < size - 1 && board[row][mergedCol + 1] == board[row][mergedCol]) {
                        board[row][mergedCol + 1] *= 2;
                        board[row][mergedCol] = 0;
                    }
                }
            }
        }
    }
    
    private void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}