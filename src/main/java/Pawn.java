public class Pawn implements Piece {

    Color color; 
    public Pawn(Color color){
        // this.queen = new Piece(color);
        this.color = color;
    }
    
  @Override
    public boolean differentColor(Piece other) {
        return false;
    }

    @Override
    public boolean validMoving(String start, String end) {//not done. has to factor direction in. and for jumping 2
        char a = start.charAt(0);
        int a1 = (int)a - 65;
        char b = start.charAt(1);
        int a2 = (int)b;
        
        
        char c = end.charAt(0);
        int b1 = (int)a - 65;
        char d = end.charAt(1);
        int b2 = (int)b;

        if ((b2 != a2)){
            return false;
        }

        if (this.getColor() == Color.WHITE){

            if (a1 == 2){
                if ((b1 - a1) == 2){
                    return true;
                }
                return false;
            }else{
                if ((b1 - a1) == 1){
                    return true;
                }
                return false;
            }
        }else{
            if (a1 == 7){
                if ((b1 - a1) == -2){
                    return true;
                }
                return false;
            }else{
                if ((b1 - a1) == -1){
                    return true;
                }
                return false;
            }
        }

        // if (Math.abs(a1 - b1) == 2 )
        //  if (Math.abs(a1 - b1) > 1 || Math.abs(a2 - b2) > 1){
        //      return false;
        //  }
        //  return true;
    }


    public boolean validAttack(String start, String end) {
        return false;
    }

    @Override
    public String getType(){
        return this.getClass().toString();
    }

    @Override
    public Color getColor() {
        return null;
    }
    
}
