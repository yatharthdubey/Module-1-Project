package com.capgemini.takehome.service;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.exceptions.ProductCodeNotFoundException;

public interface IProductService {

	Product getProductDetails(int productCode) throws ProductCodeNotFoundException;
	
}