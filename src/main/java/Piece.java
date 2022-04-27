public abstract class Piece {
    private Color color;
    boolean differentColor(Piece other){
        if (other == null){
            return true;
        }
        return other.getColor() == other.getColor();
    }
    abstract boolean validMoving(String start, String end);
    Color getColor(){
        return this.color;
    }
    
    abstract String getType();
}