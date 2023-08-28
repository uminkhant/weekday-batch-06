package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
	private LocalDate saleDate;
	private LocalTime saleTime;
	private int total;
	
	@OneToMany(mappedBy = "sale",cascade = CascadeType.PERSIST)
	private List< SaleDetails> saleDetials = new ArrayList<SaleDetails>();
	
	
	public Sale( LocalDate saleDate,LocalTime time, int total) {
		super();
		this.saleDate = saleDate;
		this.saleTime = saleTime;
		this.total = total;
		
	}
	
	public void addSaleDetail(SaleDetails detail) {
		detail.setSale(this);
		this.saleDetials.add(detail);
	}
	
}
