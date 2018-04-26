package com.ACS.ChessLibrary.Models;

import com.ACS.ChessLibrary.Interfaces.*;

public class Space {

    //region Parameters

    //Each individual space will have a reference to the GameBoard that it resides in.
    private Board myGame;

    //Each individual space will have a few pieces of information that contain what its 'state' is
    //contents obviously refers to what piece it has (null == empty),
    private IPiece contents;
    //highlighted will refer to a potential locaiton for a piece to move when its a players turn and they click the piece for the first time
    private boolean highlighted;

    //selected will be used to dictate when a player clicks a specific piece on the game board to bring up information about it,
    //and temporarily lock clicks aroudn the screen until they un-select it.
    private boolean selected;

    //refers to position of the space in the gameboard, always referred via
    // [row][col]

    private int row;
    private int col;
    //endregion

    //region Constructors
    public Space(Board theBoard, int row, int col) {
        setMyGame(theBoard);
        setHighlighted(false);
        setRow(row);
        setCol(col);
    }
    //endregion

    //region Getters and Setters
    public void setContents(IPiece newContents) {
        this.contents = newContents;
    }

    public IPiece getContents() {
        return this.contents;
    }

    public void setHighlighted(boolean value) {
        this.highlighted = value;
    }

    public boolean getHighlighted() {
        return this.highlighted;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Board getMyGame() {
        return myGame;
    }

    public void setMyGame(Board myGame) {
        this.myGame = myGame;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    //endregion

}
