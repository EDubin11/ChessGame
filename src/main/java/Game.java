public class Game {
    private Piece[][] board;
    
    public Game() {
        this.board = new Piece[8][8];
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
        while (!this.validMove(startLetter, startNumber, endLetter, endNumber) {
            
        }
    }
    
    public boolean validMove(int startLetter, int startNumber, int endLetter, int endNumber) {
        switch (this.board[startLetter][startNumber]) {
            case 
        }
    }
    
}
