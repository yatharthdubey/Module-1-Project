package com.capgemini.takehome.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.dao.ProductDAO;
import com.capgemini.takehome.exceptions.ProductCodeNotFoundException;
import com.capgemini.takehome.service.ProductService;
import com.capgemini.takehome.service.IProductService;

public class Testing {

	IProductService productService = new ProductService(new ProductDAO());
	/*Testing: whether Product is found in the Collection according to the Product Code Passed into it*/
	@Test
	public void whenGetProductDeatilsSuccessfullyReturnsProductObjectAccordingToTheInput() throws ProductCodeNotFoundException {
		
		Product product = new Product();
		product.setProductCode(1001);
		product.setProductName("iPhone");
		product.setProductCategory("Electronics");
		product.setProductPrice(35000);
		assertEquals(product, productService.getProductDetails(1001));
		
	}
	/*Testing: if Product is not found in the Collection then we encounters with exception or not*/
	@Test(expected = ProductCodeNotFoundException.class)
	public void whenProductCodeIsNotFoundThenProductCodeNotFoundExceptionOccurs() throws ProductCodeNotFoundException {
		
		productService.getProductDetails(1005);
		
	}
}
