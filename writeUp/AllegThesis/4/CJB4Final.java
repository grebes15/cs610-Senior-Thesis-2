/*
Andreas Landgrebe
Computer Science 600
Common Java Bug 5
This is a game of Tic Tac Toe playing against the computer but wait there is an error
I wrote this program from scratch so I am not citing any websites.
*/

import java.util.Scanner;
import java.util.Random;
public class CJB4Final {
  
  
    static int [] board =  {0,0,0,0,0,0,0,0,0};
  
  
    public static int getMove() {
        int num=-1;
        while (moveIsNotLegal(num)){
            System.out.println();
            System.out.println("What is your move (X) 0-8?");
              
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            num = Integer.parseInt(str);
            if (moveIsNotLegal(num)) {
                System.out.println("That move is not correct");
            }
      
        }
  
        return num;
    }
      
    public static void printBoard() {
        for (int row=0; row<3; row++){
            System.out.println("   |   |   ");
  
            for (int col=0; col<3; col++) {
                switch (board[row*3+col]) {
                case 0: System.out.print("   ");

                case 1: System.out.print(" X ");
                break;
                case 2: System.out.print(" O ");
                }
                if (col!=2) System.out.print("|");
            }
            System.out.println();
            System.out.println("   |   |   ");
  
            if (row!=2) System.out.println("------------");
  
        }
          
    }
  
    public static boolean moveIsNotLegal(int position) {
        if ((position<0)||(position>8)) return true;
        return (board[position]!=0);
    }
      
    public static int findWinningMove() {
        boolean foundit = false;
        int candidate=0;
        while ((candidate<9)&&(!foundit))
        {
            if (board[candidate]==0) // spot is empty
            {
                board[candidate]=2;
                foundit=(Winner()==2);
                board[candidate]=0;
  
            }
            if (!foundit) {
                candidate++;
            }
        }
        if (foundit) return candidate;
        return (-1);
  
    }
      
    public static int Winner()
  
    {
        int winner = 0;
        for (int player = 1; player <= 2; player++) {
            if ((board[0] == player) && (board[1] == player) && (board[2] == player))
                winner = player;
            if ((board[0] == player) && (board[3] == player) && (board[6] == player))
                winner = player;
            if ((board[0] == player) && (board[4] == player) && (board[8] == player))
                winner = player;
            if ((board[1] == player) && (board[4] == player) && (board[7] == player))
                winner = player;
            if ((board[2] == player) && (board[5] == player) && (board[8] == player))
                winner = player;
            if ((board[3] == player) && (board[4] == player) && (board[5] == player))
                winner = player;
            if ((board[6] == player) && (board[7] == player) && (board[8] == player))
                winner = player;
            if ((board[2] == player) && (board[4] == player) && (board[6] == player))
                winner = player;
        }
  
        return winner;
    }
  
    public static int findRandomMove() {
        int candidate = -1;
        Random rg = new Random();
  
        while (moveIsNotLegal(candidate)) {
            candidate = rg.nextInt(9);
        }
  
        return candidate;
          
    }
      
    public static int checkBoard(int player) {
        int opponent;
        if (player==1) {
            opponent=2;
        } else {
            opponent=1;
        }
        int danger=-1;
          
        if ((board[0]==player)&&(board[1]==player)&&(board[2]!=opponent)) danger=2;
        if ((board[1]==player)&&(board[2]==player)&&(board[0]!=opponent)) danger=0;     
        if ((board[0]==player)&&(board[2]==player)&&(board[1]!=opponent)) danger=1;     
        if ((board[0]==player)&&(board[3]==player)&&(board[6]!=opponent)) danger=6;
        if ((board[0]==player)&&(board[4]==player)&&(board[8]!=opponent)) danger=8;     
        if ((board[0]==player)&&(board[6]==player)&&(board[3]!=opponent)) danger=3;
        if ((board[0]==player)&&(board[8]==player)&&(board[4]!=opponent)) danger=4;
          
        if ((board[1]==player)&&(board[2]==player)&&(board[0]!=opponent)) danger=0;
        if ((board[1]==player)&&(board[4]==player)&&(board[7]!=opponent)) danger=7;     
        if ((board[1]==player)&&(board[7]==player)&&(board[4]!=opponent)) danger=4;
          
        if ((board[2]==player)&&(board[4]==player)&&(board[6]!=opponent)) danger=6;
        if ((board[2]==player)&&(board[6]==player)&&(board[4]!=opponent)) danger=4;     
        if ((board[2]==player)&&(board[5]==player)&&(board[8]!=opponent)) danger=8;
        if ((board[2]==player)&&(board[8]==player)&&(board[5]!=opponent)) danger=5;
  
        if ((board[3]==player)&&(board[4]==player)&&(board[5]!=opponent)) danger=5;
        if ((board[3]==player)&&(board[5]==player)&&(board[4]!=opponent)) danger=4;     
  
        if ((board[4]==player)&&(board[5]==player)&&(board[3]!=opponent)) danger=3;
        if ((board[4]==player)&&(board[6]==player)&&(board[2]!=opponent)) danger=2;     
        if ((board[4]==player)&&(board[7]==player)&&(board[1]!=opponent)) danger=1;
        if ((board[4]==player)&&(board[8]==player)&&(board[0]!=opponent)) danger=0;
  
        if ((board[5]==player)&&(board[8]==player)&&(board[2]!=opponent)) danger=2;
          
        if ((board[6]==player)&&(board[7]==player)&&(board[8]!=opponent)) danger=8;     
        if ((board[6]==player)&&(board[8]==player)&&(board[7]!=opponent)) danger=7;
          
        if ((board[7]==player)&&(board[8]==player)&&(board[6]!=opponent)) danger=6;
        return danger;
  
  
          
    }
      
