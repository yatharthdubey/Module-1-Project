package com.capgemini.takehome.dao;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.util.CollectionUtil;

import java.util.Map;
import java.util.Map.Entry;

public class ProductDAO implements IProductDAO {

	public Product getProductDetails(int productCode) {
		
		Map<Integer, Product>  map = CollectionUtil.getHashmap(); //Gathering Collection(HashMap) from CollectionUtil 
		for (Entry<Integer, Product> entry : map.entrySet()) {
			if(entry.getKey()==productCode) { // if Product found then return product object
				return entry.getValue();
			}
		}
		return null; //if product not found then return null
		
	}
	
}
