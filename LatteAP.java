import java.io.IOException;
import java.util.Scanner;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/*
 * Arjun and Laeo's Latte Assignment
 */

public class LatteAP {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("What city would you like to get the information for?");
		System.out.println("If the city name is multiple words, please use the abbreviation (ie: New York City --> NYC)");
		String cityName = scan.nextLine();

		fetch(cityName);
	}//main


	public static LatteAP fetch(String cityName) {
		try {
			
			HttpResponse<JsonNode> d = Unirest.get("http://api.apixu.com/v1/current.json?key=26715c9ff059418b9cd171747172505&q=" + cityName)
			  .asJson();
			
			System.out.println("Country: " + d.getBody().getObject().getJSONObject("location").get("country"));
			System.out.println("Region: " + d.getBody().getObject().getJSONObject("location").get("region"));
			System.out.println("Current Temperature (f): " + d.getBody().getObject().getJSONObject("current").get("temp_f"));
			System.out.println("Current Wind (mph): " + d.getBody().getObject().getJSONObject("current").get("wind_mph"));
			System.out.println("Humidity: " + d.getBody().getObject().getJSONObject("current").get("humidity"));
			System.out.println("Condition: " + d.getBody().getObject().getJSONObject("current").getJSONObject("condition").get("text"));
			return null;

	
		}//catch
 catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}//fetch


}//public class LatteAP


