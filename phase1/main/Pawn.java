package main;
public class Pawn implements Piece {
    private Color color;

    public Pawn(Color color) {
        this.color = color;
    }
    
    @Override
    public void move(String start, String end) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public Piece attack(String start, String end) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    
    @Override
    public boolean differentColor(Piece other) {
        // TODO Auto-generated method stub
        return false;
    }
    
    
    @Override
    public boolean validMove(String start, String end) {
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
        return this.color;
    }
}
