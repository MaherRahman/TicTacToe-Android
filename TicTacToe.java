// logic for tic tac toe
import java.util.Random;

public class TicTacToe {
    
    Symbols[] board;
    
    public TicTacToe() {
        
    }
    
    public boolean setPlayerMove(int pos) {
        if (board[pos] == Symbols.Blank && !isGameOver()) {
            board[pos] = Symbols.X;
            return true;
        }
        return false;
    }
    
    public int setComputerMove() {
        Random r = new Random();
        
        int pos = r.nextInt(bound: 9);
        
        if (isGameOver()) {
            return -1;
        }
        
        while (board[pos] != Symbols.Blank) {
            pos = r.nextInt(bound: 9);
        }
        
        board[pos] = Symbols.O;
        return pos;
    }
    
    public boolean isGameOver() {
        return whoWon() != Results.inProgress;
    
    }
    
    public Results whoWon() {
        Results result = checkHorVer();
        if (result == Results.inProgress) {
            result = checkDiag();
            if (result == Results.inProgress) {
                result = checkDraw();
            }
        }
        return result;
    }
    
    private Results checkHorVer() {
        for (int i = 0; i < 3; i++) {
            // checks the horizontal, Vertical to see if someone has won. 
            if(board[i * 3] == Symbols.X && board[(i * 3) + 1] == Symbols.X &&                      board[(i * 3) + 2] == Symbols.X) {
                return Results.Player;
            } else if (board[i] == Symbols.X && board[i + 3] == Symbols.X &&
                        board[i + 6] == Symbols.X) {
                return Results.Player;
            } else if(board[i * 3] == Symbols.O && board[(i * 3) + 1] ==                                Symbols.O && board[(i * 3) + 2] == Symbols.O) {
                return Results.Computer;
            } else if (board[i] == Symbols.O && board[i + 3] == Symbols.O &&
                        board[i + 6] == Symbols.O) {
                return Results.Computer;
            }
        }
        
        return Results.inProgress;
    }
    
    private Results checkDiag() {
        if (board[0] == Symbols.X && board[4] == Symbols.X && board[8] ==                     Symbols.X) {
            return Results.Player;
        } else if (board[2] == Symbols.X && board[4] == Symbols.X && board[6]                   == Symbols.X}
            return Results.Player;
        } else if (board[0] == Symbols.O && board[4] == Symbols.O && board[8]                   == Symbols.O) {
            return Results.Computer;
        } else if (board[2] == Symbols.O && board[4] == Symbols.O && board[6]                   == Symbols.O}
            return Results.Player;
        }
        return Results.inProgress;
    }
    
    private Results checkDraw() {
        for (Symbols symb: board) {
            if (symb == Symbol.Blank) {
                return Results.inProgress;
            }
        }
        return Results.Draw;
    }
    
    public void reset() {
        board = new Symbols[9];
        
        for (int i = 0; i < board.length; i++) {
            board[i] = Symbols.Blank;
        }
    }

}


// make an enumerated Data Type. 

public enum Symbols {

    Blank, X, O

}

public enum Results {
    Player, Computer, Draw, inProgress
}
