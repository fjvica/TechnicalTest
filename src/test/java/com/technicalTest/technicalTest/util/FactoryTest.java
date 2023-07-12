package com.technicalTest.technicalTest.util;

import com.technicalTest.technicalTest.model.Price;

import java.time.LocalDateTime;

public class FactoryTest {

    public static Price createPrice(){
        Price price = new Price();

        price.setPrice(Double.valueOf("50.50"));
        price.setCurr("EUR");
        price.setPriceList(1);
        price.setPriority(1);
        price.setEndDate(LocalDateTime.of(2020,2,10, 10,10,10));
        price.setStartDate(LocalDateTime.of(2020,2,1, 10,10,10));
        price.setBrandId(1);

        return price;
    }

    public static Price createPriceTest1(){
        Price price = new Price();

        price.setPrice(Double.valueOf("35.5"));
        price.setCurr("EUR");
        price.setPriceList(1);
        price.setProductId(35455L);
        price.setPriority(0);
        price.setEndDate(LocalDateTime.of(2020,12,31, 23,59,59));
        price.setStartDate(LocalDateTime.of(2020,6,14, 00,00,00));
        price.setBrandId(1);

        return price;
    }

    public static Price createPriceTest2(){
        Price price = new Price();

        price.setPrice(Double.valueOf("25.45"));
        price.setCurr("EUR");
        price.setPriceList(2);
        price.setProductId(35455L);
        price.setPriority(1);
        price.setEndDate(LocalDateTime.of(2020,6,14, 18,30,00));
        price.setStartDate(LocalDateTime.of(2020,6,14, 15,00,00));
        price.setBrandId(1);

        return price;
    }

    public static Price createPriceTest3(){
        Price price = new Price();

        price.setPrice(Double.valueOf("30.5"));
        price.setCurr("EUR");
        price.setPriceList(3);
        price.setProductId(35455L);
        price.setPriority(1);
        price.setEndDate(LocalDateTime.of(2020,6,15, 11,00,00));
        price.setStartDate(LocalDateTime.of(2020,6,15, 00,00,00));
        price.setBrandId(1);

        return price;
    }

    public static Price createPriceTest4(){
        Price price = new Price();

        price.setPrice(Double.valueOf("38.95"));
        price.setCurr("EUR");
        price.setPriceList(4);
        price.setProductId(35455L);
        price.setPriority(1);
        price.setEndDate(LocalDateTime.of(2020,12,31, 23,59,59));
        price.setStartDate(LocalDateTime.of(2020,6,15, 16,00,00));
        price.setBrandId(1);

        return price;
    }

}
