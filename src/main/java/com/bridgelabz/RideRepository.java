package com.bridgelabz;

import java.util.HashMap;

public class RideRepository {
   HashMap<String,Ride[]> rideHashMap = new HashMap<>();
   public void addRides(String userId,Ride[] rides){
       if (rideHashMap.containsKey(userId)){
           System.out.println("This userId already exists.");
       }else {
           rideHashMap.put(userId,rides);
       }
   }
   public Invoice getInvoiceFromUserId(String userId){
       Ride[] rides = rideHashMap.get(userId);
       CabInvoice invoice = new CabInvoice();
       return invoice.getInvoiceOfRides(rides);
   }
}
