package com.base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomExtentReporer {
	 private static final Logger logger = LoggerFactory.getLogger(CustomExtentReporer.class);
	    private static ExtentReports extent;
	    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	    // Private constructor to prevent instantiation
	    private CustomExtentReporer() {}

	    // Initialize ExtentReports (called in @BeforeSuite)
	    public static synchronized ExtentReports initExtentReports() {
	        if (extent == null) {
	            logger.info("Initializing ExtentReports");
	            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-report.html");
	            sparkReporter.config().setDocumentTitle("Automation Test Report");
	            sparkReporter.config().setReportName("TestNG Test Suite");
	            extent = new ExtentReports();
	            extent.attachReporter(sparkReporter);
	        }
	        return extent;
	    }

	    // Get ExtentReports instance
	    public static synchronized ExtentReports getExtentReports() {
	        if (extent == null) {
	            logger.warn("ExtentReports not initialized. Initializing now.");
	            initExtentReports();
	        }
	        return extent;
	    }

	    // Create ExtentTest for a test method
	    public static ExtentTest createTest(String testName) {
	        ExtentTest test = getExtentReports().createTest(testName);
	        extentTest.set(test);
	        logger.info("Created ExtentTest for: {}", testName);
	        return test;
	    }

	    // Get thread-specific ExtentTest
	    public static ExtentTest getTest() {
	        ExtentTest test = extentTest.get();
	        if (test == null) {
	            logger.error("ExtentTest is null for thread: {}", Thread.currentThread().getId());
	        }
	        return test;
	    }

	    // Flush reports (called in @AfterSuite)
	    public static void flushReports() {
	        if (extent != null) {
	            logger.info("Flushing ExtentReports");
	            extent.flush();
	        }
	    }

	    // Clean up ThreadLocal (called in @AfterMethod)
	    public static void removeTest() {
	        extentTest.remove();
	    }
	

}
