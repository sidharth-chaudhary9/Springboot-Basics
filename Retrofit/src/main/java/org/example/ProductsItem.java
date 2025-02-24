package org.example;

public class ProductsItem{
	private int quantity;
	private int productId;
	ProductsItem(int productId,int quantity){
		this.productId=productId;
		this.quantity=quantity;
	}
	ProductsItem(){}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public int getProductId(){
		return productId;
	}

	@Override
 	public String toString(){
		return 
			"ProductsItem{" + 
			"quantity = '" + quantity + '\'' + 
			",productId = '" + productId + '\'' + 
			"}";
		}
}
