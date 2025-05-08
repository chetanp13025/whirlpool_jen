package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Create_tripTest extends File_uploadtest {

    @Test(dependsOnMethods = "testFileUploadProcess") // Run this after file upload
    public void testCreateTripProcess() throws InterruptedException, IOException {
        File_uploadtest.testFileUploadProcess(); // Ensure file is uploaded
        Trip();
    }

    public static void Trip() throws InterruptedException {
        // Profile & Logout
        WebElement profileBtn = driver.findElement(By.xpath(Profile));
        Assert.assertNotNull(profileBtn, "❌ Profile button not found.");
        profileBtn.click();

        Thread.sleep(500);

        WebElement logoutBtn = driver.findElement(By.xpath(Logout));
        Assert.assertNotNull(logoutBtn, "❌ Logout button not found.");
        logoutBtn.click();

        // Login as Logistics Manager
        driver.findElement(By.xpath(usernamefiledW)).sendKeys(Log_man_un);
        driver.findElement(By.xpath(passfieldW)).sendKeys(Log_man_pass);
        driver.findElement(By.xpath(signinw)).click();

        Thread.sleep(3000);

        // Search CRM
        WebElement logRequest = driver.findElement(By.xpath(Log_request));
        Assert.assertNotNull(logRequest, "❌ Log request input not found.");
        logRequest.sendKeys(CRMTickets + Keys.ENTER);

        Thread.sleep(3000);

        WebElement checkBox = driver.findElement(By.xpath(Check_box));
        Assert.assertTrue(checkBox.isDisplayed(), "❌ Checkbox not visible for trip confirmation.");
        checkBox.click();

        driver.findElement(By.xpath(Update_confirmation)).click();

        Confirma = driver.findElement(By.xpath(Confirmation));
        Assert.assertTrue(Confirma.isDisplayed(), "❌ Confirmation button not found.");
        js.executeScript("arguments[0].click();", Confirma);

        driver.findElement(By.xpath(Suggest_Pick)).click();
        driver.findElement(By.xpath(Date_pick)).click();
        driver.findElement(By.xpath(Confirm)).click();

        Thread.sleep(500);

        driver.findElement(By.xpath(Check_box)).click();
        driver.findElement(By.xpath(Update_asign)).click();
        driver.findElement(By.xpath(Log_field)).sendKeys("Chetan_log1");
        driver.findElement(By.xpath(Par)).click();
        driver.findElement(By.xpath(Confirm)).click();

        Thread.sleep(500);

        WebElement createTripsBtn = driver.findElement(By.xpath(Create_Trips));
        Assert.assertNotNull(createTripsBtn, "❌ Create Trips button not found.");
        createTripsBtn.click();

        Thread.sleep(1000);

        driver.findElement(By.xpath(Search_CT)).sendKeys(CRMTickets + Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath(Check_box)).click();
        driver.findElement(By.xpath(Create_Trip)).click();

        Seq_num = driver.findElements(By.xpath(Sequence_num));
        Assert.assertFalse(Seq_num.isEmpty(), "❌ Sequence numbers not loaded for trip.");

        System.out.println("Trip item count: " + Seq_num.size());

        for (i = 0; i < Seq_num.size(); i++) {
            Seq_num.get(i).sendKeys(String.valueOf(i + 1));
        }

        driver.findElement(By.xpath(Submit)).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath(Track_trip)).click();
        Thread.sleep(1500);

        WebElement crmTicketBtn = driver.findElement(By.xpath(CRM_tk));
        Assert.assertNotNull(crmTicketBtn, "❌ CRM Ticket icon not found.");
        crmTicketBtn.click();

        CRM_tiket_n = driver.findElement(By.xpath(CRM_ticket));
        Assert.assertNotNull(CRM_tiket_n, "❌ CRM ticket detail not found.");
        js.executeScript("arguments[0].click();", CRM_tiket_n);

        driver.findElement(By.xpath(Search_TP)).sendKeys(CRMTickets + Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(By.xpath(Check_box)).click();
        driver.findElement(By.xpath(Update_exe)).click();

        WebElement executiveInput = driver.findElement(By.xpath(Executive));
        Assert.assertNotNull(executiveInput, "❌ Executive input field not found.");
        executiveInput.sendKeys("Chetan_log_field4");

        driver.findElement(By.xpath(Exe)).click();
        driver.findElement(By.xpath(Asexe)).sendKeys("Chetan_log_field4");
        driver.findElement(By.xpath(Exe)).click();
        driver.findElement(By.xpath(Vehical)).sendKeys("KA09WB789");

        WebElement confirmBtn = driver.findElement(By.xpath(Confirm));
        Assert.assertTrue(confirmBtn.isDisplayed(), "❌ Final confirm button not visible.");
        confirmBtn.click();

        Thread.sleep(2000);
        System.out.println("✅ Trip creation completed successfully.");
    }
}
