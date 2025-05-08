package web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
// import org.testng.annotations.Test;

public class Create_trip extends File_upload {

	public static void Trip() throws InterruptedException {

		driver.findElement(By.xpath(Profile)).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(Logout)).click();
		driver.findElement(By.xpath(usernamefiledW)).sendKeys(Log_man_un);
		driver.findElement(By.xpath(passfieldW)).sendKeys(Log_man_pass);
		driver.findElement(By.xpath(signinw)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Log_request)).sendKeys(CRMTickets + Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath(Check_box)).click();
		driver.findElement(By.xpath(Update_confirmation)).click();
		Confirma = driver.findElement(By.xpath(Confirmation));
		js.executeScript("arguments[0].click();", Confirma);
		driver.findElement(By.xpath(Suggest_Pick)).click();
		driver.findElement(By.xpath(Date_pick)).click();
		driver.findElement(By.xpath(Confirm)).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(Check_box)).click();
		driver.findElement(By.xpath(Update_asign)).click();
		// driver.findElement(By.xpath(Log_par)).click();
		driver.findElement(By.xpath(Log_field)).sendKeys("Chetan_log1");
		driver.findElement(By.xpath(Par)).click();
		driver.findElement(By.xpath(Confirm)).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(Create_Trips)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Search_CT)).sendKeys(CRMTickets + Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(Check_box)).click();
		driver.findElement(By.xpath(Create_Trip)).click();
		Seq_num = driver.findElements(By.xpath(Sequence_num));
		System.out.println(Seq_num.size());
		for (i = 0; i < Seq_num.size(); i++) {
			Seq_num.get(i).sendKeys(String.valueOf(i + 1));
		}
		driver.findElement(By.xpath(Submit)).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(Track_trip)).click();

		// driver.findElement(By.xpath(Log_ex)).sendKeys("chetan");
		// driver.findElement(By.xpath(Exe)).click();
		// driver.findElement(By.xpath(Confirm)).click();
		Thread.sleep(1500);
		// driver.findElement(By.xpath(Check_box)).click();
		// seq = driver.findElements(By.xpath(Sequence));
		// System.out.println(seq.size());
		driver.findElement(By.xpath(CRM_tk)).click();
		CRM_tiket_n = driver.findElement(By.xpath(CRM_ticket));
		js.executeScript("arguments[0].click();", CRM_tiket_n);
		driver.findElement(By.xpath(Search_TP)).sendKeys(CRMTickets + Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath(Check_box)).click();
		driver.findElement(By.xpath(Update_exe)).click();
		driver.findElement(By.xpath(Executive)).sendKeys("Chetan_log_field4");
		driver.findElement(By.xpath(Exe)).click();
		driver.findElement(By.xpath(Asexe)).sendKeys("Chetan_log_field4");
		driver.findElement(By.xpath(Exe)).click();
		driver.findElement(By.xpath(Vehical)).sendKeys("KA09WB789");
		driver.findElement(By.xpath(Confirm)).click();
		Thread.sleep(2000);
		// FTA_app.Executive();
		// Successfull=driver.findElement(By.xpath(Sucessful));
		// System.out.println(Successfull.getText());
		//

	}
}
