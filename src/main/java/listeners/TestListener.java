package listeners;

import browser.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import static org.testng.Reporter.log;

public class TestListener extends TestListenerAdapter {
    private Logger logger = LoggerFactory.getLogger(TestListener.class);
    Browser browser = new Browser();

    private static final String TEST_CLASS = "TEST CLASS: ",
            TEST_NAME = "TEST: ",
            DIVIDING_LINE = "___________________________________________________",
            BROWSER = "BROWSER: ",
            REASON = "REASON: ",
            BASE_URL = "BASE_URL: ";

    String browserVersion = "";

    @Override
    public void onTestStart(ITestResult result) {
        getBrowserVersion();
        System.out.println("Test started: " + result.getName() + "(" + result.getTestClass().getName() + ")");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(TEST_NAME + result.getName() + "(" + result.getTestClass().getName() + ")" + DIVIDING_LINE + "SUCCESS " + "\n" +
//                TEST_CLASS + result.getTestClass().getName() + "\n" +
                BROWSER + System.getProperty("browser") + " " + browserVersion + "\n" +
                BASE_URL + browser.getBaseUrl());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(TEST_NAME + result.getName() + "(" + result.getTestClass().getName() + ")" + DIVIDING_LINE + "FAILED " + "\n" +
//                TEST_CLASS + result.getTestClass().getName() + "\n" +
                REASON + result.getThrowable().getMessage() + "\n" +
                BROWSER + System.getProperty("browser") + " " + browserVersion + "\n" +
                BASE_URL + browser.getBaseUrl());
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(TEST_NAME + result.getName() + "(" + result.getTestClass().getName() + ")" + DIVIDING_LINE + "SKIPPED " + "\n" +
//                TEST_CLASS + result.getTestClass().getName() + "\n" +
                REASON + result.getThrowable().getMessage() + "\n" +
                BROWSER + System.getProperty("browser") + " " + browserVersion + "\n" +
                BASE_URL + browser.getBaseUrl());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        System.out.println(DIVIDING_LINE + "FINISHED");
    }

    private void getBrowserVersion() {
        try {
            browserVersion = System.getProperty("wdm.chromeDriverVersion");
        } catch (NullPointerException e) {
            System.out.println("Browser version is not pointed");
        }
    }
}