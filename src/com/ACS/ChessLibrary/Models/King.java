package com.ACS.ChessLibrary.Models;

import com.ACS.ChessLibrary.Interfaces.IPiece;

import com.ACS.ChessLibrary.Enumeration.*;


public class King implements IPiece {
    // These are the king class's parameters
    //They get created during class instantiation
    private PlayerColor color;
    private boolean hasMoved;
    private Space mySpace;

    //this is the King class's constructor method
    //it gets called when the object is created

    public King (PlayerColor importedColor, Space mySpace){

        this.setColor(importedColor);
        this.setHasMoved(false);
        this.setMySpace(mySpace);

    }

    public void highlightPossibleMoves() {
        //TODO NEIL 3

        Board myGameBoard = mySpace.getMyGame();

        int row = mySpace.getRow();
        int col = mySpace.getCol();

        Space[][] boardSpaces = myGameBoard.getTheSpaces();

        if( boardSpaces[row+1][col].getContents() == null)
        {

            boardSpaces[row+1][col].setHighlighted(true);
            }

        if( boardSpaces[row+1][col+1].getContents() == null)
        {

            boardSpaces[row+1][col+1].setHighlighted(true);
        }

        if( boardSpaces[row+1][col-1].getContents() == null)
        {

            boardSpaces[row+1][col-1].setHighlighted(true);
        }
        if( boardSpaces[row][col+1].getContents() == null)
        {

            boardSpaces[row][col+1].setHighlighted(true);
        }
        if( boardSpaces[row][col-1].getContents() == null)
        {

            boardSpaces[row][col-1].setHighlighted(true);
        }
        if( boardSpaces[row-1][col].getContents() == null)
        {

            boardSpaces[row-1][col].setHighlighted(true);
        }
        if( boardSpaces[row-1][col+1].getContents() == null)
        {

            boardSpaces[row-1][col+1].setHighlighted(true);
        }
        if( boardSpaces[row-1][col-1].getContents() == null)
        {

            boardSpaces[row-1][col-1].setHighlighted(true);
        }

// these are the setter and getter methods for the above parameters
//since the above parameters are marked as private this is the only way any code outside of this class can see their value

    //region Getters and Setters
    private void setColor (PlayerColor importedColor){
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
    }

    public Space getMySpace() {
        return mySpace;
    }

    public void setMySpace(Space mySpace) {
        this.mySpace = mySpace;
    }

//endregion




}
