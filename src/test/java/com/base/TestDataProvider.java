package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider(name = "loginData")
    public Object[][] loginDataProvider() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);

        return new Object[][] {
            { prop.getProperty("user1.username"), prop.getProperty("user1.password") }
            //{ prop.getProperty("user2.username"), prop.getProperty("user2.password") }
        };
    }
	
	@DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginDataProvider() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);

        return new Object[][] {
           // { prop.getProperty("user1.username"), prop.getProperty("user1.password") }
            { prop.getProperty("user2.username"), prop.getProperty("user2.password") }
        };
    }

}
