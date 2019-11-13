package com.productapp.junit.productinfo;


import java.util.HashMap;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.productapp.cucumber.serenity.ProductSerenitySteps;
import com.productapp.testbase.TestBase;
import com.productapp.utils.ReusableSpecifications;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;



@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductsCRUDTest extends TestBase {

	static String name = "Fridge";
	static double price = 12.00;
	static int productId;
	
	@Steps
	ProductSerenitySteps steps;
	@Title("Create a new product with name and price returns 200 status code instead of 201 which is a defect")
	@Test
	public void test001(){
		steps.createProduct1(name,price)
		.statusCode(201)
		.spec(ReusableSpecifications.getGenericResponseSpec());
	}
	

	@Title("Create a new product with name and zero price which is a defect! ")
	@Test
	public void test002(){
		steps.createProduct(name,0.0)
		.statusCode(201)
		.spec(ReusableSpecifications.getGenericResponseSpec());
	}
	
	@Title("Create a new product without name and some price which is a defect!")
	@Test
	public void test003(){
		steps.createProduct("",price)
		.statusCode(201)
		.spec(ReusableSpecifications.getGenericResponseSpec());
	}
	
	@Title("Product creates again with with same name and price  which is a defect")
	@Test
	public void test004(){
		steps.createProduct1(name,price)
		.statusCode(201)
		.spec(ReusableSpecifications.getGenericResponseSpec());
	}
	
	@Title("Verify if the product was added to the application")
	@Test
	public void test005(){
		
	HashMap<String,Object> value =	steps.getProductInfoByname(name);	
	assertThat(value,hasValue(name));
	productId = (int) value.get("id");
	System.out.println("<=====productId=====>" +productId);
		
	}
	
	@Title("Update the product name and verify the updated information,Expected status code 204 but was 200 which is a defect!")
	@Test
	public void test006(){
		
		
		name = name+"_Updated";
		steps.updateProductName(productId,name);
		HashMap<String,Object> value = steps.getProductInfoByname(name);
		assertThat(value,hasValue(name));
	}
	
	@Title("Delete the student and verify if the student is deleted!")
	@Test
	public void test007(){
		steps.deleteStudent(productId);
		steps.getStudentByID(productId).statusCode(404);
	}

}

