package com.qa.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	

	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:/Users/RITHWIK/My_Work2/REST-API/src/main/java/com/qa/config/Config.properties");

			prop.load(fis);
		} catch (IOException e) {
			e.getMessage();
		}
	}

}
