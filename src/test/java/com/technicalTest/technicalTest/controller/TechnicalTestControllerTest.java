package com.technicalTest.technicalTest.controller;

import com.technicalTest.technicalTest.service.PriceService;
import com.technicalTest.technicalTest.util.FactoryTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TechnicalTestControllerTest {

    @InjectMocks
    TechnicalTestController technicalTestController;
    @Mock
    PriceService priceService;



    @Test
    public void testApiOk() {
        when(priceService.searchPrice(any(),any(), any()))
                .thenReturn(Optional.of(FactoryTest.createPrice()));

        Assertions.assertEquals(ResponseEntity.status(HttpStatus.OK).body(FactoryTest.createPrice()),
                technicalTestController.searchPrice("15-06-2020-00.00.00",1, 1L));

    }

    @Test
    public void testApiNotFound() {
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Price not found"),
                technicalTestController.searchPrice("28-06-2021-00.00.00",1, 1L));

    }

    @Test()
    public void testApiParseException() {
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error parsing date, required the next format: yyyy-MM-dd-HH.mm.ss"),
                technicalTestController.searchPrice("-06-2021-00.00.00",1, 1L));

    }
}