    public static void main(String[] args) {
          
        String str;
        System.out.println("TicTacToe");
          
  
        int num = getMove();
        board[num]=1;
          
        switch (num) {
        case 4: System.out.println("My move is number 0");
                board[0]=2;
                break;
        case 0:
        case 2:
        case 6:
        case 8: System.out.println("My move is number 4");
        board[4]=2;
        break;
          
        case 1:
        case 3:
        case 5:
        case 7: System.out.println("My move is number 4");
        board[4]=2;
        break;
        }
          
        num=-1;
        while (moveIsNotLegal(num)) {
            printBoard();
  
            num=getMove();
        }
          
        board[num]=1;
          
        printBoard();
  
        // Computer move. See if opponent has two in a row
        // find if two in a row
          
        int nextmove =checkBoard(1);
          
        if (nextmove>=0) { 
            System.out.println();
            System.out.println("My move is "+nextmove);
            board[nextmove]=2;
        } else {
            boolean foundit = false;
            int candidate=0;
            while ((candidate<9)&&(!foundit))
            {
                if (board[candidate]==0) // spot is empty
                {
                    board[candidate]=2;
                    foundit = (checkBoard(2)>=0);
                    board[candidate]=0;
                }
                if (!foundit) {
                    candidate++;
                }
            }
            if (foundit==true) {
                System.out.println("My move is " + candidate);
                board[candidate] = 2;
            } else {
                // do a random move
                while (moveIsNotLegal(candidate)) {
                    candidate = (int) Math.random()*9;                  
                }
                System.out.println("My move is (random) " + candidate);
                board[candidate] = 2;               
  
            }
        }
              
        while (moveIsNotLegal(num)) {
            printBoard();
            num = getMove();
        }
          
        board[num]=1;
          
          
        if (Winner() != 0) {
            printBoard();
            if (Winner()==1) System.out.println("You win!!");
            else System.out.println("Guess who just won????");
            System.exit(0); 
        }
        // can we get three in a row
  
        if (findWinningMove() >= 0) {
            System.out.println("We have an offensive move");
            num = findWinningMove();
            board[num] = 2;
        } else {
  
            // defensive move
            int nextmove2 = checkBoard(1);
            if (nextmove2 >= 0) {
                System.out.println("My move is " + nextmove2);
                board[nextmove2] = 2;
            } else {
                // random move
                nextmove2 = findRandomMove();
                board[nextmove2]= 2;
            }
        }
        if (Winner() != 0) {
            printBoard();
            if (Winner()==1) System.out.println("You win!!");
            else System.out.println("Guess who just won????");
            System.exit(0); 
            }
  
        while (moveIsNotLegal(num)) {
            printBoard();
            num = getMove();
        }
          
        board[num]=1;
  
        if (Winner() != 0) {
            printBoard();
            if (Winner()==1) System.out.println("You win!!");
            else System.out.println("Guess who just won????");
            System.exit(0); 
        }
        // can we get three in a row
  
        if (findWinningMove() >= 0) {
            System.out.println("We have an offensive move");
            num = findWinningMove();
            board[num] = 2;
        } else {
  
            // defensive move
            int nextmove3 = checkBoard(1);
            if (nextmove3 >= 0) {
                System.out.println("My move is " + nextmove3);
                board[nextmove3] = 2;
            } else {
                // random move
                nextmove3 = findRandomMove();
                board[nextmove3]= 2;
            }
        }
        if (Winner() != 0) {
            printBoard();
            if (Winner()==1) System.out.println("You win!!");
            else System.out.println("Guess who just won????");
            System.exit(0); 
        }
      
        printBoard();
          
        System.out.println("Darn. It is a tie!!");
  
    }
}       
         
