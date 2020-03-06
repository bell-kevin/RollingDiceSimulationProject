package rollingdicesimulation;

/******************************************************************************
 * RollingDiceSimulation.java 
 * Programmer: @author jcboyd
 * Version 1
 * This program simulates rolling dice a number of times specified by the user,
 * stores the results in an array, and displays the number of times for each
 * sum 
 *****************************************************************************/

import java.util.Scanner;

public class RollingDiceSimulation 
{
    public static void main(String[] args) 
    {
        //declarations
        Scanner stdIn = new Scanner(System.in);
        int numberSides;
        int numberDice;
        int possibleSums;
        int numberRolls;
        int countRolls = 0;
        int diceSum;
        int[][] rollResult;
        
        //input
        System.out.println("Dice Rolls by JC Boyd\n");
        System.out.print("How many sides on a die? ");
        numberSides = stdIn.nextInt();
        System.out.print("How many dice shall I roll? ");
        numberDice = stdIn.nextInt();
        System.out.print("How many times shall I roll the dice? ");
        numberRolls = stdIn.nextInt();

        //set up array
        possibleSums = (numberSides * numberDice) - numberDice + 1;
        rollResult = new int[possibleSums][2];
        for (int i = 0; i < possibleSums; i++)
        {
            rollResult[i][0] = numberDice + i; //create every possible sum
            rollResult[i][1] = 0; //set each counter to 0
        }
       
        //roll dice and record results
        for (int i = 0; i < numberRolls; i++) //repeat for number of rolls
        {
            diceSum = 0; //reset dice sum before rolling dice again
            for (int r = 0; r < numberDice; r++) //simulate separate dice rolls
            {
                diceSum += (int) (Math.random() * numberSides + 1);
            } //end for
            for (int f = 0; f < possibleSums; f++) //find sum in array and add 1
            {
                if (rollResult[f][0] == diceSum)
                {
                    rollResult[f][1]++;
                }
            } //end for
        } //end for
        
        //output
        System.out.println("Number of times each total occurred:");
        for (int i = 0; i < possibleSums; i++)
        {
            System.out.printf("result %-6d times rolled %-6d\n", 
                    rollResult[i][0], rollResult[i][1]);
            countRolls += rollResult[i][1];
        } 
        System.out.printf("Total = %d\n", countRolls);
         
    } //end main

} //end class RollingDiceSimulation
