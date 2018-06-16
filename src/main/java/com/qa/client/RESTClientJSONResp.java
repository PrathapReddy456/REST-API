package com.qa.client;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RESTClientJSONResp {
	// 1. GET Method

		public CloseableHttpResponse get(String URL) throws ClientProtocolException, IOException {

			CloseableHttpClient httpClient = HttpClients.createDefault(); // it will create client connection
			// Abstartc class reference variable

			HttpGet httpget = new HttpGet(URL); // http GET request
			CloseableHttpResponse closable = httpClient.execute(httpget); // to pass request object(httpget) to hit the GET url
				
			return closable;

}
}