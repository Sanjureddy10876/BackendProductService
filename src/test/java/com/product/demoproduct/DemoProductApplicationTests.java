package com.product.demoproduct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import productentity.Product;
import productrepository.ProductRepo;
import productservice.ProductService;

import java.util.List;


@SpringBootTest
class DemoProductApplicationTests {
	private final ProductRepo productRepository = Mockito.mock(ProductRepo.class);
	private final ProductService productService = new ProductService(productRepository);
	@Test
	void contextLoads() {

	}

	@Test
	void testGetAllProducts() {
		List<Product> products = List.of(new Product());
		Mockito.when(productRepository.findAll()).thenReturn(products);
		Assertions.assertEquals(1, productService.getAllProducts().size());
	}

}
