package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@NamedQuery(name = "getAllSaleDetails",query = "select sd from SaleDetails sd where sd.sale.isDeleted= false")
public class SaleDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int qty;
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Sale  sale;
	private int total;
	
		
	public SaleDetails(int qty, Product product) {
		super();
		this.qty = qty;
		this.product = product;
		
	}
	
	
}
