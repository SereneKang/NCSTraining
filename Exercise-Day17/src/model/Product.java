package model;

import java.io.Serializable;

public class Product implements Serializable,Comparable<Product>{

	int productId;
	String productModel;
	String hardDrive;
	String memory;
	int price;

	
	
	public Product(int productId) {
		super();
		this.productId = productId;
	}
	public Product() {
		super();
	}
	public Product(int productId, String productModel, String hardDrive, String memory, int price) {
		super();
		this.productId = productId;
		this.productModel = productModel;
		this.hardDrive = hardDrive;
		this.memory = memory;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductModel() {
		return productModel;
	}
	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}
	public String getHardDrive() {
		return hardDrive;
	}
	public void setHardDrive(String hardDrive) {
		this.hardDrive = hardDrive;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ProductId=" + productId + ", productModel=" + productModel + ", hardDrive=" + hardDrive
				+ ", memory=" + memory + ", price=" + price;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hardDrive == null) ? 0 : hardDrive.hashCode());
		result = prime * result + ((memory == null) ? 0 : memory.hashCode());
		result = prime * result + price;
		result = prime * result + productId;
		result = prime * result + ((productModel == null) ? 0 : productModel.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (hardDrive == null) {
			if (other.hardDrive != null)
				return false;
		} else if (!hardDrive.equals(other.hardDrive))
			return false;
		if (memory == null) {
			if (other.memory != null)
				return false;
		} else if (!memory.equals(other.memory))
			return false;
		if (price != other.price)
			return false;
		if (productId != other.productId)
			return false;
		if (productModel == null) {
			if (other.productModel != null)
				return false;
		} else if (!productModel.equals(other.productModel))
			return false;
		return true;
	}
	@Override
	public int compareTo(Product o2) {
		
		return this.productId-o2.productId;
	}
	
	
	
	
}
