package com.jdc.mkt.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter

public class ProductLoader {

	private List<Product> list;
	
	public void addProduct(Product p) {
		list.add(p);
	}
	
	public List<Product> getListProduct(){
		return list;
	}

	public ProductLoader() {
		super();
		this.list = new ArrayList<Product>();
	}
	
	
}
