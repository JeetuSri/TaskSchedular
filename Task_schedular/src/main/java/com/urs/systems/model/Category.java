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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Category")
public class Category {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Integer product_category_id;
 private String product_category;
// private Set<ProductType> productType = new HashSet<ProductType>(0);
 
 @OneToMany( targetEntity=ProductType.class,cascade=CascadeType.ALL)
 @JoinColumn(name = "product_category_id", referencedColumnName="product_category_id")
 @LazyCollection(LazyCollectionOption.FALSE)
 private List<ProductType> productType;
 
 public List<ProductType> getProductType() {
  return productType;
 }
 
// @OneToMany(fetch = FetchType.LAZY, mappedBy = "Category")
// public Set<ProductType> getProductType() {
//  return this.productType;
// }
 
 public String getProduct_category() {
  return product_category;
 }
 public Integer getProduct_category_id() {
  return product_category_id;
 }

 public void setProduct_category_id(Integer product_category_id) {
  this.product_category_id = product_category_id;
 }

 public void setProductType(List<ProductType> productType) {
  this.productType = productType;
 }

 public void setProduct_category(String product_category) {
  this.product_category = product_category;
 }
}