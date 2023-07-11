package com.technicalTest.technicalTest.repository;

import com.technicalTest.technicalTest.model.Price;
import com.technicalTest.technicalTest.model.PricePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
@Transactional
public interface PriceRepository extends JpaRepository<Price, PricePK> {

    @Query(
            value = "SELECT * FROM PRICE p " +
                    "WHERE p.startDate <= ?1 " +
                    "AND p.endDate >= ?1 " +
                    "AND p.brandId = ?2 " +
                    "AND p.productId = ?3" +
                    "ORDER BY p.priority DESC" +
                    "LIMIT 1",
            nativeQuery = true)
    Optional<Price> searchPrice(Date date, Integer brandId, String productId);

}
