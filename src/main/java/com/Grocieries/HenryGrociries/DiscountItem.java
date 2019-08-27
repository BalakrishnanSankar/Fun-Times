package com.Grocieries.HenryGrociries;

import java.util.Date;
/**
 * DiscountItem class is used to store the discount product and its details
 * 
 * @author Balakrishnan S
 *
 */
public class DiscountItem {
	private String product;
	private int unitCount;
	private String disProduct;
	private double disProductPer;
	private Date  disStartDate;
	private Date  disEndDate;
	private int discountunit;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getUnitCount() {
		return unitCount;
	}
	public void setUnitCount(int unitCount) {
		this.unitCount = unitCount;
	}
	public String getDisProduct() {
		return disProduct;
	}
	public void setDisProduct(String disProduct) {
		this.disProduct = disProduct;
	}
	public double getDisProductPer() {
		return disProductPer;
	}
	public void setDisProductPer(double disProductPer) {
		this.disProductPer = disProductPer;
	}
	public Date getDisStartDate() {
		return disStartDate;
	}
	public void setDisStartDate(Date disStartDate) {
		this.disStartDate = disStartDate;
	}
	public Date getDisEndDate() {
		return disEndDate;
	}
	public void setDisEndDate(Date disEndDate) {
		this.disEndDate = disEndDate;
	}
	public int getDiscountunit() {
		return discountunit;
	}
	public void setDiscountunit(int discountunit) {
		this.discountunit = discountunit;
	}
	
}
