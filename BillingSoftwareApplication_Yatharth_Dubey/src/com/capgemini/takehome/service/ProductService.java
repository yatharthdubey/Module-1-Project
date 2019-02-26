package com.capgemini.takehome.service;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.dao.IProductDAO;
import com.capgemini.takehome.exceptions.ProductCodeNotFoundException;

public class ProductService implements IProductService {
	
	IProductDAO productDAO;
	
	public ProductService(IProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}

	public Product getProductDetails(int productCode) throws ProductCodeNotFoundException {
		
		Product product = new Product();
		product = productDAO.getProductDetails(productCode);
		if(product == null) {
			throw new ProductCodeNotFoundException(); //if DAO layer returns null then Exception occurs
		}
		return product; //if DAO layer return Product object then return it to Client
		
	}

}
