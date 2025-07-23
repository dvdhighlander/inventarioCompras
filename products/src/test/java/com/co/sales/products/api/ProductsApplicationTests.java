package com.co.sales.products.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import com.co.sales.products.api.model.Products;
import com.co.sales.products.api.model.ProductsDTO;
import com.co.sales.products.api.model.ProductsResponse;
import com.co.sales.products.api.repository.ProductsRepository;
import com.co.sales.products.api.service.ProductsServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class ProductsApplicationTests {

  
    @Mock
    private ProductsRepository prodRepository;

    @InjectMocks
    private ProductsServiceImpl prodService;

	@Test
	public void testCreateProduct() throws Exception {
		   ProductsDTO productToSave = new ProductsDTO("ProductoTest", 200,"Descripcion Test");
		   Products savedProduct = new Products(); 
		   savedProduct.setId(3);
		   savedProduct.setNombre("ProductoTest");
		   savedProduct.setPrecio(200);
		   savedProduct.setDescripcion("Descripcion Test");
		   
	       Mockito.when(prodRepository.save(Mockito.any(Products.class))).thenReturn(savedProduct);

	       ProductsResponse result = prodService.createProduct(productToSave);
	        Assertions.assertNotNull(result);
	        Assertions.assertEquals(savedProduct.getNombre(), result.getProduct().getNombre());
	        Assertions.assertEquals(savedProduct.getPrecio(), result.getProduct().getPrecio());
	        
	        Mockito.verify(prodRepository, Mockito.times(1)).save(Mockito.any(Products.class));
	
	}
}
