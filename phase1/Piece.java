public interface Piece {
    enum Color {
        WHITE,
        BLACK
    }
    void move(String start, String end);
    Piece attack(String start, String end);
    boolean differentColor(Piece other);
    boolean validMove(String start, String end);
    boolean validAttack(String start, String end);
}