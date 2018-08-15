package com.williams.kailyn;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListOfRoutes {
    LinkedList<Route> routeList = new LinkedList<>();
    private String county;
    private int index = 0;
    private boolean forward= true;
    private int endOfRoute= numberOfRoutes()-1;
    private int startOfRoute= 0;

    public ListOfRoutes(String county) {
        this.county = county;
    }

    public boolean addRoute(Route route) {
        if (routeList.contains(route)) {
            return false;
        } else {
            routeList.add(route);
            return true;
        }
    }

    public void printRoutes() {

        System.out.println("Here are your routes for the day. You have " + numberOfRoutes() + " routes for the day in " + county + " county- ");
        for (int i = 0; i < routeList.size(); i++) {
            System.out.println("Customer Name: " + routeList.get(i).getCustomerName() + "\n" + routeList.get(i).displayAddress() + "\n");

        }
    }

    public int numberOfRoutes() {
        return routeList.size();
    }

//---------------------------------------------------------------------------------
    //Components for list iterator

    public void nextRoute() {
        if (!forward) {
            index++;
        }
        if (hasNext()) {
            System.out.println("Dropping package off at destination --> " + routeList.get(index).displayAddress());
            forward = true;
            index++;
        }
        else if(index>= endOfRoute) {
            System.out.println("Delivery Done!");
        }
    }

    public void previousRoute(){
        if(forward){
            index--;
        }
        if(hasPrevious()) {
            index--;
            System.out.println("Going back to "+routeList.get(index).displayAddress());
            forward = false;
        }
        else if(!hasPrevious()) {
            System.out.println("Turn around and finish delivering your packages!");
            index++;
        }
        else if(index==startOfRoute){
                System.out.println("Turn around and finish delivering your packages!");
            }
    }
    private boolean hasPrevious(){
        if(routeList!=null && index< numberOfRoutes() && index>startOfRoute){
            return true;
        }
        return false;
    }

    private boolean hasNext(){
        if(routeList != null && index < numberOfRoutes()){
            return true;
        }
        return false;
    }
}

