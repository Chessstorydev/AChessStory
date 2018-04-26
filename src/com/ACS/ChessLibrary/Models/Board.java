package com.ACS.ChessLibrary.Models;

import com.ACS.ChessLibrary.Interfaces.IPiece;
import com.ACS.ChessLibrary.Enumeration.PlayerColor;

public class Board {

    //This is the 2 Dimensional array that encompasses all of the game spaces on the game board.
    //******************************************************************************************
    //
    //
    //                      ALWAYS REFER TO THIS 2D ARRAY IN THE FORMAT OF
    //
    //                                      [ROW][COLUMN]
    //
    //
    //
    //******************************************************************************************
    private Space[][] theSpaces;

    //These will hold references to where the White King and the Black King are currently at in the gameboard.
    //This will make it easy to determine Check later on without unnecessary recursion.
    private IPiece whiteKing;
    private IPiece blackKing;

    //this is a simple variable to keep track of whose turn it is.
    private PlayerColor whoseTurn;

    public Board() {
        setWhoseTurn(PlayerColor.WHITE);
        Space[][] myFreshlyGeneratedSpaces = generateNewSpaces();
        setTheSpaces(myFreshlyGeneratedSpaces);
    }

    //This instantiates a new 2D array fo Space objects set up for a new game of chess.

    private Space[][] generateNewSpaces() {

        Space[][] spaces = new Space[8][8];

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                spaces[row][col] = new Space(this, row, col);
            }

        }
        for (int count = 0; count < 8; count++) {

            IPiece whitePawn = new Pawn(PlayerColor.WHITE, spaces[1][count]);
            spaces[1][count].setContents(whitePawn);

            IPiece blackPawn = new Pawn(PlayerColor.BLACK, spaces[6][count]);
            spaces[6][count].setContents(blackPawn);

            if (count == 0 || count == 7) {
                IPiece whiteRook = new Rook(PlayerColor.WHITE, spaces[0][count]);
                spaces[0][count].setContents(whiteRook);

                IPiece blackRook = new Rook(PlayerColor.BLACK, spaces[7][count]);
                spaces[7][count].setContents(blackRook);

            }
            if (count == 1 || count == 6) {
                IPiece whiteKnight = new Knight(PlayerColor.WHITE, spaces[0][count]);
                spaces[0][count].setContents(whiteKnight);

                IPiece blackKnight = new Knight(PlayerColor.BLACK, spaces[7][count]);
                spaces[7][count].setContents(blackKnight);

            }
            if (count == 2 || count == 5) {
                IPiece whiteBishop = new Bishop(PlayerColor.WHITE, spaces[0][count]);
                spaces[0][count].setContents(whiteBishop);

                IPiece blackBishop = new Bishop(PlayerColor.BLACK, spaces[7][count]);
                spaces[7][count].setContents(blackBishop);

            }
            if (count == 3) {
                IPiece whiteQueen = new Queen(PlayerColor.WHITE, spaces[0][count]);
                spaces[0][count].setContents(whiteQueen);

                IPiece blackQueen = new Queen(PlayerColor.BLACK, spaces[7][count]);
                spaces[7][count].setContents(blackQueen);

            }
            if (count == 4) {
                IPiece whiteKing = new King(PlayerColor.WHITE, spaces[0][count]);
                spaces[0][count].setContents(whiteKing);

                IPiece blackKing = new King(PlayerColor.BLACK, spaces[7][count]);
                spaces[7][count].setContents(blackKing);

            }
        }


        return spaces;

    }

    public void clearHighlighting()
    {

        //This method will need to use 2 for loops to iterate through all of the Spaces on the gameboard
        //and turn their Highlighting value to false;

        //we will do this from time to time, and this is a good helper method.

        //psuedocode:
        //get access to variable that refers to gameboard (already inside gameboard.java)
        // need to get the spaces
        // Need to iterate over every space
        // Need to set those spaces highlighted to false


        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                this.theSpaces[row][col].setHighlighted(false);
            }

        }
//
    }


    //region GS
    public PlayerColor getWhoseTurn() {
        return whoseTurn;
    }

    public void setWhoseTurn(PlayerColor whoseTurn) {
        this.whoseTurn = whoseTurn;
    }

    public Space[][] getTheSpaces() {
        return theSpaces;
    }

    public void setTheSpaces(Space[][] theSpaces)
    {
        this.theSpaces = theSpaces;
    }

    public IPiece getWhiteKing()
    {
        return whiteKing;
    }

    public void findWhiteKing() {
        

        //This method will need to navigate the SPACE[][] to find where the white king is and set the
        // 'this.whiteKing' = to that Space object.
        //Definitely read the article i sent you before this.

        //Pseudocode:
        // Get the spaces
        // Iterate through the spaces
        // check the contents of each space for the white king
        // if we find white king, set local variable to this space

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
               IPiece temp = this.theSpaces[row][col].getContents();
               if (temp != null){
                   if (temp.getColor() == PlayerColor.WHITE)
                   {
                       if (temp.getClass().getName() == "com.ACS.ChessLibrary.Models.King")
                       {
                          whiteKing = temp;
                          col = 8;
                          row = 8;
                       }
                   }
               }
            }
        }
    }

    public IPiece getBlackKing() {
        return blackKing;
    }

    public void findBlackKing() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                IPiece temp = this.theSpaces[row][col].getContents();
                if (temp != null){
                    if (temp.getColor() == PlayerColor.BLACK)
                    {
                        if (temp.getClass().getName() == "com.ACS.ChessLibrary.Models.King")
                        {
                            blackKing = temp;
                            col = 8;
                            row = 8;
                        }
                    }
                }
            }
        }

        //This method will need to navigate the SPACE[][] to find where the black king is and set the
        // 'this.blackKing' = to that Space object.
        //Definitely read the article i sent you before this.
    }

    //endregion

}

