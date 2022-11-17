package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CabInvoiceTest {
    @Test
   public void givenTimeAndDistanceShould_ReturnTotalFare(){
        CabInvoice cabinvoice = new CabInvoice();
       double totalFare = cabinvoice.getTotalFare(10,1);
        Assertions.assertEquals(101,totalFare);
    }
    @Test
    public void givenTimeAndDistanceShould_ReturnMinimumFare(){
        CabInvoice cabinvoice = new CabInvoice();
        double totalFare = cabinvoice.getTotalFare(0.2,1);
        Assertions.assertEquals(5,totalFare);
    }
    @Test
    public void givenMultipleRidesShould_ReturnAggregateFare(){
        CabInvoice cabinvoice = new CabInvoice();
        Ride[] rides ={new Ride(12.0,3.0),new Ride(14.0,5.0),new Ride(0.1,3.0)};
        double totalFare = cabinvoice.getTotalFare(rides);
        Assertions.assertEquals(273,totalFare);
    }

}
