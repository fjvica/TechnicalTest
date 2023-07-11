package com.technicalTest.technicalTest.service;

import com.technicalTest.technicalTest.model.Price;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

public interface PriceService {

    Optional<Price> searchPrice(Date date, Integer brandId, String productId);
}
