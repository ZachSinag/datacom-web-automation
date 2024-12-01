package datacom.module2;

import datacom.base.BrowserManager;
import datacom.utilities.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static datacom.utilities.MyElements.*;

public class TC2_08 extends BrowserManager {
    private static final By DEFAULT_MAP_LOCATOR = By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]");

    @Test
    public void TC2_08_ASIA_LOCATION() throws InterruptedException, IOException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        MyElements.click(driver, By.xpath("//li[@data-tab-id='our-locations' and @role='anchor']"));
        DataCom.logs("The user clicked on the Our Locations Navigation menu");

        MyElements.click(driver, By.xpath("//li[@data-tab-section-id='.item2']"));
        DataCom.logsCapture(driver, className, "The user clicked on the Asia location mega menu");

        String defaultOpenMap = getAttribute(driver, DEFAULT_MAP_LOCATOR, "class");
        String defaultOpenMapText = getText(driver, DEFAULT_MAP_LOCATOR);

        MyElements.wait(driver, "/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]");

        Assert.assertTrue(
                defaultOpenMap.contains("open"),
                "Expected the default map's class to contain 'open'. Actual: " + defaultOpenMap
        );
        Assert.assertTrue(
                defaultOpenMapText.contains("Malaysia"),
                "Expected the default map text to contain 'Malaysia'. Actual: " + defaultOpenMapText
        );

        DataCom.logsPassed("The user is able to see Malaysia as the default open map.");

        MyElements.wait(driver, "/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[2]");

        String malaysiaDetails = getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[2]"));
        Assert.assertTrue(malaysiaDetails.contentEquals("Level 3A, 1 Sentral, Jalan Rakyat, Kuala Lumpur Sentral, Kuala Lumpur 50470\n" +
                "Get directions\n" +
                "+60 3 2109 1000\n" +
                "info-kl@datacom.com.au"));
        DataCom.logsPassed("The user is able to see Malaysia Exact address, Phone number, and contact email details.");


        Log.endTest(className);

        // WebDriver Screenshot
        Screen.screenPass(driver, className);

    }

}
