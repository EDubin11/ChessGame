public interface Piece {
    boolean differentColor(Piece other);
    boolean validMove(String start, String end);
    boolean validAttack(String start, String end);
    Color getColor();
}