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

import static datacom.utilities.MyElements.getAttribute;
import static datacom.utilities.MyElements.getText;

public class TC3_01 extends BrowserManager {

    @Test
    public void TC3_01_CONTACT_US_BUTTON_NAVIGATION_SECTION() throws IOException, InterruptedException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        DataCom.clickContact(driver);

        String contactTitle = getText(driver, By.xpath("/html/body/div[6]/div/div/div/div/div/div[1]/div"));
        Assert.assertTrue(contactTitle.contentEquals("Contact us"));
        DataCom.logsPassed("The user able to see the Contact Us title on the modal");

        String contactDescription = getText(driver, By.xpath("/html/body/div[6]/div/div/div/div/div/div[2]/div"));
        Assert.assertTrue(contactDescription.contentEquals("Do you have a question? Want to learn more about our products and solutions, the latest career opportunities, or our events? We're here to help. Get in touch with us."));
        DataCom.logsPassed("The user able to see the Contact Us description on the modal");

        Thread.sleep(300);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(300);
        DataCom.logs("User Scroll Down the page");

        String agreement = getText(driver, By.xpath("/html/body/div[6]/div/div/div/div/div/div[3]/div/form/div[31]"));
        Assert.assertTrue(agreement.contains("This site is protected by reCAPTCHA and the Google Privacy Policy and Terms of Service apply."));
        DataCom.logsPassed("The user able to see the Google Privacy Policy and Terms of Service on the modal");


        Log.endTest(className);

        Screen.screenPass(driver, className);
    }


}
