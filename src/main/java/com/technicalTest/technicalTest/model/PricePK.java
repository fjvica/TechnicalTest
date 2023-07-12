package com.technicalTest.technicalTest.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
