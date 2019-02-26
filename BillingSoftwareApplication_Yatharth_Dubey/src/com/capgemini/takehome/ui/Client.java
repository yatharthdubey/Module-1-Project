package com.capgemini.takehome.ui;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.dao.ProductDAO;
import com.capgemini.takehome.exceptions.ProductCodeNotFoundException;
import com.capgemini.takehome.service.IProductService;
import com.capgemini.takehome.service.ProductService;

public class Client {

	public static void main(String[] args) {
		
		IProductService productService = new ProductService(new ProductDAO());
		Scanner scanner = new Scanner(System.in);
		for(;;) {
				System.out.println("\n1) Generate Bill by entering Product code and quantity\n" //Displaying menu to Cashier
									+ "2 Exit");
				int ch = scanner.nextInt();
				switch(ch) {
					case 1: System.out.print("A)Enter Product Details \n" //Asking for details
							+ "   Enter the product code: ");
							int productCode = scanner.nextInt();
							String regexInt="[0-9][0-9][0-9][0-9]";
							if(!Pattern.matches(regexInt, String.valueOf(productCode))){ //Validating Product Code
									System.out.println("\nProduct Code must be of 4 digits"); //If Product Code Validation fails then this gets printed and case will be break
									break;
							}
							else {
								System.out.print("   Enter the quantity: ");
								int quantity = scanner.nextInt();
								if(quantity<=0) { //Validating Quantity 
									System.out.println("\nQuantity should be greater than zero"); //If Quantity Validation fails then this gets printed and case will be break
									break;
								}
								else {
									Product product = new Product(); 
									try {
										product = productService.getProductDetails(productCode);
										System.out.println("\nProduct Name:         "+product.getProductName()+"\n"  //Printing Bill(description about product is not given in Product class)
												+ "Product Category:     "+product.getProductCategory()+"\n"
												+ "Product Price (Rs):   "+product.getProductPrice()+"\n"
												+ "Quantity:             "+quantity+"\n"
												+ "Line Total (Rs):      "+(quantity*product.getProductPrice())+"\n");
										break;
						
									} catch (ProductCodeNotFoundException e) {
										System.out.println();
										System.err.println("Sorry! The Product Code "+productCode+" is not available"); //Printing ERROR message if Product code is not found
										break;
									}
								}			
							}
					case 2: scanner.close();
							System.exit(0);
					default: System.out.println("Sorry! You Entered a Wrong Choice"); //Printing error message if you entered a wrong choice
				}
		}
		
		
	}

}
