package com.base;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {
	@Override
	 public void onStart(ISuite suite) {
	        CustomExtentReporer.initExtentReports();
	    }

	    public void onFinish(ISuite suite) {
	        CustomExtentReporer.flushReports();
	    }

}
