package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "getAllProduct",query = "select p from Product p ")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(name="dt_price")
	private int detailPrice;
	@Column(name="ws_price")
	private int wholeSalePrice;
	private String description;
	@Column(columnDefinition = "varchar(45) not null default 'noImage.png'")
	private String image;
	@ManyToOne
	private Category category;
	@OneToMany(mappedBy = "product")
	private List<SaleDetails> saleDetails;
	
	
	public Product(String name, int detailPrice,
			int wholeSalePrice, String description, String image,
			Category category) {
		super();
		this.name = name;
		this.detailPrice = detailPrice;
		this.wholeSalePrice = wholeSalePrice;
		this.description = description;
		this.image = image;
		this.category = category;
	}
	
}
