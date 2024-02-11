package com.cucumber.stepdefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cucumber.utils.CommonUtils;

public class API_StepDefinition {

	private Response response;
	private Map<String, Integer> categoryCount;

	@Given("User navigates to the Coinmap API")
	public void userNavigatesToTheCoinmapAPI() {

		response = RestAssured.get("https://coinmap.org/api/v1/venues/");

		if (response.getStatusCode() == 200) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Then("User verifies the count of venues categories")
	public void userVerifiesTheCountOfVenuesCategories() throws IOException {
		Assert.assertEquals(200, response.getStatusCode());
		JSONObject jsonResponse = new JSONObject(response.getBody().asString());
		JSONArray venuesArray = jsonResponse.getJSONArray("venues");
		categoryCount = new HashMap<>();
		for (int i = 0; i < venuesArray.length(); i++) {
			JSONObject venue = venuesArray.getJSONObject(i);
			String category = venue.getString("category");
			categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
		}
		CommonUtils.writer = new FileWriter(CommonUtils.path + "\\" + "category" + " Details_From_API" + ".txt", false);
		for (Entry<String, Integer> entry : categoryCount.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
			CommonUtils.writeTextToFile(CommonUtils.writer, entry.getKey() + " = " + entry.getValue());
		}
		CommonUtils.writer.close();
	}

	@Then("User gets the names and geo locations of venues in the {string} category")
	public void userGetsTheNamesAndGeoLocationsOfVenuesInTheCategory(String categoryName) throws IOException {
		Assert.assertEquals("food", categoryName);
		JSONArray venuesArray = new JSONObject(response.getBody().asString()).getJSONArray("venues");
		System.out.println();
		CommonUtils.writer = new FileWriter(CommonUtils.path + "\\" + categoryName + " Details_From_API" + ".txt",
				false);

		for (int i = 0; i < venuesArray.length(); i++) {
			JSONObject venue = venuesArray.getJSONObject(i);
			if (venue.getString("category").equals(categoryName)) {
				String name = venue.getString("name");
				String geolocation_degrees = venue.getString("geolocation_degrees");
				CommonUtils.writeTextToFile(CommonUtils.writer,
						"Name: " + name + ", Geolocation: " + geolocation_degrees);
				System.out.println("Name: " + name + ", Geolocation: " + geolocation_degrees);
			}
		}
		CommonUtils.writer.close();
	}

}