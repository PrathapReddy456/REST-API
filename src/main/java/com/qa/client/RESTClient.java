package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RESTClient {

	// 1. GET Method

	public void get(String URL) throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault(); // it will create client connection
		// Abstartc class reference variable

		HttpGet httpget = new HttpGet(URL); // http GET request
		CloseableHttpResponse closable = httpClient.execute(httpget); // to pass request object(httpget) to hit the GET url
			
		
		// Status Code:										
		int statusCode = closable.getStatusLine().getStatusCode();

		System.out.println("Status Code:::: " + statusCode);
		
		// Json String

		String response = EntityUtils.toString(closable.getEntity(), "UTF-8"); // To get whole string entity

		JSONObject jObject = new JSONObject(response);

		System.out.println("Response JSON from API :: " + jObject);
		
		// All Headers

		Header[] headerarray = closable.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headerarray) {
			
			allHeaders.put(header.getName(), header.getValue());
		}
System.out.println("Headers Array ::"+allHeaders);
	}

}
