public interface Piece {
    boolean differentColor(Piece other);
    boolean validMoving(String start, String end);
    Color getColor();
    String getType();
}