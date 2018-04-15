package com.ACS.ChessLibrary.Models;

import com.ACS.ChessLibrary.Interfaces.*;

public class Space {

    //region Parameters
    private IPiece contents;
    private boolean highlighted;
    private boolean inDanger;

    private int row;
    private int col;
    //endregion

    //region Constructors
    public Space(int row, int col)
    {
        setHighlighted(false);

    }
    //endregion

    //region Getters and Setters
    public void setContents(IPiece newContents)
    {
        this.contents = newContents;
    }
    public IPiece getContents()
    {
        return this.contents;
    }

    public void setHighlighted(boolean value)
    {
        this.highlighted = value;
    }

    public boolean getHighlighted()
    {
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

    public boolean isInDanger() {
        return inDanger;
    }

    public void setInDanger(boolean inDanger) {
        this.inDanger = inDanger;
    }

    //endregion

}
