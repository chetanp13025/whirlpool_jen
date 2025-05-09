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

	@Test(dependsOnMethods = "testWriteOperation")
	public static void testFileUploadProcess() throws IOException, InterruptedException {
//		Over_write_filetest.Write(); // Prepopulate the file
		web(); // Run the UI automation
		Assert.assertTrue(success, "❌ File upload did not complete successfully.");
	}

	public static void web() throws IOException, InterruptedException {
		while (!success) {
			try {
				System.out.println(SRNs);
				Assert.assertFalse(SRNs.isEmpty(), "❌ SRNs list is empty. Data was not written properly.");

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(QA_URL);

				// Login
				WebElement userField = driver.findElement(By.xpath(usernamefiledW));
				WebElement passField = driver.findElement(By.xpath(passfieldW));
				WebElement signInBtn = driver.findElement(By.xpath(signinw));

				Assert.assertNotNull(userField, "❌ Username field not found.");
				Assert.assertNotNull(passField, "❌ Password field not found.");
				Assert.assertNotNull(signInBtn, "❌ Sign-in button not found.");

				userField.sendKeys(usernameW);
				passField.sendKeys(passwordW);
				signInBtn.click();

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
				Thread.sleep(18000);

				driver.navigate().refresh();

				sta = driver.findElement(By.xpath(File_status));
				Assert.assertNotNull(sta, "❌ File status element not found.");

				status = sta.getText();
				System.out.println("File status: " + status);

				Assert.assertNotNull(status, "❌ Status text is null.");
				Assert.assertFalse(status.isEmpty(), "❌ Status text is empty.");

				if (status.equalsIgnoreCase("Completed")) {
					success = true;
					Assert.assertTrue(success, "✅ File upload completed.");
					Create_tripTest.Trip();

				} else {
					System.out.println("❌ File upload status: " + status);
					tagLists.clear();
					Assert.fail("❌ File status is not 'Completed'. It is: " + status);
				}

			} finally {
				// Optional: Uncomment when you're ready to close browser after testing
				// driver.quit();
			}
		}
	}
}
