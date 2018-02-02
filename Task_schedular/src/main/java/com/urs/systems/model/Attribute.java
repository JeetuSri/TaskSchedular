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
@Table(name="Attribute")
public class Attribute {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Integer attribute_id;
 private String attribute;
 private String value;
 
 @OneToMany(fetch=FetchType.EAGER, targetEntity=ProductDetails.class,cascade=CascadeType.ALL)
 @JoinColumn(name = "attribute_id", referencedColumnName="attribute_id")
 private List<ProductDetails> productDetails;

public Integer getAttribute_id() {
	return attribute_id;
}

public void setAttribute_id(Integer attribute_id) {
	this.attribute_id = attribute_id;
}

public String getAttribute() {
	return attribute;
}

public void setAttribute(String attribute) {
	this.attribute = attribute;
}

public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}

public List<ProductDetails> getProductDetails() {
	return productDetails;
}

public void setProductDetails(List<ProductDetails> productDetails) {
	this.productDetails = productDetails;
}


}