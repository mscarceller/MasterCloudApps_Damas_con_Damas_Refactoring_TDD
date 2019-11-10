package draughts.models;

class Turn {

    private Color color;

    Turn(){
        this.setInitialTurn();
    }

    void change(){
        this.color = Color.values()[(this.color.ordinal()+1)%2];
    }

    void setInitialTurn(){
        this.color = Color.WHITE;
    }

    public Color getColor() {
		return this.color;
    }
    
}