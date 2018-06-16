package com.qa.JSONResponse;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.Base.TestBase;
import com.qa.client.RESTClient;

public class GetJSONResponse extends TestBase  {

		TestBase testBase;
		String serviceUrl;
		String apiUrl;
		String url;
		RESTClient restClient;
		CloseableHttpResponse closable;

		@BeforeMethod

		public void setUp() {
			testBase = new TestBase();
			serviceUrl = prop.getProperty("URL");
			apiUrl = prop.getProperty("ServiceURL");

			url = serviceUrl + apiUrl;

		}

		@Test

		public void getTest() throws ClientProtocolException, IOException {

			restClient = new RESTClient();
			//closable = restClient.get(url);

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


