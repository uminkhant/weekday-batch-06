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
@NamedQuery(name = "getAllProduct",query = "select p from Product p where p.isDeleted= false")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(name="dt_price")
	private int detailPrice;
	private String description;
	@Column(columnDefinition = "varchar(45) not null default 'noImage.png'")
	private String image;
	@Column(columnDefinition = "tinyint(1) default '0'")
	private boolean isDeleted;
	@ManyToOne
	private Category category;
	@OneToMany(mappedBy = "product")
	private List<SaleDetails> saleDetails;
	
	
	public Product(String name, int detailPrice, String description, String image,
			Category category) {
		super();
		this.name = name;
		this.detailPrice = detailPrice;
		this.description = description;
		this.image = image;
		this.category = category;
	}
	
}
