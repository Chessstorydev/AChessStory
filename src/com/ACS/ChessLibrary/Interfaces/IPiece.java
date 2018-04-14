package com.ACS.ChessLibrary.Interfaces;
import com.ACS.ChessLibrary.Enumeration.*;

public interface IPiece {

    public void setColor (PlayerColor color);
    public PlayerColor getColor();

    public void setHasMoved (boolean hasMoved);
    public boolean getHasMoved ();


}
