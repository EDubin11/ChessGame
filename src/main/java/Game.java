import java.util.Scanner;

public class Game {
    private Piece[][] board;
    
    public Game() {
        this.board = new Piece[8][8];
        this.board[0][0] = new Rook (Color.BLACK);
        this.board[0][1] = new Knight (Color.BLACK);
        this.board[0][2] = new Bishop (Color.BLACK);
        this.board[0][3] = new Queen (Color.BLACK);
        this.board[0][4] = new King (Color.BLACK);
        this.board[0][5] = new Bishop (Color.BLACK);
        this.board[0][6] = new Knight (Color.BLACK);
        this.board[0][7] = new Rook (Color.BLACK);
        for (int i = 0; i < 8; i++) {
            this.board[1][i] = new Pawn(Color.BLACK);
        }
        
        this.board[7][0] = new Rook (Color.WHITE);
        this.board[7][1] = new Knight (Color.WHITE);
        this.board[7][2] = new Bishop (Color.WHITE);
        this.board[7][3] = new King (Color.WHITE);
        this.board[7][4] = new Queen (Color.WHITE);
        this.board[7][5] = new Bishop (Color.WHITE);
        this.board[7][6] = new Knight (Color.WHITE);
        this.board[7][7] = new Rook (Color.WHITE);
        for (int i = 0; i < 8; i++) {
            this.board[7][i] = new Pawn(Color.WHITE);
        }
    }
    
    
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Game game = new Game();
        game.printBoard();
        while (true) {
            System.out.println("Enter move: ");
            String move = keyboard.nextLine();
            while (move.length() != 8) {
                System.out.println("Invalid move entered. Enter move: ");
                move = keyboard.next();
            }
            while (!game.validMove(move)) {
                System.out.println("Invalid move entered. Enter move: ");
                move = keyboard.next();
            }
            game.move(move);
            // game.printBoard();
        }
        
        
    }
    public void move(String move) {
        String start = move.substring(0,2);
        String end = move.substring(6);
        int startLetter = (int)start.charAt(0) - 65;
        Character startNumChar = start.charAt(1);
        int startNumber = Character.getNumericValue(startNumChar);
        int endLetter = (int)end.charAt(0) - 65;
        Character endNumChar = end.charAt(1);
        int endNumber = Character.getNumericValue(endNumChar);
        
        Piece pieceToMove = this.board[startLetter][startNumber];
        this.board[startLetter][startNumber] = null;
        this.board[endLetter][endNumber] = pieceToMove;
    }
    
    
    public boolean validMove(String move) {
        String start = move.substring(0,2);
        String end = move.substring(6);
        int startLetter = (int)start.charAt(0) - 65;
        Character startNumChar = start.charAt(1);
        int startNumber = Character.getNumericValue(startNumChar) - 1;
        int endLetter = (int)end.charAt(0) - 65;
        Character endNumChar = end.charAt(1);
        int endNumber = Character.getNumericValue(endNumChar) - 1;
        
        Piece pieceToMove = this.board[startLetter][startNumber];
        if (!pieceToMove.validMoving(start, end)) {
            return false;
        } 
        switch (this.board[startLetter][startNumber].getType()) {
            case "King":
                return this.kingValidMove(startLetter, startNumber, endLetter, endNumber, pieceToMove);
            case "Knight":
                return this.knightValidMove(startLetter, startNumber, endLetter, endNumber, pieceToMove);
            case "Pawn":
                return this.pawnValidMove(startLetter, startNumber, endLetter, endNumber, pieceToMove);
            case "Queen":
                return this.queenValidMove(startLetter, startNumber, endLetter, endNumber, pieceToMove);
            case "Rook":
                return this.rookValidMove(startLetter, startNumber, endLetter, endNumber, pieceToMove);
            case "Bishop":
                return this.bishopValidMove(startLetter, startNumber, endLetter, endNumber, pieceToMove);
            default:
                return false;
        }
    }
    
    private boolean kingValidMove(int startLetter, int startNumber, int endLetter, int endNumber, Piece piece) {
        return true;
    }
    
    private boolean knightValidMove(int startLetter, int startNumber, int endLetter, int endNumber, Piece piece) {
        return true;
    }
    
    private boolean pawnValidMove(int startLetter, int startNumber, int endLetter, int endNumber, Piece piece) {
        return true;
    }
    
    private boolean queenValidMove(int startLetter, int startNumber, int endLetter, int endNumber, Piece piece) {
        return true;
    }
    
    private boolean rookValidMove(int startLetter, int startNumber, int endLetter, int endNumber, Piece piece) {
        if (startLetter == endLetter) { //Same row
            if (startNumber < endNumber) {
                for (int i = startNumber; i < endNumber; i++) {
                    if (this.board[startLetter][i] != null) {
                        return false;
                    }
                }
            }
            else {
                for (int i = endNumber; i < startNumber; i++) {
                    if (this.board[startLetter][i] != null) {
                        return false;
                    }
                }
            }
        }
        else {
            if (startLetter < endLetter) {
                for (int i = startLetter; i < endLetter; i++) {
                    if (this.board[i][startNumber] != null) {
                        return false;
                    }
                }
            }
            else {
                for (int i = endLetter; i < startLetter; i++) {
                    if (this.board[i][startNumber] != null) {
                        return false;
                    }
                }
            }
        }
        if (!piece.differentColor(this.board[endLetter][endNumber])) {
            return false;
        }
        return true;
    }
    
    private boolean bishopValidMove(int startLetter, int startNumber, int endLetter, int endNumber, Piece piece) {
        return true;
    }
    
    
    
    
    
    
    
    private void printBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j] != null) {
                    System.out.print(this.board[i][j].getType() + ": " +  this.board[i][j].getColor());
                }
                else {
                    System.out.print("       ");
                }
                if (j != this.board[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            System.out.println("-----------------------------------------------------------------");
        }
    }
}
