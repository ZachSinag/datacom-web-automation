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

public class TC2_06 extends BrowserManager {
    private static final By DEFAULT_MAP_LOCATOR = By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[1]");

    @Test
    public void TC2_06_AUTRALIA_LOCATION() throws InterruptedException, IOException {

        String className = new Throwable().getStackTrace()[0].getMethodName();

        DataCom.testTitle(driver, className);

        MyElements.click(driver, By.xpath("//li[@data-tab-id='our-locations' and @role='anchor']"));
        DataCom.logs("The user clicked on the Our Locations Navigation menu");

        MyElements.click(driver, By.xpath("//li[@data-tab-section-id='.item1']"));
        DataCom.logsCapture(driver, className, "The user clicked on the Australia location mega menu");

        String defaultOpenMap = getAttribute(driver, DEFAULT_MAP_LOCATOR, "class");
        String defaultOpenMapText = getText(driver, DEFAULT_MAP_LOCATOR);

        MyElements.wait(driver, "/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[1]");

        Assert.assertTrue(
                defaultOpenMap.contains("open"),
                "Expected the default map's class to contain 'open'. Actual: " + defaultOpenMap
        );
        Assert.assertTrue(
                defaultOpenMapText.contains("Adelaide"),
                "Expected the default map text to contain 'Adelaide'. Actual: " + defaultOpenMapText
        );

        DataCom.logsPassed("The user is able to see Adelaide as the default open map.");

        MyElements.wait(driver, "/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[2]");

        String adelaideDetails = getText(driver, By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[2]"));
        Assert.assertTrue(adelaideDetails.contentEquals("118 Franklin Street, Adelaide, South Australia 5000\n" +
                "Get directions\n" +
                "+61 8 7221 7900\n" +
                "contactsa@datacom.com.au"));
        DataCom.logsPassed("The user is able to see Adelaide Exact address, Phone number, and contact email details.");


        Log.endTest(className);

        // WebDriver Screenshot
        Screen.screenPass(driver, className);

    }

}
