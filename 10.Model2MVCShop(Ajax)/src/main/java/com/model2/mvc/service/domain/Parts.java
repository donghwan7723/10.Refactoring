package com.model2.mvc.service.domain;




public class Parts {
 	//Field
	private int partId;	
	private String partClass;
	private String partName;
	private int price;
	private String brandIdentifyer;
	
 	//constructor
	public Parts() {
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public String getPartClass() {
		return partClass;
	}

	public void setPartClass(String partClass) {
		this.partClass = partClass;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCarBrand() {
		return brandIdentifyer;
	}

	public void setCarBrand(String brandIdentifyer) {
		this.brandIdentifyer = brandIdentifyer;
	}

	public String toString() {
		return "Parts [partId=" + partId + ", partClass=" + partClass + ", partName=" + partName + ", price=" + price
				+ ", brandIdentifyer=" + brandIdentifyer + "]";
	}	

 	
	
}