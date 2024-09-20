package com.japTutorial.jpaTuts;

import com.japTutorial.jpaTuts.entities.ProductEntity;
import com.japTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity newProduct = ProductEntity
				.builder()
				.sku("SKU 1")
				.price(BigDecimal.valueOf(2000))
				.title("Title 1")
				.quantity(5)
				.build();

		ProductEntity savedProduct = productRepository.save(newProduct);
		System.out.println(savedProduct);
	}

	@Test
	void testFindByTitle(){

		Optional<ProductEntity> optinalProduct = productRepository.findByTitle("Title 1");
		optinalProduct.ifPresent(System.out::println);

	}

	@Test
	void testFindAll(){
		List<ProductEntity> products = productRepository.findAll();
		System.out.println(products);
	}

}
