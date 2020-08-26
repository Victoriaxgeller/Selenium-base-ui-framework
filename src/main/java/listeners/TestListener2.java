//package listeners;
//
//import lombok.extern.java.Log;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//
//public class TestListener extends TestListenerAdapter {
//    private Logger log = LoggerFactory.getLogger(TestListener.class);
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        System.out.println(("-----------------------Test started: " + result.getTestClass().getName() +
//                " Test:" + result.getName() + "---------------------------"));
//
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        System.out.println("-----------------------Test success: " + result.getTestClass().getName() +
//                " Test:" + result.getName() + "---------------------------");
//
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        System.out.println("-----------------------Test failure: " + result.getTestClass().getName() +
//                " Test:" + result.getName() + "---------------------------");
//
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        System.out.println("-----------------------Test skipped: " + result.getTestClass().getName() +
//                " Test:" + result.getName() + "---------------------------");
//
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        System.out.println("-----------------------Test onTestFailedButWithinSuccessPercentage: " + result.getTestClass().getName() +
//                " Test:" + result.getName() + "---------------------------");
//
//    }
//
//    @Override
//    public void onFinish(ITestContext result) {
//        System.out.println("-----------------------Test ON FINISH: " + result.getName() +
//                " Test:" + result.getName() + "---------------------------");
//
//    }
//}
