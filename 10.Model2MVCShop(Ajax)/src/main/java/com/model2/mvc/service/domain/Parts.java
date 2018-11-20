package com.model2.mvc.service.domain;




public class Parts {
 	//Field
	private int partCode;	
	private String brand;
	private String partName;
	private int prodNo;
	private int partPrice;
	private int count;	//Àç°í
	private String fileName;
	
	
	
	
 	//constructor
	public Parts() {
	}	
	
	//method
 	public int getPartCode() {
		return partCode;
	}

	public void setPartCode(int partCode) {
		this.partCode = partCode;
	}
	
 	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

 	public String getBrand() {
		return brand;
	}
 	public void setCarBrand(String brand) {
		this.brand = brand;
	}
 	public String getPartName() {
		return partName;
	}
 	public void setPartName(String partName) {
		this.partName = partName;
	}
 	public int getProdNo() {
		return prodNo;
	}
 	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
 	public int getPartPrice() {
		return partPrice;
	}
 	public void setPartPrice(int partPrice) {
		this.partPrice = partPrice;
	}
 	public String toString() {
		return "Parts [ carBrand=" + brand + ", partName=" + partName + ", prodNo="
				+ prodNo + ", partPrice=" + partPrice + "]";
	}
 	
	
}