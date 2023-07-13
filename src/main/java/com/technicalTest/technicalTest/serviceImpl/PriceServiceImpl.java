package com.technicalTest.technicalTest.serviceImpl;

import com.technicalTest.technicalTest.model.Price;
import com.technicalTest.technicalTest.repository.PriceRepository;
import com.technicalTest.technicalTest.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * Price service implementation
 */
@Service
public class PriceServiceImpl implements PriceService {

    /**
     * Repository
     */
    private PriceRepository priceRepository;

    /**
     * Constructor
     * @param priceRepository Repository
     */
    PriceServiceImpl(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

    /**
     * Method thats coll to repository and brings the price from bbdd
     * @param date string date
     * @param brandId foreign key
     * @param productId product Id
     * @return Optional empty or Optional with a price
     */
    @Override
    public Optional<Price> searchPrice(Date date, Integer brandId, Long productId) {

        return priceRepository.searchPrice(date, brandId, productId);

    }
}
