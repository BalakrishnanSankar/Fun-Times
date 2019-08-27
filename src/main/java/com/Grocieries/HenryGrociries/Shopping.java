package com.Grocieries.HenryGrociries;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Shopping class is used to show tha available product in grocieries and to calculate the price for it 
 * 
 * @author Balakrishnan
 *
 */

public class Shopping {


	private Scanner input = null;
	NumberFormat nf = NumberFormat.getInstance();
	public static void main(String[] args) {
		Shopping shoppingDetails = new Shopping();
		shoppingDetails.getTotalPrice();
	}
	private void getTotalPrice() {
		System.out.println( "Hello World!" );
		Scanner scan = new Scanner(System.in);
		List<CustomerProduct> customerList = new ArrayList<CustomerProduct>();
		ShoppingService shoppingService = new ShoppingService();
		String oneMoreProduct="N";
		int quantity;
		int input;
		do {
			CustomerProduct customerProduct = new CustomerProduct();
			System.out.println(
					"Enter the items to be added to the cart: \n1.Soup\n2.Bread\n3.Milk\n4.Apples\n5.exit");
			input = scan.nextInt();
			switch (input) {
			case 1:
				System.out.println("enter the quantity required:");
				quantity = scan.nextInt();
				customerProduct.setProduct("soup");
				customerProduct.setUnitCount(quantity);
				customerList.add(customerProduct);
				break;
			case 2:
				System.out.println("enter the quantity required:");
				quantity = scan.nextInt();
				customerProduct.setProduct("bread");
				customerProduct.setUnitCount(quantity);
				customerList.add(customerProduct);
				break;
			case 3:
				System.out.println("enter the quantity required:");
				quantity = scan.nextInt();
				customerProduct.setProduct("milk");
				customerProduct.setUnitCount(quantity);
				customerList.add(customerProduct);
				break;
			case 4:
				System.out.println("enter the quantity required:");
				quantity = scan.nextInt();
				customerProduct.setProduct("apples");
				customerProduct.setUnitCount(quantity);
				customerList.add(customerProduct);
				break;
			default:
				System.out.println("enter the AVailable Product");
				break;
			}
			System.out.println("are you going to add one more product to basket (Y or N):");
			oneMoreProduct = scan.next();
		}while("Y".equalsIgnoreCase(oneMoreProduct));
		System.out.println("Enter date");
		Date date1;
		try {
			date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(scan.next());
			nf.setMaximumFractionDigits(2);
			double totalCost = shoppingService.calculateTotalPrice(customerList,date1);
			System.out.println("total cost:" +Double.parseDouble(nf.format(totalCost)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
