package com.tillery.board.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.Select;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
@RequestMapping(path="/board")
public class BoardFetcherServices {

	public static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

	/**
	 * fetch entire contents of the board
	 * @return board contents as JSON, ex:  <br>
	 *   [{"text":"...", "entries":[{"name":"...","text" : "..."}]}]
	 */
	@RequestMapping(path="/fetch", method=RequestMethod.GET)
	public String fetchBoard() {

		AmazonDynamoDBClient client = new AmazonDynamoDBClient();
		client.setRegion(Region.getRegion(Regions.US_WEST_2));
		
		ScanRequest scan = new ScanRequest().withTableName("board");
		scan.setSelect(Select.ALL_ATTRIBUTES);

		JsonArray jsonArray = new JsonArray();		
		ScanResult result = client.scan(scan);
		do {
			result.getItems().forEach(entry -> {
				JsonObject jsonObject = new JsonObject();
				jsonObject.addProperty("text", entry.get("text").getS());
				jsonObject.addProperty("entries", entry.get("entries").getS());
				jsonArray.add(jsonObject);
			});
			result = client.scan(scan);
		} while (result.getLastEvaluatedKey() != null);
		return gson.toJson(jsonArray);

	}
}
