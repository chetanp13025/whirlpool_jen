package test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class File_uploadtest extends Over_write_filetest {
    static WebDriver driver;
    static boolean success = false;
    static String filePath = ".\\csv_file\\Whirlpool_file.csv";
    static String absolutePath;
    static WebElement sta;
    static String status;
    static WebElement Uploadtickets;
    static WebElement CRM;
    static List<WebElement> seq;
    static List<WebElement> Seq_num;
    static int i = 1;
    static WebElement CRM_tiket_n;
    protected static JavascriptExecutor js;
    static WebElement Confirma;
    static WebElement Successfull;

    @Test // Mark this method as a TestNG test method
    public static void testFileUploadProcess() throws IOException, InterruptedException {
    	Over_write_filetest.Write();
        web(); // Call your existing web automation logic
        Assert.assertTrue(success, "File upload did not complete successfully.");
    }

    public static void web() throws IOException, InterruptedException {
        while (!success) {
            try {
                System.out.println(SRNs); // Assuming SRNs is populated in Over_write_filetest
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                driver.get(QA_URL);
                driver.findElement(By.xpath(usernamefiledW)).sendKeys(usernameW);
                driver.findElement(By.xpath(passfieldW)).sendKeys(passwordW);
                driver.findElement(By.xpath(signinw)).click();
                Thread.sleep(1000);

                Uploadtickets = driver.findElement(By.xpath(UploadT));
                js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", Uploadtickets);
                driver.findElement(By.xpath(Upload)).click();
                driver.findElement(By.xpath(Select_file)).click();
                absolutePath = System.getProperty("user.dir") + "\\" + filePath;
                Runtime.getRuntime().exec("C://autoitfiles/fileupload.exe" + " " + absolutePath);
                Thread.sleep(3000);
                driver.findElement(By.xpath(Confirm)).click();
                Thread.sleep(15000);
                driver.navigate().refresh();

                sta = driver.findElement(By.xpath(File_status));
                status = sta.getText();
                if (status.equals("Completed")) {
                    System.out.println(status);
                    success = true;
                    // Create_trip.Trip();
                } else {
                    System.out.println(status);
                    tagLists.clear();
                }
            } finally {
                // driver.quit(); // Consider when you want to quit the driver
            }
        }
    }
}