package com.ACS;


import java.util.Scanner;

public class TestProgram {


    public static void main(String[] args) {
        // write your code here
Scanner inputScanner = new Scanner(System.in);
printMenu();
int myIntiger = inputScanner.nextInt();

//int myIntiger = 5;
//        System.out.println("Hello World");
      System.out.println(myIntiger);
//myIntiger = 7;
//        System.out.print(myIntiger);

    }


    public static void printMenu()
    {
        System.out.println("Welcome to the UI for the Chess Program");
        System.out.println("1: Display the Game");
        System.out.println("2: Make a Move");
        System.out.println("Please Make a Choice");


    }

}
