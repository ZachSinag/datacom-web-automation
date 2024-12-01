package datacom.module2;

import datacom.base.BrowserManager;
import datacom.utilities.DataCom;
import datacom.utilities.Log;
import datacom.utilities.MyElements;
import datacom.utilities.Screen;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static datacom.utilities.MyElements.getAttribute;
import static datacom.utilities.MyElements.getText;

public class TC2_05 extends BrowserManager {
    private static final By DEFAULT_MAP_LOCATOR = By.xpath("//*[@id='section-0']/div[1]");
    private static final By SECOND_MAP_LOCATOR = By.xpath("//*[@id=\"section-1\"]/div[1]");

    @Test
    public void TC2_05_NEW_ZEALAND_CITY_DROPDOWN_BEHAVIOR() throws InterruptedException, IOException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        MyElements.click(driver, By.xpath("//li[@data-tab-id='our-locations' and @role='anchor']"));
        DataCom.logs("The user clicked on the Our Locations Navigation menu");

        MyElements.click(driver, By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div[1]"));
        DataCom.logs("The user clicked on the Christchurch dropdown menu");

        String defaultOpenMap = getAttribute(driver, DEFAULT_MAP_LOCATOR, "class");
        String secondOpenMap = getAttribute(driver, SECOND_MAP_LOCATOR, "class");
        String secondOpenMapText = getText(driver, SECOND_MAP_LOCATOR);

        MyElements.wait(driver, "//*[@id='section-0']/div[1]");

        Assert.assertFalse(
                defaultOpenMap.contains("open"),
                "Expected the default map's class not contain 'open'. Actual: " + defaultOpenMap
        );

        DataCom.logsPassed("The user is able to see the Auckland section is automatically collapse.");

        MyElements.wait(driver, "//*[@id=\"section-1\"]/div[1]");

        Assert.assertTrue(
                secondOpenMap.contains("open"),
                "Expected the default map's class contain 'open'. Actual: " + secondOpenMap
        );

        Assert.assertTrue(
                secondOpenMapText.contains("Christchurch"),
                "Expected the default map text to contain 'Christchurch'. Actual: " + secondOpenMapText
        );

        DataCom.logsPassed("The user is able to see the Christchurch section is automatically expand.");

        MyElements.wait(driver, "/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div[2]");

        String christChurchDetails = getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div[2]"));
        Assert.assertTrue(christChurchDetails.contentEquals("67 Gloucester Street, Christchurch 8013\n" +
                "Get directions\n" +
                "+64 3 379 7775\n" +
                "reception.christchurch@datacom.co.nz"));
        DataCom.logsPassed("The user is able to see Christchurch Exact address, Phone number, and contact email details.");


        Log.endTest(className);

        // WebDriver Screenshot
        Screen.screenPass(driver, className);

    }

}
