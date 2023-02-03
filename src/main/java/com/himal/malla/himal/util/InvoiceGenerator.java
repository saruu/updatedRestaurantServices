package com.himal.malla.himal.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InvoiceGenerator {


    public String getInvoiceNumber(String productName, int orderId){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();


        return productName+"_"+now+"_"+orderId;
    }
}
