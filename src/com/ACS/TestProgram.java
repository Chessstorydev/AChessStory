package com.ACS;

import com.ACS.ChessLibrary.Interfaces.IPiece;
import com.ACS.ChessLibrary.Models.*;
import com.ACS.ChessLibrary.Enumeration.PlayerColor;

import java.util.Scanner;

public class TestProgram {

    public static Board theGame;
    public static void main(String[] args) {
        // write your code here

        int choice = 0;
        theGame = new Board();
        while(true)
        {
            try {

                System.out.println("Welcome to shitty UI for chess program!");
                System.out.println("1: Make a move");
                System.out.println("2: Display gameBoard");
                System.out.println("3: Clear highlighting");
                Scanner scan = new Scanner(System.in);
                choice = scan.nextInt();

                if (choice == 1) {
                    makeAMove();
                } else if (choice == 2) {
                    displayGame();
                } else if (choice == 3) {
                    theGame.clearHighlighting();
                }
            }
            catch(Exception e)
            {
                System.out.println("You done fucked up");
                System.out.println (e.getCause());
            }
        }
//        System.out.println("hello");
//        int myvariable = 5;
//        System.out.println(myvariable);
//        System.out.println(testMethod());
//
//        Board gameBoard = new Board();
//
//        for(int i = 0; i > 8; i ++)
//        {
//            System.out.println("my value of I is: " + i);
//
//        }
       /* Pawn myPawn = new Pawn(PlayerColor.WHITE);
        System.out.println(myPawn.getColor());

        myPawn = new Pawn(PlayerColor.BLACK);
        System.out.println(myPawn.getColor());*/
    }


    public static void makeAMove()
    {
System.out.println("Please enter row");
        Scanner scan = new Scanner(System.in);
        int rowChoice = scan.nextInt();

        System.out.println("Please enter column");
        int colChoice = scan.nextInt();

        Space[][] theSpaces = theGame.getTheSpaces();
        IPiece myContents = theSpaces [rowChoice][colChoice].getContents();
        myContents.highlightPossibleMoves();
    }

    public static void displayGame()
    {
        Space[][] theSpaces = theGame.getTheSpaces();
        for(int i = 0; i < 33; i ++ )
      {
          System.out.print("-");
      }
      System.out.println();
      for(int i = 0; i < 8; i ++)
      {

          for(int j = 0; j< 8; j++)
          {
              String  piece = " ~";
              if(theSpaces[Math.abs(i-7)][j].getContents() != null)
              {
                  IPiece thePiece = theSpaces[Math.abs(i-7)][j].getContents();
                  switch(thePiece.getClass().getName())
                  {
                      case "com.ACS.ChessLibrary.Models.Pawn":
                          piece = "P";
                          break;
                      case "com.ACS.ChessLibrary.Models.Rook":
                          piece = "R";
                          break;
                      case "com.ACS.ChessLibrary.Models.Knight":
                          piece = "K";
                          break;
                      case "com.ACS.ChessLibrary.Models.Bishop":
                          piece = "B";
                          break;
                      case "com.ACS.ChessLibrary.Models.Queen":
                          piece = "Q";
                          break;
                      case "com.ACS.ChessLibrary.Models.King":
                          piece = "X";
                          break;


                      //.equals("com.ACS.ChessLibrary.Models.Pawn"));
                  }
                  if(thePiece.getColor() == PlayerColor.BLACK)
                  {
                      piece = "B" + piece;
                  }
                  else
                  {
                      piece = "W" + piece;
                  }


              }

              if(theSpaces[Math.abs(i-7)][j].getHighlighted() == true)
              {
                  piece = piece + "H";
              }
              if(piece.length() == 3)
              {
                  System.out.print("|" + piece);
              }
              else
              {
                  System.out.print("|" + piece + "\t");
              }

          }
          System.out.println("|");
          for(int k = 0; k < 33; k ++ )
          {
              System.out.print("-");
          }
          System.out.println();
      }
      System.out.println("\n\n");

    }




}
