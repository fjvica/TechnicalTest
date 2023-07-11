package com.technicalTest.technicalTest.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

/**
 * Primary key for price model
 */
@Embeddable
public class PricePK implements Serializable {

    private Long productId;
    private Integer priceList;

    //Constructor
    public PricePK(Long productId, Integer priceList) {
        this.productId = productId;
        this.priceList = priceList;
    }


    //Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }
}
