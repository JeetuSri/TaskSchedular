package com.urs.systems.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ProductType")
public class ProductType {
 
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer product_type_id;
private String product_type;
@JoinColumn(name = "product_category_id" )
private Integer product_category_id;

@OneToMany(fetch=FetchType.EAGER, targetEntity=ProductDetails.class,cascade=CascadeType.ALL)
@JoinColumn(name = "product_type_id", referencedColumnName="product_type_id")
private List<ProductDetails> productDetails;

public Integer getProduct_type_id() {
	return product_type_id;
}

public void setProduct_type_id(Integer product_type_id) {
	this.product_type_id = product_type_id;
}

public String getProduct_type() {
	return product_type;
}

public void setProduct_type(String product_type) {
	this.product_type = product_type;
}

public Integer getProduct_category_id() {
	return product_category_id;
}

public void setProduct_category_id(Integer product_category_id) {
	this.product_category_id = product_category_id;
}

public List<ProductDetails> getProductDetails() {
	return productDetails;
}

public void setProductDetails(List<ProductDetails> productDetails) {
	this.productDetails = productDetails;
}


}