public class Pawn extends Piece {

    Color color; 
    public Pawn(Color color){
        this.color = color;
    }


    @Override
    public boolean validMoving(String start, String end) {//not done. has to factor direction in. and for jumping 2
        char a = start.charAt(0);
        int a1 = ((int)a) - 65;
        char b = start.charAt(1);
        int a2 = Character.getNumericValue(b) - 1;
        
        
        char c = end.charAt(0);
        int b1 = ((int)c) - 65;
        char d = end.charAt(1);
        int b2 = Character.getNumericValue(d) - 1;

        if ((b2 != a2)){
            return false;
        }

        if (this.getColor() == Color.WHITE){

            if (a1 == 6){
                if ((b1 - a1) == -2){
                    return true;
                }
                if ((b1 - a1) == -1){
                    return true;
                }
                return false;
            }else{
                if ((b1 - a1) == -1){
                    return true;
                }
                return false;
            }
        }else{
            if (a1 == 1){
                if ((b1 - a1) == 2){
                    return true;
                }
                if ((b1 - a1) == 1){
                    return true;
                }
                return false;
            }else{
                if ((b1 - a1) == 1){
                    return true;
                }
                return false;
            }
        }
    }


    public boolean validAttack(String start, String end) {
        char a = start.charAt(0);
        int a1 = ((int)a) - 65;
        char b = start.charAt(1);
        int a2 = Character.getNumericValue(b) - 1;
        
        
        char c = end.charAt(0);
        int b1 = ((int)c) - 65;
        char d = end.charAt(1);
        int b2 = Character.getNumericValue(d) - 1;

        if (a2 == b2) {
            return false;
        }
        if(Math.abs(a2 - b2) > 1) {
            return false;
        }
        if (this.getColor() == Color.WHITE){

            if (a1 == 1){
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
        }else{
            if (a1 == 6){
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
        }
    }

    public Color getColor(){
        return this.color;
    }
    
    public String getType(){
        return "Pawn";
    }

}
