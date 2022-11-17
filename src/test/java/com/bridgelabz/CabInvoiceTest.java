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

}
