package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.client.RESTClient;

public class GetAPITest extends TestBase {

	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RESTClient restClient;

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

		restClient.get(url);

	}

}
