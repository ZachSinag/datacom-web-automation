package datacom.module2;

import datacom.base.BrowserManager;
import datacom.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Map;

import static datacom.utilities.MyElements.*;

public class TC2_01 extends BrowserManager {

    @Test
    public void TC2_01_OUR_LOCATION_NAVIGATION_SECTIONS() throws InterruptedException, IOException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,4000)");
        DataCom.logsCapture(driver, className, "User Scroll Down the page until footer section");

        MyElements.click(driver, By.xpath("//li[@data-tab-id='our-locations' and @role='anchor']"));
        DataCom.logs("The user clicked on the Our Locations Navigation menu");

        String locationTitle = getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div[4]/div/div[1]"));
        Assert.assertTrue(locationTitle.contentEquals("Our locations"));
        DataCom.logsPassed("The user able to see the Our Locations Title");

        String locationBody = getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div[4]/div/div[2]/div"));
        Assert.assertTrue(locationBody.contentEquals("Contact one of our global offices or one of our teams to find out more about how we can help you, or to answer any query you may have."));
        DataCom.logsPassed("The user able to see the Our Locations body literature");

        Log.endTest(className);

        // WebDriver Screenshot
        Screen.screenPass(driver, className);

    }

}
