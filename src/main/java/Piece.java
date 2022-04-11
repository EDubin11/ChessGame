public interface Piece {
    boolean differentColor(Piece other);
    boolean validMove(String start, String end);
    Color getColor();
    String getType();
}