public class Rook extends Piece {
    Color color; 
    public Rook(Color color){
        this.color = color;
    }



    @Override
    public boolean validMoving(String start, String end) {
        //B3 -> [][]
        
        char a = start.charAt(0);
        int a1 = ((int)a) - 65;
        char b = start.charAt(1);
        int a2 = Character.getNumericValue(b) - 1;
        
        
        char c = end.charAt(0);
        int b1 = ((int)c) - 65;
        char d = end.charAt(1);
        int b2 = Character.getNumericValue(d) - 1;

        if ((a1 != b1) && (a2 != b2)) {
            return false;
        }
        return true;
    }

    public Color getColor(){
        return this.color;
    }

    public String getType(){
        return "Rook";
    }


}
