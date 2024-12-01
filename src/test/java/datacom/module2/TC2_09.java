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

public class TC2_09 extends BrowserManager {
    private static final By DEFAULT_MAP_LOCATOR = By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]");
    private static final By SECOND_MAP_LOCATOR = By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[1]");

    @Test
    public void TC2_09_ASIA_COUNTRY_DROPDOWN_BEHAVIOR() throws InterruptedException, IOException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        MyElements.click(driver, By.xpath("//li[@data-tab-id='our-locations' and @role='anchor']"));
        DataCom.logs("The user clicked on the Our Locations Navigation menu");

        MyElements.click(driver, By.xpath("//li[@data-tab-section-id='.item2']"));
        DataCom.logsCapture(driver, className, "The user clicked on the Asia location mega menu");

        MyElements.click(driver, By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[1]"));
        DataCom.logs("The user clicked on the Philippines dropdown menu");

        String defaultOpenMap = getAttribute(driver, DEFAULT_MAP_LOCATOR, "class");
        String secondOpenMap = getAttribute(driver, SECOND_MAP_LOCATOR, "class");
        String secondOpenMapText = getText(driver, SECOND_MAP_LOCATOR);

        MyElements.wait(driver, "/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]");

        Assert.assertFalse(
                defaultOpenMap.contains("open"),
                "Expected the default map's class not contain 'open'. Actual: " + defaultOpenMap
        );

        DataCom.logsPassed("The user is able to see the Malaysia section is automatically collapse.");

        MyElements.wait(driver, "/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[1]");

        Assert.assertTrue(
                secondOpenMap.contains("open"),
                "Expected the default map's class contain 'open'. Actual: " + secondOpenMap
        );

        Assert.assertTrue(
                secondOpenMapText.contains("Philippines"),
                "Expected the default map text to contain 'Philippines'. Actual: " + secondOpenMapText
        );

        DataCom.logsPassed("The user is able to see the Philippines section is automatically expand.");

        MyElements.wait(driver, "/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[2]");


        String philippinesDetails = getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[2]"));
        DataCom.logs(philippinesDetails);
        Assert.assertTrue(philippinesDetails.contentEquals("Level 23F, IBM Plaza, 8 Eastwood Ave, Bagumbayan, Quezon City, 1110 Metro Manila, Philippines\n" +
                "Get directions\n" +
                "+63 2 717 6300\n" +
                "caracamille.cruz@datacom.com.au"));
        DataCom.logsPassed("The user is able to see Philippines Exact address, Phone number, and contact email details.");


        Log.endTest(className);

        // WebDriver Screenshot
        Screen.screenPass(driver, className);

    }

}
