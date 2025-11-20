package com.ui.listeners;

import com.constants.Env;
import com.utility.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_RETRY_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Env.QA,"MAX_RETRY_ATTEMPTS"));
    //private static final int MAX_RETRY_ATTEMPTS = 3;
    private static int currentAttempt= 0;


    @Override
    public boolean retry(ITestResult iTestResult) {

        if(currentAttempt<MAX_RETRY_ATTEMPTS)
        {
            currentAttempt++;
            return true;
        }
        return false;
    }
}
