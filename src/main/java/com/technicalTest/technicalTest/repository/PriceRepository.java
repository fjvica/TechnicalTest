package com.technicalTest.technicalTest.repository;

import com.technicalTest.technicalTest.model.Price;
import com.technicalTest.technicalTest.model.PricePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * Repository
 */
@Repository
@Transactional
public interface PriceRepository extends JpaRepository<Price, PricePK> {

    /**
     * Method thats brings the price from bbdd
     * @param date string date
     * @param brandId foreign key
     * @param productId product Id
     * @return Optional empty or Optional with a price
     */
    @Query(
            value = "SELECT * FROM PRICE p " +
                    "WHERE p.start_date <= :date " +
                    "AND p.end_date >= :date " +
                    "AND p.brand_id = :brandId " +
                    "AND p.product_id = :productId " +
                    "ORDER BY p.priority DESC " +
                    "LIMIT 1",
            nativeQuery = true)
    Optional<Price> searchPrice(@Param("date") Date date, @Param("brandId") Integer brandId, @Param("productId") Long productId);

}
