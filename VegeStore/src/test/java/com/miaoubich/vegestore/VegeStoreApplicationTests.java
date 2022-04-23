package com.miaoubich.vegestore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.miaoubich.vegestore.controller.VegetableController;
import com.miaoubich.vegestore.model.Vegetable;

@SpringBootTest
class VegeStoreApplicationTests {

	@Autowired
	private VegetableController vegeController;
	
	@Test
	void addVegetableTest() {
		//Arrange
		Vegetable vege = buildVege();
		
		//Act
		ResponseEntity<Vegetable> actualResult = vegeController.addOrUpdate(vege);

		//Assert
		assertEquals(vege, actualResult.getBody());
	}
	
	
	public Vegetable buildVege() {
		Vegetable vegetable = new Vegetable();
		vegetable.setName("Apple");
		vegetable.setPrice(10);
		vegetable.setQuantity(5120);
		vegetable.setFridge("AA");
		
		return vegetable;
	}

}
