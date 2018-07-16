package com.anu.app;

import java.util.*;

public class ATM{

    public static Scanner kbd = new Scanner(System.in);
   // private AccountService accountService;


    public static int menu()
    {
        int menuChoice;
        do
        {
            System.out.print("\nPlease Choose From the Following Options:"
                    + "\n 1. Display Balance \n 2. Deposit"
                    + "\n 3. Withdraw\n 4. Log Out\n\n");

            menuChoice = kbd.nextInt();

            if (menuChoice < 1 || menuChoice > 4){
                System.out.println("error");
            }

        }while (menuChoice < 1 || menuChoice > 4);

        return menuChoice;
    }

    public static void displayBalance(double x)
    {
        System.out.printf("\nYour Current Balance is $%.2f\n", x);
    }

    public static double deposit(double x, double y)
    {
        double depositAmt = y, currentBal = x;
        double newBalance = depositAmt + currentBal;

        System.out.printf("Your New Balance is $%.2f\n",  newBalance);

        return newBalance;
    }

    public static double withdraw(double x, double y)
    {
        double withdrawAmt = y, currentBal = x, newBalance;


        newBalance = currentBal - withdrawAmt;
        System.out.printf("Your New Balance is %.2f\n",newBalance);

        return newBalance;
    }

    public static void main(String[] args) {
System.out.println("Modulo ----"+235/50);
        String accNum, pass, origBal = "error";
        int count = 0, menuOption = 0;
        double depositAmt = 0, withdrawAmt = 0, currentBal=0;
        boolean  foundNonDigit;
        //loop that will count the number of login attempts
        //you make and will exit program if it is more than 3.
        //as long as oriBal equals an error. 
       // AccountServiceImpl accountService
        do{
            foundNonDigit = false;
            System.out.println("Please Enter Your Account Number: ");
            accNum = kbd.next();

            System.out.println("Enter Your Password: ");
            pass = kbd.next();

//            origBal = .

            count++;

            if (count >= 3 && origBal.equals("error")){
                System.out.print("Maximum Login Attempts Reached.");
                System.exit(0);
            }
            if (!(origBal.equals("error"))){
                System.out.println("\nYour New Balance is: $ "+ origBal);
            }
            else
                System.out.println(origBal);


        }while(origBal.equals("error"));

        currentBal=Double.parseDouble(origBal);
        //this loop will keep track of the options that 
        //the user inputs in for the menu. and will 
        //give the option of deposit, withdraw, or logout.

        while (menuOption != 4)
        {
            menuOption=menu();
            switch (menuOption)
            {
                case 1:
                    displayBalance(currentBal);
                    break;
                case 2:
                    System.out.print("\nEnter Amount You Wish to Deposit: $ ");
                    depositAmt = kbd.nextDouble();
                    currentBal=deposit(depositAmt, currentBal);
                    break;
                case 3:
                    System.out.print("\nEnter Amount You Wish to Withdrawl: $ ");
                    withdrawAmt = kbd.nextDouble();

                    while(withdrawAmt>currentBal){
                        System.out.print("ERROR: INSUFFICIENT FUNDS!! "
                                + "PLEASE ENTER A DIFFERENT AMOUNT: $");
                        withdrawAmt = kbd.nextDouble();
                    }

                    currentBal = withdraw(currentBal, withdrawAmt);
                    break;
                case 4:
                    System.out.print("\nThank For Using My ATM.  Have a Nice Day.  Good-Bye!");
                    System.exit(0);
                    break;
            }
        }
    }
}