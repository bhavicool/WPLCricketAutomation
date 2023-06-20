package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetExpectedWPLData {

	public List<String> getExpectedWPLHSScores() {
		RestAssured.baseURI = "https://stg-wpl.sportz.io/cricket/live/json/5262_2_stats.json";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get(RestAssured.baseURI);
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

		System.out.println("Status Code is:" + response.getStatusCode());
		System.out.println("Response Header is:" + response.getHeader("Content-Type"));

		// Reading response of the API using JsonPath class

		JsonPath jsonPathEvaluator = response.jsonPath();

		List<String> expectedHSScores = new ArrayList<String>();
		expectedHSScores = jsonPathEvaluator.getList("leaderboard.highest_score");

		List<String> expectedHSScoresFor20Players = new ArrayList<String>();
		int count=0;
		for(String highestScore:expectedHSScores)
		{
			if(count==20)
				break;
			expectedHSScoresFor20Players.add(highestScore);
			count++;
		}

		return expectedHSScoresFor20Players;
	}
}
