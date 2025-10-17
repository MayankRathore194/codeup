package Java.openupvs.Assignment3_2;

import java.util.Random;

public class Game2048 {
    public static int SIZE=4;
    public static int [][] board=new int[SIZE][SIZE];
    public static Random random = new Random();
    public static boolean moved = false;
    //Print board
    public static void printBoard()
    {
        for(int i=0;i<SIZE;i++)
        {
            System.out.println("");
            System.out.println("-------------------");
            for(int j=0;j<SIZE;j++)
            {
                System.out.print("| ");
                System.out.print(board[i][j]);
                System.out.print(" |");
            }


        }
    }
    //Add 2 or 4 at random box
    public static void addRandomTile() {
        int emptyCount = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    emptyCount++;
                }
            }
        }
        if (emptyCount == 0) return;

        int pos = random.nextInt(emptyCount);
        int value = random.nextInt(10) < 9 ? 2 : 4;

        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) { 
                    if (count == pos) {
                        board[i][j] = value;
                        return;
                    }
                    count++; 
                }
            }
        }
    }
    // Move tiles LEFT
    public static void moveLeft() {
        for (int i=0;i<SIZE;i++) {
            int[] newRow = new int[SIZE];
            int pos=0;
            for (int j=0;j<SIZE;j++) {
                if (board[i][j] != 0) {
                    if (newRow[pos]==0)newRow[pos]=board[i][j];
                    else if (newRow[pos]==board[i][j]) {
                        newRow[pos]= 2*newRow[pos];
                        pos++;
                    } else {
                        pos++;
                        newRow[pos]=board[i][j];
                    }
                }
            }
            for (int j=0;j<SIZE;j++) {
                if (board[i][j] != newRow[j]) moved = true;
                board[i][j] = newRow[j];
            }
        }
    }

    // Move  RIGHT
    public static void moveRight() {
        for (int i=0;i<SIZE;i++) {
            int[] newRow = new int[SIZE];
            int pos=SIZE - 1;
            for (int j=SIZE-1;j>=0;j--) {
                if (board[i][j]!= 0) {
                    if (newRow[pos]==0) newRow[pos]=board[i][j];
                    else if (newRow[pos]==board[i][j]) {
                        newRow[pos]*= 2;
                        pos--;
                    } else {
                        pos--;
                        newRow[pos]=board[i][j];
                    }
                }
            }
            for (int j=0;j<SIZE;j++) {
                if (board[i][j]!= newRow[j]) moved = true;
                board[i][j] = newRow[j];
            }
        }
    }

    // Move  UP
    public static void moveUp() {
        for (int j = 0; j < SIZE; j++) {
            int[] newCol = new int[SIZE];
            int pos=0;
            for (int i=0;i<SIZE;i++) {
                if (board[i][j] != 0) {
                    if (newCol[pos]==0) newCol[pos]=board[i][j];
                    else if (newCol[pos]==board[i][j]) {
                        newCol[pos] *= 2;
                        pos++;
                    } else {
                        pos++;
                        newCol[pos]=board[i][j];
                    }
                }
            }
            for (int i = 0; i < SIZE; i++) {
                if (board[i][j] != newCol[i]) moved = true;
                board[i][j] = newCol[i];
            }
        }
    }

    // Move  DOWN
    public static void moveDown() {
        for (int j=0;j<SIZE;j++) {
            int[] newCol = new int[SIZE];
            int pos=SIZE-1;
            for (int i=SIZE- 1;i>=0;i--) {
                if (board[i][j] != 0) {
                    if (newCol[pos]==0) newCol[pos]=board[i][j];
                    else if (newCol[pos]==board[i][j]) {
                        newCol[pos]*= 2;
                        pos--;
                    } else {
                        pos--;
                        newCol[pos]=board[i][j];
                    }
                }
            }
            for (int i = 0; i < SIZE; i++) {
                if (board[i][j] != newCol[i]) moved = true;
                board[i][j] = newCol[i];
            }
        }
    }
    //Method to check if the user win
    public static boolean checkWin() {
        for (int i=0;i<SIZE;i++)
        {
            for (int j=0;j<SIZE;j++)
            {
                if (board[i][j]==2048) return true;
            }
        }
        return false;
    }
    //check if no move left
    public static boolean isGameOver() {
        for (int i=0;i<SIZE;i++)
        {
            for (int j=0;j<SIZE;j++)
            {
                if (board[i][j] == 0) return false;
            }
        }

        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE - 1; j++)
                if (board[i][j] == board[i][j + 1] || board[j][i] == board[j + 1][i])
                    return false;

        return true;
    }


    
    
}
