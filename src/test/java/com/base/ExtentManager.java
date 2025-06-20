package com.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	 private static ExtentReports extent;

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            ExtentSparkReporter spark = new ExtentSparkReporter("reports/OrangeHRMLoginReport.html");
	            extent = new ExtentReports();
	            extent.attachReporter(spark);
	            extent.setSystemInfo("Tester", "Naveen");
	            extent.setSystemInfo("Environment", "QA");
	        }
	        return extent;
	    }
	    
	    public static void flushReports() {
	        if (extent != null) {
	            
	            extent.flush();
	        }
	    }

}
