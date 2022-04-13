public class Queen extends Piece {
    Color color; 

    public Queen(Color color){
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
    public boolean validMoving(String start, String end) {
        // if (Rook.validMoving(start, end) || Bishop.validMoving(start, end)) {
        //     return truel;
        // }

        char a = start.charAt(0);
       int a1 = (int)a - 65;
       char b = start.charAt(1);
       int a2 = Character.getNumericValue(b) - 1;
       
       
       char c = end.charAt(0);
       int b1 = (int)a - 65;
       char d = end.charAt(1);
       int b2 = Character.getNumericValue(d) - 1;

        if ((a1 != b1) && (a2 != b2)) {
            return true;
        }else if (Math.abs(a1 - b1) == Math.abs(a2 - b2)){
            return true;
        }else{
            return false;
        }

        // if (Math.abs(a1 - b1) != Math.abs(a2 - b2)) {
        //     return false;
        // }



        // // TODO Auto-generated method stub
        // return false;
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
