package listeners;

import browser.Browser;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.ITestContext;

public class TestListener extends TestListenerAdapter {

    private Browser browser = new Browser();

    private static final String TEST_NAME = "TEST: ",
            DIVIDING_LINE = "___________________________________________________",
            BROWSER = "BROWSER: ",
            REASON = "REASON: ",
            BASE_URL = "BASE_URL: ";

    private String browserVersion = "";

    @Override
    public void onTestStart(ITestResult result) {
        getBrowserVersion();
        System.out.println("Test started: " + result.getName() +
                "(" + result.getTestClass().getName() + ")");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(TEST_NAME + result.getName() + "(" + result.getTestClass().getName() + ")" +
                DIVIDING_LINE + "SUCCESS " + "\n" +
                BROWSER + System.getProperty("browser") + " " + browserVersion + "\n" +
                BASE_URL + browser.getBaseUrl());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(TEST_NAME + result.getName() + "(" + result.getTestClass().getName() + ")" +
                DIVIDING_LINE + "FAILED " + "\n" +
                REASON + result.getThrowable().getMessage() + "\n" +
                BROWSER + System.getProperty("browser") + " " + browserVersion + "\n" +
                BASE_URL + browser.getBaseUrl());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(TEST_NAME + result.getName() + "(" + result.getTestClass().getName() + ")" +
                DIVIDING_LINE + "SKIPPED " + "\n" +
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