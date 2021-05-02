package Model;

import Boards.BoardBase;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ComputerPlayer {
    private char type;

    public ComputerPlayer(char type){
        this.type = type;
    }

    public String playMove(){
        String returnedMove;
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        switch(type) {
            case 'E':
                returnedMove = computerEasyPlay();
                break;

            case 'M':
                returnedMove = computerMediumPlay();
                break;

            case 'H':
                returnedMove = computerHardPlay();
                break;



            default:
                returnedMove = "";
        }
        return returnedMove;
    }

    private String computerEasyPlay(){
        boolean played = false;
        String entry = "";
        do{
            for(int i =0;i<3;i++){
                for (int j = 0;j<3;j++){

                    if(BoardBase.getGameArray()[i][j].equals("")){
                        entry = getString(i,j);
                        played = true;
                        break;
                    }

                }
                if(played){
                    break;
                }
            }

        }while (!played);
        return entry;
    }

    private String computerMediumPlay(){
        boolean played = false;
        int i = -1;
        int j = -1;

        Random rand = new Random();
        while(!played) {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
            if (BoardBase.getGameArray()[i][j].equals("")){
                played = true;
            }
        }
        return getString(i,j);

    }

    private String computerHardPlay(){
        String [][] board = new String[3][3];
        for(int i =0;i<3;i++){
            board[i] = BoardBase.getGameArray()[i].clone();
        }
        return findBestMove(board);
    }

    private boolean isMovesLeft(String board[][]){
        for(int i =0;i<3;i++){
            for (int j=0;j<3;j++){
                if(board[i][j].equals("")){
                    return true;
                }
            }
        }
        return false;
    }

    private int evaluate(String board[][]){
        for(int row = 0;row<3;row++){
            if(board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2])){

                if(board[row][0].equals("X")){
                    return +10;
                }
                else if(board[row][0].equals("O")){
                    return -10;
                }
            }
        }
        for (int col = 0; col < 3; col++)
        {
            if (board[0][col].equals(board[1][col]) &&
                    board[1][col].equals(board[2][col]))
            {
                if (board[0][col].equals("X"))
                    return +10;

                else if (board[0][col].equals("O"))
                    return -10;
            }
        }

        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
        {
            if (board[0][0].equals("X"))
                return +10;
            else if (board[0][0].equals("O"))
                return -10;
        }

        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]))
        {
            if (board[0][2].equals("X"))
                return +10;
            else if (board[0][2].equals("O"))
                return -10;
        }
        return 0;
    }

    private int miniMax(String board [][], int depth, boolean isMax){

        int score = evaluate(board);
        if (score == 10)
            return score;


        if (score == -10)
            return score;


        if (isMovesLeft(board) == false)
            return 0;
        if(isMax){
            int best = -1000;

            for (int i =0;i<3;i++){
                for(int j = 0;j<3;j++){
                    if(board[i][j].equals("")){
                        board[i][j] = "X";
                        best = Math.max(best,miniMax(board,depth+1,!isMax));
                        board[i][j] = "";
                    }
                }
            }

            return best;
        }

        else
        {
            int best = 1000;

            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (board[i][j].equals(""))
                    {

                        board[i][j] = "O";
                        best = Math.min(best, miniMax(board, depth + 1, !isMax));

                        board[i][j] = "";
                    }
                }
            }
            return best;
        }
    }

    private String findBestMove(String board[][]){

        int bestVal = -1000;
        int row = -1;
        int col = -1;

        for (int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){

                if(board[i][j].equals("")){
                    board[i][j]="X";
                    int moveVal = miniMax(board,0,false);
                    board[i][j]="";

                    if (moveVal > bestVal) {

                        row = i;
                        col = j;
                        bestVal = moveVal;
                    }
                    }
                }

            }
        return getString(row,col);
        }



    private String getString(int indexI, int indexJ){
        String temp = Integer.toString(indexI);
        temp+=Integer.toString(indexJ);
        return temp;
    }
}
