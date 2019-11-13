package com.productapp.utils;

import org.mockito.internal.matchers.LessThan;

import com.vladsch.flexmark.ast.Content;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;


public class ReusableSpecifications {
	public static RequestSpecBuilder rspec;
	public static ResponseSpecBuilder respec;

	public static RequestSpecification requestSpecification;
	public static ResponseSpecification responseSpecification;

	
	public static RequestSpecification getGenericRequestSpec(){
		rspec= new RequestSpecBuilder();
		rspec.setContentType(ContentType.JSON);
        requestSpecification=rspec.build();
        return requestSpecification;
	}
	
	
	public static ResponseSpecification getGenericResponseSpec()
	{
       respec=new ResponseSpecBuilder();
       respec.expectHeader("Content-Type", "application/json;charset=UTF-8");
       respec.expectHeader("Transfer-Encoding", "chunked");
       respec.expectResponseTime(lessThan(5L),TimeUnit.SECONDS);
       responseSpecification = respec.build();
       return responseSpecification;
   
	}

}
