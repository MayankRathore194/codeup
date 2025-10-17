package Java.openupvs.Assignment3_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game2048.addRandomTile();
        Game2048.addRandomTile();
        Game2048.printBoard();
        Scanner scanner = new Scanner(System.in);

        boolean k=true;//for infinite loop
        

        while(k)
        {
            
             System.out.println("""
                                \nEnter move :-
                                W:Move up
                                S:Move down
                                A:Move left
                                D:Move right
                                Q: to exit""");
            char move = Character.toUpperCase(scanner.next().charAt(0));
            Game2048.moved = false;
            
           
            switch (move) {
                case 'W' :Game2048.moveUp(); break;
                case 'S': Game2048.moveDown(); break;
                case 'A': Game2048.moveLeft(); break;
                case 'D': Game2048.moveRight(); break;
                case 'Q':return;
                default:
                    break;
            }
            if (Game2048.moved) {
                Game2048.addRandomTile();
                Game2048.printBoard();
            } else {
                System.out.println("No tiles moved. Try another direction!");
            }
            if (Game2048.checkWin()) {
                Game2048.printBoard();
                System.out.println("Congratulations you reached 2048");
                break;
            }
            if (Game2048.isGameOver()) {
                Game2048.printBoard();
                System.out.println("Game Over");
                break;
            }

        }
    }
    
}
