package com.co.sales.inventory.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.co.sales.inventory.api.constants.InventoryConstants;
import com.co.sales.inventory.api.model.CompraDTO;
import com.co.sales.inventory.api.model.CompraResponse;
import com.co.sales.inventory.api.service.InventoryServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class InventoryApplicationTests {
	
	@Autowired
	 private InventoryServiceImpl inventoryService = new InventoryServiceImpl();
	
    @InjectMocks
    private InventoryServiceImpl mockService;

    
	@Test
	public void whenProductNotExists() throws Exception {
		 CompraDTO compra= new CompraDTO(99991, 10);
		IllegalArgumentException thrown = Assertions.assertThrows(
		            IllegalArgumentException.class,
		            () -> inventoryService.buyProduct(compra)
		        );

		        Assertions.assertTrue(thrown.getMessage().contains(InventoryConstants.NO_PRODUCT));
		   
	}
	@Test
	public void whenNotEnoughInventory() throws Exception {
		 CompraDTO compra= new CompraDTO(1, 100000);
		IllegalArgumentException thrown = Assertions.assertThrows(
		            IllegalArgumentException.class,
		            () -> inventoryService.buyProduct(compra)
		        );

		        Assertions.assertTrue(thrown.getMessage().contains(InventoryConstants.ERROR_NOT_ENOUGH_INVENTORY));
		   
	}
	
	@Test
	public void testBuyProduct() throws Exception {
		   CompraDTO productToBuy = new CompraDTO(1,10);
	       CompraResponse result = mockService.buyProduct(productToBuy);
	        Assertions.assertNotNull(result);

	
	}

}
