import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;  

public class Game {
    private Piece[][] board;
    private List<Piece> white;
    private List<Piece> black;
    private boolean whiteTurn;
    private Set<String> allMovesSpots;
    
    public Game() {
        this.whiteTurn = true;
        this.white = new ArrayList<>();
        this.black = new ArrayList<>();
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
            black.add(this.board[1][i]);
            black.add((this.board[0][i]));
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
            this.board[6][i] = new Pawn(Color.WHITE);
            white.add(this.board[6][i]);
            white.add((this.board[7][i]));
        }
        this.allMovesSpots = new HashSet<>();
        populateSet();
    }
    
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Game game = new Game();
        game.printBoard();
        while (!game.checkMate()) {
            if (game.whiteTurn) {
                System.out.println("White to move");
            }
            else {
                System.out.println("Black to move");
            }
            System.out.println("Type " + "\"" + "END" + "\"" +" or Enter move: ");
            String move = keyboard.nextLine();
            if (move.equals("END")){
                System.out.println("Game ended. Goodbye. ");
                keyboard.close();
                return;
            }
            if (move.length() != 8) {
                System.out.print("Invalid move. ");
                continue;
            }
            if (!game.validMove(move)) {
                System.out.print("Invalid move. ");
                continue;
            }
            
            Piece pieceAttacked = game.move(move);

            if (game.inCheck(game.whiteTurn)) {
                game.undoMove(move, pieceAttacked);
                continue;
            }
            game.whiteTurn = !game.whiteTurn;
            game.printBoard();
        } 
        keyboard.close();
        
    }
    public Piece move(String move) {
        String start = move.substring(0,2);
        String end = move.substring(6);
        int startLetter = (int)start.charAt(0) - 65;
        // if (startLetter)
        Character startNumChar = start.charAt(1);
        int startNumber = Character.getNumericValue(startNumChar) - 1;
        int endLetter = (int)end.charAt(0) - 65;
        Character endNumChar = end.charAt(1);
        int endNumber = Character.getNumericValue(endNumChar) - 1;
        
        Piece pieceToMove = this.board[startLetter][startNumber];
        if (this.board[endLetter][endNumber] != null) {
            Color col = this.board[endLetter][endNumber].getColor();
            if (col == Color.BLACK) {
                black.remove(this.board[endLetter][endNumber]);
            }else {
                white.remove(this.board[endLetter][endNumber]);
            }
        }
        Piece pieceToReturn = null;
        if (this.board[endLetter][endNumber] != null) {
            pieceToReturn = this.board[endLetter][endNumber];
        }
        this.board[startLetter][startNumber] = null;
        this.board[endLetter][endNumber] = pieceToMove;
        return pieceToReturn;
    }
    
    private void undoMove(String move, Piece pieceAttacked) {
        String start = move.substring(0,2);
        String end = move.substring(6);
        int startLetter = (int)start.charAt(0) - 65;
        Character startNumChar = start.charAt(1);
        int startNumber = Character.getNumericValue(startNumChar);
        int endLetter = (int)end.charAt(0) - 65;
        Character endNumChar = end.charAt(1);
        int endNumber = Character.getNumericValue(endNumChar);
        this.board[startLetter][startNumber] = this.board[endLetter][endNumber];
        this.board[endLetter][endNumber] = pieceAttacked;
    }
    
    
    public boolean validMove(String move) {
        String start = move.substring(0,2);
        String end = move.substring(6);
        int startLetter = (int)start.charAt(0) - 65;
        if (((startLetter > 8) ||  ((int)startLetter < 0))){
            return false;
        }
        Character startNumChar = start.charAt(1);
        int startNumber = Character.getNumericValue(startNumChar) - 1;
        int endLetter = (int)end.charAt(0) - 65;
        if (((endLetter > 8) ||  ((int)endLetter < 0))){
            return false;
        }
        Character endNumChar = end.charAt(1);
        int endNumber = Character.getNumericValue(endNumChar) - 1;
        
        Piece pieceToMove = this.board[startLetter][startNumber];
        
        if (pieceToMove == null){
            return false;
        }
        if (whiteTurn){
            if (pieceToMove.getColor() != Color.WHITE){
                return false;
            }
        }else{
            if (pieceToMove.getColor() != Color.BLACK){
                return false;
            }
        }
        if (!pieceToMove.validMoving(start, end)) {
            if ((pieceToMove instanceof Pawn)){
                if (!(((Pawn) pieceToMove).validAttack(start, end))){
                    return false;
                }
            }else{
                return false;
            }
        } 
        if (!pieceToMove.differentColor(this.board[endLetter][endNumber])) {
            return false;
        }
        switch (pieceToMove.getType()) {
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
        if (!piece.differentColor(this.board[endLetter][endNumber])) {
            return false;
        }
        return true;
    }
    
    private boolean knightValidMove(int startLetter, int startNumber, int endLetter, int endNumber, Piece piece) {
        if (!piece.differentColor(this.board[endLetter][endNumber])) {
            return false;
        }
        return true;
    }
    
    private boolean pawnValidMove(int startLetter, int startNumber, int endLetter, int endNumber, Piece piece) {
        if (!piece.differentColor(this.board[endLetter][endNumber])) {
            return false;
        }
        if (piece.getColor() == Color.BLACK){
            if (endLetter - startLetter == 2){
                if (this.board[startLetter + 1][startNumber] != null || (startNumber != endNumber)){
                    return false;
                }
            }
            else if (startNumber == endNumber && this.board[endLetter][endNumber] != null) {
                return false;
            }
            else{
                if ((startNumber != endNumber) && (this.board[endLetter][endNumber] == null)){
                    return false;
                }
            }  
        }else{
            if (startLetter - endLetter == 2){
                if (this.board[startLetter - 1][startNumber] != null || (startNumber != endNumber)){
                    return false;
                }
            } 
            else if (startNumber == endNumber && this.board[endLetter][endNumber] != null) {
                return false;
            }
            else if ((startNumber != endNumber) && (this.board[endLetter][endNumber] == null)){
                    return false;
            }

            return true;

        }
        if (!piece.differentColor(this.board[endLetter][endNumber])) {
            return false;
        }
        return true;
    }
    
    private boolean queenValidMove(int startLetter, int startNumber, int endLetter, int endNumber, Piece piece) {
        if (!piece.differentColor(this.board[endLetter][endNumber])) {
            return false;
        }
        if (!this.rookValidMove(startLetter, startNumber, endLetter, endNumber, piece) && !this.bishopValidMove(startLetter, startNumber, endLetter, endNumber, piece)) {
            return false;
        }
        return true;
    }
    
    private boolean rookValidMove(int startLetter, int startNumber, int endLetter, int endNumber, Piece piece) {
        if (!piece.differentColor(this.board[endLetter][endNumber])) {
            return false;
        }
        if (startLetter == endLetter) { //Same row
            if (startNumber < endNumber) {
                for (int i = startNumber + 1; i < endNumber - 1; i++) {
                    if (this.board[startLetter][i] != null) {
                        return false;
                    }
                }
            }
            else {
                for (int i = endNumber + 1; i < startNumber - 1; i++) {
                    if (this.board[startLetter][i] != null) {
                        return false;
                    }
                }
            }
        }
        else {
            if (startLetter < endLetter) {
                for (int i = startLetter + 1; i < endLetter - 1; i++) {
                    if (this.board[i][startNumber] != null) {
                        return false;
                    }
                }
            }
            else {
                for (int i = endLetter + 1; i < startLetter - 1; i++) {
                    if (this.board[i][startNumber] != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean bishopValidMove(int startLetter, int startNumber, int endLetter, int endNumber, Piece piece) {
        if (!piece.differentColor(this.board[endLetter][endNumber])) {
            return false;
        }
        int letter = startLetter;
        int number = startNumber;
        if (startLetter < endLetter && startNumber < endNumber) {
            letter++;
            number++;
            while (letter < endLetter) {
                if (this.board[letter][number] != null) {
                    return false;
                }
                letter++;
                number++;
            }
        }
        else if (startLetter < endLetter && startNumber > endNumber) {
            letter++;
            number--;
            while (letter < endLetter) {
                if (this.board[letter][number] != null) {
                    return false;
                }
                letter++;
                number--;
            }
        }
        else if (startLetter > endLetter && startNumber > endNumber) {
            letter--;
            number--;
            while (letter < endLetter) {
                if (this.board[letter][number] != null) {
                    return false;
                }
                letter--;
                number--;
            }
        }
        else if (startLetter > endLetter && startNumber < endNumber) {
            letter--;
            number++;
            while (letter < endLetter) {
                if (this.board[letter][number] != null) {
                    return false;
                }
                letter--;
                number++;
            }
        }
        return true;
    }

    private boolean inCheck(boolean whiteTurn){
        Color color;
        List<Piece> otherTeam;
        if (whiteTurn) {
            color = Color.WHITE;
            otherTeam = this.black;
        }
        else {
            color = Color.BLACK;
            otherTeam = this.white;
        }
        int kingLetter = 0;
        int kingNumber = 0;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j] != null && this.board[i][j] instanceof King && this.board[i][j].getColor() == color) {
                    kingLetter = i;
                    kingNumber = j;
                }
            }
        }
        char charKL = (char)(kingLetter + 65);
        char charKN = (char)((kingNumber + 1) + '0');
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (otherTeam.contains(this.board[i][j])) {
                    char charI = (char)(i + 65);
                    char charJ = (char)((j + 1) + '0');
                    String string = String.valueOf(charI) + String.valueOf(charJ) + " to " + String.valueOf(charKL) + String.valueOf(charKN);
                    if (this.validMove(string)) {
                        return true;
                    } 
                }
            }
        }
        return false;
    }
    
    private boolean checkMate () {
        if (!inCheck(whiteTurn)){
            return false;
        }
        boolean temp;
        Color color;
        List<Piece> thisTeam;
        if (whiteTurn) {
            color = Color.WHITE;
            thisTeam = this.white;
        }
        else {
            color = Color.BLACK;
            thisTeam = this.black;
        }
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (thisTeam.contains(this.board[i][j])) {
                    char charI = (char)(i + 65);
                    char charJ = (char)((j + 1) + '0');
                    for (String spot: allMovesSpots){
                        String string = String.valueOf(charI) + String.valueOf(charJ) + " to " + spot;
                    if (this.validMove(string)) {
                        String end = string.substring(6);
                        int endLetter = (int)end.charAt(0) - 65;
                        Character endNumChar = end.charAt(1);
                        int endNumber = Character.getNumericValue(endNumChar);
                        Piece oldPiece = this.board[endLetter][endNumber];
                        move(string);
                        if (!inCheck(whiteTurn)){
                            undoMove(string, oldPiece);
                            return false;
                        }
                        // return true;
                    } 
                    }
                }
            }
        }
        return true;
    }
    
    private void printBoard() {
        System.out.print("      ");
        for (int i = 0; i < this.board.length; i++) {
            int toP = i + 1;    
            System.out.printf("%10s", toP);
            System.out.printf("%11s", " ");
        }
        System.out.println();
        for (int i = 0; i < this.board.length; i++) {
            System.out.print((char)((i + 65)) + "   ");
            for (int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j] != null) {
                    String str = this.board[i][j].getType() + ": " +  this.board[i][j].getColor();
                    double before = Math.ceil((20.0 - str.length()) / 2);
                    double after = Math.floor((20.0 - str.length()) / 2);
                    System.out.printf("%" + before + "s", " ");
                    System.out.print(this.board[i][j].getType() + ": " +  this.board[i][j].getColor());
                    System.out.printf("%" + after + "s", " ");
                }
                else {
                    System.out.printf("%20s", " ");
                }
                if (j != this.board[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            for (int t = 0; t < 171; t++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private void populateSet(){
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                char charI = (char)(i + 65);
                char charJ = (char)((j + 1) + '0');
                String toAdd = String.valueOf(charI) + String.valueOf(charJ);
                this.allMovesSpots.add(toAdd);
            }
        }
    }
}
