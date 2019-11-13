package com.productapp.cucumber.serenity;

import java.util.HashMap;

import com.productapp.model.ProductClass;
import com.productapp.utils.ReusableSpecifications;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ProductSerenitySteps {
	
	@Step("Creating the product using Name:{0},Price:{1} On sucess the status code should be 201")
	public ValidatableResponse createProduct
	                    (String name,
	                    double price
	                    ) {
		
		ProductClass product = new ProductClass();
		product.setName(name);
		product.setPrice(price);
		
		return SerenityRest.rest().given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
	    .when()
		.body(product)
		.post()
		.then();

	}
	
	@Step("Creating the product using Name:{0},Price:{1} On sucess the status code should be 201")
	public ValidatableResponse createProduct1
	                    (String name,
	                    double price
	                    ) {
		
		ProductClass product = new ProductClass();
		product.setName(name);
		product.setPrice(price);
		
		return SerenityRest.rest().given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
	    .when()
		.body(product)
		.post()
		.then();

	}
	
	@Step("Getting the student information with first name:{0}")
	public HashMap<String,Object> getProductInfoByname(String name)
	{
		String val1="findAll{it.name=='";
		String val2="'}.get(0)";
		System.out.println("<-----product name--->+"+val1+name+val2);
		
		return SerenityRest.rest().given()
		.when()
		.get("http://localhost:5000/v1/products")
		.then()
		.statusCode(200)
		.extract()
		.path(val1+name+val2);
		//.path(firstName);

	}

	
	@Step("Getting the student information with first name:{0}")
	public HashMap<String,Object> getStudentInfoByFirstName(String firstName)
	{
		String val1="findAll{it.firstName=='";
		String val2="'}.get(0)";
		System.out.println("<-----getStudentInfoByFirstName--->+"+val1+firstName+val2);
		
		return SerenityRest.rest().given()
		.when()
		.get("/list")
		.then()
		.statusCode(200)
		.extract()
		.path(val1+firstName+val2);

	}
	
	
	@Step("Updating the productname information using productid : {0} ,product name:{1}")
	public ValidatableResponse updateProductName
	                    (
	                    int productId,		
	                     String name
	                    ) {
		
		ProductClass product = new ProductClass();
		product.setName(name);
		return SerenityRest.rest().given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
	    .when()
		.body(product)
		.put("/" +productId)
		.then()
		.statusCode(204);


	}


	
	@Step("Deleting the product information  with ID :{0}")
	public void deleteProduct(int productId){
		SerenityRest.rest().given().when().delete("/"+productId);
	}
			
	
	@Step("Getting the the product information  with ID :{0}")
	public ValidatableResponse getProductByID(int productId)
	{
	return SerenityRest.rest().given().when().get("/" +productId).then();
}
	
	@Step("Deleting the student information  with ID :{0}")
	public void deleteStudent(int StudentId){
		SerenityRest.rest().given().when().delete("/"+StudentId);
	}
			
	
	@Step("Getting the the student information  with ID :{0}")
	public ValidatableResponse getStudentByID(int studentId)
	{
	return SerenityRest.rest().given().when().get("/" +studentId).then();
}


}
