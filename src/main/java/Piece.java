public abstract class Piece {
    boolean differentColor(Piece other){
        return other.getColor() == other.getColor();
    }
    abstract boolean validMoving(String start, String end);
    Color getColor(){
        return this.getColor();
    }
    String getType(){
        return this.getClass().toString();
    }
}