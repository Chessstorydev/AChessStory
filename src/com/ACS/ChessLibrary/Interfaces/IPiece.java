package com.ACS.ChessLibrary.Interfaces;
import com.ACS.ChessLibrary.Enumeration.*;
import com.ACS.ChessLibrary.Models.Board;

public interface IPiece {

    private void setColor (PlayerColor color){};

    public PlayerColor getColor();

    public void setHasMoved (boolean hasMoved);
    public boolean getHasMoved ();

    public int[][] getPossibleMoves(Board theGameBoard);
}
