package com.technicalTest.technicalTest;

import com.technicalTest.technicalTest.model.Price;
import com.technicalTest.technicalTest.repository.PriceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static com.technicalTest.technicalTest.util.FactoryTest.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TechnicalTestApplicationTests {

	@LocalServerPort
	private int port;

	private static RestTemplate restTemplate;
	private String baseUrl = "http://localhost";

	@BeforeAll
	public static void init(){
		restTemplate = new RestTemplate();
	}

	@Autowired
	PriceRepository priceRepository;



	@Test
	public void test1Api() {
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/priceData/14-06-2020-10.00.00/1/35455");
		var correctPrice = createPriceTest1();
		Price response = restTemplate.getForObject(baseUrl, Price.class);
		Assertions.assertEquals(correctPrice, response);
	}

	@Test
	public void test2Api() {
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/priceData/14-06-2020-16.00.00/1/35455");
		var correctPrice = createPriceTest2();
		Price response = restTemplate.getForObject(baseUrl, Price.class);
		Assertions.assertEquals(correctPrice, response);
	}

	@Test
	public void test3Api() {
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/priceData/14-06-2020-21.00.00/1/35455");
		var correctPrice = createPriceTest1();
		Price response = restTemplate.getForObject(baseUrl, Price.class);
		Assertions.assertEquals(correctPrice, response);
	}

	@Test
	public void test4Api() {
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/priceData/15-06-2020-10.00.00/1/35455");
		var correctPrice = createPriceTest3();
		Price response = restTemplate.getForObject(baseUrl, Price.class);
		Assertions.assertEquals(correctPrice, response);
	}

	@Test
	public void test5Api() {
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/priceData/16-06-2020-21.00.00/1/35455");
		var correctPrice = createPriceTest4();
		Price response = restTemplate.getForObject(baseUrl, Price.class);
		Assertions.assertEquals(correctPrice, response);
	}

}
