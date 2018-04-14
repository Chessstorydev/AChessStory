package com.ACS.ChessLibrary.Models;

import com.ACS.ChessLibrary.Interfaces.IPiece;

import com.ACS.ChessLibrary.Enumeration.*;


public class Pawn implements IPiece {
// These are the pawn class's parameters
    //They get created during class instantiation
    private PlayerColor color;

    private boolean hasMoved;


    //this is the Pawn class's constructor method
    //it gets called when the object is created

    public Pawn(PlayerColor importedColor){

        this.setColor(importedColor);
        this.setHasMoved(false);

    };



// these are the setter and getter methods for the above parameters
//since the above parameters are marked as private this is the only way any code outside of this class can see their value


    public void setColor (PlayerColor importedColor){
     this.color = importedColor;
    };
    public PlayerColor getColor(){

        return this.color;
    };

    public void setHasMoved (boolean importedHasMoved){

        this.hasMoved = importedHasMoved;
    };
    public boolean getHasMoved (){

    return this.hasMoved;
    };

}
