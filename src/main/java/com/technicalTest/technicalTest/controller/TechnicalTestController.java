package com.technicalTest.technicalTest.controller;

import com.technicalTest.technicalTest.model.Price;
import com.technicalTest.technicalTest.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Price Controller
 */
@RestController("/")
public class TechnicalTestController {

    private static Logger log = LoggerFactory.getLogger(TechnicalTestController.class);

    /**
     * Search price Service
     */
    private final PriceService priceService;

    /**
     * Constructor
     * @param priceService Search price Service
     */
    TechnicalTestController(PriceService priceService) {
        this.priceService = priceService;
    }

    /**
     * Method that process inputs and search a price in bbdd
     * @param date string date
     * @param brandId foreign key
     * @param productId product Id
     * @return ResponseEntity with the result
     */
    @Operation(summary = "Get a price")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get a price from BBDD",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Price.class)) }),
            @ApiResponse(responseCode = "404", description = "Price not found in BBDD",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "500", description = "Error parsing date",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) })}
    )
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
            log.error("ErrorError parsing date: {}", e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error parsing date, required the next format: yyyy-MM-dd-HH.mm.ss");
        }


    }
}
