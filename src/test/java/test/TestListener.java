package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("[START] Test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[PASS] Test: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[FAIL] Test: " + result.getName());
        System.out.println("Reason: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[SKIP] Test: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("==> Starting Test Suite: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("==> Finished Test Suite: " + context.getName());
    }
}