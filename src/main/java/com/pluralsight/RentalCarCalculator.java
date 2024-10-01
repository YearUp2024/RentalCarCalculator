package com.pluralsight;

import java.util.Scanner;

//This function is calculating total cost for Resting a Car
public class RentalCarCalculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        //User Inputs
        String pickupDate = promptUserForPickUpDate("Enter pickup Date: ");
        short numberOfDays = promptUserForNumberOfDays("Enter Number of days you will rend the car for: ");
        boolean needsTolltag = promptUserForTooltag("Do you need an electronic toll tag at $3.95/day (yes/no)? ");
        boolean needsGPD = promptUserForTooltag("Do you need a GPS at $2.95/day (yes/no)? ");
        boolean needsRoadSideAssistance = promptUserForTooltag("Do you need roadside assistance at $3.95/day (yes/no)? ");
        short age = promptUserForAge("How old are you: ");

        //Calculating const's
        double basicCarRentalFee = 29.99 * numberOfDays;
        double totalOptionsFee = optionalFees(needsTolltag, needsGPD, needsRoadSideAssistance);
        double underAgeSurcharge = checkUserAge(age, basicCarRentalFee);
        double totalCost = basicCarRentalFee + totalOptionsFee + underAgeSurcharge;

        //Printing in the console
        System.out.println("");
        System.out.printf("Basic Car Rental fee:   %.2f\n", basicCarRentalFee);
        System.out.printf("Optional Fees:          %.2f\n", totalOptionsFee);
        System.out.printf("Underage Surcharge Fee: %.2f\n", underAgeSurcharge);
        System.out.println("------------------------------------------------");
        System.out.printf("Toal:                   %.2f\n", totalCost);
    }

    //This is getting Pickup date
    public static String promptUserForPickUpDate(String pickupDate){
        System.out.print(pickupDate);
        return scanner.nextLine();
    }

    //This is getting number of days the user wants to rent the car
    public static short promptUserForNumberOfDays(String numberOfDays){
        System.out.print(numberOfDays);
        return scanner.nextShort();
    }

    //This is getting if the user wants Tolltag, GPS and RoadSideAssistance
    public static boolean promptUserForTooltag(String arg){
        Scanner scanner = new Scanner(System.in);
        System.out.print(arg);
        String userAns = scanner.nextLine();
        return userAns.equalsIgnoreCase("Y") || userAns.equalsIgnoreCase("YES");
    }

    //This is getting User Age
    public static short promptUserForAge(String age){
        System.out.print(age);
        short userAge = scanner.nextShort();
        return userAge;
    }

    //This is calculating Total optional fee
    public static double optionalFees(boolean needsTolltag, boolean needsGPD, boolean needsRoadSideAssistance){
        double total = 0.0;
        double electronicTollTag = 3.95;
        double GPS = 2.95;
        double roadsideAssistanc = 3.95;

        if(needsTolltag == true){
            total += electronicTollTag;
        }
        if(needsGPD == true){
            total += GPS;
        }
        if(needsRoadSideAssistance == true){
            total += roadsideAssistanc;
        }
        return total;
    }

    //This is calculating Underage Surcharge
    public static double checkUserAge(short age, double basicCarRentalFee){
        double underageSurchage = 0;
        double BasicCarRentalSurcharge = 0.3;
        if(age < 25){
            underageSurchage = basicCarRentalFee * BasicCarRentalSurcharge;
        }
        return underageSurchage;
    }
}