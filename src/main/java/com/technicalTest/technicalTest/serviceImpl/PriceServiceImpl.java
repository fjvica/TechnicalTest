package com.technicalTest.technicalTest.serviceImpl;

import com.technicalTest.technicalTest.model.Price;
import com.technicalTest.technicalTest.repository.PriceRepository;
import com.technicalTest.technicalTest.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Optional<Price> searchPrice(Date date, Integer brandId, String productId) {

        return priceRepository.searchPrice(date, brandId, productId);

    }
}
