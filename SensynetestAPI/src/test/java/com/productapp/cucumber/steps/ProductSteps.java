package com.productapp.cucumber.steps;

import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class ProductSteps {
	
	@When("^user sends the get request to the list end point,they must get back a valid staus code 200$")	
	public void verifystatusCode200forlistendpoint()
	{
		SerenityRest.rest()
		.given()
		.when()
		.get("/list")
		.then()
		.statusLine("200");	
	}

}
