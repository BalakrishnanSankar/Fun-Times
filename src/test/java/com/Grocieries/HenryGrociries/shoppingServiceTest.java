package com.Grocieries.HenryGrociries;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;


public class shoppingServiceTest {

	@Test
	public void testScenario1() throws ParseException{
		
		List<CustomerProduct> purchaseProducts=new ArrayList<CustomerProduct>();
		
		CustomerProduct soup=new CustomerProduct();
		soup.setProduct("soup");
		soup.setUnitCount(3);
		
		CustomerProduct bread=new CustomerProduct();
		bread.setProduct("bread");
		bread.setUnitCount(2);
		
		purchaseProducts.add(soup);
		purchaseProducts.add(bread);
		
		ShoppingService groceryService=new ShoppingService();
		Date date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse("27/08/2019");
		double result=groceryService.calculateTotalPrice(purchaseProducts, date1);
		assertEquals(3.15,result,1);
		
	}
	
	@Test
	public void testScenario2() throws ParseException {
		List<CustomerProduct> purchaseProducts = new ArrayList<CustomerProduct>();

		CustomerProduct apples = new CustomerProduct();
		apples.setProduct("apples");
		apples.setUnitCount(6);

		CustomerProduct milk = new CustomerProduct();
		milk.setProduct("milk");
		milk.setUnitCount(1);

		purchaseProducts.add(apples);
		purchaseProducts.add(milk);

		ShoppingService groceryService = new ShoppingService();
		Date date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse("27/08/2019");
		double result=groceryService.calculateTotalPrice(purchaseProducts, date1);
		assertEquals(1.90, result,0);
	}
	
	@Test
	public void testScenario3() throws ParseException {
		List<CustomerProduct> purchaseProducts = new ArrayList<CustomerProduct>();

		CustomerProduct apples = new CustomerProduct();
		apples.setProduct("apples");
		apples.setUnitCount(6);

		CustomerProduct milk = new CustomerProduct();
		milk.setProduct("milk");
		milk.setUnitCount(1);

		purchaseProducts.add(apples);
		purchaseProducts.add(milk);

		ShoppingService groceryService = new ShoppingService();
		Date date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse("31/08/2019");
		double result=groceryService.calculateTotalPrice(purchaseProducts, date1);
		assertEquals(1.84, result, 4);

	}
	
	@Test
	public void testScenario4() throws ParseException {
		List<CustomerProduct> purchaseProducts = new ArrayList<CustomerProduct>();

		CustomerProduct apples = new CustomerProduct();
		apples.setProduct("apples");
		apples.setUnitCount(3);

		CustomerProduct soup = new CustomerProduct();
		soup.setProduct("soup");
		soup.setUnitCount(2);

		purchaseProducts.add(apples);
		purchaseProducts.add(soup);

		ShoppingService groceryService = new ShoppingService();
		Date date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse("31/08/2019");
		double result=groceryService.calculateTotalPrice(purchaseProducts, date1);
		assertEquals(1.97, result, 7);

	}
	
}
