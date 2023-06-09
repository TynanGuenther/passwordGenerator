package org.example;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Your Password is: " + passgen());
    }

    private static String passgen(){
        final String UpperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String LowerChars = "abcdefghijklmnopqrstuvwxyz";
        final String Numbers = "1234567890";
        final String SpecialChars = "!@#$%^&*()?-_+=";
        String password = "";
        int length = length("How long do you want the password?");
        System.out.println("Answer the following questions with either 'y' for yes or 'n' for no.");
        boolean lower = option(Options.LOWER);
        boolean upper = option(Options.UPPER);
        boolean special = option(Options.SPECIAL);
        boolean number = option(Options.NUMBER);

        if(!lower && !upper && !special && !number){
            System.out.println("Since you didn't choose yes on any of the options I will make a password for you myself!\n");
            return dumbPass();
        }
        String possibleChars = "";
        if(lower){
            possibleChars = possibleChars + (LowerChars);
        }
        if(upper){
            possibleChars = possibleChars + (UpperChars);
        }
        if(number){
            possibleChars = possibleChars + (Numbers);
        }
        if(special){
            possibleChars = possibleChars + (SpecialChars);
        }
        Random rand = new Random();
        for(int i = 0; i<length; i++){
            char n = possibleChars.charAt(rand.nextInt(possibleChars.length()));
            password = password + n;
        }

        return password;
    }

    private static boolean option(Options op){
        switch (op){
            case LOWER -> System.out.println("Do you want lower case letters?");
            case UPPER -> System.out.println("Do you want upper case letters?");
            case NUMBER -> System.out.println("Do you want numbers?");
            case SPECIAL -> System.out.println("Do you want special characters?");
        }
        String scan = scanner.nextLine();
        boolean val = false;
        if(scan.equals("y")){
            val = true;
        } else if (scan.equals("n")) {
            val = false;
        } else{
            System.out.println("Please make sure your answer is only a 'y' for yes or a 'n' for no. Try again.");
            option(op);
        }
        return val;
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

    private static String dumbPass(){
        Random rand = new Random();
        String[] dumbPasses = {"12345", "Password", "Password123", "default", "1"};
        int dum = rand.nextInt(dumbPasses.length);
        return dumbPasses[dum];
    }
}