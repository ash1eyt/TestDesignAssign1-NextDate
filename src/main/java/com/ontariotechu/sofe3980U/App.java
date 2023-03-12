package com.ontariotechu.sofe3980U;

import java.util.Scanner;

/**
 *Test Design Assignment 1: NextDate
 **/

public class App {

    public static void main(String[] args) {
        System.out.println("Please enter the year, month, and date in this order (yyyy mm dd). Please press enter after each input: ");
        Scanner scan = new Scanner(System.in);

        int year = scan.nextInt();              //Variables to keep the user input
        int month = scan.nextInt();
        int day = scan.nextInt();

        System.out.println("The calculated next date is: " + NextDate(year, month, day));   //Returns next date using function
    }

    public static String NextDate(int year, int month, int day) {       //NextDate function

        String ret_nextdate;            //String variable to return the next date

        boolean leap = false;           //Boolean variable for the leap year

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)    //If the conditions are true, the leap variable is set to true
            leap = true;

        if (year < 1812 || year > 2212) {           //Making sure it's in the correct year interval

            System.out.println("Invalid year value.");
            return "Invalid year value.";
        } else if (month < 1 || month > 12) {           //Making sure a valid month value has been added

            System.out.println("Invalid month value.");
            return "Invalid month value.";
        } else if (day < 1 || day > 31) {              //Making sure a valid day value has been added

            System.out.println("Invalid day value.");
            return "Invalid day value.";
        }

        if ((month == 4 || month == 6 || month == 9 || month == 11) && (day > 30)) {     //Checking for invalid values for months that have 30 days
            System.out.println("Invalid day for specified months.");
            return "Invalid day for specified months.";
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day == 30)) {    //The next date for these months if '30' is inputted is the next month

            month = month + 1;
            day = 1;

        } else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) && (day == 31)) {    //Months that have 31 days

            month = month + 1;
            day = 1;
        } else if (month == 12 && day == 31 && year == 2212) {      //If user inputs Dec 31, 2212, statement will be printed out as next date is not in the interval

            System.out.println("Next date is not within the interval.");
            return "Next date is not within the interval.";
        }

        else if (month == 12 && day == 31) {        //If value of Dec 31 is given, the next date will be Jan 1 of the next year
            month = 1;
            day = 1;
            year = year + 1;}

        else if (leap && month == 2 && day == 28)   //If it is Feb 28 of a leap year, the day will be incremented
            day = day + 1;

        else if (!leap && month == 2 && day == 28) {    //If it is Feb 28 of a non-leap year, next date will be the first of next month
            day = 1;
            month = month + 1;

        } else if (leap && month == 2 && day > 29){     //If a value greater than 29 is given for the day for Feb, a statement will be printed out

            System.out.println("Invalid day for leap year.");
            return "Invalid day for leap year.";

        } else if (!leap && month == 2 && day > 28){        //If a value greater than 28 is given for the day for Feb (non leap year), statement will be printed

            System.out.println("Invalid day, no leap year.");
            return "Invalid day, no leap year.";
        }

        else if (leap && month == 2 && day == 29) {     //If it is Feb 29 of a leap year, next date will be the first of next month
            day = 1;
            month = month + 1;
        }
        else                                            //Otherwise, increment the day by 1
            day = day + 1;

        ret_nextdate = year + " " + month + " " + day;      //Return the year, month, and day of the next date
        return ret_nextdate;
    }
}

