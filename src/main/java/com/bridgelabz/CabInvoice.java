package com.bridgelabz;

public class CabInvoice {
    enum fareForNormalRides{FARE_PER_KM(10),FARE_PER_MINUTE(1),MINIMUM_FARE(5);
    int value;
        fareForNormalRides(int value){
            this.value=value;
        }
    };
    enum fareForPremiumRides{FARE_FOR_PREMIUM_RIDES(15),PREMIUM_FARE_PER_MINUTE(2),PREMIUM_MINIMUM_FARE(20);
    int value ;
        fareForPremiumRides(int value){
            this.value=value;
        }
    };

    static final int FARE_PER_KM = 10;
    static final int FARE_PER_MINUTE = 1;
    static final int MINIMUM_FARE = 5;
    static final int PREMIUM_FARE_PER_KM = 15;
    static final int PREMIUM_FARE_PER_MINUTE = 2;
    static final int PREMIUM_MINIMUM_FARE = 20;


    public double getTotalFare(double distance, double time){
        double totalFare = fareForNormalRides.FARE_PER_KM.value*distance+fareForNormalRides.FARE_PER_MINUTE.value*time;
        if (totalFare<fareForNormalRides.MINIMUM_FARE.value) {

            return fareForNormalRides.MINIMUM_FARE.value;
        }
        else
        return totalFare;
    }
    public double getTotalFareForPremiumRides(double distance, double time){
        double totalFare = fareForPremiumRides.FARE_FOR_PREMIUM_RIDES.value*distance+fareForPremiumRides.PREMIUM_FARE_PER_MINUTE.value*time;
        if (totalFare<fareForPremiumRides.PREMIUM_MINIMUM_FARE.value) {
            return fareForPremiumRides.PREMIUM_MINIMUM_FARE.value;
        }
        else
            return totalFare;
    }

    public double getTotalFare(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride: rides){
            double totalFare = getTotalFare(ride.distance,ride.time);
            aggregateFare += totalFare;
        }
        return aggregateFare;
    }
    public double getTotalFareForPremiumRides(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride: rides){
            double totalFare = getTotalFareForPremiumRides(ride.distance,ride.time);
            aggregateFare += totalFare;
        }
        return aggregateFare;
    }

    public Invoice getInvoiceOfRides(Ride[] rides) {
        int numberOfRides = rides.length;
        double totalFare = getTotalFare(rides);
        double averageRideFare = totalFare/numberOfRides;
        return new Invoice(numberOfRides,totalFare,averageRideFare);
    }
    public Invoice getInvoiceOfPremiumRides(Ride[] rides) {
        int numberOfRides = rides.length;
        double totalFare = getTotalFareForPremiumRides(rides);
        double averageRideFare = totalFare/numberOfRides;
        return new Invoice(numberOfRides,totalFare,averageRideFare);
    }
    public Invoice getInvoiceOfRidesOfBothRides(Ride[] rides){
        double totalFare = 0;
        for (Ride ride: rides ){
            if (ride.rideType.equals("Normal")){
                totalFare += getTotalFare(ride.distance,ride.time);
            }else if (ride.rideType.equals("Premium")){
                totalFare+=getTotalFareForPremiumRides(ride.distance,ride.time);
            }
        }
        return new Invoice(rides.length,totalFare,totalFare/rides.length);
    }

}
