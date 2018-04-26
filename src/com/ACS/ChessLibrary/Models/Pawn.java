package com.ACS.ChessLibrary.Models;

import com.ACS.ChessLibrary.Interfaces.IPiece;

import com.ACS.ChessLibrary.Enumeration.*;


public class Pawn implements IPiece {
    // These are the pawn class's parameters
    //They get created during class instantiation
    private PlayerColor color;
    private boolean hasMoved;
    private Space mySpace;

    //this is the Pawn class's constructor method
    //it gets called when the object is created

    public Pawn(PlayerColor importedColor, Space mySpace){

        this.setColor(importedColor);
        this.setHasMoved(false);
        this.setMySpace(mySpace);

    };


    //This method will be invoked when we need to identify where a particular piece is capable of moving.
    //It will refer to the attached Space, and the Space's reference to the GameBoard object.
    //With this information, it will calculate all possible moves that can be made for this piece

    //It will disregard if a move puts your own team into check, as that will be checked later in a different location.
    //
    // I will also disregard en passant for now, as that involes some additional information being added to a 'piece'
    // (i.e. just moved...cant en passant a pawn that wasn't moved on the turn before).  We hadnle this later.
    //
    //All this method needs to do is:

    //Identify color (as since its a pawn, this tells us whether it can move UP the board (increasing the row index)
    // or DOWN the board (decreasing hte row index).
    //Find the applicable squares it can move (taking into account first move being 2 spaces, and diagonal captures
    public void highlightPossibleMoves() {
        //First, lets get a reference to our GameBoard so we can look at it.
        Board myGameBoard = mySpace.getMyGame();

        //Next, lets find the row/col of this piece by asking the Space object.
        int row = mySpace.getRow();
        int col = mySpace.getCol();

        //Lastly, lets pull the Space[][] from the gameBoard so that we can make some decisions and highlight some squares.
        Space[][] boardSpaces = myGameBoard.getTheSpaces();

        //we have one main 'branch' here.  If we are white, we need to move 'UP'.  Else, we need to move 'Down.  None of your classes
        //will have to worry about this and will instead make all decisions the same.
        if(this.getColor() == PlayerColor.WHITE)
        {
            if(row == 1)
            {
                //This means the pawn is still on its base row, so lets check if we can move 2 spaces.
                if( boardSpaces[row+1][col].getContents() == null && boardSpaces[row+2][col].getContents() == null)
                {
                    //If both spaces in front of me are empty, i can move there, so highlight it.
                    boardSpaces[row+2][col].setHighlighted(true);
                }
            }

            //for all other possible moves, we have the 3 moves of ROW+1, ROW+1 and COL+1, and ROW+1 and COL-1;
            //But we have to make sure i dont go outside the bounds of the array (aka, try to evaluate a space that doenst fall
            //in our 8x8 game board).

            if(row < 7 &&  boardSpaces[row+1][col].getContents() == null)
            {
                //We arent on the last row, and the space in front of me is empty.  Highlight it and then check for diagonals.
                boardSpaces[row+1][col].setHighlighted(true);

                if(col>0 && boardSpaces[row+1][col-1].getContents() != null && boardSpaces[row+1][col-1].getContents().getColor() == PlayerColor.BLACK)
                {
                    //The above is a 3 part if statement. Since they are all 'ANDS', the first to fail will prevent the others from being executed, otherwise we would run into problems.
                    //Boils down to

                    //If we arent on the LEFT edge of the board from whites perspective
                    //AND
                    //If the Diagonal LEFT space has a piece in it
                    //AND
                    //IF that piece is black
                    //THEN
                    //I can take that piece.
                    boardSpaces[row+1][col-1].setHighlighted(true);
                }

                if(col < 7 && boardSpaces[row+1][col+1].getContents() != null && boardSpaces[row+1][col+1].getContents().getColor() == PlayerColor.BLACK)
                {
                    //This does the same except its checking to make sure we arent on the right edge of hte board from whites perspective.

                    boardSpaces[row+1][col+1].setHighlighted(true);
                }

            }
        }
        //This is an ELSE statement.  It is attached to the IF statement in that, if the if statement evaluates to false
        //the ELSE statement is guaranteed to execute.
        //Since our color can only be 2 values (white or black), we use an IF ELSE.

        //This one does the same as above, without the comments. the ROW values are flipped from Positive to Negative 1s, since the
        //pawn can move the same basic way, just in the opposite direction.
        else
        {
            if(row == 6)
            {
                if( boardSpaces[row-1][col].getContents() == null && boardSpaces[row-2][col].getContents() == null)
                {
                    boardSpaces[row-2][col].setHighlighted(true);
                }
            }
            if(row < 7 &&  boardSpaces[row-1][col].getContents() == null)
            {
                boardSpaces[row-1][col].setHighlighted(true);

                if(col>0 && boardSpaces[row-1][col-1].getContents() != null && boardSpaces[row-1][col-1].getContents().getColor() == PlayerColor.BLACK)
                {
                    boardSpaces[row-1][col-1].setHighlighted(true);
                }

                if(col < 7 && boardSpaces[row+1][col+1].getContents() != null && boardSpaces[row+1][col+1].getContents().getColor() == PlayerColor.BLACK)
                {
                    boardSpaces[row-1][col+1].setHighlighted(true);
                }

            }
        }

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
