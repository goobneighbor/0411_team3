package com.t09ether.home.dto;

public class ProductDTO {
	private int pro_code;
	private String pro_name;
	private int pro_price;
	private String pro_stock;
	private String image;
	private String detailed;
	

	@Override
	public String toString() {
		return "ProductDTO [pro_code=" + pro_code + ", pro_name=" + pro_name + ", pro_price=" + pro_price
				+ ", pro_stock=" + pro_stock + ", image=" + image + ", detailed=" + detailed + "]";
	}
	
	public int getPro_code() {
		return pro_code;
	}
	public void setPro_code(int pro_code) {
		this.pro_code = pro_code;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public String getPro_stock() {
		return pro_stock;
	}
	public void setPro_stock(String pro_stock) {
		this.pro_stock = pro_stock;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDetailed() {
		return detailed;
	}
	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}
	
	
}
