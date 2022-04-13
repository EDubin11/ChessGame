public class Knight implements Piece {

    Color color; 
    public Knight(Color color){
        // this.queen = new Piece(color);
        this.color = color;
    }

    @Override
    public boolean differentColor(Piece other) {
        return false;
    }

    @Override
    public boolean validMoving(String start, String end) {
        char a = start.charAt(0);
       int a1 = (int)a - 65;
       char b = start.charAt(1);
       int a2 = (int)b;
       
       
       char c = end.charAt(0);
       int b1 = (int)a - 65;
       char d = end.charAt(1);
       int b2 = (int)b;
        
        if (Math.abs(a1 - b1) == 1 && Math.abs(a2 - b2) == 2){
            return true;
        }else if (Math.abs(a1 - b1) == 2 && Math.abs(a2 - b2) == 2){
            return true;
        }else{
            return false;
        }

        //return false;
    }

    @Override
    public String getType(){
        return "Knight";
    }

    @Override
    public Color getColor() {
        return null;
    }
    
}
