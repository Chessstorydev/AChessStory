package com.ACS;

import com.ACS.ChessLibrary.Models.*;
import com.ACS.ChessLibrary.Enumeration.PlayerColor;

public class TestProgram {


    public static void main(String[] args) {
        // write your code here

        System.out.println("hello");
        int myvariable = 5;
        System.out.println(myvariable);
        System.out.println(testMethod());

        Pawn myPawn = new Pawn(PlayerColor.WHITE);
        System.out.println(myPawn.getColor());

        myPawn = new Pawn(PlayerColor.BLACK);
        System.out.println(myPawn.getColor());
    }


    public static int testMethod()
    {


        return 2;

    }


}
