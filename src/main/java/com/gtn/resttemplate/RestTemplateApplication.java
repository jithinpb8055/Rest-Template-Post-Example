package com.gtn.resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Simple Application to call a POST api using spring ret template
 * uri - API base url + end point
 * requestString - request data in json format
 * header - request headers
 */
@SpringBootApplication
public class RestTemplateApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestTemplateApplication.class, args);
		// Spring boot application has started.
		// Now we can call the REST API

		RestTemplate restTemplate = new RestTemplate();
		String uri = "<your api path>";
		// Example data
		// String requestString = "{\"username\":\"admin\",\"password\":\"password\"}";
 		String requestString = "<Request json>";

 		// Creating headers for the API call
		// Request data is in json format
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Creating request entity with request data and headers
		HttpEntity<String> requestEntity = new HttpEntity<>(requestString, headers);

		// Calling API and getting response.
		ResponseEntity<String> response = restTemplate.postForEntity(uri,
				requestEntity, String.class);

		// Here we are printing the response to console.
		System.out.println(response);
	}

}
