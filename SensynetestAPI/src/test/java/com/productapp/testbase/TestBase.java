package com.productapp.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {
	
	@BeforeClass
	public static void init()
	{
		//RestAssured.baseURI="http://localhost:8080/student/";
		RestAssured.baseURI= "http://localhost:5000/v1/product";

	}

}
