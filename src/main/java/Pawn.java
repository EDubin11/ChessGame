public class Pawn implements Piece {

  @Override
    public boolean differentColor(Piece other) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean validMoving(String start, String end) {//not done. has to factor direction in. and for jumping 2
        // TODO Auto-generated method stub
        char a = start.charAt(0);
        int a1 = (int)a - 65;
        char b = start.charAt(1);
        int a2 = (int)b;
        
        
        char c = end.charAt(0);
        int b1 = (int)a - 65;
        char d = end.charAt(1);
        int b2 = (int)b;

        if (this.getColor == Color.WHITE){
            if (a2 == 2){
                
            
            
            }else{

            
            
            }
        
        
        
        
        }else{

        }
        if (Math.abs(a1 - b1) == 2 )
         if (Math.abs(a1 - b1) > 1 || Math.abs(a2 - b2) > 1){
             return false;
         }
         return true;
    }


    public boolean validAttack(String start, String end) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getType(){
        return "Pawn";
    }

    @Override
    public Color getColor() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
