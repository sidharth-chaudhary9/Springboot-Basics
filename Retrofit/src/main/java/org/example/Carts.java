package org.example;

import java.util.List;

public class Carts{
	private String date;
	private int v;
	private int id;
	private int userId;
	private List<ProductsItem> products;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setV(int v){
		this.v = v;
	}

	public int getV(){
		return v;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setProducts(List<ProductsItem> products){
		this.products = products;
	}

	public List<ProductsItem> getProducts(){
		return products;
	}

	@Override
 	public String toString(){
		return 
			"Carts\n{" +
			"date = '" + date + '\n' +
			",__v = '" + v + '\n' +
			",id = '" + id + '\n' +
			",userId = '" + userId + '\n' +
			",products = '" + products + '\n' +
			"}";
		}
}