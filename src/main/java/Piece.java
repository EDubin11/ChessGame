public abstract class Piece {
    private Color color;
    boolean differentColor(Piece other){
        return other.getColor() == other.getColor();
    }
    abstract boolean validMoving(String start, String end);
    Color getColor(){
        return this.color;
    }
    
    String getType(){
        return this.getClass().toString();
    }
}