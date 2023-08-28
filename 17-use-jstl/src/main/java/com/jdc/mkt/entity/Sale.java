package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sale implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Member customer;
	private Member cashier;
	private LocalDateTime saleDate;
	private int total;
	@OneToMany(mappedBy = "sale")
	private List< SaleDetails> saleDetials;
	
	
	public Sale(Member customer, Member cashier, LocalDateTime saleDate, int total, List<SaleDetails> saleDetials) {
		super();
		this.customer = customer;
		this.cashier = cashier;
		this.saleDate = saleDate;
		this.total = total;
		this.saleDetials = saleDetials;
	}
	
	
}
