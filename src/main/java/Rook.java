public class Rook implements Piece {
    Color color; 
    public Rook(Color color){
        // this.queen = new Piece(color);
        this.color = color;
    }


 @Override
    public boolean differentColor(Piece other) {
        return false;
    }

    @Override
    public boolean validMoving(String start, String end) {
        //B3 -> [][]
        
        char a = start.charAt(0);
        int a1 = (int)a - 65;
        char b = start.charAt(1);
        int a2 = (int)b;
        
        
        char c = end.charAt(0);
        int b1 = (int)a - 65;
        char d = end.charAt(1);
        int b2 = (int)b;

        if ((a1 != b1) && (a2 != b2)) {
            return false;
        }
        return true;
    }


    @Override
    public String getType(){
        return "Rook";
    }

    @Override
    public Color getColor() {
        return null;
    }
    
}
