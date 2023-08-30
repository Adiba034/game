import java.util.Scanner;
public class Game2048 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter board size: ");
        int boardSize = scanner.nextInt();
        // scanner.close();
        
        Controller controller = new Controller(boardSize);
        controller.play();
    }
}
