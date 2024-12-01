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

public class TC2_07 extends BrowserManager {
    private static final By DEFAULT_MAP_LOCATOR = By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[1]");
    private static final By SECOND_MAP_LOCATOR = By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[1]");

    @Test
    public void TC2_07_AUTRALIA_CITY_DROPDOWN_BEHAVIOR() throws InterruptedException, IOException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        MyElements.click(driver, By.xpath("//li[@data-tab-id='our-locations' and @role='anchor']"));
        DataCom.logs("The user clicked on the Our Locations Navigation menu");

        MyElements.click(driver, By.xpath("//li[@data-tab-section-id='.item1']"));
        DataCom.logsCapture(driver, className, "The user clicked on the Australia location mega menu");

        MyElements.click(driver, By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[1]"));
        DataCom.logs("The user clicked on the Brisbane dropdown menu");

        String defaultOpenMap = getAttribute(driver, DEFAULT_MAP_LOCATOR, "class");
        String secondOpenMap = getAttribute(driver, SECOND_MAP_LOCATOR, "class");
        String secondOpenMapText = getText(driver, SECOND_MAP_LOCATOR);

        MyElements.wait(driver, "/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[1]");

        Assert.assertFalse(
                defaultOpenMap.contains("open"),
                "Expected the default map's class not contain 'open'. Actual: " + defaultOpenMap
        );

        DataCom.logsPassed("The user is able to see the Adelaide section is automatically collapse.");

        MyElements.wait(driver, "/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[1]");

        Assert.assertTrue(
                secondOpenMap.contains("open"),
                "Expected the default map's class contain 'open'. Actual: " + secondOpenMap
        );

        Assert.assertTrue(
                secondOpenMapText.contains("Brisbane"),
                "Expected the default map text to contain 'Brisbane'. Actual: " + secondOpenMapText
        );

        DataCom.logsPassed("The user is able to see the Brisbane section is automatically expand.");

        MyElements.wait(driver, "/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]");

        String brisbaneDetails = getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]"));
        Assert.assertTrue(brisbaneDetails.contentEquals("501 Ann Street, Fortitude Valley, Brisbane, Queensland 4006\n" +
                "Get directions\n" +
                "+61 7 3842 8888\n" +
                "qldsales@datacom.com.au"));
        DataCom.logsPassed("The user is able to see Brisbane Exact address, Phone number, and contact email details.");


        Log.endTest(className);

        // WebDriver Screenshot
        Screen.screenPass(driver, className);

    }

}
