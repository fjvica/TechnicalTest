package com.technicalTest.technicalTest.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

/**
 * Primary key for price model
 */
@Embeddable
@Data
public class PricePK implements Serializable {

    private Long productId;
    private Integer priceList;


}
