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

public class TC2_04 extends BrowserManager {
    private static final By DEFAULT_MAP_LOCATOR = By.xpath("//*[@id='section-0']/div[1]");

    @Test
    public void TC2_04_NEW_ZEALAND_LOCATIONS() throws InterruptedException, IOException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        MyElements.click(driver, By.xpath("//li[@data-tab-id='our-locations' and @role='anchor']"));
        DataCom.logs("The user clicked on the Our Locations Navigation menu");

        MyElements.click(driver, By.xpath("//li[@data-tab-section-id='.item1']"));
        DataCom.logsCapture(driver, className, "The user clicked on the Australia location mega menu");

        MyElements.click(driver, By.xpath("//li[@data-tab-section-id='.item0']"));
        DataCom.logs("The user clicked back on the New Zealand location mega menu");


        MyElements.wait(driver, "//*[@id='section-0']/div[1]");

        String defaultOpenMap = getAttribute(driver, DEFAULT_MAP_LOCATOR, "class");
        String defaultOpenMapText = getText(driver, DEFAULT_MAP_LOCATOR);

        Assert.assertTrue(
                defaultOpenMap.contains("open"),
                "Expected the default map's class to contain 'open'. Actual: " + defaultOpenMap
        );
        Assert.assertTrue(
                defaultOpenMapText.contains("Auckland"),
                "Expected the default map text to contain 'Auckland'. Actual: " + defaultOpenMapText
        );

        DataCom.logsPassed("The user is able to see Auckland as the default open map.");

        MyElements.wait(driver, "/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div[2]");

        String aucklandDetails = getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div[2]"));
        Assert.assertTrue(aucklandDetails.contentEquals("58 Gaunt Street, Auckland CBD, Auckland 1010\n" +
                "Get directions\n" +
                "+64 9 303 1489\n" +
                "reception.gaunt@datacom.co.nz"));
        DataCom.logsPassed("The user is able to see Auckland Exact address, Phone number, and contact email details.");


        Log.endTest(className);

        // WebDriver Screenshot
        Screen.screenPass(driver, className);

    }

}
