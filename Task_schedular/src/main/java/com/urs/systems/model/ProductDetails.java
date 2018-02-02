package com.urs.systems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ProductDetails")
public class ProductDetails {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
@JoinColumn(name = "product_category_id" )
private Integer product_type_id;
@JoinColumn(name = "attribute_id" )
private Integer attribute_id;
public Integer getId() {
 return id;
}
public void setId(Integer id) {
 this.id = id;
}
public Integer getProduct_type_id() {
 return product_type_id;
}
public void setProduct_type_id(Integer product_type_id) {
 this.product_type_id = product_type_id;
}
public Integer getAttribute_id() {
 return attribute_id;
}
public void setAttribute_id(Integer attribute_id) {
 this.attribute_id = attribute_id;
}
}