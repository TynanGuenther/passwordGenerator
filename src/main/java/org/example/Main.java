package org.example;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


    }

    private static String passgen(){
        String password = "";
        int length = length("How long do you want the password?");
        System.out.println("Answer the following questions with either 'y' for yes or 'n' for no.");
        boolean lower = option(Options.LOWER);
        boolean upper = option(Options.UPPER);
        boolean special = option(Options.SPECIAL);
        boolean number = option(Options.NUMBER);

        if(!lower && !upper && !special && !number){
            System.out.println("Since you didn't choose yes on any of the options I will make a password for you myself");
            password = dumbPass();
        }

    }

    private static boolean option(Options op){
        switch (op){
            case LOWER -> System.out.println("Do you want lower case letters?");
            case UPPER -> System.out.println("Do you want upper case letters?");
            case NUMBER -> System.out.println("Do you want numbers?");
            case SPECIAL -> System.out.println("Do you want special characters?");
        }
        String ret = scanner.nextLine();
        if(ret == "y"){
            return true;
        } else if (ret == "n") {
            return false;
        }
        else{
            System.out.println("Please make sure your answer is only a 'y' for yes or a 'n' for no. Try again.");
            option(op);
        }
    }
    private static int length(String question){
        System.out.println(question);
        int l = 0;
        String lengthS = scanner.nextLine();
        try{
            l = Integer.parseInt(lengthS);
        }catch (NumberFormatException ex){
            length("Your answer must be an integer. Please try again.");
        }
        if(l < 1){
            length("Your answer must be greater than 1. Please try again.");
        }
        return l;
    }

    private static String dumPass(){

    }
}