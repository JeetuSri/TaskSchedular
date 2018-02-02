package com.urs.systems.controller;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urs.systems.model.Attribute;
import com.urs.systems.model.Category;
import com.urs.systems.model.ProductDetails;
import com.urs.systems.model.ProductType;
import com.urs.systems.model.Status;
import com.urs.systems.service.AttributeService;
import com.urs.systems.service.CategoryServiceImp;
import com.urs.systems.service.ProDetailService;
import com.urs.systems.service.ProductTypeService;
import com.urs.systems.service.StatusService;
 
 
@RestController
public class MainController {
	
	@Autowired
	ProDetailService proDetailService;
	
	@Autowired
	AttributeService attributeService;
	
	@Autowired
	CategoryServiceImp catService;
	
	@Autowired
	ProductTypeService proTypeService;
	
	@Autowired
	StatusService statusService;
	
	

	     // --------------------Status-----------------------------\\
	
	@RequestMapping(value="/Status", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<Status>> getAllStatus(@RequestParam String applicableTo)
	{
		return new ResponseEntity<List<Status>>(statusService.getApplicableStatus(applicableTo),HttpStatus.OK);
	}
      	
	@RequestMapping(value="/AddStatus" , method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
    	public ResponseEntity<Void> AddStatus(@RequestBody Status Status)
	{
		statusService.save(Status);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	 @RequestMapping(value = "/updateStatus", method = RequestMethod.PUT)
	     public ResponseEntity<Void> updateStatus(@RequestBody Status Status)
	 {
	     if (statusService.updateStatus(Status))
	     {
	     return new ResponseEntity<Void>(HttpStatus.OK);
	     }
	     return new ResponseEntity<Void>(HttpStatus.CREATED);
	   }
	
	 @RequestMapping(value = "/deleteStatus", method = RequestMethod.DELETE)
	   public ResponseEntity<Void> deleteStatus(@RequestBody Status status)
	  {
		 System.out.println(status);
	     if (statusService.deleteStatus(status))
	     {
	      return new ResponseEntity<Void>(HttpStatus.OK);
	     }
	        return new ResponseEntity<Void>(HttpStatus.CREATED);
	   }
	
	 
	//	----------------------CategorieTable---------------------\\
	
	@RequestMapping(value = "/getallcategories/", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getallcategories() {
		return new ResponseEntity<List<Category>>(catService.getAllCategories(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addcategory/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addproduct(@RequestBody Category category) {
		catService.save(category);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
		
		 @RequestMapping(value = "/deletecat/", method = RequestMethod.DELETE)
		   public ResponseEntity<Void> deleteCategories(@RequestBody Category cat) {
		    
		     if (catService.deleteCategories(cat)) {
		      return new ResponseEntity<Void>(HttpStatus.OK);
		     }
		        return new ResponseEntity<Void>(HttpStatus.CREATED);
		   }
		 
		 @RequestMapping(value = "/uproducCategory/", method = RequestMethod.PUT)
		   public ResponseEntity<Void> updateCategory(@RequestBody Category cat) {
		     if (catService.updateCategories(cat)) {
		      return new ResponseEntity<Void>(HttpStatus.OK);
		     }
		        return new ResponseEntity<Void>(HttpStatus.CREATED);
		   }
		
		 
//		 -------------------ProductType------------------------------\\
		 

			@RequestMapping(value = "/addProductType/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Void> addproduct(@RequestBody ProductType ProductType) {
				proTypeService.save(ProductType);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		 
		 @RequestMapping(value = "/uproductProductType/", method = RequestMethod.PUT)
		   public ResponseEntity<Void> updateProductType(@RequestBody ProductType pro) {
		     if (proTypeService.updateProductType(pro)) {
		      return new ResponseEntity<Void>(HttpStatus.OK);
		     }
		        return new ResponseEntity<Void>(HttpStatus.CREATED);
		   }

			@RequestMapping(value = "/deletetype/", method = RequestMethod.DELETE)
			public ResponseEntity<Void> deleteProduct(@RequestBody ProductType prod) {
				System.out.println(">>>>>>>>"+prod.getProduct_type());
				 if (proTypeService.deleteProducttype(prod)) {
					 return new ResponseEntity<Void>(HttpStatus.OK);
				 }
			     return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
			@RequestMapping(value = "/allProduct/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<ProductType>> getAllProduct() {
				List<ProductType> t = new ArrayList<ProductType>();
				t = proTypeService.getProduct_type();
				System.out.println("controller..");
				return new ResponseEntity<List<ProductType>>(t, HttpStatus.OK);
			}
			
			
               //-------------------------Attribute-----------------------\\
			
			
			@RequestMapping(value = "/allAttribute/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<Attribute>> getAllAttribute() {
				List<Attribute> t = new ArrayList<Attribute>();
				t = attributeService.getAllAttribute();
				return new ResponseEntity<List<Attribute>>(t, HttpStatus.OK);
			}
			
			@RequestMapping(value = "/createAttribute/", method = RequestMethod.POST)
			public ResponseEntity<Void> createCategory(@RequestBody Attribute att) {
				attributeService.createAttributes(att);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
			
			@RequestMapping(value = "/uproducAttribute/", method = RequestMethod.PUT)
			public ResponseEntity<Void> updateAttriute(@RequestBody Attribute att) {
				if (attributeService.updateAttributes(att)) {
					return new ResponseEntity<Void>(HttpStatus.OK);
				}
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
			
			@RequestMapping(value = "/deleteattribute/", method = RequestMethod.DELETE)
			public ResponseEntity<Void> deleteAttribute(@RequestBody Attribute att) {

				if (attributeService.deleteAttributes(att)) {
					return new ResponseEntity<Void>(HttpStatus.OK);
				}
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
			
			
			
               //-------------------ProductDetails-----------------------\\
			
			@RequestMapping(value = "/allProductDetails/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<ProductDetails>> getAllProductDetails() {
				List<ProductDetails> t = new ArrayList<ProductDetails>();
				t = proDetailService.getAllProduct_Details();
				
				return new ResponseEntity<List<ProductDetails>>(t, HttpStatus.OK);
			}
			
			@RequestMapping(value = "/createProductDetails/", method = RequestMethod.POST)
			public ResponseEntity<Void> createCategory(@RequestBody ProductDetails prod){
				proDetailService.createProduct_Details(prod);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
			
			@RequestMapping(value = "/deleteProductDetails/", method = RequestMethod.DELETE)
			public ResponseEntity<Void> deleteCategories(@RequestBody ProductDetails prod) {
				if (proDetailService.deleteProduct_Details(prod)) {
					return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
				}
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}			
			
			@RequestMapping(value = "/uproducProductDetails/", method = RequestMethod.PUT)
			public ResponseEntity<Void> updateProductDetails(@RequestBody ProductDetails prod) {
				 if (proDetailService.updateProduct_Details(prod)) {
					 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
				 }
			   return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
			
}