package com.technicalTest.technicalTest.controller;

import com.technicalTest.technicalTest.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController("/")
public class TechnicalTestController {

    private final PriceService priceService;

    TechnicalTestController(PriceService priceService) {
        this.priceService = priceService;
    }


    @GetMapping(value = "/priceData/{date}/{brandId}/{productId}")
    public ResponseEntity searchPrice(@PathVariable(value = "date") String date,
                                       @PathVariable(value = "brandId") Integer brandId,
                                       @PathVariable(value = "productId") Long productId) {

        try{
            //Format date to LocalDateTime
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH.mm.ss", Locale.UK);
            var datetime_str = date;
            Date datetime = formatter.parse(datetime_str);

            var result = priceService.searchPrice(datetime, brandId, productId);

            if (result.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(result.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Price not found");
            }

        }
        catch (ParseException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error parsing date, required the next format: yyyy-MM-dd-HH.mm.ss");
        }


    }
}
