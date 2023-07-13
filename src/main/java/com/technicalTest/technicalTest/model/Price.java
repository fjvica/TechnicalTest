package com.technicalTest.technicalTest.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Entity class
 */
@Entity
@Data
@IdClass(PricePK.class)
@Table(name = "price")
public class Price {

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDate;

    @Id
    @Column(name = "price_list")
    private Integer priceList;

    @Id
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "price")
    private Double price;

    @Column(name = "curr")
    private String curr;


}
