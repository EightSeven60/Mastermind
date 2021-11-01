import Classes.GameBoard;
import GUI.AppFrame;

public class Mastermind {
    public static void main(String[] args) {
        GameBoard gameBoard = GameBoard.getInstance();
        AppFrame appFrame = new AppFrame(gameBoard);
    }
}
