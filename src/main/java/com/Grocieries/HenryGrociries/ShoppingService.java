package com.Grocieries.HenryGrociries;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * ShoppingService is used to make the disocunt rule and to calculate the price with discount
 * 
 * @author Balakrishnan.S
 *
 */
public class ShoppingService 
{
	/**
	 * GetStockItems method is used to keep available product with price.
	 * 
	 */
	public Map<String, Double> GetStockItems(){
		Map<String,Double> discountItemMap = new HashMap<String,Double>();
		discountItemMap.put("soup", 0.65);
		discountItemMap.put("bread", 0.80);
		discountItemMap.put("milk", 1.30);
		discountItemMap.put("apples", 0.10);
		return discountItemMap;
	}
	/**
	 * getDiscountDetails method is used to keep discount items.
	 * 
	 */
	public Map<String,DiscountItem> getDiscountDetails(){
		Map<String,DiscountItem> discountItemMap = new HashMap<String,DiscountItem>();
		List<DiscountItem> stockDiscountList = new ArrayList<DiscountItem>();
		DiscountItem discountItem = new DiscountItem();
		discountItem.setProduct("apples");
		discountItem.setUnitCount(1);
		discountItem.setDiscountunit(0);
		discountItem.setDisProduct("apples");
		discountItem.setDisProductPer(0.10);
		discountItem.setDisStartDate(getDiscountDate(3));
		discountItem.setDisEndDate(getMonthEndDate());
		discountItemMap.put("apples", discountItem);
		stockDiscountList.add(discountItem);
		discountItem = new DiscountItem();
		discountItem.setProduct("soup");
		discountItem.setUnitCount(2);
		discountItem.setDisProduct("bread");
		discountItem.setDisProductPer(0.50);
		discountItem.setDiscountunit(1);
		discountItem.setDisStartDate(getDiscountDate(-1));
		discountItem.setDisEndDate(getDiscountDate(7));
		stockDiscountList.add(discountItem);
		discountItemMap.put("bread", discountItem);
		return discountItemMap;
	}
	/**
	 * getMonthEndDate method is used to get the last day of month.
	 * 
	 */
	private static Date getMonthEndDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1); 
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}
	/**
	 * getDiscountDate method is used to get the date.
	 * 
	 */
    private static Date getDiscountDate(int days) {
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DATE, days);
    	return cal.getTime();
    }
    /**
	 * calculateTotalPrice method is used to get the total price of the product with discount.
	 * 
	 */
	public double calculateTotalPrice(List<CustomerProduct> customerList, Date dateValue) {
		double discountPrice = 0;
		double actualPrice = 0;
		double totalPrice =0;
		Map<String, Double> stockList = GetStockItems();
		Map<String,DiscountItem> discountItems = getDiscountDetails();
		for(CustomerProduct product : customerList){
			actualPrice = stockList.get(product.getProduct()) * product.getUnitCount();
			discountPrice = getDiscountPrice(product,discountItems, customerList, stockList, dateValue);
			totalPrice = totalPrice + (actualPrice - discountPrice);
		}

		return totalPrice;
	}
	/**
	 * getDiscountPrice method is used to get the total discount for the product.
	 * 
	 */
	public Double getDiscountPrice(CustomerProduct product, Map<String,DiscountItem> discountItemsMap, List<CustomerProduct> customerList, Map<String, Double> stockList,
			Date dateValue){ 
		Double discountPrice = 0.0;
		if(discountItemsMap.containsKey(product.getProduct())){
			DiscountItem discountItem = discountItemsMap.get(product.getProduct());
			Optional<CustomerProduct> discountProduct = customerList.stream().filter(prod -> prod.getProduct().equals(discountItem.getProduct())).findAny();
			if(discountProduct.isPresent()){
				if((discountProduct.get().getUnitCount()>=discountItem.getUnitCount()) && dateValue.after(discountItem.getDisStartDate()) && dateValue.before(discountItem.getDisEndDate())){
					if(discountItem.getDiscountunit() > 0){
						discountPrice = stockList.get(product.getProduct()) * discountItem.getDisProductPer();
					}
					else{
						discountPrice = stockList.get(product.getProduct())* product.getUnitCount() * discountItem.getDisProductPer();
					}

				}
			}
		}
		return discountPrice;
	}
}
