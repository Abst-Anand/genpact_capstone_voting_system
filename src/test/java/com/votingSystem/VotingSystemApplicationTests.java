package com.votingSystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VotingSystemApplicationTests {



	@Test
	void contextLoads() {
	}

//	@Test
//	void testRepository(){
//		ProductEntity newProduct = ProductEntity
//				.builder()
//				.sku("SKU 1")
//				.price(BigDecimal.valueOf(2000))
//				.title("Title 1")
//				.quantity(5)
//				.build();
//
//		ProductEntity savedProduct = productRepository.save(newProduct);
//		System.out.println(savedProduct);
//	}

//	@Test
//	void testFindByTitle(){
//
//		Optional<ProductEntity> optinalProduct = productRepository.findByTitle("Title 1");
//		optinalProduct.ifPresent(System.out::println);
//
//	}

//	@Test
//	void testFindAll(){
//		List<ProductEntity> products = productRepository.findAll();
//		System.out.println(products);
//	}

}
