package com.technicalTest.technicalTest.service;

import com.technicalTest.technicalTest.model.Price;

import java.util.Date;
import java.util.Optional;

/**
 * Price service Interface
 */
public interface PriceService {

    Optional<Price> searchPrice(Date date, Integer brandId, Long productId);
}
