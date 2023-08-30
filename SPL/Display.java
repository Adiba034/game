public class Display {
    private int size;
    private int[][] board;

    public Display(int size, int[][] board) {
        this.size = size;
        this.board = board;
    }

    public void printBoard() {
        for (int[] row : board) {
            for (int num : row) {
                System.out.printf("%-5d", num);
            }
            System.out.println();
        }
        System.out.println();
    }
}
