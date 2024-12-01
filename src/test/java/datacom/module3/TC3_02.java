package datacom.module3;

import datacom.base.BrowserManager;
import datacom.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static datacom.utilities.MyElements.getText;

public class TC3_02 extends BrowserManager {
    Map<String, DataModel> dataMap;

    @Test
    public void TC3_02_CONTACT_US_ERROR_FIELD_VALIDATION() throws IOException, InterruptedException {

        dataMap = new DataReader().customerInput();
        DataModel Data = dataMap.get("submit_invalid");

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        DataCom.clickContact(driver);

        MyElements.click(driver, By.id("FirstName"));
        MyElements.click(driver, By.id("LastName"));
        String firstName_err = getText(driver, By.xpath("/html/body/div[5]/div/div/div/div/div/div[3]/div/form/div[2]"));
        Assert.assertTrue(firstName_err.contentEquals(Data.getForename_error_message()));
        DataCom.logs("The Error message for First Name field: " + Data.getForename_error_message());
        DataCom.logsPassed("The user validated that the first name error message is correct");

        MyElements.click(driver, By.id("Email"));
        String lastName_err = getText(driver, By.xpath("/html/body/div[5]/div/div/div/div/div/div[3]/div/form/div[4]"));
        Assert.assertTrue(lastName_err.contentEquals(Data.getLastname_error_message()));
        DataCom.logs("The Error message for Last Name field: " + Data.getLastname_error_message());
        DataCom.logsPassed("The user validated that the Last name error message is correct");

        MyElements.click(driver, By.id("Phone"));
        String email_err = getText(driver, By.xpath("/html/body/div[5]/div/div/div/div/div/div[3]/div/form/div[6]"));
        Assert.assertTrue(email_err.contentEquals(Data.getEmail_error_message()));
        DataCom.logs("The Error message for Business Email field: " + Data.getEmail_error_message());
        DataCom.logsPassed("The user validated that the Business Email error message is correct");

        MyElements.click(driver, By.id("Title"));
        MyElements.wait(driver, "/html/body/div[5]/div/div/div/div/div/div[3]/div/form/div[8]");
        String phone_err = getText(driver, By.xpath("/html/body/div[5]/div/div/div/div/div/div[3]/div/form/div[8]"));
        Assert.assertTrue(phone_err.contentEquals(Data.getNumber_error_message()));
        DataCom.logs("The Error message for Phone Number field: " + Data.getNumber_error_message());
        DataCom.logsPassed("The user validated that the Phone Number error message is correct");

        Thread.sleep(300);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(300);
        DataCom.logsCapture(driver, className, "User Scroll Down the page");

        MyElements.click(driver, By.id("Company"));
        MyElements.wait(driver, "/html/body/div[5]/div/div/div/div/div/div[3]/div/form/div[10]");
        String title_err = getText(driver, By.xpath("/html/body/div[5]/div/div/div/div/div/div[3]/div/form/div[10]"));
        Assert.assertTrue(title_err.contentEquals(Data.getJob_error_message()));
        DataCom.logs("The Error message for Job title field: " + Data.getJob_error_message());
        DataCom.logsPassed("The user validated that the Job title error message is correct");

        MyElements.click(driver, By.id("Country"));
        MyElements.wait(driver, "/html/body/div[5]/div/div/div/div/div/div[3]/div/form/div[11]");
        String company_err = getText(driver, By.xpath("/html/body/div[5]/div/div/div/div/div/div[3]/div/form/div[12]"));
        Assert.assertTrue(company_err.contentEquals(Data.getCompany_error_message()));
        DataCom.logs("The Error message for Company Name field: " + Data.getCompany_error_message());
        DataCom.logsPassed("The user validated that the Company Name error message is correct");

        MyElements.click(driver, By.id("Title"));
        Thread.sleep(100);
        MyElements.wait(driver, "//*[@id=\"mktoForm_1846\"]/div[14]");
        String country_err = getText(driver, By.xpath("//*[@id=\"mktoForm_1846\"]/div[14]"));
        Assert.assertTrue(country_err.contentEquals(Data.getDropdown_error_message()));
        DataCom.logs("The Error message for Country field: " + Data.getDropdown_error_message());
        DataCom.logsPassed("The user validated that the Country error message is correct");

        MyElements.click(driver, By.id("custom2"));
        Thread.sleep(100);
        MyElements.click(driver, By.id("Title"));
        MyElements.wait(driver, "/html/body/div[5]/div/div/div/div/div/div[3]/div/form/div[16]");
        String custom_err = getText(driver, By.xpath("//*[@id=\"mktoForm_1846\"]/div[17]"));
        Assert.assertTrue(custom_err.contentEquals(Data.getDropdown_error_message()));
        DataCom.logs("The Error message for How can we help you? field: " + Data.getDropdown_error_message());
        DataCom.logsPassed("The user validated that the How can we help you? message is correct");

        Log.endTest(className);

        Screen.screenPass(driver, className);
    }


}
