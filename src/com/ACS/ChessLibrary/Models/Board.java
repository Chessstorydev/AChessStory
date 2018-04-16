package com.ACS.ChessLibrary.Models;
import com.ACS.ChessLibrary.Interfaces.IPiece;
import com.ACS.ChessLibrary.Enumeration.PlayerColor;

public class Board {



    private Space[][] theSpaces;



    private PlayerColor whoseTurn;






public Board (){

    //whoseTurn is White to begin, need to set it to white
    // theSpaces needs to be filled up with 64 space objects,
    // and some of these space objects will need a piece
 setWhoseTurn(PlayerColor.WHITE);

 Space[][] myFreshlyGeneratedSpaces = generateNewSpaces();

 setTheSpaces(myFreshlyGeneratedSpaces);
}

public PlayerColor getWhoseTurn() {
        return whoseTurn;
    }

    public void setWhoseTurn(PlayerColor whoseTurn) {
        this.whoseTurn = whoseTurn;
    }

    public Space[][] getTheSpaces() {
        return theSpaces;
    }

    public void setTheSpaces(Space[][] theSpaces) {
        this.theSpaces = theSpaces;
    }

public Space[][] generateNewSpaces(){

Space[][] spaces = new Space[8][8];

for(int row = 0; row < 8; row ++)
{
    for(int col = 0; col < 8; col ++)
    {
     spaces [row][col] = new Space (row, col);
    }

}
for (int count =0; count < 8; count ++)
{

    IPiece whitePawn = new Pawn (PlayerColor.WHITE, spaces[1][count]);
    spaces [1][count].setContents(whitePawn);

    IPiece blackPawn = new Pawn (PlayerColor.BLACK, spaces[6][count]);
    spaces [6][count].setContents(blackPawn);

if (count == 0 || count == 7)
{ IPiece whiteRook = new Rook (PlayerColor.WHITE, spaces[0][count]);
    spaces [0][count].setContents(whiteRook);

    IPiece blackRook = new Rook (PlayerColor.BLACK, spaces[7][count]);
    spaces [7][count].setContents(blackRook);

}
    if (count == 1 || count == 6)
    { IPiece whiteKnight = new Knight (PlayerColor.WHITE, spaces[0][count]);
        spaces [0][count].setContents(whiteKnight);

        IPiece blackKnight = new Knight (PlayerColor.BLACK, spaces[7][count]);
        spaces [7][count].setContents(blackKnight);

    }
    if (count == 2 || count == 5)
    { IPiece whiteBishop = new Bishop (PlayerColor.WHITE, spaces[0][count]);
        spaces [0][count].setContents(whiteBishop);

        IPiece blackBishop = new Bishop (PlayerColor.BLACK, spaces[7][count]);
        spaces [7][count].setContents(blackBishop);

    }
    if (count == 3)
    { IPiece whiteQueen = new Queen (PlayerColor.WHITE, spaces[0][count]);
        spaces [0][count].setContents(whiteQueen);

        IPiece blackQueen = new Queen (PlayerColor.BLACK, spaces[7][count]);
        spaces [7][count].setContents(blackQueen);

    }
    if (count == 4)
    { IPiece whiteKing = new King (PlayerColor.WHITE, spaces[0][count]);
        spaces [0][count].setContents(whiteKing);

        IPiece blackKing = new King (PlayerColor.BLACK, spaces[7][count]);
        spaces [7][count].setContents(blackKing);

    }
}


    return spaces;

}





}

