package com.williams.kailyn;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

public class Main {
    private static Scanner StringKeyboard= new Scanner(System.in);
    private static Scanner intKeyboard= new Scanner(System.in);
    private static int answer=0;
    public static void main(String[] args) {
        ListOfRoutes routeList1 = new ListOfRoutes("Spartanburg");
        ListOfRoutes routeList2= new ListOfRoutes("Greenville");
        System.out.println("Who is your delivery man/lady for the day?");
        String deliveryDriver= StringKeyboard.nextLine();
        System.out.println("\nWelcome "+ deliveryDriver+"! ");
        System.out.println("Do you want to drive in Greenville or Spartanburg today?(1= Greenville || 2= Spartanburg)");

            while(answer!=1||answer!=2) {
                answer = intKeyboard.nextInt();
                if (answer == 1) {
                    greenVilleList(routeList2);
                    packageDelivery(routeList2);
                } else if (answer == 2) {
                    spartanburgList(routeList1);
                    packageDelivery(routeList1);
                } else
                    System.out.println("Please select the following numbers");

}


    }

    private static void spartanburgList(ListOfRoutes list) {
        Route spart1 = new Route("578 Clover Drive", "29301", "SC", "Spartanburg", "Oliver Harold");
        Route spart2 = new Route("702 Birchhill Court", "29365", "SC", "Lyman", "Kailyn Williams");
        Route spart3 = new Route("126 Hillary Lane", "29302", "SC", "Spartanburg", "Hannah Sibly");
        Route spart4 = new Route("369 Oregon Drive", "29349", "SC", "Inman", "Joseph Bryant");
        list.addRoute(spart1);
        list.addRoute(spart2);
        list.addRoute(spart3);
        list.addRoute(spart4);
    }
    private static void greenVilleList(ListOfRoutes list){
        Route green1= new Route("803 Green Court Road", "29604","SC", "Mauldin","Paris Johnson");
        Route green2= new Route("541 George Street", "29601", "SC", "Greer", "Kelvin Smith");
        Route green3= new Route("789 Green Rove Road", "29302", "SC","Greenville", "Jerry Lyles" );
        Route green4= new Route("265 Naeman Court", "29315","SC", "Travelers Rest", "James Young" );
        list.addRoute(green1);
        list.addRoute(green2);
        list.addRoute(green3);
        list.addRoute(green4);


    }
    private static void packageDelivery(ListOfRoutes list){

        list.printRoutes();
        printInstructions();

        iterateRouteChange(list);

    }
    private static void printInstructions(){
        System.out.println("1- Go to next Route\n2- Go to previous route\n3- Stop delivery/End program");
    }

    private static void iterateRouteChange(ListOfRoutes list){
        boolean quit= false;

        while(!quit){
            int number= intKeyboard.nextInt();
            switch(number) {
                case 1:
                    System.out.println("Driving to destination....");
                    driveWait();
                    list.nextRoute();
                    break;
                case 2:
                    System.out.println("Driving back to destination.... ");
                    driveWait();
                    list.previousRoute();
                    break;
                case 3:
                    quit= true;
            }
        }
    }

    private static void driveWait(){
        //Simulates a delivery time frame
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }


}
