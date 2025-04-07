package test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class File_upload extends Over_write_file{
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

	@Test
	public static void web() throws IOException, InterruptedException {
		while (!success) {
			try {
//				Over_write_file.Write();
//				 Properties_wl.pro();
				// System.out.println(CRMticket);
				System.out.println(SRNs);
				// System.out.println(IRRDs);
				// System.out.println(IRDs);
				// System.out.println(tagLists);
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(QA_URL);
				driver.findElement(By.xpath(usernamefiledW)).sendKeys(usernameW);
				driver.findElement(By.xpath(passfieldW)).sendKeys(passwordW);
				driver.findElement(By.xpath(signinw)).click();
				Thread.sleep(1000);
				// WebElement uploadBtn = driver.findElement(By.xpath(UploadT));
				// JavascriptExecutor js = (JavascriptExecutor) driver;
				// js.executeScript("arguments[0].click();", uploadBtn);

				// driver.findElement(By.xpath(Side)).click();
				// Thread.sleep(1000);
				// driver.findElement(By.xpath(Return)).click();
				// Thread.sleep(3000);
				Uploadtickets = driver.findElement(By.xpath(UploadT));
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", Uploadtickets);
				driver.findElement(By.xpath(Upload)).click();
				// driver.findElement(By.xpath("Create_PRD")).click();
				// driver.findElement(By.xpath("Upload")).click();
				driver.findElement(By.xpath(Select_file)).click();
				absolutePath = System.getProperty("user.dir") + "\\" + filePath;
				Runtime.getRuntime().exec("C://autoitfiles/fileupload.exe" + " " + absolutePath);
				Thread.sleep(3000);
				driver.findElement(By.xpath(Confirm)).click();
				Thread.sleep(15000);
				driver.navigate().refresh();
				// Thread.sleep(15000);
				// driver.navigate().refresh();
				// Thread.sleep(1000);
				sta = driver.findElement(By.xpath(File_status));
				status = sta.getText();
				if (status.equals("Completed")) {
					System.out.println(status);
					success = true;
//					Create_trip.Trip();
					// } else if (status.equals("Import Started")) {
					// Thread.sleep(3000);
					// driver.navigate().refresh();
					// if (status.equals("Completed")) {
					// System.out.println(status);
					// success = true;
					// }
				} else {
					System.out.println(status);
					tagLists.clear();
					// System.out.println(tagLists);
				}
				// } catch (Exception e) {
				// e.printStackTrace(); // Print the exception for debugging purposes
			} finally {
				// driver.quit();
			}
		}
	}

//	public static String getCurrentTime() {
//		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
//		Date now = new Date();
//		return sdf.format(now);
//	}
}
