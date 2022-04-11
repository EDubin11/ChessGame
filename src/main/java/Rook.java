public class Rook implements Piece {
 @Override
    public boolean differentColor(Piece other) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean validMove(String start, String end) {
        B3 -> [][]
        
        char a = start.charAt(0);
        int a1 = (int)a - 65;
        char b = start.charAt(1);
        int a2 = (int)b;


        

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean validAttack(String start, String end) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Color getColor() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
