public class Pawn extends Piece {

    Color color; 
    public Pawn(Color color){
        this.color = color;
    }

<<<<<<< HEAD
=======
  @Override
    public boolean differentColor(Piece other) {
        return false;
    }
>>>>>>> bb98d0a26f2f94661c3ef3ac9b89045700fd370a

    @Override
    public boolean validMoving(String start, String end) {//not done. has to factor direction in. and for jumping 2
        char a = start.charAt(0);
       int a1 = (int)a - 65;
       char b = start.charAt(1);
       int a2 = Character.getNumericValue(b) - 1;
       
       
       char c = end.charAt(0);
       int b1 = (int)a - 65;
       char d = end.charAt(1);
       int b2 = Character.getNumericValue(d) - 1;

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
    }


    public boolean validAttack(String start, String end) {
        return false;
    }

    
    public String getType(){
        return this.getClass().toString();
    }
<<<<<<< HEAD
=======

    @Override
    public Color getColor() {
        return null;
    }
>>>>>>> bb98d0a26f2f94661c3ef3ac9b89045700fd370a
    
}
