package com.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;
//import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class BaseClass {
    protected WebDriver driver;
    protected Properties prop;
    protected ExtentTest test;
    private static final Logger log = LogManager.getLogger(BaseClass.class);



    @BeforeMethod(alwaysRun = true)
    public void setup(Method method, ITestContext context) {
        log.info("=== BeforeMethod Start: Method={}, Test={}, Suite={}, Groups={} ===",
                method.getName(), context.getCurrentXmlTest().getName(), 
                context.getSuite().getName(), Arrays.toString(context.getIncludedGroups()));

        // Initialize ExtentTest
        try {
            test = CustomExtentReporer.createTest(method.getName());
            if (test == null) {
                log.error("ExtentTest is null after creation for method: {}", method.getName());
                throw new RuntimeException("Failed to create ExtentTest");
            }
            log.info("Created ExtentTest for method: {}", method.getName());
        } catch (Exception e) {
            log.error("Failed to initialize ExtentTest: ", e);
            throw new RuntimeException("ExtentTest initialization failed", e);
        }

        // Load config.properties
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
            log.info("Loaded config.properties successfully: {}", prop);
        } catch (IOException e) {
            log.error("Failed to load config.properties: ", e);
            if (test != null) {
                test.fail("Failed to load config.properties: " + e.getMessage());
            }
            throw new RuntimeException("Configuration loading failed", e);
        }

        // Setup browser
        try {
            String browser = prop.getProperty("browser", "chrome").toLowerCase();
            log.info("Browser selected: {}", browser);
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    break;
                default:
                    log.error("Invalid browser: {}", browser);
                    if (test != null) {
                        test.fail("Invalid browser: " + browser);
                    }
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            log.info("WebDriver initialized successfully");
        } catch (Exception e) {
            log.error("Failed to initialize WebDriver: ", e);
            if (test != null) {
                test.fail("Failed to initialize WebDriver: " + e.getMessage());
            }
            throw new RuntimeException("WebDriver initialization failed", e);
        }

        // Launch application
        try {
            String url = prop.getProperty("url");
            if (url == null || url.isEmpty()) {
                log.error("URL is not specified in config.properties");
                if (test != null) {
                    test.fail("URL is not specified in config.properties");
                }
                throw new IllegalArgumentException("URL is not specified");
            }
            driver.get(url);
            log.info("Launched URL: {}", url);
            if (test != null) {
                test.info("Launched URL: " + url);
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            log.error("Failed to launch URL: ", e);
            if (test != null) {
                test.fail("Failed to launch URL: " + e.getMessage());
            }
            throw new RuntimeException("URL launch failed", e);
        }

        log.info("=== BeforeMethod End: {} ===", method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        log.info("=== AfterMethod Start: {} ===", result.getName());

        if (test == null) {
            log.error("ExtentTest is null in AfterMethod for test: {}", result.getName());
        } else {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.fail(result.getThrowable());
                log.error("Test case Failed: ", result.getThrowable());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("Test Passed!");
                log.info("Test passed!");
            }
        }

        if (driver != null) {
            try {
                Thread.sleep(2000);
                driver.quit();
                log.info("WebDriver closed");
            } catch (Exception e) {
                log.error("Failed to close WebDriver: ", e);
            }
        }

        log.info("Test End");
        CustomExtentReporer.removeTest();
        log.info("=== AfterMethod End: {} ===", result.getName());
    }


}