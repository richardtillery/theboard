package com.tillery.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

@SpringBootApplication
@RestController
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}
	
	@RequestMapping(path="health", method=RequestMethod.GET)
	public String health() {
		Gson gson = new GsonBuilder().create();
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("status", new JsonPrimitive("healthy"));
		return gson.toJson(jsonObject);
	}

}
