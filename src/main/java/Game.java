import java.util.Scanner;

public class Game {
    private Piece[][] board;
    
    public Game() {
        this.board = new Piece[8][8];
    }
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Game game = new Game();
        while (true) {
            System.out.println("Enter move: ");
            String move = keyboard.next();
            while (move.length() != 8) {
                System.out.println("Invalid move entered. Enter move: ");
                move = keyboard.next();
            }
            while (!game.validMove(move)) {
                System.out.println("Invalid move entered. Enter move: ");
                move = keyboard.next();
            }
            game.move(move);
            game.printBoard();
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
        int startNumber = Character.getNumericValue(startNumChar);
        int endLetter = (int)end.charAt(0) - 65;
        Character endNumChar = end.charAt(1);
        int endNumber = Character.getNumericValue(endNumChar);
        
        Piece pieceToMove = this.board[startLetter][startNumber];
        if (!pieceToMove.validMoving()) {
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
        
        return true;
    }
    
    private boolean bishopValidMove(int startLetter, int startNumber, int endLetter, int endNumber, Piece piece) {
        return true;
    }
    
    
    
    
    
    
    
    private void printBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                System.out.print(this.board[i][j].getType() + ": " +  this.board[i][j].getColor());
                if (j != this.board[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            System.out.println("-----------------------------------------------------------------");
        }
    }
}
