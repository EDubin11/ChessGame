import java.lang.Math;
public class Bishop implements Piece {



    @Override
    public boolean differentColor(Piece other) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean validMoving(String start, String end) {
        // TODO Auto-generated method stub
       // return false;
       char a = start.charAt(0);
       int a1 = (int)a - 65;
       char b = start.charAt(1);
       int a2 = (int)b;
       
       
       char c = end.charAt(0);
       int b1 = (int)a - 65;
       char d = end.charAt(1);
       int b2 = (int)b;

       if (Math.abs(a1 - b1) != Math.abs(a2 - b2)) {
           return false;
       }
       return true;
    
    
    }



    @Override
    public Color getColor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getType(){
        return "Bishop";
    }
    
}
